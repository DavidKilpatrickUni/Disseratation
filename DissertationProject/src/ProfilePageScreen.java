import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ProfilePageScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePageScreen frame = new ProfilePageScreen();
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
	public ProfilePageScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("My Profile");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblHeader.setBounds(190, 37, 270, 47);
		contentPane.add(lblHeader);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(264, 461, 89, 23);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(56, 209, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 265, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(46, 183, 89, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(46, 240, 48, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(56, 296, 48, 14);
		contentPane.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(70, 332, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblIdentity = new JLabel("Identity");
		lblIdentity.setBounds(56, 369, 48, 14);
		contentPane.add(lblIdentity);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(46, 115, 89, 14);
		contentPane.add(lblFullName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(56, 140, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnEmail = new JButton("Change Email");
		btnEmail.setBounds(382, 247, 144, 23);
		contentPane.add(btnEmail);
		
		JButton btnPassword = new JButton("Change Password");
		btnPassword.setBounds(393, 292, 133, 23);
		contentPane.add(btnPassword);
		
		JButton btnUsername = new JButton("Change Username");
		btnUsername.setBounds(362, 179, 196, 23);
		contentPane.add(btnUsername);
		
		JButton btnName = new JButton("Change Name");
		btnName.setBounds(396, 139, 112, 23);
		contentPane.add(btnName);
		
		JButton btnIdentity = new JButton("Change Identity");
		btnIdentity.setBounds(371, 353, 137, 23);
		contentPane.add(btnIdentity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(56, 394, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(56, 451, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setBounds(33, 426, 48, 14);
		contentPane.add(lblDOB);
	}

}
