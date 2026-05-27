package negocio;

import java.util.ArrayList;

public class Venta {

    // encapsulamiento
    private ArrayList<ProductoVendido> productosVendidos;
    private Pago pago;

    // cconstructor
    public Venta(ArrayList<ProductoVendido> productosVendidos, Pago pago) {
        this.productosVendidos = productosVendidos;
        this.pago = pago;
    }

    // hace la suma de productos vendidos, para saber cuánto debería ser el total de la venta
    public float calcularTotalVenta() {     
    	float total = 0;
        for (ProductoVendido productoVendido : productosVendidos) {
			Producto producto = productoVendido.getProducto();
            total += producto.getPrecio()*productoVendido.getCantidadVendida();
        }
        return total;
    }

    // Método que obtiene el total según el pago
    public double obtenerTotal() {
        return pago.getMonto();
    }

    // detalle de la venta
    public void mostrarDetalle() {
        System.out.println("Detalle de Venta");
        for (ProductoVendido productoVendido : productosVendidos) {
            Producto producto = productoVendido.getProducto();
            System.out.println("Producto: " + producto.getDescripcion() +
                               "Cantidad: " + productoVendido.getCantidadVendida() +
                               "Precio: $" + producto.getPrecio());
        }
        System.out.println("Total calculado: $" + calcularTotalVenta());
        System.out.println("Total pagado (según pago): $" + obtenerTotal());
        System.out.println("Método de pago: " + pago.getMetodoPago());
        System.out.println("Estado del pago: " + pago.getEstadoPago());
    }

    public ArrayList<ProductoVendido> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(ArrayList<ProductoVendido> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
    //esta parte esta hecha con chatgpt 
    // almacena el objeto que maneja la información del pago (monto, método, estado, etc.). 
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}