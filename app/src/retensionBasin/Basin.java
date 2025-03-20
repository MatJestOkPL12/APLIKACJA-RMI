package retensionBasin;

import interfaces.IRetensionBasin;
import interfaces.IRiverSection;
import retensionBasin.labels.Discharge;
import retensionBasin.labels.NewConnectedRiver;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Basin implements IRetensionBasin, Serializable {


    Main main;
    public Basin(Main main){
        this.main = main;
    }

    int waterDischarge = 0;
    int y = 150;
    int waterInflow = 0;

    int currentCapacity = 0;
    int maxCapacity = 0;
    int drop= 0;
    String riverName;
    @Override
    public int getWaterDischarge() throws RemoteException {
        System.out.println("WaterDischarge");
        if(currentCapacity > maxCapacity){
            drop = currentCapacity - maxCapacity + waterDischarge;
            currentCapacity = currentCapacity - drop;
            return drop;
        }
        if(currentCapacity<maxCapacity && currentCapacity > waterDischarge){
            drop = waterDischarge;
            currentCapacity = currentCapacity - drop;
            return drop;
        }
        if(currentCapacity<waterDischarge){
            drop = currentCapacity;
            currentCapacity = 0;
            return drop;
        }


        return -1;

    }

    @Override
    public long getFillingPercentage() throws RemoteException {

        if(maxCapacity == 0){
            return 0;
        }
        else {
            return (long) (((double)currentCapacity / maxCapacity) * 100);
        }
    }

    @Override
    public void setWaterDischarge(int waterDischarge) throws RemoteException {
        Discharge discharge = main.getDischarge();
        this.waterDischarge = waterDischarge;

        discharge.updateValueOfDischarge(waterDischarge);
    }

    @Override
    public void setWaterInflow(int waterInflow, String name) throws RemoteException {
        this.waterInflow = waterInflow;
        currentCapacity = currentCapacity + waterInflow;

    }

    @Override
    public void assignRiverSection(IRiverSection irs, String name) throws RemoteException {
        NewConnectedRiver newConnectedRiver = new NewConnectedRiver(name, main.getPanel(), y);
        y = y+30;
    }

    public void setCapacity(int capacity){
        maxCapacity = capacity;
    }
}
