package wop2.game;

public class Heroe {
	
	private int salud;
	private int fuerza;
	private int saludMax;
	private int dinero;
	private Class clase;
	private String nombre;
	//private Item[] inventario;
	
	public enum Class {
	    GUERRERO, MAGO, PICARO 
	}
	
	public Heroe(int n, String nombre){
		switch(n){
		case 1:
			clase = Class.GUERRERO;
			break;
		case 2:
			clase = Class.MAGO;
			break;
		case 3:
			clase = Class.PICARO;
			break;
		}
		saludMax = 100;
		salud = saludMax;
		dinero = 0;
		fuerza = 10;
		
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


}
