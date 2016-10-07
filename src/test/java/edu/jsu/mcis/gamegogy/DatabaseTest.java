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
        Student testStudent = new Student(info);
        
        Student dataStudent = database.getStudent("111111");
        
        assertEquals(testStudent.getID(), dataStudent.getID());
        assertEquals(testStudent.getFirstName(), dataStudent.getFirstName());
        assertEquals(testStudent.getLastName(), dataStudent.getLastName());
        assertEquals(testStudent.getEmail(), dataStudent.getEmail());
    }
    
    @Test
    public void testGetCourse() {
        String[] info = {"99000","Spring","2013","11"};
		Course testCourse = new Course(info);
        
        Course dataCourse = database.getCourse("99000");
        
        assertEquals(testCourse.getID(), dataCourse.getID());
        assertEquals(testCourse.getSemester(), dataCourse.getSemester());
        assertEquals(testCourse.getYear(), dataCourse.getYear());
        assertEquals(testCourse.getEnrolled(), dataCourse.getEnrolled());
    }
    
    @Test
    public void testGetStudentFromMiddle() {
        String[] info = {"111232","Isidro","Thomas","ithomas"};
        Student testStudent = new Student(info);
        
        Student dataStudent = database.getStudent("111232");
        
        assertEquals(testStudent.getID(), dataStudent.getID());
        assertEquals(testStudent.getFirstName(), dataStudent.getFirstName());
        assertEquals(testStudent.getLastName(), dataStudent.getLastName());
        assertEquals(testStudent.getEmail(), dataStudent.getEmail());
    }
    
    @Test
    public void testGetCourseFromMiddle() {
        String[] info = {"99019","Fall","2013","20"};
		Course testCourse = new Course(info);
        
        Course dataCourse = database.getCourse("99019");
        
        assertEquals(testCourse.getID(), dataCourse.getID());
        assertEquals(testCourse.getSemester(), dataCourse.getSemester());
        assertEquals(testCourse.getYear(), dataCourse.getYear());
        assertEquals(testCourse.getEnrolled(), dataCourse.getEnrolled());
    }
    
    @Test
    public void testGetStudentFromEnd() {
        String[] info = {"111410","Rory","Dominguez","rdominguez"};
        Student testStudent = new Student(info);
        
        Student dataStudent = database.getStudent("111410");
        
        assertEquals(testStudent.getID(), dataStudent.getID());
        assertEquals(testStudent.getFirstName(), dataStudent.getFirstName());
        assertEquals(testStudent.getLastName(), dataStudent.getLastName());
        assertEquals(testStudent.getEmail(), dataStudent.getEmail());
    }
}