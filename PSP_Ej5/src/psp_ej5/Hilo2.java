/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
class Hilo2 extends Thread {
    //id del proceso
    int pid;
    //cuenta de hilos
    static int conta = 0;

    public Hilo2(int pid) {
        //asignamos el id
        this.pid = pid;
        //preguntamos si es el primer hilo
        if (Hilo.conta == 0) {
            try {
                //sumamos la cuenta para que el hilo hijo no entre en este if
                Hilo.conta++;
                //creamos el hilo hijo
                Hilo2 h2 = new Hilo2(2);
                //Con join al crear al hijo hacemos que el padre se quede esperando a que acabe el hijo
                h2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //empezamos el hilo, aun asi con prioridades es posible que no se ejecute primero el segundo hilo
        this.start();
    }

    public void run() {

        System.out.println("Hola soy el Hilo " + pid);

    }
}