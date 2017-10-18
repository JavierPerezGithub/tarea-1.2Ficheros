import java.util.ArrayList;

public class ListaProductos {

	ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public void add(Producto p) {
		productos.add(p);
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}
}
