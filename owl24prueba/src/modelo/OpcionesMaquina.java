package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class OpcionesMaquina {
	
	private int machid;
	private String nombre;
	private String poblacion;
	private String direccion1;
	private String direccion2;
	private Connection conexion;
	private Statement orden = null;
	
	public OpcionesMaquina(java.sql.Connection conexion2) {
		this.conexion=(Connection) conexion2;
	}
	
	public void insertarMaquina(String nombre,String poblacion,String direccion1,String direccion2){
		try{
			orden = (Statement) conexion.createStatement();
		    String sql = "INSERT INTO maquinas (nombre,poblacion,direccion1,direccion2) " +
		                   "VALUES ('"+nombre+"', '"+poblacion+"', '"+direccion1+"', '"+direccion2+"')";
		    orden.executeUpdate(sql);
		    System.out.println("Usuario registrado con exito");
		    
		   }catch(SQLException se){
			     
			      se.printStackTrace();
		   }catch(Exception e){
			     
			      e.printStackTrace();
		   }finally{
			      
			      try{
			         if(orden!=null)
			        	 conexion.close();
			      }catch(SQLException se){
			    	  se.printStackTrace();
			      }
			      try{
			         if(conexion!=null)
			        	 conexion.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      }
			}
	}

}
