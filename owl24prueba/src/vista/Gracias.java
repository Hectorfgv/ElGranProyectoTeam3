package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gracias extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Gracias dialog = new Gracias();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gracias() {
		setBounds(100, 100, 450, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnThanckYouFor = new JTextPane();
			txtpnThanckYouFor.setEditable(false);
			txtpnThanckYouFor.setBounds(19, 29, 286, 96);
			txtpnThanckYouFor.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			txtpnThanckYouFor.setText("Thank you for \nusing our app.");
			contentPanel.add(txtpnThanckYouFor);
		}
		{
			JLabel lblFlecha = new JLabel();
			lblFlecha.setBounds(309, 6, 135, 150);
			contentPanel.add(lblFlecha);
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("/Users/danielbc/Desktop/El Gran Proyecto/arrow.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Image Dimg= img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon iIcon= new ImageIcon(Dimg);
			lblFlecha.setHorizontalAlignment(SwingConstants.CENTER);
			lblFlecha.setIcon(iIcon);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Log In");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						LogIn l3 = new LogIn();
						l3.setVisible(true);
						dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
