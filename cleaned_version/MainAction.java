/***************************************************************
* file: MainAction.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v1.2
* date last modified: 10/31/2017
*
* purpose: This is the main JFrame in which the game is to be displayed
*
****************************************************************/


import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MainAction extends javax.swing.JFrame{

    TitlePanel titlePanel = new TitlePanel();

    public MainAction(String name) {
        super(name);
        initKeyActions();
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
        pack();
    }

    /**
     * The main executable class that starts the program
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainAction("PointNClick").setVisible(true);
            }
        });
    }

    /**
     * When user presses ESC, exit program.
     * When user presses F1, display game and author info
     */
    private void initKeyActions() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    JOptionPane.showMessageDialog(null, "Point N Click Game\n" +
                   "CS245 Fall 2017\n" + "Samantha Harrison, 011687793\n" +
                   "Wing Hung Lau, 010927657\n" + "Nelly Liu Peng, 010180248");
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
    }
}