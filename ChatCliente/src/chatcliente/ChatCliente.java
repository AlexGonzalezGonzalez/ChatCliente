/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import javax.swing.JOptionPane;

/**
 *
 * @author agonzalezgonzalez
 */
public class ChatCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Controlador c = new Controlador();
        //Vista v = new Vista();
        Cliente c = new Cliente();
        c.clienteEscribir(JOptionPane.showInputDialog("NickName"));
        while (true) {
        c.clienteEscribir(JOptionPane.showInputDialog("Mensaje") + "#");
        }
    }

}
