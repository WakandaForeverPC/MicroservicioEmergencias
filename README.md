# Microservicio de Gestión de Emergencias

Este proyecto es un microservicio de gestión de emergencias que permite la visualización y gestión de vehículos de emergencia, alertas y rescates inteligentes en un tablero interactivo.

## Tecnologías Utilizadas

- **Java**
- **Spring Boot**
- **Maven**
- **JavaScript**
- **Thymeleaf**
- **WebSocket**

## Estructura del Proyecto

- `src/main/java/com/proyecto/microservicioemergencias`
  - **config**: Configuración de WebSocket.
  - **controller**: Controladores REST y de vistas.
  - **model**: Modelos de datos para alertas, vehículos de emergencia y rescates.
  - **service**: Servicios para la lógica de negocio.
- `src/main/resources`
  - **static**: Archivos estáticos (JavaScript, CSS).
  - **templates**: Plantillas Thymeleaf.
  - **application.properties**: Configuración de la aplicación.

## Configuración

### WebSocket

La configuración de WebSocket se encuentra en `WebSocketConfig.java`.

### Controladores

- **EmergenciasBoardController**: Controlador para la vista del tablero de emergencias.
- **EmergenciasController**: Controlador REST para obtener datos de vehículos, alertas y rescates.

### Modelos

- **Alerta**: Representa una alerta de emergencia.
- **EmergencyVehicle**: Representa un vehículo de emergencia.
- **Rescate**: Representa un rescate inteligente.

### Servicios

- **AlertaServicio**: Servicio para gestionar alertas.
- **EmergencyVehicleService**: Servicio para gestionar vehículos de emergencia.
- **RescateServicio**: Servicio para gestionar rescates.
- **EmergencyWebSocketService**: Servicio para enviar actualizaciones a través de WebSocket.

## Frontend

El frontend se encuentra en `src/main/resources/static/emergencias` y utiliza JavaScript para actualizar el tablero de emergencias en tiempo real.

### JavaScript

El archivo `script.js` maneja la lógica de actualización del tablero.

### CSS

El archivo `styles.css` define los estilos para el tablero y los elementos visuales.

### HTML

La plantilla `board-emergencias.html` define la estructura del tablero.

## Documentación de la API

La API REST del microservicio de gestión de emergencias proporciona los siguientes endpoints:

- `GET /emergencias/vehiculos`: Obtiene la lista de vehículos de emergencia.
- `GET /emergencias/alertas`: Obtiene la lista de alertas de emergencia.
- `GET /emergencias/rescates`: Obtiene la lista de rescates inteligentes.
