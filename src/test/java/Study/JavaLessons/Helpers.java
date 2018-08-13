package Study.JavaLessons;

import java.util.Random;
import java.util.Scanner;

public class Helpers {

    public static String readFromConsole() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.next();
    }

    public static int readNumberFromConsole() {
        return Integer.parseInt(readFromConsole());
    }

    public static int createRandomNumber(int low, int high) {
        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        System.out.println(result);
        return result;
    }

}
