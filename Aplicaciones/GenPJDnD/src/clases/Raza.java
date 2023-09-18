package clases;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Constantes;

/**
 * Esta clase es el objeto Raza
 * Los atributos son las caracteristicas de cada raza
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class Raza {
    
    private String nombre;
    private String descripcion;
    private String altura;
    private String peso;
    private String edad;
    private String velocidad;
    private JSONObject caracteristicas;
    private JSONObject subrazas;
    private JSONArray conjuros;
    private JSONArray nombres;
    
    /**
     * Constructor que inicializa todo a vacio
     * Constructor por defecto para la clase Raza
     */
    public Raza() {
        nombre = Constantes.STRING_VACIO;
        descripcion = Constantes.STRING_VACIO;
        altura = Constantes.STRING_VACIO;
        peso = Constantes.STRING_VACIO;
        edad = Constantes.STRING_VACIO;
        velocidad = Constantes.STRING_VACIO;
        caracteristicas = new JSONObject();
        subrazas = new JSONObject();
        conjuros = new JSONArray();
        nombres = new JSONArray();
    }

    public Raza(String nombre, String descripcion, String altura, String peso, String edad,
                String velocidad, JSONObject caracteristicas, JSONObject subrazas,
                JSONArray conjuros, JSONArray nombres) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.velocidad = velocidad;
        this.caracteristicas = caracteristicas;
        this.subrazas = subrazas;
        this.conjuros = conjuros;
        this.nombres = nombres;
    }

    /** Devuelve el nombre de la raza. EJ: Elfo, Enano...
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /** Permite modificar el nombre de la raza
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** Devuelve la descripcion de la clase
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /** Permit emodificar la descripcion de la clase
     * @param descipcion
     */
    public void setDescripcion(String descipcion) {
        this.descripcion = descipcion;
    }
    
    /** Devuelve la altura del personaje
     * @return String
     */
    public String getAltura() {
        return altura;
    }
    
    /** Permite modificar la altura de personaje
     * @param altura
     */
    public void setAltura(String altura) {
        this.altura = altura;
    }
    
    /** Devuelve el peso del personaje
     * @return String
     */
    public String getPeso() {
        return peso;
    }
    
    /** Permite modificar el peso del personaje
     * @param peso
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    /** Devuelve la edad del personaje
     * @return String
     */
    public String getEdad() {
        return edad;
    }
    
    /** Permite modificar la edad del personaje
     * @param edad
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    /** Devuelve la velocidad de personaje
     * @return String
     */
    public String getVelocidad() {
        return velocidad;
    }
    
    /** Permite modificar la velocidad del personaje
     * @param velocidad
     */
    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
    
    /** Devuelve las caracteristicas del personaje
     * @return JSONObject
     */
    public JSONObject getCaracteristicas() {
        return caracteristicas;
    }
    
    /** Permite modificar las caracteristicas del personaje
     * @param caracteristicas
     */
    public void setCaracteristicas(JSONObject caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    /** Devuelve las subrazas
     * @return JSONObject
     */
    public JSONObject getSubrazas() {
        return subrazas;
    }
    
    /** Permite modificar las subrazas
     * @param subrazas
     */
    public void setSubrazas(JSONObject subrazas) {
        this.subrazas = subrazas;
    }
    
    /** Devuelve los conjuros que tiene la raza
     * @return JSONArray
     */
    public JSONArray getConjuros() {
        return conjuros;
    }
    
    /** Permite modificar los conjuros de la raza
     * @param conjuros
     */
    public void setConjuros(JSONArray conjuros) {
        this.conjuros = conjuros;
    }
    
    /** Devuelve un array de nombres comunes de la raza
     * @return JSONArray
     */
    public JSONArray getNombres() {
        return nombres;
    }
    
    /** Permite modificar el array de nombres comunes de la raza
     * @param nombres
     */
    public void setNombres(JSONArray nombres) {
        this.nombres = nombres;
    }

    
    /** 
     * Devuelve en formato String todos los atributos de la clase
     * @return String
     */
    @Override
    public String toString() {
        return "Raza [nombre=" + nombre + ", descripcion=" + descripcion + ", altura=" + altura + ", peso=" + peso
                + ", edad=" + edad + ", velocidad=" + velocidad + ", caracteristicas=" + caracteristicas + ", subrazas="
                + subrazas + ", conjuros=" + conjuros + ", nombres=" + nombres + "]";
    }
}
