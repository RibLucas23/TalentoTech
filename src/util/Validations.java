package src.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import src.model.Articulo;

public class Validations {
   private static final Scanner sc = new Scanner(System.in);

   public static int leerStock() {
      while (true) {
         try {
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            sc.nextLine();
            if (stock < 0) {
               System.out.println("El stock debe ser un número entero positivo.");
            } else {
               return stock;
            }
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
            sc.nextLine();
         }
      }
   }

   public static int leerId() {
      while (true) {
         try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            if (id <= 0) {
               System.out.println("El ID debe ser un número entero positivo.");
            } else {
               return id;
            }
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
            sc.nextLine();
         }
      }
   }

   public static int leerIdUnico(List<Articulo> lista) {
      while (true) {
         try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
               System.out.println("El ID debe ser un número entero positivo.");
               continue;
            }

            for (Articulo a : lista) {
               if (a.getId() == id) {
                  System.out.println("Ya existe un artículo con ese ID. Intente con otro.");
                  return leerIdUnico(lista);
               }
            }

            return id;
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
            sc.nextLine();
         }
      }
   }

   public static String leerNombre() {
      while (true) {
         System.out.print("Nombre: ");
         String nombre = sc.nextLine().trim();
         if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
         } else {
            return nombre;
         }
      }
   }

   public static double leerPrecio() {
      while (true) {
         try {
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
            sc.nextLine();
            if (precio < 0) {
               System.out.println("El precio debe ser un número positivo.");
            } else {
               return precio;
            }
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar un número decimal.");
            sc.nextLine();
         }
      }
   }

   public static boolean confirmar(String mensaje) {
      while (true) {
         System.out.print(mensaje);
         String r = sc.nextLine().trim().toLowerCase();
         if (r.equals("s"))
            return true;
         if (r.equals("n"))
            return false;
         System.out.println("Entrada inválida. Use 's' o 'n'.");
      }
   }

   public static Scanner getScanner() {
      return sc;
   }
}
