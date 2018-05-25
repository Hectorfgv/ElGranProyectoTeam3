package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;



import modelo.Usuario;
import vista.Gracias;

import vista.LogIn;
import vista.Register;

public class OpcionesUsuario {
	
		private int userid;
		private boolean admin=false;
		private String cuenta;
		private String nombre;
		private String apellido1;
		private String apellido2;
		private String edad;
		private String poblacion;
		private String email;
		private String pasword;
		private Connection conexion;
		private Statement orden = null;
		
		public OpcionesUsuario(java.sql.Connection conexion2) {
			this.conexion=(Connection) conexion2;
		}

		
		
		
			
			
			public boolean loginUsuarios(String cuenta, String pass){
				
				ResultSet rs;
				Usuario u=new Usuario();
				boolean log1=false;
				boolean log2=false;
				boolean logResult=false;
				try{
					orden = (Statement) conexion.createStatement();
			
				    String sql ="select cuenta, pasword FROM usuarios";
				    rs = orden.executeQuery(sql);
				    while(rs.next() && log1==false) {
				    	
				    String c=rs.getString("cuenta");
				    
				    if (c.compareTo(cuenta)==0) {
				    System.out.println("Esta bien usuario");
				    	log1=true;
				    	 String p=rs.getString("pasword");
						    if (p.compareTo(pass)==0) {
							    System.out.println("Esta bien contraseña");
							    	log2=true;
							    	
							    	
						    }
						    else
						    System.out.println("Esta mal contraseña");
						    logResult=false;

						    
						    if (log1 && log2)
						    {
						    	System.out.println("Autentificado con exito");
						    	logResult=true;
						    }
						   
				    }  	
				   
				    }if (log1==false) {
				    	System.out.println("Esta mal usuario");
				    	logResult=false;
				    	
				    	
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
				
				return logResult;
			
			}
			
public void registroUsuarios(String cuenta, String email, String pass){
				
				ResultSet rs;
				Usuario u=new Usuario();
				boolean log1=false;
				boolean log2=false;
				
				try{
					orden = (Statement) conexion.createStatement();
			
				    String sql ="select cuenta, email FROM usuarios";
				    rs = orden.executeQuery(sql);
				    while(rs.next() && log1==false) {
				    	
				    String c=rs.getString("cuenta");
				    
				    if (c.compareTo(cuenta)==0) {
				    	System.out.println("Usuario ya existe");
				    	log1=true;
				    	 String e=rs.getString("email");
						    if (e.compareTo(email)==0) {
							    	System.out.println("Email ya existe");
							    	log2=true;
						    }
				    }  	
				       
				 } 
			        // Patrón para validar el email
			        Pattern pattern = Pattern
			                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3})$");
			 
			        // El email a validar
			        String emailpr = email;
			 
			        Matcher mather = pattern.matcher(emailpr);
			 
			        if (mather.find() == true && (log1==false) && (log2==false)) {
			        	
			        		JOptionPane.showMessageDialog(null, "Thank you!");

			        		LogIn L1 =new LogIn();
			        		L1.setVisible(true);

					  	orden = (Statement) conexion.createStatement();
					  String sql2 = "INSERT INTO usuarios (cuenta,email,pasword) " +
					             "VALUES ('"+cuenta+"', '"+email+"', '"+pass+"')";
					  orden.executeUpdate(sql2);
			            
			        } else {
			        	JOptionPane.showMessageDialog(null, "Invalid mail");
			           
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
		
			
/*ARREGLAR METODO USSER SETTINGS*/
			/*ARREGLAR METODO USSER SETTINGS*/
			/*ARREGLAR METODO USSER SETTINGS*/
			/*ARREGLAR METODO USSER SETTINGS*/
/*
public void ActualizaNombreUsuarios(String nombreNuevo, String nombreActual){
	ResultSet rs;
	Usuario u=new Usuario();
	boolean log1=false;
	
	
	try{
		orden = (Statement) conexion.createStatement();

	    String sql ="select cuenta FROM usuarios";
	    rs = orden.executeQuery(sql);
	    while(rs.next() && log1==false) {
	    	
	    String c=rs.getString("cuenta");
	    
	    if (c.compareTo(nombreNuevo)==1) {
	    	System.out.println("Usuario ya existe");
	    	log1=true;
	    	orden = (Statement) conexion.createStatement();
			  String sql2 = "MODIFY usuarios (cuenta) " +
			             "VALUES ('"+nombreNuevo+"')";;
			    }
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
	
}*/
}