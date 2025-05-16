
package src.service;

import java.util.ArrayList;
import java.util.List;
import src.model.Articulo;

public class ArticuloService {
   private final List<Articulo> lista = new ArrayList<>();

   public List<Articulo> getArticulos() {
      return lista;
   }

   public void agregarArticulo(Articulo articulo) {
      lista.add(articulo);
   }

   public Articulo buscarArticuloPorId(int id) {
      for (Articulo a : lista) {
         if (a.getId() == id)
            return a;
      }
      return null;
   }

   public boolean eliminarArticulo(Articulo articulo) {
      return lista.remove(articulo);
   }
}
