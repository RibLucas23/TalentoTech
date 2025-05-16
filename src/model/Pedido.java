package src.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
   private static int contadorId = 1;
   private int id;
   private List<Articulo> articulos;

   public Pedido() {
      this.id = contadorId++;
      this.articulos = new ArrayList<>();
   }

   public int getId() {
      return id;
   }

   public List<Articulo> getArticulos() {
      return articulos;
   }

   public void agregarArticulo(Articulo articulo) {
      articulos.add(articulo);
   }

   public boolean quitarArticulo(int idArticulo) {
      return articulos.removeIf(a -> a.getId() == idArticulo);
   }

   public double getPrecioTotal() {
      return articulos.stream().mapToDouble(Articulo::getPrecio).sum();
   }

   public void mostrar() {
      System.out.println("Pedido #" + id);
      if (articulos.isEmpty()) {
         System.out.println("Sin artículos en el pedido.");
      } else {
         for (Articulo a : articulos) {
            a.mostrar();
         }
         System.out.printf("Total del pedido: $%.2f\n", getPrecioTotal());
      }
      System.out.println("------------------------");
   }
}
