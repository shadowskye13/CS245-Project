/**
 * file: MainAction.java
 * author: S. Harrison, N. Peng, W. Lau
 * class: CS245 Programming Graphical User Interfaces
 * 
 * assignment: Quarter Project v1.0
 * date last modified: 10/9/17
 * 
 * purpose: This is the main JFrame in which the game
 * is to be displayed.
 */
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class MainAction extends javax.swing.JFrame{
    private TitlePanel titlePanel = new TitlePanel();
    
    /**
     * method: MainAction
     * purpose: This is the default constructor for the
     * MainAction class. This method creates a JFrame 
     * to hold the game display.
     */
    public MainAction(String name) {
        super(name);
        initGUI();
    }

    /**
     * method: initGUI
     * purpose: This method initializes the GUI.
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(titlePanel);
        setSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * method: main
     * purpose: This method starts the main executable
     * that starts the program.
     */
    public static void main(String args[]) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainAction("Hangman").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
