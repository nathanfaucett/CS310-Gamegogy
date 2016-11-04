package edu.jsu.mcis.gamegogy.GUI;

import edu.jsu.mcis.gamegogy.Course;
import edu.jsu.mcis.gamegogy.CourseGrades;
import edu.jsu.mcis.gamegogy.Database;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SelectionPanel extends JPanel implements ActionListener {
    private String[] courseIDs;
    private Course[] courseObjs;
    private JLabel courseTerm, courseEnrollment,
            courseTermLabel, courseEnrollmentLabel,
            courseBoxLabel, assignmentBoxLabel,
            csvSwitchLabel, jsonSwitchLabel;
    private JComboBox courseBox, assignmentBox;
    public int selectedCourse = 0, selectedAssignment = 0;
    private Database database;
    private CourseGrades grades;
    private GamegogyGUI gamegogyGUI;
    private JRadioButton csvSwitch, jsonSwitch;
    
    public SelectionPanel(Course[] courseObjects, Database db, GamegogyGUI gamegogyGUI) {
        this.database = db;
        this.gamegogyGUI = gamegogyGUI;
        courseObjs = courseObjects;
        String[] courseAssignments = new String[1];
        courseIDs = new String[courseObjects.length];
        
        for(int i = 0; i < courseObjects.length; i++) {
            courseIDs[i] = courseObjects[i].getID();
        }
        
        ButtonGroup databaseSwitchGroup = new ButtonGroup();
        csvSwitchLabel = new JLabel("Resource File: ");
        csvSwitch = new JRadioButton();
        jsonSwitchLabel = new JLabel("Web Service:");
        jsonSwitch = new JRadioButton();
        databaseSwitchGroup.add(csvSwitch);
        databaseSwitchGroup.add(jsonSwitch);
        
        courseBox = new JComboBox(courseIDs);
        courseBox.setName("CourseBox");
        assignmentBox = new JComboBox(courseAssignments);
        assignmentBox.setName("AssignmentBox");
        
        courseBoxLabel = new JLabel();
        assignmentBoxLabel = new JLabel();
        
        courseTerm = new JLabel();
        courseTerm.setName("courseTerm");
        courseTermLabel = new JLabel();
        
        courseEnrollment = new JLabel();
        courseEnrollment.setName("courseEnrollment");
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
        
        add(csvSwitchLabel);
        add(csvSwitch);
        add(jsonSwitchLabel);
        add(jsonSwitch);
        
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
        gamegogyGUI.setSelectedAssignment(selectedAssignment, grades);
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
            selectedAssignment = assignmentBox.getSelectedIndex();
            if (selectedAssignment == -1) {
                selectedAssignment = 0;
            }
            gamegogyGUI.setSelectedAssignment(selectedAssignment, grades);
        }
    }
}
