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
public class EmpleadoPorComision extends Empleado{

    
    private double ventasBrutas;
    private double tarifaComision;
    
    public EmpleadoPorComision(long legajo, String nombre, String apellido, String ssn, String email, double ventasBrutas, double tarifaComision) {
        super(legajo, nombre, apellido, ssn, email);
    
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public double getTarifaComision() {
        return tarifaComision;
    }
    
        @Override
    public double calcularSalario() {
    
    return ventasBrutas * tarifaComision;
    }

    @Override
    public String toString() {
        return "<html><body>Empleado por Comision: " +super.toString()+ "<br>VentasBrutas: " + ventasBrutas + "<br>TarifaComision: " + tarifaComision + " </body></html>";
    }
    
    
    
}
