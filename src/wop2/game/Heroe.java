package wop2.game;

import wop2.items.*;

public class Heroe {
	

	private String nombre;
	private Class clase;
	private int salud;
	private int fuerza;
	private int defensagolpe;
	private int defensacorte;
	private int resistencia;
	private int precision;
	private int magia;
	private int saludMax;
	private int dinero;
	private Arma arma;
	private Armadura armadura;
	private String genero;
	private Items[] inventario; //HACER GETTER
	
	public enum Class {
	    GUERRERO, MAGO, PICARO,
	}

	
	public Heroe(){
		System.out.println("penes");
	}
	
	
	/*public void subirNivel(Class clase){
		fuerza += clase.modFuerza;
		
	}*/
	
	
	public Heroe(String clase, String nombre, String genero){
		inventario = new Items[10];
		switch(clase){
		case "1":
			this.clase = Class.GUERRERO;
			defensagolpe = 30;
			defensacorte = 20;
			resistencia = 2;
			precision = 0;
			magia = 0;
			fuerza = 10;
			saludMax = 150;
			arma = new Arma(0, "Palo afilado", 3, 0, 0, Arma.TipoAtaque.CORTE);
			armadura = new Armadura(0, "Ropajes", 0, 1, 0);
			break;
		case "2":
			this.clase = Class.MAGO;
			magia = 10;
			defensagolpe = 5;
			defensacorte = 10;
			resistencia = 40;
			precision = 5;
			fuerza = 3;
			saludMax = 50;
			arma = new Arma(0, "Libro quemado", 4, 0, 0, Arma.TipoAtaque.MAGIA);
			armadura = new Armadura(0, "Ropajes", 0, 1, 0);
			break;
		case "3":
			this.clase = Class.PICARO;
			magia = 3;
			defensagolpe = 10;
			defensacorte = 15;
			resistencia = 15;
			precision = 10;
			fuerza = 6;
			saludMax = 100;
			arma = new Arma(0, "Cuchillo embotado", 3, 1, 2, Arma.TipoAtaque.CORTE);
			armadura = new Armadura(0, "Ropajes", 0, 1, 0);
			break;
		}
		System.out.println(inventario.length);
		inventario[5] = new Arma(0, "Cuchillo embotado", 3, 1, 2, Arma.TipoAtaque.CORTE);
		salud = saludMax;
		dinero = 100;//cambiar a 0
		this.nombre = nombre;
		this.genero = genero;
		
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getSaludMax() {
		return saludMax;
	}

	public void setSaludMax(int saludMax) {
		this.saludMax = saludMax;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public Class getClase() {
		return clase;
	}

	public void setClase(Class clase) {
		this.clase = clase;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Arma getArma() {
		return arma;
	}


	public void setArma(Arma arma) {
		this.arma = arma;
	}


	public Armadura getArmadura() {
		return armadura;
	}


	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
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


	public int getMagia() {
		return magia;
	}


	public void setMagia(int magia) {
		this.magia = magia;
	}


	public Items[] getInventario() {
		return inventario;
	}


	public void setInventario(Items[] inventario) {
		this.inventario = inventario;
	}


	public String toString(){
		String s = "Nombre: " + nombre + "\nClase: " + clase +", genero: " + genero + "\nSalud: " + salud + "/" + saludMax +"(" + ((float)salud/saludMax)*100 + "%)\n";
		s += "Estadisticas ofensivas:\n------\nFuerza: " + fuerza + "\nMagia: " + magia + "\nPrecision: " + precision + "\n\n";
		s += "Estadisticas defensivas:\n------\nGolpe: " + defensagolpe + "\nCorte: " + defensacorte + "\nResistencia magica: " + resistencia + "\n\n";
		s += "Equipo\n------\nArma: " + arma + "\nArmadura: " + armadura + "\n";
		s += "Inventario\n------\n";
		for(Items i: inventario){
			if(i != null)
				s += i + "\n";
		}
		s += "Dinero: " + dinero +"\n------\n";
		return s;
	}

}
