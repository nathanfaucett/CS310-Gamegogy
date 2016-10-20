package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class SelectionPanel extends JPanel implements ActionListener {
    private String[] courseAssignments, courseIDs;
    private Course[] courseObjs;
    private JLabel courseTerm, courseEnrollment;
    
    public SelectionPanel(Course[] courseObjects, String[] assignments) {
        courseObjs = courseObjects;
        courseAssignments = assignments;
        courseIDs = new String[courseObjects.length];
        
        for(int i = 0; i < courseObjects.length; i++) {
            courseIDs[i] = courseObjects[i].getID();
        }
        
        JComboBox course = new JComboBox(courseIDs);
        JComboBox courseWork = new JComboBox(courseAssignments);
        courseTerm = new JLabel();
        courseEnrollment = new JLabel();

        course.setSelectedIndex(0);
        courseWork.setSelectedIndex(0);
        courseTerm.setText("Term: ");
        courseEnrollment.setText("Enrollment: ");

        course.addActionListener(this);
        courseWork.addActionListener(this);

        courseTerm.setBorder
            (BorderFactory.createEmptyBorder(0, 20, 0, 0));
        courseEnrollment.setBorder
            (BorderFactory.createEmptyBorder(0, 0, 0, 20));
        course.setBorder
            (BorderFactory.createEmptyBorder(0, 50, 0, 0));
        courseWork.setBorder
            (BorderFactory.createEmptyBorder(0, 0, 0, 50));
        GridLayout grid = new GridLayout(0,2);
        grid.setHgap(100);
        
        this.setLayout(grid);
        
        add(course);
        add(courseWork);
        add(courseTerm);
        add(courseEnrollment);
    }
    
    public void refreshCourseAssignments() {
        /*
            TODO: write code for retrieving a new set of course assignments
        */
    }

    public void updateLabels(int courseIndexSelected) {
        courseTerm.setText(
            "Term: " + courseObjs[courseIndexSelected].getSemester() 
            + " " + courseObjs[courseIndexSelected].getYear()
            );
        
        courseEnrollment.setText(
            "Enrollment: " + courseObjs[courseIndexSelected].getEnrolled()
            );
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox activeComboBox = (JComboBox) event.getSource();
        int selectedItem = activeComboBox.getSelectedIndex();
        updateLabels(selectedItem);
        refreshCourseAssignments();
    }
}
