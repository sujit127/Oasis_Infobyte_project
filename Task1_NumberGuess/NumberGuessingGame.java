import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("🎮 Welcome to Guess The Number Game 🎮");

        do {
            int number = random.nextInt(100) + 1; // 1 to 100
            int attempts = 5;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it!");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");
                guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    int roundScore = (attempts - i + 1) * 10;
                    System.out.println("Points earned: " + roundScore);
                    totalScore += roundScore;
                    guessedCorrectly = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too LOW!");
                } else {
                    System.out.println("Too HIGH!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You ran out of attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Your total score: " + totalScore);

            System.out.print("\nDo you want to play another round? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nThanks for playing! Final Score: " + totalScore);
        sc.close();
    }
}