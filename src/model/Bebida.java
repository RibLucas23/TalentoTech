package src.model;

public class Bebida extends Articulo {
   private String vencimiento;
   private double volumenLitros;

   public Bebida(int id, String nombre, double precio, int stock, String vencimiento, double volumenLitros) {
      super(id, nombre, precio, stock);
      this.vencimiento = vencimiento;
      this.volumenLitros = volumenLitros;

   }

   public String getVencimiento() {
      return vencimiento;
   }

   public void setVencimiento(String vencimiento) {
      this.vencimiento = vencimiento;
   }

   public double getVolumenLitros() {
      return volumenLitros;
   }

   public void setVolumenLitros(double volumen) {
      this.volumenLitros = volumen;
   }

   @Override
   public void mostrar() {
      int id = super.getId();
      String nombre = super.getNombre();
      double precio = super.getPrecio();
      int stock = super.getStock();
      System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + stock
            + " | Bebida | Vencimiento: " + vencimiento + " | Volumen: " + volumenLitros + "Lt");
   }
}
