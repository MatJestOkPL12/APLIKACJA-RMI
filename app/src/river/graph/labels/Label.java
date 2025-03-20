package river.graph.labels;

import javax.swing.*;

public class Label {
    JLabel adress = new JLabel("Adres");
    JLabel port = new JLabel("Port");
    JLabel name = new JLabel("Nazwa");

    public Label(JPanel panel){

        adress.setBounds(5,10,60,20);
        port.setBounds(5,40,60,20);
        name.setBounds(5,70,60,20);

        panel.add(adress);
        panel.add(port);
        panel.add(name);

    }
}
