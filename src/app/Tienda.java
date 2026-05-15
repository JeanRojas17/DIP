package app;

import services.MetodoPago;

// Esta clase representa un módulo de alto nivel en el principio de inversión de dependencias (DIP).
// Depende de la abstracción MetodoPago, no de implementaciones concretas como PayPal o TarjetaCredito.
// Esto permite que el código sea flexible y extensible, ya que se puede cambiar el método de pago sin modificar esta clase.
public class Tienda {

    private MetodoPago metodoPago;

    public Tienda(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarCompra(double monto) {
        metodoPago.procesarPago(monto);
    }
}