package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelo.Conexion;
import modelo.Usuario;
import modelo.OpcionesUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class IngresoUsuarios extends JFrame {

	java.sql.Connection con=null;
	java.sql.PreparedStatement pst=null;
	ResultSet rs=null;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCuenta;
	private JTextField textEmail;
	private JButton btnRegistro;
	
	private Conexion db;
	private OpcionesUsuario udb;
	private Connection conexion;
	private boolean connected=false;
	private JTextField textPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoUsuarios frame = new IngresoUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public IngresoUsuarios() {
		
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Cuenta");
		lblNombre.setBounds(10, 27, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("E-mail");
		lblApellido1.setBounds(10, 77, 52, 14);
		contentPane.add(lblApellido1);
		
		textCuenta = new JTextField();
		textCuenta.setBounds(69, 24, 249, 20);
		contentPane.add(textCuenta);
		textCuenta.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(69, 74, 249, 20);
		contentPane.add(textEmail);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(69, 121, 249, 20);
		contentPane.add(textPassword);
		
		JLabel lblApellido2 = new JLabel("Password");
		lblApellido2.setBounds(10, 124, 52, 14);
		contentPane.add(lblApellido2);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conectar();
				try{
					udb.registroUsuarios(textCuenta.getText(),textEmail.getText(),textPassword.getText());
				}
				catch(Exception e1)
				{
					System.out.println( " User registred succesfully");
				}
				}
			
	
			
		});
		btnRegistrar.setBounds(247, 197, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCuenta.setText("");
				textEmail.setText("");
				textPassword.setText("");
				
		}
		});
		btnLimpiar.setBounds(10, 197, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conectar();
				try{
					udb.loginUsuarios(textCuenta.getText(),textPassword.getText());
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "User or passcord are wrong");
				}
				}
			
		});
		btnLogin.setBounds(128, 197, 89, 23);
		contentPane.add(btnLogin);
		
		
		
		
		Conectar();
	}
	
	private void Conectar(){
		
		try{
			db=new Conexion("localhost","owl24","root","");
			connected=db.connectDB();
			conexion=db.getConexion();
			udb=new OpcionesUsuario(conexion);
			
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
