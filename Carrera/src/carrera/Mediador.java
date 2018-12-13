/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import static carrera.Carrera.l;
import static carrera.Carrera.t;

/**
 *
 * @author agonzalezgonzalez
 */
public class Mediador {
    /*
    Metodo que se encarga de dar turno a la liebre o a la tortuga y hace esperar a cada uno 
    */
    public synchronized void turno(String nombre) throws InterruptedException {
        if (nombre.equalsIgnoreCase("tortuga")) {
            Thread.sleep(1000);
            t.mover(Carrera.movimientoTortuga(), t.getPosicion());
            System.out.println("Posicion de la tortuga: " + t.getPosicion());
            if (t.getPosicion() >= 100) {
                System.out.println("Llego la tortuga");
                System.exit(0);
            }
            
            notify();
            wait();
           
            

        } else if (nombre.equalsIgnoreCase("liebre")) {
            Thread.sleep(1000);
            l.mover(Carrera.movimientoLiebre(), l.getPosicion());
            System.out.println("Posicion de la liebre: " + l.getPosicion());
            if (l.getPosicion() >= 100) {
                System.out.println("LLego la liebre");
                System.exit(0);
            }
            notify();
            wait();
            
    }
}
}
