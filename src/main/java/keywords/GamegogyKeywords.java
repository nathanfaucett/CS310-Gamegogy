package keywords;


import edu.jsu.mcis.gamegogy.*;


public class GamegogyKeywords {
    private Gamegogy g;
    String type;
    String id;
    
    public void startGamegogyCLIWithArguments(String a, String b) {
        g = new Gamegogy();
        type = a;
        id = b;
    }
    
    public String getCommandLineOutput(){
        return g.findByID(a,b);
    }