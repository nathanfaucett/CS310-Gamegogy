package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamegogyGUI extends JPanel implements ActionListener{
	private Gamegogy gamegogy;
	private String[] coursesIDs;
	private String[] courseAssignments = {" "};
	
	public GamegogyGUI() {
		
		Dimension dim = getPreferredSize();
		
		gamegogy = new Gamegogy();
		
		Course[] courseObjs = (Course[])gamegogy.findAll("course");
		//Todo add function to get course assignments
		//CourseGrades[] courseAssigments = gamegogy;
		
		for(int i = 0; i < courseObjs.length; i++) {
			courseIDs[i] = courseObjs[i].getID(); 
		}
		
		JComboBox course = new JComboBox(courseObjs);
		JComboBox courseWork = new JComboBox(courseAssignments);
		
		course.setSelectedIndex(0);
		courseWork.setSelectedIndex(0);
		
		course.addActionListener(this);
		courseWork.addActionListener(this);
		
		add(course);
		add(courseWork);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void refreshCoureAssignments() {
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
	
	public static void main(String[] args) {
		GamegogyGUI panel = new GamegogyGUI();
		JFrame frame = new JFrame("Gamegogy");
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack(); 

	}
}