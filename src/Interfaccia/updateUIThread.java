package Interfaccia;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

public class updateUIThread {
    private byte[] byteArray;//private String msg;
    //private ByteArrayInputStream bis;

    public updateUIThread(byte[] array){    //public updateUIThread(String str) {
        this.byteArray = array;   //this.msg = str;
        //this.bis = ByteArrayInputStream(array);
    }

    public void run() {
        System.out.println("Ciao Mario!");

        //Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray , 0, byteArray .length);
        //imageView.setImageBitmap(bitmap);//text.setText(text.getText().toString()+"Client Says: "+ msg + "\n");
    }
}
