package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Conexion;
import modelo.OpcionesUsuario;
import vista.User_Settings;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private final JPanel Pan_Iz = new JPanel();
	private JTextField TxtUser;
	private JPasswordField TxtPass;
	/*Nuevo*/
	private Conexion db;
	private OpcionesUsuario udb;
	private Connection conexion;
	private boolean connected=false;
	/*Active directory*/
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					LogIn frame = new LogIn();
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
	public LogIn() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator Sep_Hor_Iz = new JSeparator();
		Sep_Hor_Iz.setForeground(Color.BLACK);
		Sep_Hor_Iz.setBounds(6, 173, 163, 12);
		contentPane.add(Sep_Hor_Iz);
		Pan_Iz.setBackground(Color.DARK_GRAY);
		Pan_Iz.setBounds(0, 0, 175, 364);
		contentPane.add(Pan_Iz);
		
		JTextPane TXT_Descrip = new JTextPane();
		TXT_Descrip.setForeground(Color.WHITE);
		TXT_Descrip.setEditable(false);
		TXT_Descrip.setBackground(Color.DARK_GRAY);
		TXT_Descrip.setText("Welcome to OLW 24, with this APP you can find all the vending machine in your zone.");
		
		JLabel lblNewLabel = new JLabel();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./img/owl.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image Dimg= img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon iIcon= new ImageIcon(Dimg);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(iIcon);
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_Pan_Iz = new GroupLayout(Pan_Iz);
		gl_Pan_Iz.setHorizontalGroup(
			gl_Pan_Iz.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Pan_Iz.createSequentialGroup()
					.addGroup(gl_Pan_Iz.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Pan_Iz.createSequentialGroup()
							.addGap(15)
							.addComponent(TXT_Descrip, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Pan_Iz.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Pan_Iz.setVerticalGroup(
			gl_Pan_Iz.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Pan_Iz.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(TXT_Descrip, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		Pan_Iz.setLayout(gl_Pan_Iz);
		
		Panel Pan_Der = new Panel();
		Pan_Der.setBackground(Color.WHITE);
		Pan_Der.setBounds(175, 0, 414, 364);
		contentPane.add(Pan_Der);
		
		TxtUser = new JTextField();
		TxtUser.setBackground(SystemColor.window);
		TxtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setLabelFor(TxtUser);
		
		JSeparator Sep_Hor_Der = new JSeparator();
		Sep_Hor_Der.setForeground(Color.BLACK);
		
		JLabel lblError = new JLabel("Wrong User or Password");
		lblError.setVisible(false);
		lblError.setForeground(UIManager.getColor("Button.select"));
		
		
		/*Boton Log In*/
		JButton Btn_Log = new JButton("Log In");
		Btn_Log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Conectar();
				
	    		String nombre =	TxtUser.getText();	    		
	    		try{
					
					if (TxtUser.getText().compareTo("Administrador")==0 && (TxtPass.getText().compareTo("Owl24pi.3")==0)){
						db.ActiveDirectory();
						Admin A1 = new Admin();
			    			A1.setVisible(true);
			    		dispose();
					}
					else
					{
						Conectar();
						if(udb.loginUsuarios(TxtUser.getText(), TxtPass.getText()) == true) {
							Inicio I1 = new Inicio(nombre);
					    		I1.setVisible(true);
					    		dispose();
							
						}else{
							lblError.setVisible(true);
						};
					}
				}
				catch(Exception e1)
				{
				
					JOptionPane.showMessageDialog(null, "User or password are wrong");
				}

				}
			
		});
		Btn_Log.setBounds(128, 197, 89, 23);
		contentPane.add(Btn_Log);
				
				
			
			
			
			
		
		
		JButton Btn_Reg = new JButton("Register");
		Btn_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Accion de Registro*/
				Register R1 = new Register();
				R1.setVisible(true);
				dispose();
			}
		});
		
		TxtPass = new JPasswordField();
		TxtPass.setBackground(SystemColor.window);
		lblPassword.setLabelFor(TxtPass);
		
		
		GroupLayout gl_Pan_Der = new GroupLayout(Pan_Der);
		gl_Pan_Der.setHorizontalGroup(
			gl_Pan_Der.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Pan_Der.createSequentialGroup()
					.addGroup(gl_Pan_Der.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Pan_Der.createSequentialGroup()
							.addGap(52)
							.addComponent(Sep_Hor_Der, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Pan_Der.createSequentialGroup()
							.addGap(117)
							.addGroup(gl_Pan_Der.createParallelGroup(Alignment.TRAILING)
								.addComponent(Btn_Reg, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(Btn_Log, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(52, Short.MAX_VALUE))
				.addGroup(gl_Pan_Der.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_Pan_Der.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Pan_Der.createSequentialGroup()
							.addGroup(gl_Pan_Der.createParallelGroup(Alignment.LEADING)
								.addComponent(TxtUser, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(TxtPass, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUser))
							.addContainerGap(0, Short.MAX_VALUE))))
				.addGroup(Alignment.TRAILING, gl_Pan_Der.createSequentialGroup()
					.addContainerGap(239, Short.MAX_VALUE)
					.addComponent(lblError)
					.addGap(14))
		);
		gl_Pan_Der.setVerticalGroup(
			gl_Pan_Der.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Pan_Der.createSequentialGroup()
					.addContainerGap(8, Short.MAX_VALUE)
					.addComponent(lblError)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TxtUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(TxtPass, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Sep_Hor_Der, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Btn_Log, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Btn_Reg, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		Pan_Der.setLayout(gl_Pan_Der);
		Conectar();

	}
	
	/*Nuevo*/
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
			System.out.println( " Debe haber algun problema con la BBDD o con la conexion.");	
		}
	}
}
