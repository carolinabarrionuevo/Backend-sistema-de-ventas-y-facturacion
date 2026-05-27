package negocio;

public class Debito extends Pago {
	private int nroTarjeta;

	public Debito(double monto, String metodoPago, int nroTarjeta) {
		super(monto, metodoPago);
		this.nroTarjeta = nroTarjeta;
	}

	@Override
	public void calcularMontoTotal() {
		// Sin recargo ni descuento
	}

	@Override
	public void registrarPago() {
		System.out.println("Pago realizado con DÉBITO.");
		System.out.println("Número de tarjeta: " + nroTarjeta);
		System.out.printf("Total pagado: $%.2f\n", getMonto());
	}
}
