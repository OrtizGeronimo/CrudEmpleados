/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utnfrm.dao;

/**
 *
 * @author yeron
 */
public class DAOFactory {
    public static DAOEmpleado crearEmpleadoDAO(){
        return new DAOEmpleadoImpl();
    }
}
