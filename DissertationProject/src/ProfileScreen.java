import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class ProfileScreen extends JFrame {

	private JPanel contentPane;

	public ProfileScreen(LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMyAccount = new JButton("Account Details");
		btnMyAccount.setToolTipText("Click To View Account Details");
		btnMyAccount.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AccountScreen frame = new AccountScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnMyAccount.setBounds(175, 300, 150, 25);
		contentPane.add(btnMyAccount);
		
		JButton btnMyProfile = new JButton("Profile Details");
		btnMyProfile.setToolTipText("Click To View Profile Details");
		btnMyProfile.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyProfileScreen frame = new MyProfileScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnMyProfile.setBounds(175, 250, 150, 25);
		contentPane.add(btnMyProfile);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setToolTipText("Click To Return To Main Menu");
		btnMainMenu.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenuScreen gui = new MainMenuScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setBounds(175, 450, 150, 25);
		contentPane.add(btnMainMenu);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setToolTipText("Click To Log Out Of Elenco");
		btnLogOut.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				int select;																																	
			
				select = JOptionPane.showOptionDialog(null, "Confirm Log Out", "Elence - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) {
				
					LoginScreen gui = new LoginScreen();
					gui.setVisible(true);
					dispose();
				}
			}
		});
		btnLogOut.setBounds(175, 350, 150, 25);
		contentPane.add(btnLogOut);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setBounds(150, 25, 200, 75);
		contentPane.add(lblElenco);
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					
		Image appImage = appIcon.getImage();															
		Image appImageResize = appImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);		
		appIcon = new ImageIcon(appImageResize);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Click To Exit Elenco");
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
		btnExit.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnExit.setBounds(200, 500, 100, 25);
		contentPane.add(btnExit);
		
		JLabel lblHeader = new JLabel("My Profile");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(175, 175, 150, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
		
	}

}
