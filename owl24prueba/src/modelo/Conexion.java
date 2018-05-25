package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.mysql.jdbc.Connection;

public class Conexion {
	//Atributos
	/**
	 * Atributos de la clase conexión
	 */
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	private String host; 
	private String bbdd; 
	private String user; 
	private String pass; 
	private String url;  
	                    
	private Connection conexion = null;
	
		//Constructores
	/**
	 * Constructor con 4 parámetros
	 * @param HOST
	 * @param BBDD
	 * @param USER
	 * @param PASS
	 */
	public Conexion(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	/**
	 * getter de Connection
	 * @return
	 */
	public Connection getConexion(){
		return this.conexion;
	}
	//Métodos
	/**
	 * Método boolean de conexión del driver
	 * @return
	 */
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
	
	
	/**
	 * Método de auntenticción de Administrador con el Active Directory
	 */
	public void ActiveDirectory () {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://10.2.72.75");
		
		//Rellenamos con el usuario/dominio y password
		env.put(Context.SECURITY_PRINCIPAL, "Administrador@win12server.com");
		env.put(Context.SECURITY_CREDENTIALS, "Owl24pi.3");
		
		DirContext ctx;
		
		try {
			//Autenticamos el usuario
			ctx = new InitialDirContext(env);
			System.out.println("El usuario se ha autenticado correctamente");
			ctx.close();
		} catch (NamingException ex) {
			System.out.println("Ha habido un error en la autenticaciÃ³n");
		}
		
	}
	

}
