/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author agonzalezgonzalez
 */
public class Controlador {

    Cliente c;

    Controlador(Cliente c) {
        this.c = c;
        c.clienteEscribir(JOptionPane.showInputDialog(null, "NickName"));
        
    }
    
    public Cliente getCliente(){
        return this.c;
    }

    public void enviar(String mensaje) {
        c.clienteEscribir(mensaje);
    }

    public String leer() {
        return c.clienteLeerResultado();
    }
}
