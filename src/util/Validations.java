package src.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import src.model.Articulo;

public class Validations {
   private static final Scanner sc = new Scanner(System.in);

   public static int leerEntero(String mensaje, int min, Integer max, String error) {
      while (true) {
         System.out.print(mensaje);
         try {
            int valor = sc.nextInt();
            sc.nextLine();
            if (valor < min || (max != null && valor > max)) {
               System.out.println(error);
            } else {
               return valor;
            }
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
            sc.nextLine();
         }
      }
   }

   public static double leerDouble(String mensaje, String error) {
      while (true) {
         System.out.print(mensaje);
         try {
            double valor = sc.nextDouble();
            sc.nextLine();
            if (valor < 0) {
               System.out.println(error);
            } else {
               return valor;
            }
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar un número decimal.");
            sc.nextLine();
         }
      }
   }

   public static String leerTexto(String mensaje, String error) {
      while (true) {
         System.out.print(mensaje);
         String texto = sc.nextLine().trim();
         if (texto.isEmpty()) {
            System.out.println(error);
         } else {
            return texto;
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

   public static int leerOpcion(int min, int max) {
      return leerEntero("Ingrese opción (" + min + "-" + max + "): ", min, max, "Opción inválida.");
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
