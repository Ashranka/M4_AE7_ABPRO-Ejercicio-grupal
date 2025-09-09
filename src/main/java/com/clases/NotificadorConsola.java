package com.clases;

public class NotificadorConsola implements Notificador {
    @Override
    public void enviar(String mensaje, Usuario usuario) {
        System.out.println("Enviando notificación a: " + usuario.getEmail());
        System.out.println("ensaje: " + mensaje);
        System.out.println("Notificación enviada exitosamente");
    }
}
