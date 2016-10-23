package edu.jsu.mcis.gamegogy;

import com.sun.java.accessibility.util.AWTEventMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LeaderboardPanel extends JPanel implements ComponentListener, MouseListener{
    private ArrayList<Bar> barArray = new ArrayList();
    
    public LeaderboardPanel() {
        Bar b = new Bar(100, 85);
        Bar b2 = new Bar(100, 60);
        Bar b3 = new Bar(100, 20);
        Bar b4 = new Bar(100, 100);
        
        barArray.add(b);
        barArray.add(b2);
        barArray.add(b3);
        barArray.add(b4);
        
        setPreferredSize(new Dimension( 400,25 * barArray.size()));
        
        for (Bar bar : barArray) {
            add(bar);
//            JLabel barlabel = new JLabel();
//            barlabel.setText("Bloop");
//            barlabel.setVerticalAlignment(JLabel.TOP);
//            add(barlabel);
        }
        
        GridLayout grid = new GridLayout(0,1);
        this.setLayout(grid);
        
        addMouseListener(this);
        addComponentListener(this);
    }
    
    public static void refreshPanel(int assignmentIndexSelected) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        System.out.println("Clicked at: " + x
                + " " + y + " On bar " + getComponentAt(x, y));
    }
    @Override
    public void mousePressed(MouseEvent event) {}
    @Override
    public void mouseReleased(MouseEvent event) {}
    @Override
    public void mouseEntered(MouseEvent event) {}
    @Override
    public void mouseExited(MouseEvent event) {}
    
    @Override
    public void componentResized(ComponentEvent e) {
    }
    @Override
    public void componentMoved(ComponentEvent e) {
    }
    @Override
    public void componentShown(ComponentEvent e) {
    }
    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
