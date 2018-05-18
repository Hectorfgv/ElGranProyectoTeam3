package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import modelo.Conexion;
import modelo.Maquina;
import modelo.OpcionesMaquina;
import modelo.OpcionesUsuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class ventana2 extends JFrame {

	private JPanel contentPane;
	private Conexion db;
	private OpcionesMaquina mdb;
	private Connection conexion;
	private boolean connected=false;
	private JTextField textPassword;
	private JTextField textBusqueda;
	private Statement orden = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana2 frame = new ventana2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ventana2 (java.sql.Connection conexion2) {
		this.conexion=(Connection) conexion2;
	}
	/**
	 * Create the frame.
	 */
	public ventana2() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JComboBox comboBreaker = new JComboBox();
		comboBreaker.addItem("marca");
		comboBreaker.addItem("poblacion");
		comboBreaker.setBounds(118, 43, 70, 20);
		contentPane.add(comboBreaker);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Conectar();
				String maq=textBusqueda.getText();
				ResultSet rs;
				
				if (comboBreaker.getSelectedItem().equals("marca")){
					
					try{
						orden = (Statement) conexion.createStatement();
					    String sql = "SELECT * FROM maquinas WHERE marca LIKE '"+ maq +"'ORDER BY rating";
					    rs = orden.executeQuery(sql);
					    System.out.println(rs);
					   }catch(SQLException se){
						     
						      se.printStackTrace();
					   }catch(Exception sed){
						     
						      sed.printStackTrace();
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
				
					
				}else {
					try{
						orden = (Statement) conexion.createStatement();
					    String sql = "SELECT * FROM maquinas WHERE poblacion LIKE '"+maq+"' ORDER BY rating";
					    rs = orden.executeQuery(sql);
					    System.out.println(rs);
					   }catch(SQLException se){
						     
						      se.printStackTrace();
					   }catch(Exception sed){
						     
						      sed.printStackTrace();
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
		});
		
		btnBuscar.setBounds(161, 137, 89, 23);
		contentPane.add(btnBuscar);
		
		textBusqueda = new JTextField();
		textBusqueda.setBounds(214, 43, 86, 20);
		contentPane.add(textBusqueda);
		textBusqueda.setColumns(10);
		
		
	}
	private void Conectar(){
		
		try{
			db=new Conexion("localhost","owl24","root","");
			connected=db.connectDB();
			conexion=db.getConexion();
			mdb=new OpcionesMaquina(conexion);
			
			if(connected==true) {
				System.out.println("Entrada aceptada\n");
			}
			else System.out.println("No puede entrar");
			
			}
		catch(Exception e)
		{
			System.out.println( " Debe haber algún problema con la BBDD o con la conexión.");	
		}
}
}
