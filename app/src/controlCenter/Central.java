package controlCenter;

import controlCenter.graph.NewTank;
import interfaces.IControlCenter;
import interfaces.IRetensionBasin;

import javax.swing.text.TabableView;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Central implements IControlCenter {

    Main main;
    int y = 110;

    List<String> tankNames = new ArrayList<>();
    List <NewTank> tanks = new ArrayList<>();

    public Central(Main main){
        this.main = main;
    }
    @Override
    public void assignRetensionBasin(IRetensionBasin irb, String name) throws RemoteException {
        NewTank tank = new NewTank(main.getPanel(),name, y, irb);
        tanks.add(tank);
        y = y+40;
        tankNames.add(name);
    }

    public List<String> getTankNames(){
        return tankNames;
    }
    public List<NewTank> getTanks(){
        return tanks;
    }
}
