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

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtUserName;
	private JPasswordField passwordFieldPassword;


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
					loginAttempt = LoginApplication.enterLogin(username, password);
						
					if (loginAttempt != null)
					{	
						LoggedIn currentLoggedIn = new LoggedIn(loginAttempt.getCurrentUserID(), loginAttempt.getCurrentUserName());
							
						MainMenuScreen mainScreen = new MainMenuScreen(currentLoggedIn);
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
				
				
				int select;																												// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Elenco - Exit", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																					// If Statement. Variable value is YES.
					
					System.exit(1);																								// Use connection with Controller to start method.																					
					
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
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					// Create new instance of Icon using the given PNG file.
		Image appImage = appIcon.getImage();															// Create image of icon variable.
		Image appImageResize = appImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		appIcon = new ImageIcon(appImageResize);														// Set instance of Icon to the resized Image.
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(200, 100, 100, 100);
		contentPane.add(lblLogo);
		
		
	}
}
