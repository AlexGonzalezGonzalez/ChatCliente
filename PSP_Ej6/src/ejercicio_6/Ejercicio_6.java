/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_6;

/**
 *
 * @author alejandro
 */
public class Ejercicio_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CubbyHole cb = new CubbyHole();
        System.out.println("Inicial: "+cb.getInit());
        Productor p = new Productor(cb);
        Consumidor c = new Consumidor(cb);
        Thread t = new Thread(p);
        Thread t2 = new Thread(c);
        t.start();
        t2.start();
    }
    
}
