import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

public class CrearPJFrame extends ObjetosFrame {

    private Container contenedor;
    private Map<String, JButton> botones;
    private Map<String, JLabel> etiquetas;
    private Map<String, JTextField> cuadrosTextos;
    private Map<String, JComboBox<String>> combos;
    private Map<String, JRadioButton> radioBotones;

    public void VentanaPrincipal() {
        //Asigna un titulo a la barra de titulo
        setTitle("Creacion de personaje");

        //tamaño de la ventana
        setSize(900,600);

        //pone la ventana en el Centro de la pantalla
        setLocationRelativeTo(null);

        // ponemos la visibilidad de la pantalla
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botones.get(Constantes.BOTON_GUARDAR_PJ)) {
            // TODO: falta guardar los datos en CSV
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combos.get(Constantes.COMBO_RAZA)) {
            try {
                String raza = (String) combos.get(Constantes.COMBO_RAZA).getSelectedItem();
                JLabel label1 = etiquetas.get(Constantes.LABEL_IMAGEN);
                ImageIcon imgIcon = new ImageIcon(getClass().getResource("./resources/"+ raza +".png"));
                Image imgEscalada = imgIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                Icon iconoEscalado = new ImageIcon(imgEscalada);
                label1.setIcon(iconoEscalado);
            } catch (Exception exception) {
                return;
            }
        } else if (e.getSource() == combos.get(Constantes.COMBO_NIVEL)) {
            etiquetas.get(Constantes.LABEL_MOD_COMPETENCIA).setText(Constantes.LABEL_MOD_COMPETENCIA + " " + Constantes.mapaNivelesModCompetencia.get(combos.get(Constantes.COMBO_NIVEL).getSelectedItem()));
        }
    }

        @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == radioBotones.get(Constantes.LABEL_HABILIDAD_ATLETISMO)) {
            if (radioBotones.get(Constantes.LABEL_HABILIDAD_ATLETISMO).isSelected()) {
                System.out.println("Se ha pulsao");
            }
        }
    }

    private void inicializarVariables() {
        botones = new HashMap<>();
        etiquetas = new HashMap<>();
        cuadrosTextos = new HashMap<>();
        combos = new HashMap<>();
        radioBotones = new HashMap<>();
        contenedor = getContentPane();
        contenedor.setLayout(null);

        Constantes.inicializarMapaNivelCompetencia();
    }

    public void run() {
        inicializarVariables();

        // Aniadimos el boton de guardar pj
        String textoBoton = Constantes.BOTON_GUARDAR_PJ;
        JButton botonGuardar = aniadirBoton(textoBoton, 710, 520, 150, 20);
        botonGuardar.setBackground(Color.lightGray);
        botones.put(textoBoton, botonGuardar);

        // Aniadimos una etiqueta
        crearLabelParaImagen();

        // Aniadimos la seleccion de raza y clase
        colocarRazaClase();

        // Colocamos alineamiento y nivel
        colocarAlineamientoNivel();

        // Colocamos las etiquetas y textos para insertar las caracteristicas del personaje
        colocarCaracteristicasPersonaje();

        // Colocar las habilidades
        colocarHabilidades();

        // Colocamos el mod de competencia
        colocarModCompetencia();

        // Colocar Atributos (modificadores, valores y nombre)
        colocarAtributos();

        // Sacamos la pantalla
        VentanaPrincipal();
    }

    /**
     * Funcion que coloca las etiquetas y combos de la raza y de la clase
     */
    private void colocarRazaClase() {
        // Creamos una etiqueta para Raza
        JLabel etiquetaRaza = aniadirLabel(Constantes.LABEL_RAZA, 340, 40, 40, 20);
        etiquetas.put(Constantes.LABEL_RAZA, etiquetaRaza);

        // Creamos un combo donde seleccionar Raza
        List<String> listadoRazas = new ArrayList<>();
        listadoRazas.add("Humano");
        listadoRazas.add("Elfo");
        JComboBox<String> comboRazas = aniadirCombo(listadoRazas, 440, 40, 120, 20);
        combos.put(Constantes.COMBO_RAZA, comboRazas);

        // Creamos una etiqueta para Clase
        JLabel etiquetaClase = aniadirLabel(Constantes.LABEL_CLASE, 600, 40, 40, 20);
        etiquetas.put(Constantes.LABEL_CLASE, etiquetaClase);

        // Creamos un combo donde seleccionar Clase
        List<String> listadoClases = new ArrayList<>();
        listadoClases.add("Guerrero");
        listadoClases.add("Arquero");
        JComboBox<String> comboClases = aniadirCombo(listadoClases, 680, 40, 120, 20);
        combos.put(Constantes.COMBO_CLASE, comboClases);
    }

    /**
     * Funcion que coloca la etiqueta y el combo del alineamienot y el nivel
     */
    private void colocarAlineamientoNivel() {
        // Creamos una etiqueta para Alineamiento
        JLabel etiquetaAlineamiento = aniadirLabel(Constantes.LABEL_ALINEAMIENTO, 340, 90, 80, 20);
        etiquetas.put(Constantes.LABEL_ALINEAMIENTO, etiquetaAlineamiento);

        // Creamos un combo donde seleccionar Alineamiento
        List<String> listadoAlineamiento = getListaAlineamiento();
        JComboBox<String> comboAlineamiento = aniadirCombo(listadoAlineamiento, 440, 90, 120, 20);
        combos.put(Constantes.COMBO_ALINEAMIENTO, comboAlineamiento);

        // Creamos una etiqueta para el Nivel
        JLabel etiquetaNivel = aniadirLabel(Constantes.LABEL_NIVEL, 600, 90, 40, 20);
        etiquetas.put(Constantes.LABEL_NIVEL, etiquetaNivel);

        // Creamos un combo donde seleccionar Nivel
        List<String> listadoNivel = getListaNivel();
        JComboBox<String> comboClases = aniadirCombo(listadoNivel, 680, 90, 120, 20);
        combos.put(Constantes.COMBO_NIVEL, comboClases);
    }

    /**
     * Funcion que devuelve la lista con los distintos alineamientos
     * @return
     */
    private List<String> getListaAlineamiento() {
        List<String> listadoAlineamiento = new ArrayList<>();
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_LEGAL_BUENO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_LEGAL_NEUTRO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_LEGAL_MALVADO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_NEUTRAL_BUENO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_NEUTRO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_NEUTRAL_MALVADO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_CAOTICO_BUENO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_CAOTICO_NEUTRO);
        listadoAlineamiento.add(Constantes.ALINEAMIENTO_CAOTICO_MALVADO);
        return listadoAlineamiento;
    }

    /**
     * Funcion que devuelve la lista de los niveles para el combo
     * @return
     */
    private List<String> getListaNivel() {
        List<String> listadoNivel = new ArrayList<>();
        for (int i = 1; i <= Constantes.NIVEL_MAXIMO; i++) {
            listadoNivel.add(String.valueOf(i));
        }
        return listadoNivel;
    }

    /**
     * Funcion que coloca todas las etiquetas y textos de las caracteristicas del personaje
     */
    private void colocarCaracteristicasPersonaje() {
        // Creamos una etiqueta para el Nombre
        JLabel etiquetaNombre = aniadirLabel(Constantes.LABEL_NOMBRE, 340, 160, 120, 20);
        etiquetas.put(Constantes.LABEL_NOMBRE, etiquetaNombre);

        // Creamos un texto donde insertar el Nombre
        JTextField textFieldNombre = aniadirTexto(null, 440, 160, 120, 20);
        cuadrosTextos.put(Constantes.LABEL_NOMBRE, textFieldNombre);

        // Creamos una etiqueta para Apellidos
        JLabel etiquetaApellidos = aniadirLabel(Constantes.LABEL_APELLIDOS, 600, 160, 120, 20);
        etiquetas.put(Constantes.LABEL_APELLIDOS, etiquetaApellidos);

        // Creamos un texto donde insertar el Apellidos
        JTextField textFieldApellidos = aniadirTexto(null, 680, 160, 120, 20);
        cuadrosTextos.put(Constantes.LABEL_APELLIDOS, textFieldApellidos);

        // Creamos una etiqueta para el Peso
        JLabel etiquetaPeso = aniadirLabel(Constantes.LABEL_PESO, 340, 220, 120, 20);
        etiquetas.put(Constantes.LABEL_PESO, etiquetaPeso);

        // Creamos un texto donde insertar el Peso
        JTextField textFieldPeso = aniadirTexto(null, 440, 220, 120, 20);
        cuadrosTextos.put(Constantes.LABEL_PESO, textFieldPeso);

        // Creamos una etiqueta para Altura
        JLabel etiquetaAltura = aniadirLabel(Constantes.LABEL_ALTURA, 600, 220, 120, 20);
        etiquetas.put(Constantes.LABEL_ALTURA, etiquetaAltura);

        // Creamos un texto donde insertar el Altura
        JTextField textFieldAltura = aniadirTexto(null, 680, 220, 120, 20);
        cuadrosTextos.put(Constantes.LABEL_ALTURA, textFieldAltura);
    }

    /**
     * Funcion que coloca todas las habilidades en JRadioButton
     */
    private void colocarHabilidades() {
        // Habilidades de Fuerza
        JRadioButton radioButtonAtletismo = aniadirRadioButton(Constantes.LABEL_HABILIDAD_ATLETISMO, 340, 260, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_ATLETISMO, radioButtonAtletismo);

        // Habilidades de Destreza
        JRadioButton radioButtoAcrobacia = aniadirRadioButton(Constantes.LABEL_HABILIDAD_ACROBACIAS, 340, 280, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_ACROBACIAS, radioButtoAcrobacia);
        JRadioButton radioButtoJuegoDeManos = aniadirRadioButton(Constantes.LABEL_HABILIDAD_JUEGO_DE_MANOS, 340, 300, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_JUEGO_DE_MANOS, radioButtoJuegoDeManos);
        JRadioButton radioButtoSigilo = aniadirRadioButton(Constantes.LABEL_HABILIDAD_SIGILO, 340, 320, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_SIGILO, radioButtoSigilo);

        // Habilidades de Inteligencia
        JRadioButton radioButtonArcano = aniadirRadioButton(Constantes.LABEL_HABILIDAD_ARCANO, 340, 340, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_ARCANO, radioButtonArcano);
        JRadioButton radioButtonHistoria = aniadirRadioButton(Constantes.LABEL_HABILIDAD_HISTORIA, 340, 360, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_HISTORIA, radioButtonHistoria);
        JRadioButton radioButtonInvestigacion = aniadirRadioButton(Constantes.LABEL_HABILIDAD_INVESTIGACION, 520, 260, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_INVESTIGACION, radioButtonInvestigacion);
        JRadioButton radioButtonNaturaleza = aniadirRadioButton(Constantes.LABEL_HABILIDAD_NATURALEZA, 520, 280, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_NATURALEZA, radioButtonNaturaleza);

        // Habilidades de Sabiduria
        JRadioButton radioButtonTratoConAnimales = aniadirRadioButton(Constantes.LABEL_HABILIDAD_TRATO_CON_ANIMALES, 520, 300, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_TRATO_CON_ANIMALES, radioButtonTratoConAnimales);
        JRadioButton radioButtonPerspicacia = aniadirRadioButton(Constantes.LABEL_HABILIDAD_PERSPICACIA, 520, 320, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_PERSPICACIA, radioButtonPerspicacia);
        JRadioButton radioButtonMedicina = aniadirRadioButton(Constantes.LABEL_HABILIDAD_MEDICINA, 520, 340, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_MEDICINA, radioButtonMedicina);
        JRadioButton radioButtonPercepcion = aniadirRadioButton(Constantes.LABEL_HABILIDAD_PERCEPCION, 520, 360, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_PERCEPCION, radioButtonPercepcion);
        JRadioButton radioButtonSupervivencia = aniadirRadioButton(Constantes.LABEL_HABILIDAD_SUPERVIVENCIA, 700, 260, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_SUPERVIVENCIA, radioButtonSupervivencia);

        // Habilidades de Carisma
        JRadioButton radioButtonEngano = aniadirRadioButton(Constantes.LABEL_HABILIDAD_ENGANO, 700, 280, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_ENGANO, radioButtonEngano);
        JRadioButton radioButtonIntimidacion = aniadirRadioButton(Constantes.LABEL_HABILIDAD_INTIMIDACION, 700, 300, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_INTIMIDACION, radioButtonIntimidacion);
        JRadioButton radioButtonInterpretacion = aniadirRadioButton(Constantes.LABEL_HABILIDAD_INTERPRETACION, 700, 320, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_INTERPRETACION, radioButtonInterpretacion);
        JRadioButton radioButtonPersuasion = aniadirRadioButton(Constantes.LABEL_HABILIDAD_PERSUASION, 700, 340, 150, 20);
        radioBotones.put(Constantes.LABEL_HABILIDAD_PERSUASION, radioButtonPersuasion);
    }

    /**
     * Funcion que coloca los nombres, valores y modificadores de los atributos
     */
    private void colocarAtributos() {
        List<String> nombresLabelAtributos = getListaAtributos();
        int saltoEntreAtributos = 135;
        for (int i = 0; i < nombresLabelAtributos.size(); i++) {

            // Creamos la label con el nombre del atributo
            String nombreAtributo = nombresLabelAtributos.get(i);
            String nombreEtiqueta = getNombreEtiquetaDesdeNombreAtributo(nombreAtributo, 15);
            JLabel etiquetaAtributo = aniadirLabel(nombreEtiqueta, 50 + saltoEntreAtributos*i, 400, 90, 80);
            etiquetaAtributo.setHorizontalAlignment(SwingConstants.CENTER);
            etiquetaAtributo.setVerticalAlignment(SwingConstants.CENTER);
            etiquetaAtributo.setBorder(BorderFactory.createLineBorder(Color.black));
            etiquetas.put(nombreAtributo, etiquetaAtributo);

            // Creamos la label con el valor del atributo
            String valorAtributo = "15";
            JLabel etiquetaValor = aniadirLabel(valorAtributo, 85 + saltoEntreAtributos*i, 430, 25, 25);
            etiquetaValor.setHorizontalAlignment(SwingConstants.CENTER);
            etiquetas.put(Constantes.LABEL_VALOR+nombreAtributo, etiquetaValor);

            // Creamos la label con el modificador del atributo
            String modificadorAtributo = "+2";
            JLabel etiquetaModificador = aniadirLabel(modificadorAtributo, 85 + saltoEntreAtributos*i, 450, 25, 25);
            etiquetaModificador.setHorizontalAlignment(SwingConstants.CENTER);
            etiquetaModificador.setBorder(BorderFactory.createLineBorder(Color.black));
            etiquetas.put(Constantes.LABEL_MODIFICADOR+nombreAtributo, etiquetaModificador);
        }
    }

    private void colocarModCompetencia() {
        // Creamos una etiqueta para el Mod de Competencia
        String modCompetencia = Constantes.LABEL_MOD_COMPETENCIA + " " + Constantes.mapaNivelesModCompetencia.get(combos.get(Constantes.COMBO_NIVEL).getSelectedItem());
        JLabel etiquetaRaza = aniadirLabel(modCompetencia, 600, 120, 200, 20);
        etiquetas.put(Constantes.LABEL_MOD_COMPETENCIA, etiquetaRaza);
    }

    /**
     * Funcion que genera la cadena para el texto de la etiqueta del atributo
     * @param nombreAtributo
     * @param valorAtributo
     * @return
     */
    private String getNombreEtiquetaDesdeNombreAtributo(String nombreAtributo, int valorAtributo) {
        String nombreEtiqueta = "<html>"+nombreAtributo;
        nombreEtiqueta += "<br>";
        nombreEtiqueta += "&nbsp;";
        nombreEtiqueta += "<br>";
        nombreEtiqueta += "&nbsp;";
        nombreEtiqueta += "</html>";
        return nombreEtiqueta;
    }

    /**
     * Funcion que devuelve la lista con los nombres de las etiqueta de los atributos
     * @return
     */
    private List<String> getListaAtributos() {
        List<String> nombresLabelAtributos = new ArrayList<>();
        nombresLabelAtributos.add(Constantes.LABEL_ATRIBUTO_FUERZA);
        nombresLabelAtributos.add(Constantes.LABEL_ATRIBUTO_DESTREZA);
        nombresLabelAtributos.add(Constantes.LABEL_ATRIBUTO_CONSTITUCION);
        nombresLabelAtributos.add(Constantes.LABEL_ATRIBUTO_INTELIGENCIA);
        nombresLabelAtributos.add(Constantes.LABEL_ATRIBUTO_SABIDURIA);
        nombresLabelAtributos.add(Constantes.LABEL_ATRIBUTO_CARISMA);
        return nombresLabelAtributos;
    }

    /**
     * Funcion que crea la etiqueta para la imagen
     */
    private void crearLabelParaImagen() {
        JLabel etiquetaImagen = aniadirLabel(Constantes.LABEL_IMAGEN, 20, 50, 300, 300);
        etiquetaImagen.setBorder(BorderFactory.createLineBorder(Color.black));
        etiquetas.put(Constantes.LABEL_IMAGEN, etiquetaImagen);

        ImageIcon imgIcon = new ImageIcon(getClass().getResource("./resources/Humano.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        etiquetaImagen.setIcon(iconoEscalado);
    }
}
