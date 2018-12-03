/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej1;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
class Hilo extends Thread {
    //id del proceso
    int pid;

    Hilo(int i) {
        //asignamos el id al hilo para identificarlo
        this.pid = i;
        //comenzamos el hilo
        this.start();
    }

    @Override
    public void run() {
        
        for (int i = 0; i < 10; i++) {

            try {
                //muestra Hilo y su id
                System.out.println("Hilo " + pid + ": " + i);
                //Tiempo de espera entre 50 segundos y 1 segundo
                //cada iteracion el for el hilo se suspende durante un tiempo random
                Thread.sleep((long) (Math.random() * 50000 + 1000));

            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
