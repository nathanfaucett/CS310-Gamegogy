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
        Bar b = new Bar(200, 85);
        Bar b2 = new Bar(200, 60);
        Bar b3 = new Bar(200, 20);
        Bar b4 = new Bar(200, 100);
        Bar b5 = new Bar(200, 50);
        
        barArray.add(b);
        barArray.add(b2);
        barArray.add(b3);
        barArray.add(b4);
        barArray.add(b5);
        
        setPreferredSize(new Dimension( 400,25 * barArray.size()));
        
        for (Bar bar : barArray) {
            add(bar);
        }
        
        GridLayout grid = new GridLayout(0,1);
        this.setLayout(grid);
        
        addMouseListener(this);
        addComponentListener(this);
    }
    
    public void refreshPanel(int assignmentIndexSelected, CourseGrades grades) {
        
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
