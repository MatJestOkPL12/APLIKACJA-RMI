package retensionBasin.labels;

import javax.swing.*;

public class NewConnectedRiver {

    public NewConnectedRiver(String name, JPanel panel, int y){
        JLabel newRiver = new JLabel(name);
        newRiver.setBounds(580, y, 100,20);


        panel.add(newRiver);
        panel.revalidate();
        panel.repaint();
    }

}
