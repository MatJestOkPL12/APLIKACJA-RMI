package river.graph.labels;

import javax.swing.*;

public class WaterFromBasin {

    JLabel label = new JLabel("Woda otrzymana ze zbiornika");
    JLabel value = new JLabel("0");
    JPanel panel;

    public WaterFromBasin(JPanel panel){

        this.panel = panel;


        label.setBounds(480,120, 180,20);
        value.setBounds(550,150,50,20);


        panel.add(label);
        panel.add(value);

    }

    public void updateVale(int value){

        this.value.setText(String.valueOf(value));


        panel.revalidate();
        panel.repaint();
    }

}
