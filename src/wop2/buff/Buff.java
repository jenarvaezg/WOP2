package wop2.buff;

import wop2.buff.Buff;
import wop2.game.Heroe;

public class Buff {
	private String nombre;
	private Buffo buffo;
	private int initstat;
	private int potencia;
	
	public enum Buffo{
		SALUD, FUERZA, MAGIA, DEFGOLPE, DEFCORTE, RESISTENCIA, PRECISION, NADA,
	}
	
	public Buff (String buffo, String nombre, int potencia, Heroe heroe){
		this.nombre = nombre;
		this.potencia = potencia;
		switch(buffo){
		case "1":
			this.buffo = Buffo.SALUD;
			setInitstat(heroe.getSalud());
			heroe.setSalud(heroe.getSalud() + potencia);
			break;
		case "2":
			this.buffo = Buffo.FUERZA;
			setInitstat(heroe.getFuerza());
			heroe.setFuerza(heroe.getFuerza() + potencia);
			break;
		case "3":
			this.buffo = Buffo.MAGIA;
			setInitstat(heroe.getMagia());
			heroe.setMagia(heroe.getMagia() + potencia);
			break;
		case "4":
			this.buffo = Buffo.DEFGOLPE;
			setInitstat(heroe.getDefensagolpe());
			heroe.setDefensagolpe(heroe.getDefensagolpe() + potencia);
			break;
		case "5":
			this.buffo = Buffo.DEFCORTE;
			setInitstat(heroe.getDefensacorte());
			heroe.setDefensacorte(heroe.getDefensacorte() + potencia);
			break;
		case "6":
			this.buffo = Buffo.RESISTENCIA;
			setInitstat(heroe.getResistencia());
			heroe.setResistencia(heroe.getResistencia() + potencia);
			break;
		case "7":
			this.buffo = Buffo.PRECISION;
			setInitstat(heroe.getPrecision());
			heroe.setPrecision(heroe.getPrecision() + potencia);
			break;
		case "8":
			break;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Buffo getBuffo() {
		return buffo;
	}

	public void setBuffo(Buffo buffo) {
		this.buffo = buffo;
	}

	public int getInitstat() {
		return initstat;
	}

	public void setInitstat(int initstat) {
		this.initstat = initstat;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

}

