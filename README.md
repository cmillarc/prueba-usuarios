Documentación del Proyecto

Este documento detalla cómo compilar y ejecutar el proyecto localmente.

Requisitos
Java 17
Maven

Pasos para la compilación y ejecución

1-Clonar el repositorio: Usa el comando git para clonar el repositorio a tu máquina local.

git clone https://github.com/cmillarc/prueba-usuarios.git

2-Compilar el proyecto: Navega hasta el directorio del proyecto y utiliza Maven para compilarlo.

cd tu-proyecto
mvn clean install

3-Ejecutar la aplicación: Usa el siguiente comando para ejecutar la aplicación:

mvn spring-boot:run

Documentación de la API
La documentación de la API está disponible en http://localhost:8080/swagger-ui.html.

Creación de usuarios
Para crear un usuario, se puede utilizar el siguiente ejemplo en el endpoint de creación de usuarios en Swagger 
(POST /users):

{
"name": "Juan Rodriguez",
"email": "juanro@driguz.org",
"password": "Hunter2$",
"phones": [
{
"number": "1234567",
"cityCode": "1",
"countryCode": "57"
}
]
}

Notas: se valida que el correo no exista, devuelve el siguiente error.

{
"mensaje": "El correo juanro@driguz.org ya está registrado"
}

valida correo y password, devuelve el siguiente error.

{
"password": "Password must be between 8 and 20 characters",
"email": "Email should be valid"
}

