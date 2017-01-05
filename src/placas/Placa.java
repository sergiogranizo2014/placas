/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 *
 * @author Winner
 */
/**
Clase Placa
Esta clase contiene metodos de validacion mediante expresiones regulares y 
conversion de formatos 
*/
public class Placa {
    /**
     * Metodo Validar Placa: Mediante una expresion regular se verifica que la
     * placa cumpla el formato solicitado, en este caso los tres primeros caracteres 
     * deben ser letras, exceptuando D, F y Ñ seguidos de un guion medio y 
     * finalmente tres o cuatros caracteres numericos, Si la placa cumple el formato
     * se devuelve true, caso contrario devuelve false
     */
    public Boolean validarPlaca(String placa) {
        Matcher matcher = Pattern.compile("^(((?![D|F|Ñ])[A-Z]){3}-\\d{3,4})$").matcher(placa);
        return matcher.matches();
    }

    /**
    * Metodo Obtener Dia: Se recibe la fecha que el usuario seleccionada en la
    * interfaz grafica, se transforma en un arreglo de objetos y se extrae la 
    * primera posición, ya que ahi se encuentra almecenado el dia en forma
    * de cadena de Texto
    */
    public String obtenerDia(String fechaSeleccionada) {
        List palabras = Arrays.asList(Pattern.compile("\\s+").split(fechaSeleccionada));
        for (String s : (List<String>) palabras);
        return palabras.get(0).toString();
    }
    /**
    * Método Obtener Hora y minutos: Se recibe la hora que el usuario selecciona en
    * la interfaz grafica,en formato HH:mm, se transforma en un arreglo de dos
    * posiciones, la primera posicion almacena la hora y la segunda los minutos
    */
    public List<Integer> obtenerHoraMinuto(String horaSeleccionada) {
        List<Integer> horasMinutos = new ArrayList<>();
        List palabras = Arrays.asList(Pattern.compile(":+").split(horaSeleccionada));
        for (String s : (List<String>) palabras) {
            horasMinutos.add(Integer.parseInt(s));
        }

        return horasMinutos;
    }

    /**
    * Método Obtener Ultimo Digito: Se recibe la placa previamente validada, y se
    * extrae el último digito, este método devuelve un char que representa el 
    * ultimo digito
    */
    public char obtenerUltimoDigito(String placaValidada) {
        int n = placaValidada.length();
        char ultimoDigito = placaValidada.charAt(n - 1);
        return ultimoDigito;
    }

    /**
    * Método Formatear fecha: Permite Cambiar el formato de un Date tradicional a
    * un formato personalizado, Ejemplo: Se recibe la entrada 1/4/2017 y la cambia 
    * al formato 'Miercoles 4 de Enero de 2017', la fecha se devuelve en una cadena
    * de texto
    */
    public String formatearFecha(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMMM 'de' yyyy");
        String fechaSeleccionada = dateFormat.format(date);
        return fechaSeleccionada;
    }

}
