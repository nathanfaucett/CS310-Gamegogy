package keywords;

import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.swing.context.Context;

import org.netbeans.jemmy.operators.JComponentOperator;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.ComponentChooser;
import java.awt.Component;
import java.awt.Shape;
import java.awt.Rectangle;

import edu.jsu.mcis.gamegogy.*;

public class GamegogyGUIKeywords {

    @RobotKeyword("Clicks the leaderboard bar given by index.\n")
    @ArgumentNames({"index"})
    public void clickLeaderboardBarAtIndex(int index) {
        
    }

    
}
