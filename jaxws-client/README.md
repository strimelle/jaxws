# JAX-WS Web Service and XSL Transformation

Web Services Assessment Task 2.

The project has two parts:

- `jaxws-server` – SOAP web service with directors and their movies. Data is stored in an H2 database.
- `jaxws-client` – web page that gets data from the web service and shows it as HTML or PDF using XSL.

## Technologies

Java, Spring Boot, Apache CXF, JAXB, H2, Liquibase, Spring Data JPA, XSLT, XSL-FO, Apache FOP, wsimport, Maven.

## How to run

First start the server, then the client (from the IDE or with Maven):

```
cd jaxws-server
mvnw spring-boot:run
```

```
cd jaxws-client
mvnw spring-boot:run
```

Useful addresses:

- client page: http://localhost:8081
- WSDL: http://localhost:8082/services/directors?wsdl
- H2 console: http://localhost:8082/h2-console (JDBC URL `jdbc:h2:mem:directors`, user `sa`, no password)

## Web service operations

- `getAllDirectors` – all directors
- `getDirectorById(id)` – one director
- `getDirectorsByGenre(genre)` – directors by genre code, e.g. `S`
- `getAllMovies` – all movies
- `getMoviesByDirectorId(id)` – movies of one director

## Testing with Postman

Send a `POST` request to `http://localhost:8082/services/directors`
with header `Content-Type: text/xml; charset=utf-8` and raw XML body, for example:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.jaxws.imazolevska.eif.viko.lt/">
    <soapenv:Header/>
    <soapenv:Body>
        <ser:getDirectorById>
            <id>1</id>
        </ser:getDirectorById>
    </soapenv:Body>
</soapenv:Envelope>
```

For other operations change the element inside `<soapenv:Body>`.

In SoapUI create a new SOAP project with the WSDL address above.

## Client generation (wsimport)

Client classes are generated from `jaxws-client/src/main/resources/wsdl/directors.wsdl`
when the client is built:

```
cd jaxws-client
mvnw clean compile
```

If the web service changes, save the new WSDL from the running server to this file and build the client again.

## Tests

```
mvnw test
```

Run it in both `jaxws-server` and `jaxws-client`.

## JavaDoc

JavaDoc is in the `docs` folder of each project.
