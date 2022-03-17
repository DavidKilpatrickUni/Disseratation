import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileScreen frame = new ProfileScreen();
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
	public ProfileScreen(LoggedIn currentLoggedIn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("My Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AccountScreen frame = new AccountScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(427, 98, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyProfileScreen frame = new MyProfileScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnMyProfile.setBounds(161, 98, 89, 23);
		contentPane.add(btnMyProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainScreen gui = new MainScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(267, 395, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen gui = new LoginScreen();
				gui.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(267, 284, 89, 23);
		contentPane.add(btnLogOut);
	}

}
