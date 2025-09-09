# Ejercicio Grupal TDD - Servicio de Registro de Usuarios

**Grupo 3**
- Andrea Correa
- Andrés Shranka

## Descripción

Este proyecto implementa un servicio de registro de usuarios siguiendo TDD y Mockito para simular dependencias externas.

## Comandos principales

```bash
mvn clean compile
mvn test
mvn exec:java -Dexec.mainClass="evaGrupal.AplicacionDemo"
```

## Reflexiones del Equipo

### ¿Qué tan natural fue seguir TDD?

**Andrea**: "Al principio me costó cambiar la mentalidad de escribir el código primero. Estaba acostumbrada a pensar en la implementación antes que en las pruebas. Pero una vez que agarre el ritmo, TDD me obligó a pensar mejor en lo que realmente necesitaba."

**Andrés**: "Para mi fue desafiante porque quería saltarme directo a escribir la clase ServicioDeRegistro. Me parecía raro escribir código que sabía que iba a fallar. Pero después entendí que te ayuda a definir claramente qué esperas antes de implementarlo."

**Conclusión**: TDD no fue natural al principio, pero nos llevó a código más limpio y bien documentado. El ciclo Red-Green-Refactor se volvió más intuitivo después de las primeras iteraciones.

### ¿En qué momento dudaron del orden o diseño?

**Validaciones**: No estabamos seguros si validar en el constructor de Usuario o en ServicioDeRegistro. Las pruebas nos ayudaron a decidir hacerlo en ServicioDeRegistro.

**Granularidad de pruebas**: Andrea quería una prueba grande para todo el flujo, pero nos dimos cuenta de que pruebas pequeñas son más fáciles de mantener y debugear.

**Mocks vs implementación real**: Decidimos usar mocks para pruebas unitarias (aislamiento) e implementación real para pruebas de integración.

### ¿Qué aprendieron simulando dependencias?

**Andrea**: "Mockito es súper poderoso. Pudimos verificar que se llamaran los métodos correctos sin implementar realmente el envío de notificaciones. Los verify() nos dieron mucha confianza."

**Andrés**: "Los mocks hicieron las pruebas más rápidas. El pair programming funcionó bien - uno hacia de driver y el otro pensaba en casos edge."

**Ambos**: "Trabajar con la interfaz Notificador desde el principio nos permitió trabajar en paralelo. La comunicación fue clave para los contratos."

