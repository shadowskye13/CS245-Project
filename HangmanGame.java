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
    private Random wordGen = new Random();
    
    public String pickWord() {
        int word = wordGen.nextInt(5);
        return wordToGuess[word];
    }
}
