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

/**
 * <h1> Class </h1>
 * 
 * <p>
 * User layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * MainMenuScreen
 * </p>
 * 
 * <p>
 * Main Menu screen of the program that allows easy access to other areas/features of the application through GUI navigation.
 * <br>Has a direct link with <code>MainMenuApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see MainMenuApplication
 */

public class MainMenuScreen extends JFrame {

	// Variables
	
	private JPanel contentPane;
	
	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>MainMenuScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 * 
	 * @see MainMenuScreen
	 * @see LoggedIN
	 */

	public MainMenuScreen(LoggedIn currentLoggedIn) {
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
		
		JButton btnDiscover = new JButton("Discover Songs");
		btnDiscover.setToolTipText("Feature To Discover/Find A Song Suggested By The Elenco Community");
		btnDiscover.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDiscover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiscoverSongScreen frame = new DiscoverSongScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnDiscover.setBounds(175, 300, 150, 25);
		contentPane.add(btnDiscover);
		
		JButton btnSuggest = new JButton("Suggest Songs");
		btnSuggest.setToolTipText("Feature To Add/Upload/Suggest A Song To Elenco Community");
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
		
		JButton btnMyPlaylists = new JButton("My Playlists");
		btnMyPlaylists.setToolTipText("Feature To View/Create/Update Your Own Elenco Playlists");
		btnMyPlaylists.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMyPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyPlaylistsScreen frame = new MyPlaylistsScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnMyPlaylists.setBounds(175, 350, 150, 25);
		contentPane.add(btnMyPlaylists);
		
		JButton btnCommunity = new JButton("Community Playlists");
		btnCommunity.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCommunity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CommunityPlaylistScreen frame = new CommunityPlaylistScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCommunity.setBounds(175, 400, 150, 25);
		contentPane.add(btnCommunity);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setBounds(150, 25, 200, 75);
		contentPane.add(lblElenco);
	
		ImageIcon profileButton =  new ImageIcon(ElencoStartup.class.getResource("/ColourProfileIcon.PNG"));					
		Image buttonImage = profileButton.getImage();															
		Image buttonImageResize = buttonImage.getScaledInstance(75,75, java.awt.Image.SCALE_SMOOTH);		
		profileButton = new ImageIcon(buttonImageResize);														

		JButton btnCircle = new JButton(profileButton);
		btnCircle.setForeground(Color.WHITE);
		btnCircle.setBackground(Color.WHITE);
		btnCircle.setBorder(new CircleButtons(300));
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfileMenuScreen frame = new ProfileMenuScreen(currentLoggedIn);
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
