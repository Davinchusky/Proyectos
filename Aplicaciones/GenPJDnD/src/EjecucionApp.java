import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.Configuracion;
import com.Constantes;

import clases.Atributo;
import clases.Caracteristicas;
import clases.Clase;
import clases.Habilidades;
import clases.Personaje;
import clases.Raza;
import ficheros.ManipularFicheros;

/**
 * Esta clase contiene la ejecucion del codigo y metodos para actuar sobre la configuracion y los personajes
 * que se quieren crear
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class EjecucionApp {

    private Configuracion config;

    /**
     * Funcion principal de ejecucion del hilo
     */
    public void run() {
        // BasicConfigurator.configure();
        // Constantes.log.info("Esto es una prueba de log");
        String datos = ManipularFicheros.leerFichero("./resources/data.json");
        config = new Configuracion(new JSONObject(datos));
        List<Personaje> personajes = new ArrayList<>();

        // Ejecucion proceso
        boolean finalizar = false;
        while (!finalizar) {
            imprimirMenu();
            String linea = Constantes.sc.nextLine();
            switch (linea) {
                case "1": // Mostrar razas y clases disponibles
                    mostrarDatosConfiguracion();
                    break;
                case "2": // Mostrar personajes creados
                    System.out.println(personajes.toString());
                    break;
                case "3": // Crear un nuevo personaje
                    Personaje personaje = crearPersonaje();
                    System.out.println("Personaje creado: " + personaje.toString());
                    personajes.add(personaje);
                    break;
                case "4": // Editar personaje
                    int indexPJ = obtenerPersonaje(personajes);
                    if (indexPJ != -1) {
                        editarPersonaje(personajes.get(indexPJ));
                    }
                    break;
                case "0": // Fin del programa
                    for (Personaje personaje2 : personajes) {
                        ManipularFicheros.guardarDatosPersonaje(personaje2);
                    }
                    finalizar = true;
                    break;
                default:
            }
        }
    }

    /**
     * Funcion que permite editar un personaje que se haya creado
     * @param personaje
     */
    private void editarPersonaje(Personaje personaje) {
        while (true) {
            System.out.println("Indique que desea editar entre raza, clase, caracteristicas o atributos.");
            String linea = Constantes.sc.nextLine();
            linea = linea.toLowerCase().trim();
            switch (linea) {
                case "raza":
                    personaje.setRaza(seleccionarRaza());
                    break;
                case "clase":
                    personaje.setClase(seleccionarClase());
                    break;
                case "caracteristicas":
                    modificarCaracteristicas(personaje);
                    break;
                case "atributos":
                    modificarAtributos(personaje);
                    break;
                default:
            }
            System.out.println("¿Desea modificar algo mas? escriba Si o No");
            linea = Constantes.sc.nextLine();
            if (linea.trim().equalsIgnoreCase(Constantes.STRING_NO)) {
                return;
            }
        }

    }

    /**
     * Funcion que permite modificar los atributos del personaje
     * @param personaje
     */
    private void modificarAtributos(Personaje personaje) {
        while (true) {
            System.out.println("Indique que atributo desea modificar");
            System.out.println(personaje.getAtributos().toString());
            String atributoAModificar = Constantes.sc.nextLine();
            atributoAModificar = atributoAModificar.substring(0,1).toUpperCase() + atributoAModificar.substring(1,atributoAModificar.length()).toLowerCase().trim();

            Atributo atributo = personaje.getAtributos().get(atributoAModificar);
            if (atributo != null) {
                System.out.println("¿Que nuevo valor desea asignar? Valor actual: " + atributo.getValor());
                String nuevoValor = Constantes.sc.nextLine();
                atributo.setValor(Integer.valueOf(nuevoValor));
            } else {
                System.out.println("Ha insertado el nombre de un atributo no existente.");
            }

            System.out.println("¿Desea modificar algún atributo mas? escriba Si o No");
            String linea = Constantes.sc.nextLine();
            if (linea.trim().equalsIgnoreCase(Constantes.STRING_NO)) {
                return;
            }
        }
    }

    // /**
    //  * Esta funcion busca en el personaje el atributo cuyo nombre coincide con el nombre pasado por parametro
    //  * @param personaje
    //  * @return
    //  */
    // private Atributo obtenerAtributoDesdeNombre(List<Atributo> atributos, String nombreAtributo) {
    //     for (Atributo atributo : atributos) {
    //         if (atributo.getNombre().equalsIgnoreCase(nombreAtributo)) {
    //             return atributo;
    //         }
    //     }
    //     return null;
    // }

    /**
     * Funcion que permite modificar una o mas caracteristicas del personaje en funcion de lo que escriba el usuario
     * @param personaje
     */
    private void modificarCaracteristicas(Personaje personaje) {
        while (true) {
            System.out.println("¿Que caracteristica desea modificar?");
            System.out.println(personaje.getCaracteristicas().toString());
            String caracteristica = Constantes.sc.nextLine();
            caracteristica = caracteristica.toLowerCase().trim();
            System.out.println("¿Que nuevo valor desea asignar?");
            String nuevoValor = Constantes.sc.nextLine();
            switch (caracteristica) {
                case "nombre":
                    personaje.getCaracteristicas().setNombre(nuevoValor);
                    break;
                case "apellidos":
                    personaje.getCaracteristicas().setApellidos(nuevoValor);
                    break;
                case "mote":
                    personaje.getCaracteristicas().setMote(nuevoValor);
                    break;
                case "edad":
                    personaje.getCaracteristicas().setEdad(nuevoValor);
                    break;
                case "fecha de nacimiento":
                    personaje.getCaracteristicas().setFechaNacimiento(nuevoValor);
                    break;
                case "peso":
                    personaje.getCaracteristicas().setPeso(nuevoValor);
                    break;
                case "altura":
                    personaje.getCaracteristicas().setAltura(nuevoValor);
                    break;
                case "sexo":
                    personaje.getCaracteristicas().setSexo(nuevoValor);
                    break;
                case "nivel":
                    personaje.getCaracteristicas().setNivel(Integer.valueOf(nuevoValor));
                    break;
            }
            System.out.println("¿Desea modificar algo mas? escriba Si o No");
            String linea = Constantes.sc.nextLine();
            if (linea.trim().equalsIgnoreCase(Constantes.STRING_NO)) {
                return;
            }
        }
    }

    /**
     * Devuelve un personaje de la lista a traves del mote que introduzca el usuario
     * @param personajes
     * @return
     */
    private int obtenerPersonaje(List<Personaje> personajes) {
        System.out.println("Escriba a continuacion el mote del personaje que desea editar");
        String linea = Constantes.sc.nextLine();
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getCaracteristicas().getMote().equalsIgnoreCase(linea)) {
                return i;
            }
        }
        System.out.println("El mote introducido no es de un personaje que se haya creado.");
        return -1;
    }

    /**
     * Funcion que permite crear un personaje desde 0
     * @return
     */
    private Personaje crearPersonaje() {
        Raza raza = seleccionarRaza();

        Caracteristicas caracteristicas = crearCaracteristicas();

        Clase clase = seleccionarClase();

        Map<String, Atributo> atributos = getAtributos();

        Map<String, Habilidades> habilidades = crearHabilidades(atributos, caracteristicas.getNivel());
        
        return new Personaje(caracteristicas, raza, clase, atributos, habilidades);
    }

    private Map<String, Habilidades> crearHabilidades(Map<String, Atributo> atributos, int nivel) {
        Map<String, Habilidades> mapaAtributos = getListaHabilidades(atributos, nivel);
        int modCompetencia = Constantes.mapaModificadoresNivel.get(nivel);
        for (String nombreAtributo : mapaAtributos.keySet()) {
            mapaAtributos.get(nombreAtributo).setModificadorCompetencia(modCompetencia);
        }
        return mapaAtributos;
    }

    private Map<String, Habilidades> getListaHabilidades(Map<String, Atributo> mapaAtributos, int competencia) {
        Map<String, Habilidades> habilidades = new HashMap<>();
        Habilidades atletismo = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.FUERZA));
        Habilidades acrobacias = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.DESTREZA));
        Habilidades juegoDeManos = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.DESTREZA));
        Habilidades sigilo = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.DESTREZA));
        Habilidades arcano = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.INTELIGENCIA));
        Habilidades historia = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.INTELIGENCIA));
        Habilidades investigacion = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.INTELIGENCIA));
        Habilidades naturaleza = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.INTELIGENCIA));
        Habilidades religion = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.INTELIGENCIA));
        Habilidades tratoConAnimales = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.SABIDURIA));
        Habilidades perspicacia = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.SABIDURIA));
        Habilidades medicina = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.SABIDURIA));
        Habilidades percepcion = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.SABIDURIA));
        Habilidades supervivencia = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.SABIDURIA));
        Habilidades engaño = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.CARISMA));
        Habilidades intimidacion = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.CARISMA));
        Habilidades interpretacion = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.CARISMA));
        Habilidades persuasion = new Habilidades(0, false, 
                                                competencia, mapaAtributos.get(Constantes.CARISMA));

        habilidades.put(Constantes.ATLETISMO, atletismo);
        habilidades.put(Constantes.ACROBACIAS, acrobacias);
        habilidades.put(Constantes.JUEGO_DE_MANOS, juegoDeManos);
        habilidades.put(Constantes.SIGILO, sigilo);
        habilidades.put(Constantes.ARCANO, arcano);
        habilidades.put(Constantes.HISTORIA, historia);
        habilidades.put(Constantes.INVESTIGACION, investigacion);
        habilidades.put(Constantes.NATURALEZA, naturaleza);
        habilidades.put(Constantes.RELIGION, religion);
        habilidades.put(Constantes.TRATO_CON_ANIMALES, tratoConAnimales);
        habilidades.put(Constantes.PERSPICACIA, perspicacia);
        habilidades.put(Constantes.MEDICINA, medicina);
        habilidades.put(Constantes.PERCEPCION, percepcion);
        habilidades.put(Constantes.SUPERVIVENCIA, supervivencia);
        habilidades.put(Constantes.ENGAÑO, engaño);
        habilidades.put(Constantes.INTIMIDACION, intimidacion);
        habilidades.put(Constantes.INTERPRETACION, interpretacion);
        habilidades.put(Constantes.PERSUASION, persuasion);
        return habilidades;
    }

    /**
     * Funcion que crea los atributos de un personaje segun elija el usuario
     * @return
     */
    private Map<String, Atributo> getAtributos() {
        while (true) {
            System.out.println("¿Cómo desea crear los atributos?");
            System.out.println("Pulse 1 para crearlo de forma totalmente aleatoria entre " + Constantes.ATRIBUTO_MINIMO_INICIAL 
                                + " y " + Constantes.ATRIBUTO_MAXIMO_INICIAL);
            System.out.println("Pulse 2 para seleccionar asignar en función del array [15, 14,  13,  12,  10,  8]");
            System.out.println("Pulse 3 si desea distribuir los 27 puntos entre los diferentes atributos");
            String linea = Constantes.sc.nextLine();
            switch(linea){
                case "1":
                    return crearAtributosAleatorios();
                case "2":
                    return crearAtributosArray();
                case "3":
                    return crearAtributosDistribuirPuntuacion();
                default:
            }
        }
    }

    /**
     * Funcion que permite distribuir los 27 puntos de inicio totalmente libre entre las clases
     * @return
     */
    private Map<String, Atributo> crearAtributosDistribuirPuntuacion() {
        Map<String, Atributo> atributos = getListaAtributos();
        int puntosGastados = 0;
        while (true) {
            System.out.println("Dispone de " + (Constantes.TOTAL_PUNTAJE_ATRIBUTOS - puntosGastados) + " puntos");
            System.out.println("Indique que atributo desea modificar");
            System.out.println(atributos.toString());
            String atributoAModificar = Constantes.sc.nextLine();
            atributoAModificar = atributoAModificar.substring(0,1).toUpperCase() + atributoAModificar.substring(1,atributoAModificar.length()).toLowerCase().trim();

            Atributo atributo = atributos.get(atributoAModificar);
            if (atributo != null) {
                System.out.println("¿Que nuevo valor desea asignar? Valor actual: " + atributo.getValor());
                String nuevoValor = Constantes.sc.nextLine();
                int valor = Integer.valueOf(nuevoValor);
                int costePuntos = costeAtributo(valor, atributo.getValor());

                System.out.println("Valor: " + valor);
                if (valor < Constantes.ATRIBUTO_MINIMO_INICIAL) { // Comprobacion de que no se pone un valor menor
                    System.out.println("No puede poner un valor inferior a " + Constantes.ATRIBUTO_MINIMO_INICIAL);
                    continue;
                }

                if (atributo.getValor() > valor) { // Se decrementa el valor
                    System.out.println("Se decrementa el valor");
                } else if (atributo.getValor() < valor) { // Se aumenta el valor
                    if (puntosGastados + costePuntos > Constantes.TOTAL_PUNTAJE_ATRIBUTOS) { // Se pretende conseguir mas del limite
                        System.out.println("No se puede poner gastar tantos puntos");
                        continue;
                    }
                    System.out.println("Se aumenta el valor");
                }
                puntosGastados = puntosGastados + costePuntos;
                atributo.setValor(valor);
            } else {
                System.out.println("Ha insertado el nombre de un atributo no existente.");
            }

            if (puntosGastados == Constantes.TOTAL_PUNTAJE_ATRIBUTOS) {
                System.out.println("Ha finalizado de distribuir sus puntos ¿Desea modificar algún atributo mas? escriba Si o No");
                System.out.println(atributos.toString());
                String linea = Constantes.sc.nextLine();
                if (linea.trim().equalsIgnoreCase(Constantes.STRING_NO)) {
                    break;
                }
            }
        }
        return atributos;
    }

    private int costeAtributo(int valor, int valorAtributo) {
        int coste = 0;
        coste = valor / Constantes.ATRIBUTO_COSTE_DOBLE >= 1 ? (valor % Constantes.ATRIBUTO_COSTE_DOBLE)*2 
                + (Constantes.ATRIBUTO_COSTE_DOBLE - valorAtributo)
                : valor - valorAtributo;
        return coste;
    }

    /**
     * Funcion que devuelve el array de Atributos generados a partir del array [15, 14,  13,  12,  10,  8]
     * @return
     */
    private Map<String, Atributo> crearAtributosArray() {
        List<String> arrayValores = crearArrayAtributos();
        System.out.println("Se ha seleccionado la opcion para asignar el array [15, 14,  13,  12,  10,  8].");
        Map<String, Atributo> atributos = getListaAtributos();

        for (String nombre : atributos.keySet()) {
            Atributo atributo = atributos.get(nombre);
            System.out.println("Para el atributo " + nombre + " ¿que valor desea asignar?");
            while (true) {
                System.out.println("Valores disponibles: " + arrayValores.toString());
                String linea = Constantes.sc.nextLine();
                if (arrayValores.contains(linea)) {
                    atributo.setValor(Integer.valueOf(linea));
                    arrayValores.remove(linea);
                    break;
                }
                System.out.println("Introduzca un valor disponible en el array");
            }
        }

        return atributos;
    }

    /**
     * Funcion que devuelve una lista con los atributos del personaje. Los valores se generan aleatoriamente
     * @return
     */
    private Map<String, Atributo> getListaAtributos() {
        Map<String, Atributo> atributos = new HashMap<>();
        Atributo fuerza = new Atributo(Constantes.ATRIBUTO_MINIMO_INICIAL);
        Atributo destreza = new Atributo(Constantes.ATRIBUTO_MINIMO_INICIAL);
        Atributo constitucion = new Atributo(Constantes.ATRIBUTO_MINIMO_INICIAL);
        Atributo inteligencia = new Atributo(Constantes.ATRIBUTO_MINIMO_INICIAL);
        Atributo sabiduria = new Atributo(Constantes.ATRIBUTO_MINIMO_INICIAL);
        Atributo carisma = new Atributo(Constantes.ATRIBUTO_MINIMO_INICIAL);

        atributos.put(Constantes.FUERZA, fuerza);
        atributos.put(Constantes.DESTREZA, destreza);
        atributos.put(Constantes.CONSTITUCION, constitucion);
        atributos.put(Constantes.INTELIGENCIA, inteligencia);
        atributos.put(Constantes.SABIDURIA, sabiduria);
        atributos.put(Constantes.CARISMA, carisma);
        return atributos;
    }

    /**
     * Funcion que devuelve una lista con los valores del array de valores de los atributos [15, 14,  13,  12,  10,  8]
     * @return
     */
    private List<String> crearArrayAtributos() {
        List<String> lista = new ArrayList<>();
        lista.add("15");
        lista.add("14");
        lista.add("13");
        lista.add("12");
        lista.add("10");
        lista.add("8");
        return lista;
    }

    /**
     * Funcion que devuelve el array de Atributos generador de forma aleatoria
     * @return
     */
    private Map<String, Atributo> crearAtributosAleatorios() {
        Map<String, Atributo> atributos = getListaAtributos();
        for (String nombreAtributo : atributos.keySet()) {
            atributos.get(nombreAtributo).setValor(generarValorAtributo());
        }
        return atributos;
    }

    /**
     * Funcion que genera un valor aleatorio entre el valor máximo y minimo incial de personaje para asignarselo a unAtributo.
     * @return
     */
    private int generarValorAtributo() {
        return (int)(Math.random()*(Constantes.ATRIBUTO_MAXIMO_INICIAL - Constantes.ATRIBUTO_MINIMO_INICIAL)
                + Constantes.ATRIBUTO_MINIMO_INICIAL);
    }

    /**
     * Funcion que devuelve una clase en funcion de lo que introduzca el usuario
     * @return
     */
    private Clase seleccionarClase() {
        while (true) {
            System.out.println("¿Qué clase es el personaje?");
            mostrarClases();
            String line = Constantes.sc.nextLine();
            for (Clase clase : config.getClases()) {
                if (clase.getNombre().equalsIgnoreCase(line)) {
                    return clase;
                }
            }
        }
    }

    /**
     * Funcion que devuelve una raza en funcion de lo que introduzca el usuario
     * @return
     */
    private Raza seleccionarRaza() {
        while (true) {
            System.out.println("¿Qué raza es el personaje?");
            mostrarRazas();
            String line = Constantes.sc.nextLine();
            for (Raza raza : config.getRazas()) {
                if (raza.getNombre().equalsIgnoreCase(line)) {
                    return raza;
                }
            }
        }
    }

    /**
     * Funcion que devuelve las caracteristicas del personaje en funcion de lo que devuelva el usuario
     * @return
     */
    private Caracteristicas crearCaracteristicas() {
        System.out.println("Procedemos a crear las características del personaje:");
        System.out.println("Indique el nombre del personaje");
        String nombre = Constantes.sc.nextLine();
        
        System.out.println("Indique los apellidos de su personaje");
        String apellidos = Constantes.sc.nextLine();

        System.out.println("Indique el mote del personaje");
        String mote = Constantes.sc.nextLine();

        System.out.println("Indique la edad del personaje. Ej: 30 anos");
        String edad = Constantes.sc.nextLine();
        
        System.out.println("Indique la fecha de nacimiento (día y mes) del personaje");
        String fechaNacimiento = Constantes.sc.nextLine();

        System.out.println("Indique el peso del personaje. Ej: 80kg");
        String peso = Constantes.sc.nextLine();
        
        System.out.println("Indique la altura del personaje. Ej: 1'50m");
        String altura = Constantes.sc.nextLine();
        
        System.out.println("Indique el sexo del personaje");
        String sexo = Constantes.sc.nextLine();
        
        System.out.println("Indique el nivel del personaje");
        int nivel = Integer.valueOf(Constantes.sc.nextLine());
        
        return new Caracteristicas(nombre, apellidos, mote, edad, fechaNacimiento, peso, altura, sexo, nivel);
    }

    /**
     * Funcion que imprime en consola el menu con las opciones que puede hacer el usuario
     */
    private void imprimirMenu() {
        System.out.println("\n\n/********************************************/");
        System.out.println("¿Que acción desea realizar?");
        System.out.println("Pulse 1 - Para mostrar las clases y razas disponibles");
        System.out.println("Pulse 2 - Para mostrar los personajes creados");
        System.out.println("Pulse 3 - Para crear un nuevo personaje");
        System.out.println("Pulse 4 - Para editar un personaje existente");
        System.out.println("Pulse 0 - Para salir");
        System.out.println("/********************************************/\n\n");
    }

    /**
     * Funcion que muestra los datos de las razas y clases
     */
    private void mostrarDatosConfiguracion() {
        mostrarRazas();
        mostrarClases();
    }

    /** 
     * Funcion que muestra los datos de las razas
     */
    private void mostrarRazas() {
        for (Raza obj : config.getRazas()) {
            System.out.println(obj.toString());
        }
    }

    /**
     * Funcion que muestra los datos de las clases
     */
    private void mostrarClases() {
        for (Clase obj : config.getClases()) {
            System.out.println(obj.toString());
        }
    }
}
