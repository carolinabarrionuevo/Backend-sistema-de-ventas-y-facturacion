package ejecucion;

import java.util.Scanner;
import negocio.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();
        Carrito carrito = new Carrito();

        // Cargar productos al catálogo
        System.out.println("/CARGA DE PRODUCTOS AL CATÁLOGO/");
        int codigo;
        do {
            System.out.print("Ingrese código del producto (0 para finalizar): ");
            codigo = sc.nextInt();
            sc.nextLine();

            if (codigo != 0) {
                System.out.print("Ingrese descripción: ");
                String descripcion = sc.nextLine();

                System.out.print("Ingrese precio unitario: ");
                float precio = sc.nextFloat();
                sc.nextLine();

                System.out.print("Ingrese stock actual: ");
                int stock = sc.nextInt();
                sc.nextLine();

                System.out.print("Ingrese stock mínimo: ");
                int stockMin = sc.nextInt();
                sc.nextLine();

                Producto p = new Producto(codigo, descripcion, precio, stock, stockMin);
                catalogo.agregarProducto(p);
            }
        } while (codigo != 0);

        // Mostrar catálogo
        System.out.println("\n/CATÁLOGO CARGADO/");
        catalogo.listarProductos();

        // Registrar ventas
        System.out.println("\n/VENTA DE PRODUCTOS/");
        String respuesta;
        do {
            System.out.print("¿Vender un producto? (SI / NO): ");
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("SI")) {
                System.out.print("Ingrese código del producto a vender: ");
                int cod = sc.nextInt();
                sc.nextLine();

                Producto prodBuscado = catalogo.buscarProducto(cod);

                if (prodBuscado != null) {
                    System.out.print("Ingrese cantidad de unidades a vender: ");
                    int cant = sc.nextInt();
                    sc.nextLine();

                    if (prodBuscado.getStock() >= cant) {
                        if (!carrito.productoRepetido(prodBuscado)) {
                            ProductoVendido prod = new ProductoVendido(prodBuscado, cant);
                            carrito.agregarProducto(prod);
                            System.out.println("Producto agregado al carrito.");
                        } else {
                            System.out.println("Ese producto ya fue agregado al carrito anteriormente.");
                        }
                    } else {
                        System.out.println("No hay stock suficiente. Stock disponible: " + prodBuscado.getStock());
                    }
                } else {
                    System.out.println("No se encontró el producto.");
                }
            }

        } while (respuesta.equalsIgnoreCase("SI"));

        // Mostrar productos en el carrito
        System.out.println();
        if (!carrito.estaVacio()) {
            System.out.println("/RESUMEN DE COMPRA/");
            carrito.listarProductos();

            // Selección de método de pago
            double totalCompra = carrito.getTotal();
            Pago pago = null;

            while (pago == null) {
                System.out.println("\nSeleccione método de pago:");
                System.out.println("1 = Efectivo (-10%)");
                System.out.println("2 = Débito");
                System.out.println("3 = Crédito (+6%, 12%, 20%)");
                System.out.print("Opción: ");
                int metodo = sc.nextInt();
                sc.nextLine();

                switch (metodo) {
                    case 1:
                        pago = new Efectivo(totalCompra, "EFECTIVO");
                        break;

                    case 2:
                        System.out.print("Ingrese número de tarjeta de débito: ");
                        int debito = sc.nextInt();
                        sc.nextLine();
                        pago = new Debito(totalCompra, "DEBITO", debito);
                        break;

                    case 3:
                        System.out.print("Ingrese número de tarjeta de crédito: ");
                        int credito = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Ingrese cantidad de cuotas (2, 3 o 6): ");
                        int cuotas = sc.nextInt();
                        sc.nextLine();

                        if (cuotas == 2 || cuotas == 3 || cuotas == 6) {
                            pago = new Credito(totalCompra, "CREDITO", credito, cuotas);
                        } else {
                            System.out.println("Cantidad de cuotas inválida. Solo 2, 3 o 6.");
                        }
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            }

            // Finalizar pago
            pago.calcularMontoTotal();
            pago.registrarPago();

            // Disminuir stock
            for (ProductoVendido pv : carrito.getProductos()) {
                pv.getProducto().disminuirStock(pv.getCantidadVendida());
            }

        } else {
            System.out.println("El carrito está vacío. No se realizó ninguna venta.");
        }

        // Mostrar productos con stock mínimo
        System.out.println("\n/PRODUCTOS EN STOCK MÍNIMO/");
        catalogo.listarProductosEnStockMinimo();

        sc.close();
    }
}
