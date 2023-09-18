import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClaseFrame extends ObjetosFrame {
    private Container contenedor;
    private Map<String, JButton> botones;
    private JTextField textfield1;
    private JComboBox<String> combo1;

    public void VentanaPrincipal() {
        //Asigna un titulo a la barra de titulo
        setTitle("Personajes DnD 5e");

        //tamaño de la ventana
        setSize(500,600);

        //pone la ventana en el Centro de la pantalla
        setLocationRelativeTo(null);

        // ponemos la visibilidad de la pantalla
        setVisible(true);

        // cerramos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarVariables() {
        botones = new HashMap<>();
        contenedor = getContentPane();
        contenedor.setLayout(null);
    }

    public void run() {
        inicializarVariables();
        String textoBoton = Constantes.BOTON_CREAR_PERSONAJE;
        JButton boton = aniadirBoton(textoBoton, 10, 10, 150, 20);
        botones.put(textoBoton, boton);
        textfield1 = aniadirTexto("hola", 10, 70, 100, 20);
        List<String> listado = new ArrayList<>();
        listado.add("Elfo");
        listado.add("Humano");
        combo1 = aniadirCombo(listado, 130, 10, 100, 50);
        VentanaPrincipal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pato");
        if (e.getSource() == botones.get(Constantes.BOTON_CREAR_PERSONAJE)) {
            CrearPJFrame ventanaPJ = new CrearPJFrame();
            ventanaPJ.run();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Pato");
        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
            setTitle(seleccionado);
            textfield1.setText(seleccionado);
        }
    }

}