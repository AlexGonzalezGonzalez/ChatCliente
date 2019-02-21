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

    int size = 0;
    DataOutputStream ops;
    DataInputStream ips;
    InputStream is;
    OutputStream os;
    InetSocketAddress addr;
    Socket clienteSocket;
    byte[] mensaje;
    Lector lector;

    //Constructor
    Cliente() {
        
        //Nos conectamos al servidor
        conexion();
        System.out.println("Cliente conectado");

    }

    public void setLector(Lector lector) {
        this.lector = lector;
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
            ops.writeInt(msg.getBytes().length);
            ops.write(msg.getBytes());
            System.out.println("Cliente escribio: " + msg);

        } catch (IOException ex) {}
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
            ops = new DataOutputStream(clienteSocket.getOutputStream());
            ips = new DataInputStream(clienteSocket.getInputStream());

        } catch (IOException ex) {

        }

    }

    public DataInputStream getIps() {
        return ips;
    }

    public void desconexion() {
        //Enviamos un mensaje al servidor de cierre y cerramos todo
        //Si falla muestra un mensaje
        try {

            clienteEscribir("/bye");
            lector.getHilo().stop();
            clienteSocket.close();
            System.out.println("Desconectado");

            if (is != null) {
                is.close();
            }

            if (os != null) {
                os.close();
            }

            if (clienteSocket != null) {
                clienteSocket.close();
            }
            System.exit(0);

        } catch (IOException ex) {

        }
    }
}
