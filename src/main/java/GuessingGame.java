public class GuessingGame {
    public static void main(String[] args) {

        int attempts = 0;

        Prompter prompter = new Prompter();

        String itemName = prompter.promptItemName();
        int maxNumberOfItems = prompter.promptItemMaxNumber(itemName);

        Jar jar = new Jar(itemName, maxNumberOfItems);

        // if there are no problems creating the Jar, proceed with the game
        prompter.printSeparator();
        prompter.printWelcomeMessage();

        boolean hasWon = false;
        while (!hasWon) {
            int guess = prompter.promptForGuess(jar);

            if (guess <= 0 || guess > jar.getMaxNumber()) {
                prompter.printInvalidGuessMessage();
                continue;
            }

            attempts++;

            if (guess == jar.getNumberOfItems()) {
                hasWon = true;
                prompter.printWinMessage(attempts);
            } else if (guess < jar.getNumberOfItems()) {
                prompter.printFeedback(true);
            } else if (guess > jar.getNumberOfItems()) {
                prompter.printFeedback(false);
            }
        }
    }
}
