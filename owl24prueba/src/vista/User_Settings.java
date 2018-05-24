package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class User_Settings extends JFrame {

	private JPanel contentPane;
	private JTextField TXTMail;
	private JPasswordField TXTPass;
	private JPasswordField TXTRPass;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Settings frame = new User_Settings();
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
	public User_Settings(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSettings = new JLabel("");
		lblSettings.setBackground(Color.ORANGE);
		lblSettings.setBounds(0, 22, 120, 120);
		contentPane.add(lblSettings);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./img/Perfil.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image Dimg= img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iIcon= new ImageIcon(Dimg);
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setIcon(iIcon);
		
		
		
		
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setText(nombre);
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(125, 22, 233, 134);
		contentPane.add(lblNombre);
		
		JLabel lblMail = new JLabel("");
		lblMail.setBackground(Color.YELLOW);
		lblMail.setBounds(22, 174, 61, 61);
		contentPane.add(lblMail);
		BufferedImage imgM = null;
		try {
			imgM = ImageIO.read(new File("./img/mail.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image Mimg= imgM.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		ImageIcon mIcon = new ImageIcon(Mimg);
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setIcon(mIcon);
		
		TXTMail = new JTextField();
		TXTMail.setBackground(SystemColor.window);
		TXTMail.setBounds(95, 179, 263, 50);
		contentPane.add(TXTMail);
		TXTMail.setColumns(10);
		
		JLabel lblPass = new JLabel("");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setBackground(Color.YELLOW);
		lblPass.setBounds(24, 280, 61, 61);
		contentPane.add(lblPass);
		BufferedImage imgP = null;
		try {
			imgP = ImageIO.read(new File("./img/lock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image Pimg = imgP.getScaledInstance(40, 50, Image.SCALE_SMOOTH);
		ImageIcon pIcon = new ImageIcon(Pimg);
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setIcon(pIcon);
		
		TXTPass = new JPasswordField();
		TXTPass.setBackground(SystemColor.window);
		TXTPass.setColumns(10);
		TXTPass.setBounds(97, 285, 263, 50);
		contentPane.add(TXTPass);

		JLabel lblRpass = new JLabel("");
		lblRpass.setHorizontalAlignment(SwingConstants.CENTER);
		lblRpass.setBackground(Color.YELLOW);
		lblRpass.setBounds(22, 386, 61, 61);

		contentPane.add(lblRpass);
		BufferedImage imgRP = null;
		try {
			imgRP = ImageIO.read(new File("./img/lock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image RPimg= imgRP.getScaledInstance(40, 50, Image.SCALE_SMOOTH);
		ImageIcon rpIcon = new ImageIcon(RPimg);
		lblRpass.setHorizontalAlignment(SwingConstants.CENTER);
		lblRpass.setIcon(rpIcon);
		
		
		TXTRPass = new JPasswordField();
		TXTRPass.setBackground(SystemColor.window);
		TXTRPass.setColumns(10);
		TXTRPass.setBounds(97, 391, 263, 50);
		contentPane.add(TXTRPass);
	
	/*Boton LogOut*/	
	
		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogOut.setBounds(292, 478, 70, 70);
		btnLogOut.setBorderPainted(false);
		contentPane.add(btnLogOut);
		BufferedImage imgLO = null;
		try {
			imgLO = ImageIO.read(new File("./img/LogOut.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image LOimg= imgLO.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon loIcon = new ImageIcon(LOimg);
		btnLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogOut.setIcon(loIcon);
		
	/*Boton Favoritos*/	
		JButton btnFav = new JButton("");
		btnFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFav.setBounds(35, 478, 70, 70);
		btnFav.setBorderPainted(false);
		contentPane.add(btnFav);
		BufferedImage imgF = null;
		try {
			imgF = ImageIO.read(new File("./img/Fav.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image Fimg= imgF.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon fIcon = new ImageIcon(Fimg);
		btnFav.setHorizontalAlignment(SwingConstants.CENTER);
		btnFav.setIcon(fIcon);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(100, 257, 258, 31);
		contentPane.add(lblPassword);
		
		JLabel lblRepPass = new JLabel("Repeat Password");
		lblRepPass.setForeground(Color.BLACK);
		lblRepPass.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRepPass.setBounds(100, 364, 258, 31);
		contentPane.add(lblRepPass);
		
		JLabel lblNombre_Camb = new JLabel("Name");
		lblNombre_Camb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNombre_Camb.setBounds(100, 154, 258, 31);
		contentPane.add(lblNombre_Camb);
		
		JButton btnNewButton = new JButton("SEND!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass1=String.valueOf(TXTPass.getPassword());
				String pass2=String.valueOf(TXTRPass.getPassword());
				if(pass1.compareTo(pass2) != 0) {
					lblPassword.setForeground(Color.RED);
					lblRepPass.setForeground(Color.RED);

				}else {
					
				}
			
			}
		});
		btnNewButton.setBounds(140, 478, 117, 61);
		contentPane.add(btnNewButton);
		
		
		
	
	
	
	
	
	}
}