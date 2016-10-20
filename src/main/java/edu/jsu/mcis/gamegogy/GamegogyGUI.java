package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamegogyGUI extends JFrame{
    private Gamegogy gamegogy;
    private Course[] courseObjs;
    /*
        TODO: remove assignment of empty string set
    */
    private String[] courseAssignments = {" "};

    public GamegogyGUI() {
        gamegogy = new Gamegogy();
        Dimension dim = getPreferredSize();
        
        courseObjs = (Course[])gamegogy.findAll("course");
        /*
            TODO: add function to get course assignments
        */
        //CourseGrades[] courseAssigments = gamegogy.;

        JFrame mainFrame= new JFrame();
        
        JPanel selectionPanel = 
                new SelectionPanel(courseObjs, courseAssignments);
        JPanel leaderboardPanel = 
                new LeaderboardPanel();
        JPanel infoPanel = 
                new InformationPanel();
        
        mainFrame.add(selectionPanel);
        mainFrame.add(leaderboardPanel);
        mainFrame.add(infoPanel);
    }

    @Override
    public final Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) {
        JFrame frame = new GamegogyGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
    }
}