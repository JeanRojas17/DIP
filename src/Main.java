import app.Tienda;
import services.PayPal;
import services.TarjetaCredito;
import services.Criptomoneda;
import services.MetodoPago;

// Se crean instancias concretas de métodos de pago y se inyectan en la clase Tienda.
// Esto permite que Tienda dependa de la abstracción MetodoPago, no de las implementaciones concretas.
public class Main {

    public static void main(String[] args) {

        // Pago con tarjeta
        MetodoPago tarjeta = new TarjetaCredito();
        Tienda pago1 = new Tienda(tarjeta);
        pago1.realizarCompra(500000);
        
        // Pago con PayPal
        MetodoPago paypal = new PayPal();
        Tienda pago2 = new Tienda(paypal);
        pago2.realizarCompra(150000);

        // Pago con criptomonedas
        MetodoPago criptomoneda = new Criptomoneda();
        Tienda pago3 = new Tienda(criptomoneda);
        pago3.realizarCompra(50000);
    }
}