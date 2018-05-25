package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;



import modelo.Usuario;
import vista.Gracias;

import vista.LogIn;
import vista.Register;

public class OpcionesUsuario {
	//Atributos
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
		//Metodos
		/**
		 * MÈtodo de enlace con la clase conexiÛn
		 * @param conexion2
		 */
		public OpcionesUsuario(java.sql.Connection conexion2) {
			this.conexion=(Connection) conexion2;
		}

	/**
	 * MÈtodo de loginUsuarios
	 * @param cuenta
	 * @param pass
	 * @return
	 */
			
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
							    System.out.println("Esta bien contrase√±a");
							    	log2=true;
							    	
							    	
						    }
						    else
						    System.out.println("Esta mal contrase√±a");
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
			/**
			 * MÈtodo Para registrar Usuarios
			 * @param cuenta
			 * @param email
			 * @param pass
			 */
			
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
				    	System.out.println("Usuario ya existe");
				    	log1=true;
				    	 String e=rs.getString("email");
						    if (e.compareTo(email)==0) {
							    	System.out.println("Email ya existe");
							    	log2=true;
						    }
				    }  	
				       
				 } if ((log1==false) && (log2==false)) {
					  		
					  	orden = (Statement) conexion.createStatement();
					  String sql2 = "INSERT INTO usuarios (cuenta,email,pasword) " +
					             "VALUES ('"+cuenta+"', '"+email+"', '"+pass+"')";
					  orden.executeUpdate(sql2);
					  Gracias G3 = new Gracias();
					  G3.setVisible(true);
					  Register R1 =new Register();
					  R1.dispose();
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

public void ActualizaUsuarios(String nombre, String pass){
	
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
	       
	 } if ((log1==false) && (log2==false)) {
		  		
		  	orden = (Statement) conexion.createStatement();
		  String sql2 = "INSERT INTO usuarios (cuenta,email,pasword) " +
		             "VALUES ('"+cuenta+"', '"+email+"', '"+pass+"')";
		  orden.executeUpdate(sql2);
		  Gracias G3 = new Gracias();
		  G3.setVisible(true);
		  Register R1 =new Register();
		  R1.dispose();
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