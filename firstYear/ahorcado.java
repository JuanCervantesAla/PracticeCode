package ahorcado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ahorcado {

	public static void main(String[] args) throws IOException {
		//Lector para las letras
		InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader lectorBuffer = new BufferedReader (lector);
        //Lector para la opcion del menu
        Scanner opcionMenu = new Scanner(System.in);
		inicio(lectorBuffer,opcionMenu);
	}
	
	private static void inicio(BufferedReader lectorBuffer,Scanner opcionMenu){
		String[] medio= {"p","r","o","g","r","a","m","a","r"};
		String[] facil= {"c","u","c","e","i"};
		int opcionJugador;
		System.out.println("Hola este es el ahorcado: elije un nivel para comenzar"
				+ "\n1.Facil\n2.Medio\n3.Dificil");
		opcionJugador=opcionMenu.nextInt();
		switch(opcionJugador) {
			case 1:
				juego(lectorBuffer,facil);
				break;
			case 2:
				juego(lectorBuffer,medio);
				break;
			case 3:
				break;
			default:System.out.println("Esa opcion no existe");
		}
	}
	
	private static void juego(BufferedReader lectorBuffer,String[] palabra) {
		String [] auxiliar = new String[palabra.length];
		int a=0,vidas=5;
		String letra = null;
		for(int u=0;u<palabra.length;u++) {
			auxiliar[u]="_ ";
		}
		for(int e = 0; e<palabra.length;e++) {
			System.out.print("_ ");
		}
		do {
			System.out.println("\nIngresa la letra:");
			try {
				letra = lectorBuffer.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(palabra[a].equals(letra)) {
				auxiliar[a]=letra+" ";
				for(int i=0;i<palabra.length;i++) {
					if(auxiliar[i].equals("")) {
						System.out.print("_ ");
					}
					else {
						System.out.print(auxiliar[i]);
					}
				}
				a++;
			}
			else {
				vidas--;
				System.out.println("Te quedan "+vidas+" vidas, Vuelve a intentar");
			}
			if(vidas<5) {
				personaje(vidas);
			}
			System.out.println("\n********************************************");
		}while(a<palabra.length && vidas>0);
		if(vidas>0){
			System.out.println("\nGanaste");
		}
		else {
			System.out.println("\nPerdiste");
		}
	}
	
	private static void personaje(int vidas) {
		switch(vidas) {
		case 4:
			System.out.println("\n 0 ");
			break;
		case 3:
			System.out.println("\n 0 ");
			System.out.println(" | ");
			break;
		case 2:
			System.out.println("\n 0 ");
			System.out.println(" | ");
			System.out.println("/ ");
			break;
		case 1:
			System.out.println("\n 0 ");
			System.out.println(" | ");
			System.out.println("/ |");
			break;
		case 0:
			System.out.println("\n 0 ");
			System.out.println("-|- ");
			System.out.println("/ |");
			break;
		
		}
	}
}
