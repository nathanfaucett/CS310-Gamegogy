package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;


public class StudentTest {
    Student student;
    
    @Before
	public void setUp() {
        String[] info = {"111111","Jerrod","Shields","jshields"};
		student = new Student(info);
	}
    
    @Test
	public void testIDSetCorrectly() {
		assertEquals("111111", student.getID());
	}
    
    @Test
	public void testFirstNameSetCorrectly() {
		assertEquals("Jerrod", student.getFirstName());
	}
    
    @Test
	public void testLastNameSetCorrectly() {
		assertEquals("Shields", student.getLastName());
	}
    
    @Test
	public void testEmailSetCorrectly() {
		assertEquals("jshields", student.getEmail());
	}
        
    @Test
    public void testToString() {
        assertEquals("[111111] Jerrod Shields jshields@jsu.edu", student.toString());
    }
    
    @Test
    public void testConstructor() {
        Student s = new Student("111111","Jerrod","Shields","jshields");
        assertEquals("[111111] Jerrod Shields jshields@jsu.edu", s.toString());
    }
}