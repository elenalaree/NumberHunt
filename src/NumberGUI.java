import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGUI extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;

    private NumberLogic numberLogic;

    public NumberGUI() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("Guess the number!");

        add(guessField);
        add(guessButton);
        add(resultLabel);


        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        numberLogic = new NumberLogic();
    }

    public void runApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    private void handleGuess() {
        int userGuess = Integer.parseInt(guessField.getText());
        int remainingTries = updateTries();
        if(remainingTries == 0){
            resultLabel.setText("You ran out of tries! Dang!");
        }
        if (numberLogic.playNumberGuessingGame(userGuess)) {
            resultLabel.setText("You got it!");
        } else {
            String hint = numberLogic.displayHint(userGuess, remainingTries);
            resultLabel.setText(hint);
        }
    }

    private int updateTries() {
        return numberLogic.getRemainingTries();
    }

    public static void main(String[] args) {
        NumberGUI numberGUI = new NumberGUI();
        numberGUI.runApplication();
    }
}
