package CC;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
				CentroCultural centro = new CentroCultural(); 
				Scanner input = new Scanner (System.in);
				int opcion=-1;		
				do {
					System.out.println("\n¿Qué desea hacer?\n"
						+ "1. Importar Materiales\n"
						+ "2. Agregar Materiales\n"
						+ "3. Exportar Materiales\n"
						+ "4. Mostrar Materiales\n"
						+ "5. Mostrar Socios\n"
						+ "0. Salir");
					opcion = input.nextInt(); input.nextLine();
					System.out.println();
					redireccionMenu(opcion, centro);
				}while(opcion!=0);
			}

			public static void redireccionMenu(int opcion, CentroCultural centro) {
				
				switch (opcion) {
				case 1:
					if( centro.importarMateriales("src/Documentos/importar.txt") ) {
						System.out.println("Importado con exito");
					} else {
						System.out.println("Ha ocurrido un error");
					}
					break;
				case 2:
					centro.agregarMaterialManualmente();
					break;
				case 3:
					centro.exportarMateriales();
					break;
				case 4:
					centro.mostrarMateriales();
					break;
				case 5:
					centro.mostrarSocios();
					break;
				}
		// TODO Auto-generated method stub

	}

}
