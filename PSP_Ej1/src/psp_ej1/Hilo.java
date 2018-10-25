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

    int pid;

    Hilo(int i) {

        this.pid = i;
        this.start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                System.out.println("Hilo " + pid + ": " + i);
                //Tiempo de espera entre 50 segundos y 1 segundo
                Thread.sleep((long) (Math.random() * 50000 + 1000));

            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
