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

/**
 *
 * @author agonzalezgonzalez
 */
public class Lector implements Runnable {

    DataInputStream ips;
    int size = 0;
    byte[] x;
    byte[] mensaje;

    Lector(DataInputStream ips) {
        System.out.println(ips);
        this.ips = ips;
        new Thread(this).start();
    }

    @Override
    public void run() {

        while (true) {

            try {
                while (ips.available() == 0) {

                }
                size = ips.readInt();

                if (size > 0) {
                    mensaje = new byte[size];
                    ips.read(mensaje);
                    x = new byte[mensaje.length];
                    System.out.println("Cliente recibio: " + new String(mensaje));
                    Vista.chat.append(new String(mensaje));
                    

                }
            } catch (Exception ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
