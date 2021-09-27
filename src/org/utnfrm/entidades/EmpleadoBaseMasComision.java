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
public class EmpleadoBaseMasComision extends EmpleadoPorComision {

    private double salarioBase;

    public EmpleadoBaseMasComision(long legajo, String nombre, String apellido, String ssn, String email, double ventasBrutas, double tarifaComision, double salarioBase) {
        super(legajo, nombre, apellido, ssn, email, ventasBrutas, tarifaComision);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (getVentasBrutas() * getTarifaComision());
    }

    @Override
    public String toString() {
        return "<html><body>Empleado Base más Comisión: <br>" + "Nombre : " + super.getNombre() + "<br>Apellido: " + super.getApellido() +"<br>Numero de seguro social: "+ super.getSsn() + "<br>Email: " +super.getEmail() + "<br>Ventas Brutas: "+ super.getVentasBrutas()+ "<br>Tarifa Comision: "+ super.getTarifaComision()+   "<br>Salario Base: " + salarioBase + " </body></html>";
        
    }

}
