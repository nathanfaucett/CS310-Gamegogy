package edu.jsu.mcis.gamegogy;

import org.junit.*;
import static org.junit.Assert.*;

public class ConnectionTest {
    @Test
    public void testCreateConnectionToStudentList(){
        String output = Connection.createConnection("studentlist");
        assertEquals("111111", output.substring(2, 8));
    }
    
    @Test
    public void testCreateConnectionToStudent(){
        String output = Connection.createConnection("student/111111");
        assertEquals("{\"id\":\"111111\",\"first\":\"Jerrod\",\"last\":\"Shields\",\"email\":\"jshields\"}", output);
    }
}
