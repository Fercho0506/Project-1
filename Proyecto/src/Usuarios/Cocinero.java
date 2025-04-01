package Usuarios;

import LugarServicios.Cafeteria;

public class Cocinero extends Empleado{
	private Cafeteria cafeteria;
	
	
	public Cocinero (String login, String password, int edad, float altura, Cafeteria cafeteria, String labor) {
		super(login, password, edad, altura, "cocinero", labor);
		this.cafeteria=cafeteria;
	}
	
	public void prepararPlato(String plato) {
		System.out.print("Se preparó "+plato+"plato");
	}
}
