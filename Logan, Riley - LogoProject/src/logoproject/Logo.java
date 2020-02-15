/**
 * @author Riley Logan
 * IT251-2001A-01
 * Intermediate Java Programming I
 * Prof. Anthony Lowe
 */

package logoproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.JPanel;


public class Logo extends JPanel {
    
    private final int xPad = 0; // horizontal padding
    private final int yPad = 10; // vertical padding
    private int reamY; // ream graphic vertical offset
    private int reamX; // ream graphic horizontal offset
    
    Color blueShade = new Color(58 ,95 ,135); // ream graphic
    Color blueTint =  new Color(171,207,250); // ream graphic
    
    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1; // graphics object
        Dimension d = this.getSize(); // get window size
        Random r = new Random(); // this is random
        
        this.coveredSlogan(g, r, d); // option 1
//        this.barSlogan(g, r, d); // option 2

    } //> > end of paint method
    
    
    /*
    *   Slogan option 1: Got you covered!
    */
    private void coveredSlogan(Graphics2D g, Random r, Dimension d){
        g.setColor(Color.white);
        Font f = g.getFont();
        Font logoFont = new Font(f.getFontName(), Font.BOLD, f.getSize() + 22);
        g.setFont(logoFont);
        g.drawString("Dunder Mifflin Paper Co", xPad + 100, yPad + 200);
        Font sloganFont = new Font(f.getFontName(), 0, f.getSize() + 16);
        g.setFont(sloganFont);
        g.drawString("We got you covered.", xPad + 160, yPad + 300);
        this.drawReam(g, r.nextInt((int) d.getWidth()), r.nextInt((int) d.getHeight()));
    }
    
    /*
    *   Slogan option 2: Raising the bar.
    */
    private void barSlogan(Graphics2D g, Random r, Dimension d){
        g.setColor(Color.white);
        Font f = g.getFont();
        Font logoFont = new Font(f.getFontName(), Font.BOLD, f.getSize() + 22);
        g.setFont(logoFont);
        g.drawString("Dunder Mifflin Paper Co", xPad + 100, yPad + 200);
        Font sloganFont = new Font(f.getFontName(), 0, f.getSize() + 16);
        g.setFont(sloganFont);
        g.drawString("Raising the bar.", xPad + 190, yPad + 300);
        this.drawReam(g, reamX, reamY);
    }
    
    /*
    *   updateReams() controls the behavior for barSlogan();
    */
    public void updateReams(){
        reamY -= 9;
        Random r = new Random();
        Dimension d = this.getSize(); // get window size
        if (reamY < 0){ // if at top of screen
            reamY = (int) d.getHeight(); // then begin at bottom again
            reamX = r.nextInt((int) d.getWidth());
            // this is the point where i want to make (x,y) random, so the next
            // stack of reams begins in a new area.
        }
    }
    
    /*
    *   The following methods that create one "ream" of paper are separated from
    *   one another so g.fill(path); doesn't spill all over previously drawn areas.
    */
    private void drawReam(Graphics2D g, int x, int y){
        this.drawReamSides(g, x, y);
        this.drawReamFrontEdge(g, x, y);
        this.drawReamTop(g, x, y);
        this.drawReamMockText(g, x, y);
    }
    
    private void drawReamSides(Graphics2D g, int x, int y){
        GeneralPath path = new GeneralPath();
        
        path.moveTo(x+5,  y+3 ); // top corner
        path.lineTo(x-20, y+24); // left top corner 
        path.lineTo(x-20, y+32); // left bottom corner
        path.lineTo(x+20, y+55); // bottom bottom corner
        path.lineTo(x+45, y+35); // right bottom corner
        path.lineTo(x+45, y+27); // right top corner
        path.lineTo(x+5,  y+3 ); // return to beginning
        
        g.setColor(blueShade);
        g.fill(path);
    }
    
    private void drawReamTop(Graphics2D g, int x, int y){
        GeneralPath path = new GeneralPath();
        
        path.moveTo(x+5,  y+3 ); // top corner
        path.lineTo(x-20, y+24); // left top corner 
        path.lineTo(x+20, y+47); // bottom top corner
        path.lineTo(x+45, y+27); // right top corner
        path.lineTo(x+5,  y+3 ); // return to beginning
        
        g.fill(path);
    }
    
    private void drawReamFrontEdge(Graphics2D g, int x, int y){
        GeneralPath path = new GeneralPath();
        
        path.moveTo(x+20, y+47); // bottom top corner
        path.lineTo(x+20, y+55); // bottom bottom corner
        
        g.setColor(blueTint);
        g.draw(path);
    }
    
    private void drawReamMockText(Graphics2D g, int x, int y){
        GeneralPath path = new GeneralPath();
        
        // line 1
        path.moveTo(x-2,  y+28);
        path.lineTo(x+14, y+15);
        // line 2
        path.moveTo(x+4,  y+30);
        path.lineTo(x+18, y+19);
        
        g.setColor(blueShade);
        g.draw(path);
    }
} // end of Logo class
    
    

// >> EXAMPLES & VARIANCES <<
  // > Diamond stuff
    /*
    private void drawDiamond(Graphics2D g, int x, int z){
        GeneralPath path = new GeneralPath();
        z /= 2;
        int y = x;
        path.moveTo(x, y-z); // top
        path.lineTo(y-z, x); // left
        path.lineTo(x, y+z); // bottom
        path.lineTo(x+z, y); // right
        path.lineTo(x, y-z); // top
        g.setColor(lilac);
        g.fill(path);
    }
    */
    
    /*
    private boolean showDiamond; // design shower/hider variable
    */
    
    /*
    Color purple = new Color(50,45,90); // diamond graphic
    Color lilac = new Color(139,120,171); // diamond graphic
    */
    
    /*
    public boolean isShowDiamond() {
        return showDiamond;
    }

    public void setShowDiamond(boolean showDiamond) {
        this.showDiamond = showDiamond;
    }
    */
    
    /*
    if (showDiamond){
        this.drawDiamond(g, 300, 400); // (Graphics2D object, centerpoint coordinates, height)
    }
    */
    
  // > Other stuff
    /*
    private void companyName(Graphics2D g, int x, int y){
        // may not need this one
    }
    */
    
    /*
    private void drawPaper(Graphics2D g, int x, int y){
        GeneralPath path =  new GeneralPath();
        
        g.setColor(blueTint);
        
        path.moveTo(x+13, y);
        path.lineTo(x,    y);
        path.lineTo(x,    y+30);
        path.lineTo(x+18, y+30);
        path.lineTo(x+18, y+5);
        path.lineTo(x+13, y+5);
        path.lineTo(x+13, y);
        path.lineTo(x+18, y+5);
        
        g.draw(path);
    }
    */
    
// g.setColor(Color.gray); // set as native color
// final Color PURPLE = new Color(50,45,90); // example of unchanging color
    
    /*
//  Background
  NOTE: not used becasue it overwrites my animation.
        g.setColor(Color.white);
        g.fillRect(0, 0, (int) d.getWidth(), (int) d.getHeight()); // fill window size with color
    */