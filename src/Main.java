package src;

import src.controller.ArticuloController;
import src.controller.PedidoController;
import src.service.ArticuloService;
import src.service.PedidoService;
import src.util.Validations;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = Validations.getScanner();

      // Instanciar servicios
      ArticuloService articuloService = new ArticuloService();
      PedidoService pedidoService = new PedidoService();

      // Instanciar controladores con los servicios
      ArticuloController articuloController = new ArticuloController(articuloService);
      PedidoController pedidoController = new PedidoController(pedidoService, articuloService);

      int opcion = 0;
      while (opcion != 7) {
         System.out.println("\n--- Menú Principal ---");
         System.out.println("1. Crear artículo");
         System.out.println("2. Listar artículos");
         System.out.println("3. Modificar artículo");
         System.out.println("4. Eliminar artículo");
         System.out.println("5. Crear pedido");
         System.out.println("6. Listar pedidos");
         System.out.println("7. Salir");
         System.out.print("Ingrese una opción: ");

         if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
               case 1 -> articuloController.crearArticulo();
               case 2 -> articuloController.listarArticulos();
               case 3 -> articuloController.modificarArticulo();
               case 4 -> articuloController.eliminarArticulo();
               case 5 -> pedidoController.crearPedido();
               case 6 -> pedidoController.listarPedidos();
               case 7 -> System.out.println("Saliendo...");
               default -> System.out.println("Opción inválida.");
            }
         } else {
            System.out.println("Entrada inválida.");
            sc.nextLine();
         }
      }
   }
}
