import java.util.HashMap;
import java.util.Map;

public class Constantes {

    public static final String BOTON_EXIT = "Exit";
    public static final String BOTON_CREAR_PERSONAJE = "Crear personaje";
    public static final String BOTON_GUARDAR_PJ = "Guardar personaje";
    
    // Etiquetas
    public static final String LABEL_IMAGEN = "Foto";
    public static final String LABEL_RAZA = "Raza:";
    public static final String LABEL_CLASE = "Clase:";
    public static final String LABEL_ALINEAMIENTO = "Alineamiento:";
    public static final String LABEL_NIVEL = "Nivel:";
    public static final String LABEL_NOMBRE = "Nombre:";
    public static final String LABEL_APELLIDOS = "Apellidos:";
    public static final String LABEL_PESO = "Peso:";
    public static final String LABEL_ALTURA = "Altura:";
    public static final String LABEL_ATRIBUTO_FUERZA = "Fuerza";
    public static final String LABEL_ATRIBUTO_DESTREZA = "Destreza";
    public static final String LABEL_ATRIBUTO_CONSTITUCION = "Constitucion";
    public static final String LABEL_ATRIBUTO_INTELIGENCIA = "Inteligencia";
    public static final String LABEL_ATRIBUTO_SABIDURIA = "Sabiduria";
    public static final String LABEL_ATRIBUTO_CARISMA = "Carisma";
    public static final String LABEL_VALOR = "Valor_";
    public static final String LABEL_MODIFICADOR = "Modificador_";
    public static final String LABEL_MOD_COMPETENCIA = "Modificador Competencia";
    public static final String LABEL_HABILIDAD_ATLETISMO = "Atletismo";
    public static final String LABEL_HABILIDAD_ACROBACIAS = "Acrobacias";
    public static final String LABEL_HABILIDAD_JUEGO_DE_MANOS = "Juego de Manos";
    public static final String LABEL_HABILIDAD_SIGILO = "Sigilo";
    public static final String LABEL_HABILIDAD_ARCANO = "Arcano";
    public static final String LABEL_HABILIDAD_HISTORIA = "Historia";
    public static final String LABEL_HABILIDAD_INVESTIGACION = "Investigacion";
    public static final String LABEL_HABILIDAD_NATURALEZA = "Naturaleza";
    public static final String LABEL_HABILIDAD_TRATO_CON_ANIMALES = "Trato con animales";
    public static final String LABEL_HABILIDAD_PERSPICACIA = "Perspicacia";
    public static final String LABEL_HABILIDAD_MEDICINA = "Medicina";
    public static final String LABEL_HABILIDAD_PERCEPCION = "Percepcion";
    public static final String LABEL_HABILIDAD_SUPERVIVENCIA = "Supervivencia";
    public static final String LABEL_HABILIDAD_ENGANO = "Engaño";
    public static final String LABEL_HABILIDAD_INTIMIDACION = "Intimidacion";
    public static final String LABEL_HABILIDAD_INTERPRETACION = "Intrepretacion";
    public static final String LABEL_HABILIDAD_PERSUASION = "Persuasion";

    // Combos
    public static final String COMBO_RAZA = "Raza";
    public static final String COMBO_CLASE = "Clase";
    public static final String COMBO_ALINEAMIENTO = "Alineamiento";
    public static final String COMBO_NIVEL = "Nivel";

    // Alineamiento
    public static final String ALINEAMIENTO_LEGAL_BUENO = "Legal Bueno";
    public static final String ALINEAMIENTO_LEGAL_NEUTRO = "Legal Neutral";
    public static final String ALINEAMIENTO_LEGAL_MALVADO = "Legal Malvado";
    public static final String ALINEAMIENTO_NEUTRAL_BUENO = "Neutral Bueno";
    public static final String ALINEAMIENTO_NEUTRO = "Neutral";
    public static final String ALINEAMIENTO_NEUTRAL_MALVADO = "Neutral Malvado";
    public static final String ALINEAMIENTO_CAOTICO_BUENO = "Caotico Bueno";
    public static final String ALINEAMIENTO_CAOTICO_NEUTRO = "Caotico Neutral";
    public static final String ALINEAMIENTO_CAOTICO_MALVADO = "Caotico Malvado";
    
    public static final int NIVEL_MAXIMO = 20;

    public static Map<String, String> mapaNivelesModCompetencia = new HashMap<>();

    public static void inicializarMapaNivelCompetencia() {
        mapaNivelesModCompetencia.put("1", "+2");
        mapaNivelesModCompetencia.put("2", "+2");
        mapaNivelesModCompetencia.put("3", "+2");
        mapaNivelesModCompetencia.put("4", "+2");
        mapaNivelesModCompetencia.put("5", "+3");
        mapaNivelesModCompetencia.put("6", "+3");
        mapaNivelesModCompetencia.put("7", "+3");
        mapaNivelesModCompetencia.put("8", "+3");
        mapaNivelesModCompetencia.put("9", "+4");
        mapaNivelesModCompetencia.put("10", "+4");
        mapaNivelesModCompetencia.put("11", "+4");
        mapaNivelesModCompetencia.put("12", "+4");
        mapaNivelesModCompetencia.put("13", "+5");
        mapaNivelesModCompetencia.put("14", "+5");
        mapaNivelesModCompetencia.put("15", "+5");
        mapaNivelesModCompetencia.put("16", "+5");
        mapaNivelesModCompetencia.put("17", "+6");
        mapaNivelesModCompetencia.put("18", "+6");
        mapaNivelesModCompetencia.put("19", "+6");
        mapaNivelesModCompetencia.put("20", "+6");
    }
}
