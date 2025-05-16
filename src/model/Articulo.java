package src.model;

public class Articulo {
   private int id;
   private String nombre;
   private double precio;
   private int stock;

   public Articulo(int id, String nombre, double precio, int stock) {
      this.id = id;
      this.nombre = nombre;
      this.precio = precio;
      this.stock = stock;
   }

   public int getId() {
      return id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public double getPrecio() {
      return precio;
   }

   public void setPrecio(double precio) {
      this.precio = precio;
   }

   public int getStock() {
      return stock;
   }

   public void setStock(int stock) {
      this.stock = stock;
   }

   public void mostrar() {
      System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + stock);
   }
}
