/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_6;

/**
 *
 * @author alejandro
 */
class CubbyHole {

    boolean y = false;
    int x = 100;
    private int conta = 0;

    public int getInit() {
        return x;

    }

    public synchronized int getX() {

        if (conta > 0) {

            while (y == false) {
                try {

                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        conta++;
        y = false;
        return x;

    }

    public synchronized void setX(int valor) {
        x = valor;
        System.out.println("Total: " + x);
        y = true;
        notifyAll();
    }

}
