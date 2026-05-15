<div align="center">

# **Buenas prácticas, principios SOLID y patrones**

### **Integrantes**

Jean Paul Rojas Herera

Daniel Sundar Bonilla Bolaños

Michael Dowglas Lenis Chaguendo

</div>

## Tabla de Contenidos

- [Dependency Inversion Principle (DIP) - Sistema de Pagos](#dependency-inversion-principle-dip---sistema-de-pagos)
- [¿Qué es el DIP?](#qué-es-el-dip)
- [Aplicación en el Código](#aplicación-en-el-código)
- [Diagrama de Dependencias](#diagrama-de-dependencias)
- [Beneficios del DIP en este Ejemplo](#beneficios-del-dip-en-este-ejemplo)
- [Escalabilidad con Criptomoneda](#escalabilidad-con-criptomoneda)
- [Estructura del ejercicio](#estructura-del-ejercicio)
- [Instrucciones de uso](#instrucciones-de-uso)

## Dependency Inversion Principle (DIP) - Sistema de Pagos

Este repositorio contiene la demostración de un ejemplo de uso del Principio de Inversión de Dependencias (DIP) usando un sistema de pagos en Java.

## ¿Qué es el DIP?

El Principio de Inversión de Dependencias (DIP) es uno de los cinco principios SOLID de la programación orientada a objetos. Establece que:

- Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones.
- Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.

Esto promueve el desacoplamiento, la flexibilidad y la facilidad de mantenimiento del código.

## Aplicación en el Código

En este ejemplo:

- **Abstracción**: La interfaz `MetodoPago` define el contrato para procesar pagos.
- **Módulo de alto nivel**: La clase `Tienda` depende de la abstracción `MetodoPago`, no de implementaciones concretas.
- **Módulos de bajo nivel**: Las clases `PayPal`, `TarjetaCredito` y `Criptomoneda` implementan la interfaz y dependen de la abstracción.
- **Inyección de dependencias**: En `Main.java`, se inyectan las dependencias concretas en `Tienda`, permitiendo cambiar el método de pago sin modificar el código de `Tienda`.

## Diagrama de Dependencias

```
Tienda (alto nivel) --> MetodoPago (abstracción)
                              ^
                              |
          +-------------------+-------------------------+
          |                   |                         |
   PayPal (bajo nivel)  TarjetaCredito (bajo nivel)  Criptomoneda (bajo nivel)
```

## Beneficios del DIP en este Ejemplo

- **Flexibilidad**: Se pueden agregar nuevos métodos de pago (ej. Bitcoin, Transferencia) sin modificar `Tienda`.
- **Mantenibilidad**: Cambios en las implementaciones concretas no afectan el código de alto nivel.
- **Testabilidad**: Facilita las pruebas unitarias al permitir mockear las dependencias.

## Escalabilidad con `Criptomoneda`

La clase `Criptomoneda` es un ejemplo de cómo el proyecto puede escalar fácilmente con nuevos métodos de pago.
Al añadir una nueva implementación de `MetodoPago`, no es necesario cambiar la clase `Tienda` ni la lógica existente; basta con instanciar y pasar la nueva dependencia.
Este enfoque reduce el acoplamiento y soporta la expansión futura del sistema con otros métodos de pago sin reescribir el módulo de alto nivel.

## Estructura del ejercicio

- `src/`:
  - `Main.java`: Clase principal que demuestra la inyección de dependencias.
  - `services/`:
    - `MetodoPago.java`: Interfaz que define el método de pago.
    - `PayPal.java`: Implementación concreta para pagos con PayPal.
    - `TarjetaCredito.java`: Implementación concreta para pagos con tarjeta de crédito.
    - `Criptomoneda.java`: Implementación concreta para pagos con criptomonedas.
  - `app/`:
    - `Tienda.java`: Clase que representa una tienda y procesa compras usando un método de pago.
- `README.md`: Documentación

## Instrucciones de uso

1. Clona el repositorio.
2. Compila y ejecuta el archivo `Main.java` para probar el ejercicio.

### Salida esperada:

```
Pagando $500000.0 con tarjeta de crédito.
Pagando $150000.0 con PayPal.
Pagando $50000.0 con criptomonedas.
```