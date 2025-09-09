
import com.clases.Notificador;
import com.clases.ServicioDeRegistro;
import com.clases.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicioDeRegistroTest {

    @Mock
    private Notificador notificadorMock;

    private ServicioDeRegistro servicioDeRegistro;

    @BeforeEach
    void setUp() {
        servicioDeRegistro = new ServicioDeRegistro(notificadorMock);
    }

    @Test
    void deberiaRegistrarUsuarioYEnviarNotificacion() {
        // Arrange
        Usuario usuario = new Usuario("Juan Pérez", "juan@ejemplo.com");
        String mensajeEsperado = "¡Bienvenido a nuestra aplicación, Juan Pérez!";

        // Act
        servicioDeRegistro.registrar(usuario);

        // Assert
        verify(notificadorMock, times(1)).enviar(mensajeEsperado, usuario);
    }

    @Test
    void deberiaLanzarExcepcionSiUsuarioEsNull() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            servicioDeRegistro.registrar(null);
        });

        // Verificar que no se llame al notificador
        verifyNoInteractions(notificadorMock);
    }

    @Test
    void deberiaLanzarExcepcionSiNombreEsNulo() {
        // Arrange
        Usuario usuarioSinNombre = new Usuario(null, "test@ejemplo.com");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            servicioDeRegistro.registrar(usuarioSinNombre);
        });

        verifyNoInteractions(notificadorMock);
    }

    @Test
    void deberiaLanzarExcepcionSiEmailEsNulo() {
        // Arrange
        Usuario usuarioSinEmail = new Usuario("Juan", null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            servicioDeRegistro.registrar(usuarioSinEmail);
        });

        verifyNoInteractions(notificadorMock);
    }
}