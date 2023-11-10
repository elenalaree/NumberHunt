import java. util.Scanner;
import java. lang.Math;

public class Main {
    public static void main(String[] args) {

        int answer = (int) (Math.random() * 100) + 1;
        int tries = 5;

        Scanner input = new Scanner(System.in);
        boolean correct = false;

        System.out.println("I've chosen a number between 1 and 100. \n You have 5 guesses.");
        while (tries > 0) {
            System.out.println("Enter your guess: ");
            int guess = input.nextInt();
            if(guess ==  answer) {
                int guesses = tries - 1;
                String formattedString = """
                        You got it!
                        It took %s tries!
                        """.formatted(guesses);
                System.out.println(formattedString);
                break;
            } else if (guess > answer) {
                int guesses = tries - 1;
                System.out.println("Too high! Guess lower.");
            } else {
                int guesses = tries - 1;
                System.out.println("Too low! Guess higher. You have " + guesses + " guesses left!");
            }
            tries--;
        }

        if (!correct) {
            System.out.println("You ran out of tries! You lose");
        }
    }
}