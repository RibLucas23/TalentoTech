package src.controller;

import src.model.Articulo;
import src.service.ArticuloService;
import src.util.Validations;
import java.util.Scanner;

public class ArticuloController {
   private final ArticuloService service = new ArticuloService();

   public void iniciar() {
      Scanner sc = Validations.getScanner();
      int opcion = 0;

      while (opcion != 5) {
         System.out.println("\n--- Menú de Gestión de Artículos ---");
         System.out.println("1. Crear artículo");
         System.out.println("2. Listar artículos");
         System.out.println("3. Modificar artículo");
         System.out.println("4. Eliminar artículo");
         System.out.println("5. Salir");
         System.out.print("Ingrese una opción: ");

         if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
               case 1 -> crearArticulo();
               case 2 -> listarArticulos();
               case 3 -> modificarArticulo();
               case 4 -> eliminarArticulo();
               case 5 -> System.out.println("Saliendo...");
               default -> System.out.println("Opción inválida.");
            }
         } else {
            System.out.println("Entrada inválida.");
            sc.nextLine();
         }
      }
   }

   private void crearArticulo() {
      int id = Validations.leerIdUnico(service.getArticulos());
      String nombre = Validations.leerNombre();
      double precio = Validations.leerPrecio();
      int stock = Validations.leerStock();
      service.agregarArticulo(new Articulo(id, nombre, precio, stock));
      System.out.println("Artículo agregado.");
   }

   private void listarArticulos() {
      if (service.getArticulos().isEmpty()) {
         System.out.println("No hay artículos cargados.");
      } else {
         for (Articulo a : service.getArticulos()) {
            a.mostrar();
         }
      }
   }

   private void modificarArticulo() {
      int id = Validations.leerId();
      Articulo articulo = service.buscarPorId(id);
      if (articulo == null) {
         System.out.println("Artículo no encontrado.");
         return;
      }
      String nombre = Validations.leerNombre();
      double precio = Validations.leerPrecio();
      int stock = Validations.leerStock();
      articulo.setNombre(nombre);
      articulo.setPrecio(precio);
      articulo.setStock(stock);
      System.out.println("Artículo modificado.");
   }

   private void eliminarArticulo() {
      int id = Validations.leerId();
      Articulo articulo = service.buscarPorId(id);
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
