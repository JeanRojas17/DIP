package services;

// Esta clase es una implementación concreta de la interfaz MetodoPago.
// Esto permite que el módulo de alto nivel (Tienda) no dependa directamente de esta implementación.
public class TarjetaCredito implements MetodoPago {
    
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pagando $" +monto+ " con tarjeta de crédito.");
    }
}