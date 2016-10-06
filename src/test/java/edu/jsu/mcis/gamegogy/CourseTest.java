package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;


public class CourseTest {
    Course course;
    
    @Before
	public void setUp() {
        String[] info = {"99000","Spring","2013","11"};
		course = new Course(info);
	}
    
    @Test
	public void testIDSetCorrectly() {
		assertEquals("99000", course.getID());
	}
    
    @Test
	public void testSemesterSetCorrectly() {
		assertEquals("Spring", course.getSemester());
	}
    
    @Test
	public void testYearSetCorrectly() {
		assertEquals("2013", course.getYear());
	}
    
    @Test
	public void testEnrolledSetCorrectly() {
		assertEquals("11", course.getEnrolled());
	}
}