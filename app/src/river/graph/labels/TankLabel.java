package river.graph.labels;

import javax.swing.*;

public class TankLabel {

    JLabel label = new JLabel("Zbiornik");

    public TankLabel(JPanel panel){

        label.setBounds(360,40,80,20);

        panel.add(label);


    }

}
