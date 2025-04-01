package LugarServicios;

import java.util.ArrayList;
import java.util.List;

import Modelo.Compra;
import Usuarios.Empleado;

public abstract class LugarServicio {
	private List<Empleado> empleados;
	private String tipoLugar;
	private int ventas;
	private List<Compra> historialCompras;
	
	public LugarServicio(String tipo) {
		this.tipoLugar=tipo;
		this.ventas=0;
		this.empleados= new ArrayList<Empleado>();
		this.historialCompras= new ArrayList<Compra>();
	}
	
	public String getTipo() {
		return tipoLugar;
	}
	
	public int getVentas() {
		return ventas;
	}
	
	public void setVentas(int venta) {
		ventas=venta;
	}
	
	public void registrarVenta(Compra compra) {
		historialCompras.addLast(compra);
		ventas+= compra.getPrecio();
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.addLast(empleado);
	}
	
	public void eliminarEmpleado(Empleado empleado) {
		int i=0;
		boolean noEncontrado= true;
		while(i<empleados.size() && noEncontrado) {
			Empleado employ= empleados.get(i);
			if (employ == empleado) {
				empleados.remove(i);
				noEncontrado=false;
			}
			i++;
		}
	}
}
