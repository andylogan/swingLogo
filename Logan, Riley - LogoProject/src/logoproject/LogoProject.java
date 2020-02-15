/**
 * @author Riley Logan
 * IT251-2001A-01
 * Intermediate Java Programming I
 * Prof. Anthony Lowe
 */
package logoproject;

import java.awt.Color;
import javax.swing.JFrame;

public class LogoProject {

    public static void main(String[] args) {
        JFrame window = new JFrame("Watch out for paper cuts."); // title bar
        window.setBounds(100,100,600,600); // (horizontal offset from screen 1 corner, vertical offset from screen 1 corner, width, height)
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // otherwise will keep running on close
        
        Logo logo = new Logo();
        window.add(logo);
        
        Animator a = new Animator(logo);
        
        window.setVisible(true); // i seeeee you
        window.setBackground(Color.white);
    }
    
}
