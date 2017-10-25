
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
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
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SudokuPanel extends JPanel {
    private JPanel gameGrid;
    private JLabel dateTime,titleLabel;
    private JButton submitButton, quitButton;
    private SudokuGame sudGame;
    private TextField[][] board;
    private int score;
    
    public SudokuPanel(int score) {
        initComponents();
        sudGame = new SudokuGame(score);
        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(200,200,200));
        
    }
    
    private void initComponents() {
        titleLabel = new JLabel("Sudoku");
        titleLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        titleLabel.setFont(new Font("Trattatello", 1, 30));
        add(titleLabel);
        
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Trattetello",1,24));
        add(submitButton);
        
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Trattatello",1,24));
        add(quitButton);
        
        displayDateTime();
        buildBoard();
    }
    
    /**
     * This displays the date time label and uses a timer to update
     * the time every second
     */
    private void displayDateTime() {
        dateTime = new JLabel();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        dateTime.setFont(new Font("Tahoma", 1, 14));
        dateTime.setText(dateFormat.format(new Date()));
        add(dateTime);
        Timer time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dateTime.setText(dateFormat.format(new Date()));
            }
        });
        time.setRepeats(true);
        time.start();
    }
    
    private void buildBoard() {
        gameGrid = new JPanel();
        gameGrid.setLayout(new java.awt.GridLayout(9,9));
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board[i][j] = new TextField(2);
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
