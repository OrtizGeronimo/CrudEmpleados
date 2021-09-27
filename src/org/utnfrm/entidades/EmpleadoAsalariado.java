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
public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    public EmpleadoAsalariado(long legajo, String nombre, String apellido, String ssn, String email, double salarioSemanal) {
        super(legajo, nombre, apellido, ssn, email);
        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    
    
    
    @Override
    public double calcularSalario() {
    
    return getSalarioSemanal();
    }

    @Override
    public String toString() {
        return "<html><body>Empleado Asalariado: " + super.toString() + "<br>Salario Semanal: " + salarioSemanal + " </body></html>";
    }

        

    
}
