import javax.swing.JTextField;

/**
 * file: SudokuGame.java
 * author: S. Harrison, N. Peng, W. Lau
 * class: CS245 Programming Graphical User Interfaces
 * 
 * assignment: Quarter Project v1.2
 * date last modified: 10/29/17
 * 
 * purpose: This class is the logic of the Sudoku game.
 */

public class SudokuGame {

    private int[][] solution = {
        {8,3,5,4,1,6,9,2,7},{2,9,6,8,5,7,4,3,1},{4,1,7,2,9,3,6,5,8},
        {5,6,9,1,3,4,7,8,2},{1,2,3,6,7,8,5,4,9},{7,4,8,5,2,9,1,6,3},
        {6,5,2,7,8,1,3,9,4},{9,8,1,3,4,5,2,7,6},{3,7,4,9,6,2,8,1,5}};

    private int[][] numGrid = {
        {8,0,0,4,0,6,0,0,7},{0,0,0,0,0,0,4,0,0},{0,1,0,0,0,0,6,5,0},
        {5,0,9,0,3,0,7,8,0},{0,0,0,0,7,0,0,0,0},{0,4,8,0,2,0,1,0,3},
        {0,5,2,0,0,0,0,9,0},{0,0,1,0,0,0,0,0,0},{3,0,0,9,0,2,0,0,5}};

    private static final int SCORE = 540;
    private int score;
    private boolean firstTime;

    //method: SudokuGame
    //purpose: This is the constructor of the SudokuGame
    public SudokuGame(int oldScore) {
        score = oldScore + SCORE;
        firstTime = true;
    }

    /**
     * Returns whether this is the first round of the game.
     */
    public boolean isFirst() {
        return firstTime;
    }

    /**
     * Sets the condition of this game round being the first or not.
     */
    public void setFirst(boolean cond) {
        firstTime = cond;
    }

    //method: getNumGrid
    //purpose: Returns the original num grid of the game (with missing user input)
    public int[][] getNumGrid() {
        return this.numGrid;
    }

    //method: getScore
    //purpose: This method returns the score
    public int getScore() {
        return score;
    }

    //method: validInput
    //purpose: This method checks if the input string is valid or not
    public boolean validInput(String input) {
        try {
            int num = Integer.parseInt(input);
            if(num >= 1 && num <= 9) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //method: finishedGame
    //purpose: This method compares the game with the solution, records the wrong count
    //in order to calculate the final score
    //If the user finishes the game before trying to attempt any input, the score
    //is also taken into account
    public boolean finishedGame(JTextField[][] board) {
        int wrongCount = 0;
        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j].getText().equals("") ||
                    Integer.parseInt(board[i][j].getText()) != solution[i][j]) {
                    wrongCount++;
                }
            }
        }
        if(firstTime) {
            score -= wrongCount * 10;
        }
        return (wrongCount == 0);
    }

    public boolean checkIndiv(int num, int i, int j) {
        return solution[i][j] == num;
    }

}