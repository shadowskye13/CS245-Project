
    /***************************************************************
* file: HangmanPanel.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.0
* date last modified: 10/10/2017
*
* purpose: This panel is the actual Hangman game, which controls
* the flow and statuses of the whole game.
* It shows the hangman game screen with a date timer
* and the game itself, which consists of buttons representing the
* alphabet letters and a hangman picture and word text field that
* are filled out as correct guesses are done.
****************************************************************/


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HangmanPanel extends JPanel{

    // Wordlist
    private String[] wordList = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};

    // Hangman pic
    private ImageIcon hangmanHead = new ImageIcon(getClass().getResource("/imgs/HangmanWithHead.png"));
    private ImageIcon hangmanBody = new ImageIcon(getClass().getResource("/imgs/HangmanWithBody.png"));
    private ImageIcon hangmanArm1 = new ImageIcon(getClass().getResource("/imgs/HangmanOneArm.png"));
    private ImageIcon hangmanArm2 = new ImageIcon(getClass().getResource("/imgs/HangmanFinal.png"));
    private ImageIcon hangmanLeg1 = new ImageIcon(getClass().getResource("/imgs/HangmanOneLeg.png"));
    private ImageIcon hangmanLeg2 = new ImageIcon(getClass().getResource("/imgs/HangmanBothLegs.png"));

    // Other components
    private JPanel alphabetPanel;
    private String selectedWord;
    private JLabel hangmanPic, 
                   dateTimeLabel, 
                   titleLabel,
                   descriptionLabel,
                   scoreLabel;
    private int score, 
                miss, 
                guessed;
    private JButton skipButton, 
                    continueButton;
    private ArrayList<JLabel> correctLetters;
    private HashMap<String, JButton> letterButtonMapper;

    public HangmanPanel() {
        initComponents();
        this.setBackground(new Color(153, 204, 255));
        this.setSize(new Dimension(600,400));
    }

    private void initComponents() {
        // Keep track of score
        score = 100;
        miss = 0 ;
        guessed = 0;

        // Display game title and description
        descriptionLabel = new JLabel("Welcome!");
        add(descriptionLabel);
        titleLabel = new JLabel("Hangman");
        titleLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleLabel.setFont(new Font("Tahoma", 1, 30));
        add(titleLabel);

        // Display hangman picture
        hangmanPic = new JLabel();
        hangmanPic.setIcon(new ImageIcon(getClass().getResource("/imgs/Hangman-0.png")));
        hangmanPic.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
        add(hangmanPic);

        // Display skip button
        skipButton = new JButton("Skip");
        skipButton.setFont(new Font("Tahoma", 0, 16));
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                score = 0;
                scoreLabel.setText("Score: " + score);
                disableButtons();
                finishGame("Game skipped");
            }
        });
        add(skipButton);

        // Display current time and date
        displayDateTime();

        // Display score
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Tahoma", 0, 30));
        add(scoreLabel);

        // Build the rest of the logic of the game
        buildGame();
    }

    /**
     * Updates the picture of hangman based on miss
     */
    private void changeHangman() {
        switch(miss) {
            case 1:
                hangmanPic.setIcon(hangmanHead);
                break;
            case 2:
                hangmanPic.setIcon(hangmanBody);
                break;
            case 3:
                hangmanPic.setIcon(hangmanLeg1);
                break;
            case 4:
                hangmanPic.setIcon(hangmanLeg2);
                break;
            case 5:
                hangmanPic.setIcon(hangmanArm1);
                break;
            case 6:
                hangmanPic.setIcon(hangmanArm2);
                break;
            default:
                break;
        }
        this.revalidate();
        this.repaint();
    }

    /**
     * This displays the date time label and uses a timer to update
     * the time every second
     */
    private void displayDateTime() {
        dateTimeLabel = new JLabel();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        dateTimeLabel.setFont(new Font("Tahoma", 1, 14));
        dateTimeLabel.setText(dateFormat.format(new Date()));
        add(dateTimeLabel);
        Timer time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dateTimeLabel.setText(dateFormat.format(new Date()));
            }
        });
        time.setRepeats(true);
        time.start();
    }

    /**
     * The main logic of the hangman name
     */
    private void buildGame() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        letterButtonMapper = new HashMap<>();
        alphabetPanel = new JPanel();
        selectedWord = wordList[(int)(wordList.length * Math.random())];

        alphabetPanel.setLayout(new java.awt.GridLayout(2, 13));

        // Fill out word bank
        correctLetters = new ArrayList<>();
        JPanel correctLettersPanel = new JPanel(new FlowLayout());
        for(int i = 0; i < selectedWord.length(); i++) {
            JLabel letterLabel = new JLabel("_");
            letterLabel.setFont(new Font("Tahoma", 0, 15));

            correctLettersPanel.add(letterLabel);
            correctLetters.add(letterLabel);
        }
        add(correctLettersPanel);

        // loop through alphabet and create buttons and their actions
        String activeLetter;
        for(int i = 0; i < alphabet.length(); i++) {
            activeLetter = "" + alphabet.charAt(i);

            JButton letterButton = new JButton();
            // each letter button has an action associated with it
            letterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    JButton selectedLetter = letterButtonMapper.get(evt.getActionCommand());
                    // update score and hangman pic based on letter selection
                    if(!userActionGuessed(evt.getActionCommand())) {
                        score-=10;
                        scoreLabel.setText("Score: " + score);
                        miss++;
                        // update hangman pic
                        changeHangman();
                    }
                    if(guessed == selectedWord.length()) {
                        finishGame("You won!");
                    } else if (miss == 6) {
                        finishGame("You lost!");
                    }
                    selectedLetter.setEnabled(false);
                    repaint();
                }
            });
            letterButton.setText(activeLetter);
            letterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            letterButton.setFont(new Font("Tahoma", 0, 14));
            letterButton.setActionCommand(activeLetter);

            letterButtonMapper.put(activeLetter, letterButton);
            alphabetPanel.add(letterButton);
        }
        add(alphabetPanel);
    }

    /**
     * When user presses a button, determine if it was a correct guess or not
     */
    private boolean userActionGuessed(String letter) {
        boolean correctGuess = false;

        for(int i = 0; i < selectedWord.length(); i++) {
            if(letter.equals("" + selectedWord.charAt(i))) {
                JLabel correctLetter = correctLetters.get(i);
                correctLetter.setText("" + selectedWord.charAt(i));
                guessed++;
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    /**
     * Finish the game of hangman. Show score and disable buttons
     */
    private void finishGame(String result) {
        // Disable all buttons
        disableButtons();
        descriptionLabel.setText(result);
        repaint();
        
        removeAll();
        add(new ColorBubblesPanel());
        revalidate();
        repaint();
    }

    private void disableButtons() {
        for(Map.Entry<String, JButton> entry : letterButtonMapper.entrySet()) {
            entry.getValue().setEnabled(false);
        }
        skipButton.setEnabled(false);
    }
}

