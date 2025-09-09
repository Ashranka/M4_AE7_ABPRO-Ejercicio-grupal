package com.clases;

import java.util.ArrayList;
import java.util.List;

public class ServicioDeRegistro {
    private final Notificador notificador;
    private final List<Usuario> usuariosRegistrados;

    public ServicioDeRegistro(Notificador notificador) {
        this.notificador = notificador;
        this.usuariosRegistrados = new ArrayList<>();
    }

    public void registrar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }

        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario es requerido");
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email del usuario es requerido");
        }

        usuariosRegistrados.add(usuario);

        String mensaje = "¡Bienvenido a nuestra aplicación, " + usuario.getNombre() + "!";
        notificador.enviar(mensaje, usuario);
    }

    public List<Usuario> getUsuariosRegistrados() {
        return new ArrayList<>(usuariosRegistrados);
    }
}