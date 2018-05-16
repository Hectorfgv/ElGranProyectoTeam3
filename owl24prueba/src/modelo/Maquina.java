package modelo;

public class Maquina {


	private int machid;
	private String nombre="";
	private String poblacion="";
	private String direccion1="";
	private int direccion2=0;

	public Maquina() {
		
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

