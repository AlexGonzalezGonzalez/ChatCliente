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
                System.out.println("Leer: " + new String(mensaje));
                if (msg.contains("USUARIOS | ")) {
                    info = msg.split(" | ");
                    for (int i = 1; i < info.length - 1; i++) {
                        Vista.nuevoUsuario(info[i]);
                    }

                } else if (msg.contains("SALAS | ")) {
                    info = msg.split(" | ");
                    for (int i = 1; i < info.length - 1; i++) {
                        if (i == 1) {
                            Vista.chat.setText(Vista.chat.getText() + "\nSalas:\n");
                        }
                        Vista.chat.setText(Vista.chat.getText() + info[i] + "\n");
                    }

                } else {
                    Vista.chat.setText(Vista.chat.getText() + msg);
                    Vista.chat.setText(Vista.chat.getText() + "\n");
                    if (msg.contains("Nuevo usuario conectado ( ")) {
                        System.out.println("if del lector");
                        String[] arr = msg.split("conectado \\( ");
                        Vista.nuevoUsuario(arr[1].split(" /")[0]);
                    }

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
