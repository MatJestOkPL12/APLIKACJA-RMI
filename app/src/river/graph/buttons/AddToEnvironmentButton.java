package river.graph.buttons;

import interfaces.IEnvironment;
import interfaces.IRiverSection;
import river.River;
import river.graph.texfields.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddToEnvironmentButton {
    JButton environment = new JButton("Dodaj do środowiska");


    public AddToEnvironmentButton(JPanel panel, TextField textField, River river){

        environment.setBounds(260,300,160,20);

        environment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] data = textField.getText();
                String host = data[0];
                int port = Integer.parseInt(data[1]);

                try {
                    Registry registry = LocateRegistry.getRegistry(host,port);
                    IEnvironment environment = (IEnvironment) registry.lookup("IEnvironment");
                    IRiverSection irs = river;
                    environment.assignRiverSection(irs, data[2]);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(environment);

    }
}
