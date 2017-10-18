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

public class EndScreen extends JPanel{
    private JButton back;
    private JLabel endGame;
    
    public EndScreen(int score) {
        checkScore(score);
        initComponents();
        //this.setLayout(new BorderLayout());
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
                removeAll();
                add(new MenuScreen());
                revalidate();
                repaint();
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
}
