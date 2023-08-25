import java.util.*;

class NumberGame {
    private int randomNumber;
    private int score = 100;
    private int userInputNumber;

    NumberGame() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(100);
    }

    void getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 100: ");
        userInputNumber = sc.nextInt();
        checkGuess(userInputNumber);
    }

    boolean checkGuess(int userNumber) {
        if (userNumber == randomNumber) {
            System.out.println("Congratulations! You guessed correctly. Your score is " + score +
                    " out of 100, and it took you " + (10 - (score / 10)) + " attempt(s).");

            if (playAgain()) {
                score = 100;
                getUserInput();
            }
            return true;
        }

        score -= 10;
        if (score == 0) {
            System.out.println("You have reached the maximum limit of guesses (10). Better luck next time.");

            if (playAgain()) {
                score = 100;
                getUserInput();
            }
            return true;
        }

        int difference = Math.abs(randomNumber - userNumber);

        if (randomNumber < userNumber) {
            System.out.print("Your guessed number is too high. ");
        } else {
            System.out.print("Your guessed number is too low. ");
        }

        if (difference > 20) {
            System.out.println();
        } else if (difference > 10) {
            System.out.println("The absolute difference is below 21 and above 10.");
        } else if (difference > 5) {
            System.out.println("The absolute difference is below 11 and above 5.");
        } else if (difference > 2) {
            System.out.println("The absolute difference is just below 6 and above 2.");
        } else {
            System.out.println("The absolute difference is just below 3.");
        }

        getUserInput();
        return false;
    }

    boolean playAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer.equalsIgnoreCase("yes");
    }
}

public class Main {
    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        numberGame.getUserInput();
    }
}
