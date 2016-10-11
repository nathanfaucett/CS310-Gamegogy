package keywords;


import edu.jsu.mcis.gamegogy.*;


public class GamegogyKeywords {
    private Gamegogy g;
    String type;
    String id;
    String ids;

    public void startGamegogyCLIWithArguments(String a, String b) {
        g = new Gamegogy();
        type = a;
        id = b;
    }
    public void startGamegogyCLIWithArguments() {
        g = new Gamegogy();
        type = null;
        id = null;
    }
    public void startGamegogyCLIWithArguments(String a) {
        g = new Gamegogy();
        ids = a;
    }

    public String getCommandLineOutput(){
        if (ids != null) {
            String out = "";

            if (ids.equals("studentids")) {
                Student[] objects = (Student[]) g.findAll("student");
                out = objects[0].getID();

                for(int i = 1; i < objects.length; i++) {
                    out += '\n' + objects[i].getID();
                }
            } else if (ids.equals("courseids")) {
                Course[] objects = (Course[]) g.findAll("course");
                out = objects[0].getID();

                for(int i = 1; i < objects.length; i++) {
                    out += '\n' + objects[i].getID();
                }
            }
            return out;
        } else if (type == null) {
            return "";
        } else {
            return g.findByID(type,id).toString();
        }
    }
}
