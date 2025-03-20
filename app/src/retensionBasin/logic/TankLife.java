package retensionBasin.logic;

import interfaces.IRetensionBasin;
import interfaces.IRiverSection;
import retensionBasin.Basin;
import retensionBasin.Main;
import retensionBasin.textFields.RiverName;
import retensionBasin.textFields.TextField;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TankLife extends Thread{

    TextField textField;
    Main main;
    Basin basin;


    public TankLife(TextField textField, Main main, Basin basin){
        this.textField = textField;
        this.main = main;
        this.basin = basin;
    }


    public void run(){

        while (true) {

            sendWater();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void sendWater() {
        String[] data = textField.getText();
        String host = data[0];
        int port = Integer.parseInt(data[1]);
        RiverName riverName = main.getRiverName();
        String name = riverName.getText();


        if (name.isEmpty()) {

        } else {
            try {
                System.out.println(name);
                Registry registry = LocateRegistry.getRegistry(host, port);
                IRiverSection river = (IRiverSection) registry.lookup(name);
                int drop = basin.getWaterDischarge();
                river.setRealDischarge(drop);

            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            }


        }
    }


}
