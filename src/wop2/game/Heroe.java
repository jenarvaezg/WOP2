package wop2.game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import wop2.items.*;
import wop2.items.Arma.TipoAtaque;

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
	private float dinero;
	private Arma arma;
	private Armadura armadura;
	private String genero;
	private Item[] inventario; //HACER GETTER
	private int contadorbuffo;
	
	
	public enum Class {
	    GUERRERO, MAGO, PICARO,
	}

	
	
	/*public void subirNivel(Class clase){
		fuerza += clase.modFuerza;
		
	}*/
	
	
	public Heroe(String clase, String nombre, String genero){
		inventario = new Item[10];
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
		salud = saludMax;
		dinero = 0f;//cambiar a 0
		this.nombre = nombre;
		this.genero = genero;
		
	}
	
	public int hashCode(){
		int sumahashes = 0;
		sumahashes += getNombre().hashCode();
		sumahashes -= getClase().hashCode();
		sumahashes += getSalud()*2;
		sumahashes -= getFuerza()*3;
		sumahashes += getDefensacorte()*4;
		sumahashes -= getDefensagolpe()*5;
		sumahashes += getResistencia()*6;
		sumahashes -= getPrecision()*7;
		sumahashes += getMagia()*8;
		sumahashes -= getSaludMax()*9;
		sumahashes -= getDinero();
		sumahashes += getPrecioArma()*2;
		sumahashes -= getAtaqueArma()*3;
		sumahashes += getTipoAtaque().hashCode();
		sumahashes -= getPrecisionArma()*4;
		sumahashes += getCriticoArma()*5;
		sumahashes -= getPrecioArmadura()*6;
		sumahashes += getNombreArmadura().hashCode();
		sumahashes -= getNombre().hashCode();
		sumahashes += getDefensacorteArmadura()*7;
		sumahashes -= getDefensagolpeArmadura()*8;
		sumahashes += getResistenciaArmadura()*9;
		sumahashes -= getGenero().hashCode();
		return sumahashes;		
	}
	
	public Heroe(String fichero) throws FileNotFoundException {
		Scanner lector;
		lector = new Scanner(new FileReader(fichero));
		nombre = lector.nextLine();
		setClase(lector.nextLine());
		salud = Integer.parseInt(lector.nextLine());
		fuerza = Integer.parseInt(lector.nextLine());
		defensagolpe = Integer.parseInt(lector.nextLine());
		defensacorte = Integer.parseInt(lector.nextLine());
		resistencia = Integer.parseInt(lector.nextLine());
		precision = Integer.parseInt(lector.nextLine());
		magia = Integer.parseInt(lector.nextLine());
		saludMax = Integer.parseInt(lector.nextLine());
		dinero = Integer.parseInt(lector.nextLine());
		arma = new Arma();
		arma.setPrecio(Integer.parseInt(lector.nextLine()));
		arma.setNombre(lector.nextLine());
		arma.setAtaque(Integer.parseInt(lector.nextLine()));
		arma.setTipo(lector.nextLine());
		arma.setPrecision(Integer.parseInt(lector.nextLine()));
		arma.setPrecision(Integer.parseInt(lector.nextLine()));
		armadura = new Armadura();
		armadura.setPrecio(Integer.parseInt(lector.nextLine()));
		armadura.setNombre(lector.nextLine());
		armadura.setDefensaCorte((Integer.parseInt(lector.nextLine())));
		armadura.setDefensaGolpe((Integer.parseInt(lector.nextLine())));
		armadura.setResistencia((Integer.parseInt(lector.nextLine())));
		genero = lector.nextLine();
		lector.close();
		if(Integer.parseInt(lector.nextLine()) != hashCode())
			throw new RuntimeException();
		inventario = new Item[10];
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

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public Class getClase() {
		return clase;
	}

	public void setClase(Class clase) {
		this.clase = clase;
	}
	
	public void setClase(String s){
		switch(s){
		case "GUERRERO":
			clase = Class.GUERRERO;
			break;
		case "MAGO":
			clase = Class.MAGO;
			break;
		case "PICARO":
			clase = Class.PICARO;
			break;
		}
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


	public Item[] getInventario() {
		return inventario;
	}
	
	
	public int getAtaqueArma(){
		return arma.getAtaque();
	}
	
	public int getPrecisionArma(){
		return arma.getPrecision();
	}
	
	public int getCriticoArma(){
		return arma.getCritico();
	}
	
	public TipoAtaque getTipoAtaque(){
		return arma.getTipo();
	}


	public void setInventario(Item[] inventario) {
		this.inventario = inventario;
	}
	
	public String stringSalud(){
		return + salud + "/" + saludMax +"(" + ((float)salud/saludMax)*100 + "%)";
	}


	public String toString(){
		String s = "Nombre: " + nombre + "\nClase: " + clase +", genero: " + genero + "\nSalud: "+stringSalud()+"\n";
		s += "Estadisticas ofensivas:\n------\nFuerza: " + fuerza + "\nMagia: " + magia + "\nPrecision: " + precision + "% \n\n";
		s += "Estadisticas defensivas:\n------\nGolpe: " + defensagolpe + "\nCorte: " + defensacorte + "\nResistencia magica: " + resistencia + "\n\n";
		s += "Equipo\n------\nArma: " + arma + "\nArmadura: " + armadura + "\n";
		s += "Inventario\n------\n";
		for(Item i: inventario){
			if(i != null)
				s += i + "\n";
		}
		s += "Dinero: " + dinero +"\n------\n";
		return s;
	}

	public int getPrecioArma() {
		return arma.getPrecio();
	}

	public String getNombreArma() {
		return arma.getNombre();
	}

	public int getPrecioArmadura() {
		return armadura.getPrecio();
	}

	public String getNombreArmadura() {
		return armadura.getNombre();
	}

	public int getDefensacorteArmadura() {
		return armadura.getDefensaCorte();
	}

	public int getDefensagolpeArmadura() {
		return armadura.getDefensaGolpe();
	}

	public int getResistenciaArmadura() {
		return armadura.getResistencia();
	}

	public int getContadorbuffo() {
		return contadorbuffo;
	}

	public void setContadorbuffo(int contadorbuffo) {
		this.contadorbuffo = contadorbuffo;
	}

}
