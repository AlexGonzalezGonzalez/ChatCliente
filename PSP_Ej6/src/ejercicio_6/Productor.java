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
class Productor implements Runnable {

    static boolean producido;
    CubbyHole c;
    int x, ingreso;

    public Productor(CubbyHole c) {
        this.c = c;
    
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                x=c.getX();
                c.setX((ingreso()+x));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }

    public int ingreso() {
        ingreso = (int) (Math.random() * 50 + 1);
        System.out.println("Ingreso: " + ingreso);
        return ingreso;
    }

}
