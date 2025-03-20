package tailor.graph;

import javax.swing.*;

public class PortArea {

    JTextField port = new JTextField("100");

    public PortArea(JPanel panel){

        port.setBounds(150,10,100,20);

        panel.add(port);

    }


    public String getPort(){
        return port.getText();
    }

}
