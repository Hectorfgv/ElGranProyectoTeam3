package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	private String host; 
	private String bbdd; 
	private String user; 
	private String pass; 
	private String url;
	                    
	private Connection conexion = null;
	
		
	public Conexion(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	public boolean connectDB(){
		try{
			
			Class.forName(CONTROLADOR_MYSQL);
			conexion = (Connection) DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
			return false;
        }
		catch( ClassNotFoundException noEncontroClase){
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Connection getConexion(){
		return this.conexion;
	}


}
