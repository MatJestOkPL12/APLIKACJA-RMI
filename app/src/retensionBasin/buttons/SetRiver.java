package retensionBasin.buttons;

import interfaces.IRetensionBasin;
import interfaces.IRiverSection;
import retensionBasin.Basin;
import retensionBasin.Main;
import retensionBasin.logic.TankLife;
import retensionBasin.textFields.RiverName;
import retensionBasin.textFields.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SetRiver {

    JButton setRiver = new JButton("Podłącz do rzeki");

    public SetRiver(JPanel panel, RiverName riverName, TextField textField, Basin basin, Main main){

        setRiver.setBounds(530,40,140,20);


        setRiver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TankLife tankLife = new TankLife(textField,main, basin );
                tankLife.start();

                String river = riverName.getText();

                String [] data = textField.getText();

                String host = data[0];
                String name = data[2];
                int port = Integer.parseInt(data[1]);

                try {
                    Registry registry = LocateRegistry.getRegistry(host,port);

                    IRiverSection irs = (IRiverSection) registry.lookup(river);

                    IRetensionBasin retensionBasin = basin;

                    irs.assignRetensionBasin(basin, name);


                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        panel.add(setRiver);


    }

}
