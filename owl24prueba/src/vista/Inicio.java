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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Label;
import java.awt.List;

import javax.swing.Box;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.TextArea;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblResultados;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 589);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblPerfil = new JLabel();
		lblPerfil.setBounds(12, 12, 100, 100);
		contentPane.add(lblPerfil);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("/Users/danielbc/Desktop/El Gran Proyecto/Perfil.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image Dimg= img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iIcon= new ImageIcon(Dimg);
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setIcon(iIcon);getToolkit();
		
		JButton btnBuscar = new JButton("Search");
		btnBuscar.setBounds(255, 65, 120, 47);
		contentPane.add(btnBuscar);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 124, 353, 12);
		contentPane.add(separator);
		
		lblResultados = new JLabel("Search Results");
		lblResultados.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblResultados.setBounds(124, 148, 138, 16);
		contentPane.add(lblResultados);
		
		label = new JLabel("...");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(162, 165, 61, 16);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 16, 120, 47);
		contentPane.add(comboBox);
		
		JTextField TXTbuscar = new JTextField();
		TXTbuscar.setBounds(255, 25, 120, 26);
		contentPane.add(TXTbuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 201, 369, 360);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
	}
}
