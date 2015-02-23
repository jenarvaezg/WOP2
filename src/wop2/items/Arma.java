package wop2.items;


public class Arma extends Item {
	
	private int precio;
	private String nombre;
	private int ataque;
	private TipoAtaque tipo;
	private int precision;
	private int critico;
		//hacer en otro momento tipos enumerados para elementos
		//hacer atributo para el intervalo de las armas
	
	public enum TipoAtaque{
		CORTE, GOLPE, MAGIA,
	}
	
	public Arma(int precio, String nombre, int ataque, int precision, int critico, TipoAtaque tipo){
		this.precio = precio;
		this.nombre = nombre;
		this.ataque = ataque;
		this.precision = precision;
		this.critico = critico;
		this.setTipo(tipo);
	}

	public Arma() {
		;
	}

	@Override
	public int getPrecio() {
		return precio;
	}
	

	@Override
	public void setPrecio(int precio) {
		this.precio = precio;	
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}
	
	public int getCritico() {
		return critico;
	}

	public void setCritico(int critico) {
		this.critico = critico;
	}

	public TipoAtaque getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtaque tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "[Nombre: " + nombre + ", precio de venta: " + precio + ", ataque: "
				+ ataque + ", precision: " + precision + "%, critico: " + critico + ", tipo: " + tipo  
				 + "]";
	}

	public void setTipo(String s) {
		switch(s){
		case "GOLPE":
			tipo = TipoAtaque.GOLPE;
			break;
		case "CORTE":
			tipo = TipoAtaque.CORTE;
			break;
		case "MAGIA":
			tipo = TipoAtaque.MAGIA;
			break;
		}
		// TODO Auto-generated method stub
		
	}

}
