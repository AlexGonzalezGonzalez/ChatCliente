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
class Lector implements Runnable {
    /*
    bz: objeto buzon
    pid: id del proceso
    */
    BuzonCorreo bz;
    private int pid;

    //asignamos las variables
    public Lector(BuzonCorreo bz, int x) {
        this.bz = bz;
        this.pid = x;
        new Thread(this).start();
    }

    @Override
    public void run() {
        //leemos el mensaje
            bz.getMensaje(pid); 
    }

}
