/***************************************************************
* file: SudokuPanel.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.2
* date last modified: 10/29/2017
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        submitButton.setFont(new Font("Trattatello",1,24));
        bottomPanel.add(submitButton);

        // Display quit button
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Trattatello",1,24));
        bottomPanel.add(quitButton);

        // Add this panel to main panel
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void buildBoard() {
        gameGrid = new JPanel();
        gameGrid.setLayout(new java.awt.GridLayout(9,9));
        board = new JTextField[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                board[i][j] = new JTextField(2);
                gameGrid.add(board[i][j]);
                if(presets(i,j) != 0) {
                    board[i][j].setText(Integer.toString(presets(i,j)));
                }
            }
        }
    }

    private void checkBoard() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                sudGame.checkScore(i, j, Integer.parseInt(board[i][j].getText()));  
            }
        }
    }

    private int presets(int a,int b) {
        if(a == 0 && b == 0) {
            return sudGame.getNum(0, 0);
        }
        else if(a == 0 && b == 3) {
            return sudGame.getNum(0, 3);
        }
        else if(a == 0 && b == 5) {
            return sudGame.getNum(0, 5);
        }
        else if(a == 0 && b == 8) {
            return sudGame.getNum(0, 8);
        }
        else if(a == 1 && b == 6) {
            return sudGame.getNum(1, 6);
        }
        else if(a == 2 && b == 1) {
            return sudGame.getNum(2, 1);
        }
        else if(a == 2 && b == 6) {
            return sudGame.getNum(2, 6);
        }
        else if(a == 2 && b == 7) {
            return sudGame.getNum(2, 7);
        }
        else if(a == 3 && b == 0) {
            return sudGame.getNum(3, 0);
        }
        else if(a == 3 && b == 2) {
            return sudGame.getNum(3, 2);
        }
        else if(a == 3 && b == 4) {
            return sudGame.getNum(3,4);
        }
        else if(a == 3 && b == 6) {
            return sudGame.getNum(3, 6);
        }
        else if(a == 3 && b == 7) {
            return sudGame.getNum(3, 7);
        }
        else if(a == 4 && b == 4) {
            return sudGame.getNum(4, 4);
        }
        else if(a == 5 && b == 1) {
            return sudGame.getNum(5, 1);
        }
        else if(a == 5 && b == 2) {
            return sudGame.getNum(5, 2);
        }
        else if(a == 5 && b == 4) {
            return sudGame.getNum(5, 4);
        }
        else if(a == 5 && b == 6) {
            return sudGame.getNum(5, 6);
        }
        else if(a == 5 && b == 8) {
            return sudGame.getNum(5, 8);
        }
        else if(a == 6 && b == 1) {
            return sudGame.getNum(6, 1);
        }
        else if(a == 6 && b == 2) {
            return sudGame.getNum(6, 2);
        }
        else if(a == 6 && b == 7) {
            return sudGame.getNum(6, 7);
        }
        else if(a == 7 && b == 2) {
            return sudGame.getNum(7, 2);
        }
        else if(a == 8 && b == 0) {
            return sudGame.getNum(8, 0);
        }
        else if(a == 8 && b == 3) {
            return sudGame.getNum(8, 3);
        }
        else if(a == 8 && b == 5) {
            return sudGame.getNum(8, 5);
        }
        else if(a == 8 && b == 8) {
            return sudGame.getNum(8, 8);
        }
        else {
            return 0;
        }
    }

}