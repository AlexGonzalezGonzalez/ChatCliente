/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agonzalezgonzalez
 */
public class BuzonCorreo {

    public static boolean lleno = false;
    private String mensaje;

    public synchronized void getMensaje(int pid) {
        //esperamos a que haya mensaje que leer
        try {
            while (BuzonCorreo.lleno == false) {
                wait();
            }
            //mostramos el mensaje de cada hilo
            System.out.println("Hilo "+pid+" leyo el mensaje: "+mensaje);
            //decimos que el buzon esta vacio
            BuzonCorreo.lleno=false;
            

        } catch (InterruptedException ex) {
            Logger.getLogger(BuzonCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //metodo que muestra el mensaje que se escribe y quien lo escribe y notifica que el buzon esta vacio
    public synchronized void setMensaje(String mensaje, int x) {
        
            this.mensaje = mensaje;
            System.out.println("Hilo " + x + " escribio: Hilo " + x);
            BuzonCorreo.lleno = true;
            notify();
    }

}
