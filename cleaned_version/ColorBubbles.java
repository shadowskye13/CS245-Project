/***************************************************************
* file: ColorBubbles.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/19/2017
*
* purpose: This class contains the main logic of the bubbles
* game. It selects a random color and a random string associated
* with it. The score that is being kept track of relates to the
* bubble game alone, and does not include the score of the entire
* PointNClick application
****************************************************************/

import java.awt.Color;
import java.util.Random;

public class ColorBubbles {
    private String[] colors = new String[]{"green","red","blue","purple","yellow"};
    private String chosenString;
    private Color chosenColor;

    public ColorBubbles() {
        reset();
    }

    // Choose a string, and a color for that string
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

    // Retrieve the string name representation of the Color assigned
    public String getChosenColorToString() {
        if (chosenColor.equals(Color.BLUE)) {
            return "blue";
        }
        else if (chosenColor.equals(Color.GREEN)) {
            return "green";
        }
        else if (chosenColor.equals(Color.RED)) {
            return "red";
        }
        else if (chosenColor.equals(Color.MAGENTA)) {
            return "purple";
        }
        else if (chosenColor.equals(Color.YELLOW)) {
            return "yellow";
        }
        else
            return "";
    }

    // Retrieve a random color name string
    private void chooseString() {
        Random rand = new Random();
        int choice = rand.nextInt(5);
        chosenString = colors[choice];
    }

    // Retrieve a random color for the string shown
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