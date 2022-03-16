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

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	public MainScreen(String currentUserID, String currentUserName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("Main Menu");
		lblHeader.setBounds(367, 32, 142, 14);
		contentPane.add(lblHeader);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfileScreen frame = new ProfileScreen(currentUserID,currentUserName);
				frame.setVisible(true);
				dispose();
			}
		});
		btnProfile.setBounds(883, 28, 89, 23);
		contentPane.add(btnProfile);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(385, 445, 89, 23);
		contentPane.add(btnExit);
		
		textField = new JTextField();
		textField.setBounds(545, 29, 96, 20);
		textField.setText(currentUserName);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDiscover = new JButton("Discover");
		btnDiscover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiscoverScreen frame = new DiscoverScreen(currentUserID, currentUserName);
				frame.setVisible(true);
				dispose();
			}
		});
		btnDiscover.setBounds(532, 231, 89, 23);
		contentPane.add(btnDiscover);
		
		JButton btnSuggest = new JButton("Suggest");
		btnSuggest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestSongScreen frame = new SuggestSongScreen(currentUserID, currentUserName);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSuggest.setBounds(173, 231, 89, 23);
		contentPane.add(btnSuggest);
		
		JButton btnNewMyPlaylist = new JButton("My Playlist");
		btnNewMyPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyPlaylistsScreen frame = new MyPlaylistsScreen(currentUserID, currentUserName);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewMyPlaylist.setBounds(152, 308, 142, 23);
		contentPane.add(btnNewMyPlaylist);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPlaylistScreen frame = new SearchPlaylistScreen();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(555, 308, 89, 23);
		contentPane.add(btnNewButton);
	}
}
