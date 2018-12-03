/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_7;

/**
 *
 * @author agonzalezgonzalez
 */
public class Ejercicio_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BuzonCorreo bz = new BuzonCorreo();
        //creamos escritores y lectores con su codigo correspondiente
        Escritor es1 = new Escritor(bz,0);
        Escritor es2 = new Escritor(bz,2);
        Escritor es3 = new Escritor(bz,4);
        Lector lc1 = new Lector(bz,1);
        Lector lc2 = new Lector(bz,3);
        Lector lc3 = new Lector(bz,5);
        
        
      

    }

}
