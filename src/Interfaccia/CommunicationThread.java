package Interfaccia;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

public class CommunicationThread implements Runnable{
    private Socket clientSocket;
    private DataInputStream input;  //BufferedReader input]

    public CommunicationThread(Socket clientSocket){
        this.clientSocket = clientSocket;

        try {
            InputStream in = this.clientSocket.getInputStream();
            this.input = new DataInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        System.out.println("hello");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                byte[] data;//String read = input.readLine();
                int len= this.input.readInt();
                data = new byte[len];
                if (len > 0) {
                    this.input.readFully(data,0,data.length);
                }
                        /*
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        byte[] data;
                        int length = 0;
                        while ((length = this.input.read(data))!=-1) {
                            out.write(data,0,length);
                        }
                           data=out.toByteArray();
                        */
                System.out.println("Dati:"+input);
                //TEST
                Image image = ImageIO.read(input);//Read the file to a BufferedImage
                BufferedImage bi = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
                File output = new File("C:\\Users\\micha\\Desktop\\Test_Img_Camera\\image.jpg");//Create a file for the output
                Files.copy(input, output.toPath(), StandardCopyOption.ATOMIC_MOVE);
                //FINE TEST

                //updateConversationHandler.post(new updateUIThread(data));//updateConversationHandler.post(new updateUIThread(read));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
    }
