package river.graph.texfields;

import javax.swing.*;
import java.util.jar.JarEntry;

public class TankChoice {

    JTextField textField = new JTextField();

    public TankChoice(JPanel panel){

        textField.setBounds(420,40,100,20);

        panel.add(textField);

    }


    public String getText(){
        return textField.getText();
    }

}
