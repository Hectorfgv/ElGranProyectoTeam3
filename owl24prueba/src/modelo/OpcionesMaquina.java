package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import modelo.Maquina;
import vista.ventana2;

public class OpcionesMaquina {
	
	private int machid;
	private String nombre;
	private String poblacion;
	private String direccion1;
	private String direccion2;
	private double rating;
	private String marca;
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
	public void mostrarMaquinas(String a){
		
		
		ResultSet rs;
		Maquina m1 = new Maquina();
		try{
			
			orden = (Statement) conexion.createStatement();
	
		    String sql = "SELECT * FROM maquinas WHERE marca LIKE'"+a+"'+ ORDER BY marca,poblacion";
		    rs = orden.executeQuery(sql);
		    
		    while(rs.next()){
		    	 m1.setPoblacion(rs.getString("poblacion"));
		    	 m1.setRating(rs.getDouble("marca"));
    
		    }
		   
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
	
	public void filtarMaquinas(String item, String busqueda) {
		ResultSet rs;
		Maquina m1=new Maquina();
		int cont =0;
		try{
			orden = (Statement) conexion.createStatement();
			String sql = "SELECT  poblacion, marca, rating, nombre, direccion1, direccion2 FROM maquinas WHERE "+ item +"= '"+busqueda +"' ORDER BY rating DESC";
			rs = orden.executeQuery(sql);
			
			while(rs.next()) {
				
					 
					 m1.setNombre(rs.getString("nombre"));
					 m1.setPoblacion(rs.getString("poblacion"));
					 m1.setMarca(rs.getString("marca"));
					 m1.setDireccion1(rs.getString("direccion1"));
					 m1.setDireccion2(rs.getInt("direccion2"));
					 m1.setRating(rs.getDouble("rating"));
						
					 cont ++;
					 System.out.println("Nombre:" +m1.getNombre()+", Población:"+m1.getPoblacion()+", Calle/Av:"+m1.getDireccion1()+", Número:"+m1.getDireccion2()+", Marca:"+m1.getMarca()+" y Puntuación:"+m1.getRating()+"\n");
			}
			System.out.println(cont);
		   
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
