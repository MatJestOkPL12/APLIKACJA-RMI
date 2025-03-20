package river.graph.labels;

import javax.swing.*;

public class TankInfo {

    JLabel tankInfo = new JLabel("Podłączony zbiornik:");
    JLabel tankType = new JLabel("Brak podłączonego zbiornika");
    JPanel panel;

    public TankInfo(JPanel panel){
        this.panel = panel;
        tankInfo.setBounds(270,120, 120,20);
        tankType.setBounds(250,150,200,20);


        panel.add(tankInfo);
        panel.add(tankType);


    }

    public void updateType(String name){

        tankType.setBounds(300,150,200,20);
        tankType.setText(name);

        panel.revalidate();
        panel.repaint();

    }


}
