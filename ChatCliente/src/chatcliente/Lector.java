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
    Cliente cliente;
    DataInputStream lector;
    int size = 0;
    byte[] mensaje = new byte[2000];
    String[] info, result;

    Lector(Cliente c) {
        this.cliente = c;
        this.lector = c.getIps();
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

                mensaje = new byte[lector.readInt()];
                lector.read(mensaje);
                String msg = new String(mensaje);
                System.out.println("Leer: " + msg);
                if (msg.contains("USUARIOS |")) {
                    System.out.println("USUARIOS IF");
                    info = msg.split(" | ");

                    for (int i = 0; i < info.length; i++) {
                        if (i != 0) {
                            if(!info[1].contains("|")){
                            System.out.println("INFO: " + info[i]);
                            Vista.nuevoUsuario(info[i]);
                            }
                        }

                    }

                } else if (msg.contains("SALAS | ")) {
                    info = msg.split(" | ");
                    for (int i = 0; i < info.length; i++) {
                        if (i == 0) {
                            Vista.chat.setText(Vista.chat.getText() + "\nSalas:\n");
                        }
                        Vista.chat.setText(Vista.chat.getText() + info[i] + "\n");
                    }

                } else {
                    Vista.chat.setText(Vista.chat.getText() + msg);
                    Vista.chat.setText(Vista.chat.getText() + "\n");
                    if (cliente.clienteSocket.isConnected() == false) {
                        break;
                    }
                }
            } catch (IOException ex) {
                this.hilo.stop();
                this.cliente.desconexion();

            }
        }
    }

}
