/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

/**
 *
 * @author agonzalezgonzalez
 */
class Tortuga extends Thread{

    public static boolean turno = false;
    public static int posicion = 1;
    private int movimiento;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public void run() {

        while (this.getPosicion() < 100) {
            System.out.println("tortuga "+Tortuga.turno);
            if (Tortuga.turno == true) {
                
                Carrera.turno("tortuga");
            }

        }

        

    }

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
