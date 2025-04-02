package Atracciones;

import java.util.Date;

public abstract class Atraccion {
	
	private String nombre;
	private int capacidad;
	private String ubicacion;
	private int empleadosMin;
	private String exclusividad;
	private Date temporada;
	private boolean abierta;
	private String tipo;
	
	public Atraccion(String nombre, int capacidad, String ubicacion, int empleadosMin, String exclusividad, Date temporada, String tipo) {
		this.nombre=nombre;
		this.capacidad=capacidad;
		this.ubicacion= ubicacion;
		this.empleadosMin= empleadosMin;
		this.exclusividad=exclusividad;
		this.temporada=temporada;
		this.tipo=tipo;
		this.abierta = false;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public int getEmpleadosMin() {
		return empleadosMin;
	}
	
	public String getExclusividad() {
		return exclusividad;
	}
	
	public Date getTemporada() {
		return temporada;
	}
	
	public boolean getAbierta() {
		return abierta;
	}
	
	public void setNombre(String name) {
		nombre=name;
	}
	
	public void setCapacidad(int capa) {
		capacidad= capa;
	}
	
	public void getUbicacion(String ubi) {
		ubicacion=ubi;
	}
	
	public void getEmpleadosMin(int emp) {
		empleadosMin= emp;
	}
	
	public void getExclusividad(String exclu) {
		exclusividad= exclu;
	}
	
	public void getTemporada(Date temp) {
		temporada=temp;
	}
	
	public void abrirAtraccion() {
		abierta=true;
	}
	
	public void cerrarAtraccion() {
		abierta=false;
	}
}
