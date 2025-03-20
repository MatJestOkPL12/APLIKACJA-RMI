package controlCenter.logic;

import controlCenter.Central;
import controlCenter.graph.NewTank;
import controlCenter.graph.textField.TextField;
import interfaces.IRetensionBasin;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class CentralWork extends  Thread{

    Central central;
    String host;
    int port;
    public CentralWork(Central central, TextField textField){
        this.central = central;
        host = textField.getText()[0];
        port = Integer.parseInt(textField.getText()[1]);
    }

    public void run(){



        while(true){

            updateFilling(host, port);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private void updateFilling(String host, int port){
        System.out.println("Apdejt");
        List<String> names = central.getTankNames();
        List<NewTank> tanks = central.getTanks();
        for(int i = 0; i<names.size(); i++){
            String name = names.get(i);
            NewTank tank = tanks.get(i);
            try {
                Registry registry = LocateRegistry.getRegistry(host, port);
                IRetensionBasin basin = (IRetensionBasin) registry.lookup(name);
                long fillingPercentage = basin.getFillingPercentage();
                System.out.println(fillingPercentage);
                tank.updatePercentage(fillingPercentage);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
