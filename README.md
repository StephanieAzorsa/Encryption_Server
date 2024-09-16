<!-- PROJECT PRESENTATION -->
<div align="center">

  <h1 align="center">🔐 Argus Encryption Solver</h1>

  <p align="center">
    <a href="">Reportar Bug</a>
    |
    <a href="">Solicitar Feature</a>
  </p>
</div></br>

## 📌 Acerca del repositorio
Este proyecto implementa el backend para la solución de desencriptar un mensaje siguiendo un proceso específico de encriptación explicado por Argus. 
El backend está desarrollado en **Java** con **Spring Boot**.

## 🚀 Descripción del Proceso de Encriptación

Argus utilizó un proceso de encriptación basado en:
1. La inversión de palabras
2. Desplazamiento circular de letras 
3. Transformación modular. 

Nuestro backend sigue este proceso para encriptar el mensaje y el proceso inverso para desencriptar el mensaje.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**

## 🛠️ Instalación y Configuración

1. Clona el repositorio
2. Compila y ejecuta el backend con Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run

3. El servidor se ejecutará en http://localhost:8081


## 👩🏻‍💻 Mejoras Futuras
- Soporte para más tipos de encriptación.
- Guardado y gestión de mensajes encriptados.