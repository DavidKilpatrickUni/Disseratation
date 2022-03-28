import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSendEmailScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmailAddress;
	private JTextField txtTo;
	private JLabel lblTo;
	private JLabel lblEmail;
	private JLabel lblMessage;
	AdminEmailInfo emailInfo;

	public AdminSendEmailScreen(AdminLoggedIn currentAdmin, String userID) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
			
				String firstname= null;
				String surname= null;
				String email= null;
				
				ResultSet searchAttempt = AdminSQL.accountDetails(userID);	
	
				try {
					while (searchAttempt.next())																	
						{

					
						firstname = searchAttempt.getString("First Name");
						surname = searchAttempt.getString("Last Name");
						email = searchAttempt.getString("Email");
						emailInfo = new AdminEmailInfo(firstname, surname, email);
						
						
						txtTo.setText(emailInfo.getFirstname() + " " + emailInfo.getSurname());
						txtEmailAddress.setText(emailInfo.getEmailAddress());
						
						}
				} catch (SQLException error) {
					
					error.printStackTrace();
				}

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(176, 121, 357, 20);
		contentPane.add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		JTextArea txtMessage = new JTextArea();
		txtMessage.setLineWrap(true);
		txtMessage.setBounds(54, 208, 479, 244);
		contentPane.add(txtMessage);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = null;
				emailInfo.setMessage(txtMessage.getText());
				
				email =(emailInfo.getEmailAddress() + " Dear " + emailInfo.getFirstname() + " " + emailInfo.getSurname() + "\n" + emailInfo.getMessage());
				AdminEmailServices.sendEmail(email);
			}
		});
		btnSend.setBounds(251, 478, 89, 23);
		contentPane.add(btnSend);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
				adminSearchAccountsScreen.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(251, 529, 89, 23);
		contentPane.add(btnBack);
		
		txtTo = new JTextField();
		txtTo.setBounds(176, 79, 357, 20);
		contentPane.add(txtTo);
		txtTo.setColumns(10);
		
		lblTo = new JLabel("Name Of Recipient");
		lblTo.setBounds(54, 82, 112, 14);
		contentPane.add(lblTo);
		
		lblEmail = new JLabel("Email Address");
		lblEmail.setBounds(54, 124, 91, 14);
		contentPane.add(lblEmail);
		
		lblMessage = new JLabel("Message");
		lblMessage.setBounds(54, 182, 48, 14);
		contentPane.add(lblMessage);
		
		
	}
}
