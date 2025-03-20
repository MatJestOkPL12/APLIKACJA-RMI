package controlCenter.graph.textField;

import javax.swing.*;

public class TextField {

    JTextField adress = new JTextField("localhost");
    JTextField port = new JTextField("100");
    JTextField name = new JTextField("Centrala");

    public TextField(JPanel panel){

        adress.setBounds(60,10,80,20);
        port.setBounds(60,40,80,20);
        name.setBounds(60,70,80,20);

        panel.add(adress);
        panel.add(port);
        panel.add(name);

    }

    public String[] getText(){
        String [] buff = new String[3];

        buff[0] = adress.getText();
        buff[1] = port.getText();
        buff[2] = name.getText();

        return buff;
    }
}
