/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.gamegogy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class Connection {
    //private static String baseURL = "http://inspired.jsu.edu:7272/gamegogy/";
    private static String baseURL = "http://localhost:8080/";
   // private String relativeURL = "";
    
    public static String createConnection(String relativeURL) {
        String absoluteURL = baseURL + relativeURL;
        
        try {
            StringBuilder result = new StringBuilder();
            URL url;
            if (baseURL != null) {
                url = new URL(absoluteURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                return result.toString();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Failed";
    }
    
    public static void setBaseURL(String b) {
        baseURL = b;
    }
    
}
