package tailor;

import tailor.graph.Lablel;
import tailor.graph.PortArea;
import tailor.graph.StartButton;

import javax.swing.*;

public class Main {




    public static void main(String[] args) {
        Tailor tailor = new Tailor();
        Main main = new Main();
        main.makeGUI(tailor);

    }

    private void makeGUI(Tailor tailor){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Lablel lablel= new Lablel(panel);
        tailor.setLabel(lablel);
        PortArea portArea = new PortArea(panel);
        StartButton startButton = new StartButton(panel, portArea,tailor);


        frame.add(panel);
        frame.setTitle("Tailor");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocation(400,400);
    }





}
