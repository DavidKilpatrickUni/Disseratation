import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdmin;
	private JPasswordField passwordField;

	public AdminLoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String adminID = null;
				int adminLevel;
				
				ResultSet attemptLogin = AdminSQL.attemptLogin(txtAdmin.getText().strip(), passwordField.getText().strip());
				
				try {
					while(attemptLogin.next())
					{
						adminID = attemptLogin.getString("AdminID");
						adminLevel = attemptLogin.getInt("AdminLevel");
						
						AdminLoggedIn currentAdmin = new AdminLoggedIn(adminID, adminLevel);
						
						AdminMainMenuScreen mainScreen = new AdminMainMenuScreen(currentAdmin);
						mainScreen.setVisible(true);
						dispose();
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(181, 375, 100, 25);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			}
		});
		btnExit.setBounds(181, 477, 100, 25);
		contentPane.add(btnExit);
		
		txtAdmin = new JTextField();
		txtAdmin.setBounds(192, 210, 200, 25);
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		JLabel lblHeader = new JLabel("Elenco - Admin");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHeader.setBounds(119, 83, 200, 50);
		contentPane.add(lblHeader);
		
		JLabel lblAdminName = new JLabel("Admin Name");
		lblAdminName.setForeground(Color.BLUE);
		lblAdminName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdminName.setBounds(66, 210, 100, 25);
		contentPane.add(lblAdminName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(66, 280, 100, 25);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 280, 200, 25);
		contentPane.add(passwordField);
	}
	
	
	
}
