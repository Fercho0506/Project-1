package LugarServicios;

import java.util.Collection;
import java.util.HashMap;


public class Cafeteria extends LugarServicio{
	private HashMap<String, Integer> productos;
	
	public Cafeteria() {
		super("cafeteria");
		this.productos= new HashMap<String, Integer>();
	}
	
	public void agregarProducto(String nombre, int precio) {
		productos.put(nombre, precio);
	}
	
	public void quitarProducto(String nombre) {
		productos.remove(nombre, nombre);
	}
	
	public int getPrecioProducto(String producto) {
		return productos.get(producto);
	}
	
	public Collection<String> getProductos(){
		return productos.keySet();
	}
	
}
