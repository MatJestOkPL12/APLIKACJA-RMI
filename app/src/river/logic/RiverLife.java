package river.logic;

import interfaces.IRetensionBasin;
import interfaces.IRiverSection;
import river.River;
import river.graph.texfields.TankChoice;
import river.graph.texfields.TextField;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RiverLife extends Thread {

    TextField textField;
    TankChoice tankChoice;
    River river;


    public RiverLife(TextField textField, TankChoice tankChoice, River river){
        this.textField = textField;
        this.tankChoice = tankChoice;
        this.river = river;
    }

    public void run(){

        while (true) {

            setWater(river);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    private void setWater(River river){

        String [] data = textField.getText();
        String host = data[0];
        int port = Integer.parseInt(data[1]);
        String name = data[2];
        String tank = tankChoice.getText();



        try {
            Registry registry = LocateRegistry.getRegistry(host,port);

            IRetensionBasin basin = (IRetensionBasin) registry.lookup(tank);

            basin.setWaterInflow(river.getWaterToTank(), name);


        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }


}
