package clases;

/**
 * Esta clase es el objeto Habilidad
 * Los atributos son los datos que dan informacion sobre una habilidad
 * 
 * @author David Rendo Casado
 * @version 24 Agosto 2023
 */
public class Habilidades {
    
    private int modificadorHabilidad;
    private boolean competencia;
    private int modificadorCompetencia;
    private Atributo atributo;
    
    public Habilidades(int modificadorHabilidad, boolean competencia, int modificadorCompetencia, Atributo atributo) {
        this.modificadorHabilidad = modificadorHabilidad;
        this.competencia = competencia;
        this.modificadorCompetencia = modificadorCompetencia;
        this.atributo = atributo;
    }
    
    /** 
     * @return int
     */
    public int getModificadorHabilidad() {
        return modificadorHabilidad;
    }
    
    /** 
     * @param modificadorHabilidad
     */
    public void setModificadorHabilidad(int modificadorHabilidad) {
        this.modificadorHabilidad = modificadorHabilidad;
    }
    
    /** 
     * @return boolean
     */
    public boolean isCompetencia() {
        return competencia;
    }
    
    /** 
     * @param competencia
     */
    public void setCompetencia(boolean competencia) {
        this.competencia = competencia;
    }
    
    /** 
     * @return int
     */
    public int getModificadorCompetencia() {
        return modificadorCompetencia;
    }
    
    /** 
     * @param modificadorCompetencia
     */
    public void setModificadorCompetencia(int modificadorCompetencia) {
        this.modificadorCompetencia = modificadorCompetencia;
    }
    
    /** 
     * @return Atributo
     */
    public Atributo getAtributo() {
        return atributo;
    }
    
    /** 
     * @param atributo
     */
    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    /**
     * Funcion que devuelve el valor del modificador total de la habilidad
     * @return
     */
    public int getModificadorTotal() {
        return (competencia == true) ? getModificadorHabilidad() + atributo.getModificador() + getModificadorCompetencia() : 
                                        getModificadorHabilidad() + atributo.getModificador();
    }

    @Override
    public String toString() {
        return "Habilidades [modificadorHabilidad=" + modificadorHabilidad + ", competencia="
                + competencia + ", modificadorCompetencia=" + modificadorCompetencia + ", atributo=" + atributo + "]";
    }
}
