/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SamanthaRose
 */

import java.util.Random;

public class HangmanGame {
    private String[] wordToGuess = new String[]{"abstract", "cemetery", "nurse",
                                        "pharmacy", "climbing"}; 
    private String chosenWord;
    private char[] letterBlanks;
    private Random wordGen = new Random();
    
    private String pickWord() {
        int word = wordGen.nextInt(5);
        chosenWord = wordToGuess[word];
        return chosenWord;
    }
    
    private void initLetters() {
        letterBlanks = new char[pickWord().length()];
    }
    
    private boolean checkLetter(char a) {
       boolean hasLetter = false;
       for(int i = 0; i < letterBlanks.length; i++) {
           if(chosenWord.charAt(i) == a) {
               letterBlanks[i] = a;
               hasLetter = true;
           }
       } 
       return hasLetter;
    }
}
