/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utnfrm.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import org.utnfrm.dao.DAOEmpleado;
import org.utnfrm.dao.DAOFactory;

/**
 *
 * @author yeron
 */
public class RunGestionEmpleados extends JFrame {

    private JMenuBar jmnubarBarraDeMenus;
    private JMenu jmnuEmpleado;
    private JMenuItem jmItemAltaEmpleado;
    private JMenuItem jmItemBajaEmpleado;
    private JMenuItem jmItemModificarEmpleado;
    private JMenuItem jmItemCalcularSalario;

    private JSeparator jSeparador1;
    private JMenuItem jSalir;
    private JLabel jlbSaludo;
    private JLabel jlbCantidadEmpleados;
    private JMenu jmnuIdioma;
    private JMenuItem jmItemEspañol;
    private JMenuItem jmItemIngles;
    private JMenuItem jmItemFrances;

    private Locale localizacion = Locale.getDefault();

    static String mostrarValor(Locale locale, String key) {
        ResourceBundle rs = ResourceBundle.getBundle("org.utnfrm.app.menu", locale);
        String valor = rs.getString(key);
        return valor;
    }

    public RunGestionEmpleados() {

        setSize(400, 210);
        setTitle("Gestión de Empleados");
        getContentPane().setBackground(Color.DARK_GRAY);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();

    }

    private void initComponents() {
        DAOEmpleado empDAO = DAOFactory.crearEmpleadoDAO();
        long ctidadEmpleados = empDAO.getCantidadEmpleados();
        getContentPane().setLayout(null);
        jlbSaludo = new JLabel();
        getContentPane().add(jlbSaludo);
        //  jlbSaludo.setText("BIENVENIDO A LA GESTIÓN DE EMPLEADOS");
        jlbSaludo.setText(mostrarValor(localizacion, "saludoInicio"));
        jlbSaludo.setBounds(90, 30, 400, 40);

        jlbCantidadEmpleados = new JLabel();
        getContentPane().add(jlbCantidadEmpleados);
        jlbCantidadEmpleados.setText(mostrarValor(localizacion, "cantidadEmp") + " " + ctidadEmpleados);
        jlbCantidadEmpleados.setBounds(100, 60, 400, 40);

        jlbCantidadEmpleados.setForeground(Color.white);
        jlbSaludo.setForeground(Color.white);

        /*
            creamos la barra de menu
         */
        jmnubarBarraDeMenus = new JMenuBar();
        setJMenuBar(jmnubarBarraDeMenus);

        /*
            le agregamos un menu a esa barra
         */
        jmnuEmpleado = new JMenu();
        jmnuEmpleado.setMnemonic('E');
        jmnuEmpleado.setText(mostrarValor(localizacion, "empleados"));
        jmnubarBarraDeMenus.add(jmnuEmpleado);

        /*
            Creamos y agregamos los items al menu
         */
        jmItemAltaEmpleado = new JMenuItem();
        jmItemBajaEmpleado = new JMenuItem();
        jmItemModificarEmpleado = new JMenuItem();
        jmItemCalcularSalario = new JMenuItem();

        jmItemAltaEmpleado.setText(mostrarValor(localizacion, "itemAlta"));
        jmItemBajaEmpleado.setText(mostrarValor(localizacion, "itemBaja"));
        jmItemModificarEmpleado.setText(mostrarValor(localizacion, "itemModificar"));
        jmItemCalcularSalario.setText(mostrarValor(localizacion, "itemCalcular"));

        jmnuEmpleado.add(jmItemAltaEmpleado);
        jmnuEmpleado.add(jmItemBajaEmpleado);
        jmnuEmpleado.add(jmItemModificarEmpleado);
        jmnuEmpleado.add(jmItemCalcularSalario);

        jSeparador1 = new JSeparator();
        jmnuEmpleado.add(jSeparador1);

        jSalir = new JMenuItem();
        jSalir.setText(mostrarValor(localizacion, "itemSalir"));
        jmnuEmpleado.add(jSalir);

        /*
            Creamos otro menú para elección de idioma
         */
        jmnuIdioma = new JMenu();
        jmnuIdioma.setText(mostrarValor(localizacion, "idioma"));
        jmnuIdioma.setMnemonic('I');
        jmnubarBarraDeMenus.add(jmnuIdioma);

        /*
            Items para ese menú
         */
        jmItemEspañol = new JMenuItem();
        jmItemIngles = new JMenuItem();
        jmItemFrances = new JMenuItem();

        jmItemEspañol.setText(mostrarValor(localizacion, "español"));
        jmItemIngles.setText(mostrarValor(localizacion, "ingles"));
        jmItemFrances.setText(mostrarValor(localizacion, "frances"));

        jmnuIdioma.add(jmItemEspañol);
        jmnuIdioma.add(jmItemIngles);
        jmnuIdioma.add(jmItemFrances);

        //------------------------------------
        /*
            Creamos un manejador de eventos
         */
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Locale locale = null;
                Object item = ae.getSource();
                String idioma = "";
                if (item == jmItemEspañol) {
                    idioma = "español";
                    localizacion = Locale.getDefault();
                    jlbSaludo.setText(mostrarValor(localizacion, "saludoInicio"));
                    jlbCantidadEmpleados.setText(mostrarValor(localizacion, "cantidadEmp") + " " + ctidadEmpleados);
                    jmnuEmpleado.setText(mostrarValor(localizacion, "empleados"));
                    jmItemAltaEmpleado.setText(mostrarValor(localizacion, "itemAlta"));
                    jmItemBajaEmpleado.setText(mostrarValor(localizacion, "itemBaja"));
                    jmItemModificarEmpleado.setText(mostrarValor(localizacion, "itemModificar"));
                    jmItemCalcularSalario.setText(mostrarValor(localizacion, "itemCalcular"));

                    jmItemEspañol.setText(mostrarValor(localizacion, "español"));
                    jmItemIngles.setText(mostrarValor(localizacion, "ingles"));
                    jmItemFrances.setText(mostrarValor(localizacion, "frances"));
                    jmnuIdioma.setText(mostrarValor(localizacion, "idioma"));
                    jSalir.setText(mostrarValor(localizacion, "itemSalir"));

                } else if (item == jmItemFrances) {
                    localizacion = Locale.FRANCE;
                    idioma = "frances";
                    jlbSaludo.setText(mostrarValor(localizacion, "saludoInicio"));
                    jlbCantidadEmpleados.setText(mostrarValor(localizacion, "cantidadEmp") + " " + ctidadEmpleados);
                    jmnuEmpleado.setText(mostrarValor(localizacion, "empleados"));
                    jmItemAltaEmpleado.setText(mostrarValor(localizacion, "itemAlta"));
                    jmItemBajaEmpleado.setText(mostrarValor(localizacion, "itemBaja"));
                    jmItemModificarEmpleado.setText(mostrarValor(localizacion, "itemModificar"));
                    jmItemCalcularSalario.setText(mostrarValor(localizacion, "itemCalcular"));

                    jmItemEspañol.setText(mostrarValor(localizacion, "español"));
                    jmItemIngles.setText(mostrarValor(localizacion, "ingles"));
                    jmItemFrances.setText(mostrarValor(localizacion, "frances"));
                    jmnuIdioma.setText(mostrarValor(localizacion, "idioma"));
                    jSalir.setText(mostrarValor(localizacion, "itemSalir"));

                } else if (item == jmItemIngles) {
                    localizacion = Locale.US;
                    idioma = "ingles";
                    jlbSaludo.setText(mostrarValor(localizacion, "saludoInicio"));
                    jlbCantidadEmpleados.setText(mostrarValor(localizacion, "cantidadEmp") + " " + ctidadEmpleados);
                    jmnuEmpleado.setText(mostrarValor(localizacion, "empleados"));
                    jmItemAltaEmpleado.setText(mostrarValor(localizacion, "itemAlta"));
                    jmItemBajaEmpleado.setText(mostrarValor(localizacion, "itemBaja"));
                    jmItemModificarEmpleado.setText(mostrarValor(localizacion, "itemModificar"));
                    jmItemCalcularSalario.setText(mostrarValor(localizacion, "itemCalcular"));

                    jmItemEspañol.setText(mostrarValor(localizacion, "español"));
                    jmItemIngles.setText(mostrarValor(localizacion, "ingles"));
                    jmItemFrances.setText(mostrarValor(localizacion, "frances"));
                    jmnuIdioma.setText(mostrarValor(localizacion, "idioma"));
                    jSalir.setText(mostrarValor(localizacion, "itemSalir"));
                }

                if (localizacion == Locale.US && item == jmItemAltaEmpleado) {

                    jmItemAltaEmpleadoActionPerformedIngles(ae);

                } else if (localizacion == Locale.US && item == jmItemBajaEmpleado) {
                    jmItemBajaEmpleadoActionPerformedIngles(ae);
                } else if (localizacion == Locale.US && item == jmItemModificarEmpleado) {
                    jmItemModificarEmpleadoActionPerformedIngles(ae);
                } else if (localizacion == Locale.US && item == jSalir) {
                    jmItemSalirActionPerformedIngles(ae);
                } else if (localizacion == Locale.US && item == jmItemCalcularSalario) {
                    jmItemCalcularSalarioActionPerformedIngles(ae);
                } else if (localizacion == Locale.US && item == jmItemEspañol) {

                }

                if (localizacion == Locale.getDefault() && item == jmItemAltaEmpleado) {
                    jmItemAltaEmpleadoActionPerformedEspañol(ae);
                } else if (localizacion == Locale.getDefault() && item == jmItemBajaEmpleado) {
                    jmItemBajaEmpleadoActionPerformedEspañol(ae);
                } else if (localizacion == Locale.getDefault() && item == jmItemModificarEmpleado) {
                    jmItemModificarEmpleadoActionPerformedEspañol(ae);
                } else if (localizacion == Locale.getDefault() && item == jSalir) {
                    jmItemSalirActionPerformedEspañol(ae);
                } else if (localizacion == Locale.getDefault() && item == jmItemCalcularSalario) {
                    jmItemCalcularSalarioActionPerformedEspañol(ae);
                }

                if (localizacion == Locale.FRANCE && item == jmItemAltaEmpleado) {
                    jmItemAltaEmpleadoActionPerformedFrances(ae);
                } else if (localizacion == Locale.FRANCE && item == jmItemBajaEmpleado) {
                    jmItemBajaEmpleadoActionPerformedFrances(ae);
                } else if (localizacion == Locale.FRANCE && item == jmItemModificarEmpleado) {
                    jmItemModificarEmpleadoActionPerformedFrances(ae);
                } else if (localizacion == Locale.FRANCE && item == jSalir) {
                    jmItemSalirActionPerformedFrances(ae);
                } else if (localizacion == Locale.FRANCE && item == jmItemCalcularSalario) {
                    jmItemCalcularSalarioActionPerformeFrancesEspañol(ae);
                }

            }

        };

        jmItemAltaEmpleado.addActionListener(al);
        jmItemBajaEmpleado.addActionListener(al);
        jSalir.addActionListener(al);
        jmItemModificarEmpleado.addActionListener(al);
        jmItemCalcularSalario.addActionListener(al);

        jmItemIngles.addActionListener(al);
        jmItemFrances.addActionListener(al);
        jmItemEspañol.addActionListener(al);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    private void jmItemSalirActionPerformedEspañol(ActionEvent ae) {
        System.exit(0);
    }

    private void jmItemAltaEmpleadoActionPerformedEspañol(ActionEvent ae) {
        new AltaEmpleado(this, "español", false).setVisible(true);

    }

    private void jmItemBajaEmpleadoActionPerformedEspañol(ActionEvent ae) {
        new BajaEmpleado(this, "español", false).setVisible(true);
    }

    private void jmItemModificarEmpleadoActionPerformedEspañol(ActionEvent ae) {
        new ModificarEmpleado(this, "español", false).setVisible(true);
    }

    private void jmItemCalcularSalarioActionPerformedEspañol(ActionEvent ae) {
        new CalculoSalario(this, "español", false).setVisible(true);
    }

    private void jmItemAltaEmpleadoActionPerformedIngles(ActionEvent ae) {
        new AltaEmpleado(this, "ingles", false).setVisible(true);
    }

    private void jmItemBajaEmpleadoActionPerformedIngles(ActionEvent ae) {
        new BajaEmpleado(this, "ingles", false).setVisible(true);
    }

    private void jmItemModificarEmpleadoActionPerformedIngles(ActionEvent ae) {
        new ModificarEmpleado(this, "ingles", false).setVisible(true);
    }

    private void jmItemSalirActionPerformedIngles(ActionEvent ae) {
        System.exit(0);
    }

    private void jmItemCalcularSalarioActionPerformedIngles(ActionEvent ae) {
        new CalculoSalario(this, "ingles", false).setVisible(true);
    }

    private void jmItemAltaEmpleadoActionPerformedFrances(ActionEvent ae) {
        new AltaEmpleado(this, "frances", false).setVisible(true);
    }

    private void jmItemBajaEmpleadoActionPerformedFrances(ActionEvent ae) {
        new BajaEmpleado(this, "frances", false).setVisible(true);
    }

    private void jmItemModificarEmpleadoActionPerformedFrances(ActionEvent ae) {
        new ModificarEmpleado(this, "frances", false).setVisible(true);
    }

    private void jmItemSalirActionPerformedFrances(ActionEvent ae) {
        System.exit(0);
    }

    private void jmItemCalcularSalarioActionPerformeFrancesEspañol(ActionEvent ae) {
        new CalculoSalario(this, "frances", false).setVisible(true);
    }

    public static void main(String[] args) {
        new RunGestionEmpleados().setVisible(true);
    }
}
