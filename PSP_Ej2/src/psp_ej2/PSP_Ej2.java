/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_ej2;

/**
 *
 * @author oracle
 */
public class PSP_Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo h1= new Hilo(1);
        Hilo h2= new Hilo(2);
        Hilo h3= new Hilo(3);
        Hilo h4= new Hilo(4);
        //mientras alguno siga ejecutandose, no se muestra el mensaje
        while(h1.isAlive() && h2.isAlive() && h3.isAlive() && h4.isAlive()){
            
        }
        System.out.println("Acabo");
    }
    
}
