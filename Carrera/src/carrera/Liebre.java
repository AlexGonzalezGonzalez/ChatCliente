/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import static java.lang.Thread.State.TERMINATED;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agonzalezgonzalez
 */
class Liebre extends Thread {

    Thread tortuga;
    public static int posicion = 1;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public void run() {

        while (this.getPosicion() < 100) {
         
            if (Tortuga.turno == false) {
                Carrera.turno("liebre");

            }
        }
       
    }

    public void mover(int casillas, int posicion) {
        if (casillas > 0) {
            System.out.println("Liebre avanza " + casillas + " casillas");
        } else if(casillas<0){
            System.out.println("Liebre esvara " + (casillas * -1) + " casillas");
        }
        else{
            System.out.println("Liebre duerme");
        }
        if ((casillas + posicion) < 1) {
            this.posicion = 1;
        } else {
            this.posicion = posicion + casillas;
        }
    }

}
