package app;

import java.util.Scanner;
import exception.InventarioException;
import model.Producto;
import service.InventarioService;

public class Main {
    public static void main(String[] args) {
        InventarioService inventario = new InventarioService();
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("\n=== SISTEMA DE INVENTARIO ===");
                System.out.println("1. Agregar producto");
                System.out.println("2. Eliminar producto");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Listar productos");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                
                try {
                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Código: ");
                            String codigo = sc.nextLine();
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Cantidad: ");
                            int cantidad = sc.nextInt();
                            System.out.print("Precio: ");
                            double precio = sc.nextDouble();
                            sc.nextLine();
                            
                            Producto nuevo = new Producto(codigo, nombre, cantidad, precio);
                            inventario.agregarProducto(nuevo);
                        }
                        case 2 -> {
                            System.out.print("Código del producto a eliminar: ");
                            String codigo = sc.nextLine();
                            inventario.eliminarProducto(codigo);
                        }
                        case 3 -> {
                            System.out.print("Código del producto a actualizar: ");
                            String codigo = sc.nextLine();
                            System.out.print("Nueva cantidad: ");
                            int cantidad = sc.nextInt();
                            System.out.print("Nuevo precio: ");
                            double precio = sc.nextDouble();
                            sc.nextLine();
                            
                            inventario.actualizarProducto(codigo, cantidad, precio);
                        }
                        case 4 -> {
                            System.out.println("\n--- Inventario ---");
                            for (Producto p : inventario.listarProductos()) {
                                System.out.println(p);
                            }
                        }
                        case 0 -> System.out.println("Saliendo del sistema...");
                        default -> System.out.println("Opción no válida.");
                    }
                } catch (InventarioException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                
            } while (opcion != 0);
        }
    }
}