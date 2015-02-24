package wop2.combat;

import java.util.Random;
import java.util.Scanner;

import wop2.enemies.Enemigo;
import wop2.game.Heroe;
import wop2.game.Main;

public class Combat {
	
	
	private static final int precisionbase = 60;
	
	private static Random semilla;
	
	private static int damageheroe;
	private static int precisionheroe;
	private static int precisionenemigo;
	private static int damageenemigo;
	
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
				System.out.println("CRITICO!!!!11! INFLIGES: " + damageheroe*3 + " puntos de damage");
				enemigo.setSalud(enemigo.getSalud() - damageheroe*3);
			}else{
				System.out.println("Golpeas a tu enemigo y le infliges: " + damageheroe +" puntos de damage");
				enemigo.setSalud(enemigo.getSalud() - damageheroe);
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
			System.out.println("Tu enemigo te golpea y te inflige: " + damageenemigo +" puntos de damage");
			heroe.setSalud(heroe.getSalud() - damageenemigo);
		}
	}
	
	private static void setStatsBuff (Heroe heroe){
		switch (heroe.getTipoBuffo()){
			case SALUD:
				heroe.setSalud(heroe.getInitStatBuff());
				break;
			case FUERZA:
				heroe.setFuerza(heroe.getInitStatBuff());
				break;
			case MAGIA:
				heroe.setMagia(heroe.getInitStatBuff());
				break;
			case DEFGOLPE:
				heroe.setDefensagolpe(heroe.getInitStatBuff());
				break;
			case DEFCORTE:
				heroe.setDefensacorte(heroe.getInitStatBuff());
				break;
			case RESISTENCIA:
				heroe.setResistencia(heroe.getInitStatBuff());
				break;
			case PRECISION:
				heroe.setPrecision(heroe.getInitStatBuff());
				break;
			case NADA:
				break;
			default:
				break;
			}
		}
	
	
	private static void getStats(Heroe heroe, Enemigo enemigo){
		precisionheroe = precisionbase + heroe.getPrecision() + heroe.getPrecisionArma();
		precisionenemigo = precisionbase + enemigo.getPrecision();
		switch(heroe.getTipoAtaque()){
		case GOLPE:
			damageheroe = heroe.getAtaqueArma() + heroe.getFuerza() - enemigo.getDefensagolpe();			
			break;
		case CORTE:
			damageheroe = heroe.getAtaqueArma() + heroe.getFuerza() - enemigo.getDefensacorte();
			break;			
		case MAGIA:
			damageheroe = heroe.getAtaqueArma() + heroe.getMagia() - enemigo.getResistencia();
		}
		if(damageheroe < 0)
			damageheroe = 0;
		switch(enemigo.getTipoAtaque()){
		case GOLPE:
			damageenemigo = enemigo.getdamage() - heroe.getDefensagolpe();			
			break;
		case CORTE:
			damageenemigo = enemigo.getdamage() - heroe.getDefensacorte();
			break;			
		case MAGIA:
			damageenemigo = enemigo.getdamage() - heroe.getResistencia();
		}
		if(damageenemigo < 0)
			damageenemigo = 0;
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
					if(heroe.getSalud() <= 0){
						System.out.println(enemigo.getNombre() + " te ha asesinado. Pierdes " + heroe.getDinero()*0.30 + " bitcoin");
						heroe.setDinero((float) (heroe.getDinero() - (heroe.getDinero()*0.30)));
						heroe.setSalud(heroe.getSaludMax());
						setStatsBuff(heroe);
						return ResultadoCombate.DERROTA;
					}					
					break;
				case "2":
					System.out.println("Huyes del combate y pierdes " + (int)heroe.getDinero()*0.15 + " bitcoins");
					heroe.setDinero((float) ((float)heroe.getDinero() - (float)heroe.getDinero()*0.15));
					setStatsBuff(heroe);
					return ResultadoCombate.HUIDA;
				default:
					System.out.println("Comando erroneo");
				}
		}while(!salir);
		System.out.println("Has logrado derrotar a " + enemigo.getNombre() + " y obtienes " + enemigo.getDinero() + " bitcoin");
		heroe.setDinero(heroe.getDinero() + enemigo.getDinero());
		if(enemigo.getLoot() != null){
			System.out.println("Ademas has conseguido: " + enemigo.getLoot());
			//HACER METODO ADDITEM
		}
		setStatsBuff(heroe);
		return ResultadoCombate.VICTORIA;
	}



}
