package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class SelectionPanel extends JPanel implements ActionListener {
    private String[] courseAssignments, courseIDs;
    private Course[] courseObjs;
    private JLabel courseTerm, courseEnrollment,
            courseTermLabel, courseEnrollmentLabel,
            courseBoxLabel, assignmentBoxLabel;
    private JComboBox courseBox, assignmentBox;
    public int selectedCourse = 0, selectedAssignment = 0;
    private Database database;
    private CourseGrades grades;
    
    public SelectionPanel(Course[] courseObjects, Database d) {
        this.database = d;
        courseObjs = courseObjects;
        String[] courseAssignments = new String[1];
        courseIDs = new String[courseObjects.length];
        
        for(int i = 0; i < courseObjects.length; i++) {
            courseIDs[i] = courseObjects[i].getID();
        }
        
        courseBox = new JComboBox(courseIDs);
        courseBox.setName("CourseBox");
        assignmentBox = new JComboBox(courseAssignments);
        assignmentBox.setName("AssignmentBox");
        
        courseBoxLabel = new JLabel();
        assignmentBoxLabel = new JLabel();
        courseTerm = new JLabel();
        courseTermLabel = new JLabel();
        courseEnrollment = new JLabel();
        courseEnrollmentLabel = new JLabel();

        courseBox.setSelectedIndex(0);
        assignmentBox.setSelectedIndex(0);
        courseBoxLabel.setText("Course ");
        assignmentBoxLabel.setText("Column ");
        courseTermLabel.setText("Term: ");
        courseEnrollmentLabel.setText("Enrollment: ");

        courseBox.addActionListener(this);
        assignmentBox.addActionListener(this);

        GridLayout grid = new GridLayout(0,4);
        grid.setHgap(20);
        this.setLayout(grid);
        
        add(courseBoxLabel);
        add(courseBox);
        add(assignmentBoxLabel);
        add(assignmentBox);
        add(courseTermLabel);
        add(courseTerm);
        add(courseEnrollmentLabel);
        add(courseEnrollment);
        
        courseBoxUtilized();
    }
    
    public void refreshCourseAssignments(int courseIndexSelected) {
        selectedAssignment = 0;
        assignmentBox.setSelectedItem(selectedAssignment);
        grades = database.getGrades(courseObjs[courseIndexSelected].getID());
        GamegogyGUI.setSelectedAssignment(selectedAssignment, grades);
        assignmentBox.removeAllItems();
        String[] assignments = grades.getAssignments();
        for (String assignment : assignments) {
            assignmentBox.addItem(assignment);
        }
    }

    private void refreshLabels(int courseIndexSelected) {
        courseTerm.setText(
            courseObjs[courseIndexSelected].getSemester() 
            + " " + courseObjs[courseIndexSelected].getYear()
            );
        
        courseEnrollment.setText(
            courseObjs[courseIndexSelected].getEnrolled()
            );
        
        selectedCourse = courseIndexSelected;
    }
    
    private void courseBoxUtilized() {
        int courseIndexSelected = courseBox.getSelectedIndex();
        refreshLabels(courseIndexSelected);
        refreshCourseAssignments(courseIndexSelected);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox activeComboBox = (JComboBox) event.getSource();
        
        if (activeComboBox.getName().equals("CourseBox")) {
            courseBoxUtilized();
        } 
        else if (activeComboBox.getName().equals("AssignmentBox")) {
            GamegogyGUI.setSelectedAssignment(selectedAssignment, grades);
        }
        
    }
}
