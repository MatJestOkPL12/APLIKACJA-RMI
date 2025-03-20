package river;

import interfaces.IRetensionBasin;
import interfaces.IRiverSection;
import river.graph.labels.RainfallLabel;
import river.graph.labels.TankInfo;
import river.graph.labels.WaterFromBasin;

import java.io.Serializable;
import java.rmi.RemoteException;

public class River  implements IRiverSection, Serializable {



    public River(Main main){
        this.main = main;
    }

    Main main;

    int rainfall = 0;
    int waterInRiver =0;
    int dischargeValue = 0;
    int waterFromBasin = 0;
    String tankName;
    @Override
    public void setRealDischarge(int realDischarge) throws RemoteException {
        System.out.println(realDischarge);
        waterFromBasin = realDischarge;
        WaterFromBasin waterFromBasin1 = main.getWaterFromBasin();
        waterFromBasin1.updateVale(waterFromBasin);
    }

    @Override
    public void setRainfall(int rainfall) throws RemoteException {
        RainfallLabel rainfallLabel = main.getRainfall();
        this.rainfall = rainfall;

        rainfallLabel.uptadeRainfallValue(rainfall);
    }

    @Override
    public void assignRetensionBasin(IRetensionBasin irb, String name) throws RemoteException {
        TankInfo tankInfo = main.getTankinfo();
        tankInfo.updateType(name);
        System.out.println(name);
        tankName = name;
    }

    public int getWaterToTank(){
        return rainfall+dischargeValue;
    }


    public String getTankName(){
        System.out.println(tankName);
        return tankName;
    }



}
