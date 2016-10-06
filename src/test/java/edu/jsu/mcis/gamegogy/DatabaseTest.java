package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;


public class DatabaseTest {
    Database database;
    
    @Before
    public void setUp() {
        database = new Database();
    }
    
    @Test
    public void testGetStudent() {
        String[] info = {"111111","Jerrod","Shields","jshields"};
        Student student = new Student(info);
        
        assertEquals(student, database.getStudent("111111"));
    }
    
    @Test
    public void testGetCourse() {
        String[] info = {"99000","Spring","2013","11"};
		Course course = new Course(info);
        
        assertEquals(course, database.getCourse("99000"));
    }
}