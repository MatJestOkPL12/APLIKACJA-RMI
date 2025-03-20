package controlCenter;

import controlCenter.graph.button.AddButton;
import controlCenter.graph.labels.Label;
import controlCenter.graph.textField.TextField;

import javax.swing.*;

public class Main {

    JPanel panel;

    public static void main(String[] args) {
        Main main = new Main();
        Central central = new Central(main);
        main.makeGui(central);
    }

    private void makeGui(Central central){
        JFrame frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);


        Label label = new Label(panel);
        TextField textField = new TextField(panel);
        AddButton addButton = new AddButton(panel, textField, central);



        frame.setTitle("Control Center");
        frame.setLocation(100,100);
        frame.setSize(500,500);




        frame.add(panel);
        frame.setVisible(true);
    }

    public JPanel getPanel(){
        return panel;
    }


}
