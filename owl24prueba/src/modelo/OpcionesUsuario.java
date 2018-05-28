package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.mysql.jdbc.PreparedStatement;

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
		private Statement orden2 = null;
		
		public OpcionesUsuario(java.sql.Connection conexion2) {
			this.conexion=(Connection) conexion2;
		}

		/*Metodo de LogIn de Ususarios*/
			
			public boolean loginUsuarios(String cuenta, String pass){
				
				ResultSet rs;
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
				    	log1=true;
				    	 String p=rs.getString("pasword");
						    if (p.compareTo(pass)==0) {
							    	log2=true;
							    	
							    	
						    }
						    else
						    logResult=false;

						    
						    if (log1 && log2)
						    {
						    	logResult=true;
						    }
						   
				    }  	
				   
				    }if (log1==false) {
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
		
		/* Metodo De Registro*/
			
			public void registroUsuarios(String cuenta, String email, String pass){
				
				ResultSet rs;
				boolean log1=false;
				boolean log2=false;
				
				try{
					orden = (Statement) conexion.createStatement();
			
				    String sql ="select cuenta, email FROM usuarios";
				    rs = orden.executeQuery(sql);
				    while(rs.next() && log1==false) {
				    	
				    String c=rs.getString("cuenta");
				    
				    if (c.compareTo(cuenta)==0) {
			        	JOptionPane.showMessageDialog(null, "Existing user");
			        	

				    	log1=true;
				    	 String e=rs.getString("email");
						    if (e.compareTo(email)==0) {
						    		JOptionPane.showMessageDialog(null, "Existing Mail");
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
			        	
			        		JOptionPane.showMessageDialog(null, "Thank you! Now you can Login & enjoy ");


					  	orden = (Statement) conexion.createStatement();
					  String sql2 = "INSERT INTO usuarios (cuenta,email,pasword) " +
					             "VALUES ('"+cuenta+"', '"+email+"', '"+pass+"')";
					  orden.executeUpdate(sql2);
			            
			        } else {
			        	JOptionPane.showMessageDialog(null, "Invalid mail \n example@example.com " );
			           
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
		
		/* Metodo Actualizar*/
			
			public void ActualizaNombreUsuarios(String cuenta1, String cuenta_nueva){
				
				ResultSet rs;
				boolean log1=false;
				
				try{
					orden = (Statement) conexion.createStatement();
				    String sql ="select cuenta FROM usuarios";

				    rs = orden.executeQuery(sql);
				    while(rs.next() && log1==false) {
				    String c=rs.getString("cuenta");
				    if (c.compareTo(cuenta1)==0) {
				    	
				    	
				    	PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(
				    		      "UPDATE usuarios SET cuenta = ? WHERE cuenta = ?");
				    		    ps.setString(1, cuenta_nueva);
				    		    ps.setString(2, rs.getString("cuenta"));
				    		    ps.executeUpdate();
				    		    ps.close();

				    		    JOptionPane.showMessageDialog(null, "Changes correctly saved!");
			           
			            
			            
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
		
		/* Cambio contraseña */
			public void ActualizaPassUsuarios(String cuenta1, String pass){
				
				ResultSet rs;
				boolean log1=false;
				
				try{
					orden = (Statement) conexion.createStatement();
				    String sql ="select cuenta FROM usuarios";

				    rs = orden.executeQuery(sql);
				    while(rs.next() && log1==false) {
				    String c=rs.getString("cuenta");
				    if (c.compareTo(cuenta1)==0) {
				    	
				    	
				    	PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(
				    		      "UPDATE usuarios SET pasword = ? WHERE cuenta = ?");
				    		    ps.setString(1, pass);
				    		    ps.setString(2, rs.getString("cuenta"));
				    		    ps.executeUpdate();
				    		    ps.close();

				    		    JOptionPane.showMessageDialog(null, "Password correctly saved!");
			           
			            
			            
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
				
			
}