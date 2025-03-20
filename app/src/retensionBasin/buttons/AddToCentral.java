package retensionBasin.buttons;

import interfaces.IControlCenter;
import interfaces.IRetensionBasin;
import retensionBasin.Basin;
import retensionBasin.textFields.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddToCentral {

    JButton addToCentralButton = new JButton("Dodaj do centrali");

    public AddToCentral(JPanel panel, TextField textField, Basin basin){

        addToCentralButton.setBounds(200,300, 150,20);

        addToCentralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String [] data = textField.getText();
                    String host = data[0];
                    int port = Integer.parseInt(data[1]);
                    String name = data[2];


                try {
                    Registry registry = LocateRegistry.getRegistry(host, port);
                    IControlCenter icc = (IControlCenter) registry.lookup("IControlCenter");
                    IRetensionBasin irb = basin;
                    icc.assignRetensionBasin(irb, name);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                } catch (NotBoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        panel.add(addToCentralButton);

    }

}
