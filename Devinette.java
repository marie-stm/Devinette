package ProgGraphique;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Devinette extends JFrame {

	
    private JTextField inputField;
    private JButton guessButton;
    private JLabel feedbackLabel;
    private int randomNumber;

    public Devinette() {
        
        setTitle("Jeu de devinette");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

       
        randomNumber = (int) (Math.random() * 100) + 1;

      
        JLabel promptLabel = new JLabel("Entrez un nombre entre 1 et 100 :");
        inputField = new JTextField(10);
        guessButton = new JButton("Deviner");
        feedbackLabel = new JLabel(" ");

       
        add(promptLabel);
        add(inputField);
        add(guessButton);
        add(feedbackLabel);

     
        guessButton.addActionListener(new GuessButtonListener());

     
        setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int userGuess = Integer.parseInt(inputField.getText());

                if (userGuess < randomNumber) {
                    feedbackLabel.setText("Plus haut !");
                } else if (userGuess > randomNumber) {
                    feedbackLabel.setText("Plus bas !");
                } else {
                    feedbackLabel.setText("Gagné ! Le nombre était " + randomNumber);
                   
                    randomNumber = (int) (Math.random() * 100) + 1;
                }

            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Veuillez entrer un nombre valide.");
            }
        }
    }

    public static void main(String[] args) {
        // Lancer l'application
        new Devinette();
    }
}


