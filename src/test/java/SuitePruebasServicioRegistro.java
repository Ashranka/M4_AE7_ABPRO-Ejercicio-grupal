import com.clases.Notificador;
import com.clases.NotificadorConsola;
import com.clases.ServicioDeRegistro;
import com.clases.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Suite de Pruebas - Servicio de Registro")
public class SuitePruebasServicioRegistro {

    @Nested
    @DisplayName("Pruebas del Servicio de Registro")
    public class PruebasServicioRegistro extends ServicioDeRegistroTest {
        // Las pruebas ya están definidas en la clase padre
    }

    @Nested
    @DisplayName("Pruebas de Integración")
    class PruebasIntegracion {

        @Test
        @DisplayName("Debería integrar correctamente con un notificador real")
        void deberiaIntegrarConNotificadorReal() {
            Notificador notificadorReal = new NotificadorConsola();
            ServicioDeRegistro servicio = new ServicioDeRegistro(notificadorReal);

            Usuario usuario = new Usuario("María García", "maria@ejemplo.com");

            assertDoesNotThrow(() -> servicio.registrar(usuario));
            assertEquals(1, servicio.getUsuariosRegistrados().size());
        }
    }
}
