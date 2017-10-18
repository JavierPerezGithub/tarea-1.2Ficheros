import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MostrarProductosXML {
	

	public static void main(String[] args) {
		
		/*
		 * SI ME DA ERROR DE BIT
		 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> 
		*/
		
		
		// creamos una instancia al documentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// Creamos un DocumentBuilder para usarlo como parseador.
			DocumentBuilder db = dbf.newDocumentBuilder();
			// recuperamos el documento que vamos a leer.
			Document document = db.parse(new File("productos.xml"));

			// accedemos al nodo raiz --> empleados.
			Node raiz = document.getFirstChild();
			// sacamos por consola el nodo ra�z.
			System.out.println(raiz.getNodeName());

			// accedemos a los nodos hijos del nodo ra�z, obtenemos una lista.
			NodeList elementos = raiz.getChildNodes();
			obtenerNodosHijos(elementos, "");			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void obtenerNodosHijos(NodeList elementos, String tab) {
		Node nodo;
		NodeList hijos;

		if (elementos.getLength() > 1) {

			for (int i = 0; i < elementos.getLength(); i++) {
				// accedemos a los elementos de la lista de 1 en 1
				nodo = elementos.item(i);

				// para cada nodo comprobamos que sea de tipo elemento
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					// sacamos por consola el nombre de la etiqueta tabul�ndola con respecto al nodo
					// raiz
					System.out.println(tab + "\t" + nodo.getNodeName());

					// accedemos a la lista de elementos hijos del nodo que estamos manejando.
					hijos = nodo.getChildNodes();
					obtenerNodosHijos(hijos, tab + "\t");
				}
			}

		} else
			System.out.println(tab + "\t" + elementos.item(0).getNodeValue());
	}

}
