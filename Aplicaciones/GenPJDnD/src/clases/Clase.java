package clases;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Esta clase es el objeto Clase
 * Los atributos son las opciones de cada clase
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class Clase {

    private String nombre;
    private String descripcion;
    private int dado_de_golpe;
    private Map<String, Atributo> tiradas_de_salvacion;
    private JSONArray equipo;
    private JSONObject competencias;
    private JSONObject habilidades;

    public Clase() {
        nombre = "";
        descripcion = "";
        dado_de_golpe = 0;
        tiradas_de_salvacion = new HashMap<>();
        equipo = new JSONArray();
        competencias = new JSONObject();
        habilidades = new JSONObject();
    }

    /**
     * 
     * @param nmbre
     * @param descripcion
     * @param dado_de_golpe
     * @param tiradas_de_salvacion
     * @param equipo
     * @param competencias
     * @param habilidades
     */
    public Clase (String nombre, String descripcion, int dado_de_golpe, Map<String, Atributo> tiradas_de_salvacion, 
                JSONArray equipo, JSONObject competencias, JSONObject habilidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dado_de_golpe = dado_de_golpe;
        this.tiradas_de_salvacion = tiradas_de_salvacion;
        this.equipo = equipo;
        this.competencias = competencias;
        this.habilidades = habilidades;
    }

    /** Devuelve el nombre de la clase. EJ: Barbaro, Mago...
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /** Permite Modificar el nombre de la clase
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Devuelve la descripcion de la clase
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /** Permite modificar la descripcion de la clase
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** Devuelve el dado de golpe. EJ: 12 (dado de 12 caras)
     * @return
     */
    public int getDado_de_golpe() {
        return dado_de_golpe;
    }

    /** Permite modificar el dado de golpe
     * @param dado_de_golpe
     */
    public void setDado_de_golpe(int dado_de_golpe) {
        this.dado_de_golpe = dado_de_golpe;
    }

    /** Devuelve los atributos que tienen tirada de salvacion
     * @return
     */
    public Map<String, Atributo> getTiradas_de_salvacion() {
        return tiradas_de_salvacion;
    }

    /** Permite modificar las tiradas de salvacion
     * @param tiradas_de_salvacion
     */
    public void setTiradas_de_salvacion(Map<String, Atributo> tiradas_de_salvacion) {
        this.tiradas_de_salvacion = tiradas_de_salvacion;
    }

    /** Devuelve los objetos del equipo que tiene el personaje
     * @return
     */
    public JSONArray getEquipo() {
        return equipo;
    }

    /** Permite modificar los objetos del equipo que tiene el personaje
     * @param equipo
     */
    public void setEquipo(JSONArray equipo) {
        this.equipo = equipo;
    }

    /** Devuelve las competencias que tiene el personaje
     * @return
     */
    public JSONObject getCompetencias() {
        return competencias;
    }

    /** Permite modificar las competencias del personaje
     * @param competencias
     */
    public void setCompetencias(JSONObject competencias) {
        this.competencias = competencias;
    }

    /** Devuelve las habilidades el personaje
     * @return
     */
    public JSONObject getHabilidades() {
        return habilidades;
    }

    /** Permite modificar las habilidades del personaje
     * @param habilidades
     */
    public void setHabilidades(JSONObject habilidades) {
        this.habilidades = habilidades;
    }

    
    /** Devuelve en formato String todos los atributos de la clase
     * @return String
     */
    @Override
    public String toString() {
        return "Clase [nombre=" + nombre + ", descripcion=" + descripcion + ", dado_de_golpe=" + dado_de_golpe
                + ", tiradas_de_salvacion=" + tiradas_de_salvacion + ", equipo=" + equipo + ", competencias="
                + competencias + ", habilidades=" + habilidades + "]";
    }
}
