import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guesser Game!");
        System.out.println("************************************");

        Random friendRandom = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nLet's start a new round!");
            int roundsWonInCurrentGame = playOneRound(friendRandom, scanner);
            System.out.println("Your Score - Rounds Won: " + roundsWonInCurrentGame);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nThanks for playing the Number Guesser Game! See you next time.");
        scanner.close();
    }

    private static int playOneRound(Random friendRandom, Scanner scanner) {
        int mysteryNumber = friendRandom.nextInt(100) + 1;
        int maxAttempts = 5;
        int attempts = 0;
        boolean correctGuess = false;

        while (!correctGuess && attempts < maxAttempts) {
            System.out.print("\nEnter your guess: ");
            int playerGuess = scanner.nextInt();

            if (playerGuess == mysteryNumber) {
                System.out.println("Congratulations! You guessed it!");
                correctGuess = true;
            } else if (playerGuess < mysteryNumber) {
                System.out.println("Nice try, but your guess is too low. Try again.");
            } else {
                System.out.println("Close, but your guess is too high. Try again.");
            }

            attempts++;
        }

        if (correctGuess) {
            System.out.println("You won this round!");
            return 1;
        } else {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + mysteryNumber);
            return 0;
        }
    }
}
