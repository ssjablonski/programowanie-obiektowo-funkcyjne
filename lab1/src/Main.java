import java.util.Scanner;

public class Main {
    public static void factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("Factorial of " + n + " is equal: " + result);
    }

    public static void main(String[] args) {
        boolean working = true;
        while (working) {
            Scanner myObj = new Scanner((System.in));
            System.out.println("Woudl you like to calculate factorial or exit program? (Options: Calculate, Exit)");
            String choice = myObj.nextLine();
            switch (choice) {
                case "Calculate":
                    System.out.println("Enter value of factorial you want to calculate: ");
                    int factorialN = myObj.nextInt();
                    factorial(factorialN);
                    break;
                case "Exit":
                    System.out.println("End of program. See you soon!");
                    working = false;
                    break;
                default:
                    System.out.println("Wrong option input!");
            }
        }
    }
}