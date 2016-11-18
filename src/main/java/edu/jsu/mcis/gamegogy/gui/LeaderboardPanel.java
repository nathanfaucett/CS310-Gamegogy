package edu.jsu.mcis.gamegogy.gui;

import edu.jsu.mcis.gamegogy.CourseGrades;
import java.awt.Color;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class LeaderboardPanel extends JPanel 
        implements ComponentListener, MouseListener{
    public ArrayList<Bar> barArray = new ArrayList();
    private InformationPanel infoPanel;
    private Bar currentBar;
    
    public LeaderboardPanel(InformationPanel informationPanel) {
        this.infoPanel = informationPanel;
        
        GridLayout grid = new GridLayout(0,1);
        this.setLayout(grid);
        
        addMouseListener(this);
        addComponentListener(this);
    }
    
    public void refreshPanel(int assignmentIndexSelected, CourseGrades grades) {
        removeAll();
        //String[] assignments = grades.getAssignments();
        List<String[]> gradeList = 
                grades.getAll(grades.getAssignments()[assignmentIndexSelected]);
        barArray = new ArrayList<>();
        float highestGrade = Float.parseFloat((gradeList.get(0))[1]);
        
        for (String[] grade : gradeList) {
            float studentScore = Float.parseFloat(grade[1]);
            barArray.add(new Bar(highestGrade, studentScore, grade[0]));
        }
        
        barArray.get(0).barColor = Color.blue;
        currentBar = barArray.get(0);
        
        for (Bar bar : barArray) {
            add(bar);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        
        if (currentBar != null) {
            currentBar.barColor = Color.GREEN;
            currentBar.repaint();
        }
        
        Bar bar = (Bar)getComponentAt(x, y);
        currentBar = bar;
        currentBar.barColor = Color.BLUE;
        currentBar.repaint();
        infoPanel.setLabels(bar.id, bar.score);
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
