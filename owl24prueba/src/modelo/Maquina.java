package modelo;

public class Maquina {


	private int machid;
	private String nombre="";
	private String poblacion="";
	private String direccion1="";
	private int direccion2=0;
	private double rating=0.0;
	private String marca;

	public Maquina() {
		
	}
	
	
	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getMachid() {
		return machid;
	}

	public void setMachid(int machid) {
		this.machid = machid;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public int getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(int direccion2) {
		this.direccion2 = direccion2;
	}

	public String toString(){
		return this.machid+" "+this.nombre+" "+this.poblacion+" "+this.direccion1+" "+this.direccion2;
	}

}

