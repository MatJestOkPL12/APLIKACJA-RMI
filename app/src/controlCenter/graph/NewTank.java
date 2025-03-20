package controlCenter.graph;

import interfaces.IRetensionBasin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class NewTank {

    JLabel nameL = new JLabel();
    JTextField discharge = new JTextField();
    JButton setDischarge = new JButton("Ustaw Przepływ");
    JLabel percentage = new JLabel("0%");
    JPanel panel;


    public NewTank(JPanel panel, String name, int y, IRetensionBasin irb){

        this.panel = panel;

        nameL.setText(name);
        nameL.setBounds(5,y, 100,20);
        discharge.setBounds(90,y,100,20);
        setDischarge.setBounds(220,y,150,20);
        percentage.setBounds(410,y,50,20);

        setDischarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dischargeValue = Integer.parseInt(discharge.getText());

                try {
                    irb.setWaterDischarge(dischargeValue);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });



        panel.add(nameL);
        panel.add(discharge);
        panel.add(setDischarge);
        panel.add(percentage);

        panel.revalidate();
        panel.repaint();


    }


    public void updatePercentage(long percentage){

        this.percentage.setText(String.valueOf(percentage)+"%");
        panel.revalidate();
        panel.repaint();


    }

}
