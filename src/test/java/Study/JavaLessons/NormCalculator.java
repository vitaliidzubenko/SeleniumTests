package Study.JavaLessons;

import java.util.Scanner;

public class NormCalculator {


    public static void main(String[] args) {
        NormCalculator calculator = new NormCalculator();
        calculator.start();
    }

    public void start() {
        displayMenu();
        System.out.println("Enter operation :");
        readFromConsole();

        Scanner scan = new Scanner(System.in);
        String userChoice = scan.next();
        System.out.println("Enter first number");
        int num1 = scan.nextInt();
        System.out.println("Enter second number");
        int num2 = scan.nextInt();

        if (userChoice.equals("+")) {
            System.out.println(num1 + num2);
        } else if (userChoice.equals("-")) {
            System.out.println(num1 - num2);
        } else if (userChoice.equals("*")) {
            System.out.println(num1 * num2);
        } else if (userChoice.equals("/")) {
            System.out.println(num1 / num2);
        }

    }

    public String readFromConsole() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void displayMenu() {
        System.out.println("What you want to do motherfucker?");
        System.out.println();
        System.out.println("1. + Add");
        System.out.println("2. - Subtract");
        System.out.println("3. * Multiply");
        System.out.println("4. / Divide");
    }

}
