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
public class BajaEmpleado extends JDialog implements Idiomas {

    private int bdra = 0;
    private JLabel saludoLabel;
    private JLabel consultaLabel;
    private JLabel infoLabel;
    private JTextField jtfConsulta;
    private JButton jbBuscar;
    private JButton jbBorrar;
    private JButton jbCancelar;
    private JLabel confirmacionLabel;
    @Override
    public String mostrarValor(Locale locale, String key) {
    ResourceBundle rs = ResourceBundle.getBundle("org.utnfrm.app.menu", locale);
        String valor = rs.getString(key);
        return valor;
    }

    public BajaEmpleado(Frame frame,String idioma, boolean bln) {
        super(frame, bln);

        do {
            String idiomas = idioma;
            Locale localizacion = Locale.getDefault();
            if ("ingles".equals(idiomas)) {
                localizacion = Locale.US;
            } else if ("frances".equals(idiomas)) {
                localizacion = Locale.FRANCE;
            }
            Component RunGestionEmpleados = null;
            setLocationRelativeTo(RunGestionEmpleados);
            setLayout(null);
            setSize(600, 400);
            setTitle("Baja Empleado");
            initComponents(localizacion);

        } while (bdra == 1);

    }

    private void initComponents(Locale locale) {

        saludoLabel = new JLabel();
        saludoLabel.setText(mostrarValor(locale, "saludoBaja"));
        saludoLabel.setBounds(225, 30, 150, 20);
        getContentPane().add(saludoLabel);

        consultaLabel = new JLabel();
        consultaLabel.setText(mostrarValor(locale, "legajoBaja"));
        consultaLabel.setBounds(20, 80, 300, 20);
        getContentPane().add(consultaLabel);

        jtfConsulta = new JTextField();
        jtfConsulta.setBounds(360, 80, 70, 20);
        getContentPane().add(jtfConsulta);

        infoLabel = new JLabel();
        infoLabel.setBounds(90, 50, 300, 150);
        getContentPane().add(infoLabel);
        infoLabel.setVisible(false);

        jbBuscar = new JButton();
        jbBuscar.setText(mostrarValor(locale, "jbBuscar"));
        jbBuscar.setBounds(75, 250, 150, 25);
        getContentPane().add(jbBuscar);

        jbCancelar = new JButton();
        jbCancelar.setText(mostrarValor(locale, "jbCancelar"));
        jbCancelar.setBounds(375, 250, 150, 25);
        getContentPane().add(jbCancelar);

        jbBorrar = new JButton();
        jbBorrar.setText(mostrarValor(locale, "jbBorrar"));
        getContentPane().add(jbBorrar);
        jbBorrar.setVisible(false);

        confirmacionLabel = new JLabel();
        confirmacionLabel.setText(mostrarValor(locale, "confirmacionBaja"));
        confirmacionLabel.setBounds(200, 200, 300, 20);
        getContentPane().add(confirmacionLabel);
        confirmacionLabel.setVisible(false);

        jbBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DAOEmpleado empDAO = DAOFactory.crearEmpleadoDAO();
                int legajo = 0;
                try {
                    legajo = Integer.parseInt(jtfConsulta.getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "El legajo debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }
                Empleado emp = empDAO.findById(legajo);
                if (empDAO.findById(legajo) != null) {
                    infoLabel.setText(emp.toString());
                    infoLabel.setVisible(true);
                    jbBuscar.setVisible(false);
                    jbBorrar.setVisible(true);
                    jbBorrar.setBounds(75, 250, 150, 25);
                    confirmacionLabel.setVisible(true);
                    consultaLabel.setVisible(false);
                    jtfConsulta.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "El legajo no corresponde a un empleado existente", "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }

            }

        });

        jbBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DAOEmpleado empDAO = DAOFactory.crearEmpleadoDAO();
                int legajo = 0;
                try {
                    legajo = Integer.parseInt(jtfConsulta.getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorLegajo"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }
                if (bdra == 0) {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "empleadoBorrado"));
                    dispose();

                    empDAO.borrarEmpleado(legajo);
                }
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
