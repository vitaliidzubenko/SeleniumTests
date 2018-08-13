package Study.JavaLessons;

import java.util.Scanner;

public class Calculator {

    public int currentValue = 0;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }

    public void start() {
        String userResponse;

        do {
            displayMenu();

            userResponse = readFromConsole();

            if (userResponse.equals("+")) {
                currentValue = add(readNumberFromConsole());

            } else if (userResponse.equals("-")) {
                currentValue = subtract(readNumberFromConsole());

            } else if (userResponse.equals("*")) {
                currentValue = multiply(readNumberFromConsole());

            } else if (userResponse.equals("/")) {
                currentValue = divide(readNumberFromConsole());
            }

        } while (!userResponse.equals("q"));
    }

    public int add(int operand) {
        return currentValue + operand;
    }

    public int subtract(int operand) {
        return currentValue - operand;
    }

    public int multiply(int operand) {
        return currentValue * operand;
    }

    public int divide(int operand) {
        return currentValue / operand;
    }

    public int readNumberFromConsole() {
        return Integer.parseInt(readFromConsole());
    }

    public String readFromConsole() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void displayMenu() {
        System.out.println("What you want to do motherfucker?");
        System.out.println();
        System.out.println("+ Add");
        System.out.println("- Subtract");
        System.out.println("* Multiply");
        System.out.println("/ Divide");
        System.out.println("Your current value " + currentValue);
    }
}
