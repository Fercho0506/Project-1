package Usuarios;

public class Administrador extends Usuario{
	private static final long serialVersionUID = 1L;
	public Administrador(String login, String password, int edad, float altura) {
		super(login, password, "administrador", edad, altura);
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
}
