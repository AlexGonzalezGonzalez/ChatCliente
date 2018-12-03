/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
class Hilo extends Thread {
    //id de los hilos hecho estatico para que cuando se cree un nuevo hilo
    //se le sume uno y esa variable la compartan todos asi el siguiente que se cree
    //se le asignara un id diferente al anterior
    static int pid;
    //cuenta que controla cuantos hilos se crearan
    int conta;
    //Variable de tipo Thread
    Hilo h1;

    Hilo(int x, int y) {
        //asignamos la cuenta que llevan los hilos
        this.conta = x;
        //asignamos el id al hilo
        this.pid = y;
        //mientras la cuenta sea menos a 5, empieza el hilo creado
        if (conta != 5) {

            this.start();
        }
    }
    @Override
    public void run() {
        
        System.out.println("Comenzo el Hilo " + pid);
        
        for (int i = 0; i < 10; i++) {
            
            try {
                //Muestra su id y la iteracion y lo suspende un tiempo random
                System.out.println("Hilo " + pid + ": " + i);
                Thread.sleep((long) (Math.random() * 600 + 100));
                if (i == 9) {
                    //en la ultima iteracion comprueba si hay menos de 4 hilos para no crear mas de 5
                    if (conta != 4) {
                        //aumentamos las variables para crear el hilo hijo
                        conta++;
                        pid++;
                        //Creamos el hijo 
                        Hilo h1 = new Hilo(conta, pid);
                        //Mientras el hilo hijo se este ejecutanto, no acaba
                        while (h1.isAlive()) {
                        }
                    }
                    //mostramos los id de los hilos
                    System.out.println("Acabo el Hilo " + pid);
                    /*Como cada hilo se queda esperando y la variable pid es estatica
                    al mostrar el primer mensaje la variable vale 5 porque tenemos 5 hilos
                    y hay que decrementarla para que muestre 4,3,2,1 cada vez que pasa un hilo
                    */
                    pid--;

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
