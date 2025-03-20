package river.graph.buttons;

import interfaces.IRetensionBasin;
import interfaces.IRiverSection;
import retensionBasin.Basin;
import river.River;
import river.graph.texfields.TankChoice;
import river.graph.texfields.TextField;
import river.logic.RiverLife;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddToTank {

    JButton button = new JButton("Dodaj do zbiornika");


    public AddToTank(JPanel panel, TankChoice tankChoice, TextField textField, River river){

        button.setBounds(530,40,140,20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tankName = tankChoice.getText();
                String [] data = textField.getText();
                String host = data[0];
                int port = Integer.parseInt(data[1]);
                String name = data[2];

                try {
                    Registry registry = LocateRegistry.getRegistry(host,port);

                    IRetensionBasin basin = (IRetensionBasin) registry.lookup(tankName);
                    IRiverSection riverSection = river;
                    basin.assignRiverSection(riverSection, name);

                    RiverLife riverLife = new RiverLife(textField, tankChoice, river);
                    riverLife.start();

                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });


        panel.add(button);

    }


}
