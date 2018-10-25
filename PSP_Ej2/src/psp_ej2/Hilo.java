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
    int pid;
    static int conta=0;
    static boolean acabo;
    Hilo(int x){
        this.pid=x;
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Hilo "+pid+": "+i);
                Thread.sleep(1000);
                if(i==4){
                    conta++;
                   
                    if(conta==4){
                    acabo=true;
                        
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
