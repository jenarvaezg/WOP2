package wop2.game;

import java.util.Scanner;

import wop2.items.*;

public class Game {
	
	private Scanner reader = new Scanner(System.in);
	private static String prompt = "->";
	private Heroe heroe;
	
	private void printIntro(){
		System.out.println("#HISTORIA#");//TO-DO
	}
	
	private static void printThisAndPrompt(String s){
		System.out.println(s);
		System.out.print(prompt);
	}
	
	public Game(){
		boolean ok = false;
		String clase = null; 
		do{
			try{
				printThisAndPrompt("Escoge una clase:\n1) Guerrero\n2) Mago\n3) Picaro");
				clase = reader.nextLine();
				Integer.parseInt(clase);
				ok = true;
			}catch(NumberFormatException e){
				System.out.println("Eres un cachondo");
			}	
		}while(!ok);
		printThisAndPrompt("Escribre tu nombre");
		String name = reader.nextLine();
		printThisAndPrompt("Escribe tu genero");
		heroe = new Heroe(clase, name, reader.nextLine());
		printIntro();
	}
	
	public Game(String fichero){
		System.out.println("IN_DEV");;//TO-DO
	}
	
	private void arena(){
		;//TODO
	}

	private void tienda(){ //hacer clase tiendo
		System.out.println("Bienvenido a la tienda");//AGREGAR BUFFOS
		boolean salir = false;
		do{
			printThisAndPrompt("1) Comprar \n2) Vender\n3) Salir");
			switch(reader.nextLine()){
			case "1":
				switch(heroe.getClase()){
				case GUERRERO:
					printThisAndPrompt("1) Espada de piedra (15 bitcoins)\n2) Maza de madera (27 bitcoins)\n3) Malla oxidada (52 bitcoins)\n4) Salir");
					switch(reader.nextLine()){
					case "1":
						if(heroe.getDinero() >= 15){
							heroe.setDinero(heroe.getDinero() -15);
							heroe.setArma(new Arma(15/2, "Espada de piedra", 7, 2, 1, Arma.TipoAtaque.CORTE));
							System.out.println("Obtienes: Espada de piedra");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "2":
						if(heroe.getDinero() >= 27){
							heroe.setDinero(heroe.getDinero() - 27);
							heroe.setArma(new Arma(27/2, "Maza de madera", 10, 0, 0, Arma.TipoAtaque.GOLPE));
							System.out.println("Obtienes: Maza de madera");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "3":
						if(heroe.getDinero() >= 52){
							heroe.setArmadura(new Armadura(52/2, "Malla oxidada", 20, 10, 0));
							System.out.println("Obtienes: Espada de piedra");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "4":
						salir = true;
						break;
					default:
						System.out.println("Comando incorrecto");
						break;
					}
					break;
				case MAGO:
					printThisAndPrompt("1) Baston de chopo (30 bitcoins)\n2) Varita rota (20 bitcoins)\n3) Tunica usada (10 bitcoins)\n4) Salir");
					switch(reader.nextLine()){
					case "1":
						if(heroe.getDinero() >= 30){
							heroe.setDinero(heroe.getDinero() - 30);
							heroe.setArma(new Arma(30/2, "Baston de chopo", 4, 0, 1, Arma.TipoAtaque.GOLPE));
							System.out.println("Obtienes: Baston de chopo");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "2":
						if(heroe.getDinero() >= 20){
							heroe.setDinero(heroe.getDinero() - 20);
							heroe.setArma(new Arma(15/2, "Varita rota", 7, 5, 0, Arma.TipoAtaque.MAGIA));
							System.out.println("Obtienes: Varita rota");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "3":
						if(heroe.getDinero() >= 10){
							heroe.setDinero(heroe.getDinero() - 10);
							heroe.setArmadura(new Armadura(10/2, "Tunica usada", 1, 2, 20));
							System.out.println("Obtienes: Tunica usada");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "4":
						salir = true;
						break;
					default:
						System.out.println("Comando incorrecto");
						break;
					}
					break;
				case PICARO:
					printThisAndPrompt("1) Daga doblada (8 bitcoins)\n2) Arco astillado (42 bitcoins)\n3) Peto ajado (30 bitcoins)\n4) Salir");
					switch(reader.nextLine()){
					case "1":
						if(heroe.getDinero() >= 8){
							heroe.setDinero(heroe.getDinero() - 8);
							heroe.setArma(new Arma(7/2, "Daga doblada", 7, 0, 0, Arma.TipoAtaque.CORTE));
							System.out.println("Obtienes: Daga doblada");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "2":
						if(heroe.getDinero() >= 42){
							heroe.setDinero(heroe.getDinero() - 42);
							heroe.setArma(new Arma(42/2, "Arco astillado", 12, 7, 5, Arma.TipoAtaque.CORTE));
							System.out.println("Obtienes: Espada de piedra");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "3":
						if(heroe.getDinero() >= 30){
							heroe.setDinero(heroe.getDinero() - 30);
							heroe.setArmadura(new Armadura(30/2, "Peto ajado", 10, 10, 5));
							System.out.println("Obtienes: Espada de piedra");//TODO
						}else{
							System.out.println("No tienes dinero, mangarrian");
						}
						break;
					case "4":
						salir = true;
						break;
					default:
						System.out.println("Comando incorrecto");
						break;
					}
				}
				break;
			case "2":
				System.out.println("AQUI VENDERIAS COSAS");
				break;
			case "3":
				System.out.println("Que le vaya a usted bien");
				salir = true;
				break;
			default:
				System.out.println("Comando invalido");
			}
		}while(!salir);
	}
	
	private void taberna(){
		System.out.println("Bienvenido a la taberna");//AGREGAR BUFFOS
		boolean salir = false;
		do{
			printThisAndPrompt("1) Descansar (30 Bitcoins)\n2) Salir");
			switch(reader.nextLine()){
			case "1":
				if(heroe.getDinero() < 30){
					System.out.println("Vuelve cuando tengas dinero, mangarrian");
					salir = true;
					//}else if(heroe.getSalud().equals(heroe.getSaludMax())){ aqui agregamos buffos chachis				
				}else{
					System.out.println("Te sientes en forma");
					heroe.setSalud(heroe.getSaludMax());
					heroe.setDinero(heroe.getDinero() - 30);
					salir = true;
				}
				break;
			case "2":
				System.out.println("Hasta luego cocodrilo");
				salir = true;
				break;
			default:
				System.out.println("Comando invalido");
			}
		}while(!salir);

	}
	
	private void escriba(){
		System.out.println("PROXIMAMENTE SE GUARDARA LA PARTIDA AQUI");//TODO
	}
	
	public void menu(){
		System.out.println("Empieza el juego!");
		boolean exit = false;
		do{
			printThisAndPrompt("1) Arena\n2) Tienda\n3) Taberna\n4) Escriba\n5) Status\n6) Salir");
			switch(reader.nextLine()){
			case "1":
				arena();
				break;
			case "2":
				tienda(); //ARREGLAR POR BULDU
				break;
			case "3":
				taberna(); //finiquitao menos buffos
				break;
			case "4":
				escriba(); //hacer, guarda partida
				break;
			case "5":
				System.out.println(heroe);
				break;
			case "6":
				System.out.println("Adios");
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
		String decision;
		System.out.println("World of Picky 2 Alpha 0.1\n---------------");
		Scanner readerMain = new Scanner(System.in);
		do{
			printThisAndPrompt("1) Nuevo\n2) Cargar\n3) Extras");
			decision = readerMain.nextLine();
			switch(decision){
			case "1":
				game = new Game();
				proceed = true;
				break;
			case "2":
				game = new Game("fichero");
				proceed = true;
				return;
				//break;
			case "3":
				printExtras();
				break;
			default:
				System.out.println("Comando inválido");
			}
		}while(!proceed);
		game.menu();
		readerMain.close();
	}

}
