/**
 * @author Riley Logan
 * IT251-2001A-01
 * Intermediate Java Programming I
 * Prof. Anthony Lowe
 */
package logoproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Animator implements ActionListener {
    
    private final Logo logo;
    private int count;
    private final int frequency = 25; // milliseconds
    private final int duration = 2; // mod inside actionPerformed method

    public Animator(Logo logo) {
        this.logo = logo;
        Timer t = new Timer(frequency, this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        logo.updateReams();
        /*
        count += 1;
        if (count % duration == 0){
            logo.setShowDiamond(true);
        } else {
            logo.setShowDiamond(false);
        }
        */
        logo.repaint();
        
    }
    
}
