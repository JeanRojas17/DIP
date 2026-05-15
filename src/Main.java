import app.Tienda;
import services.PayPal;
import services.TarjetaCredito;
import services.MetodoPago;

// Se crean instancias concretas de métodos de pago y se inyectan en la clase Tienda.
// Esto permite que Tienda dependa de la abstracción MetodoPago, no de las implementaciones concretas.
public class Main {

    public static void main(String[] args) {

        // Pago con tarjeta
        MetodoPago tarjeta = new TarjetaCredito();
        Tienda tienda1 = new Tienda(tarjeta);
        tienda1.realizarCompra(500000);
        
        // Pago con PayPal
        MetodoPago paypal = new PayPal();
        Tienda tienda2 = new Tienda(paypal);
        tienda2.realizarCompra(150000);
    }
}