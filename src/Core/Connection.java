package Core;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;

public class Connection {
    Webcam webcam;
    public Connection(final JTextField IPAddress, final JTextField Port){
        Socket connection;
        String IPServer = IPAddress.getText();
        int port = Integer.parseInt(Port.getText());

        InputStream in;
        InputStreamReader input;
        BufferedReader sIN;

        try{
            connection = new Socket (IPServer, port);

            String message = "Aperta connessione con Server: " + IPServer + "\n su porta: " + port;

            ImageIcon icon = new ImageIcon("cam.png");
            JOptionPane.showMessageDialog(null, message, "Connected", JOptionPane.INFORMATION_MESSAGE, icon);

            //INIZIALIZZAZIONE FLUSSO INPUT PER RICEZIONE INFO VIA SOCKET "CONNESSIONE"
            in = connection.getInputStream();
            input = new InputStreamReader(in);
            sIN = new BufferedReader(input);


            //LETTURA DELL'ORA DAL SOCKET E VISUALIZZAZIONE SU TERMINALE CLIENT
            //String infoClock = sIN.readLine();

            webcam= new Webcam();

            webcam.frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                    try {
                        sIN.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    try {
                        connection.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    System.out.println("Connessione chiusa!");
                    JOptionPane.showMessageDialog(null, "La connessione è stata chiusa", "Connection closed", JOptionPane.INFORMATION_MESSAGE, icon);
            }
            });
        }catch(IOException e){
            System.out.println("Errore " + e);
        }
    }
}
