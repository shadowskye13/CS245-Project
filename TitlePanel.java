/**
 * file: TitlePanel.java
 * author: S. Harrison, N. Peng, W. Lau
 * class: CS245 Programming Graphical User Interfaces
 * 
 * assignment: Quarter Project, v1.0
 * date last modified: 10/9/17
 * 
 * purpose: This program presents the initial title page
 * containing the team name and project name. This program
 * presents a page that appears for three seconds and cues
 * the main menu screen to appear.
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TitlePanel extends JPanel implements ActionListener{
    /**
     * method: TitlePanel
     * purpose: This method creates an instance of the
     * title screen to be displayed. It also initiates
     * a timer to go off after three seconds to transition
     * to the menu screen.
     */
    public TitlePanel() {
        initComponents();
        this.setSize(new Dimension(600,400));
        
        Timer timer = new Timer(1000,this);
        timer.setInitialDelay(3000);
        timer.setRepeats(false);
        timer.start();
    }
    
    /**
     * method: actionPerformed
     * purpose: This method handles the action of the
     * timer going off by taking the user to the main
     * menu screen.
     */
    public void actionPerformed(ActionEvent e) {
        this.removeAll();
        this.add(new MenuScreen());
        this.revalidate();
        this.repaint();
    }

    /**
     * method: initComponents
     * purpose: This method initializes all the components
     * of the title screen to be displayed.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Trattatello", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CS245 Group Project");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setLocation(new java.awt.Point(200, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Trattatello", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("by The GUIneers");
        jLabel2.setAlignmentX(1.0F);
        jLabel2.setAlignmentY(1.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
