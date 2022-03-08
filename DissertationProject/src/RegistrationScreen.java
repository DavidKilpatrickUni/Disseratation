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
import java.awt.event.ActionEvent;

public class RegistrationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textUserName;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldConfirm;
	private JTextField textSurname;
	private JTextField textFirstName;
	private JTextField textFieldDay;
	private JTextField textFieldYear;

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
		setBounds(100, 100, 600, 658);
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
				
				
				
				
				/*private JPanel contentPane;
				private JTextField textEmail;
				private JTextField textUserName;
				private JPasswordField passwordFieldPass;
				private JPasswordField passwordFieldConfirm;
				private JTextField textSurname;
				private JTextField textFirstName;
				private JTextField textFieldDay;
				private JTextField textFieldYear;
				*/
				///RegistrationApplication.createAccount( );
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

	
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(186, 183, 109, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(305, 183, 109, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnNB = new JRadioButton("Non-binary");
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
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(163, 236, 96, 20);
		contentPane.add(textFieldDay);
		textFieldDay.setColumns(10);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(421, 225, 96, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "March", "April"}));
		comboBoxMonth.setBounds(296, 224, 96, 22);
		contentPane.add(comboBoxMonth);
		
		JLabel lblHeader = new JLabel("Create Account");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(236, 28, 167, 40);
		contentPane.add(lblHeader);
	}
}
