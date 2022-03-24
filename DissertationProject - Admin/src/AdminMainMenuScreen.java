import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminMainMenuScreen extends JFrame {

	private JPanel contentPane;


	public AdminMainMenuScreen(AdminLoggedIn currentAdmin) {
		setTitle("Admin - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("Admin Menu");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(170, 53, 169, 47);
		contentPane.add(lblHeader);
		
		JButton btnSongs = new JButton("Songs");
		btnSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchSongsScreen adminSearchSongsScreen = new AdminSearchSongsScreen(currentAdmin);
				adminSearchSongsScreen.setVisible(true);
				dispose();
			}
		});
		btnSongs.setBounds(170, 201, 125, 23);
		contentPane.add(btnSongs);
		
		JButton btnPlaylists = new JButton("Playlists");
		btnPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchPlaylistScreen adminSearchPlaylistScreen = new AdminSearchPlaylistScreen(currentAdmin);
				adminSearchPlaylistScreen.setVisible(true);
				dispose();
			}
		});
		btnPlaylists.setBounds(170, 253, 125, 23);
		contentPane.add(btnPlaylists);
		
		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchAccountsScreen adminSearchAccountsScreen = new AdminSearchAccountsScreen(currentAdmin);
				adminSearchAccountsScreen.setVisible(true);
				dispose();
			}
		});
		btnAccounts.setBounds(170, 301, 125, 23);
		contentPane.add(btnAccounts);
		
		JButton btnComments = new JButton("Comments");
		btnComments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchCommentsScreen adminSearchCommentsScreen = new AdminSearchCommentsScreen(currentAdmin);
				adminSearchCommentsScreen.setVisible(true);
				dispose();
			}
		});
		btnComments.setBounds(170, 355, 125, 23);
		contentPane.add(btnComments);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			}
		});
		btnExit.setBounds(182, 488, 89, 23);
		contentPane.add(btnExit);
	}
}
