package services;

// Esta interfaz define la abstracción para métodos de pago según el principio de inversión de dependencias (DIP).
// Los módulos de alto nivel dependen de esta abstracción,
// permitiendo que las implementaciones concretas sean intercambiables sin afectar el código de alto nivel.
public interface MetodoPago {
    void procesarPago(double monto);
}