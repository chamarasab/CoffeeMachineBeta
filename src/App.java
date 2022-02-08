import java.util.Scanner;

public class App {
    static int waterAmount = 400;
    static int milkAmount = 540;
    static int beansAmount = 120;
    static int cupsAmount = 9; // disposable cups loaded
    static int moneyAmount = 550;

    public static void main(String[] args) throws Exception {
        // checkMachineStatus();
        getAction();
    }

    private static void getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                System.out.println(
                        "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String drink = scanner.nextLine();

                switch (drink) {
                    case "1":
                        checkResourcesAvailability(1);
                        // reduceResources(250,0,16,1,4);
                        break;
                    case "2":
                        checkResourcesAvailability(2);
                        //reduceResources(350, 75, 20, 1, 7);
                        break;
                    case "3":
                        checkResourcesAvailability(3);
                        //reduceResources(200, 100, 12, 1, 6);
                        break;
                    case "back":
                        getAction();
                        break;
                    default:
                        break;
                }
                checkMachineStatus();
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                waterAmount += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                milkAmount += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                beansAmount += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                cupsAmount += scanner.nextInt();
                //checkMachineStatus();
                getAction();
                break;
            case "take":
                System.out.println("\nI gave you $" + moneyAmount);
                moneyAmount = 0;
                //checkMachineStatus();
                getAction();
                break;
            case "remaining":
                checkMachineStatus();
                break;
            case "exit":
                System.exit(0);
                break;
            default :
                break;
        }
        scanner.close();
    }

    private static void checkResourcesAvailability(int i) {
        boolean water = false;
        boolean milk = false;
        boolean beans = false;
        boolean cups = false;
        switch (i) {
            case 1: // espresso
                if (250 < waterAmount) {
                    water = true;
                }
                if (16 < beansAmount) {
                    beans = true;
                }
                if (1 < cupsAmount) {
                    cups = true;
                }
                if (water == true && beans == true && cups == true) {
                    System.out.println("I have enough resources, making you a coffee!");
                    reduceResources(250, 0, 16, 1, 4);
                } else if (water == false) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans == false) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups == false) {
                    System.out.println("Sorry, not enough cups!");
                }
                break;
            case 2: // latte
                if (350 < waterAmount) {
                    water = true;
                }
                if (75 < milkAmount) {
                    milk = true;
                }
                if (20 < beansAmount) {
                    beans = true;
                }
                if (1 < cupsAmount) {
                    cups = true;
                }
                if (water == true && milk == true && beans == true && cups == true) {
                    System.out.println("I have enough resources, making you a coffee!");
                    reduceResources(350, 75, 20, 1, 7);
                } else if (water == false) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk == false) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans == false) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups == false) {
                    System.out.println("Sorry, not enough cups!");
                }
                break;
            case 3: // cappuccino
                if (200 < waterAmount) {
                    water = true;
                }
                if (100 < milkAmount) {
                    milk = true;
                }
                if (12 < beansAmount) {
                    beans = true;
                }
                if (1 < cupsAmount) {
                    cups = true;
                }
                if (water == true && milk == true && beans == true && cups == true) {
                    System.out.println("I have enough resources, making you a coffee!");
                    reduceResources(200, 100, 12, 1, 6);
                } else if (water == false) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk == false) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans == false) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cups == false) {
                    System.out.println("Sorry, not enough cups!");
                }
                break;

            default:
                break;
        }
        getAction();
    }

    private static void reduceResources(int water, int milk, int beans, int cups, int money) {
        waterAmount -= water;
        milkAmount -= milk;
        beansAmount -= beans;
        cupsAmount -= cups;
        moneyAmount += money;
    }

    private static void checkMachineStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterAmount + " ml of water");
        System.out.println(milkAmount + " ml of milk");
        System.out.println(beansAmount + " g of coffee beans");
        System.out.println(cupsAmount + " disposable cups");
        System.out.println("$" + moneyAmount + " of money");
        getAction();
    }
}
