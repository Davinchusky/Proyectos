import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ObjetosFrame extends JFrame implements ActionListener, ItemListener, ChangeListener {

    public JButton aniadirBoton(String texto, int posicionX, int posicionY, int ancho, int altura) {
        JButton boton = new JButton(texto);
        boton.setBounds(posicionX,posicionY,ancho,altura);
        boton.addActionListener(this);
        add(boton);
        return boton;
    }

    public JTextField aniadirTexto(String texto, int posicionX, int posicionY, int ancho, int altura) {
        JTextField textfield1 = new JTextField(20);
        textfield1.setBounds(posicionX,posicionY,ancho,altura);
        textfield1.setText(texto);
        textfield1.setVisible(true);
        add(textfield1);
        return textfield1;
    }

    public JComboBox<String> aniadirCombo(List<String> valores, int posicionX, int posicionY, int ancho, int altura) {
        JComboBox<String> combo1 = new JComboBox<String>();
        for (String valor : valores) {
            combo1.addItem(valor);
        }
        combo1.setBounds(posicionX,posicionY,ancho,altura);
        combo1.addItemListener(this);
        combo1.setVisible(true);
        add(combo1);
        return combo1;
    }

    public JLabel aniadirLabel(String texto, int posicionX, int posicionY, int ancho, int altura) {
        JLabel label1 = new JLabel(texto);
        label1.setBounds(posicionX,posicionY,ancho,altura);
        add(label1);
        return label1;
    }

    public JRadioButton aniadirRadioButton(String texto, int posicionX, int posicionY, int ancho, int altura) {
        JRadioButton radio1 = new JRadioButton(texto);
        radio1.setBounds(posicionX,posicionY,ancho,altura);
        radio1.addChangeListener(this);
        radio1.setEnabled(false);
        radio1.setSelected(true);
        add(radio1);
        return radio1;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Debe sobrescribir la funcion itemStateChanged");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Debe sobrescribir la funcion actionPerformed");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println("Debe sobrescribir la funcion stateChanged");
    }
    
}
