package negocio;
import java.util.ArrayList;
public class Catalogo {

	 // productos es una lista (específicamente una ArrayList) que puede guardar
								// muchos objetos del tipo Producto.

	private ArrayList<Producto> productos;

	// CONSTRUCTOR:
	public Catalogo() {
			productos = new ArrayList<>();
		}

	public void agregarProducto(Producto p) {
	    Producto encontrado = buscarProducto(p.getCodigo());
	    if (encontrado == null) {
	        productos.add(p);
	        System.out.println("Producto agregado correctamente al catálogo.");
	    } else {
	        System.out.println("El producto ya se encuentra en el catálogo.");
	    }
	}


	public void eliminarProducto(int codigo) { // ELIMNAR PRODUCTO
		Producto encontrado = buscarProducto(codigo); // Busca el producto con ese código usando buscarProducto.
		if (encontrado != null) { // Si lo encuentra (encontrado != null), lo borra de la lista.
			productos.remove(encontrado);
		} else {
			System.out.println("El producto no se elimina ya que no fue encontrado"); // Si NO lo encuentra muestra este
																						// mensaje
		}
	}

	public Producto buscarProducto(int codigo) {
		for (Producto p : productos) { // Recorre la lista de productos uno por uno con un for.
			if (p.getCodigo() == codigo) { // Compara el código de cada producto (p.getCodigo()) con el que buscamos.
				return p; // Si lo encuentra, lo devuelve.
			}
		}
		return null; // Si no lo encuentra, devuelve null.
	}

	public void listarProductos() {
		for (Producto p : productos) { // Para cada producto p que esté dentro de la lista productos, hacé lo que está
										// entre llaves { ... }
										// Es una estructura de bucle que sirve para recorrer todos los elementos que
										// hay en una lista (ArrayList) de forma automática y sencilla.
			System.out.println("Codigo:" + p.getCodigo()); // p.getCodigo() → obtiene el código del producto actual.
			System.out.println("Descripcion:" + p.getDescripcion());
			System.out.println("Precio: $ " + p.getPrecio());
			System.out.println("Stock:" + p.getStock());
			System.out.println("Stock minimo: " + p.getStockMin());
			System.out.println();

		}
	}
	//Metodo para mostrar productos que esten en stock min
	public void listarProductosEnStockMinimo(){
		System.out.println("Productos con stock minimo o menor: ");
		boolean hayMin = false;

		for (Producto p: productos){
			if (p.esStockMin()){
				System.out.println("Codigo: " + p.getCodigo() + " | " + p.getDescripcion() 
				+ " | Stock actual: " + p.getStock() + " | Stock minimo: " + p.getStockMin());
				hayMin = true;
			}
		}
		if (!hayMin){
			System.out.println("Todos los productos estan por encima del stock minimo.");
		}
	}
	
	public ArrayList<Producto> getProductos() {
	    return productos;
	}

	
}

