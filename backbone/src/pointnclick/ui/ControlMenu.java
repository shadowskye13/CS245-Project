
package pointnclick.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * @author nliupeng
 */
public class ControlMenu extends JFrame {

    private StartupPanel startupPanel;

    public ControlMenu(){
        startupPanel = new StartupPanel();
        
        initGUI();
        start();
    }

    private void initGUI(){
        System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());

        setTitle("CS 245 - Point N Click");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new IntroPanel());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        startTimerForGameStartup(3);
    }

    private void startTimerForGameStartup(int seconds) {
        Timer t = new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(startupPanel);
                validate();
                pack();
            }
        });
        t.setRepeats(false);
        t.setInitialDelay(seconds*1000);
        t.start();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ControlMenu cm = new ControlMenu();
                cm.setVisible(true);
            }
        });
    }
}