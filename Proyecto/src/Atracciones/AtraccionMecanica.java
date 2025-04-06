package Atracciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Usuarios.EmpleadoAtracciones;

public class AtraccionMecanica extends Atraccion{
	private float alturaMax;
	private float alturaMin;
	private List<String> restricciones;
	private String nivelRiesgo;
	
	public AtraccionMecanica(String nombre, int capacidad, String ubicacion, int empleadosMin, String exclusividad, Date temporada,
			float alturaMax, float alturaMin, String nivelRiesgo) {
		super(nombre, capacidad, ubicacion, empleadosMin, exclusividad, temporada, "mecanica");
		this.alturaMax= alturaMax;
		this.alturaMin= alturaMin;
		this.nivelRiesgo= nivelRiesgo;
		this.restricciones= new ArrayList<String>();
	}
	
	public float getAlturaMax() {
		return alturaMax;
	}
	
	public float getAlturaMin() {
		return alturaMin;
	}
	
	public String getNivel() {
		return nivelRiesgo;
	}
	
	public List<String> getRestricciones(){
		return restricciones;
	}
	
	public void agregarRestriccion(String restriccion) {
		restricciones.addLast(restriccion);
	}
	
	public void setAlturaMax(float altura) {
		alturaMax= altura;
	}
	
	public void setAlturaMin(float altura) {
		alturaMin= altura;
	}
	
	
	public void setNivel(String level) {
		nivelRiesgo=level;
	}
	
	public void eliminarRestriccion(String restriccion) {
		int i=0;
		boolean NoEncontrado= true;
		while(i<restricciones.size() && NoEncontrado) {
			String restrict= restricciones.get(i);
			if (restrict== restriccion) {
				restricciones.remove(i);
				NoEncontrado= false;
			}
			i++;
		}
	}
}
