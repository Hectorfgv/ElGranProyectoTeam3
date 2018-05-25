package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Conexion;
import modelo.OpcionesUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField TXTUser;
	private JTextField TXTMail;
	private JPasswordField TXTPassword;
	private JPasswordField TXTrepPass;
	/*Nuevo*/
	private Conexion db;
	private OpcionesUsuario udb;
	private Connection conexion;
	private boolean connected=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int resp = JOptionPane.showConfirmDialog(Register.this, "¿Seguro que deseas salir?"); 
				if(resp == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			
			
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 387, 589);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*Titulo Registro*/
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblRegister.setBounds(24, 6, 251, 76);
		contentPane.add(lblRegister);
		
		
		/*Imagen registro*/
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(263, 6, 103, 76);
		contentPane.add(lblNewLabel);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./img/RegisterIcon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image Dimg= img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon iIcon= new ImageIcon(Dimg);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(iIcon);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUser.setBounds(24, 112, 77, 25);
		contentPane.add(lblUser);
		
		TXTUser = new JTextField();
		TXTUser.setBackground(SystemColor.window);
		lblUser.setLabelFor(TXTUser);
		TXTUser.setBounds(35, 135, 315, 45);
		contentPane.add(TXTUser);
		TXTUser.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMail.setBounds(24, 203, 77, 25);
		contentPane.add(lblMail);
		
		TXTMail = new JTextField();
		TXTMail.setBackground(SystemColor.window);
		TXTMail.setColumns(10);
		TXTMail.setBounds(35, 226, 315, 45);
		contentPane.add(TXTMail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(24, 293, 90, 25);
		contentPane.add(lblPassword);
		
		TXTPassword = new JPasswordField();
		TXTPassword.setBackground(SystemColor.window);
		TXTPassword.setColumns(10);
		TXTPassword.setBounds(35, 316, 315, 45);
		contentPane.add(TXTPassword);
		
		JLabel btnSendReg = new JLabel("Repeat Password");
		btnSendReg.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSendReg.setBounds(24, 383, 162, 25);
		contentPane.add(btnSendReg);
		
		TXTrepPass = new JPasswordField();
		TXTrepPass.setBackground(SystemColor.window);
		TXTrepPass.setColumns(10);
		TXTrepPass.setBounds(35, 406, 315, 45);
		contentPane.add(TXTrepPass);
		
		JLabel lblDifPass = new JLabel("Different passwords.");
		lblDifPass.setForeground(Color.RED);
		lblDifPass.setVisible(false);
		lblDifPass.setHorizontalAlignment(SwingConstants.LEFT);
		lblDifPass.setBounds(38, 465, 152, 16);
		contentPane.add(lblDifPass);
		
		JButton btnSend = new JButton("¡SEND!");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass1=String.valueOf(TXTPassword.getPassword());
				String pass2=String.valueOf(TXTrepPass.getPassword());
				
				if(pass1.compareTo(pass2) != 0) {
					lblDifPass.setVisible(true);
					
				}else{
					System.out.println( "Colectas");
					
					Conectar();
					try{
						udb.registroUsuarios(TXTUser.getText(), TXTMail.getText(),TXTPassword.getText());
						
					
					}
					catch(Exception e1)
					{
						System.out.println( "User registred succesfully");
						dispose();
					
					}}}
			
			});
		
		
		btnSend.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSend.setBounds(134, 503, 117, 45);
		contentPane.add(btnSend);
		
		JButton btnAtras = new JButton();
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn l2 = new LogIn();
				l2.setVisible(true);
				dispose();
			}
		});
		
		btnAtras.setBorderPainted(false);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(24, 503, 59, 45);
		contentPane.add(btnAtras);
		BufferedImage imgBack = null;
		try {
			imgBack = ImageIO.read(new File("/Users/danielbc/Desktop/El Gran Proyecto/back-icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image Bimg= imgBack.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		ImageIcon bIcon= new ImageIcon(Bimg);
		btnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		btnAtras.setIcon(bIcon);

	}

private void Conectar(){
	
	try{
		db=new Conexion("18.217.122.120","owl24?useSSL=false","admin","elgranproyectogrupo3");
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
		System.out.println( " Debe haber alg�n problema con la BBDD o con la conexi�n.");	
	}
}
}

