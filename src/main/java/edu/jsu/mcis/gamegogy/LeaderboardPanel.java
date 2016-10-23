package edu.jsu.mcis.gamegogy;

import com.sun.java.accessibility.util.AWTEventMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LeaderboardPanel extends JPanel implements MouseListener{
    private ArrayList<Bar> barArray = new ArrayList();
    private Dimension dim = this.getSize();
    
    public LeaderboardPanel() {
        Bar b = new Bar(100, 85);
        Bar b2 = new Bar(100, 60);
        Bar b3 = new Bar(100, 20);
        
        barArray.add(b);
        barArray.add(b2);
        barArray.add(b3);
        
        setPreferredSize(new Dimension( 400,25 * barArray.size()));
        
        for (Bar bar : barArray) {
            add(bar);
            JLabel barlabel = new JLabel();
            barlabel.setText("Bloop");
            barlabel.setVerticalAlignment(JLabel.TOP);
            add(barlabel);
        }
        
        GridLayout grid = new GridLayout(0,2);
        this.setLayout(grid);
        addMouseListener(this);
    }
    
    public static void refreshPanel(int assignmentIndexSelected) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        System.out.println("Clicked at: " + x + " " + y);
    }
    public void mousePressed(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
}
