package retensionBasin.labels;

import javax.swing.*;

public class RiverLabel {

    JLabel river = new JLabel("Rzeka");

    public RiverLabel(JPanel panel){

        river.setBounds(380,40,80,20);


        panel.add(river);


    }


}
