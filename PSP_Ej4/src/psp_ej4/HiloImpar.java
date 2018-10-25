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
public class HiloImpar extends Thread {

    int suma = 0;
    ArrayList<Integer> numeros = new ArrayList();

    HiloImpar() {
        this.start();
    }

    @Override
    public void run() {

        for (int i = 1; i < 1001; i++) {
            if (i % 2 != 0) {
                numeros.add(i);
            }
        }
        for (int i = 0; i < numeros.size(); i++) {
            suma = suma + numeros.get(i);
            System.out.println(suma);
        }
    }
}
