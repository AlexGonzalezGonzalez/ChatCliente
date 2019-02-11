/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agonzalezgonzalez
 */
public class Lector implements Runnable{
    InputStream lector;
    Lector(InputStream is){
        this.lector=is;
        new Thread(this).start();
    }
    @Override
    public void run() {
            
        while(true){
            try {
                byte[] mensaje = new byte[2000];
                lector.read(mensaje);
                if(lector.available()>0){
                String msg = new String(mensaje);
                System.out.println("Leer: "+new String(mensaje));
                Vista.chat.append(msg);
                }
                        
            } catch (IOException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
