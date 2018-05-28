package modelo;

import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import modelo.Maquina;
import vista.Inicio;

public class OpcionesMaquina {
	//Atributos
	/**
	 * Atributos de la clase OpcionesMaquina
	 * desde la clase Maquina
	 */
	private int machid;
	private String nombre;
	private String poblacion;
	private String direccion1;
	private String direccion2;
	private double rating;
	private String marca;
	private Connection conexion;
	private Statement orden = null;
	//M�todos
	/**
	 * M�todo para conexi�n con la clase Conexi�n
	 * @param conexion2
	 */
	public OpcionesMaquina(java.sql.Connection conexion2) {
		this.conexion=(Connection) conexion2;
	}
	/**
	 * M�todo para insertar M�quinas donde le pasamos cinco par�metros
	 * @param nombre
	 * @param poblacion
	 * @param direccion1
	 * @param direccion2
	 * @param marca
	 */
	public void insertarMaquina(String nombre,String poblacion,String direccion1,String direccion2, String marca){
		try{
			orden = (Statement) conexion.createStatement();
		    String sql = "INSERT INTO maquinas (nombre,poblacion,direccion1,direccion2,marca) " +
		                   "VALUES ('"+nombre+"', '"+poblacion+"', '"+direccion1+"', '"+direccion2+"','"+marca+"')";
		    orden.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Machine added succesfully");
		    
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
	
	/**
	 * M�todo para la b�squeda de m�quinas y mostrarlas por el JTextArea
	 * @param item
	 * @param busqueda
	 * @param jarea
	 */
	public void filtarMaquinas2(String item, String busqueda, JTextArea jarea) {
		ResultSet rs;
		Maquina m1=new Maquina();

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
						
					 jarea.setText(jarea.getText()+"Nombre:" +m1.getNombre()+", Poblaci�n:"+m1.getPoblacion()+", Calle/Av:"+m1.getDireccion1()+", N�mero:"+m1.getDireccion2()+", Marca:"+m1.getMarca()+" y Puntuaci�n:"+m1.getRating()+"\n"+"--------------------------->"+"\n");
					 
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
	/**
	 * M�todo para mostrar la lista de m�quinas existentes en la base de datos
	 * en el perfil de admin
	 * @param textArea
	 */
	public void mostrarMaquinas2(JTextArea textArea){
		
		
		ResultSet rs;
		Maquina m=new Maquina();
		try{
			
			orden = (Statement) conexion.createStatement();
	
		    String sql = "SELECT * FROM maquinas ORDER BY machid";
		    rs = orden.executeQuery(sql);
		    
		    while(rs.next()){
		    	 m.setMachid(rs.getInt("machid"));
		    	 m.setNombre(rs.getString("nombre"));
			     m.setDireccion1(rs.getString("direccion1"));
			     m.setDireccion2(rs.getInt("direccion2"));
			     m.setMarca(rs.getString("marca"));
			    
				 textArea.setText(textArea.getText()+"Nombre: " +m.getNombre()+", Direcci�n: "+m.getDireccion1()+"\n"+"N�mero: "+m.getDireccion2()+", ID: "+m.getMachid()+"\n"+"--------------------------->"+"\n");

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
		   }}
	/**
	 * El m�todo borrarM�quina borra las m�quinas de la base de datos
	 * desde el panel de admin
	 * @param id
	 */
		 public boolean borrarMaquina (int id){
						boolean eliminada=false;
						try{
							orden = (Statement) conexion.createStatement();
					
						    String sql = "DELETE FROM maquinas WHERE machid= " + " ("+id+")";
						    orden.executeUpdate(sql);
						    System.out.println("Maquina borrada con exito");
						    eliminada=true;
						   
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
					
		 return eliminada;
				 }
		   
	
}
