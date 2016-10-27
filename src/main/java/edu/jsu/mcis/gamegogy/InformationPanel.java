package edu.jsu.mcis.gamegogy;

import java.awt.*;
import javax.swing.*;

public class InformationPanel extends JPanel {
    private JLabel id, name, email, score;
    private Database database;
    
    public InformationPanel(Database db) {
        this.database = db;
        
        id = new JLabel();
        id.setName("studentId");
        name = new JLabel();
        name.setName("studentName");
        email = new JLabel();
        email.setName("studentEmail");
        score = new JLabel();
        score.setName("studentScore");
        
        GridLayout grid = new GridLayout(0,1);
        grid.setHgap(20);
        this.setLayout(grid);
        
        add(id);
        add(name);
        add(email);
        add(score);
    }
    
    public void refreshPanel(int assignmentIndex, CourseGrades grades) {
        System.out.println(assignmentIndex);
        String[] assignments = grades.getAssignments();
        String[] highestGrade = grades.getHighest(assignments[assignmentIndex]);
        Student currentStudent = database.getStudent(highestGrade[0]);
        id.setText("ID: " + currentStudent.getID());
        name.setText("Name: " + currentStudent.getFirstName() + " " 
                + currentStudent.getLastName());
        email.setText("Email: " + currentStudent.getEmail() + "@jsu.edu");
        score.setText("Score: " + highestGrade[1]);
    }
    
    public void setLabels(String studentID, float grade){
        Student currentStudent = database.getStudent(studentID);
        id.setText("ID: " + currentStudent.getID());
        name.setText("Name: " + currentStudent.getFirstName() + " " 
                + currentStudent.getLastName());
        email.setText("Email: " + currentStudent.getEmail() + "@jsu.edu");
        score.setText("Score: " +grade);
    }
    
}
