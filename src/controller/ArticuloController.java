package src.controller;

import src.model.Articulo;
import src.model.Bebida;
import src.service.ArticuloService;
import src.util.Validations;

public class ArticuloController {
   private final ArticuloService service;

   public ArticuloController(ArticuloService service) {
      this.service = service;
   }

   public void crearArticulo() {
      // Primero pregunto que tipo de articulo
      System.out.println("Seleccione el tipo de artículo a crear:");
      System.out.println("1. Artículo común");
      System.out.println("2. Bebida");
      int tipo = Validations.leerOpcion(1, 2);

      // recolecto los datos genericos de Articulo
      int id = Validations.leerIdUnico(service.getArticulos());
      String nombre = Validations.leerTexto("Nombre: ", "El nombre no puede estar vacío.");
      double precio = Validations.leerDouble("Precio: ", "El precio debe ser un número positivo.");
      int stock = Validations.leerEntero("Stock: ", 0, null, "El stock debe ser un número entero positivo.");

      // Depende de si es bebida o no, creo el Articulo o recolecto los datos
      // faltantes
      if (tipo == 1) {
         service.agregarArticulo(new Articulo(id, nombre, precio, stock));
      } else {
         String vencimiento = Validations.leerTexto("Ingrese fecha de vencimiento (Dia/Mes/Año):",
               "La fecha no puede estar vacia");
         double volumen = Validations.leerDouble("Ingrese volumen en litros:",
               "El volumen debe ser un número entero positivo.");
         service.agregarArticulo(new Bebida(id, nombre, precio, stock, vencimiento, volumen));
      }
      System.out.println("Artículo agregado.");
   }

   public void listarArticulos() {
      if (service.getArticulos().isEmpty()) {
         System.out.println("No hay artículos cargados.");
      } else {
         for (Articulo a : service.getArticulos()) {
            a.mostrar();
         }
      }
   }

   public void modificarArticulo() {
      int id = Validations.leerEntero("ID: ", 0, null, "El ID debe ser un número entero positivo.");
      Articulo articulo = service.buscarArticuloPorId(id);
      if (articulo == null) {
         System.out.println("Artículo no encontrado.");
         return;
      }
      String nombre = Validations.leerTexto("Nombre: ", "El nombre no puede estar vacío.");
      double precio = Validations.leerEntero("Stock: ", 0, null, "El stock debe ser un número entero positivo.");
      int stock = Validations.leerEntero("Stock: ", 0, null, "El stock debe ser un número entero positivo.");

      articulo.setNombre(nombre);
      articulo.setPrecio(precio);
      articulo.setStock(stock);
      System.out.println("Artículo modificado.");
   }

   public void eliminarArticulo() {
      int id = Validations.leerEntero("ID: ", 0, null, "El ID debe ser un número entero positivo.");

      Articulo articulo = service.buscarArticuloPorId(id);
      if (articulo == null) {
         System.out.println("Artículo no encontrado.");
         return;
      }
      articulo.mostrar();
      System.out.print("¿Está seguro que desea eliminar este artículo? (s/n): ");
      String confirmacion = Validations.getScanner().nextLine().trim().toLowerCase();
      if (confirmacion.equals("s")) {
         service.eliminarArticulo(articulo);
         System.out.println("Artículo eliminado.");
      } else {
         System.out.println("Eliminación cancelada.");
      }
   }
}
