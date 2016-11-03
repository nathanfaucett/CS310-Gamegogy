package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;
import au.com.bytecode.opencsv.*;

public class CSVlocal {
    
    //reconfigure to run on strings instead of files
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
    
    
    /*
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        StringBuffer csvContents = new StringBuffer();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getResourceAsStream("grades.csv")))) {
            String line;
            while((line = reader.readLine()) != null) {
                csvContents.append(line + '\n');
            }
        }
        catch(IOException e) { e.printStackTrace(); }
        String testCsv = csvContents.toString();
    */
    
}