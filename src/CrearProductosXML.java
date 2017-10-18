import java.io.*;
import com.thoughtworks.xstream.XStream;

public class CrearProductosXML {

	public static void main(String[] args) {
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("C:\\Users\\21650521\\eclipse-workspace\\JavierPerez_Tarea_UF1_2\\src\\productos.dat"));
			
			Producto p= null;
			
			ListaProductos lPro = new ListaProductos();
			
			p = (Producto)ois.readObject();
			
			//Lectura
			try {
				
				while(p !=null) {
					lPro.add(p);
					p = (Producto)ois.readObject();
				}

			}catch(EOFException e) {
				System.out.println("Fin");
			}
			ois.close();
			XStream xs = new XStream();
			//Nombre del elemento raiz se llama ListaProductos, se corresponde con la clase ListaProductos.
			xs.alias("ListaProductos", ListaProductos.class);
			//Nombre del elemento raiz se llama Producto, se corresponde con la clase Producto.
			xs.alias("Producto", Producto.class);
	//en addImplicitCollection haces referencia a la clase principal y el nombre productos es el contenedor Array.
			
			xs.addImplicitCollection(ListaProductos.class, "productos");
			//Transformo en XML y le doy salida indicandole la ruta.
			xs.toXML(lPro, new FileOutputStream("productos.xml"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
