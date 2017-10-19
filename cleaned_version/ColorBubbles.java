/***************************************************************
* file: ColorBubbles.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/18/2017
*
* purpose: This class contains the main logic of the bubbles
* game. It selects a random color and a random string associated
* with it. The score that is being kept track of relates to the
* bubble game alone, and does not include the score of the entire
* PointNClick application
****************************************************************/

import java.util.Random;
import java.awt.*;

public class ColorBubbles {
    private String[] colors = new String[]{"green","red","blue","purple","yellow"};
    private String chosenString;
    private Color chosenColor;
    private int score = 0;

    public ColorBubbles() {
        reset();
    }

    public void reset() {
        chooseString();
        chooseColor();
    }

    public Color getChosenColor() {
        return chosenColor;
    }

    public String getChosenString() {
        return chosenString;
    }

    public int getScore() {
        return score;
    }

    public boolean checkColor(Color c) {
        if(c.equals(chosenColor)) {
            score += 100;
            return true;
        }
        return false;
    }

    private void chooseString() {
        Random rand = new Random();
        int choice = rand.nextInt(5);
        chosenString = colors[choice];
    }

    private void chooseColor() {
        Random rand = new Random();
        int choice = rand.nextInt(5);
        switch(choice) {
            case 0:
                chosenColor = Color.RED;
                break;
            case 1:
                chosenColor = Color.GREEN;
                break;
            case 2:
                chosenColor = Color.BLUE;
                break;
            case 3:
                chosenColor = Color.MAGENTA;
                break;
            case 4:
                chosenColor = Color.YELLOW;
                break;
            default:
                break;
        }
    }

}