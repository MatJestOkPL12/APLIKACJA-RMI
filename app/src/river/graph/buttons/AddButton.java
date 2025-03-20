package river.graph.buttons;

import interfaces.IRiverSection;
import interfaces.ITailor;
import river.River;
import river.graph.texfields.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AddButton {

    JButton addButton = new JButton("Dodaj do serwera");

    public AddButton(JPanel panel, TextField textField, River river1){

        addButton.setBounds(180,40,150,20);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] data = textField.getText();
                String addres = data[0];
                int port = Integer.parseInt(data[1]);

                try {
                    River river = river1;
                    String name = data[2];
                    IRiverSection irs = (IRiverSection) UnicastRemoteObject.exportObject(river, 0);
                    Registry registry = LocateRegistry.getRegistry(addres, port);
                    registry.rebind(name, irs);
                    ITailor tailor = (ITailor) registry.lookup("Tailor");
                    tailor.register(river,name);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        panel.add(addButton);


    }




}
