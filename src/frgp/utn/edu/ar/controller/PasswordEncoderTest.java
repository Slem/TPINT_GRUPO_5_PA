package frgp.utn.edu.ar.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin")); // Imprime la contraseña encriptada para 'admin'
        System.out.println(encoder.encode("1234")); // Imprime la contraseña encriptada para '1234'
    }
}