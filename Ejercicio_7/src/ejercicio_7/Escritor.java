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
class Escritor implements Runnable {
    /*
    pid: id del proceso
    bz: objeto buzon
    mensaje: mensaje a escribir
    */
    private int pid;
    BuzonCorreo bz;
    String mensaje;


    //asignamos el id y el buzon
    public Escritor(BuzonCorreo bz, int x) {
        this.pid = x;
        this.bz = bz;
        new Thread(this).start();
    }

    @Override
    public void run() {
        //escribimos un mensaje
        bz.setMensaje("Hilo " + pid, pid);

    }

 

}
