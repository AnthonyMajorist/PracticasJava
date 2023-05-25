package CC;

public class Discos extends Material{

	private String discografica;
	
	public Discos(String titulo, String autor, String dniSocio, String discografica) {
		
		super(titulo, autor, dniSocio);
		this.discografica=discografica;
	}

	public String getDiscografica() {
		return discografica;
	}

	public void setDiscografica(String discografica) {
		this.discografica = discografica;
	}

	@Override
	public String toString() {
		return super.toString()+" "+discografica;
	}
	//Devuelve 1 si es libro 0 si es disco (lo cual facilita una comparación directa)
	public int prioridadComparar() {
		
		return 0;
	}
	// Al saber que tipo de material es puedo mandar el Nº de paginas como extring y hacer un cast para permitir el uso de la misma función para comparar int y texto segun la necesidad
	public String subCompareTo() {
		
		return discografica;
	}
}
