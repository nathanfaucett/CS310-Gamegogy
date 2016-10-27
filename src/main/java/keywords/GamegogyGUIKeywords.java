package keywords;

import edu.jsu.mcis.gamegogy.GUI.Bar;
import edu.jsu.mcis.gamegogy.GUI.LeaderboardPanel;
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
        ContainerOperator context = (ContainerOperator) Context.getContext();
        ComponentChooser chooser = new CustomPanelChooser();
        JComponentOperator operator = new JComponentOperator(context, chooser);
        LeaderboardPanel panel = (LeaderboardPanel)operator.getSource();
        Bar b = (Bar)panel.barArray.get(index);
        int componentX = b.getX();
        int componentY = b.getY();
        operator.clickMouse(componentX, componentY, 1);
    }

    class CustomPanelChooser implements ComponentChooser {
        public CustomPanelChooser() {}
        public boolean checkComponent(Component comp) {
            return (comp instanceof LeaderboardPanel);
        }
        public String getDescription() {
            return "Leaderboard Panel";
        }
    }
    
}
