package wop2.combat;

import java.util.Random;
import java.util.Scanner;

import wop2.enemies.Enemigo;
import wop2.game.Heroe;
import wop2.game.Main;

public class Combat {
	
	
	private static final int precisionbase = 60;
	
	private static Random semilla;
	
	private static int dañoheroe;
	private static int precisionheroe;
	private static int precisionenemigo;
	private static int dañoenemigo;
	
	public enum ResultadoCombate{
		VICTORIA, DERROTA, HUIDA,
	}
	
	public static void turnoJugador(Heroe heroe, Enemigo enemigo){
		if(semilla.nextInt(101) > precisionheroe){//fallas
			if(semilla.nextInt(2) == 1){
				System.out.println("Tu enemigo ha esquivado el golpe");
			}else{
				System.out.println("Has fallado el golpe");
			}
		}else{
			if(semilla.nextInt(101) < heroe.getCriticoArma()){
				System.out.println("CRITICO!!!!11! INFLIGES: " + dañoheroe*2 + " puntos de daño");
				enemigo.setSalud(enemigo.getSalud() - dañoheroe*2);
			}else{
				System.out.println("Golpeas a tu enemigo y le infliges: " + dañoheroe +" puntos de daño");
				enemigo.setSalud(enemigo.getSalud() - dañoheroe);
			}
		}
		
	}
	
	
	private static void turnoEnemigo(Heroe heroe, Enemigo enemigo) {
		if(semilla.nextInt(101) > precisionenemigo){
			if(semilla.nextInt(2) == 1){
				System.out.println("Has esquivado el golpe");
			}else{
				System.out.println("Tu enemigo ha fallado el golpe");
			}
		}else{
			System.out.println("Tu enemigo te golpea y te inflige: " + dañoenemigo +" puntos de daño");
			heroe.setSalud(heroe.getSalud() - dañoenemigo);
		}
	}
	
	private static void getStats(Heroe heroe, Enemigo enemigo){
		precisionheroe = precisionbase + heroe.getPrecision() + heroe.getPrecisionArma();
		precisionenemigo = precisionbase + enemigo.getPrecision();
		switch(heroe.getTipoAtaque()){
		case GOLPE:
			dañoheroe = heroe.getAtaqueArma() + heroe.getFuerza() - enemigo.getDefensagolpe();			
			break;
		case CORTE:
			dañoheroe = heroe.getAtaqueArma() + heroe.getFuerza() - enemigo.getDefensacorte();
			break;			
		case MAGIA:
			dañoheroe = heroe.getAtaqueArma() + heroe.getMagia() - enemigo.getResistencia();
		}
		if(dañoheroe < 0)
			dañoheroe = 0;
		switch(enemigo.getTipoAtaque()){
		case GOLPE:
			dañoenemigo = enemigo.getDaño() - heroe.getDefensagolpe();			
			break;
		case CORTE:
			dañoenemigo = enemigo.getDaño() - heroe.getDefensacorte();
			break;			
		case MAGIA:
			dañoenemigo = enemigo.getDaño() - heroe.getResistencia();
		}
		if(dañoenemigo < 0)
			dañoenemigo = 0;
	}
	
	public static ResultadoCombate Combatir(Heroe heroe, Enemigo enemigo, Scanner reader){
		System.out.println("LUCHA CONTRA:  " + enemigo.getNombre());
		semilla = new Random();
		getStats(heroe, enemigo);
		boolean salir = false;
		do{
			System.out.println("Tu salud: " + heroe.stringSalud());
			System.out.println("Salud del enemigo " + enemigo.stringSalud());
			Main.printThisAndPrompt("1) Atacar\n2) Huir");
			switch(reader.nextLine()){
			case "1":
				turnoJugador(heroe, enemigo);
				if(enemigo.getSalud() > 0){
					turnoEnemigo(heroe, enemigo); //SEGUIR GOLPEANDO AL CADAVER
				}else{
					salir = true;
				}
				if(heroe.getSalud() < 0){
					System.out.println(enemigo.getNombre() + " te ha asesinado. Pierdes " + (int)heroe.getDinero()*0.30 + " bitcoin");
					heroe.setDinero((int)((float)heroe.getDinero() - (float)heroe.getDinero()*0.30));
					heroe.setSalud(heroe.getSaludMax());
					return ResultadoCombate.DERROTA;
				}					
				break;
			case "2":
				System.out.println("Huyes del combate y pierdes " + (int)heroe.getDinero()*0.15 + " bitcoins");
				heroe.setDinero((int)((float)heroe.getDinero() - (float)heroe.getDinero()*0.15));
				return ResultadoCombate.HUIDA;
			default:
				System.out.println("Comando erróneo");
			}
		}while(!salir);
		System.out.println("Has logrado derrotar a " + enemigo.getNombre() + " y obtienes " + enemigo.getDinero() + " bitcoin");
		heroe.setDinero(heroe.getDinero() + enemigo.getDinero());
		if(enemigo.getLoot() != null){
			System.out.println("Además has conseguido: " + enemigo.getLoot());
			//HACER METODO ADDITEM
		}
		return ResultadoCombate.VICTORIA;
	}



}
