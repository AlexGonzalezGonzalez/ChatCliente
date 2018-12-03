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
public class Hilo23 extends Thread {
    String numero;
    int suma = 0;
    ArrayList<Integer> numeros = new ArrayList();

    Hilo23() {
        this.start();
    }
    public void run() {
        /*
        Para cada numero entre 1 y 1000
        cogemos cada caracter y preguntamos si tiene un 2 o un 3
        Si es asi lo metemos en un array
        */
        for (int i = 1; i < 1001; i++) {
         numero=String.valueOf(i);
         char ch=numero.charAt(numero.length()-1);
         if(ch=='2' || ch=='3'){
             numeros.add(i);
            }
        }
        //sumamos todos los numeros del array y los mostramos
        for (int i = 0; i < numeros.size(); i++) {
            suma=suma+numeros.get(i);
        }
        System.out.println(suma);
    }
}
