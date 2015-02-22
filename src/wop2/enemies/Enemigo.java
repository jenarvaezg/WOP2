package wop2.enemies;

import wop2.items.Arma.TipoAtaque;
import wop2.items.Item;

public class Enemigo {
	
	private int saludMax;
	private int salud;
	private int daño;
	private int defensagolpe;
	private int defensacorte;
	private int resistencia;
	private int precision;
	private TipoAtaque tipoAtaque;
	private String nombre;
	private int dinero;
	private Item loot;
	
	
	
	public Enemigo(int saludMax, int daño, int precision, int defensagolpe,
			int defensacorte, int resistencia, TipoAtaque tipoAtaque,
			String nombre, int dinero, Item loot) {
		this.saludMax = saludMax;
		this.salud = saludMax;
		this.daño = daño;
		this.precision = precision;
		this.setDefensagolpe(defensagolpe);
		this.setDefensacorte(defensacorte);
		this.setResistencia(resistencia);
		this.tipoAtaque = tipoAtaque;
		this.nombre = nombre;
		this.dinero = dinero;
		this.loot = loot;
	}
	
		
	public int getSaludMax() {
		return saludMax;
	}
	public void setSaludMax(int saludMax) {
		this.saludMax = saludMax;
	}
	public int getSalud() {
		return salud;
	}
	public void setSalud(int salud) {
		this.salud = salud;
	}
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public TipoAtaque getTipoAtaque() {
		return tipoAtaque;
	}
	public void setTipoAtaque(TipoAtaque tipoAtaque) {
		this.tipoAtaque = tipoAtaque;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public Item getLoot() {
		return loot;
	}
	public void setLoot(Item loot) {
		this.loot = loot;
	}

	public int getDefensagolpe() {
		return defensagolpe;
	}

	public void setDefensagolpe(int defensagolpe) {
		this.defensagolpe = defensagolpe;
	}

	public int getDefensacorte() {
		return defensacorte;
	}

	public void setDefensacorte(int defensacorte) {
		this.defensacorte = defensacorte;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}


	public int getPrecision() {
		return precision;
	}


	public void setPrecision(int precision) {
		this.precision = precision;
	}
	
	public String stringSalud(){
		return "Salud: " + salud + "/" + saludMax +"(" + ((float)salud/saludMax)*100 + "%)";
	}

}
