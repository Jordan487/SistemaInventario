package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class InventarioArchivo {
    private static final String NOMBRE_ARCHIVO = "inventario.txt";

    // Guardar lista de productos en archivo
    public static void guardarInventario(List<Producto> productos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(productos);
            System.out.println("Inventario guardado en archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    // Cargar lista de productos desde archivo
    @SuppressWarnings("unchecked")
    public static List<Producto> cargarInventario() {
        List<Producto> productos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            productos = (List<Producto>) ois.readObject();
            System.out.println("Inventario cargado desde archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
        }
        return productos;
    }
}