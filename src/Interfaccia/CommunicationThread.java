package Interfaccia;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class CommunicationThread implements Runnable{
    private Socket clientSocket;
    private DataInputStream input;  //BufferedReader input]
    private InputStream in = null;

    public CommunicationThread(Socket clientScoket){
        this.clientSocket = clientSocket;

        try {
            in = this.clientSocket.getInputStream();
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
                System.out.println(input.toString());
                //updateConversationHandler.post(new updateUIThread(data));//updateConversationHandler.post(new updateUIThread(read));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
    }
