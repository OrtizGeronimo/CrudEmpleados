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
public abstract class Empleado {

    private long legajo;
    private String nombre;
    private String apellido;
    private String ssn;
    private String email;

    public Empleado(long legajo, String nombre, String apellido, String ssn, String email) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ssn = ssn;
        this.email = email;
    }

    public long getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }
    

    public abstract double calcularSalario();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Legajo: ").append(legajo).append("<br>");
        sb.append("Nombre: ").append(nombre).append("<br>");
        sb.append("Apellido: ").append(apellido).append("<br>");
        sb.append("Número de seguro social: ").append(ssn).append("<br>");
        sb.append("Email: ").append(email).append("<br>");
    
        return sb.toString();
    }

}
