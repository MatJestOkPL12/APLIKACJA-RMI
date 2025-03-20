package retensionBasin.buttons;

import interfaces.IRetensionBasin;
import interfaces.ITailor;
import retensionBasin.Basin;
import retensionBasin.Main;
import retensionBasin.logic.TankLife;
import retensionBasin.textFields.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AddButton {

    JButton button = new JButton("Dodaj do serwera");

    public AddButton(JPanel panel, TextField textField, Basin basin){

        button.setBounds(180,40,150,20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String [] data = textField.getText();

            String host = data[0];
            int port = Integer.parseInt(data[1]);
            String name = data[2];

            basin.setCapacity(Integer.parseInt(textField.getCapacity()));




                try {
                    IRetensionBasin irb = (IRetensionBasin) UnicastRemoteObject.exportObject(basin,0);
                    Registry registry = LocateRegistry.getRegistry(host,port);
                    registry.rebind(name,irb);
                    ITailor tailor = (ITailor) registry.lookup("Tailor");
                    tailor.register(basin,name);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });



        panel.add(button);
    }

}
