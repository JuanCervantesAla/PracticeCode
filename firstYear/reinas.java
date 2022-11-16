package reinas;
import java.util.Random;

public class reinas {

	//Contador como estatico para contar el numero de soluciones
	static int contador=0;
	
	public static void main(String[] args) {
	
		inicio();

	}
	
	
	public static void inicio() {
		
		//Creo el tablero y lo lleno con ceros y unos
		int[][] tablero=new int[8][8];
		crearTablero(tablero);
		imprimirTablero(tablero);
		
		
		//Inicio con el tablero
		System.out.println();
		//Ingreso el tablero y desde quiero que comience que es la fila 0
		llenarTablero(tablero,0);
		
	}
	
	
	//Para llenar el tablero es la funcion recursiva
	public static void llenarTablero(int[][]tablero,int coordenada1) {
		
		boolean espacioDisponible;
		
		//Si la coordenada 1 = 8 significa que ya recorrio todo el tablero
		if (coordenada1 == 8) {
			
			//Cuenta el numero de solucion
			contador++;
			System.out.println("Solucion #"+contador);
            imprimirTablero(tablero);
            return;
            
        }
		

		/*Itera para colocar una reina sobre la misma fila
		 * Si la fila es 0, va iterando la columna hasta el 7 que es el limite
		 * */
        for (int coordenada2 = 0; coordenada2 < 8; coordenada2++) {
        	
        	//Verifico que exista espacio en la posicion si no choca con ninguna reina
        	espacioDisponible=verificarEspacioReina(tablero, coordenada1, coordenada2);
        	
        	//Si el espacio esta disponible
            if (espacioDisponible==true) {
            	
            	//Crea una reina en el espacio
                tablero[coordenada1][coordenada2] = 1;
 
                //Vuelve a iterar
                llenarTablero(tablero, coordenada1 + 1);
 
                //El espacio anterior que tengo dejalo en 0 ya que no se va a repetir porque choca
                tablero[coordenada1][coordenada2] = 0;
                
            }
            
        }
        
	}
	
	
	
	//Verifico cada parte de la reina
	public static boolean verificarEspacioReina(int[][]tablero, int coordenada1, int coordenada2) {	
		
		//Verificando TODA LA MATRIZ del 0 al 7
		for(int fila=0;fila<8;fila++) {
			
			/*
			 * Verifica en la coordenada 
			 * Si encuentra una en la misma columna regresa falso
			 * 
			 * */
			if(tablero[fila][coordenada2]==1) {
				return false;
			}
			//Inicio el for de las columnas
			for(int columna=0;columna<8;columna++) {
				/*
				 * Si en el tablero...
				 * La fila que es constante y la columna que es variable
				 * forman un 1 significa que ya esta ocupado el espacio
				 * */
				if(tablero[coordenada1][columna]==1) {
					
					return false;	
					
				}
				
				//Si en el tablero en la posicion de fila y columna existe una reina
				if(tablero[fila][columna]==1) {
					/*Para la diagona, si la fila y la columna sumadas
					 * Dan lo mismo que la coordenada1 y 2 sumadas entonces
					 * Significa que estan en diagonal y ambas
					 * tienen reina
					 * */
					if((fila+columna)==(coordenada1+coordenada2)) {
						return false;	
						
					}
					
					/*Para la diagona invertida, si la fila y la columna restadas
					 * Dan lo mismo que la coordenada1 y 2 sumadas entonces
					 * Significa que estan en diagonal y ambas
					 * tienen reina
					 * */
					
					if((fila-columna)==(coordenada1-coordenada2)) {
						return false;
					}
				}
				
			}
			
		}
		
		//Si todas las opciones anteriores son incorrectas eso significa que hay espacio libre
		return true;
		
		
	}
	
	
	/*
	 * Imprimir el tablero, no hay mas
	 * */
	public static void imprimirTablero(int[][]tablero) {
		for(int fila=0;fila<tablero.length;fila++) {
			
			for(int columna = 0; columna<tablero.length;columna++) {
				
				System.out.print("|"+tablero[fila][columna]+""+"|");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
	
	
	/*
	 * LLeno el tablero con puros ceros
	 * */
	public static void crearTablero(int[][]tablero) {
		for(int fila=0;fila<tablero.length;fila++) {
			
			for(int columna = 0; columna<tablero.length;columna++) {
				
				tablero[fila][columna]=0;
				
			}
			
		}
	}
	
	
	
	/*
	 * 
	 * OBSOLETO
	 * Me indica cuantos '1' o "Reinas"
	 * se encuentran en el tablero
	 * */
	public static int cuantasReinasExisten(int[][]tablero) {
		
		int numeroReinas=0;
		
		for(int fila=0;fila<8;fila++) {
			
			for(int columna=0;columna<8;columna++) {
				
				if(tablero[fila][columna]==1) {
					
					numeroReinas++;
					
				}
				
			}
			
		}
		
		return numeroReinas;
		
	}
	
	
	
	
	/*
	 * OBSOLETO
	 * Verifico cuantos ceros hay
	 * Si hay mas de un cero significa que aun hay espacio
	 * 
	 * */
	public static boolean verificarEspacioTablero(int[][] tablero) {
		int cero=0;
		
		for(int fila=0;fila<tablero.length;fila++) {
			
			for(int columna=0;columna<tablero.length;columna++) {
				
				if(tablero[fila][columna]==0) {
					
					cero++;
					
				}

				
			}
			
		}
		
		if(cero==0) {
			
			return false;
			
		}
		
		else {
			
			return true;
			
		}
		
	}
	

}
