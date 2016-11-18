package edu.jsu.mcis.gamegogy.gui;

import edu.jsu.mcis.gamegogy.CSVResource;
import edu.jsu.mcis.gamegogy.Database;
import edu.jsu.mcis.gamegogy.JSONResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SourceMenu extends JMenu implements ActionListener{
    private JRadioButtonMenuItem csvSwitch, jsonSwitch;
    private Database database;
    private SelectionPanel selectionPanel;

    public SourceMenu(boolean defaultToCSV, Database db,
            SelectionPanel sp){
        this.database = db;
        this.selectionPanel = sp;
        this.setName("Source");
        this.setText("Source");

        csvSwitch = new JRadioButtonMenuItem();
        csvSwitch.setText("Resource File");
        csvSwitch.setName("Resource File");
        jsonSwitch = new JRadioButtonMenuItem();
        jsonSwitch.setText("Web Service");
        jsonSwitch.setName("Web Service");

        if (defaultToCSV) {
            csvSwitch.setSelected(true);
        } else {
            jsonSwitch.setSelected(true);
        }

        csvSwitch.addActionListener(this);
        jsonSwitch.addActionListener(this);

        ButtonGroup switchGroup = new ButtonGroup();
        switchGroup.add(csvSwitch);
        switchGroup.add(jsonSwitch);

        this.add(csvSwitch);
        this.add(jsonSwitch);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JRadioButtonMenuItem activeRadioButton = (JRadioButtonMenuItem) event.getSource();

        if (activeRadioButton.getName().equals("Web Service")) {
            csvSwitch.setSelected(false);
            jsonSwitch.setSelected(true);

            this.database.load(new JSONResource());
            selectionPanel.courseBoxUtilized();
            selectionPanel.refreshCourses();
        } else if (activeRadioButton.getName().equals("Resource File")) {
            csvSwitch.setSelected(true);
            jsonSwitch.setSelected(false);

            this.database.load(new CSVResource());
            //these functions should probably be moved outside of SelectionPanel
            selectionPanel.courseBoxUtilized();
            selectionPanel.refreshCourses();
        }
    }
}
