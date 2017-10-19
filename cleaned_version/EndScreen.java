/***************************************************************
* file: EndScreen.java
* author: Samantha Rose, Wing Hung Lau, Nelly Liu Peng
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project v.1.1
* date last modified: 10/18/2017
*
* purpose: This panel shows the end screen displaying an user's
* score after a game
****************************************************************/


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EndScreen extends JPanel{
    private JButton back;
    private JLabel endGame;

    public EndScreen(int score) {
        checkScore(score);
        initComponents();
        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(200,200,200));
    }

    private void initComponents() {
        back = new JButton("Back");
        back.setSize(new Dimension(100,50));
        back.setLocation(500, 500);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                backToMenuScreen();
            }
        });
        add(back);

        endGame = new JLabel();
        endGame.setText("End of Game.");
        endGame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        endGame.setSize(new Dimension(200,100));
        endGame.setFont(new java.awt.Font("Trattatello",0,16));
        add(endGame);
    }

    /**
     * Checks the score the player currently has and if higher than
     * those from the highscores.txt file, then prompt the user to
     * input its name
     */
    private void checkScore(int i) {
        try {
            // Retrieve directory file path
            Path currentRelativePath = Paths.get("");
            String filePath = currentRelativePath.toAbsolutePath().toString() + "/src/highscores.txt";

            // Read from highscores file
            File file = new File(filePath);
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);

            String line, scoreString;
            int lineCount = 0;
            while((line = buffer.readLine()) != null) {
                scoreString = line.substring(line.lastIndexOf('.') + 1);
                if(i > Integer.parseInt(scoreString)) {
                    changeScores(lineCount,i);
                    break;
                }
                lineCount++;
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads the highscores.txt file and adds new high score
     */
    private void changeScores(int line, int score) {
        String name = (String)JOptionPane.showInputDialog(this,"Please enter your name: ",null);
        name += ". . ." + score;
        try {
            // Retrieve directory file path
            String filePath = Paths.get("").toAbsolutePath().toString() + "/src/highscores.txt";
            Path file = Paths.get(filePath);
            List<String> lines = Files.readAllLines(file);
            lines.set(line, name);
            Files.write(file, lines);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Return to menu screen
     */
    private void backToMenuScreen() {
        JPanel menuScreen = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, this);
        menuScreen.removeAll();
        menuScreen.add(new MenuScreen());
        menuScreen.revalidate();
        menuScreen.repaint();
    }
}