package retensionBasin.textFields;

import retensionBasin.labels.RiverLabel;

import javax.swing.*;

public class RiverName {

    JTextField textField = new JTextField();

    public RiverName(JPanel panel){

        textField.setBounds(440,40,80,20);

        panel.add(textField);

    }


    public String getText(){
        return textField.getText();
    }

}
