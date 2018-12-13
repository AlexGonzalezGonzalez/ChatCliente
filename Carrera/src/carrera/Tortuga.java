/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agonzalezgonzalez
 */
class Tortuga implements Runnable{
    Mediador x;
    public static boolean turno = false;
    public static int posicion = 1;

    Tortuga (Mediador x){
        this.x=x;
        new Thread(this).start();
    }
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public void run() {
        //Mientras no llegue a 100, y tenga turno se mueve
        while (true) {

                try {
                    x.turno("tortuga");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
                }
            

        }

        

    }
    //Asigna la posicion a la tortuga dependiendo del numero random de casillas a moverse
    public void mover(int casillas, int posicion) {
        if (casillas > 0) {
            System.out.println("Tortuga avanza " + casillas + " casillas");
        } else {
            System.out.println("Tortuga esvara " + (casillas * -1) + " casillas");
        }
        if ((casillas + posicion) < 1) {
            this.posicion = 1;
        } else {
            this.posicion = posicion + casillas;
        }
    }
}
