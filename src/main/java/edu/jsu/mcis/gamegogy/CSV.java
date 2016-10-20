package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;
import au.com.bytecode.opencsv.*;
//import org.json.simple.*;
//import org.json.simple.parser.*;

public class CSV {
    
    public static List<String[]> fileReader(File file) {
        CSVParser parser = new CSVParser();
        List<String[]> record = new ArrayList<>();
        
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufReader.readLine()) != null ) {
                String[] lineData = parser.parseLine(line);
                
                record.add(lineData);
            }
            
            return record;
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return record;
    }
    
}