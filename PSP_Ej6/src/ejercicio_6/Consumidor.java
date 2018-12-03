/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
class Consumidor implements Runnable {

    static boolean retornado = true;
    CubbyHole c;

    int x;
    private int extrac;

    
    public Consumidor(CubbyHole c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                
                x = c.getX();
                c.setX((x+extrac()));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int extrac() {
        
        extrac = (int) (Math.random() * 50 + 1);
        extrac = -1 * extrac;
        System.out.println("Extraccion: " + extrac);
        return extrac;
    }
}
