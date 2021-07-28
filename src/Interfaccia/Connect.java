package Interfaccia;

import javax.swing.*;
import Core.Connection;
import Core.Webcam;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connect extends JFrame implements ActionListener{
    private final JTextField IPAddress;
    private final JTextField Port;
    private final JButton Start;
    private Socket socket;

    public Connect(){
        Start = new JButton("Start");
        Start.addActionListener(this);
        IPAddress= new JTextField("IPAddress: ");
        IPAddress.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                IPAddress.setText("");
            }
        });
        Port= new JTextField("Port: ");
        Port.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Port.setText("");
            }
        });
        JPanel p1 = new JPanel(new GridLayout());
        p1.add(IPAddress);
        p1.add(Port);
        JPanel p2 = new JPanel(new GridLayout());
        p2.add(Start);
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.SOUTH);
        IPAddress.setEditable(true);
        Port.setEditable(true);
        setContentPane(p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Start){
            try {
                InetAddress serverAddr = InetAddress.getByName(IPAddress.getText());
                socket = new Socket(IPAddress.getText(), Integer.parseInt(Port.getText()));
            } catch (UnknownHostException unknownHostException) {
                unknownHostException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            CommunicationThread commThread = new CommunicationThread(socket);   //faccio partira il thread per lo scambio dei dati
            new Thread(commThread).start();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Connect::new);
    }
}