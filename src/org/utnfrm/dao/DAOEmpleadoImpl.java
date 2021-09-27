/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utnfrm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.utnfrm.entidades.Empleado;
import org.utnfrm.entidades.EmpleadoAsalariado;
import org.utnfrm.entidades.EmpleadoBaseMasComision;
import org.utnfrm.entidades.EmpleadoPorComision;
import org.utnfrm.entidades.EmpleadoPorHoras;

/**
 *
 * @author yeron
 */
public class DAOEmpleadoImpl implements DAOEmpleado {

    Connection con = null;

    private long cantidadEmpleados;

    public DAOEmpleadoImpl() {
        String url = "jdbc:derby://localhost:1527/ProyectoFinalDB";

        try {
            con = DriverManager.getConnection(url);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos, " + e.getErrorCode() + e.getMessage(), "Error DB", JOptionPane.WARNING_MESSAGE);

        }

    }

    @Override
    public void crearEmpleado(Empleado emp) {

        String query;
        if (emp instanceof EmpleadoAsalariado) {
            try (Statement st = con.createStatement()) {
                EmpleadoAsalariado empleado = (EmpleadoAsalariado) emp;
                query = "INSERT INTO EMPLEADOS VALUES(" + emp.getLegajo() + ", "
                        + "'" + emp.getNombre() + "', "
                        + "'" + emp.getApellido() + "', "
                        + "'" + emp.getEmail() + "', "
                        + "'" + emp.getSsn() + "', "
                        + empleado.getSalarioSemanal() + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "1)";
                if (st.executeUpdate(query) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar al empleado en la base de datos");
                } else {

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar al empleado en la base de datos" + e.getMessage() + e.getLocalizedMessage());

            }
        } else if (emp instanceof EmpleadoBaseMasComision) {
            try (Statement st = con.createStatement()) {
                EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) emp;
                query = "INSERT INTO EMPLEADOS VALUES(" + emp.getLegajo() + ", "
                        + "'" + emp.getNombre() + "', "
                        + "'" + emp.getApellido() + "', "
                        + "'" + emp.getEmail() + "', "
                        + "'" + emp.getSsn() + "', "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + empleado.getVentasBrutas() + ", "
                        + empleado.getTarifaComision() + ", "
                        + empleado.getSalarioBase() + ", "
                        + "4)";
                System.out.println("sql creando emp base mas comi");
                if (st.executeUpdate(query) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar al empleado en la base de datos");
                } else {
                    //        cantidadEmpleados++;
                }

            } catch (Exception e) {
            }
        } else if (emp instanceof EmpleadoPorComision) {
            try (Statement st = con.createStatement()) {
                EmpleadoPorComision empleado = (EmpleadoPorComision) emp;
                query = "INSERT INTO EMPLEADOS VALUES(" + emp.getLegajo() + ", "
                        + "'" + emp.getNombre() + "', "
                        + "'" + emp.getApellido() + "', "
                        + "'" + emp.getEmail() + "', "
                        + "'" + emp.getSsn() + "', "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + empleado.getVentasBrutas() + ", "
                        + empleado.getTarifaComision() + ", "
                        + "NULL" + ", "
                        + "3)";
                if (st.executeUpdate(query) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar al empleado en la base de datos");
                } else {

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar al empleado en la base de datos");
            }
        } else if (emp instanceof EmpleadoPorHoras) {
            try (Statement st = con.createStatement()) {
                EmpleadoPorHoras empleado = (EmpleadoPorHoras) emp;
                query = "INSERT INTO EMPLEADOS VALUES(" + emp.getLegajo() + ", "
                        + "'" + emp.getNombre() + "', "
                        + "'" + emp.getApellido() + "', "
                        + "'" + emp.getEmail() + "', "
                        + "'" + emp.getSsn() + "', "
                        + "NULL" + ", "
                        + empleado.getTarifa() + ", "
                        + empleado.getHoras() + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "NULL" + ", "
                        + "2)";
                if (st.executeUpdate(query) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar al empleado en la base de datos");
                } else {

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar al empleado en la base de datos");
            }
        }

    }

    /*
        METODO ACTUALIZAR
     */
    @Override
    public void actualizarEmpleado(Empleado emp) {
        String query;
        String query2;
        query = "UPDATE EMPLEADOS SET NOMBRE ='" + emp.getNombre() + "', "
                + "APELLIDO ='" + emp.getApellido() + "', "
                + "EMAIL ='" + emp.getEmail() + "', "
                + "SSN ='" + emp.getSsn() + "', "
                + "SALARIO_SEMANAL = NULL, "
                + "TARIFA_HORA = NULL, "
                + "HORAS = NULL, "
                + "VENTAS_BRUTAS = NULL, "
                + "TARIFA_COMISION = NULL, "
                + "SALARIO_BASE = NULL"
                + " WHERE LEGAJO = " + emp.getLegajo();
        try (Statement st = con.createStatement()) {
            st.executeUpdate(query);
        } catch (Exception e) {

        }
        if (emp instanceof EmpleadoAsalariado) {
            EmpleadoAsalariado empleado = (EmpleadoAsalariado) emp;
            try (Statement st = con.createStatement()) {

                query2 = "UPDATE EMPLEADOS SET NOMBRE ='" + empleado.getNombre() + "', "
                        + "APELLIDO ='" + empleado.getApellido() + "', "
                        + "EMAIL ='" + empleado.getEmail() + "', "
                        + "SSN ='" + empleado.getSsn() + "', "
                        + "SALARIO_SEMANAL = " + empleado.getSalarioSemanal() + ", "
                        + "TIPO = 1"
                        + " WHERE LEGAJO = " + empleado.getLegajo();
                st.executeUpdate(query2);
                if (st.executeUpdate(query2) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar empleado", "Error", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar empleado en la db" + e.getMessage() + e.getErrorCode(), "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
            }
        } else if (emp instanceof EmpleadoPorHoras) {
            EmpleadoPorHoras empleado = (EmpleadoPorHoras) emp;
            try (Statement st = con.createStatement()) {
                query2 = "UPDATE EMPLEADOS SET NOMBRE ='" + empleado.getNombre() + "', "
                        + "APELLIDO ='" + empleado.getApellido() + "', "
                        + "EMAIL ='" + empleado.getEmail() + "', "
                        + "SSN ='" + empleado.getSsn() + "', "
                        + "TARIFA_HORA = " + empleado.getTarifa() + ", "
                        + "HORAS = " + empleado.getHoras() + ", "
                        + "TIPO = 2"
                        + " WHERE LEGAJO = " + empleado.getLegajo();

                if (st.executeUpdate(query2) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar empleado", "Error", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar empleado en la db" + e.getMessage() + e.getErrorCode(), "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
            }
        } else if (emp instanceof EmpleadoBaseMasComision) {
         
            EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) emp;
            try (Statement st = con.createStatement()) {
                query2 = "UPDATE EMPLEADOS SET NOMBRE ='" + empleado.getNombre() + "', "
                        + "APELLIDO ='" + empleado.getApellido() + "', "
                        + "EMAIL ='" + empleado.getEmail() + "', "
                        + "SSN ='" + empleado.getSsn() + "', "
                        + "VENTAS_BRUTAS = " + empleado.getVentasBrutas() + ", "
                        + "TARIFA_COMISION = " + empleado.getTarifaComision() + ", "
                        + "SALARIO_BASE = " + empleado.getSalarioBase() + ", "
                        + "TIPO = 4"
                        + " WHERE LEGAJO = " + empleado.getLegajo();

                if (st.executeUpdate(query2) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar empleado", "Error", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar empleado en la db" + e.getMessage() + e.getErrorCode(), "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
            }
        } else if (emp instanceof EmpleadoPorComision) {
            
            EmpleadoPorComision empleado = (EmpleadoPorComision) emp;
            try (Statement st = con.createStatement()) {
                query2 = "UPDATE EMPLEADOS SET NOMBRE ='" + empleado.getNombre() + "', "
                        + "APELLIDO ='" + empleado.getApellido() + "', "
                        + "EMAIL ='" + empleado.getEmail() + "', "
                        + "SSN ='" + empleado.getSsn() + "', "
                        + "VENTAS_BRUTAS = " + empleado.getVentasBrutas() + ", "
                        + "TARIFA_COMISION = " + empleado.getTarifaComision() + ", "
                        + "TIPO = 3"
                        + " WHERE LEGAJO = " + empleado.getLegajo();

                if (st.executeUpdate(query2) != 1) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar empleado", "Error", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar empleado en la db" + e.getMessage() + e.getErrorCode(), "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
            }
        }

    }

    @Override
    public void borrarEmpleado(long legajo) {

        Empleado emp = findById(legajo);

        if (emp == null) {
            JOptionPane.showMessageDialog(null, "El empleado no existe en la base de datos", "Error", JOptionPane.WARNING_MESSAGE);
        }

        try (Statement st = con.createStatement()) {

            String query = "DELETE FROM EMPLEADOS WHERE LEGAJO = " + legajo;

            if (st.executeUpdate(query) != 1) {
                JOptionPane.showMessageDialog(null, "Error al borrar al empleado", "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
            } else {

            }
        } catch (SQLException e) {

        }

    }

    @Override
    public Empleado findById(long legajo) {

        ResultSet rs = null;
        try (Statement st = con.createStatement()) {
            String query = "SELECT * FROM EMPLEADOS WHERE LEGAJO = " + legajo;
            rs = st.executeQuery(query);
            if (!rs.next()) {
                return null;
            } else if (rs.getInt("TIPO") == 1) {
                EmpleadoAsalariado emp = new EmpleadoAsalariado(rs.getInt("LEGAJO"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("SSN"),
                        rs.getString("EMAIL"),
                        rs.getInt("SALARIO_SEMANAL"));
                return emp;
            } else if (rs.getInt("TIPO") == 2) {
                EmpleadoPorHoras emp = new EmpleadoPorHoras(rs.getInt("LEGAJO"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("SSN"),
                        rs.getString("EMAIL"),
                        rs.getDouble("TARIFA_HORA"),
                        rs.getDouble("HORAS"));
                return emp;
            } else if (rs.getInt("TIPO") == 3) {
                EmpleadoPorComision emp = new EmpleadoPorComision(rs.getInt("LEGAJO"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("SSN"),
                        rs.getString("EMAIL"),
                        rs.getDouble("VENTAS_BRUTAS"),
                        rs.getDouble("TARIFA_COMISION"));
                return emp;
            } else if (rs.getInt("TIPO") == 4) {
                EmpleadoBaseMasComision emp = new EmpleadoBaseMasComision(rs.getInt("LEGAJO"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("SSN"),
                        rs.getString("EMAIL"),
                        rs.getDouble("VENTAS_BRUTAS"),
                        rs.getDouble("TARIFA_COMISION"),
                        rs.getDouble("SALARIO_BASE"));

                return emp;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el empleado por ID", "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(-1);
        }

        return null;
    }

    @Override
    public Empleado[] findAll() throws DAOExcepcion {
        try (Statement st = con.createStatement()) {

            String query = "SELECT * FROM EMPLEADOS";
            ResultSet rs = st.executeQuery(query);

            ArrayList<Empleado> listaEmpleados = new ArrayList<>();
            Empleado emp = null;
            while (rs.next()) {
                //  cantidadEmpleados++;
                switch (rs.getInt("TIPO")) {
                    case 1:

                        listaEmpleados.add(new EmpleadoAsalariado(rs.getInt("LEGAJO"),
                                rs.getString("NOMBRE"),
                                rs.getString("APELLIDO"),
                                rs.getString("SSN"),
                                rs.getString("EMAIL"),
                                rs.getDouble("SALARIO_SEMANAL")));

                        break;
                    case 2:

                        listaEmpleados.add(new EmpleadoPorHoras(rs.getInt("LEGAJO"),
                                rs.getString("NOMBRE"),
                                rs.getString("APELLIDO"),
                                rs.getString("SSN"),
                                rs.getString("EMAIL"),
                                rs.getDouble("TARIFA_HORA"),
                                rs.getDouble("HORAS")));

                        break;
                    case 3:

                        listaEmpleados.add(new EmpleadoPorComision(rs.getInt("LEGAJO"),
                                rs.getString("NOMBRE"),
                                rs.getString("APELLIDO"),
                                rs.getString("SSN"),
                                rs.getString("EMAIL"),
                                rs.getDouble("VENTAS_BRUTAS"),
                                rs.getDouble("TARIFA_COMISION")));

                        break;
                    case 4:
                       
                        listaEmpleados.add(new EmpleadoBaseMasComision(rs.getInt("LEGAJO"),
                                rs.getString("NOMBRE"),
                                rs.getString("APELLIDO"),
                                rs.getString("SSN"),
                                rs.getString("EMAIL"),
                                rs.getDouble("VENTAS_BRUTAS"),
                                rs.getDouble("TARIFA_COMISION"),
                                rs.getDouble("SALARIO_BASE")));

                        break;
                    default:
                        break;
                }
            }
            
     
                return listaEmpleados.toArray(new Empleado[0]);
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error a buscar los empleados en la base de datos", "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(-1);
            throw new DAOExcepcion();

        }

    }

    @Override
    public long getCantidadEmpleados() {
        try (Statement st = con.createStatement()) {

            String query = "SELECT * FROM EMPLEADOS";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                cantidadEmpleados++;
            }
        } catch (Exception e) {
        }
        return cantidadEmpleados;
    }

}
