package org.example;
import java.util.Scanner;
public class RescueMission {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nameofuser = "Player";
    // konumlar belirlenmeden önce tanımlamak istedim
        int selectmenu = 0;
        boolean difficultyset = false;
        boolean gameisrunning = true;
        int sizeofarea = 0;
        int survivornumber = 0;
        int hazadrnumber = 0;
        int movementcost = 0;
        int rescuepoints = 0;
        int firstfuel = 0;
        int survivor1X = -1;
        int survivor1Y = -1;
        int survivor1Found = 0;
        int survivor2X = -1;
        int survivor2Y = -1;
        int survivor2Found = 0;
        int survivor3X = -1;
        int survivor3Y = -1;
        int survivor3Found = 0;
        int survivor4X = -1;
        int survivor4Y = -1;
        int survivor4Found = 0;
        int survivor5X = -1;
        int survivor5Y = -1;
        int survivor5Found = 0;
        int hazard1X = -1;
        int hazard1Y = -1;
        int hazard2X = -1;
        int hazard2Y = -1;
        int hazard3X = -1;
        int hazard3Y = -1;
        int hazard4X = -1;
        int hazard4Y = -1;
        int hazard5X = -1;
        int hazard5Y = -1;
        int hazard6X = -1;
        int hazard6Y = -1;
        int hazard7X = -1;
        int hazard7Y = -1;
        int hazard8X = -1;
        int hazard8Y = -1;
        int hazard9X = -1;
        int hazard9Y = -1;
        int hazard10X = -1;
        int hazard10Y = -1;
// while döngüsü icinde ana menüyü yazdım
        while (gameisrunning) {
            System.out.println("\n------ Welcome to Rescue Mission Game! ------");
            System.out.println("Please select an choice:");
            System.out.println("1) Change your name");
            System.out.println("2) Set game difficulty");
            System.out.println("3) Start game");
            System.out.println("4) Exit game");

            selectmenu = scanner.nextInt();
            scanner.nextLine();

            if(selectmenu != 1 && selectmenu != 2 && selectmenu != 3 && selectmenu != 4 ) {
                System.out.println("Invalid number. Please enter a number between 1 - 4.");
                scanner.nextLine();
                continue;
            }

            if (selectmenu == 1) {
                System.out.println("Please enter your user name:");
                nameofuser = scanner.nextLine();
                System.out.println("Name changed to: " + nameofuser);
            }
            else if (selectmenu == 2) {
                System.out.println("Please select the game difficulty:");
                System.out.println("E) Easy");
                System.out.println("M) Medium");
                System.out.println("H) Hard");

                char difficulty = scanner.nextLine().toUpperCase().charAt(0);
// zorluk secimlerine göre oyun alanı ve benzeri şeyler belirlendi
                if (difficulty == 'E') {
                    sizeofarea = 10;
                    survivornumber = 3;
                    hazadrnumber = 5;
                    movementcost = 2;
                    rescuepoints = 5;
                    firstfuel = 150;
                }
                else if (difficulty == 'M') {
                    sizeofarea = 15;
                    survivornumber = 4;
                    hazadrnumber = 8;
                    movementcost = 3;
                    rescuepoints = 10;
                    firstfuel = 120;
                }
                else if (difficulty == 'H') {
                    sizeofarea = 20;
                    survivornumber = 5;
                    hazadrnumber = 10;
                    movementcost = 5;
                    rescuepoints = 15;
                    firstfuel = 100;
                }
                else {
                    System.out.println("Invalid difficulty selected. Please try again. (Use E for Easy, M for Medium, H for Hard) ");
                    continue;
                }


                survivor1X = (int) (Math.random() * sizeofarea);
                survivor1Y = (int) (Math.random() * sizeofarea);
                // bu while kısımlarında do while kullanımıda yapabilirdim fakat while kullanarak konum belirlemeyi tercih ettim.
                while (survivor1X == 0 && survivor1Y == 0) {
                    survivor1X = (int) (Math.random() * sizeofarea);
                    survivor1Y = (int) (Math.random() * sizeofarea);
                }

                survivor2X = (int) (Math.random() * sizeofarea);

                survivor2Y = (int) (Math.random() * sizeofarea);
                while ((survivor2X == 0 && survivor2Y == 0) ||
                        (survivor2X == survivor1X && survivor2Y == survivor1Y)) {

                    survivor2X = (int) (Math.random() * sizeofarea);
                    survivor2Y = (int) (Math.random() * sizeofarea);
                }


                survivor3X = (int) (Math.random() * sizeofarea);

                survivor3Y = (int) (Math.random() * sizeofarea);
                while ((survivor3X == 0 && survivor3Y == 0) ||
                        (survivor3X == survivor1X && survivor3Y == survivor1Y) ||
                        (survivor3X == survivor2X && survivor3Y == survivor2Y)) {

                    survivor3X = (int) (Math.random() * sizeofarea);
                    survivor3Y = (int) (Math.random() * sizeofarea);
                }

                if (survivornumber > 3) {
                    survivor4X = (int) (Math.random() * sizeofarea);
                    survivor4Y = (int) (Math.random() * sizeofarea);

                    while ((survivor4X == 0 && survivor4Y == 0) ||
                            (survivor4X == survivor1X && survivor4Y == survivor1Y) ||
                            (survivor4X == survivor2X && survivor4Y == survivor2Y) ||
                            (survivor4X == survivor3X && survivor4Y == survivor3Y)) {

                        survivor4X = (int) (Math.random() * sizeofarea);
                        survivor4Y = (int) (Math.random() * sizeofarea);
                    }
                }

                if (survivornumber > 4) {

                    survivor5X = (int) (Math.random() * sizeofarea);
                    survivor5Y = (int) (Math.random() * sizeofarea);

                    while ((survivor5X == 0 && survivor5Y == 0) ||
                            (survivor5X == survivor1X && survivor5Y == survivor1Y) ||
                            (survivor5X == survivor2X && survivor2Y == survivor2Y) ||
                            (survivor5X == survivor3X && survivor3Y == survivor3Y) ||
                            (survivor5X == survivor4X && survivor4Y == survivor4Y)) {

                        survivor5X = (int) (Math.random() * sizeofarea);
                        survivor5Y = (int) (Math.random() * sizeofarea);
                    }
                }

            // zorlukla belirlenen hazard sayısına eşit olana kdr i artıcak ve alttaki switchte işimize yarıcak bu yüzden for loop kullandım
                for (int i = 1; i <= hazadrnumber; i++) {

                    int hazardX = (int) (Math.random() * sizeofarea);
                    int hazardY = (int) (Math.random() * sizeofarea);



                    boolean validPosition = false;


                    while (validPosition == false) {

                        validPosition = true;



                        if (hazardX == 0 && hazardY == 0) {

                            validPosition = false;
                        }

                        if ((hazardX == survivor1X && hazardY == survivor1Y) ||
                                (hazardX == survivor2X && hazardY == survivor2Y) ||
                                (hazardX == survivor3X && hazardY == survivor3Y) ||
                                (survivornumber > 3 && hazardX == survivor4X && hazardY == survivor4Y) ||
                                (survivornumber > 4 && hazardX == survivor5X && hazardY == survivor5Y)) {


                            validPosition = false;
                        }


                        if (!validPosition) {

                            hazardX = (int) (Math.random() * sizeofarea);

                            hazardY = (int) (Math.random() * sizeofarea);
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


                difficultyset = true;
               // oyundaki görevi ve yakıt benzeri şeyler tanımlandıktan sonra kullanıcıya bildirdim
                System.out.println("\nGame config:");
                System.out.println("Game area: " + sizeofarea + "x" + sizeofarea);
                System.out.println("Survivors to find: " + survivornumber);
                System.out.println("Hazards to avoid: " + hazadrnumber);
                System.out.println("Movement cost: " + movementcost + " liters of fuel");
                System.out.println("Rescue points: " + rescuepoints + " points per survivor");
                System.out.println("Initial fuel: " + firstfuel + " liters");
            }




            else if (selectmenu == 3) {
            // zorluk secilmeden oyun secilmeye calışırsa diye if kullandım
                if (difficultyset == false) {
                    System.out.println("Please set game difficulty first!!");

                    continue;
                } // alt satırda bulunan survivor ve hazard 0landı ve başlangıc konuumu belirlendi ve oyuna başlamak icin startTime ile başlangıc zamanı belirlendi
                int currentX = 0;
                int currentY = 0;
                int currentfuel = firstfuel;
                int totalmove = 0;
                int hazardsfound = 0;
                int survivorsfound = 0;

                int score = 0;
                long startTime   = System.currentTimeMillis();

                System.out.println("\nGame started, First position is : (" + currentX + "," + currentY + ")");
                System.out.println("Use W/A/S/D to move (W=to move Up, S=to move Down, A=to move Left, D=to move Right)");


                while (currentfuel > 0 && survivorsfound < survivornumber) {

                    System.out.println("\nCurrent position: (" + currentX + "," + currentY + ")");
                    System.out.println("Fuel remaining: " + currentfuel + " liters");
                    System.out.println("Survivors found: " + survivorsfound + "/" + survivornumber);
                    System.out.println("Score: " + score);
                    System.out.println("\nEnter move (W/A/S/D):");
                   // büyük harf veya kücük harf farketmesin diye .toUpperCase() kullandım
                    char move = scanner.nextLine().toUpperCase().charAt(0);


                    int newX = currentX;

                    int newY = currentY;
                  // hareket tuşlarının değiştirdigi x y eksen değerleri
                    if (move == 'W') {

                        newY = currentY + 1;
                    } else if (move == 'S') {

                        newY = currentY - 1;
                    } else if (move == 'A') {

                        newX = currentX - 1;
                    } else if (move == 'D') {

                        newX = currentX + 1;
                    } else {

                        System.out.println("Invalid key!! Use W/A/S/D to move (W=to move Up, S=to move Down, A=to move Left, D=to move Right).");

                        continue;
                    }
                    if (newX < 0 || newX >= sizeofarea || newY < 0 || newY >= sizeofarea) {

                        System.out.println("Invalid move!! You cannot move outside the game area.");

                        continue;
                    }

                    currentX = newX;

                    currentY = newY;

                    currentfuel -= movementcost;

                    totalmove++;

                    boolean survivorFound = false;

                   // survivor bulma kısmı
                    if (currentX == survivor1X && currentY == survivor1Y && survivor1Found == 0) {

                        score += rescuepoints;

                        survivorsfound++;

                        survivor1Found = 1;
                        survivorFound = true;
                    }
                    else if (currentX == survivor2X && currentY == survivor2Y && survivor2Found == 0) {

                        score += rescuepoints;

                        survivorsfound++;

                        survivor2Found = 1;
                        survivorFound = true;
                    }
                    else if (currentX == survivor3X && currentY == survivor3Y && survivor3Found == 0) {

                        score += rescuepoints;

                        survivorsfound++;

                        survivor3Found = 1;
                        survivorFound = true;
                    }
                    else if (survivornumber > 3 && currentX == survivor4X && currentY == survivor4Y && survivor4Found == 0) {

                        score += rescuepoints;

                        survivorsfound++;

                        survivor4Found = 1;
                        survivorFound = true;
                    }
                    else if (survivornumber > 4 && currentX == survivor5X && currentY == survivor5Y && survivor5Found == 0) {

                        score += rescuepoints;

                        survivorsfound++;
                        survivor5Found = 1;
                        survivorFound = true;
                    }
                    if (survivorFound) {
                        System.out.println("Survivor found!! +" + rescuepoints + " points");
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
                        hazardsfound++;
                     // rastgele hazard type belirlendi ve switchte farklı caselere farklı tipler yazıldı
                        int hazardType = (int) (Math.random() * 4);
                        int hazardCost = 0;

                     // her hazardın farklı bir fuel kaybettirme değeri olsun diye math.random kullandım
                        switch (hazardType) {
                            case 0:
                                hazardCost = (int) (Math.random()*(7)+2);
                                System.out.println("DANGER! Wild animal attacked!! -" + hazardCost + " liters of fuel");
                                break;
                            case 1:
                                hazardCost = (int) (Math.random() * (6) + 10);
                                System.out.println("DANGER! Blocked path ahead!! -" + hazardCost + " liters of fuel");
                                break;
                            case 2:
                                hazardCost = (int) (Math.random() * (4) + 2);
                                System.out.println("DANGER! Snowslip!! -" + hazardCost + " liters of fuel");
                                break;
                            case 3:
                                hazardCost = (int) (Math.random() * (5) + 5);
                                System.out.println("DANGER! Cold snap!! -" + hazardCost + " liters of fuel");
                                break;
                        }
                        currentfuel -= hazardCost;

                    }

                    if (currentfuel <= 0) {

                        System.out.println("\nYou Are Out of fuel! Mission finished!");
                        break;
                    }
                }

            // oynanan toplam süre hesaplatıldı
                long endTime = System.currentTimeMillis();
                int elapsedSeconds = (int)((endTime - startTime) / 1000);
                int minutes = elapsedSeconds / 60;
                int seconds = elapsedSeconds % 60;
               // oyun sonu ekranını yazdım ve oyun sonundaki bilgileri verdim
                System.out.println("\n************ GAME IS OVER ************");
                if (survivorsfound == survivornumber) {

                    System.out.println("CONGRATULATIONS " + nameofuser + "Mission Succesful !");


                    int bonuspoints = currentfuel / 10;

                    score += bonuspoints;

                    System.out.println("Bonus points for remaining fuels: +" + bonuspoints);
                } else {

                    System.out.println("Mission Failed! Better luck next time,Stay Determined " + nameofuser + "!");
                }
                System.out.println("\nFinal Stats:");
                System.out.println("Time taken while you played: " + minutes + " minutes " + seconds + " seconds");
                System.out.println("Total moves: " + totalmove);
                System.out.println("Fuel consumed: " + (firstfuel - currentfuel) + " liters");
                System.out.println("Survivors found: " + survivorsfound + "/" + survivornumber);
                System.out.println("Hazards encountered: " + hazardsfound);
                System.out.println("Final score is: " + score + " points");

                difficultyset = false;
                survivor1Found = 0;
                survivor2Found = 0;
                survivor3Found = 0;
                survivor4Found = 0;
                survivor5Found = 0;

                System.out.println("\nPress Enter to return to main menu.");
                scanner.nextLine();
            }
            else if (selectmenu == 4) {
                System.out.println("\nThanks for playing Rescue Mission");
                System.out.println("Goodbye " + nameofuser + " See you later!!!");

                gameisrunning = false;
            }
            else {
                System.out.println("Invalid number. Please select a number between 1 and 4.");

            }
        }
    }
}