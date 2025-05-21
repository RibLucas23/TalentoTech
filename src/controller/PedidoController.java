package src.controller;

import src.model.Articulo;
import src.model.Pedido;
import src.service.ArticuloService;
import src.service.PedidoService;
import src.util.Validations;

public class PedidoController {
   private final PedidoService pedidoService;
   private final ArticuloService articuloService;

   public PedidoController(PedidoService pedidoService, ArticuloService articuloService) {
      this.pedidoService = pedidoService;
      this.articuloService = articuloService;
   }

   public void crearPedido() {
      Pedido pedido = pedidoService.crearPedido();
      System.out.println("Pedido #" + pedido.getId() + " creado.");

      boolean seguir = true;
      while (seguir) {
         articuloService.getArticulos();
         System.out.println("Ingrese el ID del artículo a agregar al pedido:");
         int idArticulo = Validations.leerEntero("ID: ", 0, null, "El ID debe ser un número entero positivo.");
         Articulo articulo = articuloService.buscarArticuloPorId(idArticulo);
         if (articulo != null) {
            pedidoService.agregarArticuloAPedido(pedido, articulo);
            System.out.println("Artículo agregado al pedido.");
            pedido.mostrar();
         } else {
            System.out.println("Artículo no encontrado.");
         }

         seguir = Validations.confirmar("¿Desea agregar otro artículo? (s/n): ");
      }
   }

   public void listarPedidos() {
      for (Pedido p : pedidoService.listarPedidos()) {
         p.mostrar();
         System.out.println("--------------------");
      }
   }
}