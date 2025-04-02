package Atracciones;

import java.util.Date;

public class Espectaculo {
	private String nombre;
	private Date fecha;
	private String horario;
	private boolean abierto;
	
	public Espectaculo(String nombre, Date fecha, String horario) {
		this.nombre=nombre;
		this.fecha=fecha;
		this.horario=horario;
		this.abierto=false;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Date getfecha() {
		return fecha;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public boolean getAbierto() {
		return abierto;
	}
	
	public void setNombre(String name) {
		nombre=name;
	}
	
	public void setFecha(Date date) {
		fecha=date;
	}
	
	public void setHorario(String hor) {
		horario=hor;
	}
	
	public void abrir() {
		abierto=true;
	}
	
	public void cerrar() {
		abierto=false;
	}
}
