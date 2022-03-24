import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

public class AdminViewAccountScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstname;
	private JTextField txtSurname;
	private JTextField txtDOB;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JComboBox comboBoxIdentity;
	private JTextField txtUserID;

	public AdminViewAccountScreen(AdminLoggedIn currentAdmin, String selectedUserID) {
		setTitle("Admin - Song Details");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				loadContent(selectedUserID);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(108, 179, 200, 20);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(108, 226, 200, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		comboBoxIdentity = new JComboBox();
		comboBoxIdentity.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Non-binary"}));
		comboBoxIdentity.setBounds(108, 278, 200, 20);
		contentPane.add(comboBoxIdentity);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(108, 326, 200, 20);
		contentPane.add(txtDOB);
		txtDOB.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(108, 421, 200, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(108, 374, 200, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnUpdate1 = new JButton("Update");
		btnUpdate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update First Name?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					AdminSQL.updateFirstname(txtUserID.getText(), txtFirstname.getText()) ;
					JOptionPane.showMessageDialog(null, "Successfully Updated First Name", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnUpdate1.setBounds(335, 178, 89, 23);
		contentPane.add(btnUpdate1);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(108, 470, 200, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnDelete = new JButton("Delete Account");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This account?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deleteAccount(selectedUserID);
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Account", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
						AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
						adminSearchAccountsScreen.setVisible(true);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
				}
			}
		});
		btnDelete.setBounds(141, 572, 150, 23);
		contentPane.add(btnDelete);
		
		JButton btnMain = new JButton("Main Menu");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
				adminSearchAccountsScreen.setVisible(true);
				dispose();
			}
		});
		btnMain.setBounds(171, 631, 100, 23);
		contentPane.add(btnMain);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(10, 182, 70, 14);
		contentPane.add(lblFirstname);
		
		JLabel lblSurname = new JLabel("Last name");
		lblSurname.setBounds(10, 229, 88, 14);
		contentPane.add(lblSurname);
		
		JLabel lblIdentity = new JLabel("Identity");
		lblIdentity.setBounds(10, 281, 48, 14);
		contentPane.add(lblIdentity);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setBounds(10, 329, 70, 14);
		contentPane.add(lblDOB);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 377, 70, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 424, 48, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 473, 48, 14);
		contentPane.add(lblPassword);
		
		JButton btnUpdate2 = new JButton("Update");
		btnUpdate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update Last Name?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					AdminSQL.updateSurname(txtUserID.getText(), txtSurname.getText());
					JOptionPane.showMessageDialog(null, "Successfully Updated Last Name", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnUpdate2.setBounds(335, 225, 89, 23);
		contentPane.add(btnUpdate2);
		
		JButton btnUpdate3 = new JButton("Update");
		btnUpdate3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update Identity?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					AdminSQL.updateIdentity(txtUserID.getText(), comboBoxIdentity.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Successfully Updated Identity", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnUpdate3.setBounds(335, 277, 89, 23);
		contentPane.add(btnUpdate3);
		
		JButton btnUpdate4 = new JButton("Update");
		btnUpdate4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update Date Of Birth?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					AdminSQL.updateDOB(txtUserID.getText(), txtDOB.getText());
					JOptionPane.showMessageDialog(null, "Successfully Updated Date Of Birth", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnUpdate4.setBounds(335, 325, 89, 23);
		contentPane.add(btnUpdate4);
		
		JButton btnUpdate5 = new JButton("Update");
		btnUpdate5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update Username?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.updateUsername(txtUserID.getText(), txtUsername.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Updated Username", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
						AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
						adminSearchAccountsScreen.setVisible(true);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
				
		
			}
		});
		btnUpdate5.setBounds(335, 373, 89, 23);
		contentPane.add(btnUpdate5);
		
		JButton btnUpdate6 = new JButton("Update");
		btnUpdate6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update Email?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.updateEmail(txtUserID.getText(), txtEmail.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Updated Email", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
						AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
						adminSearchAccountsScreen.setVisible(true);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
				

			}
		});
		btnUpdate6.setBounds(335, 420, 89, 23);
		contentPane.add(btnUpdate6);
		
		JButton btnUpdate7 = new JButton("Update");
		btnUpdate7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update Password?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.updatePassword(txtUserID.getText(), txtPassword.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Updated Password", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
						AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
						adminSearchAccountsScreen.setVisible(true);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			
			}
		});
		btnUpdate7.setBounds(335, 469, 89, 23);
		contentPane.add(btnUpdate7);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(108, 131, 200, 20);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(10, 134, 48, 14);
		contentPane.add(lblUserid);
		
		JButton btnBlock = new JButton("Block Account");
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Placeholder for potential feature", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
			}
		});
		btnBlock.setBounds(141, 524, 150, 23);
		contentPane.add(btnBlock);
		
		JLabel lblHeader = new JLabel("Song Details");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHeader.setBounds(127, 26, 224, 43);
		contentPane.add(lblHeader);
	}

	public void loadContent(String selectedUserID) {
		
		ResultSet accountDetails = AdminSQL.accountDetails(selectedUserID);
	
		String userID = null;
		String firstname = null;
		String surname = null;
		String identity = null;
		String DOB = null;
		String username = null;
		String email = null;
		String password =null;

		try 
		{
		
			while (accountDetails.next())																	
			{
				userID = accountDetails.getString("UserID");
				firstname = accountDetails.getString("First Name");
				surname = accountDetails.getString("Last Name");
				identity = accountDetails.getString("Identity");
				DOB = accountDetails.getString("Date Of Birth");
				username = accountDetails.getString("UserName");
				email = accountDetails.getString("Email");
				password = accountDetails.getString("AES_DECRYPT(Password,'encrypt')");
				
				System.out.println("password: " + password);

				txtUserID.setText(userID);
				txtFirstname.setText(firstname);
				txtSurname.setText(surname);
				comboBoxIdentity.setSelectedItem(identity);
				txtDOB.setText(DOB);
				txtUsername.setText(username);
				txtEmail.setText(email);
				txtPassword.setText(password);
				
			}

		}
		catch (SQLException sqe)
		{
		
		}
	}
	
}
