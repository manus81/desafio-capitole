# Capitole Desafío

## Ejecución del Proyecto

1. Clonar el repositorio:
   ```bash
   git clone <url-del-repo>
   cd capitole-desafio

2. Compilar y ejecutar con Maven:
   ```bash
   mvn clean spring-boot:run

3. La aplicación estará disponible en: http://localhost:8080.


## Tecnologías Utilizadas

- Java 17
- Maven
- Spring Boot 3.3.4
- H2 Database (en memoria para pruebas)
- MapStruct
- Lombok


## Endpoint (ejemplo)

URL:
GET http://localhost:8080/prices/applicable?applicationDate=2024-06-15&productId=1&brandId=1

Parámetros de Consulta:

- applicationDate: Fecha del precio aplicable (formato yyyy-MM-dd).
- productId: ID del producto.
- brandId: ID de la marca.
