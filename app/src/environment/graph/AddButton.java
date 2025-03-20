package environment.graph;

import environment.Environment;
import interfaces.IControlCenter;
import interfaces.IEnvironment;
import interfaces.ITailor;

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

    public AddButton(JPanel panel, TextField textField, Environment environment){

        addButton.setBounds(180,40,150,20);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] data = textField.getText();
                String addres = data[0];
                int port = Integer.parseInt(data[1]);
                String name = data[2];

                try {
                    IEnvironment icc = (IEnvironment) UnicastRemoteObject.exportObject(environment,0);
                    Registry registry = LocateRegistry.getRegistry(addres,port);
                    registry.rebind("IEnvironment", icc);
                    ITailor tailor = (ITailor) registry.lookup("Tailor");
                    tailor.register(environment, name);
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
