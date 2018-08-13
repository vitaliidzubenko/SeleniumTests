package Study.JavaLessons;

public class Game {

    private static final int Maximum = 50;
    private static final int Minimum = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private void start() {

        int createdRandomNumber;
        int guessedAlready;

        do {
            createdRandomNumber = Helpers.createRandomNumber(Minimum, Maximum);
            do {
                guessedAlready = Helpers.readNumberFromConsole();

                if (createdRandomNumber > guessedAlready) {
                    System.out.println("The number I thought of is bigger");

                } else if (createdRandomNumber < guessedAlready) {
                    System.out.println("The number I thought of is smaller");

                } else {
                    System.out.println("Number is correct");
                }

            } while (createdRandomNumber != guessedAlready);

        } while (playAgain());
    }

    private boolean playAgain() {
        System.out.println("Want to a play a game? Y/N");
        return Helpers.readFromConsole().equals("y");
    }

}
