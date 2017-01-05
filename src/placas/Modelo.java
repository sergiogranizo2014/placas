/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/***
 *
 * @author Winner
 */
/**
 * Clase Modelo: Contiene los datos y las estructuras de datos necesarios
 * para la manipulación de los mismos
 */
public class Modelo {
    /** 
    * Mapa para vincular cada dia con su configuración respectiva
    */
     Map<String, Object[]> mapa = new TreeMap<String, Object[]>();
    
    private Object[] lunes = new Object[6];
    private Object[] martes = new Object[6];
    private Object[] miercoles = new Object[6];
    private Object[] jueves = new Object[6];
    private Object[] viernes = new Object[6];

    public Object[] getDiaLunes() {
        return lunes;
    }

    public void setDiaLunes(Object[] lunes) {
        this.lunes = lunes;
    }

    public Object[] getDiaMartes() {
        return martes;
    }

    public void setDiaMartes(Object[] martes) {
        this.martes = martes;
    }

    public Object[] getDiaMiercoles() {
        return miercoles;
    }

    public void setDiaMiercoles(Object[] miercoles) {
        this.miercoles = miercoles;
    }

    public Object[] getDiaJueves() {
        return jueves;
    }

    public void setDiaJueves(Object[] jueves) {
        this.jueves = jueves;
    }

    public Object[] getDiaViernes() {
        return viernes;
    }

    public void setDiaViernes(Object[] viernes) {
        this.viernes = viernes;
    }
    
    
    
    /**
    * Constructor del Modelo: Cuando se crea una instancia de esta clase, paralelamente
    * se cargan todos los datos en el Map, para evitar errores de NullPoinerException
    */
    public Modelo() {
        llenarDatos();
    }

    /**
    * Metodo Llenar Datos: Con este metodo se carga toda la informacion que corresponde
    * a los dias que se aplica el Pico y Placa con los respectivos horarios de
    * restriccion para la circulacion y el ultimo digito de la placa que se toma en cuenta 
    * para dicha restriccion
    */
    public Map<String, Object[]> llenarDatos() {
    /**
    * Arreglo de Objetos para la configuracion del Dia lunes
    * Ultimo digito de la placa 1 y 2
    * Horario de Restriccion
    * Mañana: Desde 07h00 hasta 09h30
    * Tarde y Noche: Desde 16h00 hasta 19h30
    */
        
        lunes[0] = 1;
        lunes[1] = 2;              //digito de la placa
        lunes[2] = "07:00";
        lunes[3] = "09:30";  // Hora pico mañana
        lunes[4] = "16:00";
        lunes[5] = "19:30";  // Hora pico tarde y noche

    /**
    * Arreglo de Objetos para la configuracion del Dia Martes
    * Ultimo digito de la placa 3 y 4
    * Horario de Restriccion
    * Mañana: Desde 07h00 hasta 09h30
    * Tarde y Noche: Desde 16h00 hasta 19h30
    */
        martes[0] = 3;
        martes[1] = 4;
        martes[2] = "07:00";
        martes[3] = "09:30";  // Hora pico mañana
        martes[4] = "16:00";
        martes[5] = "19:30";  // Hora pico tarde y noche

    /**
    * Arreglo de Objetos para la configuracion del Dia Miercoles
    * Ultimo digito de la placa 5 y 6
    * Horario de Restriccion
    * Mañana: Desde 07h00 hasta 09h30
    * Tarde y Noche: Desde 16h00 hasta 19h30
    */
        miercoles[0] = 5;
        miercoles[1] = 6;
        miercoles[2] = "07:00";
        miercoles[3] = "09:30";  // Hora pico mañana
        miercoles[4] = "16:00";
        miercoles[5] = "19:30";  // Hora pico tarde y noche

    /**
    * Arreglo de Objetos para la configuracion del Dia Jueves
    * Ultimo digito de la placa 7 y 8
    * Horario de Restriccion
    * Mañana: Desde 07h00 hasta 09h30
    * Tarde y Noche: Desde 16h00 hasta 19h30
    */
        jueves[0] = 7;
        jueves[1] = 8;
        jueves[2] = "07:00";
        jueves[3] = "09:30";  // Hora pico mañana
        jueves[4] = "16:00";
        jueves[5] = "19:30";  // Hora pico tarde y noche

    /**
    * Arreglo de Objetos para la configuracion del Dia Viernes
    * Ultimo digito de la placa 9 y 0
    * Horario de Restriccion
    * Mañana: Desde 07h00 hasta 09h30
    * Tarde y Noche: Desde 16h00 hasta 19h30
    */
        viernes[0] = 9;
        viernes[1] = 0;
        viernes[2] = "07:00";
        viernes[3] = "09:30";  // Hora pico mañana
        viernes[4] = "16:00";
        viernes[5] = "19:30";  // Hora pico tarde y noche

        mapa.put("lunes", lunes);
        mapa.put("martes", martes);
        mapa.put("miercoles", miercoles);
        mapa.put("jueves", jueves);
        mapa.put("viernes", viernes);

        return mapa;

    }

    /**
    * metodo Recorrer arreglo: Permite recorrer el modelo de datos, segun el dia
    * que se necesite para extraer y verificar la información correspondiente al 
    * Pico y Placa sea correcta
    */
    public Object[] recorrerArreglo(String diaE) {
        Set set = mapa.entrySet();
        Iterator iterator = set.iterator();
        Object[] dia = null;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
           if(mentry.getKey().equals(diaE)) {
            dia = (Object[]) mentry.getValue();
           }
        }
       return dia;
    }

    /**
    * Metodo Validar Dia, Placa y Ultimo Digito: Metodo principal que compara
    * la fecha, hora y la placa previamente validados y verifica si el usuario puede 
    * circular en la fecha y hora ingresada 
    */
    public String validarDiaPlaca(String fecha, char ultimoDigito, List<Integer> horasMinutos) {
        StringBuilder res = new StringBuilder();
        Set set = mapa.entrySet();
        Iterator iterator = set.iterator();
        Object[] dia;
        if (fecha.equals("sábado") || fecha.equals("domingo")) {
        } else {
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                if (fecha.equals(mentry.getKey())) {
                    dia = (Object[]) mentry.getValue();
                    int ultimo = Integer.parseInt(String.valueOf(ultimoDigito));
                    int dig1 = (int) dia[0];
                    int dig2 = (int) dia[1];
                    if (ultimo == dig1 || ultimo == dig2) {
                        String resu = (compararHora(dia, horasMinutos)) ? "Puede Circular, pero esté pendiente del horario de Restricción" : "No puede Circular hoy por el pico y placa";
                        res.append(resu).append("\n");
                        break;

                    } else {
                        res.append("Puede Circular libremente"+"\n");
                        break;
                    }
                }
            }
            
        }
        return res.toString();
    }

    /**
    * Metodo Comparar Hora: Compara la hora que selecciona le usuario con la hora
    * de restriccion del Pico y Placa, este metodo devuelve verdadero si el
    * usuario puede circular en dicha hora y falso si no puede hacerlo
    */
    public Boolean compararHora(Object[] dia, List<Integer> lista) {
        Boolean puedeCircular;

        Placa pl = new Placa();
        List<Integer> iniM = pl.obtenerHoraMinuto(dia[2].toString());
        List<Integer> finM = pl.obtenerHoraMinuto(dia[3].toString());
        List<Integer> iniT = pl.obtenerHoraMinuto(dia[4].toString());
        List<Integer> finT = pl.obtenerHoraMinuto(dia[5].toString());

        if ((lista.get(0) >= iniM.get(0) && lista.get(0) <= finM.get(0)) || (lista.get(0) >= iniT.get(0) && lista.get(0) <= finT.get(0))) {

            if ((lista.get(0) == 9 || lista.get(0) == 19) && lista.get(1) > 30) {
                puedeCircular = true;
            } else {
                puedeCircular = false;
            }
        } else {
            puedeCircular = true;
        }
        return puedeCircular;
    }


}
