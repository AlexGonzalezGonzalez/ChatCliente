/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agonzalezgonzalez
 */
public class Ascensor {
    //piso: piso actual en el que se encuentra el ascensor
    static int piso = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos 5 clientes
        Cliente c1 = new Cliente(1, 10, "Quique");
        Cliente c2 = new Cliente(2, 4, "Samu");
        Cliente c3 = new Cliente(7, 5, "Alex");
        Cliente c4 = new Cliente(6, 3, "Adrian");
        Cliente c5 = new Cliente(9, 0, "LEPAGE");
    }
    
    /*
    Los clientes realizan llamadas que es este metodo
    Al ser synchronized solo un cliente puede hacer una llamada a la vez 
    Los otros esperan a que el otro cliente llegue a su destino
    Se muestran mensajes dependiendo si sube o baja comparando la posicion del ascensor y del origen y destino
    Se muestran mensajes si el cliente entra al ascensor o llega al destino
    */
    public synchronized static void llamada(Cliente c) {
        System.out.println(c.toString());
        if (c.getOrigen() > piso) {
            try {
                System.out.println("Ascensor en el piso: " + piso);
                System.out.println("Subiendo al piso " + c.getOrigen());
                Thread.sleep(100);
                System.out.println(c.getNombre() + " entro en el ascensor");
                if (c.getDestino() > c.getOrigen()) {
                    System.out.println("Subiendo al piso " + c.getDestino());
                    Thread.sleep(100);
                    System.out.println(c.getNombre() + " llego al destino");
                    piso = c.getDestino();
                } else {
                    System.out.println("Bajando al piso " + c.getDestino());
                    Thread.sleep(100);
                    System.out.println(c.getNombre() + " llego al destino");
                    piso = c.getDestino();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {

                System.out.println("Ascensor en el piso: " + piso);
                System.out.println("Bajando al piso " + c.getOrigen());
                Thread.sleep(100);
                System.out.println(c.getNombre() + " entro en el ascensor");
                if (c.getDestino() > c.getOrigen()) {
                    System.out.println("Subiendo al piso " + c.getDestino());
                    Thread.sleep(100);
                    System.out.println(c.getNombre() + " llego al destino");
                    piso = c.getDestino();
                } else {
                    System.out.println("Bajando al piso " + c.getDestino());
                    Thread.sleep(100);
                    System.out.println(c.getNombre() + " llego al destino");
                    piso = c.getDestino();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
