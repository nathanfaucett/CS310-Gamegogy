package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamegogyGUI extends JFrame{

    
    private Database database;
    private Course[] courseObjs;
    private static CourseGrades currentCourseGrades;
    private static SelectionPanel selectionPanel;
    private static LeaderboardPanel leaderboardPanel;
    private static InformationPanel infoPanel;

    public GamegogyGUI() {
        database = new Database();
        Dimension dim = getPreferredSize();
        courseObjs = (Course[])database.getAllCourses();
        this.setTitle("Gamegogy");
        
        selectionPanel = new SelectionPanel(courseObjs, database);
        leaderboardPanel = new LeaderboardPanel();
        infoPanel = new InformationPanel();
        
        BorderLayout frameLayout = new BorderLayout();
        frameLayout.setVgap(10);
        this.setLayout(frameLayout);
        
        this.add(selectionPanel, BorderLayout.NORTH);
        this.add(leaderboardPanel, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
    }
    
    public static void setSelectedAssignment(int assignmentIndexSelected,
            CourseGrades grades) {
        /*
        TODO: setting coursegrades for gamegogoyGUI is pointless if it is
        passed to all other panels.
        */
        currentCourseGrades = grades;
        leaderboardPanel.refreshPanel(assignmentIndexSelected, grades);
        infoPanel.refreshPanel(assignmentIndexSelected, grades);
    }

    public static void main(String[] args) {
        GamegogyGUI frame = new GamegogyGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
    }
}