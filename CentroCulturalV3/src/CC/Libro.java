package CC;

public class Libro extends Material{

	private int numPaginas;
	private String editorial;
	
	public Libro(String titulo, String autor, String dniSocio, int numPaginas, String editorial){
		super(titulo, autor, dniSocio);
		this.numPaginas=numPaginas;
		this.editorial=editorial;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String discografica) {
		this.editorial = discografica;
	}

	@Override
	public String toString() {
		return super.toString()+" "+numPaginas+" "+editorial;
	}
	//Devuelve 1 si es libro 0 si es disco (lo cual facilita una comparación directa)
	public int prioridadComparar() {
		
		return 1;
	}
	// Al saber que tipo de material es puedo mandar el Nº de paginas como extring y hacer un cast para permitir el uso de la misma función para comparar int y texto segun la necesidad
	public String subCompareTo() {
		
		return numPaginas+"";
	}
}