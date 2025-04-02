package Usuarios;

public class Cliente extends Usuario{
	
	public Cliente(String login, String password, int edad, float altura) {
		super(login, password, "cliente", edad, altura);
	}
}
