package edu.jsu.mcis.gamegogy;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class LeaderboardPanel extends JPanel{
    private Bar[] barArray;
    private Dimension dim = this.getSize();
    
    public LeaderboardPanel() {
        
        Bar b = new Bar(dim, 100, 85);
        Bar b2 = new Bar(dim, 100, 60);
        Bar b3 = new Bar(dim, 100, 60);
        
        GridLayout grid = new GridLayout(0,2);
        this.setLayout(grid);
        
        add(b);
        add(b2);
        add(b3);
    }
    
    public static void refreshPanel(int assignmentIndexSelected) {
        
    }
}
