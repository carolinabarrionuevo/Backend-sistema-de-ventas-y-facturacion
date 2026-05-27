package negocio;

public class Efectivo extends Pago {

	public Efectivo(double monto, String metodoPago) {
		super(monto, metodoPago);
	}

	@Override
	public void calcularMontoTotal() {
		setMonto(getMonto() - getMonto() * 0.10); // 10% de descuento
	}

	@Override
	public void registrarPago() {
		System.out.println("Pago realizado en EFECTIVO.");
		System.out.printf("Total pagado con descuento: $%.2f\n", getMonto());
	}
}
