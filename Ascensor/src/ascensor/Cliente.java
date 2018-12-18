/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

/**
 *
 * @author agonzalezgonzalez
 */
public class Cliente implements Runnable{
    /*
    origen: piso en el que esta el cliente
    destino: piso al que quiere ir el cliente
    nombre: nombre del cliente
    */
    private int origen;
    private int destino;
    private String nombre;
    
    //Le asignamos las variables y empezamos el hilo
    Cliente(int o,int d,String n){
        this.origen=o;
        this.destino=d;
        this.nombre=n;
        
        new Thread(this).start();
    }
    
    //el cleinte hace su llamada
    @Override
    public void run() {
        Ascensor.llamada(this);
    }
    
    //getters y setters
    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente: " + "origen: " + origen + ", destino: " + destino + ", nombre: " + nombre;
    }
    
}