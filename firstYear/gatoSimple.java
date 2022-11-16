import java.util.Scanner;
import java.util.Random;


/*
 Date: 09/23/22
 Author: Cervantes Alatorre Juan José Emiliano
 "Tic tac toe, GATO"
 */

public class gatoSimple{
  
	public static void main(String[] args) {
    
		//Declaracion de atributos
		int fila, columna,validacion,validacionVacio=0,jugadas=0;
		String[][] tablero = {{" "," "," "},{" "," "," "},{" "," "," "}};
		
		//Creacion de objetos
		Scanner lector = new Scanner(System.in);
		Random azar = new Random();
		
		
		//Bienvenida
		System.out.println("Bienvenido al juego del gato, ingrese las coordenadas para comenzar");
		imprimirTablero(tablero);
		System.out.println();
		
		//Lectura de MIS coordenadas
		System.out.print("Fila: ");
		fila = lector.nextInt();
		System.out.print("Columna: ");
		columna = lector.nextInt();
		
		//Imprimo con mis coordenadas
		imprimirTablero(tablero,fila,columna);
		System.out.println("Turno Del rival!!!");
    
		do {
      
			do {
        
				fila = azar.nextInt(3);  
				columna = azar.nextInt(3);
				validacion = validarEspacio(tablero,fila,columna);
        
			}while(validacion==2);
			
      
			imprimirTableroRival(tablero,fila,columna);
      
			do {
        
				//Lectura de MIS coordenadas
				System.out.print("Fila: ");
				fila = lector.nextInt();
				System.out.print("Columna: ");
				columna = lector.nextInt(); 
				//Validacion de los espacios
				validacion = validarEspacio(tablero,fila,columna);
        
				if(validacion==2) {
          
					System.out.println("Intenta de nuevo");
          
				}
        
			}while(validacion==2);
      
				//Imprimo con mis coordenadas
				imprimirTablero(tablero,fila,columna);
				System.out.println();
      
			for(int a =0; a<tablero.length;a++) {
        
				for(int e = 0; e<tablero[a].length;e++) {
          
					if(tablero[a][e].equals(" ")) {
            
						validacionVacio=2;
						break;
            
					}
					else {
            
						validacionVacio=1;
						break;
            
					}
          
				}
        
			}
			jugadas = jugadas(tablero);
      
			if(jugadas==1) {
        
				System.out.println("Felicidades, ganaste!!!");
				System.exit(0);
        
			}
      
			if(jugadas==2) {
        
				System.out.println("Perdiste!!!");
				System.exit(0);
        
			}
      
		}while(validacionVacio==2);
    
	}
	
	//Imprime el tablero inicial
	public static void imprimirTablero(String[][]tablero) {
    
		for(int a =0; a<tablero.length;a++) {
      
			for(int e = 0; e<tablero[a].length;e++) {
        
				System.out.print("|"+tablero[a][e]+""+"|");
        
			}
      
			System.out.println();
      
		}
    
	}
	
	//Imprimir tablero con mis coordenadas
	public static void imprimirTablero(String[][]tablero,int fila, int columna) {
    
		for(int a =0; a<tablero.length;a++) {
      
			for(int e = 0; e<tablero[a].length;e++) {
        
				tablero[fila][columna]="x";
				System.out.print("|"+tablero[a][e]+""+"|");
        
			}
      
			System.out.println();
      
		}
    
	}
	
	//Imprimir tablero rival
		public static void imprimirTableroRival(String[][]tablero,int fila, int columna) {
      
			for(int a =0; a<tablero.length;a++) {
        
				for(int e = 0; e<tablero[a].length;e++) {
          
					tablero[fila][columna]="o";
					System.out.print("|"+tablero[a][e]+""+"|");
          
				}
        
				System.out.println();
        
			}
      
		}
		
		
		public static int validarEspacio(String[][] tablero, int fila, int columna) {
      
			if(tablero[fila][columna].equals(" ")) {
				return 1;
        
			}
			else {
        
				return 2;
        
			}
      
		}
		
		//FUNCIONES PARA VALIDAR LAS JUGADAS
		private static int jugadas(String[][]tablero) {
			//xxx
			if(tablero[0][0].equals("x")&&tablero[0][1].equals("x")&&tablero[0][2].equals("x")) {
				return 1;
			}
			//xxx
			if(tablero[1][0].equals("x")&&tablero[1][1].equals("x")&&tablero[1][2].equals("x")) {
				return 1;
			}
			//xxx
			if(tablero[2][0].equals("x")&&tablero[2][1].equals("x")&&tablero[2][2].equals("x")) {
				return 1;
			}
			
			/*
			 x
			 x
			 x
			 */
			if(tablero[0][0].equals("x")&&tablero[1][0].equals("x")&&tablero[2][0].equals("x")) {
				return 1;
			}
			
			if(tablero[0][1].equals("x")&&tablero[1][1].equals("x")&&tablero[2][1].equals("x")) {
				return 1;
			}
			
			if(tablero[0][2].equals("x")&&tablero[1][2].equals("x")&&tablero[2][2].equals("x")) {
				return 1;
			}
			
			 /*x		x
			 *  x      x  
			 *   x    x		 
			 */
			if(tablero[0][0].equals("x")&&tablero[1][1].equals("x")&&tablero[2][2].equals("x")) {
				return 1;
			}
			if(tablero[0][2].equals("x")&&tablero[1][1].equals("x")&&tablero[2][0].equals("x")) {
				return 1;
			}
			
			if(tablero[0][0].equals("x")&&tablero[0][1].equals("x")&&tablero[0][2].equals("x")) {
				return 1;
			}
			
			//Enemigo
			
			//xxx
			if(tablero[0][0].equals("o")&&tablero[0][1].equals("o")&&tablero[0][2].equals("o")) {
				return 2;
			}
			//xxx
			if(tablero[1][0].equals("o")&&tablero[1][1].equals("o")&&tablero[1][2].equals("o")) {
				return 2;
			}
			//xxx
			if(tablero[2][0].equals("o")&&tablero[2][1].equals("o")&&tablero[2][2].equals("o")) {
				return 2;
			}
			
			/*
			 x
			 x
			 x
			 */
			if(tablero[0][0].equals("o")&&tablero[1][0].equals("o")&&tablero[2][0].equals("o")) {
				return 2;
			}
			
			if(tablero[0][1].equals("o")&&tablero[1][1].equals("o")&&tablero[2][1].equals("o")) {
				return 2;
			}
			
			if(tablero[0][2].equals("o")&&tablero[1][2].equals("o")&&tablero[2][2].equals("o")) {
				return 2;
			}
			
			 /* o		o
			 *  o      o  
			 *   o    o		 
			 */
			if(tablero[0][0].equals("o")&&tablero[1][1].equals("o")&&tablero[2][2].equals("o")) {
				return 2;
			}
			if(tablero[0][2].equals("o")&&tablero[1][1].equals("o")&&tablero[2][0].equals("o")) {
				return 2;
			}
			
			if(tablero[0][0].equals("o")&&tablero[0][1].equals("o")&&tablero[0][2].equals("o")) {
				return 2;
			}
			
			else {return 0;}
		}
}	
