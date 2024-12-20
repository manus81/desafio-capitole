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
GET http://localhost:8080/prices/applicable?applicationDate=2020-06-15T10:00&productId=35455&brandId=1

Parámetros de Consulta:

- applicationDate: Fecha y hora del precio aplicable (formato yyyy-MM-dd).
- productId: ID del producto.
- brandId: ID de la marca.


## Ejecutar APP

- RUN (desde raiz del proyecto): docker compose up -d
