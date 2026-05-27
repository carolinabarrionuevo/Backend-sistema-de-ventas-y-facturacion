package negocio;

//Si el usuario es un empleado, la clase es como un "cajero" va a definir todo
public abstract class Pago {
	private double monto;
	private String metodoPago;
	private String estadoPago; //aprobado/cancelado/pendiente

	public Pago(double monto, String metodoPago) {
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.estadoPago = "PENDIENTE";
	}

	public void registrarPago() {
		cambiarEstado("APROBADO");
		System.out.println("Pago aprobado. Monto: $" + monto +" Metodo de pago: " + metodoPago);
	}

	public void cancelarPago() {
		cambiarEstado("CANCELADO");  
	}

	public void cambiarEstado(String nuevoEstado) {
		if(nuevoEstado.equals("APROBADO")||nuevoEstado.equals("CANCELADO")||nuevoEstado.equals("PENDIENTE")) {
		estadoPago = nuevoEstado;}
		else {System.out.println("Error. Estado de pago invalido");}
	}

	public abstract void calcularMontoTotal();

	public double getMonto() {
		return monto;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setMonto(double d) {
		this.monto = d;
	}
	
	
}	

