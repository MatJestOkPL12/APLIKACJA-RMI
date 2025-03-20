package controlCenter.graph.button;

import controlCenter.Central;
import controlCenter.graph.textField.TextField;
import controlCenter.logic.CentralWork;
import interfaces.IControlCenter;
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


    public AddButton(JPanel panel, TextField textField, Central central){

        addButton.setBounds(180,40,150,20);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String [] data = textField.getText();
                String name = data[2];
                String host = data[0];
                int port = Integer.parseInt(data[1]);
                CentralWork centralWork = new CentralWork(central,textField);
                centralWork.start();

                try {
                    IControlCenter icc =(IControlCenter) UnicastRemoteObject.exportObject(central,0);
                    Registry registry = LocateRegistry.getRegistry(host,port);
                    registry.rebind("IControlCenter", icc);
                    ITailor tailor = (ITailor) registry.lookup("Tailor");
                    tailor.register(central, name);
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
