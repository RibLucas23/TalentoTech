package src.service;

import src.model.Articulo;
import src.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
   private final List<Pedido> pedidos = new ArrayList<>();

   public Pedido crearPedido() {
      Pedido nuevo = new Pedido();
      pedidos.add(nuevo);
      return nuevo;
   }

   public List<Pedido> listarPedidos() {
      return pedidos;
   }

   public Pedido buscarPedidoPorId(int id) {
      for (Pedido p : pedidos) {
         if (p.getId() == id)
            return p;
      }
      return null;
   }

   public void agregarArticuloAPedido(Pedido pedido, Articulo articulo) {
      pedido.agregarArticulo(articulo);
   }

   public void quitarArticuloDePedido(Pedido pedido, int idArticulo) {
      pedido.quitarArticulo(idArticulo);
   }
}
