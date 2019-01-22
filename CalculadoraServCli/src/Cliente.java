
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author agonzalezgonzalez
 */
public class Cliente {

    InputStream is;
    OutputStream os;
    InetSocketAddress addr;
    Socket clienteSocket;
    byte[] mensaje = new byte[1];

    Cliente() {
        //conexion();
    }

    public String clienteLeerResultado() {
        try {
            mensaje = new byte[1];
            is.read(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String(mensaje);
    }

    public void clienteEscribir(String msg) {

        try {
            mensaje=new byte[4];
            mensaje = msg.getBytes();
            os.write(mensaje);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conexion() {
        try {
            
            clienteSocket = new Socket();
            addr = new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);
            is = clienteSocket.getInputStream();
            os = clienteSocket.getOutputStream();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
