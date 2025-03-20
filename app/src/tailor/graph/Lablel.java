package tailor.graph;

import javax.swing.*;
import java.rmi.Remote;
import java.util.ArrayList;

public class Lablel {

    JLabel label = new JLabel("Wprowadź port");

    JPanel panel;

    public Lablel (JPanel panel){
        this.panel = panel;
        label.setBounds(5,10, 120,20);



        panel.add(label);

    }

    public void addItem(int i, ArrayList<String> name, ArrayList<Remote> r, int y){
        String [] type = r.get(i-1).toString().split("\\.");
        String finalType = type[0];
        JLabel nameL = new JLabel(name.get(i-1));
        JLabel typeL = new JLabel(finalType);
        nameL.setBounds(5, y, 100,20);
        typeL.setBounds(120,y, 100,20);

        panel.add(nameL);
        panel.add(typeL);
        panel.revalidate();
        panel.repaint();
    }



}
