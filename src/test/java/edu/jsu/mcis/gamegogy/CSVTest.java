package edu.jsu.mcis.gamegogy;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;


public class CSVTest {
        
    @Test
    public void testListIsMade() {
    List<String[]> list = CSVlocal.fileReader("courses.csv");
    String[] arrayToCheckAgainst = {"99000","Spring","2013","11"};
    String[] arrayFromList = list.get(1);
    assertArrayEquals(arrayToCheckAgainst, arrayFromList);
    }
        
    @Test
	public void testListIsNotMade() {
        List<String[]> list = CSVlocal.fileReader("BLEEEP.csv");
        assertTrue(list.isEmpty());
	}
}
