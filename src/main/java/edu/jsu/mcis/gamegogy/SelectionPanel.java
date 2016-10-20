package edu.jsu.mcis.gamegogy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SelectionPanel extends JPanel implements ActionListener {
    private String[] courseAssignments, courseIDs;
    private Course[] courseObjs;
    private JLabel courseTerm, courseEnrollment;
    
    public SelectionPanel(Course[] courseObjects, String[] assignments) {
        courseObjs = courseObjects;
        courseAssignments = assignments;
        
        
        for(int i = 0; i < courseObjs.length; i++) {
            courseIDs[i] = courseObjs[i].getID(); 
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

        add(course);
        add(courseWork);
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
