package edu.jsu.mcis.gamegogy;

import java.awt.*;
import javax.swing.*;

public class GamegogyGUI extends JFrame{

    
    private Database database;
    private Course[] courseObjs;
    private static SelectionPanel selectionPanel;
    private static LeaderboardPanel leaderboardPanel;
    private static InformationPanel infoPanel;

    public GamegogyGUI() {
        database = new Database();
        setPreferredSize(new Dimension(400, 500));
        courseObjs = (Course[])database.getAllCourses();
        this.setTitle("Gamegogy");
        
        infoPanel = new InformationPanel(database);
        leaderboardPanel = new LeaderboardPanel(infoPanel);
        selectionPanel = new SelectionPanel(courseObjs, database, this);
        
        BorderLayout frameLayout = new BorderLayout();
        frameLayout.setVgap(10);
        this.setLayout(frameLayout);
        
        JScrollPane scrollPane = new JScrollPane(leaderboardPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        this.add(selectionPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
    }
    
    public void setSelectedAssignment(int assignmentIndexSelected,
            CourseGrades grades) {
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