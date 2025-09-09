package com.clases;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Notificador notificador = new NotificadorConsola();
        ServicioDeRegistro servicio = new ServicioDeRegistro(notificador);

        System.out.println("=== Demostración del Servicio de Registro ===\n");

        Usuario usuario1 = new Usuario("Ana López", "ana@ejemplo.com");
        Usuario usuario2 = new Usuario("Carlos Rodríguez", "carlos@ejemplo.com");

        servicio.registrar(usuario1);
        System.out.println();
        servicio.registrar(usuario2);

        System.out.println("\n=== Usuarios Registrados ===");
        servicio.getUsuariosRegistrados().forEach(System.out::println);

    }
}