/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
class Hilo extends Thread{
    //id del proceso
    int pid;
    //asignamos el id y empezamos el hilo
    Hilo(int x){
        this.pid=x;
        this.start();
    }
    @Override
    public void run() {
        //cada hilo escribe su id mas el numero de iteracion y en cada 
        //iteracion se suspende un segundo
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Hilo "+pid+": "+i);
                Thread.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
