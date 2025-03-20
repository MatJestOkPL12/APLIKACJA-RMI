package retensionBasin.labels;

import javax.swing.*;

public class Discharge {

    JLabel dischargeL = new JLabel("Wielkość rzutu: ");
    JLabel dischargeValue = new JLabel();
    JPanel panel;

    public Discharge(JPanel panel){

        this.panel = panel;

        dischargeL.setBounds(30,140,100,20);
        dischargeValue.setText(String.valueOf(0));
        dischargeValue.setBounds(75, 170,60,20);

        panel.add(dischargeL);
        panel.add(dischargeValue);
    }


    public void updateValueOfDischarge(int discharge){
        dischargeValue.setText(String.valueOf(discharge));

        panel.revalidate();
        panel.repaint();
    }

}
