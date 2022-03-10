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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldFullName;
	private JTextField textFieldIdentity;
	private JTextField textFieldDOB;
	private JPasswordField passwordField;

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
	
	
	
	public AccountScreen(String currentUserID, String currentUserName) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				ResultSet accountDetails  = AccountApplication.getAccountsDetail(currentUserID);
				
				
				
				String pass = null;
				String userID = null;
				String email = null;
				String fullName= null;
				String identity = null;
				String DOB = null;
						
				try {
					
					if (accountDetails.next())																	
					{
						userID = accountDetails.getString("UserID");
						
						pass = accountDetails.getString("Password");
						email = accountDetails.getString("Email");
						fullName = accountDetails.getString("First Name") + " " + accountDetails.getString("Last Name");
					identity = accountDetails.getString("Identity");
						DOB = accountDetails.getString("Date Of Birth");
						
				
						System.out.println(pass);
						
						
						textFieldEmail.setText(email);
						passwordField.setText(pass);
						textFieldFullName.setText(fullName);
						textFieldIdentity.setText(identity);
						textFieldDOB.setText(DOB);
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
		setBounds(100, 100, 636, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("My Account");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblHeader.setBounds(190, 37, 270, 47);
		contentPane.add(lblHeader);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfileScreen frame = new ProfileScreen(currentUserID, currentUserName);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(266, 508, 89, 23);
		contentPane.add(btnBack);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(56, 265, 230, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(46, 240, 133, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(56, 296, 161, 14);
		contentPane.add(lblPassword);
		
		JLabel lblIdentity = new JLabel("Identity");
		lblIdentity.setBounds(56, 357, 48, 14);
		contentPane.add(lblIdentity);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(46, 115, 89, 14);
		contentPane.add(lblFullName);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setBounds(56, 140, 230, 20);
		contentPane.add(textFieldFullName);
		textFieldFullName.setColumns(10);
		
		JButton btnEmail = new JButton("Change Email");
		btnEmail.setBounds(362, 247, 164, 23);
		contentPane.add(btnEmail);
		
		JButton btnPassword = new JButton("Change Password");
		btnPassword.setBounds(362, 292, 164, 23);
		contentPane.add(btnPassword);
		
		JButton btnName = new JButton("Change Name");
		btnName.setBounds(362, 139, 146, 23);
		contentPane.add(btnName);
		
		JButton btnIdentity = new JButton("Change Identity");
		btnIdentity.setBounds(362, 353, 146, 23);
		contentPane.add(btnIdentity);
		
		textFieldIdentity = new JTextField();
		textFieldIdentity.setBounds(56, 395, 230, 20);
		contentPane.add(textFieldIdentity);
		textFieldIdentity.setColumns(10);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setBounds(56, 451, 144, 20);
		contentPane.add(textFieldDOB);
		textFieldDOB.setColumns(10);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setBounds(33, 426, 102, 14);
		contentPane.add(lblDOB);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(56, 321, 230, 20);
		contentPane.add(passwordField);
	}
}
