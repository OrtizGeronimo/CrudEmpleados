/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utnfrm.dao;

import java.sql.SQLException;
import org.utnfrm.entidades.Empleado;

/**
 *
 * @author yeron
 */
public interface DAOEmpleado {

    public void crearEmpleado(Empleado emp);

    public void actualizarEmpleado(Empleado emp);

    public void borrarEmpleado(long legajo);

    public Empleado findById(long legajo);

    public Empleado[] findAll() throws DAOExcepcion;
    
    public long getCantidadEmpleados();

}
