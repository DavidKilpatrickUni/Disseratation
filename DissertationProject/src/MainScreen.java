import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Toolkit;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private static MainScreen mainScreen;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 596);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("Main Menu");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(175, 175, 150, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
	
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Elenco - Exit", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {																					// If Statement. Variable value is YES.
					
					System.exit(1);																								// Use connection with Controller to start method.																					
					
				}
			}
		});
		btnExit.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnExit.setBounds(200, 500, 100, 25);
		contentPane.add(btnExit);
		
		JButton btnDiscover = new JButton("Discover Songs");
		btnDiscover.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDiscover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiscoverScreen frame = new DiscoverScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnDiscover.setBounds(175, 300, 150, 25);
		contentPane.add(btnDiscover);
		
		JButton btnSuggest = new JButton("Suggest Songs");
		btnSuggest.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnSuggest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuggestSongScreen frame = new SuggestSongScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSuggest.setBounds(175, 250, 150, 25);
		contentPane.add(btnSuggest);
		
		JButton btnNewMyPlaylist = new JButton("My Playlist");
		btnNewMyPlaylist.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewMyPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyPlaylistsScreen frame = new MyPlaylistsScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewMyPlaylist.setBounds(175, 350, 150, 25);
		contentPane.add(btnNewMyPlaylist);
		
		JButton btnNewButton = new JButton("Discover Playlists");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPlaylistScreen frame = new SearchPlaylistScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(175, 400, 150, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setBounds(150, 25, 200, 75);
		contentPane.add(lblElenco);
	

		
	
		
		ImageIcon profileButton =  new ImageIcon(ApplicationStartup.class.getResource("/ColourProfileIcon.PNG"));					// Create new instance of Icon using the given PNG file.
		Image buttonImage = profileButton.getImage();															// Create image of icon variable.
		Image buttonImageResize = buttonImage.getScaledInstance(75,75, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		profileButton = new ImageIcon(buttonImageResize);														// Set instance of Icon to the resized Image.
		
		
		JButton btnCircle = new JButton(profileButton);
		btnCircle.setForeground(Color.WHITE);
		btnCircle.setBackground(Color.WHITE);
		btnCircle.setBorder(new CircleButtons(300));
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfileScreen frame = new ProfileScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnCircle.setBounds(400, 20, 75, 75);
		contentPane.add(btnCircle);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setBounds(400, 95, 75, 14);
		lblMyProfile.setForeground(new Color(90, 192, 217));
		contentPane.add(lblMyProfile);
		
	
		
		
	}
}
