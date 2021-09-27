/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utnfrm.entidades;

/**
 *
 * @author yeron
 */
public class EmpleadoPorHoras extends Empleado{

    private double tarifa;
    private double horas;
    
    
    public EmpleadoPorHoras(long legajo, String nombre, String apellido, String ssn, String email, double tarifa, double horas) {
        super(legajo, nombre, apellido, ssn, email);
        this.tarifa = tarifa;
        this.horas = horas;
    
    }

    public double getTarifa() {
        return tarifa;
    }

    public double getHoras() {
        return horas;
    }

    
    
    @Override
    public double calcularSalario() {
    
        return tarifa * horas;
    }

    @Override
    public String toString() {
        return "<html><body>Empleado por Horas:  " +super.toString()+ "<br>Tarifa: " + tarifa + "<br>Horas: " + horas + " </body></html>";
    }
    
    
    
}
