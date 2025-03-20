package environment.graph;

import interfaces.IRiverSection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class NewRiver {

    JLabel riverName = new JLabel();
    JTextField rainfall = new JTextField();
    JButton setRainfall = new JButton("Ustaw Opady");
    IRiverSection irs;

    public NewRiver(JPanel panel, String name, int y, IRiverSection irs){

        this.irs = irs;

    riverName.setText(name);
    riverName.setBounds(5, y, 60,20);
    rainfall.setBounds(90,y, 100,20);
    setRainfall.setBounds(220,y,150,20);

    setRainfall.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int rainfallValue = Integer.parseInt(rainfall.getText());
            try {
                irs.setRainfall(rainfallValue);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }


        }
    });


    panel.add(riverName);
    panel.add(rainfall);
    panel.add(setRainfall);

    panel.revalidate();
    panel.repaint();
    }

}
