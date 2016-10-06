package edu.jsu.mcis.gamegogy;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;


public class CSVTest {
        
    @Test
	public void testListIsMade() {
		List<String[]> list = CSV.fileReader(new File("src/main/java/resources/courses.csv"));
        String[] arrayToCheckAgainst = {"99000","Spring","2013","11"};
        String[] arrayFromList = list.get(0);
        assertArrayEquals(arrayToCheckAgainst, arrayFromList);
	}
}
