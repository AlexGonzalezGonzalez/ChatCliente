/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
class Hilo extends Thread {

    static int pid;
    int conta;
    Hilo h1;

    Hilo(int x, int y) {
        this.conta = x;
        this.pid = y;
        if (conta != 5) {

            this.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Comenzo el Hilo " + pid);
        
        for (int i = 0; i < 10; i++) {
            
            try {
                System.out.println("Hilo " + pid + ": " + i);
                Thread.sleep((long) (Math.random() * 600 + 100));
                if (i == 9) {
                    if (conta != 4) {
                        conta++;
                        pid++;
                        Hilo h1 = new Hilo(conta, pid);
                        while (h1.isAlive()) {
                        }
                    }
                    System.out.println("Acabo el Hilo " + pid);
                    pid--;

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
