package tailor.graph;

import interfaces.ITailor;
import tailor.Tailor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class StartButton {

    JButton button = new JButton("Otwórz serwer");

    public StartButton(JPanel panel, PortArea portArea, Tailor tailor){
        button.setBounds(300,10, 140,20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int port = Integer.parseInt(portArea.getPort());

                try {
                    ITailor iTailor = (ITailor) UnicastRemoteObject.exportObject(tailor,0);
                    Registry registry = LocateRegistry.createRegistry(port);
                    registry.rebind("Tailor", iTailor);

                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(button);
    }

}
