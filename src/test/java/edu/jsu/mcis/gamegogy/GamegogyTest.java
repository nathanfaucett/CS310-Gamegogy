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
        Student pulledStudent = (Student) g.findByID("student","111111");
        assertEquals(student, g.toString(pulledStudent) );
    }

    @Test
    public void testFindAllStudents() {
        Student[] pulledStudents = (Student[]) g.findAll("student");
        assertEquals(299, pulledStudents.length - 1 );
    }
    
    @Test
    public void testFindSingleCourse() {
        String course = "[99000] Spring 2013 (11 students)";
        Course pulledCourse = (Course) g.findByID("course","99000");
        assertEquals(course, g.toString(pulledCourse) );
    }
    
    @Test
    public void testFindAllCourses() {
        Course[] pulledCourses = (Course[]) g.findAll("course");
        assertEquals(24, pulledCourses.length - 1);
    }
    
    
    
}
