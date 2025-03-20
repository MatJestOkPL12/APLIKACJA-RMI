package retensionBasin.labels;

import javax.swing.*;

public class ConntectedRivers {

    JLabel conRiv = new JLabel("Wpadające rzeki:");

    public ConntectedRivers(JPanel panel){

        conRiv.setBounds(550,120, 100,20);

        panel.add(conRiv);

    }

}
