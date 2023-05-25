package CC;

public abstract class Material implements Comparable<Material> {

	private static int idDisponible;
	
	protected int idMaterial;
	protected String titulo;
	protected String autor;
	protected String dniSocio;
	
	static {
		idDisponible=1;
	}
	public Material(String titulo, String autor, String dniSocio) {
		idDisponible++;
		this.idMaterial=idDisponible;
		this.titulo=titulo;
		this.autor=autor;
		this.dniSocio=dniSocio;
	}
	
	public int compareTo(Material m) {

		int res;
		//prioridadComparar => Devuelve 1 si es libro 0 si es disco (lo cual facilita una comparación directa)
		if(this.prioridadComparar() > m.prioridadComparar() ) {
			//Un libro va antes que un disco
			res=-1;
		}else if(this.prioridadComparar() > m.prioridadComparar() ) {
			res=1;
		} else {
			// Al saber que tipo de material es puedo mandar el Nº de paginas como extring y hacer un cast para permitir el uso de la misma función para comparar int y texto segun la necesidad
			if(this.prioridadComparar()==1) {
				
				int thisLibro = Integer.valueOf( subCompareTo() );
				int otroLibro = Integer.valueOf( m.subCompareTo() );
				
				if( thisLibro > otroLibro ) {
					res=-1;
				} else if (thisLibro < otroLibro){
					res=1;
				} else {
					res=0;
				}
			}else {
				String thisDisco = subCompareTo();
				String otroDisco = subCompareTo();
				
				res = thisDisco.compareTo(otroDisco);
			}
		}
		
		return res;
	}
	//Devuelve 1 si es libro 0 si es disco (lo cual facilita una comparación directa)
	abstract int prioridadComparar();
	// Al saber que tipo de material es puedo mandar el Nº de paginas como extring y hacer un cast para permitir el uso de la misma función para comparar int y texto segun la necesidad
	abstract String subCompareTo();
	public int getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDniSocio() {
		return dniSocio;
	}
	public void setDniSocio(String dniSocio) {
		this.dniSocio = dniSocio;
	}
	@Override
	public String toString() {
		return titulo+" "+ autor+" "+dniSocio;
	}
	
	
}