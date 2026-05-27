package negocio;

import java.util.ArrayList;

public class Carrito {

	private ArrayList<ProductoVendido> productos;
	private double total; //creado para que guarde el TOTAL

	public Carrito() {
		productos = new ArrayList<>();
		total = 0; //cuando se crea el carrito el total de productos es cero
	}

	public void vaciarCarrito() {
		productos.clear();
		total = 0;
	}

	public boolean estaVacio() {
		return productos.isEmpty();
	}

	public void agregarProducto(ProductoVendido pv) {
		productos.add(pv);
		total += calcularSubtotal(pv);
	}

	public boolean productoRepetido(Producto p) {
	    for (ProductoVendido existente : productos) {
	        if (existente.getProducto().getCodigo() == p.getCodigo()) {
	            return true;
	        }
	    }
	    return false;
	}


	private double calcularSubtotal(ProductoVendido pv) {
	    return pv.getProducto().getPrecio() * pv.getCantidadVendida();
	}

	public void listarProductos() {
	   
	    for (ProductoVendido pv : productos) {
	        Producto p = pv.getProducto();
	        double subtotal = calcularSubtotal(pv);

	        System.out.println("Código: " + p.getCodigo() +
	                           ", Descripción: " + p.getDescripcion() +
	                           ", Precio unitario: $" + p.getPrecio() +
	                           ", Cantidad: " + pv.getCantidadVendida() +
	                           ", Subtotal: $" + subtotal);
	    }

	    System.out.println("Total a pagar: $" + total);
	}
	
	public ArrayList<ProductoVendido> getProductos() {
	    return productos;
	}

	
	public double getTotal() {
		return total;
	}
		
}
