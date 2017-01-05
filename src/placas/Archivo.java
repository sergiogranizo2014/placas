/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;

/***
 *
 * @author Winner
 */

/**
* Clase Archivo
* Contiene los metodos necesarios para trabajar con archivos externo
* y extraer su información
*/
public class Archivo {
   private BufferedReader buffer;

    public BufferedReader getBuffer() {
        return buffer;
    }

    public void setBuffer(BufferedReader buffer) {
        this.buffer = buffer;
    }
    
    public Archivo(){
        setBuffer(getBuffer());
    }
    
    /**
    * Metodo Leer: Permite Leer un archivo externo y devuelve el contenido
    * del fichero en un objeto BufferedReader
    */
  public BufferedReader leer(){
      JFileChooser buscador = new JFileChooser();
      buscador.showOpenDialog(buscador);
      
  try{
      String patch= buscador.getSelectedFile().getAbsolutePath();
      FileInputStream archivo = new FileInputStream(patch);
      DataInputStream entrada = new DataInputStream(archivo);
      buffer = new BufferedReader(new InputStreamReader(entrada));
  }catch(Exception e){
      System.out.println("Error:  "+e.getMessage());
  }
   return getBuffer();
  }
}
