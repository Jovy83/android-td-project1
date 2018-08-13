import java.util.Scanner;

public class Prompter {

    private Scanner mScanner;

    public Prompter() {
        mScanner = new Scanner(System.in);
    }

    public String promptItemName() {
        System.out.print("What type of item should go in the jar: ");
        String itemName = mScanner.nextLine();

        if (itemName.isEmpty()) {
            throw new IllegalArgumentException("Enter a valid name.");
        }

        return itemName;
    }

    public int promptItemMaxNumber(String itemName) {
        System.out.printf("What is the maximum amount of %s that should go in the jar: ", itemName);
        String numberString = mScanner.nextLine();

        int number;
        try {
            number = Integer.valueOf(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Enter a valid number.");
        }

        if (number <= 1) {
            throw new IllegalArgumentException("Enter a number more than 1.");
        }

        return number;
    }

    public int promptForGuess(Jar jar) {
        System.out.printf("How many %s are in the jar? Pick a number from 1 to %d: ", jar.getItemName(), jar.getMaxNumber());
        String guessString = mScanner.nextLine();

        int number;
        try {
            number = Integer.valueOf(guessString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Enter a valid number.");
        }
        return number;

    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to the guessing game!");
    }

    public void printSeparator() {
        System.out.println("=======================");
        System.out.printf("%n%n%n");
        System.out.println("=======================");
    }

    public void printInvalidGuessMessage() {
        System.out.println("Only enter valid numbers within the range.");
    }

    public void printFeedback(boolean isLess) {
        if (isLess) {
            System.out.println("Guess a higher number.");
        } else {
            System.out.println("Guess a lower number.");
        }
    }

    public void printWinMessage(int attempts) {
        System.out.printf("That's correct. You got it in %d attempt(s). %n", attempts);
    }

}
