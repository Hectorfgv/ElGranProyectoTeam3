package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Conexion;
import modelo.OpcionesMaquina;
import modelo.OpcionesUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField TXTNombreM;
	private JTextField TXTPoblacion;
	private JTextField TXTDir1;
	private JTextField TXTDir2;
	private JTextField TXTidMach;
	
	/*Conexion*/
	private Conexion db;
	private OpcionesMaquina mdb;
	private Connection conexion;
	private boolean connected=false;
	private JTextField TXTMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			
				int resp = JOptionPane.showConfirmDialog(Admin.this, "¿Seguro que deseas salir?"); 
				if(resp == JOptionPane.OK_OPTION) {
					System.exit(0);
				}	
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 589, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreMaquina = new JLabel("Nombre Maquina");
		lblNombreMaquina.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNombreMaquina.setForeground(Color.BLACK);
		lblNombreMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreMaquina.setBounds(12, 8, 150, 20);
		contentPane.add(lblNombreMaquina);
		
		TXTNombreM = new JTextField();
		TXTNombreM.setBackground(SystemColor.window);
		TXTNombreM.setBounds(12, 36, 150, 35);
		contentPane.add(TXTNombreM);
		TXTNombreM.setColumns(10);
		
		JLabel lblPoblacion = new JLabel("Población");
		lblPoblacion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoblacion.setBounds(12, 79, 150, 20);
		contentPane.add(lblPoblacion);
		
		TXTPoblacion = new JTextField();
		TXTPoblacion.setBackground(SystemColor.window);
		TXTPoblacion.setBounds(12, 107, 150, 35);
		contentPane.add(TXTPoblacion);
		TXTPoblacion.setColumns(10);
		
		JLabel lblDir1 = new JLabel("Dirección 1");
		lblDir1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDir1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDir1.setBounds(12, 150, 150, 20);
		contentPane.add(lblDir1);
		
		TXTDir1 = new JTextField();
		TXTDir1.setBackground(SystemColor.window);
		TXTDir1.setBounds(12, 178, 150, 35);
		contentPane.add(TXTDir1);
		TXTDir1.setColumns(10);
		
		JLabel lblDir2 = new JLabel("Numero");
		lblDir2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDir2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDir2.setBounds(12, 221, 150, 20);
		contentPane.add(lblDir2);
		
		TXTDir2 = new JTextField();
		TXTDir2.setBackground(SystemColor.window);
		TXTDir2.setBounds(12, 249, 150, 35);
		contentPane.add(TXTDir2);
		TXTDir2.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(12, 292, 150, 20);
		contentPane.add(lblMarca);
		
		TXTMarca = new JTextField();
		TXTMarca.setBackground(SystemColor.window);
		TXTMarca.setBounds(12, 320, 150, 35);
		contentPane.add(TXTMarca);
		TXTMarca.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(281, 32, 12, 300);
		contentPane.add(separator);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valid = true;
				if(TXTNombreM.getText().equals("")){
					lblNombreMaquina.setForeground(Color.RED);
					valid = false;
				
				}else {
					lblNombreMaquina.setForeground(Color.BLACK);
					valid = true;
				}
				if(TXTPoblacion.getText().equals("")){
					valid = false;
					lblPoblacion.setForeground(Color.RED);
				
				}else {
					lblPoblacion.setForeground(Color.BLACK);
					valid = true;

				}
				if(TXTDir1.getText().equals("")) {
					valid = false;
					lblDir1.setForeground(Color.RED);
				
				}else {
					lblDir1.setForeground(Color.BLACK);
					valid = true;

				}
				if(TXTDir2.getText().equals("")) {
					valid = false;
					lblDir2.setForeground(Color.RED);
				
				}else{
					lblDir2.setForeground(Color.BLACK);
					valid = true;

				}
				if(TXTMarca.getText().equals("")) {
					valid = false;
					lblMarca.setForeground(Color.RED);
					
				}
				else {
					valid=true;
					lblMarca.setForeground(Color.BLACK);

				}
				
				if(valid == true) {
					Conectar();
					try{
						mdb.insertarMaquina(TXTNombreM.getText(), TXTPoblacion.getText(),TXTDir1.getText(), TXTDir2.getText(), TXTMarca.getText());
					
					}
					catch(Exception e1)
					{
						System.out.println( "Maquina añadida");
					
			}}
				
			}
			
		});
		
		btnInsert.setBounds(190, 70, 79, 73);
		contentPane.add(btnInsert);
		
		TXTidMach = new JTextField();
		TXTidMach.setBackground(SystemColor.window);
		TXTidMach.setBounds(305, 52, 150, 35);
		contentPane.add(TXTidMach);
		TXTidMach.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Maquina");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(305, 16, 150, 20);
		contentPane.add(lblNewLabel_1);
		
		JTextArea lbleliminada = new JTextArea("Maquina \neliminada");
		lbleliminada.setEditable(false);
		lbleliminada.setForeground(Color.RED);
		lbleliminada.setVisible(false);
		lbleliminada.setBounds(467, 11, 105, 35);
		contentPane.add(lbleliminada);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conectar();
				try{
					if(mdb.borrarMaquina(Integer.valueOf(TXTidMach.getText()))==true) {
						lbleliminada.setVisible(true);

					}
				}
				catch(Exception e1)
				{
					System.out.println( " Debe haber alg�n problema con la BBDD o con la conexi�n.");
				}
			}
		});
		btnDelete.setBounds(305, 101, 150, 29);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(315, 139, 257, 209);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.window);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnBuscar = new JButton("Ver\nMaquinas");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conectar();
				try{
					textArea.setText("");
					mdb.mostrarMaquinas2(textArea);
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, null);
				}
				Conectar();
			}
		});
		btnBuscar.setBounds(467, 56, 105, 67);
		contentPane.add(btnBuscar);
		
		JButton btnLogOut2 = new JButton("");
		btnLogOut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn LI3 = new LogIn();
				LI3.setVisible(true);
			}
		});
		btnLogOut2.setBounds(190, 213, 79, 79);
		contentPane.add(btnLogOut2);
		BufferedImage imgLO = null;
		try {
			imgLO = ImageIO.read(new File("./img/LogOut.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image LOimg= imgLO.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon loIcon = new ImageIcon(LOimg);
		btnLogOut2.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogOut2.setIcon(loIcon);
		btnLogOut2.setBorderPainted(false);

	}
	
	
	
	private void Conectar(){
		
		try{
			db=new Conexion("18.217.122.120","owl24?useSSL=false","admin","elgranproyectogrupo3");
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
