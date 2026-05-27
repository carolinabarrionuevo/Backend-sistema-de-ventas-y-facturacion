package negocio;

/*
1. Cuotas válidas: 2, 3 o 6
2. 2 cuotas: 6% recargo
3. 3 cuotas: 12% recargo
4. 6 cuotas: 20% recargo
*/

public class Credito extends Pago {
	private int nroTarjeta;
	private int nroCuotas;

	public Credito(double monto, String metodoPago, int nroTarjeta, int nroCuotas) {
		super(monto, metodoPago);
		this.nroTarjeta = nroTarjeta;
		this.nroCuotas = nroCuotas;
	}

	@Override
	public void calcularMontoTotal() {
		if (nroCuotas == 2) {
			setMonto(getMonto() + getMonto() * 0.06);
		} else if (nroCuotas == 3) {
			setMonto(getMonto() + getMonto() * 0.12);
		} else if (nroCuotas == 6) {
			setMonto(getMonto() + getMonto() * 0.20);
		}
	}

	@Override
	public void registrarPago() {
		System.out.println("Pago realizado con CRÉDITO.");
		System.out.println("Número de tarjeta: " + nroTarjeta);
		System.out.println("Cantidad de cuotas: " + nroCuotas);
		System.out.printf("Total pagado con recargo: $%.2f\n", getMonto());
	}
}
