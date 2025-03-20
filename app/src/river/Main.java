package river;


import river.graph.buttons.AddButton;
import river.graph.buttons.AddToEnvironmentButton;
import river.graph.buttons.AddToTank;
import river.graph.labels.*;
import river.graph.texfields.TankChoice;
import river.graph.texfields.TextField;

import javax.swing.*;

public class Main {
    RainfallLabel rainfallLabel;
    TankInfo tankInfo;
    WaterFromBasin waterFromBasin;




    public static void main(String[] args) {
        Main main = new Main();
        River river = new River(main);
        main.makeGui(river);
    }


    private void makeGui(River river){
        JFrame frame = new JFrame();
        frame.setTitle("River");
        frame.setSize(700,400);
        frame.setLocation(500,500);
        JPanel panel = new JPanel();
        Label label = new Label(panel);
        TextField textField = new TextField(panel);
        AddButton addButton = new AddButton(panel, textField, river);
        AddToEnvironmentButton button2 = new AddToEnvironmentButton(panel, textField, river);
        TankLabel tankLabel = new TankLabel(panel);
        TankChoice tankChoice = new TankChoice(panel);
        AddToTank addToTank = new AddToTank(panel, tankChoice, textField, river);
        waterFromBasin = new WaterFromBasin(panel);
        rainfallLabel = new RainfallLabel(panel);
        tankInfo = new TankInfo(panel);



        panel.setLayout(null);





        frame.add(panel);
        frame.setVisible(true);
    }


    public RainfallLabel getRainfall(){
        return rainfallLabel;
    }

    public TankInfo getTankinfo(){
        return tankInfo;
    }
    public WaterFromBasin getWaterFromBasin(){return waterFromBasin;}
}
