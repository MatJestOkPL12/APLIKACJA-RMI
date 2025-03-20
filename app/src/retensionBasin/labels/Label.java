package retensionBasin.labels;

import javax.swing.*;

public class Label {


    JLabel adress = new JLabel("Adres");
    JLabel port = new JLabel("Port");
    JLabel name = new JLabel("Nazwa");
    JLabel capacity = new JLabel("Objętość");

    public Label(JPanel panel){

        adress.setBounds(5,10,60,20);
        port.setBounds(5,40,60,20);
        name.setBounds(5,70,60,20);
        capacity.setBounds(0,100,60,20 );

        panel.add(adress);
        panel.add(port);
        panel.add(name);
        panel.add(capacity);

    }

}
