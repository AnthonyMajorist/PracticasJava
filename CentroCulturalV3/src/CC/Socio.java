package CC;

public class Socio {
	
	private String dniSocio;
	private String nombre;
	private String telefono;
	
	public Socio(String dniSocio, String nombre, String telefono) throws Exception{
		
		this.dniSocio=dniSocio;
		this.nombre=nombre;
		this.telefono=telefono;
	}

	public String getDniSocio() {
		return dniSocio;
	}

	public void setDniSocio(String dniSocio) {
		this.dniSocio = dniSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombre+" dni=>"+dniSocio+" telefono=>" + telefono;
	}

}
