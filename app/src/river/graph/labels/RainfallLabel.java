package river.graph.labels;

import javax.swing.*;

public class RainfallLabel {

    JLabel rainfall = new JLabel("Ilość opadów w rzece: ");
    JLabel rainfallValue = new JLabel("0");
    JPanel panel;


    public RainfallLabel(JPanel panel){

        this.panel = panel;

        rainfall.setBounds(70, 120,140,20);
        rainfallValue.setBounds(135,150,40,20);


        panel.add(rainfall);
        panel.add(rainfallValue);
    }

    public void uptadeRainfallValue(int rainfall){

        rainfallValue.setText(String.valueOf(rainfall));

        panel.revalidate();
        panel.repaint();


    }

}
