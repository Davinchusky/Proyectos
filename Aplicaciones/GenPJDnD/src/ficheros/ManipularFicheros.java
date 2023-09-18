package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.Constantes;

import clases.Personaje;

public class ManipularFicheros {
    
    public static String leerFichero(String direccion) {
        String lectura = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (direccion);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                lectura += linea;
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            } catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        return lectura;
    }

    public static void guardarDatosPersonaje(Personaje personaje) {
        String ruta = Constantes.RUTA_FICHERO + "\\" + personaje.getCaracteristicas().getNombre() 
                        + "_" + personaje.getCaracteristicas().getApellidos() 
                        + "_" + personaje.getCaracteristicas().getNivel() + "lvl.csv";
        try {
            FileWriter fw = new FileWriter(ruta, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea = personaje.getCSV();
            
            bw.write(linea);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
