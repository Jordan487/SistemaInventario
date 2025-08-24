package service;

import java.util.ArrayList;
import java.util.List;
import exception.InventarioException;
import io.InventarioArchivo;
import model.Producto;

public class InventarioService {
    private final List<Producto> productos;

    public InventarioService() {
        this.productos = InventarioArchivo.cargarInventario();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        InventarioArchivo.guardarInventario(productos);
        System.out.println("Producto agregado correctamente.");
    }

    public void eliminarProducto(String codigo) throws InventarioException {
        Producto p = buscarProducto(codigo);
        if (p == null) {
            throw new InventarioException("Producto con código " + codigo + " no encontrado.");
        }
        productos.remove(p);
        InventarioArchivo.guardarInventario(productos);
        System.out.println("Producto eliminado correctamente.");
    }

    public void actualizarProducto(String codigo, int nuevaCantidad, double nuevoPrecio) throws InventarioException {
        Producto p = buscarProducto(codigo);
        if (p == null) {
            throw new InventarioException("Producto con código " + codigo + " no encontrado.");
        }
        p.setCantidad(nuevaCantidad);
        p.setPrecio(nuevoPrecio);
        InventarioArchivo.guardarInventario(productos);
        System.out.println("Producto actualizado correctamente.");
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }
}