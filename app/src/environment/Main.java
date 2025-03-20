package environment;

import environment.graph.AddButton;
import environment.graph.Label;
import environment.graph.TextField;

import javax.swing.*;

public class Main {
    JPanel panel;

    public static void main(String[] args) {

        Main main = new Main();
        Environment environment = new Environment(main);
        main.makeGui(environment);

    }


    private void makeGui(Environment environment){
        JFrame frame = new JFrame();
        frame.setTitle("Environment");
        frame.setSize(400,400);
        frame.setLocation(500,500);
        panel = new JPanel();
        Label label = new Label(panel);
        TextField textField = new TextField(panel);
        AddButton addButton = new AddButton(panel, textField,environment);




        panel.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);
    }

    public JPanel getPanel(){
        return panel;
    }

}
