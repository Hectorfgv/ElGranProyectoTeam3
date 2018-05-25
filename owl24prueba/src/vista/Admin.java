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
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField TXTNombreM;
	private JTextField TXTPoblacion;
	private JTextField TXTDir1;
	private JTextField TXTDir2;
	private JTextField textField_4;
	
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreMaquina = new JLabel("Nombre Maquina");
		lblNombreMaquina.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNombreMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreMaquina.setBounds(12, 8, 150, 20);
		contentPane.add(lblNombreMaquina);
		
		TXTNombreM = new JTextField();
		TXTNombreM.setBackground(SystemColor.window);
		TXTNombreM.setBounds(12, 36, 150, 35);
		contentPane.add(TXTNombreM);
		TXTNombreM.setColumns(10);
		
		JLabel lblPoblacion = new JLabel("PoblaciÃ³n");
		lblPoblacion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoblacion.setBounds(12, 79, 150, 20);
		contentPane.add(lblPoblacion);
		
		TXTPoblacion = new JTextField();
		TXTPoblacion.setBackground(SystemColor.window);
		TXTPoblacion.setBounds(12, 107, 150, 35);
		contentPane.add(TXTPoblacion);
		TXTPoblacion.setColumns(10);
		
		JLabel lblDir1 = new JLabel("DirecciÃ³n 1");
		lblDir1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDir1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDir1.setBounds(12, 150, 150, 20);
		contentPane.add(lblDir1);
		
		TXTDir1 = new JTextField();
		TXTDir1.setBackground(SystemColor.window);
		TXTDir1.setBounds(12, 178, 150, 35);
		contentPane.add(TXTDir1);
		TXTDir1.setColumns(10);
		
		JLabel lblDir2 = new JLabel("Direccion 2");
		lblDir2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDir2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDir2.setBounds(12, 221, 150, 20);
		contentPane.add(lblDir2);
		
		TXTDir2 = new JTextField();
		TXTDir2.setBackground(SystemColor.window);
		TXTDir2.setBounds(12, 249, 150, 35);
		contentPane.add(TXTDir2);
		TXTDir2.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(281, 32, 12, 300);
		contentPane.add(separator);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Conectar();
				try{
					mdb.insertarMaquina(TXTNombreM.getText(), TXTPoblacion.getText(),TXTDir1.getText(), TXTDir2.getText(), TXTMarca.getText());
					dispose();
				
				}
				catch(Exception e1)
				{
					System.out.println( "Maquina aÃ±adida");
				
				}}
				
			
		});
		
		btnInsert.setBounds(190, 145, 79, 73);
		contentPane.add(btnInsert);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.window);
		textField_4.setBounds(305, 52, 150, 35);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Maquina");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(305, 16, 150, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conectar();
				try{
					mdb.borrarMaquina(Integer.valueOf(textField_4.getText()));
				}
				catch(Exception e1)
				{
					System.out.println( " Debe haber algún problema con la BBDD o con la conexión.");
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
			System.out.println( " Debe haber algï¿½n problema con la BBDD o con la conexiï¿½n.");	
		}
		
}}
