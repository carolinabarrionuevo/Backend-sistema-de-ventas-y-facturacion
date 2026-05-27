package negocio;

public class ProductoVendido {
	private Producto producto;
    private int cantidadVendida;

    // constructor
    public ProductoVendido(Producto producto, int cantidadVendida) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
    }

    // getter de cantidadVendida
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    // getter del producto
    public Producto getProducto() {
        return producto;
    }
}
