package clases;

import com.Constantes;

/**
 * Esta clase es el objeto Caracteristicas
 * Los atributos son todos aquellos datos que dan informacion del personaje
 * 
 * @author David Rendo Casado
 * @version 02 Agosto 2023
 */
public class Caracteristicas {
    
    private String nombre;
    private String apellidos;
    private String mote;
    private String edad;
    private String fechaNacimiento;
    private String peso;
    private String altura;
    private String sexo;
    private int nivel;
    

    public Caracteristicas() {
        nombre = "";
        apellidos = "";
        mote = "";
        edad = "";
        fechaNacimiento = "";
        peso = "";
        altura = "";
        sexo = "";
        nivel = 0;
    }

    public Caracteristicas(String nombre, String apellidos, String mote, String edad, String fechaNacimiento, String peso,
                            String altura, String sexo, int nivel) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mote = mote;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.nivel = nivel;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getMote() {
        return mote;
    }
    public void setMote(String mote) {
        this.mote = mote;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNaciomiento) {
        this.fechaNacimiento = fechaNaciomiento;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public String toString() {
        return "Nombre: "+ nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Mote: " + mote + "\n" +
                "Edad: " + edad + "\n" +
                "Fecha de naciomiento: " + fechaNacimiento + "\n" +
                "Peso: " + peso + "\n" +
                "Altura: " + altura + "\n" +
                "Sexo: " + sexo + "\n" +
                "Nivel: " + nivel;
    }

    public String getCSV() {
        StringBuilder sb = new StringBuilder();

        sb.append(getNombre());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getApellidos());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getMote());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getEdad());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getFechaNacimiento());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getPeso());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getAltura());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getSexo());
        sb.append(Constantes.SEPARADOR_CSV);
        sb.append(getNivel());

        return sb.toString();
    }
}
