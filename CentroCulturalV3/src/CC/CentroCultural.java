package CC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CentroCultural {
	
	private ArrayList<Material> materiales;
	private ArrayList<Socio> socios;
	
	public CentroCultural() {
		
		materiales = new ArrayList<Material>();
		socios = new ArrayList<Socio>();
		
		//Se añaden socios por defecto
		try {
			socios.add( new Socio("DNI1", "Socio1", "Telefono1") );
			socios.add( new Socio("DNI2", "Socio2", "Telefono2") );
			socios.add( new Socio("DNI3", "Socio3", "Telefono3") );
			
		}catch (Exception e) {
			//no va a llegar
		}
	}

	public boolean importarMateriales(String ruta) {
		
		try {
			File f = new File(ruta);
			Scanner lector = new Scanner(f);
			
			while(lector.hasNext() == true) {
				
				String nombre = lector.next();
				String autor = lector.next();
				String dni = lector.next();
				//Si el dni no existe dejar de mirar estos datos:
					
				//Si ahora es un INT sabremos que es un libro (poco escalabre pero mas simple)
				if(lector.hasNextInt()) {
					
					int numPaginas = lector.nextInt();
					String editorial = lector.next();
					
					if(numPaginas > 0 && existeDni(dni)  ) {
							
						materiales.add( new Libro(nombre, autor, dni, numPaginas, editorial) );	
					}
				} else {
						
					String discografica = lector.next();
					
					if(existeDni(dni)  ) {
						materiales.add( new Discos(nombre, autor, dni, discografica) );
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
	
	public boolean existeDni(String dni) {
		boolean cond = false;
		int pos = 0;
		
		while(cond == false && pos<socios.size()) {
			
			if( socios.get(pos).getDniSocio().equalsIgnoreCase(dni) ) {
				cond = true;
			}
			pos++;
		}
		
		return cond;
	}
	
	public boolean agregarMaterialManualmente() {
		
		Scanner input = new Scanner (System.in);
		String opcion;
		do {
			System.out.println("Quiere dar de alta un libro o un disco");
			opcion=input.nextLine();
		}while(opcion.equalsIgnoreCase("libro")==false && opcion.equalsIgnoreCase("disco")==false);
		
		System.out.println();
		
		System.out.println("Escriba el titulo");
		String titulo = input.nextLine();
		System.out.println("Escriba el autor");
		String autor = input.nextLine();
		System.out.println("Escriba el dni del socio");
		String dniSocio = input.nextLine();
		
		while(existeDni(dniSocio)==false) {
			
			System.out.println("DNI no existente, escribalo nuevamente. Escribe 'Socios' para mostrar los existenter o 'Salir' para finalizar el proceso");
			dniSocio = input.nextLine();
			
			if(dniSocio.equalsIgnoreCase("Socios")) {
				
				mostrarSocios();
				
			}else if(dniSocio.equalsIgnoreCase("Salir")) {
				
				return false;
			}	
		}
		if(opcion.equalsIgnoreCase("libro")) {
			int numPaginas=0;
			boolean valido=false;
			
			while(numPaginas<1 && valido==false) {
				try {
					System.out.println("Escriba el número de páginas");
					numPaginas = input.nextInt();	input.nextLine();
					if(numPaginas>0) {
						valido=true;
					}
				}
				catch(InputMismatchException e){				
				System.err.println("Debe tener más de 0 páginas");
				input.nextLine();
				}
			}
			
			System.out.println("Escriba la editorial");
			String editorial = input.nextLine();
			
			materiales.add( new Libro(titulo, autor, dniSocio, numPaginas, editorial) );
		} else {
			
			System.out.println("Escriba la discografica");
			String discografica = input.nextLine();
			
			materiales.add( new Discos(titulo, autor, dniSocio, discografica) );
		}		
		return true;
	}
	
	public void mostrarSocios() {
		for (Socio s : socios) {
			System.out.println(s.toString());
		}
	}
	
	public void mostrarMateriales() {
		Collections.sort(materiales);
		for (Material m : materiales) {
			System.out.println(m.toString());
		}
	}
	
	public boolean exportarMateriales() {
		// No encuentro el ejercicio para usar el compare to y no me acuerdo		
		File exportar=new File("src/Documentos/Materiales.txt");
		try {
			FileWriter writer = new FileWriter(exportar);
			Collections.sort(materiales);
			for (Material m : materiales) {
				writer.write( m.toString()+"\n");
			}
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
}


