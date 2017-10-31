
/***************************************************************
* file: SudokuPanel.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.2
* date last modified: 10/30/2017
*
* purpose: This class displays the panel for the sudoku
* game. It displays the numbers in a 9x9 grid. When an user
* clicks on an empty button, it prompts the user to input a
* digit.
****************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SudokuPanel extends JPanel {

    // Components
    private JPanel topPanel, bottomPanel, gameGrid;
    private JLabel titleLabel;
    private JButton submitButton, quitButton;
    private SudokuGame sudGame;
    private JTextField[][] board;

    public SudokuPanel(int score) {
        // Initialize variables
        sudGame = new SudokuGame(score);

        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(200,200,200));
        this.setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents() {
        // Initialize topPanel
        initializeTopPanel();

        // Initialize bottomPanel
        initializeBottomPanel();

        // Initialize sudoku board
        buildBoard();
    }

    /**
     * Create top panel that includes timer and title string label
     */
    private void initializeTopPanel() {
        topPanel = new JPanel(new GridLayout(1,2));

        // Display current time and date
        JLabel dateTimeLabel = new JLabel();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        dateTimeLabel.setFont(new Font("Tahoma", 1, 14));
        dateTimeLabel.setText(dateFormat.format(new Date()));
        dateTimeLabel.setToolTipText("The current date and time.");
        topPanel.add(dateTimeLabel);
        Timer time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dateTimeLabel.setText(dateFormat.format(new Date()));
            }
        });
        time.setRepeats(true);
        time.start();

        // Display title
        titleLabel = new JLabel("Sudoku");
        titleLabel.setFont(new Font("Trattatello", 1, 30));
        titleLabel.setToolTipText("The name of the game.");
        topPanel.add(titleLabel);

        // Add this panel to main panel
        add(topPanel, BorderLayout.PAGE_START);
    }

    /**
     * Create bottom panel that includes buttons to submit and quit
     */
    private void initializeBottomPanel() {
        bottomPanel = new JPanel(new GridLayout(1,2));

        // Display submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Trattatello",0,16));
        submitButton.setToolTipText("Press me to check if your solution is correct.");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correct = sudGame.finishedGame(board);
                if (correct) {
                    JOptionPane.showMessageDialog(null, "You correctly answered the sudoku game!");
                    endGame();
                } else {
                    JOptionPane.showMessageDialog(null, "Your answer is incorrect. Try again.");
                    if(sudGame.isFirst()) {
                        sudGame.setFirst(false);
                    }
                    resetBoard();
                }
            }
        });
        bottomPanel.add(submitButton);

        // Display quit button
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Trattatello",0,16));
        quitButton.setToolTipText("Press me to quit playing Sudoku.");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });
        bottomPanel.add(quitButton);

        // Add this panel to main panel
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    /**
     * Builds the sudoku board
     */
    private void buildBoard() {
        gameGrid = new JPanel();
        gameGrid.setLayout(new GridLayout(9,9));
        board = new JTextField[9][9];

        int[][] numGrid = sudGame.getNumGrid();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                // Set text field
                JTextField textField = new JTextField();
                textField.setToolTipText("Enter a number between 1 and 9 here.");

                // Fill grid panel with unanswered sudoku numgrid
                if (numGrid[i][j] != 0) {
                    textField.setEditable(false);
                    textField.setText(Integer.toString(numGrid[i][j]));
                }

                // check user input
                textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        // if there is an input, check if valid
                        String input =  textField.getText();
                        if (input.length() > 0 && textField.isEditable()) {
                            if (!sudGame.validInput(input)) {
                                JOptionPane.showMessageDialog(textField, "Invalid input. Please enter a number between 1-9");
                                textField.setText("");
                            }
                        }
                    }
                });

                board[i][j] = textField;
                gameGrid.add(textField);
            }
        }

        // Add this board panel to main panel
        add(gameGrid, BorderLayout.CENTER);
    }

    /**
     * Checks whether the board is correct. Intended for
     * subsequent rounds of sudoku, after user has guessed
     * again. If, a field is guesssed correctly, the field
     * is then made uneditable. Likewise, if the guess is
     * wrong, the field is made editable so the user can
     * change their answer.
     */
    private void resetBoard() {
        for(int a = 0; a < 9; a++) {
            for(int b = 0; b < 9; b++) {
                if (!board[a][b].getText().equals("")) {
                    if(sudGame.checkIndiv(Integer.parseInt(board[a][b].getText()), a, b)) {
                        board[a][b].setEditable(false);
                    }
                    else {
                        board[a][b].setEditable(true);
                    }
                }
            }
        }
    }

    /**
     * End the sudoku game. Guide the user to the end screen panel
     */
    private void endGame() {
        JPanel menuScreen = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, this);
        menuScreen.removeAll();
        menuScreen.add(new EndScreen(sudGame.getScore()));
        menuScreen.revalidate();
        menuScreen.repaint();
    }
}