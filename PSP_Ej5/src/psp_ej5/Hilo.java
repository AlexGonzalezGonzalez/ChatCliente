/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
class Hilo extends Thread {

    int pid;
    static int conta = 0;

    public Hilo(int pid) {
        this.pid = pid;
        
        if (Hilo.conta == 0) {
           this.setPriority(Thread.MIN_PRIORITY);
            Hilo.conta++;
            Hilo h2 = new Hilo(2);
           h2.setPriority(Thread.MAX_PRIORITY);
            
                //h2.join();
            
        }

        this.start();

    }

    public void run() {

        System.out.println("Hola soy el Hilo " + pid);

    }
}
