/***************************************************************
* file: SudokuGame.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.2
* date last modified: 10/29/2017
*
* purpose: This class contains the main logic of the sudoku
* game. It stores  a set of numbers in a 9x9 grid format and
* requests the user to fill the missing entries.
****************************************************************/

public class SudokuGame {
    private int[][] numGrid = {
        {8,3,5,4,1,6,9,2,7},{2,9,6,8,5,7,4,3,1},{4,1,7,2,9,3,6,5,8},
        {5,6,9,1,3,4,7,8,2},{1,2,3,6,7,8,5,4,9},{7,4,8,5,2,9,1,6,3},
        {6,5,2,7,8,1,3,9,4},{9,8,1,3,4,5,2,7,6},{3,7,4,9,6,2,8,1,5}};

   private int score;

    public SudokuGame(int oldScore) {
        score = oldScore + 540;
    }

    public int getNum(int a, int b) {
        return numGrid[a][b];
    }

    public boolean checkScore(int a, int b, int button) {
        if(button == numGrid[a][b]) {
            return true;
        }
        else {
            score = score - 10;
            return false;
        }
    }

    public int getScore() {
        return score;
    }

}