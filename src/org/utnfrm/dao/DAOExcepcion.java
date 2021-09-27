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
public class DAOExcepcion extends Exception{

    public DAOExcepcion() {
    }

    public DAOExcepcion(String string) {
        super(string);
    }

    public DAOExcepcion(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DAOExcepcion(Throwable thrwbl) {
        super(thrwbl);
    }

    public DAOExcepcion(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
    
    
    
}
