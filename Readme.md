# Readme

## Selección de nube
Se utilizó AWS por ser una nube ampliamente utilizada, de este se utilizó el servicio de EC2 para 
acceder a un servidor linux que permitiera ejecutar el servicio de manera simple.
Para escalar este servicio se hace necesario crear nuevos puertos y agregar un balanceador de carga 
que le permita intercambiar entre los diferentes servicios.

## Estrategia de Monitoreo

Este proyecto utiliza la libreria de [Micrometer](https://micrometer.io/) la cual ofrece conexiones 
con los siguientes proveedores:
* Datadog
* Dynatrace
* Prometheus
* Entre otros...

## Patrones utilizados

El proyecto esta basado en la arquitectura limpia propuesta por Robert C. Martin con las siguientes capas
de afuera hacia adentro
* Frameworks and Drivers
* Interface Adapters
* Application Business (Use case)
* Enterprise Business (domain)

Entre los patrones de diseño utilizados están:
* Adapters
* Factory
* Builders

## Arquitectura

![image](./architecture.png)

## Cómo ejecutar el proyecto
Este proyecto esta basado en spring-boot para su ejecución
`mvn spring-boot:run`

## JMeter
Realizando una ejecución de este proyecto con las características mínimas en un servidor linux tiene
una capacidad de 25 peticiones por minuto. Se incluye el archivo "Thread Group.jmx"

## Postman
Se incluyen las diferentes peticiones en la carpeta de "postman" con los ejemplos de las peticiones