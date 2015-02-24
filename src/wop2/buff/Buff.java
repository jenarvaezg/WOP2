package wop2.buff;

import wop2.buff.Buff;
//import wop2.game.Heroe;

public class Buff {
	private String nombre;
	private TipoBuffo buffo;
	private int initstat;
	private int potencia;
	
	public enum TipoBuffo{
		SALUD, FUERZA, MAGIA, DEFGOLPE, DEFCORTE, RESISTENCIA, PRECISION, NADA,
	}
	
	public int hashCode (Buff.TipoBuffo buffo){
		switch (buffo){
		case SALUD:
			return "SALUD".hashCode();
		case FUERZA:
			return "FUERZA".hashCode();
		case MAGIA:
			return "MAGIA".hashCode();
		case DEFGOLPE:
			return "DEFGOLPE".hashCode();
		case DEFCORTE:
			return "DEFCORTE".hashCode();
		case RESISTENCIA:
			return "RESISTENCIA".hashCode();
		case PRECISION:
			return "PRECISION".hashCode();
		case NADA:
			return "NADA".hashCode();
		default:
			return 0;
		}
	}
	
	public int hashCode(){
		int hash = 0;
		hash += hashCode(buffo);
		hash -= nombre.hashCode();
		hash += potencia*47;
		return hash;
	}
	
	public Buff (String buffo, String nombre, int potencia /*, Heroe heroe*/){
		this.nombre = nombre;
		this.potencia = potencia;
		switch(buffo){
		case "1":
			this.buffo = TipoBuffo.SALUD;
			/*setInitstat(heroe.getSalud());
			heroe.setSalud(heroe.getSalud() + potencia);*/
			break;
		case "2":
			this.buffo = TipoBuffo.FUERZA;
			/*setInitstat(heroe.getFuerza());
			heroe.setFuerza(heroe.getFuerza() + potencia);*/
			break;
		case "3":
			this.buffo = TipoBuffo.MAGIA;
			/*setInitstat(heroe.getMagia());
			heroe.setMagia(heroe.getMagia() + potencia);*/
			break;
		case "4":
			this.buffo = TipoBuffo.DEFGOLPE;
			/*setInitstat(heroe.getDefensagolpe());
			heroe.setDefensagolpe(heroe.getDefensagolpe() + potencia);*/
			break;
		case "5":
			this.buffo = TipoBuffo.DEFCORTE;
			/*setInitstat(heroe.getDefensacorte());
			heroe.setDefensacorte(heroe.getDefensacorte() + potencia);*/
			break;
		case "6":
			this.buffo = TipoBuffo.RESISTENCIA;
			/*setInitstat(heroe.getResistencia());
			heroe.setResistencia(heroe.getResistencia() + potencia);*/
			break;
		case "7":
			this.buffo = TipoBuffo.PRECISION;
			/*setInitstat(heroe.getPrecision());
			heroe.setPrecision(heroe.getPrecision() + potencia);*/
			break;
		case "8":
			this.buffo = TipoBuffo.NADA;
			break;
		}
	}
	
	public Buff(){
		;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoBuffo getBuffo() {
		return buffo;
	}

	public void setBuffo(TipoBuffo buffo) {
		this.buffo = buffo;
	}
	
	public void setBuffo(String b){
		switch(b){
		case "SALUD":
			this.buffo = TipoBuffo.SALUD;
			break;
		case "FUERZA":
			this.buffo = TipoBuffo.FUERZA;
			break;
		case "MAGIA":
			this.buffo = TipoBuffo.MAGIA;
			break;
		case "DEFGOLPE":
			this.buffo = TipoBuffo.DEFGOLPE;
			break;
		case "DEFCORTE":
			this.buffo = TipoBuffo.DEFCORTE;
			break;
		case "RESISTENCIA":
			this.buffo = TipoBuffo.RESISTENCIA;
			break;
		case "PRECISION":
			this.buffo = TipoBuffo.PRECISION;
			break;
		case "NADA":
			this.buffo = TipoBuffo.NADA;
			break;
		}
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

