package edu.jsu.mcis.gamegogy.gui;

import edu.jsu.mcis.gamegogy.Course;
import edu.jsu.mcis.gamegogy.CourseGrades;
import edu.jsu.mcis.gamegogy.Database;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("unchecked") 
public class SelectionPanel extends JPanel implements ActionListener {
    private String[] courseIDs;
    private Course[] courseObjects;
    private JLabel courseTerm, courseEnrollment,
            courseTermLabel, courseEnrollmentLabel,
            courseBoxLabel, assignmentBoxLabel;
    public JComboBox courseBox, assignmentBox;
    public int selectedCourse = 0, selectedAssignment = 0;
    private Database database;
    private CourseGrades grades;
    private GamegogyGUI gamegogyGUI;
    
    public SelectionPanel(Database db, 
            GamegogyGUI gamegogyGUI, boolean defaultToCSV) {
        this.database = db;
        this.gamegogyGUI = gamegogyGUI;
        
        courseObjects = database.getAllCourses();
        courseIDs = new String[courseObjects.length];

        for(int i = 0; i < courseObjects.length; i++) {
            courseIDs[i] = courseObjects[i].getID();
        }
        
        String[] courseAssignments = new String[1];
        
        courseBox = new JComboBox(courseIDs);
        courseBox.setName("CourseBox");
        assignmentBox = new JComboBox(courseAssignments);
        assignmentBox.setName("AssignmentBox");
        
        refreshCourses();
        
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
        grades = database.getGrades(courseObjects[courseIndexSelected].getID());
        gamegogyGUI.setSelectedAssignment(selectedAssignment, grades);
        assignmentBox.removeAllItems();
        String[] assignments = grades.getAssignments();
        for (String assignment : assignments) {
            assignmentBox.addItem(assignment);
        }
    }

    public void refreshLabels(int courseIndexSelected) {
        courseTerm.setText(
            courseObjects[courseIndexSelected].getSemester() 
            + " " + courseObjects[courseIndexSelected].getYear()
            );
        
        courseEnrollment.setText(
            courseObjects[courseIndexSelected].getEnrolled()
            );
        
        selectedCourse = courseIndexSelected;
    }
    
    public void courseBoxUtilized() {
        int courseIndexSelected = courseBox.getSelectedIndex();
        if (courseIndexSelected < 0) {
            courseIndexSelected = 0;
        }
        refreshLabels(courseIndexSelected);
        refreshCourseAssignments(courseIndexSelected);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JComboBox) {
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
        
    public void refreshCourses() {
        courseObjects = (Course[])database.getAllCourses();
        
        courseIDs = new String[courseObjects.length];

        for(int i = 0; i < courseObjects.length; i++) {
            courseIDs[i] = courseObjects[i].getID();
        }
        
        courseBox.removeAllItems();
        for (String course : courseIDs) {
            courseBox.addItem(course);
        }
        
        selectedCourse = 0;
        courseBox.setSelectedItem(0);
    }
}
