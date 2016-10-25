package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InformationPanel extends JPanel {
    private JLabel id, name, email, score,
            idLabel, nameLabel, emailLabel, scoreLabel;
    private Database database;
    
    public InformationPanel(Database db) {
        this.database = db;
        
        id = new JLabel();
        name = new JLabel();
        email = new JLabel();
        score = new JLabel();
        idLabel = new JLabel();
        nameLabel = new JLabel();
        emailLabel = new JLabel();
        scoreLabel = new JLabel();
        
        idLabel.setText("ID: ");
        nameLabel.setText("Name: ");
        emailLabel.setText("Email: ");
        scoreLabel.setText("Score: ");
        
        GridLayout grid = new GridLayout(0,2);
        grid.setHgap(20);
        this.setLayout(grid);
        
        add(idLabel);
        add(id);
        add(nameLabel);
        add(name);
        add(emailLabel);
        add(email);
        add(scoreLabel);
        add(score);
    }
    
    public void refreshPanel(int assignmentIndexSelected, CourseGrades grades) {
        System.out.println(assignmentIndexSelected);
        String[] assignments = grades.getAssignments();
        String[] highestGrade = grades.getHighest(assignments[assignmentIndexSelected]);
        Student currentStudent = database.getStudent(highestGrade[0]);
        id.setText(currentStudent.getID());
        name.setText(currentStudent.getFirstName() + " " 
                + currentStudent.getLastName());
        email.setText(currentStudent.getEmail() + "@jsu.edu");
        score.setText(highestGrade[1]);
    }
    
    public void setLabels(String studentID, float grade){
        Student currentStudent = database.getStudent(studentID);
        id.setText(currentStudent.getID());
        name.setText(currentStudent.getFirstName() + " " 
                + currentStudent.getLastName());
        email.setText(currentStudent.getEmail() + "@jsu.edu");
        score.setText("" + grade);
    }
    
}
