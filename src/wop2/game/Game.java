package wop2.game;

import java.util.Scanner;

public class Game {
	
	private Scanner reader = new Scanner(System.in);
	private String prompt = "->";
	private Heroe heroe;
	
	private void printIntro(){
		System.out.println("#HISTORIA#");//TO-DO
	}
	
	public Game(){
		System.out.println("Escoge una clase:\n1) Guerrero\n2) Mago\3) Picaro\n" + prompt);
		int clase = reader.nextInt();
		System.out.println("Escribe tu nombre\n" + prompt);
		heroe = new Heroe(clase, reader.next());
		printIntro();
	}
	
	public Game(String fichero){
		System.out.println("IN_DEV");;//TO-DO
	}
	
	private void arena(){
		;//TODO
	}
	
	private void tienda(){
		;//TODO
	}
	
	private void taberna(){
		;//TODO
	}
	
	private void escriba(){
		System.out.println("PROXIMAMENTE SE GUARDARA LA PARTIDA AQUI");//TODO
	}
	
	public void menu(){
		System.out.println("Empieza el juego!");
		boolean exit = false; 
		do{
			System.out.println("1) Arena\n2) Tienda\3) Taberna\n4) Escriba\n5) Salir\n" + prompt);
			switch(reader.nextInt()){
			case 1:
				arena();
				break;
			case 2:
				tienda();
				break;
			case 3:
				taberna();
				break;
			case 4:
				escriba();
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Comando erróneo");
			
			}
		}while(!exit);
		reader.close();
	}
	
	public static void printExtras(){
		System.out.println("VACIO TODAVIA");//TO-DO
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean proceed = false;
		Game game = null;
		Scanner readermain = new Scanner(System.in);
		System.out.println("World of Picky 2 Alpha 0.1\n---------------");
		do{
			System.out.println("1) Nuevo\n2) Cargar\n3) Extras");
			System.out.print("->");
			switch(readermain.nextInt()){
			case 1:
				game = new Game();
				proceed = true;
				break;
			case 2:
				game = new Game("fichero");
				proceed = true;
				break;
			case 3:
				printExtras();
				break;
			default:
				System.out.println("Comando inválido");
			}
		}while(!proceed);
		readermain.close();
		game.menu();

	}

}
