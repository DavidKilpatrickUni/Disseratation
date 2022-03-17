import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen(LoggedIn currentLoggedIn) {
		setTitle("Elenco - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 596);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("Main Menu");
		lblHeader.setBounds(195, 124, 142, 14);
		contentPane.add(lblHeader);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setOpaque(false);
		btnProfile.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProfile.setForeground(Color.BLACK);
		btnProfile.setBackground(Color.WHITE);
		
		
		
		
		
	
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfileScreen frame = new ProfileScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnProfile.setBounds(377, 47, 160, 36);
		contentPane.add(btnProfile);
	
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(226, 472, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnDiscover = new JButton("Discover Songs");
		btnDiscover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiscoverScreen frame = new DiscoverScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnDiscover.setBounds(188, 291, 127, 23);
		contentPane.add(btnDiscover);
		
		JButton btnSuggest = new JButton("Suggest Songs");
		btnSuggest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestSongScreen frame = new SuggestSongScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSuggest.setBounds(73, 186, 242, 91);
		contentPane.add(btnSuggest);
		
		JButton btnNewMyPlaylist = new JButton("My Playlist");
		btnNewMyPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyPlaylistsScreen frame = new MyPlaylistsScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewMyPlaylist.setBounds(185, 325, 142, 23);
		contentPane.add(btnNewMyPlaylist);
		
		JButton btnNewButton = new JButton("Discover Playlists");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPlaylistScreen frame = new SearchPlaylistScreen();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(195, 370, 132, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setBounds(150, 15, 200, 75);
		contentPane.add(lblElenco);
		
		JLabel lblProfile = new JLabel("My Profile");
		lblProfile.setBounds(433, 295, 48, 14);
		contentPane.add(lblProfile);
	}
	

	
}
