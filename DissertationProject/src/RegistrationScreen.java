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
import javax.swing.JOptionPane;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Panel;

public class RegistrationScreen extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JTextField txtEmail;
	private JTextField txtUserName;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldConfirm;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnNB;

	public RegistrationScreen() {
		setTitle("Elenco - Create Account");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Enter Your Email For This New Account Here");
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtEmail.setBounds(200, 350, 250, 25);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("Enter Your Username For This New Account Here");
		txtUserName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtUserName.setBounds(200, 300, 250, 25);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setToolTipText("Enter Your Email For This New Account Here");
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 12));
		lblEmail.setBounds(50, 350, 150, 25);
		lblEmail.setForeground(new Color(90, 192, 217));
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setToolTipText("Enter Your Username For This New Account Here");
		lblUsername.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUsername.setBounds(50, 300, 150, 25);
		lblUsername.setForeground(new Color(90, 192, 217));
		contentPane.add(lblUsername);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setToolTipText("Enter Your Password For This New Account Here");
		passwordFieldPass.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		passwordFieldPass.setBounds(200, 400, 250, 25);
		contentPane.add(passwordFieldPass);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Enter Your Password For This New Account Here");
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPassword.setBounds(50, 400, 150, 25);
		lblPassword.setForeground(new Color(90, 192, 217));
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setToolTipText("Confirm Your Password Here");
		lblConfirmPassword.setFont(new Font("Georgia", Font.BOLD, 12));
		lblConfirmPassword.setBounds(50, 450, 150, 25);
		lblConfirmPassword.setForeground(new Color(90, 192, 217));
		contentPane.add(lblConfirmPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setToolTipText("Confirm Your Password Here");
		passwordFieldConfirm.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		passwordFieldConfirm.setBounds(200, 450, 250, 25);
		contentPane.add(passwordFieldConfirm);
		
		txtSurname = new JTextField();
		txtSurname.setToolTipText("Enter Your Surname For This New Account Here");
		txtSurname.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtSurname.setBounds(200, 150, 250, 25);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("Enter Your First Name For This New Account Here");
		txtFirstName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));

	
		txtFirstName.setBounds(200, 100, 250, 25);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setToolTipText("Enter Your Details Above Then Click To Create A New Account");
		btnCreate.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFirstName.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtSurname.setBorder(new LineBorder(Color.LIGHT_GRAY));
				rdbtnMale.setForeground(new Color(90, 192, 217));
				rdbtnFemale.setForeground(new Color(90, 192, 217));
				rdbtnNB.setForeground(new Color(90, 192, 217));
				dateChooser.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtUserName.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtEmail.setBorder(new LineBorder(Color.LIGHT_GRAY));
				passwordFieldPass.setBorder(new LineBorder(Color.LIGHT_GRAY));
				passwordFieldConfirm.setBorder(new LineBorder(Color.LIGHT_GRAY));
				
				String myIdentity;
				
				if (rdbtnMale.isSelected()) {																											
					
					myIdentity = "Male";	
					
				}else if (rdbtnFemale.isSelected()) {																								
					
					myIdentity = "Female";	
		
				}else if (rdbtnNB.isSelected()){
					
					myIdentity = "Non-binary";
		
				}else {
					
					myIdentity = "";
					
				}
				
				System.out.println("Idetity selected: " + myIdentity);
				
				try {
					
					if(RegistrationApplication.checkRegistrationForm(txtFirstName.getText(), 
								txtSurname.getText(), 
								myIdentity, 
								dateChooser.getDate(),
								txtUserName.getText(), 
								txtEmail.getText(), 
								passwordFieldPass.getText(), 
								passwordFieldConfirm.getText()) == "continue")
			
					{
						
						try
						{
							
							String sentCode;
							String confirmCode;
							String confirmEmail;
						
							sentCode = EmailServices.randomConfirmCode();
							confirmEmail =  sentCode + txtEmail.getText().strip();
							
							EmailServices.confirmEmail(confirmEmail);
							
							confirmCode = (JOptionPane.showInputDialog("An Email Has Been Sent To The Address Provided With A 5-Digit Confirm Code - Enter The Code "));
						
							System.out.println("Confirm Code: " + confirmCode);
							System.out.println("Sent Code: " + sentCode);
						
							if (confirmCode.toString().equals(sentCode)) {
								
								System.out.println("Codes Match");
							
								MySQLQueries.createAccount(txtFirstName.getText().strip(), 
										txtSurname.getText().strip(), 									
										Helper.dateForDatabase(Helper.changeDateFormat(dateChooser.getDate())) ,
										myIdentity.strip(),
										txtUserName.getText().strip(), 				
										passwordFieldPass.getText().strip(),
										txtEmail.getText().strip());
						
								JOptionPane.showMessageDialog(null, "Successfully Created An Elenco Account", "Elenco - New Account Created", JOptionPane.INFORMATION_MESSAGE,null);
						
								LoginScreen mainScreen = new LoginScreen();
								mainScreen.setVisible(true);
								dispose();
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Confirm Email Code Does Not Match Expected Input", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
							}
						}
						catch (CustomException SQLError)
						{
							JOptionPane.showMessageDialog(null, SQLError.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
					}
				}
				catch (CustomException error) {
					 
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					
					switch(error.getReason())
					{
						case "firstname":
							txtFirstName.setBorder(new LineBorder(Color.RED));
							break;
						case "surname":
							txtSurname.setBorder(new LineBorder(Color.RED));
							break;
						case "identity":
							rdbtnMale.setForeground(Color.RED);
							rdbtnFemale.setForeground(Color.RED);
							rdbtnNB.setForeground(Color.RED);
						break;
						case "DOB":
							dateChooser.setBorder(new LineBorder(Color.RED));
							break;
						case "username":
							txtUserName.setBorder(new LineBorder(Color.RED));
							break;
						case "email":
							txtEmail.setBorder(new LineBorder(Color.RED));
							break;
						case "password":
							passwordFieldPass.setBorder(new LineBorder(Color.RED));
							break;
						case "confirm":
							passwordFieldConfirm.setBorder(new LineBorder(Color.RED));
							break;
					}	
				
				}				
			}
		});
		btnCreate.setBounds(187, 500, 150, 25);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Click To Return To Login Screen");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Return To Login Screen??", "Elenco - Return To Login Screen", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {		
				
					LoginScreen gui = new LoginScreen();
					gui.setVisible(true);
					dispose();
					
				}
				
			}
		});
		btnBack.setBounds(212, 550, 100, 25);
		contentPane.add(btnBack);
		
		ButtonGroup radioButtons = new ButtonGroup();

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setToolTipText("Select Male As Prefered Identity");
		rdbtnMale.setBorder(new LineBorder(Color.GREEN));
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnMale.setBounds(192, 200, 75, 25);
		rdbtnMale.setForeground(new Color(90, 192, 217));
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setToolTipText("Select Female As Prefered Identity");
		rdbtnFemale.setBorder(new LineBorder(Color.WHITE));
		rdbtnFemale.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnFemale.setBackground(new Color(255, 255, 255));
		rdbtnFemale.setBounds(268, 200, 75, 25);
		rdbtnFemale.setForeground(new Color(90, 192, 217));
		contentPane.add(rdbtnFemale);
		
		rdbtnNB = new JRadioButton("Non-binary");
		rdbtnNB.setToolTipText("Select Non-binary As Prefered Identity");
		rdbtnNB.setBorder(new LineBorder(Color.WHITE));
		rdbtnNB.setBackground(new Color(255, 255, 255));
		rdbtnNB.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnNB.setBounds(358, 200, 100, 25);
		rdbtnNB.setForeground(new Color(90, 192, 217));
		contentPane.add(rdbtnNB);
		
		radioButtons.add(rdbtnMale);																							
		radioButtons.add(rdbtnFemale);	
		radioButtons.add(rdbtnNB);

		JLabel lblFirst = new JLabel("First Name");
		lblFirst.setToolTipText("Enter Your First Name For This New Account Here");
		lblFirst.setFont(new Font("Georgia", Font.BOLD, 12));
		lblFirst.setBounds(50, 100, 150, 25);
		lblFirst.setForeground(new Color(90, 192, 217));
		contentPane.add(lblFirst);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setToolTipText("Enter Your Surname For This New Account Here");
		lblSurname.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSurname.setBounds(50, 150, 150, 25);
		lblSurname.setForeground(new Color(90, 192, 217));
		contentPane.add(lblSurname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setToolTipText("Select Your Prefered Identity For This New Account Here");
		lblGender.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGender.setBounds(50, 200, 150, 25);
		lblGender.setForeground(new Color(90, 192, 217));
		contentPane.add(lblGender);
		
		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setToolTipText("Enter Your Date Of Birth For This New Account Here - New Members Must Be 16 Or Older");
		lblDOB.setFont(new Font("Georgia", Font.BOLD, 12));
		lblDOB.setBounds(50, 250, 150, 25);
		lblDOB.setForeground(new Color(90, 192, 217));
		contentPane.add(lblDOB);
		
		JLabel lblHeader = new JLabel("Create Account");
		lblHeader.setToolTipText("Create An Elenco Account Screen");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 30));
		lblHeader.setForeground(new Color(90, 192, 217));
		lblHeader.setBounds(112, 25, 300, 40);
		contentPane.add(lblHeader);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(200, 250, 250, 25);
		dateChooser.setToolTipText("Enter Your Date Of Birth For This New Account Here - New Members Must Be 16 Or Older");
		contentPane.add(dateChooser);
		
		JButton btnExit = new JButton("Exit");
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
		btnExit.setToolTipText("Click To Exit Elenco");
		btnExit.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnExit.setBounds(212, 600, 100, 25);
		contentPane.add(btnExit);
	
	
	}
}
