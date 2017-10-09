import java.util.*;


class Hangman {
	
	private String[] wordList = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
	private String wordToGuess;
	private int miss;
	private int score;
	private ArrayList<Integer> scores;
	private char[] maskedWord;
	
	public Hangman() {
		reset();
		scores = new ArrayList<Integer>();
	}
	
	private void reset() {
		wordToGuess = wordList[(int)(Math.random() * wordList.length)];
		miss = 0;
		score = 100;
		maskedWord = new char[wordToGuess.length()];
		for(int i = 0; i < maskedWord.length; i++) {
			maskedWord[i] = '*';
		}
	}
	
	public void printWord() {
		for(int i = 0; i < maskedWord.length; i++) {
			System.out.print(maskedWord[i]);
		}     
		System.out.println();
	}
	
	public char[] getMaskedWord() {
		return maskedWord;
	}
	
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
	
	public boolean checkWin() {
		boolean win = true;
		for(int i = 0; i < maskedWord.length; i++) {
			if(maskedWord[i] == '*') {
				win = false;
			}
		}
		return win;
	}
	
	public void saveScore() {
		if(checkWin()) {
			scores.add(score);
		}   
	}
	
	public boolean checkLose() {
		boolean lose = false;
		if(miss > 6) {
			lose = true;
		}
		return lose;
	}
	
	public ArrayList<Integer> getScores() {
		Collections.sort(scores, Collections.reverseOrder());
                return scores;
	}
	
	public void skip() {
		score = 0;
	}
	
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
			default:
				break;
		}
	}
	
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