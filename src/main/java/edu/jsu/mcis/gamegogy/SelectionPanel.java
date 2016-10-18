/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.gamegogy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Nathan
 */
public class SelectionPanel extends JPanel implements ActionListener {
    private String[] courseAssignments, courseIDs;
    
    public SelectionPanel(String[] courseIdentifiers, String[] assignments) {
        courseIDs = courseIdentifiers;
        courseAssignments = assignments;
        
        JComboBox course = new JComboBox(courseIDs);
        JComboBox courseWork = new JComboBox(courseAssignments);

        course.setSelectedIndex(0);
        courseWork.setSelectedIndex(0);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
