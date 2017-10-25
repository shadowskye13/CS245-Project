/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SamanthaRose
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EndScreen extends JPanel{
    private JButton endButton;
    private JLabel finalScoreLabel;
    private int score;
    
    public EndScreen(int score) {
        this.setSize(new Dimension(600,400));
        this.setBackground(new Color(200,200,200));
        
        this.score = score;
        checkScore(score);
        initComponents();
        
    }
    
    private void initComponents() {
        endButton = new JButton("Back");
        endButton.setSize(new Dimension(100,50));
        endButton.setLocation(500, 500);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                backToMenuScreen();
            }
        });
        add(endButton);
        
        finalScoreLabel = new JLabel();
        finalScoreLabel.setText("End of Game.");
        finalScoreLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalScoreLabel.setSize(new Dimension(200,100));
        finalScoreLabel.setFont(new java.awt.Font("Trattatello",0,16));
        add(finalScoreLabel);
    }
    
    private void checkScore(int i) {
        try {
            File file = new File("highscores.txt");
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            int lineCount = 0;
            String scoreString;
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
            e.getMessage();
        }
    }
    private void changeScores(int line,int score) {
        String name = (String)JOptionPane.showInputDialog(this,"Please enter your name: ",null);
        name += ". . ." + score;
        try {
            Path file = Paths.get("highscores.txt");
            List<String> lines = Files.readAllLines(file);
            lines.set(line, name);
            Files.write(file, lines);
        }
        catch(IOException e) {
            e.getMessage();
        }
    }
    
    private void backToMenuScreen() {
        JPanel menuScreen = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, this);
        menuScreen.removeAll();
        menuScreen.add(new MenuScreen());
        menuScreen.revalidate();
        menuScreen.repaint();
    }
}
