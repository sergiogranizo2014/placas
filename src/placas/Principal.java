/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placas;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import placas.vista.Vista;

/***
 *
 * @author Winner
 */
    /**
    * Esta clase contiene el metodo principal para ejecutar la aplicacion
    */
public class Principal {

    /***
     * @param args the command line arguments
     */
    /**
    EJERCICIO
     “Pico y placa"
     Escriba un programa que reciba como 3 entradas: Fecha, Hora y la ruta de un archivo de texto.
     El contenido del archivo será un listado de “PLACAS”
     El formato de la placa es el siguiente: PBC-1234
     El formato del archivo:
     PBC-1231
     PBC-1232
     PBC-1233
     PBC-1234
 
     El Programa debe leer el contenido del archivo y validar que las placas tengan el formato correcto, 
     además debe decirme si cada una de las placas tiene posibilidad de circular en la fecha y hora ingresadas.
     */
    /**
     * Ejecucion de la aplicacion
    */
    public static void main(String[] args) {
        
        Vista vista = new Vista();
        vista.setVisible(true);

    }

}
