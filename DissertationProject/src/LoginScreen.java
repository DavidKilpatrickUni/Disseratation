import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField passwordFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(146, 193, 259, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet loginAttempt = LoginApplication.attemptLogin(txtUserName.getText(),passwordFieldPassword.getText());	
				String name = null;
				String pass = null;
				String userID = null;
						
				try {
					
					if (loginAttempt.next())																	
					{
						userID = loginAttempt.getString("UserID");
						name = loginAttempt.getString("UserName");
						pass = loginAttempt.getString("Password");
					
						System.out.println(name);
						System.out.println(pass);
						
						
						MainScreen gui = new MainScreen(userID, name);
						gui.setVisible(true);
						dispose();
					}
					
					else
					{
						System.out.println("Invalid Account Details");
					}
					
				}
				catch (SQLException sqe)
				{
					
				}
				
			}
		});
		btnLogin.setBounds(217, 276, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(45, 185, 113, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 248, 48, 14);
		contentPane.add(lblPassword);
		
		JButton btnAccount = new JButton("Create An Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RegistrationScreen gui = new RegistrationScreen();
				gui.setVisible(true);
				dispose();
			}
		});
		btnAccount.setBounds(188, 370, 144, 23);
		contentPane.add(btnAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnExit.setBounds(217, 459, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblHeader = new JLabel("Welcome");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHeader.setBounds(146, 68, 287, 73);
		contentPane.add(lblHeader);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(146, 245, 259, 20);
		contentPane.add(passwordFieldPassword);
	}
}
