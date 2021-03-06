package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import modelo.Conexion;
import modelo.Maquina;
import modelo.OpcionesMaquina;
import modelo.OpcionesUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblResultados;
	private JLabel label;
	private Conexion db;
	private OpcionesMaquina mdb;
	private Connection conexion;
	private boolean connected=false;
	private JTextField textPassword;
	private JTextField textBusqueda;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/**
	 * Create the frame.
	 */
	public Inicio(String nombre) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(Inicio.this, "¿Seguro que deseas salir?"); 
				if(resp == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 399, 602);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPerfil = new JButton();
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				User_Settings U1 = new User_Settings(nombre);
				U1.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(12, 12, 100, 100);
		contentPane.add(btnPerfil);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./img/Perfil.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image Dimg= img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iIcon= new ImageIcon(Dimg);
		btnPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		btnPerfil.setIcon(iIcon);getToolkit();
		
		JComboBox comboBreaker = new JComboBox();
		comboBreaker.addItem("Marca");
		comboBreaker.addItem("Poblacion");
		comboBreaker.setBounds(124, 16, 120, 47);
		contentPane.add(comboBreaker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 201, 369, 360);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.window);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnBuscar = new JButton("Search");
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Conectar();
				Object selectedItem = comboBreaker.getSelectedItem();
				String i=comboBreaker.toString();
				String item= i.substring( i.lastIndexOf('=')+1, i.lastIndexOf(']'));
				
				try{
					textArea.setText("");
					mdb.filtarMaquinas2(item,textBusqueda.getText(), textArea);
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, null);
				}
				Conectar();
			
			}
		});
		
		btnBuscar.setBounds(255, 65, 120, 47);
		contentPane.add(btnBuscar);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 124, 353, 12);
		contentPane.add(separator);
		
		lblResultados = new JLabel("Search Results");
		lblResultados.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblResultados.setBounds(130, 148, 138, 16);
		contentPane.add(lblResultados);
		
		label = new JLabel("...");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(169, 165, 61, 16);
		contentPane.add(label);
		
		textBusqueda = new JTextField();
		textBusqueda.setBounds(255, 25, 120, 26);
		contentPane.add(textBusqueda);
		
		
		
	}
	private void Conectar(){
		
		try{
			db=new Conexion("18.217.122.120","owl24?useSSL=false","admin","elgranproyectogrupo3");
			/*db=new Conexion("localhost","owl24","root","");*/
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
			System.out.println( " Debe haber alg�n problema con la BBDD o con la conexi�n.");	
		}
}
}
