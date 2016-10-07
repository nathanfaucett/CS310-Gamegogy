package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;


public class GamegogyTest {
    Gamegogy g;
    
    @Before
    public void setUp(){
        g = new Gamegogy();    
    }
    
   @Test
    public void testFindSingleStudent() {
        String student = "[111111] Jerrod Shields jshields@jsu.edu";
        Object pulledStudent = g.findByID("students","111111");
        assertEquals(student, pulledStudent.toString() );
    }

    @Test
    public void testFindAllStudents() {
        Object[] pulledStudents = g.findAll("students");
        assertEquals(299, pulledStudents.length - 1 );
    }
    
    public void testFindSingleCourse() {
        String course = "[99000] Spring 2013 (11 students)";
        Object pulledCourse = g.findByID("courses","99000");
        assertEquals(course, pulledCourse.toString() );
    }
    
    public void testFindAllCourses() {
        Object[] pulledCourses = g.findAll("courses");
        assertEquals(24, pulledCourses.length - 1);
    }
    
    
    
}
