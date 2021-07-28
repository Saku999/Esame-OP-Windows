package Core;

import javax.swing.*;
import java.awt.event.*;

public class Webcam extends JFrame {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("eii");

    public Webcam() {
        label.setVisible(true);
        label.setBounds(0,0,300,200);

        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setVisible(true);
        frame.add(label);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}