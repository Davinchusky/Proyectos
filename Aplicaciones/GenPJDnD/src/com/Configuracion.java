package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import clases.Atributo;
import clases.Clase;
import clases.Raza;

/**
 * Esta clase es el objeto de configuracion, esencial para la ejecucion del programa.
 * Se encarga de inicializar los datos para funcionar. Siempre se debe crear un objeto de configuracion
 * para ejecutarlo.
 * @author David Rendo Casado
 * @version 03 Agosto 2023
 */
public class Configuracion {
    private JSONObject atributos;
    private JSONObject habilidades;
    private List<Raza> razas;
    private List<Clase> clases;
    private JSONObject conjuros;

    public Configuracion(JSONObject dataJsonObject) throws JSONException {
        atributos = dataJsonObject.getJSONObject(Constantes.ConfigJson.ATRIBUTOS);
        habilidades = dataJsonObject.getJSONObject(Constantes.ConfigJson.HABILIDADES);
        conjuros = dataJsonObject.getJSONObject(Constantes.ConfigJson.CONJUROS);
        razas = new ArrayList<Raza>();
        clases = new ArrayList<Clase>();

        // Se crea la lista con todas las razas del JSON de configuracion
        JSONObject razasJSONObject = dataJsonObject.getJSONObject(Constantes.ConfigJson.RAZAS);
        for (String key : razasJSONObject.keySet()) {
            if (razasJSONObject.optJSONObject(key) != null) {
                Raza raza = crearRazaDesdeConfig(key, razasJSONObject.getJSONObject(key));
                razas.add(raza);
            }
        }

        // Se crea la lista con todas las clases del JSON de configuracion
        JSONObject clasesJSONObject = dataJsonObject.getJSONObject(Constantes.ConfigJson.CLASES);
        for (String key : clasesJSONObject.keySet()) {
            if (clasesJSONObject.optJSONObject(key) != null) {
                Clase clase = crearClaseDesdeConfig(key, clasesJSONObject.getJSONObject(key));
                clases.add(clase);
            }
        }

        // Se inicializan todos los valores del mapa de Modificadores (relacion entre valor - modificador)
        crearMapaModificadores();

        // Se inicializa los valores de los modificadores según el nivel
        crearMapaCompetenciaNivel();
    }

    /**
     * Funcion que inicializa las clases desde fichero de configuracion
     * @param key
     * @param jsonObject
     * @return
     */
    private Clase crearClaseDesdeConfig(String key, JSONObject jsonObject) {
        String nombre = key;
        String descripcion = jsonObject.optString(Constantes.ConfigJson.Clases.DESCRIPCION);
        int dado_de_golpe = jsonObject.optInt(Constantes.ConfigJson.Clases.DADO_DE_GOLPE);
        Map<String, Atributo> tiradas_de_salvacion = new HashMap<>();
        JSONArray salvacionArray = jsonObject.optJSONArray(Constantes.ConfigJson.Clases.TIRADAS_DE_SALVACION);
        if (salvacionArray != null) {
            for (int i = 0; i < salvacionArray.length(); i++) {
                String nombreAtributo = salvacionArray.getString(i);
                Atributo atributo = new Atributo();
                tiradas_de_salvacion.put(nombreAtributo, atributo);
            }
        }
        JSONArray equipo = jsonObject.optJSONArray(Constantes.ConfigJson.Clases.EQUIPO);
        JSONObject competencias = jsonObject.optJSONObject(Constantes.ConfigJson.Clases.COMPETENCIAS);
        JSONObject habilidades = jsonObject.optJSONObject(Constantes.ConfigJson.Clases.HABILIDADES);
        return new Clase(nombre, descripcion, dado_de_golpe, tiradas_de_salvacion, equipo, competencias, habilidades);
    }

    /**
     * Funcion que inicializa las razas desde fichero de configuracion
     * @param key
     * @param razaJSON
     * @return
     */
    private Raza crearRazaDesdeConfig(String key, JSONObject razaJSON) {
        String nombre = key;
        String descripcion = razaJSON.optString(Constantes.ConfigJson.Razas.DESCRIPCION);
        String altura = razaJSON.optString(Constantes.ConfigJson.Razas.ALTURA);
        String peso = razaJSON.optString(Constantes.ConfigJson.Razas.PESO);
        String edad = razaJSON.optString(Constantes.ConfigJson.Razas.EDAD);
        String velocidad = razaJSON.optString(Constantes.ConfigJson.Razas.VELOCIDAD);
        JSONObject caracteristicas = razaJSON.optJSONObject(Constantes.ConfigJson.Razas.CARACTERISTICAS);
        JSONObject subrazas = razaJSON.optJSONObject(Constantes.ConfigJson.Razas.SUBRAZAS);
        JSONArray conjuros = razaJSON.optJSONArray(Constantes.ConfigJson.Razas.CONJUROS);
        JSONArray nombres = razaJSON.optJSONArray(Constantes.ConfigJson.Razas.NOMBRES);
        return new Raza(nombre, descripcion, altura, peso, edad, velocidad, caracteristicas, subrazas, conjuros, nombres);
    }


    /**
     * 
     */
    private void crearMapaCompetenciaNivel() {
        Constantes.mapaModificadoresNivel.put(1, 2);
        Constantes.mapaModificadoresNivel.put(2, 2);
        Constantes.mapaModificadoresNivel.put(3, 2);
        Constantes.mapaModificadoresNivel.put(4, 2);
        Constantes.mapaModificadoresNivel.put(5, 3);
        Constantes.mapaModificadoresNivel.put(6, 3);
        Constantes.mapaModificadoresNivel.put(7, 3);
        Constantes.mapaModificadoresNivel.put(8, 3);
        Constantes.mapaModificadoresNivel.put(9, 4);
        Constantes.mapaModificadoresNivel.put(10, 4);
        Constantes.mapaModificadoresNivel.put(11, 4);
        Constantes.mapaModificadoresNivel.put(12, 4);
        Constantes.mapaModificadoresNivel.put(13, 5);
        Constantes.mapaModificadoresNivel.put(14, 5);
        Constantes.mapaModificadoresNivel.put(15, 5);
        Constantes.mapaModificadoresNivel.put(16, 5);
        Constantes.mapaModificadoresNivel.put(17, 6);
        Constantes.mapaModificadoresNivel.put(18, 6);
        Constantes.mapaModificadoresNivel.put(19, 6);
        Constantes.mapaModificadoresNivel.put(20, 6);
    }

    /**
     * Funcion que se encarga de inicializar los valores de los modificadores
     */
    private void crearMapaModificadores() {
        Constantes.mapaModificadoresPuntuacionAtributo.put(1, -5);
        Constantes.mapaModificadoresPuntuacionAtributo.put(2, -4);
        Constantes.mapaModificadoresPuntuacionAtributo.put(3, -4);
        Constantes.mapaModificadoresPuntuacionAtributo.put(4, -3);
        Constantes.mapaModificadoresPuntuacionAtributo.put(5, -3);
        Constantes.mapaModificadoresPuntuacionAtributo.put(6, -2);
        Constantes.mapaModificadoresPuntuacionAtributo.put(7, -2);
        Constantes.mapaModificadoresPuntuacionAtributo.put(8, -1);
        Constantes.mapaModificadoresPuntuacionAtributo.put(9, -1);
        Constantes.mapaModificadoresPuntuacionAtributo.put(10, 0);
        Constantes.mapaModificadoresPuntuacionAtributo.put(11, 0);
        Constantes.mapaModificadoresPuntuacionAtributo.put(12, 1);
        Constantes.mapaModificadoresPuntuacionAtributo.put(13, 1);
        Constantes.mapaModificadoresPuntuacionAtributo.put(14, 2);
        Constantes.mapaModificadoresPuntuacionAtributo.put(15, 2);
        Constantes.mapaModificadoresPuntuacionAtributo.put(16, 3);
        Constantes.mapaModificadoresPuntuacionAtributo.put(17, 3);
        Constantes.mapaModificadoresPuntuacionAtributo.put(18, 4);
        Constantes.mapaModificadoresPuntuacionAtributo.put(19, 4);
        Constantes.mapaModificadoresPuntuacionAtributo.put(20, 5);
        Constantes.mapaModificadoresPuntuacionAtributo.put(21, 5);
        Constantes.mapaModificadoresPuntuacionAtributo.put(22, 6);
        Constantes.mapaModificadoresPuntuacionAtributo.put(23, 6);
        Constantes.mapaModificadoresPuntuacionAtributo.put(24, 7);
        Constantes.mapaModificadoresPuntuacionAtributo.put(25, 7);
        Constantes.mapaModificadoresPuntuacionAtributo.put(26, 8);
        Constantes.mapaModificadoresPuntuacionAtributo.put(27, 8);
        Constantes.mapaModificadoresPuntuacionAtributo.put(28, 9);
        Constantes.mapaModificadoresPuntuacionAtributo.put(29, 9);
        Constantes.mapaModificadoresPuntuacionAtributo.put(30, 10);

    }

    public JSONObject getAtributos() {
        return atributos;
    }

    public JSONObject getHabilidades() {
        return habilidades;
    }

    public List<Raza> getRazas() {
        return razas;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public JSONObject getConjuros() {
        return conjuros;
    }
}
