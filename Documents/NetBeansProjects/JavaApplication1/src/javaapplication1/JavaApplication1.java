/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.net.*;

/**
 *
 * @author roman
 */
public class JavaApplication1 {
   
    private static String HOST = "localhost";
    private static int PUERTO = 2017;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Socket socket;
        DataOutputStream mensaje;
        try { 
            socket = new Socket(HOST, PUERTO);
            mensaje = new DataOutputStream(socket.getOutputStream());
            mensaje.writeUTF("Hola soy un cliente!!");
            socket.close();
        } catch (UnknownHostException e) {
           System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }    
    }
    
}
