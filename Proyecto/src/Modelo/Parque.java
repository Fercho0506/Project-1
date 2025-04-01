package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Atracciones.Atraccion;
import Atracciones.Espectaculo;
import LugarServicios.LugarServicio;
import LugarServicios.Taquilla;
import Tiquetes.FastPass;
import Tiquetes.Tiquete;
import Usuarios.Cajero;
import Usuarios.Empleado;
import Usuarios.EmpleadoAtracciones;
import Usuarios.EmpleadoServiciosgenerales;
import Usuarios.Usuario;

public class Parque {
	private String direccion;
	private String nombre;
	private int capacidad;
	private boolean abierto;
	private HashMap<String, Usuario> usuarios;
	private List<Atraccion> atracciones;
	private List<Espectaculo> espectaculos;
	private List<LugarServicio> lugaresServicios;
	
	public Parque(String direccion, String nombre, int capacidad) {
		this.direccion= direccion;
		this.nombre=nombre;
		this.capacidad=capacidad;
		this.abierto=false;
		this.usuarios= new HashMap<String, Usuario>();
		this.atracciones= new ArrayList<Atraccion>();
		this.espectaculos= new ArrayList<Espectaculo>();
		this.lugaresServicios= new ArrayList<LugarServicio>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.put(usuario.getUsuario(), usuario);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public boolean getAbierto() {
		return abierto;
	}
	
	public void agregaratraccion(Atraccion atraccion) {
		atracciones.addLast(atraccion);
	}
	
	public void agregarEspectaculo(Espectaculo espectaculo) {
		espectaculos.addLast(espectaculo);
	}
	
	public void agregarLugar(LugarServicio lugar) {
		lugaresServicios.addLast(lugar);
	}
	
	public Collection<Usuario> getUsuarios(){
		return usuarios.values();
	}
	
	public List<Empleado> getEmpleados(){
		List<Empleado> empleados= new ArrayList<Empleado>();
		for(Usuario i: usuarios.values()) {
			if (i.getTipoUsuario()=="empleado") {
				empleados.addLast((Empleado)i);
			}
		}
		return empleados;
	}
	
	public List<Atraccion> getAtracciones(){
		return atracciones;
	}
	
	public List<Espectaculo> getEspectaculo(){
		return espectaculos;
	}
	
	public List<LugarServicio> getLugares(){
		return lugaresServicios;
	}
	
	public void setNombre(String Nombre) {
		nombre=Nombre;
	}
	
	public void setCapacidad(int capacity ) {
		capacidad=capacity;
	}
	
	public void setDireccion(String direct) {
		direccion=direct;
	}
	
	public void abrirParque() {
		abierto=true;
	}
	
	public void cerrarParque() {
		abierto=false;
	}
	
	public boolean eliminarUsuario(Usuario usuario) {
		return usuarios.remove(usuario.getUsuario(), usuario);
	}
	
	public void eliminarAtraccion(Atraccion atraccion) {
		int i=0;
		boolean noEncontrado= true;
		while(i<atracciones.size() && noEncontrado) {
			Atraccion atract= atracciones.get(i);
			if (atraccion == atract) {
				atracciones.remove(i);
				noEncontrado=false;
			}
			i++;
		}
	}
	
	public void eliminarEspectaculo(Espectaculo espectaculo) {
		int i=0;
		boolean noEncontrado= true;
		while(i<espectaculos.size() && noEncontrado) {
			Espectaculo espe= espectaculos.get(i);
			if (espe == espectaculo) {
				espectaculos.remove(i);
				noEncontrado=false;
			}
			i++;
		}
	}
	
	public void eliminarLugar(LugarServicio lugar) {
		int i=0;
		boolean noEncontrado= true;
		while(i<lugaresServicios.size() && noEncontrado) {
			LugarServicio place= lugaresServicios.get(i);
			if (lugar == place) {
				lugaresServicios.remove(i);
				noEncontrado=false;
			}
			i++;
		}
	}
	
	public void cargarData() {
		null;
	}
	
	public void salvarData() {
		null;
	}
	
	public void AsignarTurno(Empleado empleado, String turno) throws Exception{
		if (empleado.gettipo()!= "serviciosGenerales") {
			empleado.AsignarTurno(turno);
		}
		else {
			throw new Exception ("Los empleados de servicios generales no tienen turno");
		}
	}
	
	public void AsignarLabor(Empleado empleado, String labor) throws Exception{
		if (labor== "cocina" && empleado.gettipo()!="cocinero") {
			throw new Exception("Solo los cocineros pueden estar en la cocina");
		}
		else if(labor=="caja" && (empleado.gettipo()!= "cajero" || empleado.gettipo()!="cocinero") ){
			throw new Exception("Solo cocineros o cajeros pueden estar en caja");
		}
		else if (labor=="atraccion" && empleado.gettipo() != "empleadoAtracciones") {
			throw new Exception("Solo los empleados de atracciones pueden estar acargo de estas");
		}
		else {
			empleado.setLabor(labor);
		}
	}
	public void retirarTurnoEmpleado(Empleado empleado, String turno) {
		empleado.RetirarTurno(turno);
	}
	
	public void asignarLugarEmpleado(Empleado empleado, LugarServicio lugar) throws Exception {
		if (empleado.gettipo()=="empleadoAtracciones") {
			throw new Exception("Este empleado es de atracciones, no lugar de servicio");
		}
		else if (empleado.gettipo()=="cajero"){
			Cajero cajero= (Cajero)empleado;
			cajero.setLugar(lugar);
		}
		else if (empleado.gettipo()=="serviciosGenerales"){
			EmpleadoServiciosgenerales employ= (EmpleadoServiciosgenerales)empleado;
			employ.setLugar(lugar);
		}
		else {
			throw new Exception("No se pudo asignar sitio");
		}
	}
	
	public void asignarAtraccionEmpleado(Empleado empleado, Atraccion atraccion) throws Exception{
		if (empleado.gettipo() == "empleadoAtracciones") {
			EmpleadoAtracciones employ= (EmpleadoAtracciones) empleado;
			employ.setAtraccion(atraccion);
		}
		else if (empleado.gettipo()=="cajero"){
			Cajero cajero= (Cajero)empleado;
			cajero.setAtraccion(atraccion);
		}
		else {
			throw new Exception("No se pudo asignar sitio");
		}
	}
	
	public void realizarCompraTiquetesOnline(CompraAtracciones compra) {
		Usuario usuario= compra.getComprador();
		for (Tiquete i: compra.getTiquetes()) {
			usuario.AgregarTiquete(i);
		}
		for(FastPass a: compra.getFastPass()) {
			usuario.agregarFastPass(a);
		}
		usuario.agregarCompra(compra);
		
	}
	
	public void realizarCompraTiquetesTaquilla(CompraAtracciones compra, Taquilla taquilla) {
		Usuario usuario= compra.getComprador();
		for (Tiquete i: compra.getTiquetes()) {
			usuario.AgregarTiquete(i);
		}
		for(FastPass a: compra.getFastPass()) {
			usuario.agregarFastPass(a);
		}
		usuario.agregarCompra(compra);
		taquilla.registrarVenta(compra);
	}
	
	public void realizarOtraCompra(CompraServicio compra) {
		compra.getComprador().agregarCompra(compra);
		compra.getLugar().registrarVenta(compra);
	}
	
}
