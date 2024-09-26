<h1  align="center"> E-Commerce Challenge - Backend </h1>

<div align="center"> Backend de la aplicación que permite realizar ventas online y implementa un carrito de compras utilizando React para el frontend y Java para el backend. </div> &nbsp;

<p align="center">
  <a href="https://www.oracle.com/java/">
    <img src="https://badgen.net/badge/language/java/red" alt="Java Badge"/></a>
  <a href="https://spring.io/">
    <img src="https://badgen.net/badge/framework/spring/green" alt="Spring Badge"/></a>
   <a href="https://www.postman.com/">
    <img src="https://badgen.net/badge/framework/postman/orange" alt="Postman Badge"/></a>
  <a href="https://www.postman.com/">
    <img src="https://badgen.net/badge/framework/netBeans/pink" alt="Apache Net Beans Badge"/></a>
</p>

---

### Summary

- [Acerca del proyecto](#acerca-del-proyecto)
- [Getting Started](#getting-started)
  - [Requisitos previos](#requisitos-previos)
  - [Ejecucion](#ejecucion)
- [Controladores](#controladores)
  - [Documentación de Endpoints](#documentacion-de-endpoints)
  - [Descripcion](#descripcion)
- [Base de datos](#base-de-datos)
- [Documentacion](#documentacion)
- [Autor](#autor)

---

## Acerca del proyecto
El objetivo principal de este proyecto es implementar un sistema de carrito de compras completamente funcional, que permita a los usuarios crear productos, eliminar productos, agregar productos a su carrito, modificar o eliminar su carrito, crear un nuevo carrito y completar compras en línea sin inconvenientes.

## Getting Started

### Requisitos previos

#### Herramientas requeridas 🛠:
- Java JDK 17+
- Spring Framework
- Postman
- IDE: Eclipse, Apache NetBeans, IntelliJ IDEA o otro de su preferencia.

#### Tecnologias utilizadas 💻:
- Java 17
- Spring Framework
- Apache Maven
- JPA/Hibernate
- Unit test con Mockito
- Servicios REST
- Base de datos SQL

### Ejecucion
### En Apache NetBeans:

#### 1. Abrir el Proyecto
- Inicia Apache NetBeans.
- Ve a `File` > `Open Project`.
- Navega hasta la carpeta donde se encuentra el proyecto Java. Si es un proyecto Spring Maven, debería contener el archivo `pom.xml`.
- Selecciona la carpeta del proyecto y haz clic en `Open Project`.

#### 2. Instalar Dependencias y Compilar el Proyecto
- Antes de ejecutar el proyecto, asegúrate de que todas las dependencias estén instaladas y que el proyecto esté compilado correctamente.
- Haz clic derecho sobre el nombre del proyecto en el panel de proyectos.
- Selecciona la opción `Clean and Build`. Esto descargará todas las dependencias necesarias y compilará el proyecto.

#### 3. Ejecutar el proyecto

##### Opción 1: Ejecutar un archivo específico
- Busca la clase principal del proyecto, que generalmente contiene el método `main`.
- Haz clic derecho sobre esa clase y selecciona `Run File`, o utiliza el atajo `Shift + F6`.

##### Opción 2: Ejecutar el proyecto completo
- Haz clic derecho sobre el nombre del proyecto en el panel de proyectos.
- Selecciona la opción `Run` para ejecutar todo el proyecto.


## Controladores

### Documentacion de Endpoints
Los endpoints se encuentran documentados en **Postman** y pueden ser consultados en detalle a traves del siguiente enlace: [Documentacion Postman](https://documenter.getpostman.com/view/13720417/2sAXqy2Jmo)

Los endpoints se encuentran documentados en **Swagger** y se puede visualizar la documentacion una vez que es ejecutado el backend, a traves del siguiente enlace: [Documentacion Swagger](http://localhost:8080/swagger-ui/index.html#/)

### Descripcion

#### 1. CartController:
- **GET `/cart/get`** 
  Recupera y devuelve una lista todos los carritos de compras almacenados en la base de datos.

- **GET `/cart/get/{id}`**  
  Busca un carrito por su ID y devuelve el carrito correspondiente; si no se encuentra, devuelve `null`.

- **POST `/cart/add`**  
  Crea un nuevo carrito, estableciendo su estado a **ABIERTO**, y guarda el carrito en la base de datos, respondiendo con un mensaje de éxito o error.

- **PUT `/cart/update`**  
  Actualiza un carrito existente en la base de datos y devuelve el carrito actualizado.

- **DELETE `/cart/delete/{id}`**  
  Elimina el carrito con el ID especificado de la base de datos, sin devolver contenido.


#### 2. DetailController

- **GET `/detail/{id}`**  
  Obtiene los productos asociados a un carrito específico utilizando su ID. Devuelve un conjunto de productos o un conjunto vacío si el carrito no se encuentra.

- **POST `/detail/add`**  
  Agrega un producto a un carrito existente, respondiendo con el carrito actualizado o un mensaje de error.

- **DELETE `/detail/remove`**  
  Elimina un producto del carrito especificado. Devuelve un mensaje de éxito junto con el carrito actualizado o un error si el producto no se encuentra.

- **POST `/buy`**  
  Cambia el estado de un carrito a **CERRADO** cuando se finaliza la compra, devolviendo un mensaje de éxito o un error si el carrito no se encuentra.

#### 3. ProductController

- **GET `/get`**  
  Recupera y devuelve una lista de todos los productos almacenados en la base de datos.

- **GET `/get/{id}`**  
  Busca un producto por su ID y lo devuelve; si no se encuentra, responde con un error 404.

- **POST `/save`**  
  Crea y guarda un nuevo producto en la base de datos, devolviendo el producto creado con estado 201 (CREATED).

- **PUT `/update/{id}`**  
  Actualiza un producto existente y devuelve un mensaje de éxito o un error si el producto no se encuentra.

- **DELETE `/delete/{id}`**  
  Elimina el producto con el ID especificado, respondiendo con un mensaje de éxito o un error si el producto no se encuentra.


## Base de datos

- El proyecto tiene una base de datos MySQL que corre en el puerto 3306, esta base de datos se encuentra descripta en el archivo `application.properties` y se llama **productcard**, la cual debe ser creada antes de ejecutar el proyecto Spring Boot.
- Para crear y ejecutar la base de datos MySQL se deben seguir las instrucciones que se encuentran en la documentacion del proyecto que se puede consultar en el siguiente [enlace](https://docs.google.com/document/d/1MX4d5Cg2YuwSd9SPIqJOvRyBcUSvnwul8-zbhCcWmPA/edit?usp=sharing).

## Documentacion 🗂

Puedes consultar la documentación completa del proyecto en este [enlace](https://docs.google.com/document/d/1MX4d5Cg2YuwSd9SPIqJOvRyBcUSvnwul8-zbhCcWmPA/edit?usp=sharing).

## Autor 👩🏻‍💻

Estefanía Sassone
