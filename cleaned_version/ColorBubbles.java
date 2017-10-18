/***************************************************************
* file: ColorBubbles.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/17/2017
*
* purpose: 
****************************************************************/

import java.util.Random;
import java.awt.*;

public class ColorBubbles {
    private String[] colors = new String[]{"green","red","blue","purple","yellow"};
    private String chosenColor;
    private Color stringColor;
    private int score = 0;

    public ColorBubbles() {
        reset();
    }

    public void reset() {
        chooseString();
        chooseColor();
    }

    public Color getStringColor() {
        return stringColor;
    }

    public String getChosenColor() {
        return chosenColor;
    }

    public int getScore() {
        return score;
    }

    public boolean checkColor(Color c) {
        if(c.equals(stringColor)) {
            score += 100;
        }
        return c.equals(stringColor);
    }

    private void chooseString() {
        Random rand = new Random();
        int choice = rand.nextInt(5);
        chosenColor = colors[choice];
    }

    private void chooseColor() {
        Random rand = new Random();
        int choice = rand.nextInt(5);
        switch(choice) {
            case 0:
                stringColor = Color.RED;
                break;
            case 1:
                stringColor = Color.GREEN;
                break;
            case 2:
                stringColor = Color.BLUE;
                break;
            case 3:
                stringColor = Color.MAGENTA;
                break;
            case 4:
                stringColor = Color.YELLOW;
                break;
            default:
                break;
        }
    }

}