package negocio;

public class Producto {
	private int codigo;
	private String descripcion;
	private double precio;
	private int cantStock;
	private int stockMin;

	// CONSTRUCTOR:
	public Producto(int codigo, String descripcion, double precio, int cantStock, int stockMin) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantStock = cantStock;
		this.stockMin = stockMin;

	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getCodigo() { // Getter
		return codigo;
	}

	public double getPrecio() { // Getter
		return precio;
	}

	public int getStock() { // Getter. El método getStock() devuelve lo que hay en cantStock
		return cantStock;
	}

	public int getStockMin() { // Getter
		return stockMin;
	}

	public boolean disminuirStock(int cantidad) {
		if (cantidad <= cantStock) { // validar para que el stock nunca sea menor al disponible. Esto evita que el
										// stock quede negativo.
			this.cantStock = cantStock - cantidad; // Resta cantidad a cantStock y guardá el resultado en cantStock
			return true;
		}
		return false; // No se descuenta nada del stock y se devuelve false,
						// indicando que no hay suficiente stock disponible.

	}

	public boolean esStockMin() {
		return cantStock <= stockMin; // Es cantStock menor o igual que stockMin?"

		// Esto devuelve true o false, o sea, un booleano.

		// Ejemplo:

		// Si cantStock = 5 y stockMin = 10 → devuelve true

		// Si cantStock = 12 y stockMin = 10 → devuelve false
	}

}
