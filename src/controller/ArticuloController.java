package src.controller;

import src.model.Articulo;
import src.service.ArticuloService;
import src.util.Validations;

public class ArticuloController {
   private final ArticuloService service;

   public ArticuloController(ArticuloService service) {
      this.service = service;
   }

   public void crearArticulo() {
      int id = Validations.leerIdUnico(service.getArticulos());
      String nombre = Validations.leerNombre();
      double precio = Validations.leerPrecio();
      int stock = Validations.leerStock();
      service.agregarArticulo(new Articulo(id, nombre, precio, stock));
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
      int id = Validations.leerId();
      Articulo articulo = service.buscarArticuloPorId(id);
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

   public void eliminarArticulo() {
      int id = Validations.leerId();
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
