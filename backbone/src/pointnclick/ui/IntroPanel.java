package pointnclick.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author nliupeng
 */
class IntroPanel extends JPanel {

    private JLabel projectLabel = new JLabel();
    private JLabel teamLabel = new JLabel();

    public IntroPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        this.setBackground(new Color(0, 0, 0));
        this.setForeground(new Color(51, 51, 51));
        this.setPreferredSize(new java.awt.Dimension(600, 400));
        this.setVisible(true);
    }

    private void initComponents() {
        projectLabel = new JLabel();
        teamLabel = new JLabel();

        projectLabel.setBackground(new Color(0, 0, 0));
        projectLabel.setFont(new Font("Century", 0, 36)); 
        projectLabel.setForeground(new Color(255, 255, 255));
        projectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectLabel.setText("CS 245 Quarter Project");

        teamLabel.setBackground(new Color(0, 0, 0));
        teamLabel.setFont(new Font("Tahoma", 0, 14)); 
        teamLabel.setForeground(new Color(255, 255, 255));
        teamLabel.setText("By: The GUIneers");

        // Set component properties

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(projectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(teamLabel)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(projectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(teamLabel)
                .addGap(86, 86, 86))
        );
    }

}