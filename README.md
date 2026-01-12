API de Entregas - Patrones de Diseño con Spring Boot

API REST desarrollada para gestionar destinatarios y entregas, aplicando patrones de diseño clásicos en un entorno Spring Boot.

Tecnologías

Java 21

Spring Boot 3

Spring Data JPA (Base de datos H2)

OpenFeign (Cliente HTTP)

Patrones de Diseño (Design Patterns)

Singleton: Utilizado internamente por Spring para la inyección de dependencias.

Strategy: Definido en la interfaz EntregaService, permitiendo múltiples implementaciones de la lógica de negocio.

Facade: Abstracción de la complejidad de consumir la API externa ViaCEP y persistir los datos en la base de datos local de forma transparente para el controlador.

Cómo ejecutar

Clona el repositorio, impórtalo como proyecto Maven y ejecuta la clase DeliveryApiApplication.
Los endpoints estarán disponibles en: http://localhost:8080/entregas
