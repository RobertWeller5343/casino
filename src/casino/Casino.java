package casino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Casino {

    public static String folderDirectory;
    public static ArrayList<String> textitems = new ArrayList<>();
    public static int coinTotal = 100;
    public static String code = ("000000");

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("welcome");
            System.out.println("1- Slots");
            System.out.println("2- BlackJack ");
            System.out.println("3-horse racing");
            System.out.println("4- check balance");
            System.out.println("5-exit program");
            System.out.println("6-get existing coins");
            int userchoice = input.nextInt();
            switch (userchoice) {
                case 1:
                    slots();
                    break;
                case 2:
                    blackJack();

                    break;
                case 3:
                    horseRacing();
                    break;
                case 4:
                    System.out.println("you balance is" + coinTotal);

                    break;
                case 5:
                    getDir();
                    writeFile();
                    readFile();
                    System.exit(0);
                case 6:

                    getDir();
                    retrieve();
                    break;

            }
        }
    }

    public static void slots() {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int slotsDone = 0;
        System.out.println("welcome to slots if you get 3 rolls of the same number you get a payout of 1000 coins");
        while (slotsDone == 0) {
            System.out.println("would you like to spin the slots (costs 5 coins)");
            System.out.println("1-spin slots");
            System.out.println("2-leave");
            System.out.println("3-check coins");
            int userchoice = input.nextInt();
            switch (userchoice) {
                case 1:
                    if (coinTotal >= 5) {
                        coinTotal = coinTotal - 5;
                        int min = 1;
                        int max = 3;
                        int num1 = random.nextInt((max - min + 1)) + min;
                        int num2 = random.nextInt((max - min + 1)) + min;
                        int num3 = random.nextInt((max - min + 1)) + min;
                        System.out.println("[" + num1 + "]" + "[" + num2 + "]" + "[" + num3 + "]");
                        if (num1 == num2 && num3 == num1 && num2 == num3) {
                            System.out.println("congrats you win 500 coins");
                            coinTotal = coinTotal + 500;

                        } else {
                            System.out.println("sorry you dont win");
                        }
                    } else {
                        System.out.println("sorry you do not have enough coins");
                    }
                    break;
                case 2:
                    return;
                case 3:
                    System.out.println(coinTotal);
                    break;

            }

        }
    }

    public static void blackJack() {
        int min = 1;
        int max = 13;
        int aiMin = 18;
        int aiMax = 25;
        int stand = 0;
        int pulls = 0;
        int number = 0;
        int aiTotal = 0;
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int bjDone = 0;
        while (bjDone == 0) {
            System.out.println("welcome to Black Jack what would you like to do 1-play, 2-check balance 3-return to main menu");
            int userchoice = input.nextInt();
            switch (userchoice) {
                case 1:
                    System.out.println("how much would you like to bet");
                    int bet = input.nextInt();
                    if (bet <= coinTotal) {
                        number = random.nextInt((max - min + 1)) + min;
                        while (stand == 0) {
                            System.out.println("you number is " + number);
                            System.out.println("would you like to hit (h) or stand (s)");
                            String choice = input.nextLine();
                            if (choice.equalsIgnoreCase("h")) {
                                number = number + random.nextInt((max - min + 1)) + min;
                            }
                            if (choice.equalsIgnoreCase("s")) {
                                stand = 1;
                            }
                            if (number > 21) {
                                stand = 1;
                            }
                            if (number == 21) {
                                stand = 1;

                            }

                        }
                        aiTotal = aiTotal + random.nextInt((aiMax - aiMin + 1)) + aiMin;
                        if (aiTotal > 21) {
                            System.out.println("you win");
                            coinTotal = coinTotal + (bet * 2);
                            number = 0;
                        }
                        if (aiTotal > number && aiTotal < 22) {
                            System.out.println("you loose");
                            coinTotal = coinTotal - bet;
                            number = 0;
                        }
                        if (aiTotal < number && number < 22) {
                            System.out.println("you win");
                            coinTotal = coinTotal + (bet * 2);
                            number = 0;
                        }
                        if (number == aiTotal) {
                            System.out.println("you draw");
                        }
                    }
                    if (bet >= coinTotal) {
                        System.out.println("bet too high");

                    }
                    break;
                case 2:
                    System.out.println(coinTotal);
                    break;
                case 3:
                    return;
            }

        }

    }

    public static void horseRacing() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int number = 0;
        int max = 4;
        int min = 1;
        int horse = 0;
        int bet = 0;
        int done = 0;
        while (done == 0) {
            System.out.println("welcome to horse racing select what you want to do 1-bet on a horse, 2- check my balance, 3- return to menu");
            int userchoice = input.nextInt();
            switch (userchoice) {
                case 1:
                    number = random.nextInt((max - min + 1)) + min;
                    System.out.println("how much would you like to bet");
                    bet = input.nextInt();
                    if (bet <= coinTotal) {
                        System.out.println("what horse would you like to bet on 1- Crimson flower, 2-Verdant Wind 3-Silver Snow, 4-Azure Moon and 5-White Clouds ");
                        horse = input.nextInt();
                        if (horse == number) {
                            System.out.println("the horse you bet on has won");
                            coinTotal = coinTotal + (bet * 10);
                            break;
                        } else {
                            if (number == 1) {
                                System.out.println("the winner is Crimson Flower");
                            }
                            if (number == 2) {
                                System.out.println("the winner is Verdant Wind");
                            }
                            if (number == 3) {
                                System.out.println("the winner is Silver Snow");
                            }
                            if (number == 4) {
                                System.out.println("the winner is Azure Moon");
                            }
                            if (number == 5) {
                                System.out.println("the winner is White Clouds");
                            }
                            coinTotal = coinTotal - bet;
                        }
                    }
                    if (bet > coinTotal) {
                        System.out.println("bet too high");
                    }
                    break;
                case 2:
                    System.out.println("you have " + coinTotal + " coins");
                    break;
                case 3:
                    return;

            }
        }
    }

    public static void getDir() {
        folderDirectory = System.getProperty("user.dir") + "\\myText.txt";
    }

    public static void writeFile() {
        Random random = new Random();
        int min = 1000000;
        int max = 3000000;
        int userCode = random.nextInt((max - min) + 1) + min;;
        System.out.println("your code is " + userCode + " dont forget it!");
        String myStr = String.valueOf(userCode);
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println("");
            printToFile.print("--");
            printToFile.print(myStr);
            printToFile.print("--");
            printToFile.print(coinTotal);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }

    public static void readFile() {
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((inputLine = read.readLine()) != null) {
                System.out.println(inputLine);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public static void printItems() {
        for (int i = 0; i < textitems.size(); i++) {
            System.out.println(textitems.get(i));
        }
    }

    public static void retrieve() {
        Scanner input = new Scanner(System.in);
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            System.out.println("what was you code");
            code = input.nextLine();
            while ((inputLine = read.readLine()) != null) {
                //System.out.println(inputLine);
                //System.out.println(code);
                String[] parts = inputLine.split("--");
                //System.out.println(parts[1]);
                if (parts[1].equals(code)) {
                    int bal = Integer.parseInt(parts[2]);
                    coinTotal = bal;
                    return;
                }

            }
            read.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
