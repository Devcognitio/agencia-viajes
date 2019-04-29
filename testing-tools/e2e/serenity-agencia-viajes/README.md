# serenity-cucumber-gradle-screenplay
Un proyecto donde se ejemplifica el uso del patrón serenity 
[screenplay](http://thucydides.info/docs/serenity-staging/#_serenity_and_the_screenplay_pattern) con cucumber y gradle.

Las pruebas de este ejemplo se corren contra la página web de [Avianca](https://www.avianca.com/co/es/).

Por defecto, los tests corren en Chrome, así que es necesario tener instalada la última versión del chrome driver y 
tenerla agregada como una variable en el path del sistema.

## Detalles generales de la implementación

Los tests usan tareas (tasks), interacciones (interactions), preguntas (questions), elementos de páginas (user_interface)
definidas en `com.devcognitio.screenplay.avianca`.

La estructura completa del proyecto es la siguiente:

````
+ model
    Clases que usan el patrón object builder o relcionadas con el modelo de dominio
+ tasks
    Clases que representan tareas que realiza el actor a nivel de proceso de negocio
+ interacion
    Clases que representan las interacciones directas con la interfaz de usuario
+ user_interface
    Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario
+ questions
    Objectos usados para consultar acerca del estado de la aplicación
    
````

## Requerimientos

Para correr el proyecto se necesita Java JDK 1.8 y Gradle preferiblemente con la versión 4.7.

## Para correr el proyecto

clean test aggregate es el comando que correrá los tests y generará el reporte en la carpeta /target/site/serenity/
 