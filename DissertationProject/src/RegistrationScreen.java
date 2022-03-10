import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class RegistrationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textUserName;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldConfirm;
	private JTextField textSurname;
	private JTextField textFirstName;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnNB;
	private String myIdentity;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationScreen frame = new RegistrationScreen();
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
	public RegistrationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEmail = new JTextField();
		textEmail.setBounds(343, 311, 96, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textUserName = new JTextField();
		textUserName.setBounds(343, 280, 96, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setBounds(97, 314, 112, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(113, 289, 96, 14);
		contentPane.add(lblUsername);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(339, 412, 140, 20);
		contentPane.add(passwordFieldPass);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(97, 415, 48, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(80, 462, 140, 14);
		contentPane.add(lblConfirmPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(339, 459, 144, 20);
		contentPane.add(passwordFieldConfirm);
		
		textSurname = new JTextField();
		textSurname.setBounds(343, 138, 96, 20);
		contentPane.add(textSurname);
		textSurname.setColumns(10);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(343, 92, 96, 20);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!RegistrationApplication.checkBlank(textFirstName.getText().trim()))
				{
					System.out.print(textFirstName.getText().trim()+"\n");
				}
				else {
					System.out.print("name empty\n");
				}
				
				if (!RegistrationApplication.checkLength(passwordFieldPass.getText()))
				{
					System.out.print("passwords too short\n");
				}
				else {
					String message= "passwords long enough\n";
					
					message = message.substring(0,1).toUpperCase() + message.substring(1);		
							
					System.out.print(message);
				}
			
				if (RegistrationApplication.regexCheck(passwordFieldPass.getText()))
				{
					
					System.out.print("legit password \n");
				}
				else {
					System.out.print("Missing password Criteria \n");
				}
				
				if (RegistrationApplication.regexEmail(textEmail.getText()))
				{
					
					System.out.print("legit email \n");
				}
				else {
					System.out.print("Missing email Criteria \n");
				}
				
			
				if (!RegistrationApplication.comparePassword(passwordFieldPass.getText(),passwordFieldConfirm.getText()))
				{
					System.out.print("passwords dont match\n");
				}
				else {
					System.out.print("passwords match\n");
				}
				
				
				
				
				
				if (rdbtnMale.isSelected()) {																											
					
					myIdentity = "Male";	
					System.out.println("Male\n");
					
				}else if (rdbtnFemale.isSelected()) {																								
					
					myIdentity = "Female";	
					System.out.println("Female\n");
					
				}else if (rdbtnNB.isSelected()){
					myIdentity = "Non-binary";
					System.out.println("Non-binary\n");
				}else {
					myIdentity = "";
					System.out.println("no identity selected\n");
				}
				
				
				
				
				
				
				
				System.out.println(dateChooser.getDate());
				
				System.out.println(RegistrationApplication.changeDateFormat(dateChooser.getDate()));
				
				String formattedDate = RegistrationApplication.changeDateFormat(dateChooser.getDate());
				
			
				RegistrationApplication.compareDates(dateChooser.getDate());
				RegistrationApplication.checkAge(dateChooser.getDate());
				
					
				/*private JPanel contentPane;
				private JTextField textEmail;
				private JTextField textUserName;
				private JPasswordField passwordFieldPass;
				private JPasswordField passwordFieldConfirm;
				private JTextField textSurname;
				private JTextField textFirstName;
				private JTextField textFieldDay;
				private JTextField textFieldYear;
				JComboBox comboBoxMonth
				*/
				///RegistrationApplication.createAccount( );
				
				
				
				System.out.println(RegistrationApplication.properCase(textFirstName.getText())+ 
						RegistrationApplication.properCase(textSurname.getText())+
						RegistrationApplication.dateForDatabase(RegistrationApplication.changeDateFormat(dateChooser.getDate()))+
						myIdentity+
						textUserName.getText()+
						passwordFieldPass.getText()+
						textEmail.getText());
			
			}
		});
		btnCreate.setBounds(222, 498, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen gui = new LoginScreen();
				gui.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(222, 551, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
		
		
		
		

		ButtonGroup radioButtons = new ButtonGroup();

	
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(186, 183, 109, 23);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(305, 183, 109, 23);
		contentPane.add(rdbtnFemale);
		
		rdbtnNB = new JRadioButton("Non-binary");
		rdbtnNB.setBounds(442, 183, 109, 23);
		contentPane.add(rdbtnNB);
		
		radioButtons.add(rdbtnMale);																							
		radioButtons.add(rdbtnFemale);	
		radioButtons.add(rdbtnNB);
		

		
		
		
		
		
		
		
		
		
		
		
		JLabel lblFirst = new JLabel("First Name");
		lblFirst.setBounds(113, 95, 96, 14);
		contentPane.add(lblFirst);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(133, 141, 48, 14);
		contentPane.add(lblSurname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(83, 187, 48, 14);
		contentPane.add(lblGender);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setBounds(67, 228, 78, 14);
		contentPane.add(lblDOB);
		
		JLabel lblHeader = new JLabel("Create Account");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(236, 28, 167, 40);
		contentPane.add(lblHeader);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(186, 228, 253, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationApplication.createAccount(RegistrationApplication.properCase(textFirstName.getText()), 
						RegistrationApplication.properCase(textSurname.getText()), 
						RegistrationApplication.dateForDatabase(RegistrationApplication.changeDateFormat(dateChooser.getDate())),
						myIdentity,
						textUserName.getText(),
						passwordFieldPass.getText(),
						textEmail.getText());
				
			}
		});
		btnNewButton.setBounds(392, 498, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationApplication.createAccount();
			}
		});
		btnNewButton_1.setBounds(536, 432, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	
	}
}
