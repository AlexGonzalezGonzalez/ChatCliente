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
public class Carrera {

    static int mov;
    static Tortuga t;
    static Liebre l;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        t = new Tortuga();
        l = new Liebre();
        t.start();
        l.start();
    }

    public static int movimientoTortuga() {
        int y = 0;
        int x = (int) (Math.ceil(Math.random() * 100));
        if (x <= 50) {
            y = 3;
        }
        if (x >= 51 && x < 70) {
            y = -6;
        }
        if (x >= 71 && x <= 101) {
            y = 1;
        }
        return y;

    }

    public static int movimientoLiebre() {
        int y = 0;
        int x = (int) (Math.ceil(Math.random() * 101));
        if (x <= 20) {
            y = 0;
        }
        if (x >= 21 && x < 40) {
            y = 9;
        }
        if (x >= 41 && x <= 60) {
            y = -2;
        }
        if (x >= 61 && x <= 70) {
            y = -12;
        }
        if (x >= 71 && x <= 101) {
            y = 1;
        }
        return y;

    }

    public synchronized static void turno(String nombre) {
        if (nombre.equalsIgnoreCase("tortuga")) {
            t.mover(Carrera.movimientoTortuga(), t.getPosicion());
            System.out.println("Posicion de la tortuga: " + t.getPosicion());
            if (t.getPosicion() >= 100) {
                System.out.println("Llego la tortuga");
                System.exit(0);
            }
            Tortuga.turno = false;

        } else if (nombre.equalsIgnoreCase("liebre")) {

            l.mover(Carrera.movimientoLiebre(), l.getPosicion());
            System.out.println("Posicion de la liebre: " + l.getPosicion());
            if (l.getPosicion() >= 100) {
                System.out.println("LLego la liebre");
                System.exit(0);
            }
            Tortuga.turno = true;
    }
}
}
