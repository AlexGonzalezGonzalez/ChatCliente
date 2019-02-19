/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author agonzalezgonzalez
 */
public class Lector implements Runnable {

    public Thread hilo;
    DataInputStream lector;
    int size = 0;
    byte[] mensaje = new byte[2000];

    Lector(DataInputStream is) {
        this.lector = is;
        hilo = new Thread(this);
        hilo.start();
    }

    public Thread getHilo() {
        return hilo;
    }

    @Override
    public void run() {

        while (true) {
            try {
                size = lector.readInt();
                mensaje = new byte[size];
                lector.read(mensaje);
                String msg = new String(mensaje);
                System.out.println("Leer: " + new String(mensaje));
                Vista.chat.setText(Vista.chat.getText() + msg);
                Vista.chat.setText(Vista.chat.getText() + "\n");
                if(msg.contains("Nuevo usuario conectado ( ")){
                    System.out.println("if del lector");
                    String[] arr=msg.split("conectado \\( ");
                    Vista.nuevoUsuario(arr[1].split(" /")[0]);
                }

            } catch (IOException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
