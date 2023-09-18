package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Esta clase contiene todas las constantes utilizadas a lo largo del proceso
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class Constantes {

    public static final Scanner sc = new Scanner(System.in);

    public static final int ATRIBUTO_MINIMO = 0;
    public static final int ATRIBUTO_MINIMO_INICIAL = 8;
    public static final int ATRIBUTO_MAXIMO_INICIAL = 16;
    public static final int ATRIBUTO_MAXIMO = 20;
    public static final int ATRIBUTO_COSTE_DOBLE = 14;

    // Atributos
    public static final String FUERZA = "Fuerza";
    public static final String DESTREZA = "Destreza";
    public static final String CONSTITUCION = "Constitucion";
    public static final String INTELIGENCIA = "Inteligencia";
    public static final String SABIDURIA = "Sabiduria";
    public static final String CARISMA = "Carisma";

    public static final int TOTAL_PUNTAJE_ATRIBUTOS = 27;

    // Habilidades
    // Fuerza
    public static final String ATLETISMO = "Atletismo";
    // Destreza
    public static final String ACROBACIAS = "Acrobacias";
    public static final String JUEGO_DE_MANOS = "Juego De Manos";
    public static final String SIGILO = "Sigilo";
    // Inteligencia
    public static final String ARCANO = "Arcano";
    public static final String HISTORIA = "Historia";
    public static final String INVESTIGACION = "Investigacion";
    public static final String NATURALEZA = "Naturaleza";
    public static final String RELIGION = "Religion";
    // Sabiduria
    public static final String TRATO_CON_ANIMALES = "Trato con Animales";
    public static final String PERSPICACIA = "Perspicacia";
    public static final String MEDICINA = "Medicina";
    public static final String PERCEPCION = "Percepcion";
    public static final String SUPERVIVENCIA = "Supervivencia";
    // Carisma
    public static final String ENGAÑO = "Engaño";
    public static final String INTIMIDACION = "Intimidacion";
    public static final String INTERPRETACION = "Interpretacion";
    public static final String PERSUASION = "Persuasion";


    // Creacion del logger
    public static final Logger log = Logger.getLogger("prueba");

    public static final String STRING_VACIO = "";

    public static final String STRING_NO = "No";

    public static final String RUTA_FICHERO = ".\\personajes";

    public static final Object SEPARADOR_CSV = ";";

    public static final Object SALTO_DE_LINEA = "\n";

    // El mapa de atributos y modificadores se crea en la clase de configuracion
    public static Map<Integer, Integer> mapaModificadoresPuntuacionAtributo = new HashMap<Integer, Integer>();
    
    // El mapa de niveles y modificadores
    public static Map<Integer, Integer> mapaModificadoresNivel = new HashMap<Integer, Integer>();

    public static final String RAZA = "Raza";
    public static final String CLASE = "Clase";
    public static final String NOMBRE = "Nombre";
    public static final String APELLIDOS = "Apellidos";
    public static final String MOTE = "Mote";
    public static final String EDAD = "Edad";
    public static final String FECHA_DE_NACIMIENTO = "Fecha de nacimiento";
    public static final String PESO = "Peso";
    public static final String ALTURA = "Altura";
    public static final String SEXO = "Sexo";
    public static final String NIVEL = "Nivel";

    private static final String MOD_COMPETENCIA = "Competencia ";
    private static final String MOD_HABILIDAD = "Habilidad ";
    
    public class ConfigJson {

        public static final String ATRIBUTOS = "Atributos";
        public static final String HABILIDADES = "Habilidades";
        public static final String RAZAS = "Razas";
        public static final String CLASES = "Clases";
        public static final String CONJUROS = "Conjuros";
        
        public class Atributos {

        }
        
        public class Habilidades {

        }

        public class Razas {
            public static final String DESCRIPCION = "Descripcion";
            public static final String ALTURA = "Altura";
            public static final String PESO = "Peso";
            public static final String EDAD = "Edad";
            public static final String VELOCIDAD = "Velocidad";
            public static final String CARACTERISTICAS = "Caracteristicas";
            public static final String SUBRAZAS = "Subrazas";
            public static final String CONJUROS = "Conjuros";
            public static final String NOMBRES = "Nombres";
        }

        public class Clases {
            public static final String DESCRIPCION = "Descripcion";
            public static final String DADO_DE_GOLPE = "Dado de Golpe";
            public static final String TIRADAS_DE_SALVACION = "Tiradas de salvacion";
            public static final String EQUIPO = "Equipo";
            public static final String COMPETENCIAS = "Competencias";
            public static final String HABILIDADES = "Habilidades";
        }

        public class Conjuros {

        }
    }

    public static String getCabecera() {
        StringBuilder sb = new StringBuilder();

        // Caracteristicas
        sb.append(Constantes.RAZA);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.CLASE);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.NOMBRE);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.APELLIDOS);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOTE);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.EDAD);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.FECHA_DE_NACIMIENTO);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.PESO);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.ALTURA);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.SEXO);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.NIVEL);

        // Atributos
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.FUERZA);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.DESTREZA);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.CONSTITUCION);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.INTELIGENCIA);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.SABIDURIA);
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.CARISMA);

        // Habilidades
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.ATLETISMO); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.ATLETISMO); // Mod hablidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.ACROBACIAS); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.ACROBACIAS); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.JUEGO_DE_MANOS); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.JUEGO_DE_MANOS); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.SIGILO); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.SIGILO); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.ARCANO); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.ARCANO); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.HISTORIA); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.HISTORIA); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.INVESTIGACION); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.INVESTIGACION); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.NATURALEZA); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.NATURALEZA); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.RELIGION); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.RELIGION); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.TRATO_CON_ANIMALES); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.TRATO_CON_ANIMALES); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.PERSPICACIA); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.PERSPICACIA); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.MEDICINA); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.MEDICINA); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.PERCEPCION); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.PERCEPCION); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.SUPERVIVENCIA); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.SUPERVIVENCIA); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.ENGAÑO); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.ENGAÑO); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.INTIMIDACION); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.INTIMIDACION); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.INTERPRETACION); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.INTERPRETACION); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_COMPETENCIA + Constantes.PERSUASION); // Mod competencia
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(Constantes.MOD_HABILIDAD + Constantes.PERSUASION); // Mod habilidad
        sb.append(Constantes.SEPARADOR_CSV);
        return sb.toString();
    }
}
