import java.util.Scanner;

public class NumberLogic {
    private int answer;
    private int maxTries;
    private int tries;
    public NumberLogic() {
        this.answer = generateRandomNumber();
        this.maxTries = 10;
        this.tries = this.maxTries;
    }

    public boolean playNumberGuessingGame(int userGuess) {
        tries--;
        return userGuess == answer;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    public String displayHint(int guess, int remainingTries) {
        String hint = (guess > answer) ? "Too high! Guess lower." : "Too low! Guess higher.";
        return hint + " You have " + (remainingTries - 1) + " guesses left!";
    }

    public int getRemainingTries() {
        return tries;
    }
}
