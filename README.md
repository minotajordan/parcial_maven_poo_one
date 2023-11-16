
# Taller - Parcial

Bienvenido, bienvenida y bienvenides al taller parcial corte #2.

## Instrucciones:

1. **Clonar el Proyecto o Copiar los Archivos:**
   - Clona el proyecto o copia los archivos en el proyecto Maven existente que creaste usando Java Maven.

2. **Estructura del Proyecto:**

parqueadero
|-- src
| -- main | -- java
| -- com | -- taller
| |-- Vehiculo.java
| |-- Automovil.java
| |-- Motocicleta.java
| -- Main.java -- pom.xml
  
3. **Solucionar Error en `Motocicleta.java`:**
- Soluciona el error mencionado en la clase `Motocicleta.java`.

4. **Agregar Dependencias en `pom.xml`:**
- Agrega las siguientes dependencias en el archivo `pom.xml` justo debajo de `</properties>`:
  ```xml
  <dependencies>
      <!-- Spark Java -->
      <dependency>
          <groupId>com.sparkjava</groupId>
          <artifactId>spark-core</artifactId>
          <version>2.9.4</version>
      </dependency>
      <!-- Gson -->
      <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
          <version>2.8.8</version>
      </dependency>
  </dependencies>
  ```

5. **Instalar Extensión JSON Formatter:**
- Instala la extensión JSON Formatter en tu navegador (Google Chrome o Brave) desde [JSON Formatter](https://chromewebstore.google.com/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa?hl=es&pli=1).

6. **Build con Dependencias:**
- Realiza un "build with dependencies" en tu proyecto.

7. **Ejecutar en el Navegador:**
- Ejecuta las siguientes URLs en tu navegador:
  - [http://localhost:4567/automoviles](http://localhost:4567/automoviles)
  - [http://localhost:4567/agregarAutomovil/nissan/frontier/uyt2334/5](http://localhost:4567/agregarAutomovil/nissan/frontier/uyt2334/5)
  - [http://localhost:4567/automoviles](http://localhost:4567/automoviles)

8. **Completar Endpoints para Motocicleta:**
- Añade y haz funcionar los siguientes endpoints para motocicletas:
  - [http://localhost:4567/motos](http://localhost:4567/motos)
  - [http://localhost:4567/agregarMoto/Honda/XR/uyt2334/250](http://localhost:4567/agregarMoto/Honda/XR/uyt2334/250)
  - [http://localhost:4567/motos](http://localhost:4567/motos)

9. **Añadir Atributos `hora de ingreso` y `hora de salida`:**
- Añade los atributos `hora de ingreso` y `hora de salida` a las clases `Automovil` y `Motocicleta`.

10. **Crear Endpoints para Registrar Hora de Salida:**
 - Crea endpoints para registrar la hora de salida de motos y automóviles del parqueadero.

11. **Crear Endpoints para Verificar Vehículos en el Parqueadero:**
 - Crea dos endpoints para verificar qué motos y automóviles están dentro del parqueadero.
   - [http://localhost:4567/motosActuales](http://localhost:4567/motosActuales)
   - [http://localhost:4567/AutomovilesActuales](http://localhost:4567/AutomovilesActuales)

12. **Crear Endpoint para Reporte de Ganancias:**
 - Crea un endpoint para obtener un informe de las ganancias por cada vehículo que ingresó y salió del parqueadero.
   - [http://localhost:4567/motosReporte](http://localhost:4567/motosReporte)
   - [http://localhost:4567/AutomovilesReporte](http://localhost:4567/AutomovilesReporte)

## Extra

13. **Generar Dos Endpoints para Total de Ganancias del Día:**
 - Quien desee, generar dos endpoints para saber el total de ganancias del día por autos, motos y en general.

## Forma de Entrega:

Sube el proyecto a un nuevo repositorio y envíalo en las fechas acordadas.

Jordan Minota
