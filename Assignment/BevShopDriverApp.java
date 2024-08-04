
import java.util.Scanner;

public class BevShopDriverApp {
    private BevShop bevShop;

    public BevShopDriverApp(BevShop bevShop) {
        this.bevShop = bevShop;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        double totalAmount = 0;

        // Print maximum limits and age requirements
        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());

        // Start the first order
        while (true) {
            System.out.println("Start please a new order:");
            System.out.println("Your Total Order for now is " + totalAmount);

            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (bevShop.isValidAge(age)) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
            } else {
                System.out.println("Your age is not appropriate for alcohol drink!!");
            }

            // Start a new order
            System.out.print("Enter the time of the order: ");
            int time = scanner.nextInt();

            System.out.print("Enter the day of the order (1 for MONDAY, 2 for TUESDAY, etc.): ");
            Day day = Day.values()[scanner.nextInt() - 1];
            scanner.nextLine();  // Consume newline

            bevShop.startNewOrder(time, day, name, age);
            Order currentOrder = bevShop.getCurrentOrder();

            // Add alcoholic beverages
            int alcoholCount = 0;
            while (alcoholCount < bevShop.getMaxOrderForAlcohol()) {
                System.out.print("Would you please add an alcohol drink (type 'yes' or 'no'): ");
                String addAlcohol = scanner.nextLine();

                if (addAlcohol.equalsIgnoreCase("yes")) {
                    System.out.print("Enter the beverage name: ");
                    String bevName = scanner.nextLine();
                    System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    bevShop.processAlcoholOrder(bevName, size);
                    alcoholCount++;
                    System.out.println("The current order of drinks is " + alcoholCount);
                    double orderTotal = currentOrder.calcOrderTotal();
                    System.out.println("The Total price on the Order is " + orderTotal);
                } else {
                    break;
                }
            }

            if (alcoholCount >= bevShop.getMaxOrderForAlcohol()) {
                System.out.println("You have reached the maximum number of alcoholic drinks for this order");
            }

            // Add other beverages
            while (true) {
                System.out.print("Would you like to add a COFFEE or SMOOTHIE to your order (type 'yes' or 'no'): ");
                String addBeverage = scanner.nextLine();

                if (addBeverage.equalsIgnoreCase("yes")) {
                    System.out.print("Enter the beverage type (COFFEE, SMOOTHIE): ");
                    String beverageType = scanner.nextLine().toUpperCase();

                    System.out.print("Enter the beverage name: ");
                    String bevName = scanner.nextLine();
                    System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    if (beverageType.equals("COFFEE")) {
                        System.out.print("Extra shot (true/false): ");
                        boolean extraShot = scanner.nextBoolean();
                        System.out.print("Extra syrup (true/false): ");
                        boolean extraSyrup = scanner.nextBoolean();
                        scanner.nextLine();  // Consume newline

                        bevShop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
                    } else if (beverageType.equals("SMOOTHIE")) {
                        System.out.print("Number of fruits: ");
                        int numOfFruits = scanner.nextInt();
                        System.out.print("Add protein (true/false): ");
                        boolean addProtein = scanner.nextBoolean();
                        scanner.nextLine();  // Consume newline

                        if (bevShop.isMaxFruit(numOfFruits)) {
                            System.out.println("You reached the maximum number of fruits");
                        } else {
                            bevShop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
                        }
                    }
                    double orderTotal = currentOrder.calcOrderTotal();
                    System.out.println("The Total Price on the Order: " + orderTotal);
                } else {
                    break;
                }
            }

            // Display order details
            System.out.println("Your current order details:");
            System.out.println(currentOrder);

            double orderTotal = currentOrder.calcOrderTotal();
            totalAmount += orderTotal;
            System.out.println("Total amount for all Orders: " + totalAmount);

            // Start a new order?
            System.out.print("Would you like to start a new order (type 'yes' or 'no'): ");
            String startNewOrder = scanner.nextLine();
            if (!startNewOrder.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Total amount for all Orders: " + totalAmount);
    }

    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        BevShopDriverApp app = new BevShopDriverApp(bevShop);
        app.run();
    }
}
