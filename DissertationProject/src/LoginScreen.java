import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * User Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * LoginScreen
 * </p>
 * 
 * <p>
 * First Screen shown on application startup.
 * <br>Offers the choice of attempting a login, creating a new account or exiting the application to the user.
 * <br>A login attempt requires 2 valid pieces of user input that match a database account row - Username and password.
 * <br>Register takes user to a new GUI to begin account creation process. 
 * <br>Has a direct link with <code>AccountApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see LoginApplication
 */
public class LoginScreen extends JFrame {

	// Variables
	
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField passwordFieldPassword;

	// Constructors
	
	// Default 
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>LoginScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * </p>
	 * 
	 * 
	 * @see LoginScreen
	 */
	
	public LoginScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("Enter Your Username Here");
		txtUserName.setBounds(150, 250, 250, 25);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Enter Username And Password Details Above Then Click To Attempt Login");
		btnLogin.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = null;
				String password = null;
				LoggedIn loginAttempt = null;
				
				username = txtUserName.getText().strip();
				password = passwordFieldPassword.getText().strip();
				try 
				{
					loginAttempt = LoginApplication.enterLogin(username, password);														// Make variable equal result of method call
							
					if (loginAttempt != null)																							// If method call not null - i.e the user input is valid and match a database row
					{	
						LoggedIn currentLoggedIn = new LoggedIn(loginAttempt.getCurrentUserID(), loginAttempt.getCurrentUserName());	// Created new instance of object to store details conveniently and ideal for parameter passing 
							
						MainMenuScreen mainScreen = new MainMenuScreen(currentLoggedIn);												// Progress to main menu
						mainScreen.setVisible(true);
						dispose();
					}
				} 
				catch (CustomException loginError) 
				{
					JOptionPane.showMessageDialog(null, loginError.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);	
				}
			}
			
		});
		btnLogin.setBounds(175, 350, 150, 25);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUsername.setForeground(new Color(90, 192, 217));
		lblUsername.setBounds(50, 250, 100, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPassword.setForeground(new Color(90, 192, 217));
		lblPassword.setBounds(50, 300, 100, 25);
		contentPane.add(lblPassword);
		
		JButton btnAccount = new JButton("Create An Account");
		btnAccount.setToolTipText("Click To Create A New Elenco Account");
		btnAccount.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationScreen gui = new RegistrationScreen();
				gui.setVisible(true);
				dispose();
			}
		});
		btnAccount.setBounds(175, 400, 150, 25);
		contentPane.add(btnAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Click To Exit Elenco");
		btnExit.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Elenco - Exit", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {																					
					
					System.exit(1);																																													
					
				}	
			
			}
		});
		btnExit.setBounds(200, 500, 100, 25);
		contentPane.add(btnExit);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setToolTipText("Elenco - Express Your Musical Opinion");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setBounds(150, 25, 200, 75);
		contentPane.add(lblElenco);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setToolTipText("Enter Your Password Here");
		passwordFieldPassword.setBounds(150, 300, 250, 25);
		contentPane.add(passwordFieldPassword);
		
		ImageIcon appIcon =  new ImageIcon(ElencoStartup.class.getResource("/BlueIcon-Circle.PNG"));					
		Image appImage = appIcon.getImage();															
		Image appImageResize = appImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);		
		appIcon = new ImageIcon(appImageResize);														
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(200, 100, 100, 100);
		contentPane.add(lblLogo);
		
		
	}
}
