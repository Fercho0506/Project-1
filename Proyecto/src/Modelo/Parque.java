package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Atracciones.Atraccion;
import Atracciones.AtraccionMecanica;
import Atracciones.Espectaculo;
import LugarServicios.Cafeteria;
import LugarServicios.LugarServicio;
import LugarServicios.Taquilla;
import Persistencia.Persistencia;
import Tiquetes.FastPass;
import Tiquetes.Tiquete;
import Tiquetes.TiqueteTemporada;
import Usuarios.Cajero;
import Usuarios.Cocinero;
import Usuarios.Empleado;
import Usuarios.EmpleadoAtracciones;
import Usuarios.EmpleadoServiciosgenerales;
import Usuarios.Usuario;

import java.io.Serializable;

public class Parque implements Serializable {
    private static final long serialVersionUID = 1L;

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
	
	public Empleado getEmpleado(List<Empleado> empleados, int possicion) {
		return empleados.get(possicion);
	}
	
	public boolean usuarioAdministrador(Usuario usuario) {
		return usuario.getTipoUsuario()== "administrador";
	}
	
	public boolean autenticarIngreso(String login, String password) {
		Usuario usuario= usuarios.get(login);
		if(usuario != null) {
			return password == usuario.getPassword();
		}
		return false;
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
		
	}
	
	public void salvarData() {
		
	}
	
	public void AsignarTurno(Empleado empleado, String turno) throws Exception{
		if (empleado.gettipo()!= "serviciosGenerales") {
			empleado.AsignarTurno(turno);
		}
		else {
			throw new Exception ("Los empleados de servicios generales no tienen turno");
		}
	}
	
	public void AsignarLabor(Empleado empleado, String labor, LugarServicio lugar) throws Exception{
		if (labor== "cocina" && empleado.gettipo()!="cocinero") {
			throw new Exception("Solo los cocineros pueden estar en la cocina");
		}
		else if(labor=="caja" && (empleado.gettipo()!= "cajero" || empleado.gettipo()!="cocinero") ){
			throw new Exception("Solo cocineros o cajeros pueden estar en caja");
		}
		else if (labor=="atraccion" && empleado.gettipo() != "empleadoAtracciones") {
			throw new Exception("Solo los empleados de atracciones pueden estar acargo de estas");
		}
		else if (labor=="caja" && empleado.gettipo()=="cocinero") {
			if (lugar.getTipo()=="cafeteria") {
				Cafeteria cafe= (Cafeteria) lugar;
				cafe.setCajero(empleado);
				empleado.setLabor(labor);
			}
			else {
				throw new Exception("Los cocineros solo pueden trabajar en las cafeterias");
			}
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
			lugar.setCajero(cajero);
		}
		else if (empleado.gettipo()=="serviciosGenerales"){
			EmpleadoServiciosgenerales employ= (EmpleadoServiciosgenerales)empleado;
			employ.setLugar(lugar);
		}
		else if(empleado.gettipo()=="cocinero" && lugar.getTipo()=="cafeteria") {
			Cafeteria cafe= (Cafeteria) lugar;
			Cocinero coci= (Cocinero) empleado;
			cafe.setCocinero(coci);
		}
		else {
			throw new Exception("No se pudo asignar sitio");
		}
	}
	
	public void asignarAtraccionEmpleado(Empleado empleado, AtraccionMecanica atraccion) throws Exception{
		if (empleado.gettipo() == "empleadoAtracciones") {
			EmpleadoAtracciones employ= (EmpleadoAtracciones) empleado;
			employ.setAtraccion(atraccion);
			atraccion.agregarEmpleado(employ);
			
		}
		else if (empleado.gettipo()=="cajero"){
			Cajero cajero= (Cajero)empleado;
			cajero.setAtraccion(atraccion);
			atraccion.setCajero(cajero);
		}
		else {
			throw new Exception("No se pudo asignar sitio");
		}
	}
	
	public int generarCodigoCompra() {
		int numero = ( int ) ( Math.random( ) * 10e7 );
		return numero;
	}
	
	public CompraAtracciones realizarCompraTiquetesOnline(Usuario usuario, List<Tiquete> tiquetes, List<FastPass> fast) {
		float precio=0;
		CompraAtracciones compra= new CompraAtracciones(generarCodigoCompra(), usuario);
		if (usuario.getTipoUsuario()== "cliente") {
			for (Tiquete i: tiquetes) {
				usuario.AgregarTiquete(i);
				precio += i.getPrecio();
				compra.agregarTiquete(i);
			}
			for(FastPass a: fast) {
				usuario.agregarFastPass(a);
				precio += a.getPrecio();
				compra.agregarFastPass(a);
			}
			compra.setPrecio(precio);
			usuario.agregarCompra(compra);
		}
		else {
			for (Tiquete i: tiquetes) {
				usuario.AgregarTiquete(i);
				precio += i.getPrecio()*0.8;
				compra.agregarTiquete(i);
			}
			for(FastPass a: fast) {
				usuario.agregarFastPass(a);
				precio += a.getPrecio()*0.8;
				compra.agregarFastPass(a);
			}
			compra.setPrecio(precio);
			usuario.agregarCompra(compra);
		}
		return compra;
		
	}
	
	public void realizarCompraTiquetesTaquilla(Usuario usuario, List<Tiquete> tiquetes, List<FastPass> fast, 
			Taquilla taquilla) throws Exception{
		if (taquilla.getCajero()!=null) {
			CompraAtracciones compra=realizarCompraTiquetesOnline(usuario, tiquetes, fast);
			taquilla.registrarVenta(compra);
		}
		else {
			throw new Exception("La taquilla no tiene un cajero que registre la venta");
		}
	}
	
	public void IngresarAtraccion(Atraccion atraccion, Tiquete tiquete) throws Exception{
		if (atraccion.getCajero() != null && atraccion.getEmpleadosMin() <= atraccion.getNumeroEmpleados()) {
			Cajero cajero= atraccion.getCajero();
			boolean sePuede= cajero.validarEntrada(tiquete);
			if (sePuede) {
				System.out.print("El ingreso fue exitoso");
			}
			else {
				System.out.print("el cliente no puede ngresar a la atracción");
			}
		}
		else {
			throw new Exception("La atracción no tiene un cajero o empleados suficientes");
		}
	}
	
	public void realizarOtraCompra(CompraServicio compra) {
		compra.getComprador().agregarCompra(compra);
		compra.getLugar().registrarVenta(compra);
	}
	
	public boolean registrarEntrada(Tiquete tiquete) {
		if (tiquete.getTipo() != "entrada") {
			return tiquete.getUsado();
		}
		return false;
	}
	
	public void registrarSalida(Tiquete tiquete, String fechaHoy) {
		if (tiquete.getTipo()== "regular") {
			tiquete.usarTiquete();
		}
		if(tiquete.getTipo()== "temporada") {
			TiqueteTemporada tiquet= (TiqueteTemporada) tiquete;
			int i2= tiquet.getFin().compareTo(fechaHoy);
			if (i2!=1) {
				tiquete.usarTiquete();
			}
		}
	}
	
	public void cargarData1() {
	    Parque parqueCargado = (Parque) Persistencia.cargarObjeto("parque.bin");
	    if (parqueCargado != null) {
	        this.direccion = parqueCargado.getDireccion();
	        this.nombre = parqueCargado.getNombre();
	        this.capacidad = parqueCargado.getCapacidad();
	        this.abierto = parqueCargado.getAbierto();
	        this.usuarios = new HashMap<>();
	        this.usuarios.putAll(parqueCargado.usuarios);
	        this.atracciones = new ArrayList<>(parqueCargado.atracciones);
	        this.espectaculos = new ArrayList<>(parqueCargado.espectaculos);
	        this.lugaresServicios = new ArrayList<>(parqueCargado.lugaresServicios);
	    }
	}

	public void salvarData1() {
	    Persistencia.guardarObjeto(this, "parque.bin");
	}

	
}
