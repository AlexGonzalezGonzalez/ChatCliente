/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author agonzalezgonzalez
 */
public class Cliente {
    int size=0;
    DataOutputStream ops;
    DataInputStream ips;
    InputStream is;
    OutputStream os;
    InetSocketAddress addr;
    Socket clienteSocket;
    byte[] mensaje;
    private boolean conectado = false;

    //Constructor
    Cliente() {

        //Nos conectamos al servidor
        conexion();
        System.out.println("Cliente conectado");

    }

    /**
     * Metodo que lee el mensaje que envio el servidor.
     *
     * @return Devuelve un String que es el resultado de la operacion.
     */
    public String clienteLeerResultado() {

        //Leemos el mensaje y lo devolvemos en un String
        //Si da error muestra un mensaje
        try {
            size=ips.readInt();
            System.out.println(size);
            if(size>0){
            mensaje = new byte[size];
            ips.read(mensaje);
                System.out.println(size);
            System.out.println("Cliente recibio: " + new String(mensaje));
            }
        } catch (IOException ex) {

        }
        return new String(mensaje);
    }

    /**
     * Metodo que envia la operacion completa al servidor
     *
     * @param msg String que contiene la operacion que se le quiere enviar al
     * servidor.
     */
    public void clienteEscribir(String msg) {

        //Escribimos el mensaje que recibimos
        //Si da error muestra un mensaje
        try {
            
            msg = msg + "#";
            size=msg.length();
            ops.writeInt(size);
            ops.write(msg.getBytes());
            System.out.println("Cliente envio: " + msg);

        } catch (IOException ex) {

        }
    }

    /**
     * Metodo que conecta con el servidor usando socket stream y inicia el
     * inputStream y outputStream
     */
    public void conexion() {

        //Creamos un socket y nos conectamos a la ip y puerto recibidos
        //Si falla la conexion es que el servidor esta cerrado
        try {

            String conexion = JOptionPane.showInputDialog(null, "Ingrese IP:Puerto");
            String[] conn = conexion.split(":");

            clienteSocket = new Socket();
            addr = new InetSocketAddress(conn[0], Integer.parseInt(conn[1]));
            clienteSocket.connect(addr);
            conectado = true;
            ops = new DataOutputStream(clienteSocket.getOutputStream());
            ips =new DataInputStream (clienteSocket.getInputStream());

        } catch (IOException ex) {

            conectado = false;
        }

    }

    public void desconexion() {
        //Enviamos un mensaje al servidor de cierre y cerramos todo
        //Si falla muestra un mensaje
        try {

            if (conectado == true) {

                os.write("OFF#".getBytes());
                if (is != null) {
                    is.close();
                }

                if (os != null) {
                    os.close();
                }

                if (clienteSocket != null) {
                    clienteSocket.close();
                }
            } else {

                System.exit(0);
            }
        } catch (IOException ex) {

        }
    }
}
