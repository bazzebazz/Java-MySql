# Curso: Base de datos con Java y Spring Data

Este repositorio contiene todo lo necesario para poder comprender el curso desde el inicio hasta el final.

# Requisitos

- [Java](http://jdk.java.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)

Si no tienes algunas de estas herramientas instaladas en su máquina, sigue las instrucciones en la documentación oficial de cada herramienta.

# Guía De Conectividad

Enlaza tu conexión de base de datos en tu archivo "application.yml", configura los datos solicitantes
```
  url: conexionstringdetubasededatos
  username: username de mysql
  password: password de mysql
```
Una vez conectada tu base de datos, aplica los scripts en tu editor preferido (Workbench o el que gustes)

## Chequear requisitos

Si instalaste en tu máquina algunas de estas herramientas anteriormente o lo acabas de hacerahora, verifica si todo funciona bien.

- Comprueba si la versión de Java esta correctamente instalada usando el siguiente comando:
   ````
   % java -version
  openjdk 17.0.6 2023-01-17 LTS
  OpenJDK Runtime Environment Microsoft-7209853 (build 17.0.6+10-LTS)
  OpenJDK 64-Bit Server VM Microsoft-7209853 (build 17.0.6+10-LTS, mixed mode, sharing)

   ````
- Comprueba si la versión de Maven en tu máquina es 3.8.0 o superior. Podes ver qué versión de Maven tenes usando el siguiente comando:
   ````
   % mvn --version
   Apache Maven 3.8.3
   Maven home: /usr/share/maven
   ````
- Comprueba si la versión de Docker en tu máquina es 18.09.0 o superior. Puedes verificar la versión de Docker usando el siguiente comando:

   ````
   % docker --version
  Docker version 24.0.2, build cb74dfc
   ````
