package wop2.items;

public class Armadura extends Item {
	
	private int precio;
	private String nombre;
	private int defensacorte;
	private int defensagolpe;
	private int resistencia;
	
	
	public Armadura(int precio, String nombre, int defensacorte, int defensagolpe, int resistencia) {
		this.precio = precio;
		this.nombre = nombre;
		this.defensacorte = defensacorte;
		this.defensagolpe = defensagolpe;
		this.resistencia = resistencia;
	}

	
	public Armadura() {
		;
	}


	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDefensaCorte() {
		return defensacorte;
	}
	public void setDefensaCorte(int defensacorte) {
		this.defensacorte = defensacorte;
	}
	public int getDefensaGolpe() {
		return defensagolpe;
	}
	public void setDefensaGolpe(int defensagolpe) {
		this.defensagolpe = defensagolpe;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}


	@Override
	public String toString() {
		return "[Nombre: " + nombre + ", precio: " + precio
				+ ", defensa corte: " + defensacorte + ", defensa golpe: "
				+ defensagolpe + ", resistencia: " + resistencia + "]";
	}
	
	



}
