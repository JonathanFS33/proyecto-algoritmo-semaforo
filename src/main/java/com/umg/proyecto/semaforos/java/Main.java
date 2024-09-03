package com.umg.proyecto.semaforos.java;

import com.umg.proyecto.semaforos.vista.Ventana;

/**
 *
 * @author Jonathan
 */
public class Main {

    public static void main(String[] args) {
        try {
            Ventana v = new Ventana();
            v.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
