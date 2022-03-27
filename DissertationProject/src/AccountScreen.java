import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * AccountScreen
 * </p>
 * 
 * <p>
 * Allows user to view their Account details and update/change some of their details that maybe wrong/out of date  
 * <br>Has a direct link with <code>AccountApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see AccountApplication
 */

public class AccountScreen extends JFrame {

	// Variables
	
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtFirstname;
	private JTextField txtDOB;
	private JPasswordField passwordField;
	private JTextField txtSurname;
	private JComboBox comboBoxIdentity; 

	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>AccountScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * <br>Makes use of CustomException to relay feedback to user.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 * 
	 * @see AccountScreen
	 * @see LoggedIN
	 * @see CustomException
	 */
	
	public AccountScreen(LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Account Details");
		setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				ResultSet accountDetails  = MySQLQueries.getAccountsDetailDecrypted(currentLoggedIn.getCurrentUserID());	// Call sql method to populate screen with current user details.

				String pass = null;
				String userID = null;
				String email = null;
				String firstname= null;
				String surname = null;
				String identity = null;
				String DOB = null;
						
				try {
					
					if (accountDetails.next())														// If a database row is returned set variables to row values of stated column titles															
					{
						
						
						pass = accountDetails.getString("AES_DECRYPT(Password,'encrypt')");
						email = accountDetails.getString("Email");
						firstname = accountDetails.getString("First Name");
						surname = accountDetails.getString("Last Name");
						identity = accountDetails.getString("Identity");
						DOB = accountDetails.getString("Date Of Birth");
						
						System.out.println("password: " + pass);
						
						txtEmail.setText(email);
						passwordField.setText(pass);
						txtFirstname.setText(firstname);
						txtSurname.setText(surname);
						comboBoxIdentity.setSelectedItem(identity);
						txtDOB.setText(DOB);

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Profile Menu");
		btnBack.setToolTipText("Return To Profile Screen");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Return To Main Menu - All Unconfirmed Input Will Be Lost", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) {
				
					ProfileMenuScreen frame = new ProfileMenuScreen(currentLoggedIn);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnBack.setBounds(200, 500, 100, 25);
		contentPane.add(btnBack);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtEmail.setBounds(25, 300, 250, 25);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblEmail.setBounds(25, 275, 100, 25);
		lblEmail.setForeground(new Color(90, 192, 217));
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblPassword.setBounds(25, 325, 100, 25);
		lblPassword.setForeground(new Color(90, 192, 217));
		contentPane.add(lblPassword);
		
		JLabel lblIdentity = new JLabel("Identity");
		lblIdentity.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblIdentity.setBounds(25, 375, 100, 25);
		lblIdentity.setForeground(new Color(90, 192, 217));
		contentPane.add(lblIdentity);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblFirstname.setBounds(25, 175, 100, 25);
		lblFirstname.setForeground(new Color(90, 192, 217));
		contentPane.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtFirstname.setBounds(25, 200, 250, 25);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JButton btnPassword = new JButton("Change Password");
		btnPassword.setToolTipText("Click To Change Password To Input");
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Password", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) 
				{
					try 
					{
					
						AccountApplication.checkValidPassword(passwordField.getText().strip());		// Check password input is valid
				
						try 
						{
						
							String confirmPassword;
							confirmPassword = (JOptionPane.showInputDialog("Retype New Password To Confirm")); 		// A popup confirm password is shown to user
						
							if(confirmPassword.equals(passwordField.getText().strip()))								// If original and popup Strings match		 
							{
							
								MySQLQueries.updatePassword(currentLoggedIn.getCurrentUserID(), passwordField.getText().strip());		// Update users current password with the new input 
							
							}
							else
							{
							
								JOptionPane.showMessageDialog(null, "Confirm Code Doesnt Match - Change Of Password Unsuccessful" , "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
							
							}
					
						} 
						catch (CustomException error) 
						{
					
							JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
				
					}	
					catch (CustomException error)
					{
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}
				
			}
		});
		btnPassword.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPassword.setBounds(310, 350, 150, 25);
		contentPane.add(btnPassword);
		
		JButton btnFirst = new JButton("Change First Name");
		btnFirst.setToolTipText("Click To Change First Name To Input");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of First Name", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) 
				{
				
					try 
					{
					
						AccountApplication.checkValidFirstname(txtFirstname.getText().strip());				// Check firstname input is valid
					
						try 
						{
							MySQLQueries.updateFirstname(currentLoggedIn.getCurrentUserID(), txtFirstname.getText().strip());	// Update current user first name with new input 
					
						} 
						catch (CustomException error) 
						{
					
							JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
				
					}
					catch (CustomException error)
					{
					
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}
				
			}
		});
		btnFirst.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnFirst.setBounds(310, 200, 150, 25);
		contentPane.add(btnFirst);
		
		JButton btnIdentity = new JButton("Change Identity");
		btnIdentity.setToolTipText("Click To Change Identity To Input");
		btnIdentity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Identity", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) 
				{
					try 
					{
						MySQLQueries.updateIdentity(currentLoggedIn.getCurrentUserID(), comboBoxIdentity.getSelectedItem().toString());			// Update current user identity with new input
					
					} 
					catch (CustomException error) 
					{
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}

				}
				
				
			}
		});
		btnIdentity.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnIdentity.setBounds(310, 400, 150, 25);
		contentPane.add(btnIdentity);
		
		txtDOB = new JTextField();
		txtDOB.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtDOB.setBounds(25, 450, 250, 25);
		contentPane.add(txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblDOB.setBounds(25, 425, 100, 25);
		lblDOB.setForeground(new Color(90, 192, 217));
		contentPane.add(lblDOB);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setBounds(25, 350, 250, 25);
		contentPane.add(passwordField);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setBounds(150, 25, 200, 75);
		contentPane.add(lblElenco);
		
		JLabel lblHeader = new JLabel("Account Details");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(150, 125, 200, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
		
		txtSurname = new JTextField();
		txtSurname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtSurname.setBounds(25, 250, 250, 25);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		JButton btnSurname = new JButton("Change Surname");
		btnSurname.setToolTipText("Click To Change Surame To Input");
		btnSurname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Surname", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) 
				{
				
					try 
					{
					
							AccountApplication.checkValidSurname(txtSurname.getText().strip());				// Check surname input is valid
					
							try 
							{
	
								MySQLQueries.updateSurname(currentLoggedIn.getCurrentUserID(), txtSurname.getText().strip());		// Udate current user surname with new input 
						
					
							} 	
							catch (CustomException error) 
							{
					
								JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
							}
				
					}
					catch (CustomException error)
					{
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}
			
			}
		});
		btnSurname.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnSurname.setBounds(310, 250, 150, 25);
		contentPane.add(btnSurname);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblSurname.setBounds(25, 225, 100, 25);
		lblSurname.setForeground(new Color(90, 192, 217));
		contentPane.add(lblSurname);
		
		comboBoxIdentity = new JComboBox();
		comboBoxIdentity.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		comboBoxIdentity.setBackground(Color.WHITE);
		comboBoxIdentity.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Non-binary"}));
		comboBoxIdentity.setBounds(25, 400, 250, 25);
		AutoCompleteDecorator.decorate(comboBoxIdentity);
		contentPane.add(comboBoxIdentity);
	}
}
