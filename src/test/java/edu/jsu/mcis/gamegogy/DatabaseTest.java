package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;


public class DatabaseTest {
    private Database database;
    
    @Before
    public void setUp() {
        database = new Database(new CSVResource());
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
        Student dataStudent = new Student(info);
        
        Student testStudent = database.getStudent("111410");
        
        assertEquals(testStudent.getID(), dataStudent.getID());
        assertEquals(testStudent.getFirstName(), dataStudent.getFirstName());
        assertEquals(testStudent.getLastName(), dataStudent.getLastName());
        assertEquals(testStudent.getEmail(), dataStudent.getEmail());
    }
    
    @Test
    public void testGetStudentFromReturnedArray() {
        Student[] array = database.getAllStudents();
        Student dataStudent = array[0];
        
        Student testStudent = database.getStudent("111111");
        
        assertEquals(testStudent.getID(), dataStudent.getID());
        assertEquals(testStudent.getFirstName(), dataStudent.getFirstName());
        assertEquals(testStudent.getLastName(), dataStudent.getLastName());
        assertEquals(testStudent.getEmail(), dataStudent.getEmail());
    }
    
    @Test
    public void testGetCourseFromReturnedArray() {
        Course[] array = database.getAllCourses();
		Course dataCourse = array[0];
        
        Course testCourse = database.getCourse("99000");
        
        assertEquals(testCourse.getID(), dataCourse.getID());
        assertEquals(testCourse.getSemester(), dataCourse.getSemester());
        assertEquals(testCourse.getYear(), dataCourse.getYear());
        assertEquals(testCourse.getEnrolled(), dataCourse.getEnrolled());
    }
    
    @Test
    public void testGetRandomAssignmentFromFront() {
        CourseGrades courseGrades = database.getGrades("99000");
        assertEquals("43.0", courseGrades.getGrades("111262", "Assignment 9"));
    }
    
    @Test
    public void testGetTotalFromMiddle() {
        CourseGrades courseGrades = database.getGrades("99017");
        assertEquals("845.0", courseGrades.getGrades("111224", "Total"));
    }
}