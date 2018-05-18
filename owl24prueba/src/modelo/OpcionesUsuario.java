package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import modelo.Usuario;

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
		
		public void insertarUsuario(String nombre,String email,String pasword){
			try{
				orden = (Statement) conexion.createStatement();
			    String sql = "INSERT INTO usuarios (cuenta,email,pasword) " +
			                   "VALUES ('"+nombre+"', '"+email+"', '"+pasword+"')";
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
		
		
		
			
			
			public void loginUsuarios(String cuenta, String pass){
				
				ResultSet rs;
				Usuario u=new Usuario();
				boolean log1=false;
				boolean log2=false;
				
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
						    
						    if (log1 && log2)
						    {
						    	System.out.println("Autentificado con éxito");
						    }
						   
				    }  	
				   
				    }if (log1==false) {
				    	System.out.println("Esta mal usuario");
				    	
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
			            System.out.println("El email ingresado es válido.");
			            
					  	orden = (Statement) conexion.createStatement();
					  String sql2 = "INSERT INTO usuarios (cuenta,email,pasword) " +
					             "VALUES ('"+cuenta+"', '"+email+"', '"+pass+"')";
					  orden.executeUpdate(sql2);
			            
			        } else {
			            System.out.println("El email ingresado es inválido.");
			        }
				
				 JOptionPane.showMessageDialog(null, "Sucessfully registered");
				 
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
