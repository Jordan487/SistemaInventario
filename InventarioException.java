package exception;

// Excepción personalizada para manejar errores de inventario
public class InventarioException extends Exception {
    public InventarioException(String mensaje) {
        super(mensaje);
    }
}