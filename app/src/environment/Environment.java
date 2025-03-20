package environment;

import environment.graph.NewRiver;
import interfaces.IEnvironment;
import interfaces.IRiverSection;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Environment implements IEnvironment, Serializable {

    public Environment(Main main){
        this.main = main;
    }

    Main main;
    int y = 110;
    @Override
    public void assignRiverSection(IRiverSection irs, String name) throws RemoteException {
        NewRiver newRiver = new NewRiver(main.getPanel(), name, y, irs);
        y=y+40;
    }
}
