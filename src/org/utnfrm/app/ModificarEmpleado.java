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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.utnfrm.dao.DAOEmpleado;
import org.utnfrm.dao.DAOFactory;
import org.utnfrm.entidades.Empleado;
import org.utnfrm.entidades.EmpleadoAsalariado;
import org.utnfrm.entidades.EmpleadoBaseMasComision;
import org.utnfrm.entidades.EmpleadoPorComision;
import org.utnfrm.entidades.EmpleadoPorHoras;

/**
 *
 * @author yeron
 */
public class ModificarEmpleado extends JDialog implements Idiomas {

    private int error = 0;
    private int bdra = 0;
    private JLabel saludoLabel;
    private JLabel legajoLabel;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel emailLabel;
    private JLabel ssnLabel;
    private JLabel tipoEmpLabel;
    private JTextField jtfLegajo;
    private JTextField jtfNombre;
    private JTextField jtfApellido;
    private JTextField jtfEmail;
    private JTextField jtfSsn;
    private JComboBox<String> jListTipoEmp;
    private JButton jbActualizar;
    private JButton jbCancelar;
    private JLabel salarioSemanalLabel;
    private JLabel salarioBaseLabel;
    private JLabel tarifaLabel;
    private JLabel ventasBrutasLabel;
    private JLabel horasLabel;
    private JLabel tarifaComisionLabel;
    private JTextField jtfSalarioSemanal;
    private JTextField jtfSalarioBase;
    private JTextField jtfTarifa;
    private JTextField jtfVentasBrutas;
    private JTextField jtfHoras;
    private JTextField jtfTarifaComision;

    private JButton jbLegajo;

    @Override
    public String mostrarValor(Locale locale, String key) {
        ResourceBundle rs = ResourceBundle.getBundle("org.utnfrm.app.menu", locale);
        String valor = rs.getString(key);
        return valor;

    }

    public ModificarEmpleado(Frame frame, String idioma, boolean bln) {
        super(frame, bln);
        do {
            String idiomas = idioma;
            Locale localizacion = Locale.getDefault();
            if ("ingles".equals(idiomas)) {
                localizacion = Locale.US;
            } else if ("frances".equals(idiomas)) {
                localizacion = Locale.FRANCE;
            }
            initComponents(localizacion);
            // setSize(500, 700);
            setSize(500, 200);
            setTitle("Modificar empleado");
            Component RunGestionEmpleados = null;
            setLocationRelativeTo(RunGestionEmpleados);
            nombreLabel.setVisible(false);
            jtfNombre.setVisible(false);
            apellidoLabel.setVisible(false);
            jtfApellido.setVisible(false);
            emailLabel.setVisible(false);
            jtfEmail.setVisible(false);
            ssnLabel.setVisible(false);
            jtfSsn.setVisible(false);
            tipoEmpLabel.setVisible(false);
            jListTipoEmp.setVisible(false);
            salarioSemanalLabel.setVisible(false);
            jtfSalarioSemanal.setVisible(false);
            jbCancelar.setVisible(false);
            jbActualizar.setVisible(false);

            horasLabel.setVisible(false);
            jtfHoras.setVisible(false);
            tarifaLabel.setVisible(false);
            jtfTarifa.setVisible(false);
            ventasBrutasLabel.setVisible(false);
            jtfVentasBrutas.setVisible(false);
            tarifaComisionLabel.setVisible(false);
            jtfTarifaComision.setVisible(false);
            salarioBaseLabel.setVisible(false);
            jtfSalarioBase.setVisible(false);

        } while (bdra == 1);
    }

    private void initComponents(Locale locale) {
        getContentPane().setLayout(null);
        saludoLabel = new JLabel();
        saludoLabel.setText(mostrarValor(locale, "saludoModificar"));
        saludoLabel.setBounds(200, 10, 200, 20);
        getContentPane().add(saludoLabel);

        /*
            Creamos los labels
         */
        legajoLabel = new JLabel();
        legajoLabel.setText(mostrarValor(locale, "legajoModificar"));
        legajoLabel.setBounds(20, 40, 300, 20);
        getContentPane().add(legajoLabel);

        nombreLabel = new JLabel();
        nombreLabel.setText(mostrarValor(locale, "ingreseNombre"));
        nombreLabel.setBounds(20, 80, 200, 20);
        getContentPane().add(nombreLabel);

        apellidoLabel = new JLabel();
        apellidoLabel.setText(mostrarValor(locale, "ingreseApellido"));
        apellidoLabel.setBounds(20, 120, 200, 20);
        getContentPane().add(apellidoLabel);

        emailLabel = new JLabel();
        emailLabel.setText(mostrarValor(locale, "ingreseEmail"));
        emailLabel.setBounds(20, 160, 200, 20);
        getContentPane().add(emailLabel);

        ssnLabel = new JLabel();
        ssnLabel.setText(mostrarValor(locale, "ingreseSSN"));
        ssnLabel.setBounds(20, 200, 200, 20);
        getContentPane().add(ssnLabel);

        /*
            Creamos los text fields
         */
        jtfLegajo = new JTextField();
        jtfLegajo.setBounds(300, 40, 175, 20);
        getContentPane().add(jtfLegajo);

        jtfNombre = new JTextField();
        jtfNombre.setBounds(190, 80, 175, 20);
        getContentPane().add(jtfNombre);

        jtfApellido = new JTextField();
        jtfApellido.setBounds(190, 120, 175, 20);
        getContentPane().add(jtfApellido);

        jtfEmail = new JTextField();
        //   jtfEmail.setText("example@gmail.com");
        jtfEmail.setBounds(190, 160, 175, 20);
        getContentPane().add(jtfEmail);

        jtfSsn = new JTextField();
        jtfSsn.setBounds(190, 200, 175, 20);
        getContentPane().add(jtfSsn);

        /*
            Creamos el comboBox
         */
        tipoEmpLabel = new JLabel();
        tipoEmpLabel.setText(mostrarValor(locale, "tipoEmp"));
        tipoEmpLabel.setBounds(20, 259, 100, 20);
        getContentPane().add(tipoEmpLabel);

        String tipoEmpleados[] = {mostrarValor(locale, "empAsa"), mostrarValor(locale, "empHoras"), mostrarValor(locale, "empComision"), mostrarValor(locale, "empBaseMasComi")};
        jListTipoEmp = new JComboBox<>(tipoEmpleados);
        getContentPane().add(jListTipoEmp);
        jListTipoEmp.setBounds(190, 250, 200, 35);

        //-------------------------------------------
        /*
            Creamos los labels para el salario
         */
        salarioSemanalLabel = new JLabel();
        salarioSemanalLabel.setText(mostrarValor(locale, "salarioSemanal"));
        salarioSemanalLabel.setBounds(20, 310, 150, 40);
        getContentPane().add(salarioSemanalLabel);

        jtfSalarioSemanal = new JTextField();
        jtfSalarioSemanal.setBounds(190, 320, 150, 20);
        getContentPane().add(jtfSalarioSemanal);

        salarioBaseLabel = new JLabel();
        salarioBaseLabel.setText(mostrarValor(locale, "salarioBase"));
        salarioBaseLabel.setBounds(20, 310, 150, 40);
        getContentPane().add(salarioBaseLabel);

        jtfSalarioBase = new JTextField();
        jtfSalarioBase.setBounds(190, 320, 150, 20);
        getContentPane().add(jtfSalarioBase);

        ventasBrutasLabel = new JLabel();
        ventasBrutasLabel.setText(mostrarValor(locale, "ventasBrutas"));
        ventasBrutasLabel.setBounds(20, 310, 150, 40);
        getContentPane().add(ventasBrutasLabel);

        jtfVentasBrutas = new JTextField();
        jtfVentasBrutas.setBounds(190, 320, 150, 20);
        getContentPane().add(jtfVentasBrutas);

        tarifaLabel = new JLabel();
        tarifaLabel.setText(mostrarValor(locale, "tarifa"));
        tarifaLabel.setBounds(20, 310, 150, 40);
        getContentPane().add(tarifaLabel);

        jtfTarifa = new JTextField();
        jtfTarifa.setBounds(190, 320, 150, 20);
        getContentPane().add(jtfTarifa);

        tarifaComisionLabel = new JLabel();
        tarifaComisionLabel.setText(mostrarValor(locale, "tarifaComision"));
        tarifaComisionLabel.setBounds(20, 350, 150, 40);
        getContentPane().add(tarifaComisionLabel);

        jtfTarifaComision = new JTextField();
        jtfTarifaComision.setBounds(190, 360, 150, 20);
        getContentPane().add(jtfTarifaComision);

        horasLabel = new JLabel();
        horasLabel.setText(mostrarValor(locale, "horas"));
        horasLabel.setBounds(20, 350, 150, 40);
        getContentPane().add(horasLabel);

        jtfHoras = new JTextField();
        jtfHoras.setBounds(190, 360, 150, 20);
        getContentPane().add(jtfHoras);

        /*
            Creamos los botones
         */
        jbActualizar = new JButton();
        jbActualizar.setText(mostrarValor(locale, "jbActualizar"));
        jbActualizar.setBounds(75, 500, 150, 40);
        getContentPane().add(jbActualizar);

        jbCancelar = new JButton();
        jbCancelar.setText(mostrarValor(locale, "jbCancelar"));
        jbCancelar.setBounds(255, 500, 150, 40);
        getContentPane().add(jbCancelar);

        jbLegajo = new JButton();
        jbLegajo.setText(mostrarValor(locale, "jbBuscar"));
        jbLegajo.setBounds(125, 100, 250, 35);
        getContentPane().add(jbLegajo);

        jbLegajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DAOEmpleado empDAO = DAOFactory.crearEmpleadoDAO();
                int legajo = 0;
                try {
                    legajo = Integer.parseInt(jtfLegajo.getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "El legajo debe ser un número entero", "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }
                Empleado emp = empDAO.findById(legajo);
                if (empDAO.findById(legajo) != null) {

                    setSize(500, 700);
                    legajoLabel.setText(mostrarValor(locale, "ingreseLegajo"));
                    jtfLegajo.setBounds(190, 40, 185, 20);
                    jtfLegajo.setText(String.valueOf(emp.getLegajo()));
                    nombreLabel.setVisible(true);
                    jtfNombre.setVisible(true);
                    jtfNombre.setText(emp.getNombre());
                    apellidoLabel.setVisible(true);
                    jtfApellido.setVisible(true);
                    jtfApellido.setText(emp.getApellido());
                    emailLabel.setVisible(true);
                    jtfEmail.setVisible(true);
                    jtfEmail.setText(emp.getEmail());
                    ssnLabel.setVisible(true);
                    jtfSsn.setVisible(true);
                    jtfSsn.setText(emp.getSsn());
                    tipoEmpLabel.setVisible(true);
                    jListTipoEmp.setVisible(true);

                    jbCancelar.setVisible(true);
                    jbActualizar.setVisible(true);
                    jbLegajo.setVisible(false);
                    if (emp instanceof EmpleadoAsalariado) {
                        jtfSalarioSemanal.setVisible(true);
                        salarioSemanalLabel.setVisible(true);
                        jListTipoEmp.setSelectedItem(tipoEmpleados[0]);
                        EmpleadoAsalariado empleado = (EmpleadoAsalariado) emp;
                        jtfSalarioSemanal.setText(String.valueOf(empleado.getSalarioSemanal()));

                    } else if (emp instanceof EmpleadoPorHoras) {
                        jListTipoEmp.setSelectedItem(tipoEmpleados[1]);
                        EmpleadoPorHoras empleado = (EmpleadoPorHoras) emp;
                        jtfHoras.setText(String.valueOf(empleado.getHoras()));
                        jtfTarifa.setText(String.valueOf(empleado.getTarifa()));

                    } else if (emp instanceof EmpleadoBaseMasComision) {
                        salarioBaseLabel.setVisible(true);
                        jtfSalarioBase.setVisible(true);
                        jListTipoEmp.setSelectedItem(tipoEmpleados[3]);
                        EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) emp;
                        jtfTarifaComision.setText(String.valueOf(empleado.getTarifaComision()));
                        jtfVentasBrutas.setText(String.valueOf(empleado.getVentasBrutas()));
                        jtfSalarioBase.setText(String.valueOf(empleado.getSalarioBase()));

                    } else if (emp instanceof EmpleadoPorComision) {
                        jListTipoEmp.setSelectedItem(tipoEmpleados[2]);
                        EmpleadoPorComision empleado = (EmpleadoPorComision) emp;
                        jtfTarifaComision.setText(String.valueOf(empleado.getTarifaComision()));
                        jtfVentasBrutas.setText(String.valueOf(empleado.getVentasBrutas()));
                    }

                } else {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorLegajoExistente"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }

            }
        });

        jbActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DAOEmpleado empDAO = DAOFactory.crearEmpleadoDAO();
                bdra = 0;
                error = 0;
                int legajo = 0;
                try {
                    legajo = Integer.parseInt(jtfLegajo.getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorLegajo"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                }
                String nombre = "";
                String apellido = "";
                String ssn = "";
                String email = "";
                if (((jtfNombre.getText()).matches("[a-zA-Z]*") && !"".equals(jtfNombre.getText()))
                        && ((jtfApellido.getText()).matches("[a-zA-Z]*") && !"".equals(jtfApellido.getText()))) {
                    nombre = jtfNombre.getText().trim();
                    apellido = jtfApellido.getText().trim();
                    error = 0;

                } else {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorStrings"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                    error = 1;
                }
                if (((jtfSsn.getText()).matches("[0-9]*") && !"".equals(jtfSsn.getText()))) {
                    ssn = jtfSsn.getText().trim();
                    error = 0;
                } else {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorSSN"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                    error = 1;
                }

                if (jtfEmail.getText().matches("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@"
                        + "[a-zA-Z0-9-]+(\\.[a-z]{2,4})$") && !"".equals(jtfEmail.getText())) {
                    email = jtfEmail.getText().trim();
                    error = 0;
                } else {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorEmail"), "Error", JOptionPane.WARNING_MESSAGE);
                    bdra = 1;
                    error = 1;
                }
                String tipoEmp = (String) jListTipoEmp.getSelectedItem();

                if (empDAO.findById(legajo) != null && error == 0) {
                    if (tipoEmpleados[0].equals(tipoEmp)) {

                        double salarioSemanal = 0;
                        try {
                            salarioSemanal = Double.parseDouble(jtfSalarioSemanal.getText());
                            EmpleadoAsalariado emp = new EmpleadoAsalariado(legajo, nombre, apellido, ssn, email, salarioSemanal);
                            empDAO.actualizarEmpleado(emp);
                        } catch (NumberFormatException numberFormatException) {
                            JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorSalarioSemanal"), "Error", JOptionPane.WARNING_MESSAGE);
                        }

                    } else if (tipoEmpleados[3].equals(tipoEmp)) {

                        try {
                            double salarioBase = Double.parseDouble(jtfSalarioBase.getText());
                            double ventasBrutas = Double.parseDouble(jtfVentasBrutas.getText());
                            double tarifaComision = Double.parseDouble(jtfTarifaComision.getText());
                            EmpleadoBaseMasComision empleado = new EmpleadoBaseMasComision(legajo, nombre, apellido, ssn, email, ventasBrutas, tarifaComision, salarioBase);
                            empDAO.actualizarEmpleado(empleado);
                        } catch (NumberFormatException numberFormatException) {
                            JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorBaseMasComi"), "Error", JOptionPane.WARNING_MESSAGE);
                            bdra = 1;
                        }
                    } else if (tipoEmpleados[2].equals(tipoEmp)) {

                        try {
                            double ventasBrutas = Double.parseDouble(jtfVentasBrutas.getText());
                            double tarifaComision = Double.parseDouble(jtfTarifaComision.getText());
                            EmpleadoPorComision emp = new EmpleadoPorComision(legajo, nombre, apellido, ssn, email, ventasBrutas, tarifaComision);
                            empDAO.actualizarEmpleado(emp);
                        } catch (NumberFormatException numberFormatException) {
                            JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorComision"), "Error", JOptionPane.WARNING_MESSAGE);
                            bdra = 1;
                        }
                    } else if (tipoEmpleados[1].equals(tipoEmp)) {

                        try {
                            double tarifa = Double.parseDouble(jtfTarifa.getText());
                            double horas = Double.parseDouble(jtfHoras.getText());
                            EmpleadoPorHoras emp = new EmpleadoPorHoras(legajo, nombre, apellido, ssn, email, tarifa, horas);
                            empDAO.actualizarEmpleado(emp);
                        } catch (NumberFormatException numberFormatException) {
                            JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorHoras"), "Error", JOptionPane.WARNING_MESSAGE);
                            bdra = 1;
                        }
                    }
                    if (bdra == 0) {
                        JOptionPane.showMessageDialog(null, mostrarValor(locale, "empleadoActualizado") + tipoEmp);
                        //     JOptionPane.showMessageDialog(null, tipoEmp);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, mostrarValor(locale, "errorLegajoExistente"), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        /*
            METODO PARA QUE A MEDIDA QUE VAYA CAMBIANDO DE TIPO DE EMPLEADO 
            SE VAYAN MODIFICANDO LOS SALARIOS QUE APARECEN EN LA VENTANA
         */
        jListTipoEmp.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                String tipoEmp = (String) jListTipoEmp.getSelectedItem();

                if (tipoEmpleados[0].equals(tipoEmp)) {
                    salarioSemanalLabel.setVisible(true);
                    jtfSalarioSemanal.setVisible(true);
                    horasLabel.setVisible(false);
                    jtfHoras.setVisible(false);
                    tarifaLabel.setVisible(false);
                    jtfTarifa.setVisible(false);
                    ventasBrutasLabel.setVisible(false);
                    jtfVentasBrutas.setVisible(false);
                    tarifaComisionLabel.setVisible(false);
                    jtfTarifaComision.setVisible(false);
                    salarioBaseLabel.setVisible(false);
                    jtfSalarioBase.setVisible(false);

                } else if (tipoEmpleados[1].equals(tipoEmp)) {
                    salarioSemanalLabel.setVisible(false);
                    jtfSalarioSemanal.setVisible(false);
                    horasLabel.setVisible(true);
                    jtfHoras.setVisible(true);
                    tarifaLabel.setVisible(true);
                    jtfTarifa.setVisible(true);
                    ventasBrutasLabel.setVisible(false);
                    jtfVentasBrutas.setVisible(false);
                    tarifaComisionLabel.setVisible(false);
                    jtfTarifaComision.setVisible(false);
                    salarioBaseLabel.setVisible(false);
                    jtfSalarioBase.setVisible(false);

                } else if (tipoEmpleados[2].equals(tipoEmp)) {
                    salarioSemanalLabel.setVisible(false);
                    jtfSalarioSemanal.setVisible(false);
                    horasLabel.setVisible(false);
                    jtfHoras.setVisible(false);
                    tarifaLabel.setVisible(false);
                    jtfTarifa.setVisible(false);
                    ventasBrutasLabel.setVisible(true);
                    jtfVentasBrutas.setVisible(true);
                    tarifaComisionLabel.setVisible(true);
                    jtfTarifaComision.setVisible(true);
                    salarioBaseLabel.setVisible(false);
                    jtfSalarioBase.setVisible(false);

                } else if (tipoEmpleados[3].equals(tipoEmp)) {
                    salarioSemanalLabel.setVisible(false);
                    jtfSalarioSemanal.setVisible(false);
                    horasLabel.setVisible(false);
                    jtfHoras.setVisible(false);
                    tarifaLabel.setVisible(false);
                    jtfTarifa.setVisible(false);
                    ventasBrutasLabel.setVisible(true);
                    jtfVentasBrutas.setVisible(true);
                    tarifaComisionLabel.setVisible(true);
                    jtfTarifaComision.setVisible(true);
                    salarioBaseLabel.setBounds(20, 400, 150, 20);
                    jtfSalarioBase.setBounds(190, 400, 150, 20);
                    salarioBaseLabel.setVisible(true);
                    jtfSalarioBase.setVisible(true);

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
