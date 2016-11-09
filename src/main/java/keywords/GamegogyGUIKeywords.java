package keywords;

import edu.jsu.mcis.gamegogy.GUI.*;

import org.netbeans.jemmy.operators.JComponentOperator;
import org.netbeans.jemmy.ComponentChooser;
import java.awt.Component;

import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.swing.context.Context;

import org.netbeans.jemmy.operators.JMenuItemOperator;
import org.netbeans.jemmy.operators.ContainerOperator;
import javax.swing.JMenuItem;

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
    
    @RobotKeyword("Returns whether the given radio button menu item is selected.\n")
    @ArgumentNames({"menuItemText"})
    public boolean radioButtonMenuItemIsSelected(String menuItemText) {
        ContainerOperator context = (ContainerOperator)Context.getContext();
        JMenuItemOperator operator = new JMenuItemOperator(context, menuItemText);
        JMenuItem item = (JMenuItem)operator.getSource();
        return item.isSelected();
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
