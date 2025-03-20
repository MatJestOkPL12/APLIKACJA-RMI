package tailor;

import interfaces.ITailor;
import tailor.graph.Lablel;

import javax.swing.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Tailor implements ITailor {


    JPanel panel;
     int counter = 0;
     List<String> data = new ArrayList<>();
     List<Remote> type = new ArrayList<>();
     Lablel lablel;
     int y = 50;
    @Override
    public boolean register(Remote r, String name) throws RemoteException {
        counter++;
        data.add(name);
        type.add(r);
        lablel.addItem(counter, (ArrayList<String>) data, (ArrayList<Remote>) type, y);
        y = y+20;
        return false;
    }

    @Override
    public boolean unregister(Remote r) throws RemoteException {
        return false;
    }

    public void setLabel(Lablel lablel){
        this.lablel = lablel;
    }



}
