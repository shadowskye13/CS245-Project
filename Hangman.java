/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/***************************************************************
* file: HangmanGame.java
* author: Wing Hung Lau
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 10/9/2017
*
* purpose: This class is the actual Hangman game, which controls 
*		   the flow and statuses of the whole game.
*
****************************************************************/ 
class Hangman {
	
	private String[] wordList = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
	private String wordToGuess;
	private int miss;
	private int score;
	private ArrayList<Integer> scores;
	private char[] maskedWord;
	
	// method: Hangman
	// purpose: This is the constructor of the class Hangman
	public Hangman() {
		reset();
		scores = new ArrayList<Integer>();
	}
	
    // method: getMiss
	// purpose: Return the miss count
    public int getMiss() {
        return miss;
    }
	
	// method: reset
	// purpose: To reset the whole game to initial state
	private void reset() {
		wordToGuess = wordList[(int)(Math.random() * wordList.length)];
		miss = 0;
		score = 100;
		maskedWord = new char[wordToGuess.length()];
		for(int i = 0; i < maskedWord.length; i++) {
			maskedWord[i] = '*';
		}
	}
	
	// method: printWord
	// purpose: To print the maskedWord
	public void printWord() {
		for(int i = 0; i < maskedWord.length; i++) {
			System.out.print(maskedWord[i]);
		}     
		System.out.println();
	}
	
	// method: getMaskedWord
	// purpose: Return the maskedWord
	public char[] getMaskedWord() {
		return maskedWord;
	}
	
	// method: checkLetter
	// purpose: To compare the character with the wordToGuess, return true if it contains that character
	//			and to display that correct character in the maskedWord; return false if it doesn't contain
	//			that character, then increment the miss by 1, decrease score by 10 and to hang portion of the body
	public boolean checkLetter(char temp) {
		boolean hasLetter = false;
		for(int i = 0; i < wordToGuess.length(); i++) {
			if(wordToGuess.charAt(i) == temp) {
				maskedWord[i] = temp;
				hasLetter = true;
			}
		}
		if(hasLetter == false) {
			miss++;
			score -= 10;
			hanging();
		}
		return hasLetter;
	}
	
	// method: checkWin
	// purpose: To check if the game wins or not, return true if the maskedWord doesn't contain *
	public boolean checkWin() {
		boolean win = true;
		for(int i = 0; i < maskedWord.length; i++) {
			if(maskedWord[i] == '*') {
				win = false;
			}
		}
		return win;
	}
	
	// method: saveScore
	// purpose: To save the score to the integer arraylist scores if wins
	public void saveScore() {
		if(checkWin()) {
			scores.add(score);
		}   
	}
	
	// method: checkLose
	// purpose: To check if the game loses or not, return true if the miss count is greater than 6
	public boolean checkLose() {
		boolean lose = false;
		if(miss > 6) {
			lose = true;
		}
		return lose;
	}
	
	// method: getScores
	// purpose: Return the integer arraylist scores in descending order
	public ArrayList<Integer> getScores() {
		Collections.sort(scores, Collections.reverseOrder());
                return scores;
	}
	
	// method: skip
	// purpose: To set the score to 0 when the game is skipped
	public void skip() {
		score = 0;
	}
	
	// method: hanging
	// purpose: To hang different part of the body corresponding to different miss count
	private void hanging() {
            switch (miss) {
			case 1:
				System.out.println("Head");
				break;
			case 2:
				System.out.println("Body");
				break;
			case 3:
				System.out.println("Left Hand");
				break;
			case 4:
				System.out.println("Right Hand");
				break;    
			case 5:
				System.out.println("Left Leg");
				break;     
			case 6:
				System.out.println("Right Leg");
                                break;
			default:
				break;
		}
	}
	
	//method: main
	//purpose: To test if the Hangman game works correctly
	public static void main(String[] args) {
		Hangman hm = new Hangman();
		hm.printWord();
		hm.checkLetter('n');
		hm.printWord();
		hm.checkLetter('i');
		hm.printWord();
		hm.checkLetter('e');
		hm.printWord();
		hm.checkLetter('a');
		hm.printWord();
		hm.checkLetter('b');
		hm.printWord();
		hm.checkLetter('c');
		hm.printWord();
		hm.checkLetter('d');
		hm.printWord();
		hm.checkLetter('o');
		hm.printWord();
		hm.checkLetter('t');
		hm.printWord();
		if(hm.checkWin()){
			System.out.println("win");
		}
		else {
			System.out.println("lose");
		}

	}
		
}