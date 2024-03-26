import java.util.Scanner;

public class Main {

    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Factorial");
        System.out.println("2. Sum");
        System.out.println("3. Exit");
        System.out.println("What would you like to do? (Enter one of options)");
    }

    private static void factorialChoice() {
        Scanner myObj = new Scanner((System.in));
        System.out.println("Enter value of factorial you want to calculate: ");
        int factorialN = myObj.nextInt();
        int result = Calculations.factorial(factorialN);
        System.out.println("Factorial of " + factorialN + " is equal: " + result);
    }

    private static void sumChoice() {
        Scanner myObj = new Scanner((System.in));
        System.out.println("Enter first value for sum.");
        int a = myObj.nextInt();
        System.out.println("Enter second value for sum.");
        int b = myObj.nextInt();
        int result = Calculations.sum(a, b);
        System.out.println("Your sum from " + a + " to " + b + " is equal: " + result);
    }

    public static void main(String[] args) {
        boolean working = true;
        while (working) {
            displayMenu();
            Scanner myObj = new Scanner((System.in));
            String choice = myObj.nextLine();
            switch (choice) {
                case "1" -> {
                    factorialChoice();
                }
                case "2" -> {
                    sumChoice();
                }
                case "3"-> {
                    System.out.println("End of program. See you soon!");
                    working = false;
                }
                default -> System.out.println("Wrong option input!");
            }
        }
    }
}