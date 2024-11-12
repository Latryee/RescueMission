package org.example;

import java.util.Scanner;
import java.util.Random;

public class RescueMission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        String playerName = "Player";
        int menuChoice = 0;
        boolean difficultySet = false;
        boolean isGameRunning = true;


        int gameAreaSize = 0;
        int numSurvivors = 0;
        int numHazards = 0;
        int movementCost = 0;
        int rescuePoints = 0;
        int initialFuel = 0;


        int survivor1X = -1, survivor1Y = -1, survivor1Found = 0;
        int survivor2X = -1, survivor2Y = -1, survivor2Found = 0;
        int survivor3X = -1, survivor3Y = -1, survivor3Found = 0;
        int survivor4X = -1, survivor4Y = -1, survivor4Found = 0;
        int survivor5X = -1, survivor5Y = -1, survivor5Found = 0;


        int hazard1X = -1, hazard1Y = -1;
        int hazard2X = -1, hazard2Y = -1;
        int hazard3X = -1, hazard3Y = -1;
        int hazard4X = -1, hazard4Y = -1;
        int hazard5X = -1, hazard5Y = -1;
        int hazard6X = -1, hazard6Y = -1;
        int hazard7X = -1, hazard7Y = -1;
        int hazard8X = -1, hazard8Y = -1;
        int hazard9X = -1, hazard9Y = -1;
        int hazard10X = -1, hazard10Y = -1;

        while (isGameRunning) {
            System.out.println("\n********* Welcome to Rescue Mission! *********");
            System.out.println("Please select an option:");
            System.out.println("1 - Change your name");
            System.out.println("2 - Set game difficulty");
            System.out.println("3 - Start game");
            System.out.println("4 - Exit game");

            try {
                menuChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
                continue;
            }

            if (menuChoice == 1) {
                System.out.println("Please enter your name:");
                playerName = scanner.nextLine();
                System.out.println("Name changed to: " + playerName);
            }
            else if (menuChoice == 2) {
                System.out.println("Please select the game difficulty:");
                System.out.println("E) Easy");
                System.out.println("M) Medium");
                System.out.println("H) Hard");

                char difficulty = scanner.nextLine().toUpperCase().charAt(0);

                if (difficulty == 'E') {
                    gameAreaSize = 10;
                    numSurvivors = 3;
                    numHazards = 5;
                    movementCost = 2;
                    rescuePoints = 5;
                    initialFuel = 150;
                }
                else if (difficulty == 'M') {
                    gameAreaSize = 15;
                    numSurvivors = 4;
                    numHazards = 8;
                    movementCost = 3;
                    rescuePoints = 10;
                    initialFuel = 120;
                }
                else if (difficulty == 'H') {
                    gameAreaSize = 20;
                    numSurvivors = 5;
                    numHazards = 10;
                    movementCost = 5;
                    rescuePoints = 15;
                    initialFuel = 100;
                }
                else {
                    System.out.println("Invalid difficulty selected. Please try again.");
                    continue;
                }


                survivor1X = random.nextInt(gameAreaSize);
                survivor1Y = random.nextInt(gameAreaSize);
                while (survivor1X == 0 && survivor1Y == 0) {
                    survivor1X = random.nextInt(gameAreaSize);
                    survivor1Y = random.nextInt(gameAreaSize);
                }

                survivor2X = random.nextInt(gameAreaSize);
                survivor2Y = random.nextInt(gameAreaSize);
                while ((survivor2X == 0 && survivor2Y == 0) ||
                        (survivor2X == survivor1X && survivor2Y == survivor1Y)) {
                    survivor2X = random.nextInt(gameAreaSize);
                    survivor2Y = random.nextInt(gameAreaSize);
                }

                survivor3X = random.nextInt(gameAreaSize);
                survivor3Y = random.nextInt(gameAreaSize);
                while ((survivor3X == 0 && survivor3Y == 0) ||
                        (survivor3X == survivor1X && survivor3Y == survivor1Y) ||
                        (survivor3X == survivor2X && survivor3Y == survivor2Y)) {
                    survivor3X = random.nextInt(gameAreaSize);
                    survivor3Y = random.nextInt(gameAreaSize);
                }

                if (numSurvivors > 3) {
                    survivor4X = random.nextInt(gameAreaSize);
                    survivor4Y = random.nextInt(gameAreaSize);
                    while ((survivor4X == 0 && survivor4Y == 0) ||
                            (survivor4X == survivor1X && survivor4Y == survivor1Y) ||
                            (survivor4X == survivor2X && survivor4Y == survivor2Y) ||
                            (survivor4X == survivor3X && survivor4Y == survivor3Y)) {
                        survivor4X = random.nextInt(gameAreaSize);
                        survivor4Y = random.nextInt(gameAreaSize);
                    }
                }

                if (numSurvivors > 4) {
                    survivor5X = random.nextInt(gameAreaSize);
                    survivor5Y = random.nextInt(gameAreaSize);
                    while ((survivor5X == 0 && survivor5Y == 0) ||
                            (survivor5X == survivor1X && survivor5Y == survivor1Y) ||
                            (survivor5X == survivor2X && survivor2Y == survivor2Y) ||
                            (survivor5X == survivor3X && survivor3Y == survivor3Y) ||
                            (survivor5X == survivor4X && survivor4Y == survivor4Y)) {
                        survivor5X = random.nextInt(gameAreaSize);
                        survivor5Y = random.nextInt(gameAreaSize);
                    }
                }


                for (int i = 1; i <= numHazards; i++) {
                    int hazardX = random.nextInt(gameAreaSize);
                    int hazardY = random.nextInt(gameAreaSize);


                    boolean validPosition = false;
                    while (!validPosition) {
                        validPosition = true;


                        if (hazardX == 0 && hazardY == 0) {
                            validPosition = false;
                        }

                        if ((hazardX == survivor1X && hazardY == survivor1Y) ||
                                (hazardX == survivor2X && hazardY == survivor2Y) ||
                                (hazardX == survivor3X && hazardY == survivor3Y) ||
                                (numSurvivors > 3 && hazardX == survivor4X && hazardY == survivor4Y) ||
                                (numSurvivors > 4 && hazardX == survivor5X && hazardY == survivor5Y)) {
                            validPosition = false;
                        }


                        if (!validPosition) {
                            hazardX = random.nextInt(gameAreaSize);
                            hazardY = random.nextInt(gameAreaSize);
                        }
                    }


                    switch (i) {
                        case 1: hazard1X = hazardX; hazard1Y = hazardY; break;
                        case 2: hazard2X = hazardX; hazard2Y = hazardY; break;
                        case 3: hazard3X = hazardX; hazard3Y = hazardY; break;
                        case 4: hazard4X = hazardX; hazard4Y = hazardY; break;
                        case 5: hazard5X = hazardX; hazard5Y = hazardY; break;
                        case 6: hazard6X = hazardX; hazard6Y = hazardY; break;
                        case 7: hazard7X = hazardX; hazard7Y = hazardY; break;
                        case 8: hazard8X = hazardX; hazard8Y = hazardY; break;
                        case 9: hazard9X = hazardX; hazard9Y = hazardY; break;
                        case 10: hazard10X = hazardX; hazard10Y = hazardY; break;
                    }
                }

                difficultySet = true;
                System.out.println("\nGame configuration:");
                System.out.println("Game area: " + gameAreaSize + "x" + gameAreaSize);
                System.out.println("Survivors to rescue: " + numSurvivors);
                System.out.println("Hazards to avoid: " + numHazards);
                System.out.println("Movement cost: " + movementCost + " liters of fuel");
                System.out.println("Rescue points: " + rescuePoints + " points per survivor");
                System.out.println("Initial fuel: " + initialFuel + " liters");
            }
            else if (menuChoice == 3) {
                if (!difficultySet) {
                    System.out.println("Please set game difficulty first!");
                    continue;
                }


                int currentX = 0;
                int currentY = 0;
                int currentFuel = initialFuel;
                int totalMoves = 0;
                int hazardsEncountered = 0;
                int survivorsRescued = 0;
                int score = 0;
                long startTime = System.currentTimeMillis();

                System.out.println("\nGame started! Initial position: (" + currentX + "," + currentY + ")");
                System.out.println("Use W/A/S/D to move (W=Up, S=Down, A=Left, D=Right)");

                while (currentFuel > 0 && survivorsRescued < numSurvivors) {
                    System.out.println("\nCurrent position: (" + currentX + "," + currentY + ")");
                    System.out.println("Fuel remaining: " + currentFuel + " liters");
                    System.out.println("Survivors rescued: " + survivorsRescued + "/" + numSurvivors);
                    System.out.println("Score: " + score);
                    System.out.println("\nEnter move (W/A/S/D):");

                    char move = scanner.nextLine().toUpperCase().charAt(0);

                    int newX = currentX;
                    int newY = currentY;

                    if (move == 'W') {
                        newY = currentY + 1;
                    } else if (move == 'S') {
                        newY = currentY - 1;
                    } else if (move == 'A') {
                        newX = currentX - 1;
                    } else if (move == 'D') {
                        newX = currentX + 1;
                    } else {
                        System.out.println("Invalid move! Use W/A/S/D.");
                        continue;
                    }

                    if (newX < 0 || newX >= gameAreaSize || newY < 0 || newY >= gameAreaSize) {
                        System.out.println("Invalid move! You cannot move outside the game area.");
                        continue;
                    }

                    currentX = newX;
                    currentY = newY;
                    currentFuel -= movementCost;
                    totalMoves++;


                    boolean survivorFound = false;
                    if (currentX == survivor1X && currentY == survivor1Y && survivor1Found == 0) {
                        score += rescuePoints;
                        survivorsRescued++;
                        survivor1Found = 1;
                        survivorFound = true;
                    }
                    else if (currentX == survivor2X && currentY == survivor2Y && survivor2Found == 0) {
                        score += rescuePoints;
                        survivorsRescued++;
                        survivor2Found = 1;
                        survivorFound = true;
                    }
                    else if (currentX == survivor3X && currentY == survivor3Y && survivor3Found == 0) {
                        score += rescuePoints;
                        survivorsRescued++;
                        survivor3Found = 1;
                        survivorFound = true;
                    }
                    else if (numSurvivors > 3 && currentX == survivor4X && currentY == survivor4Y && survivor4Found == 0) {
                        score += rescuePoints;
                        survivorsRescued++;
                        survivor4Found = 1;
                        survivorFound = true;
                    }
                    else if (numSurvivors > 4 && currentX == survivor5X && currentY == survivor5Y && survivor5Found == 0) {
                        score += rescuePoints;
                        survivorsRescued++;
                        survivor5Found = 1;
                        survivorFound = true;
                    }

                    if (survivorFound) {
                        System.out.println("Survivor found! +" + rescuePoints + " points");
                    }


                    boolean hazardFound = false;
                    if ((currentX == hazard1X && currentY == hazard1Y) ||
                            (currentX == hazard2X && currentY == hazard2Y) ||
                            (currentX == hazard3X && currentY == hazard3Y) ||
                            (currentX == hazard4X && currentY == hazard4Y) ||
                            (currentX == hazard5X && currentY == hazard5Y) ||
                            (currentX == hazard6X && currentY == hazard6Y) ||
                            (currentX == hazard7X && currentY == hazard7Y) ||
                            (currentX == hazard8X && currentY == hazard8Y) ||
                            (currentX == hazard9X && currentY == hazard9Y) ||
                            (currentX == hazard10X && currentY == hazard10Y)) {

                        hazardFound = true;

                        hazardsEncountered++;

                        int hazardType = random.nextInt(4);

                        int hazardCost = 0;


                        switch (hazardType) {
                            case 0:
                                hazardCost = random.nextInt(7) + 2;
                                System.out.println("DANGER! Wild animal encountered! -" + hazardCost + " liters of fuel");
                                break;
                            case 1:
                                hazardCost = random.nextInt(6) + 10;
                                System.out.println("DANGER! Blocked path ahead! -" + hazardCost + " liters of fuel");
                                break;
                            case 2:
                                hazardCost = random.nextInt(4) + 2;
                                System.out.println("DANGER! Snow drift! -" + hazardCost + " liters of fuel");
                                break;
                            case 3:
                                hazardCost = random.nextInt(5) + 5;
                                System.out.println("DANGER! Cold snap! -" + hazardCost + " liters of fuel");
                                break;
                        }

                        currentFuel -= hazardCost;
                    }


                    if (currentFuel <= 0) {
                        System.out.println("\nOut of fuel! Mission failed!");
                        break;
                    }
                }



                long endTime = System.currentTimeMillis();
                int elapsedSeconds = (int)((endTime - startTime) / 1000);
                int minutes = elapsedSeconds / 60;
                int seconds = elapsedSeconds % 60;


                System.out.println("\n************ GAME OVER ************");
                if (survivorsRescued == numSurvivors) {
                    System.out.println("CONGRATULATIONS " + playerName + "! Mission Accomplished!");

                    int bonusPoints = currentFuel / 10;
                    score += bonusPoints;
                    System.out.println("Bonus points for remaining fuel: +" + bonusPoints);
                } else {
                    System.out.println("Mission Failed! Better luck next time, " + playerName + "!");
                }

                System.out.println("\nFinal Statistics:");
                System.out.println("Time taken: " + minutes + " minutes " + seconds + " seconds");
                System.out.println("Total moves: " + totalMoves);
                System.out.println("Fuel consumed: " + (initialFuel - currentFuel) + " liters");
                System.out.println("Survivors rescued: " + survivorsRescued + "/" + numSurvivors);
                System.out.println("Hazards encountered: " + hazardsEncountered);
                System.out.println("Final score: " + score + " points");


                difficultySet = false;
                survivor1Found = 0;
                survivor2Found = 0;
                survivor3Found = 0;
                survivor4Found = 0;
                survivor5Found = 0;

                System.out.println("\nPress Enter to return to main menu...");
                scanner.nextLine();
            }
            else if (menuChoice == 4) {
                System.out.println("\nThanks for playing Rescue Mission!");
                System.out.println("Goodbye, " + playerName + "!");
                isGameRunning = false;
            }
            else {
                System.out.println("Invalid choice! Please select a number between 1 and 4.");
            }
        }



    }
}