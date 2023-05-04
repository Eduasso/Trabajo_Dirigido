package com.trabajo_dirigido.dirigido.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    @Size(min = 4, max = 25, message = "La longitud ${validatedValue} debe estar entre {min} y {max} caracteres")
    private String nombre;
    private String apellidos;
    @Id
    private String dni;
    private String telef;
    private String direccion;

    private String correo;

    private String password;
    public Usuario(String nombre, String apellidos, String dni, String telef, String direccion, String correo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telef = telef;
        this.direccion = direccion;
        this.correo = correo;
        this.password = password;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getTelef() {
        return telef;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
