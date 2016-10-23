package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamegogyGUI extends JFrame{
    private Gamegogy gamegogy;
    private Course[] courseObjs;
    private String[] courseAssignments = {" "};
    /*
        TODO: remove assignment of empty string set
    */

    public GamegogyGUI() {
        gamegogy = new Gamegogy();
        Dimension dim = getPreferredSize();
        courseObjs = (Course[])gamegogy.findAll("course");
        this.setTitle("Gamegogy");
        /*
            TODO: add function to get course assignments
        */
        //CourseGrades[] courseAssigments = gamegogy.;
        
        SelectionPanel selectionPanel = 
                new SelectionPanel(courseObjs, courseAssignments);
        LeaderboardPanel leaderboardPanel = 
                new LeaderboardPanel();
        InformationPanel infoPanel = 
                new InformationPanel();
        
        BorderLayout frameLayout = new BorderLayout();
        frameLayout.setVgap(10);
        this.setLayout(frameLayout);
        
        this.add(selectionPanel, BorderLayout.NORTH);
        this.add(leaderboardPanel, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
    }
    
    public static void setSelectedAssignment(int assignmentIndexSelected) {
        LeaderboardPanel.refreshPanel(assignmentIndexSelected);
        InformationPanel.refreshPanel(assignmentIndexSelected);
    }

    public static void main(String[] args) {
        GamegogyGUI frame = new GamegogyGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
    }
}