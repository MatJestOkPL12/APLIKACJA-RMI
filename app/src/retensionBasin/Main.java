package retensionBasin;


import retensionBasin.buttons.AddButton;
import retensionBasin.buttons.AddToCentral;
import retensionBasin.buttons.SetRiver;
import retensionBasin.labels.ConntectedRivers;
import retensionBasin.labels.Discharge;
import retensionBasin.labels.Label;
import retensionBasin.labels.RiverLabel;
import retensionBasin.textFields.RiverName;
import retensionBasin.textFields.TextField;

import javax.swing.*;
import javax.swing.plaf.SplitPaneUI;

public class Main {

    Discharge discharge;
    JPanel panel;
    RiverName riverName;

    public static void main(String[] args) {
        Main main = new Main();
        Basin basin = new Basin(main);
        main.makeGui(basin, main);
    }


    private void makeGui(Basin basin, Main main){
        JFrame frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);

        Label label = new Label(panel);
        TextField textField = new TextField(panel);
        AddButton addButton = new AddButton(panel,textField, basin);
        AddToCentral addToCentral = new AddToCentral(panel, textField, basin);
        RiverLabel riverLabel = new RiverLabel(panel);
        riverName = new RiverName(panel);
        SetRiver setRiver = new SetRiver(panel,riverName, textField, basin, main);
        ConntectedRivers conntectedRivers = new ConntectedRivers(panel);
        discharge = new Discharge(panel);




        frame.setSize(700,400);
        frame.setTitle("Retension Basin");



        frame.setLocation(300,300);
        frame.add(panel);
        frame.setVisible(true);
    }

    public Discharge getDischarge(){
        return discharge;
    }
    public JPanel getPanel(){
        return panel;
    }
    public RiverName getRiverName(){
        return riverName;
    }

}
