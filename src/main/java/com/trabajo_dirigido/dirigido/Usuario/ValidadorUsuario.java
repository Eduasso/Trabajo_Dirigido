package com.trabajo_dirigido.dirigido.Usuario;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidadorUsuario implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Usuario.class.equals(aClass); // clase del bean al que da soporte este validador
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        // El nombre es obligatorio
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.nombre.required", "El nombre es obligatorio");

        // Longitud del nombre máxima: 20 caracteres
        if(usuario.getNombre().length() > 20){
            errors.rejectValue("nombre", "field.nombre.invalid", "El nombre debe tener una longitud máxima de 20 caracteres");
        }

        // Los apellidos son obligatorios
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "field.apellidos.required", "Los apellidos son obligatorios");

        // Longitud de los apellidos máxima: 40 caracteres
        if(usuario.getApellidos().length() > 40){
            errors.rejectValue("apellidos", "field.apellidos.invalid", "Los apellidos deben tener una longitud máxima de 40 caracteres");
        }

        // El DNI es obligatorio
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "field.dni.required", "El DNI es obligatorio");

        // El DNI debe tener un formato NNNNNNNNL donde N=Nº y L=Letra
        validarDNI(usuario.getDni(), errors);

        // El Nº de teléfono es obligatorio
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telef", "field.telef.required", "El Nº de teléfono es obligatorio");

        // El Nº de teléfono debe tener una longitud entre 9 y 12 dígitos
        if(usuario.getTelef().length() < 9 || usuario.getTelef().length() > 12){
            errors.rejectValue("telef", "field.telef.invalid", "El Nº de teléfono debe tener una longitud de entre 9 y 12 dígitos");
        }

        // La dirección es obligatoria
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion", "field.direccion.required", "La direccion es obligatoria");

        // La direción debe tener una longitud máxima de 50 caracteres
        if(usuario.getDireccion().length() > 50){
            errors.rejectValue("direccion", "field.direccion.invalid", "La dirección debe tener una longitud máxima de 50 caracteres");
        }

        // El correo es obligatorio
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "field.correo.required", "El correo electrónico es obligatorio");

        // El correo debe tener una longitud máxima de 30 caracteres
        if(usuario.getCorreo().length() > 30){
            errors.rejectValue("correo", "field.correo.invalid", "El correo electrónico debe tener una longitud máxima de 30 caracteres");
        }

        // La password es obligatoria
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.password.required", "La contraseña es obligatoria");

        // La contraseña debe tener una longitud mínima de 10 caracteres
        if(usuario.getPassword().length() < 10){
            errors.rejectValue("password", "field.password.invalid", "La contraseña debe tener una longitud mínima de 10 caracteres");
        }

    }

    private void validarDNI(String dni, Errors errors){
        String letraMayuscula = ""; //Guardaremos la letra introducida en formato mayúscula

        // Aquí excluimos cadenas distintas a 9 caracteres que debe tener un dni y también si el último caracter no es una letra
        if(dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
            errors.rejectValue("password", "field.password.invalid", "DNI no válido");
        }

        // Al superar la primera restricción, la letra la pasamos a mayúscula
        letraMayuscula = (dni.substring(8)).toUpperCase();

        // Por último validamos que sólo tengo 8 dígitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuación
        // Llamamos a los métodos privados de la clase soloNumeros() y letraDNI()
        if(soloNumeros(dni) && letraDNI(dni).equals(letraMayuscula)) {
            return;
        }
        else {
            errors.rejectValue("dni", "field.dni.invalid", "DNI no válido");
        }

    }

    private String letraDNI(String dni) {
        // El método es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella

        // pasar miNumero a integer
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }

    private boolean soloNumeros(String dni) {

        int i, j = 0;
        String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8 primeros dígitos
        String miDNI = ""; // Guardamos en una cadena los números para después calcular la letra
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

        for(i = 0; i < dni.length() - 1; i++) {
            numero = dni.substring(i, i+1);

            for(j = 0; j < unoNueve.length; j++) {
                if(numero.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }

        if(miDNI.length() != 8) {
            return false;
        }
        else {
            return true;
        }
    }

    private boolean esta(String digito){
        boolean esta = false;
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < unoNueve.length; i++){
            if(digito == unoNueve[i]){
                esta = true;
            }
        }
        return esta;
    }

}
