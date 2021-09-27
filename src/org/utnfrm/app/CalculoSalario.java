/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utnfrm.app;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.utnfrm.dao.DAOEmpleado;
import org.utnfrm.dao.DAOFactory;
import org.utnfrm.entidades.Empleado;

/**
 *
 * @author yeron
 */
public class CalculoSalario extends JDialog implements Idiomas{

    private int error = 0;
    private int bdra = 0;
    private JLabel saludoLabel;
    private JLabel legajoLabel;
    private JTextField jtfLegajo;
    private JButton jbCancelar;
    private JButton jbVolver;
    private JButton jbBuscar;
    private JButton jbCalcular;
    private JLabel infoLabel;
    private JLabel salarioLabel;
     @Override
    public String mostrarValor(Locale locale, String key) {
     ResourceBundle rs = ResourceBundle.getBundle("org.utnfrm.app.menu", locale);
        String valor = rs.getString(key);
        return valor;
    }

    public CalculoSalario(Frame frame, String idioma, boolean bln) {
        super(frame, bln);
        do {
             String idiomas = idioma;
            Locale localizacion = Locale.getDefault();
            if ("ingles".equals(idiomas)) {
                localizacion = Locale.US;
            } else if ("frances".equals(idiomas)) {
                localizacion = Locale.FRANCE;
            }
            setSize(600, 450);
            setLayout(null);
            setTitle("Modificar Empleado");
            Component RunGestionEmpleados = null;
            setLocationRelativeTo(RunGestionEmpleados);
            initComponents(localizacion);

            salarioLabel.setVisible(false);
            jbCalcular.setVisible(false);
            jbVolver.setVisible(false);

        } while (bdra == 1 || error == 1);
    }

    private void initComponents(Locale locale) {

        saludoLabel = new JLabel();
        saludoLabel.setText(mostrarValor(locale, "saludoCalculo"));
        saludoLabel.setBounds(250, 30, 180, 20);
        getContentPane().add(saludoLabel);

        legajoLabel = new JLabel();
        legajoLabel.setText(mostrarValor(locale, "legajoCalculo"));
        legajoLabel.setBounds(20, 70, 250, 25);
        getContentPane().add(legajoLabel);

        jtfLegajo = new JTextField();
        jtfLegajo.setBounds(300, 70, 40, 25);
        getContentPane().add(jtfLegajo);

        infoLabel = new JLabel();
        infoLabel.setBounds(50, 50, 230, 210);
        getContentPane().add(infoLabel);

        salarioLabel = new JLabel();
        salarioLabel.setBounds(250, 220, 100, 50);
        getContentPane().add(salarioLabel);

        jbBuscar = new JButton();
        jbBuscar.setText(mostrarValor(locale, "jbBuscar"));
        jbBuscar.setBounds(90, 295, 150, 30);
        getContentPane().add(jbBuscar);

        jbCalcular = new JButton();
        jbCalcular.setText(mostrarValor(locale, "jbCalcular"));
        jbCalcular.setBounds(90, 295, 150, 30);
        getContentPane().add(jbCalcular);

        jbCancelar = new JButton();
        jbCancelar.setText(mostrarValor(locale, "jbCancelar"));
        jbCancelar.setBounds(340, 295, 150, 30);
        getContentPane().add(jbCancelar);

        jbVolver = new JButton();
        jbVolver.setText(mostrarValor(locale, "jbVolver"));
        jbVolver.setBounds(340, 295, 150, 30);
        getContentPane().add(jbVolver);

        jbBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DAOEmpleado empDAO = DAOFactory.crearEmpleadoDAO();
                int legajo = 0;
                try {
                    legajo = Integer.parseInt(jtfLegajo.getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorLegajo"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }
                Object item = ae.getSource();
                Empleado emp = empDAO.findById(legajo);
                if (empDAO.findById(legajo) != null) {
                    infoLabel.setText(emp.toString());
                    legajoLabel.setVisible(false);
                    jtfLegajo.setVisible(false);
                    jbCalcular.setVisible(true);
                    jbVolver.setVisible(true);
                    jbBuscar.setVisible(false);
                    jbCancelar.setVisible(false);
                    salarioLabel.setText("Salario: " + String.valueOf(emp.calcularSalario()));

                } else {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorLegajoExistente"), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jbCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                salarioLabel.setVisible(true);
                jbCalcular.setVisible(false);
                jbVolver.setVisible(false);
                jbCancelar.setVisible(true);
                jbCancelar.setText("Volver");
                jbCancelar.setBounds(225, 285, 150, 30);

            }
        });

        jbVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                dispose();
            }
        });
        jbCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

    }

   
}
