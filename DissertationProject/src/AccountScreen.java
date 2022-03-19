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

public class AccountScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtFirstname;
	private JTextField txtDOB;
	private JPasswordField passwordField;
	private JTextField txtSurname;
	private JComboBox comboBoxIdentity; 
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountScreen frame = new AccountScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	
	
	public AccountScreen(LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Account Details");
		setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				ResultSet accountDetails  = MySQLQueries.getAccountsDetailDecrypted(currentLoggedIn.getCurrentUserID());
				
				
				
				String pass = null;
				String userID = null;
				String email = null;
				String firstname= null;
				String surname = null;
				String identity = null;
				String DOB = null;
						
				try {
					
					if (accountDetails.next())																	
					{
						
						
						pass = accountDetails.getString("AES_DECRYPT(Password,'encrypt')");
						email = accountDetails.getString("Email");
						firstname = accountDetails.getString("First Name");
					surname = accountDetails.getString("Last Name");
					identity = accountDetails.getString("Identity");
						DOB = accountDetails.getString("Date Of Birth");
						
				
						System.out.println("password: " + pass);
						
						
						//comboBoxIdentity.getSelectedItem();
						
						txtEmail.setText(email);
						passwordField.setText(pass);
						txtFirstname.setText(firstname);
						txtSurname.setText(surname);
						comboBoxIdentity.setSelectedItem(identity);
						txtDOB.setText(DOB);
						/*
						private JPanel contentPane;
						private JTextField textFieldUserName;
						private JTextField textFieldEmail;
						private JTextField textFieldFullName;
						private JTextField textFieldIdentity;
						private JTextField textFieldDOB;
						private JPasswordField passwordField;
						*/
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
		
		JButton btnBack = new JButton("My Profile");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Return To Main Menu - All Unconfirmed Input Will Be Lost", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {
				
				ProfileScreen frame = new ProfileScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
				}
			}
		});
		btnBack.setBounds(200, 500, 100, 25);
		contentPane.add(btnBack);
		
		txtEmail = new JTextField();
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
		txtFirstname.setBounds(25, 200, 250, 25);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JButton btnPassword = new JButton("Change Password");
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Password", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {
				try {
					
					AccountApplication.checkValidPassword(passwordField.getText().strip());
					
					
					try 
					{
						
						String confirmPassword;
						confirmPassword = (JOptionPane.showInputDialog("Retype New Password To Confirm"));
						
						if(confirmPassword.equals(passwordField.getText().strip()))
						{
						MySQLQueries.updatePassword(currentLoggedIn.getCurrentUserID(), passwordField.getText().strip());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Confirm Code Doesnt Match - Change Of Password Unsuccessful" , "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
					
					} catch (CustomException error) {
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}catch (CustomException error){
					
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
				}
				
				}
				
				
			}
		});
		btnPassword.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPassword.setBounds(310, 350, 150, 25);
		contentPane.add(btnPassword);
		
		JButton btnFirst = new JButton("Change First Name");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of First Name", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {
				try {
					
					AccountApplication.checkValidFirstname(txtFirstname.getText().strip());
					
					
					try 
					{
						MySQLQueries.updateFirstname(currentLoggedIn.getCurrentUserID(), txtFirstname.getText().strip());
					
					} catch (CustomException error) {
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}catch (CustomException error){
					
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
				}
				
				}
				
			}
		});
		btnFirst.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnFirst.setBounds(310, 200, 150, 25);
		contentPane.add(btnFirst);
		
		JButton btnIdentity = new JButton("Change Identity");
		btnIdentity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Identity", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {
				try 

					{
						MySQLQueries.updateIdentity(currentLoggedIn.getCurrentUserID(), comboBoxIdentity.getSelectedItem().toString());
					
					} catch (CustomException error) {
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
			
				
				}
				
				
			}
		});
		btnIdentity.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnIdentity.setBounds(310, 400, 150, 25);
		contentPane.add(btnIdentity);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(25, 450, 250, 25);
		contentPane.add(txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblDOB.setBounds(25, 425, 100, 25);
		lblDOB.setForeground(new Color(90, 192, 217));
		contentPane.add(lblDOB);
		
		passwordField = new JPasswordField();
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
		txtSurname.setBounds(25, 250, 250, 25);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		JButton btnSurname = new JButton("Change Surname");
		btnSurname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Surname", "Elenco - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {
				try {
					
					AccountApplication.checkValidSurname(txtSurname.getText().strip());
					
					
					try 
					{
						
						
						MySQLQueries.updateSurname(currentLoggedIn.getCurrentUserID(), txtSurname.getText().strip());
						
					
					} catch (CustomException error) {
					
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}catch (CustomException error){
					
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
		comboBoxIdentity.setBackground(Color.WHITE);
		comboBoxIdentity.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Non-binary"}));
		comboBoxIdentity.setBounds(25, 400, 250, 25);
		AutoCompleteDecorator.decorate(comboBoxIdentity);
		contentPane.add(comboBoxIdentity);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showInputDialog("Input code");
			}
		});
		btnNewButton.setBounds(328, 452, 89, 23);
		contentPane.add(btnNewButton);
	}
}
