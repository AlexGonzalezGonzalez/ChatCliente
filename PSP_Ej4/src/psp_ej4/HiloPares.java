/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej4;

import java.util.ArrayList;

/**
 *
 * @author oracle
 */
class HiloPares extends Thread {

    
    int suma=0;
    ArrayList <Integer> numeros= new ArrayList();
    public HiloPares() {
        //empezamos el hilo
        this.start();
    }

    @Override
    public void run() {
         //Añadimos a un array los numeros pares entre 1 y 1000
         for (int i = 1; i < 1001; i++) {
            if(i%2==0){
                numeros.add(i);
            }
        }
         //sumamos todos los numeros pares y vamos mostrando el resultado de cada suma
         for (int i = 0; i < numeros.size(); i++) {
            suma=suma+numeros.get(i);
             System.out.println(suma);
        }
    }
}
