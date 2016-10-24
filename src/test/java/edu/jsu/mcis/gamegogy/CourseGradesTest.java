package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;


public class CourseGradesTest {
    CourseGrades courseGrades;
    
    @Before
    public void setUp() {
        List<String[]> info = CSV.fileReader(new File("src/main/java/resources/courses/99000.csv"));;
		courseGrades = new CourseGrades(info);
    }
    
    @Test
    public void testGetGradesForStudent() {
        assertEquals("43", courseGrades.getGrades("111262", "Assignment 9"));
    }
    
    @Test
    public void testGetHighestGradeForAssignment() {
        String[] data = {"111310", "66"};
        assertEquals(data, courseGrades.getHighest("Assignment 9"));
    }
    
    @Test
    public void testGetAllGradesForAssignment() {
        List<String[]> data = courseGrades.getAll("Assignment 9");
        String[] highest = {"111310", "66"};
        assertEquals(highest, data.get(0));
        String[] fourthHighest = {"111335", "49"};
        assertEquals(fourthHighest, data.get(3));
    }
    
    @Test
    public void testGetAssignments() {
        String[] assignments = {"Total","Assignment 1","Assignment 2","Assignment 3","Assignment 4","Assignment 5",
                            "Assignment 6","Assignment 7","Assignment 8","Assignment 9","Exam 1"};
        assertEquals(assignments, courseGrades.getAssignments());
    }
}