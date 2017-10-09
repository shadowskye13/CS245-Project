/***************************************************************
* file: MainAction.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.0
* date last modified: 10/09/2017
*
* purpose: This is the main JFrame in which the game is to be displayed
*
****************************************************************/


import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainAction extends javax.swing.JFrame{

    TitlePanel titlePanel = new TitlePanel();

    public MainAction(String name) {
        super(name);
        initGUI();
    }

    /**
     * Initialize the form GUI properties
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(titlePanel);
        setSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * The main executable class that starts the program
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainAction("Hangman").setVisible(true);
            }
        });
    }

}