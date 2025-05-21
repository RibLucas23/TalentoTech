# Sistema de Gestión de Artículos en Consola (Java)

Este es un sistema simple de gestión de artículos que funciona desde la terminal. Permite crear, listar, modificar y eliminar artículos utilizando una arquitectura por capas.

## 📂 Estructura del proyecto

```bash
src/
│
├── controller/              # Maneja la interacción con el usuario y controla el flujo
│   ├── ArticuloController.java
│   └── PedidoController.java
│
├── service/                 # Contiene la lógica de negocio y manipulación de datos
│   ├── ArticuloService.java
│   └── PedidoService.java
│
├── model/                   # Define las entidades principales del sistema
│   ├── Articulo.java
│   │    └── Bebida.java
│   └── Pedido.java
│
├── util/                    # Utilidades para validaciones y entrada de datos
│   └── Helpers.java
│
└── Main.java                # Entrada principal y menú de la aplicación
```

## 🧠 ¿Por qué elegí esta arquitectura?

A diferencia de hacer todo en 1 o 2 archivos (Main.java y Articulo.java), este diseño sigue el principio de responsabilidad única (Single Responsibility Principle) y mejora la escalabilidad, mantenimiento y legibilidad del código.

Me pareció mejor aplicar esta metodología para que sea más fácil escalar y modificar el proyecto a medida que avanzan las clases. También quise mantener desde el principio algunas buenas prácticas que se suelen usar en el día a día en el mundo laboral.

## ⚙️ ¿Cómo funciona la aplicación?

Al ejecutar Main.java, se lanza un menú de consola donde el usuario puede:

-  Crear un artículo: Ingresar ID único, nombre, precio y stock con validaciones. Si es una bebida, también se solicita vencimiento y volumen.

-  Listar artículos: Muestra todos los artículos registrados.

-  Modificar un artículo: Permite editar nombre, precio y stock de un artículo existente.

-  Eliminar un artículo: Solicita confirmación antes de borrar el artículo.

-  Crear un pedido: Permite seleccionar artículos, definir cantidades y registrar un nuevo pedido.

-  Listar pedidos: Muestra todos los pedidos realizados con su detalle.

-  Salir: Finaliza el programa.

## 📌 Tecnologías usadas

-  Lenguaje: Java

-  Entrada de usuario: Scanner

-  Arquitectura: MVC simplificado por capas (Model, Controller, Service, Util)

## ✍️ Autor

Lucas Ribeiro da Silva
