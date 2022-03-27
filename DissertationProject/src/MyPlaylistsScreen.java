import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Icon;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * MyPlaylistScreen
 * </p>
 * 
 * <p>
 * Allows users to view or create their own playlists using songs from the Elenco database part of the program. 
 * <br>Has a direct link with <code>MyPlaylistsApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see MyPlaylistsApplication
 */

public class MyPlaylistsScreen extends JFrame {

	// Variables
	
	private JPanel contentPane;
	private JTextField txtPlaylistTitle1;
	private JTextField txtPlaylistTitle2;
	private JTextField txtPlaylistTitle3;
	private JTextField txtPlaylistTitle4;
	private JTextField txtPlaylistTitle5;

	private JTextField txtPlaylistTitle6;
	private JTextField txtPlaylistTitle7;
	private JTextField txtPlaylistTitle8;
	private JTextField txtPlaylistTitle9;
	private JTextField txtPlaylistTitle10;
	private JLabel lblPlaylistIcon1;
	private JLabel lblPlaylistIcon2;
	
	private JButton btnPlaylist1;
	private JButton btnPlaylist2;
	private JButton btnPlaylist3;
	private JButton btnPlaylist4;
	private JButton btnPlaylist5;
	private JButton btnPlaylist6;
	private JButton btnPlaylist7;
	private JButton btnPlaylist8;
	private JButton btnPlaylist9;
	private JButton btnPlaylist10;
	private JTextField txtPlaylistID1;
	private JTextField txtPlaylistID2;
	private JTextField txtPlaylistID3;
	private JTextField txtPlaylistID4;
	private JTextField txtPlaylistID5;
	private JTextField txtPlaylistID6;
	private JTextField txtPlaylistID7;
	private JTextField txtPlaylistID8;
	private JTextField txtPlaylistID9;
	private JTextField txtPlaylistID10;
	
	private JButton btnDeleteList1;
	private JButton btnDeleteList2;
	private JButton btnDeleteList3;
	private JButton btnDeleteList4;
	private JButton btnDeleteList5;
	private JButton btnDeleteList6;
	private JButton btnDeleteList7;
	private JButton btnDeleteList8;
	private JButton btnDeleteList9;
	private JButton btnDeleteList10;
	
	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>MyPlaylistsScreen</code> class. 
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
	 * @see MyPlaylistsScreen
	 * @see LoggedIN
	 */
	
	public MyPlaylistsScreen( LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - My Playlists");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				clearScreen() ;
				loadContent(currentLoggedIn);

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 649);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPlaylist1 = new JButton("Create List");
		btnPlaylist1.setToolTipText("Click To View/Create Playlist");
		btnPlaylist1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID1.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
	
			}
		});
		btnPlaylist1.setBounds(50, 280, 100, 25);
		contentPane.add(btnPlaylist1);
		
		btnPlaylist6 = new JButton("Create List");
		btnPlaylist6.setToolTipText("Click To View/Create Playlist");
		btnPlaylist6.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 			PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID6.getText(),null);
	 			ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
	 			gui.setVisible(true);
	 			dispose();
	 		
	 		}
		});
		btnPlaylist6.setEnabled(false);
		btnPlaylist6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist6.setBounds(50, 480, 100, 25);
		contentPane.add(btnPlaylist6);
		
		btnPlaylist2 = new JButton("Create List");
		btnPlaylist2.setToolTipText("Click To View/Create Playlist");
		btnPlaylist2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 		
				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID2.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
		
			}
		});
		btnPlaylist2.setEnabled(false);
		btnPlaylist2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist2.setBounds(215, 280, 100, 25);
		contentPane.add(btnPlaylist2);
		
		btnPlaylist7 = new JButton("Create List");
		btnPlaylist7.setToolTipText("Click To View/Create Playlist");
		btnPlaylist7.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 
				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID7.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
			
		 	}
		});
		btnPlaylist7.setEnabled(false);
		btnPlaylist7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist7.setBounds(215, 480, 100, 25);
		contentPane.add(btnPlaylist7);
		
		btnPlaylist3 = new JButton("Create List");
		btnPlaylist3.setToolTipText("Click To View/Create Playlist");
		btnPlaylist3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID3.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();

			}
		});
		btnPlaylist3.setEnabled(false);
		btnPlaylist3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist3.setBounds(385, 280, 100, 25);
		contentPane.add(btnPlaylist3);
		
		btnPlaylist8 = new JButton("Create List");
		btnPlaylist8.setToolTipText("Click To View/Create Playlist");
		btnPlaylist8.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID8.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
			
		 	}
		});
		btnPlaylist8.setEnabled(false);
		btnPlaylist8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist8.setBounds(385, 480, 100, 25);
		contentPane.add(btnPlaylist8);
		
		btnPlaylist4 = new JButton("Create List");
		btnPlaylist4.setToolTipText("Click To View/Create Playlist");
		btnPlaylist4.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 			PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID4.getText(),null);
	 			ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
			
	 		}
		});
		btnPlaylist4.setEnabled(false);
		btnPlaylist4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist4.setBounds(555, 280, 100, 25);
		contentPane.add(btnPlaylist4);
		
		btnPlaylist9 = new JButton("Create List");
		btnPlaylist9.setToolTipText("Click To View/Create Playlist");
		btnPlaylist9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID9.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
		
			}
		});
		btnPlaylist9.setEnabled(false);
		btnPlaylist9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist9.setBounds(555, 480, 100, 25);
		contentPane.add(btnPlaylist9);
		
		btnPlaylist5 = new JButton("Create List");
		btnPlaylist5.setToolTipText("Click To View/Create Playlist");
		btnPlaylist5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID5.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
			
			}
		});
		btnPlaylist5.setEnabled(false);
		btnPlaylist5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist5.setBounds(725, 280, 100, 25);
		contentPane.add(btnPlaylist5);
		
		btnPlaylist10 = new JButton("Create List");
		btnPlaylist10.setToolTipText("Click To View/Create Playlist");
		btnPlaylist10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PlaylistInfo currentPlaylistInfo = new PlaylistInfo(txtPlaylistID10.getText(),null);
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
			
			}
		});
		btnPlaylist10.setEnabled(false);
		btnPlaylist10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPlaylist10.setBounds(725, 480, 100, 25);
		contentPane.add(btnPlaylist10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Return To Main Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenuScreen gui = new MainMenuScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(388, 561, 89, 25);
		contentPane.add(btnBack);
		
		txtPlaylistTitle1 = new JTextField();
		txtPlaylistTitle1.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle1.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle1.setBounds(25, 250, 150, 20);
		contentPane.add(txtPlaylistTitle1);
		txtPlaylistTitle1.setColumns(10);
		
		txtPlaylistTitle2 = new JTextField();
		txtPlaylistTitle2.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle2.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle2.setBounds(190, 250, 150, 20);
		contentPane.add(txtPlaylistTitle2);
		txtPlaylistTitle2.setColumns(10);
		
		txtPlaylistTitle3 = new JTextField();
		txtPlaylistTitle3.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle3.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle3.setBounds(360, 250, 150, 20);
		contentPane.add(txtPlaylistTitle3);
		txtPlaylistTitle3.setColumns(10);
		
		txtPlaylistTitle4 = new JTextField();
		txtPlaylistTitle4.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle4.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle4.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle4.setBounds(530, 250, 150, 20);
		contentPane.add(txtPlaylistTitle4);
		txtPlaylistTitle4.setColumns(10);
		
		txtPlaylistTitle5 = new JTextField();
		txtPlaylistTitle5.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle5.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle5.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle5.setBounds(700, 250, 150, 20);
		contentPane.add(txtPlaylistTitle5);
		txtPlaylistTitle5.setColumns(10);
		
		txtPlaylistTitle6 = new JTextField();
		txtPlaylistTitle6.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle6.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle6.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle6.setColumns(10);
		txtPlaylistTitle6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle6.setBounds(25, 450, 150, 20);
		contentPane.add(txtPlaylistTitle6);
		
		txtPlaylistTitle7 = new JTextField();
		txtPlaylistTitle7.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle7.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle7.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle7.setColumns(10);
		txtPlaylistTitle7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle7.setBounds(190, 450, 150, 20);
		contentPane.add(txtPlaylistTitle7);
		
		txtPlaylistTitle8 = new JTextField();
		txtPlaylistTitle8.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle8.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle8.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle8.setColumns(10);
		txtPlaylistTitle8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle8.setBounds(360, 450, 150, 20);
		contentPane.add(txtPlaylistTitle8);
		
		txtPlaylistTitle9 = new JTextField();
		txtPlaylistTitle9.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle9.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle9.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle9.setColumns(10);
		txtPlaylistTitle9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle9.setBounds(530, 450, 150, 20);
		contentPane.add(txtPlaylistTitle9);
		
		txtPlaylistTitle10 = new JTextField();
		txtPlaylistTitle10.setToolTipText("Name Of Playlist ");
		txtPlaylistTitle10.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPlaylistTitle10.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaylistTitle10.setColumns(10);
		txtPlaylistTitle10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle10.setBounds(700, 450, 150, 20);
		contentPane.add(txtPlaylistTitle10);
		
		JLabel lblHeader = new JLabel("Elenco - My Playlists");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(new Color(90, 192, 217));
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setBounds(342, 59, 300, 25);
		contentPane.add(lblHeader);
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));				
		Image appImage = appIcon.getImage();															
		Image appImageResize = appImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		
		appIcon = new ImageIcon(appImageResize);													
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(258, 22, 100, 100);
		contentPane.add(lblLogo);
		
		
		ImageIcon playlistIcon =  new ImageIcon(ApplicationStartup.class.getResource("/ProfileIcon.PNG"));					
		Image playlistImage = playlistIcon.getImage();															
		Image playlistImageResize = playlistImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);	
		playlistIcon = new ImageIcon(playlistImageResize);														
		
		
		lblPlaylistIcon1 = new JLabel(playlistIcon);
		lblPlaylistIcon1.setBounds(50, 150, 100, 100);
		contentPane.add(lblPlaylistIcon1);
		
		lblPlaylistIcon2 = new JLabel(playlistIcon);
		lblPlaylistIcon2.setBounds(50, 350, 100, 100);
		contentPane.add(lblPlaylistIcon2);
		
		txtPlaylistID1 = new JTextField();
		txtPlaylistID1.setVisible(false);
		txtPlaylistID1.setBounds(87, 127, 25, 20);
		contentPane.add(txtPlaylistID1);
		txtPlaylistID1.setColumns(10);
		
		txtPlaylistID2 = new JTextField();
		txtPlaylistID2.setVisible(false);
		txtPlaylistID2.setColumns(10);
		txtPlaylistID2.setBounds(240, 133, 25, 20);
		contentPane.add(txtPlaylistID2);
		
		txtPlaylistID3 = new JTextField();
		txtPlaylistID3.setVisible(false);
		txtPlaylistID3.setColumns(10);
		txtPlaylistID3.setBounds(408, 127, 25, 20);
		contentPane.add(txtPlaylistID3);
		
		txtPlaylistID4 = new JTextField();
		txtPlaylistID4.setVisible(false);
		txtPlaylistID4.setColumns(10);
		txtPlaylistID4.setBounds(566, 127, 25, 20);
		contentPane.add(txtPlaylistID4);
		
		txtPlaylistID5 = new JTextField();
		txtPlaylistID5.setVisible(false);
		txtPlaylistID5.setColumns(10);
		txtPlaylistID5.setBounds(743, 127, 25, 20);
		contentPane.add(txtPlaylistID5);
		
		txtPlaylistID6 = new JTextField();
		txtPlaylistID6.setVisible(false);
		txtPlaylistID6.setColumns(10);
		txtPlaylistID6.setBounds(87, 563, 25, 20);
		contentPane.add(txtPlaylistID6);
		
		txtPlaylistID7 = new JTextField();
		txtPlaylistID7.setVisible(false);
		txtPlaylistID7.setColumns(10);
		txtPlaylistID7.setBounds(258, 566, 25, 20);
		contentPane.add(txtPlaylistID7);
		
		txtPlaylistID8 = new JTextField();
		txtPlaylistID8.setVisible(false);
		txtPlaylistID8.setColumns(10);
		txtPlaylistID8.setBounds(422, 590, 25, 20);
		contentPane.add(txtPlaylistID8);
		
		txtPlaylistID9 = new JTextField();
		txtPlaylistID9.setVisible(false);
		txtPlaylistID9.setColumns(10);
		txtPlaylistID9.setBounds(603, 579, 25, 20);
		contentPane.add(txtPlaylistID9);
		
		txtPlaylistID10 = new JTextField();
		txtPlaylistID10.setVisible(false);
		txtPlaylistID10.setColumns(10);
		txtPlaylistID10.setBounds(765, 579, 25, 20);
		contentPane.add(txtPlaylistID10);
		
		btnDeleteList1 = new JButton("Delete List");
		btnDeleteList1.setToolTipText("Click To Delete Playlist");
		btnDeleteList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID1.getText() );																							// Delete the selected Playlist of given userID																						
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
				
			}
		});
		btnDeleteList1.setEnabled(false);
		btnDeleteList1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList1.setBounds(50, 315, 100, 25);
		contentPane.add(btnDeleteList1);
		
		btnDeleteList2 = new JButton("Delete List");
		btnDeleteList2.setToolTipText("Click To Delete Playlist");
		btnDeleteList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID2.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
			}
		});
		btnDeleteList2.setEnabled(false);
		btnDeleteList2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList2.setBounds(215, 315, 100, 25);
		contentPane.add(btnDeleteList2);
		
		btnDeleteList3 = new JButton("Delete List");
		btnDeleteList3.setToolTipText("Click To Delete Playlist");
		btnDeleteList3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID3.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
			}
		});
		btnDeleteList3.setEnabled(false);
		btnDeleteList3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList3.setBounds(385, 315, 100, 25);
		contentPane.add(btnDeleteList3);
		
		btnDeleteList4 = new JButton("Delete List");
		btnDeleteList4.setToolTipText("Click To Delete Playlist");
		btnDeleteList4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID4.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
	
			}
		});
		btnDeleteList4.setEnabled(false);
		btnDeleteList4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList4.setBounds(555, 315, 100, 25);
		contentPane.add(btnDeleteList4);
		
		btnDeleteList5 = new JButton("Delete List");
		btnDeleteList5.setToolTipText("Click To Delete Playlist");
		btnDeleteList5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID5.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
			}
		});
		btnDeleteList5.setEnabled(false);
		btnDeleteList5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList5.setBounds(725, 315, 100, 25);
		contentPane.add(btnDeleteList5);
		
		btnDeleteList6 = new JButton("Delete List");
		btnDeleteList6.setToolTipText("Click To Delete Playlist");
		btnDeleteList6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID6.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
			}
		});
		btnDeleteList6.setEnabled(false);
		btnDeleteList6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList6.setBounds(50, 515, 100, 25);
		contentPane.add(btnDeleteList6);
		
		btnDeleteList7 = new JButton("Delete List");
		btnDeleteList7.setToolTipText("Click To Delete Playlist");
		btnDeleteList7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID7.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
			}
		});
		btnDeleteList7.setEnabled(false);
		btnDeleteList7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList7.setBounds(215, 515, 100, 25);
		contentPane.add(btnDeleteList7);
		
		btnDeleteList8 = new JButton("Delete List");
		btnDeleteList8.setToolTipText("Click To Delete Playlist");
		btnDeleteList8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID8.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
				
			}
		});
		btnDeleteList8.setEnabled(false);
		btnDeleteList8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList8.setBounds(385, 515, 100, 25);
		contentPane.add(btnDeleteList8);
		
		btnDeleteList9 = new JButton("Delete List");
		btnDeleteList9.setToolTipText("Click To Delete Playlist");
		btnDeleteList9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID9.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
			}
		});
		btnDeleteList9.setEnabled(false);
		btnDeleteList9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList9.setBounds(555, 515, 100, 25);
		contentPane.add(btnDeleteList9);
		
		btnDeleteList10 = new JButton("Delete List");
		btnDeleteList10.setToolTipText("Click To Delete Playlist");
		btnDeleteList10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Playlist?", "Elenco - Delete Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION)
				{		
					deleteProcess(currentLoggedIn , txtPlaylistID10.getText() );
					JOptionPane.showMessageDialog(null, "Playlist Has Been Deleted", "Elenco - Successful Removed Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					clearScreen() ;
					loadContent(currentLoggedIn);
				}
				
			}
		});
		btnDeleteList10.setEnabled(false);
		btnDeleteList10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDeleteList10.setBounds(725, 515, 100, 25);
		contentPane.add(btnDeleteList10);

	}

	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives parameter from <code>MyPlaylistsScreen</code> and uses it to search the database to find all playlists for the matching userID and populates the screen with the appropriate content.
	 * </p>
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 *
	 * @see MyPlaylistsScreenScreen
	 * @see String
	 * @see int
	 * @see ResultSet
	 */
	
	public void loadContent(LoggedIn currentLoggedIn){
		
		ResultSet myLists = MySQLQueries.loadPlaylists(currentLoggedIn.getCurrentUserID());				// Search database for all playlists by current user
		
		String playlistTitle = null;
		String playListID = null;

		int row = 1;
		
		try {

			while (myLists.next())																		// while a search result is found, set following variables to data in stated 'column' names of the database 												
			{
				playlistTitle = myLists.getString("PlaylistTitle");
				playListID = myLists.getString("PlaylistID");
				System.out.println(playlistTitle);

				switch (row) {																			// Switch to fill the appropriate section of the GUI i.e populate each section for ever iteration of while loop. Only 10 results are on screen at a time 	
					case 1:
						txtPlaylistTitle1.setText(playlistTitle);
						btnPlaylist1.setText("View");
						txtPlaylistID1.setText(playListID);
						btnPlaylist2.setEnabled(true);
						btnDeleteList1.setEnabled(true);
						break;
					case 2:
						txtPlaylistTitle2.setText(playlistTitle);
						btnPlaylist2.setText("View");
						txtPlaylistID2.setText(playListID);
						btnPlaylist3.setEnabled(true);
						btnDeleteList2.setEnabled(true);
						break;
					case 3:
						txtPlaylistTitle3.setText(playlistTitle);
						btnPlaylist3.setText("View");
						txtPlaylistID3.setText(playListID);							
						btnPlaylist4.setEnabled(true);
						btnDeleteList3.setEnabled(true);
						break;
					case 4:
						txtPlaylistTitle4.setText(playlistTitle);
						btnPlaylist4.setText("View");
						txtPlaylistID4.setText(playListID);							
						btnPlaylist5.setEnabled(true);
						btnDeleteList4.setEnabled(true);
						break;
					case 5:
						txtPlaylistTitle5.setText(playlistTitle);				
						btnPlaylist5.setText("View");
						txtPlaylistID5.setText(playListID);							
						btnPlaylist6.setEnabled(true);
						btnDeleteList5.setEnabled(true);
						break;
					case 6:
						txtPlaylistTitle6.setText(playlistTitle);			
						btnPlaylist6.setText("View");
						txtPlaylistID6.setText(playListID);							
						btnPlaylist7.setEnabled(true);
						btnDeleteList6.setEnabled(true);
						break;
					case 7:
						txtPlaylistTitle7.setText(playlistTitle);					
						btnPlaylist7.setText("View");
						txtPlaylistID7.setText(playListID);							
						btnPlaylist8.setEnabled(true);
						btnDeleteList7.setEnabled(true);
						break;
					case 8:
						txtPlaylistTitle8.setText(playlistTitle);					
						btnPlaylist8.setText("View");
						txtPlaylistID8.setText(playListID);							
						btnPlaylist9.setEnabled(true);
						btnDeleteList8.setEnabled(true);
						break;
					case 9:
						txtPlaylistTitle9.setText(playlistTitle);			
						btnPlaylist9.setText("View");
						txtPlaylistID9.setText(playListID);
						btnPlaylist10.setEnabled(true);
						btnDeleteList9.setEnabled(true);
						break;
					case 10:
						txtPlaylistTitle10.setText(playlistTitle);	
						btnPlaylist10.setText("View");
						txtPlaylistID10.setText(playListID);
						btnDeleteList10.setEnabled(true);
						break;

					default:
						System.out.println("nothing matching search criteria\n");
				}
				row++;
			}

			
		}
		catch (SQLException sqe)
		{
			
		}
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Clears and resets all GUI elements to the desired state.
	 * </p>
	 * 
	 *
	 * @see MyPlaylistsScreen
	 */
	
	public void clearScreen() {
		
		txtPlaylistTitle1.setText("");
		btnPlaylist1.setText("Create List");
		btnPlaylist1.setEnabled(true);
		btnDeleteList1.setEnabled(false);
		
		txtPlaylistTitle2.setText("");
		btnPlaylist2.setText("Create List");
		btnPlaylist2.setEnabled(false);
		btnDeleteList2.setEnabled(false);
		
		txtPlaylistTitle3.setText("");
		btnPlaylist3.setText("Create List");
		btnPlaylist3.setEnabled(false);
		btnDeleteList3.setEnabled(false);
		
		txtPlaylistTitle4.setText("");
		btnPlaylist4.setText("Create List");
		btnPlaylist4.setEnabled(false);
		btnDeleteList4.setEnabled(false);
		
		txtPlaylistTitle5.setText("");
		btnPlaylist5.setText("Create List");
		btnPlaylist5.setEnabled(false);
		btnDeleteList5.setEnabled(false);
		
		txtPlaylistTitle6.setText("");
		btnPlaylist6.setText("Create List");
		btnPlaylist6.setEnabled(false);
		btnDeleteList6.setEnabled(false);
		
		txtPlaylistTitle7.setText("");
		btnPlaylist7.setText("Create List");
		btnPlaylist7.setEnabled(false);
		btnDeleteList7.setEnabled(false);
		
		txtPlaylistTitle8.setText("");
		btnPlaylist8.setText("Create List");
		btnPlaylist8.setEnabled(false);
		btnDeleteList8.setEnabled(false);
		
		txtPlaylistTitle9.setText("");
		btnPlaylist9.setText("Create List");
		btnPlaylist9.setEnabled(false);
		btnDeleteList9.setEnabled(false);
		
		txtPlaylistTitle10.setText("");
		btnPlaylist10.setText("Create List");
		btnPlaylist10.setEnabled(false);
		btnDeleteList10.setEnabled(false);
		
		
		
	}
	
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives parameter from <code>MyPlaylistsScreen</code> and uses it to delete database entries matching the mySQL search.
	 * <br> Deletes a row from Playlist table that has same playlistID as provided.
	 * <br> Then reloads the <code>MyPlaylistsScreen</code> ,so the changes to the database can be taken into consideration and only populate the GUI with playlists that exist for the current user.
	 * </p>
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 * @param deletePlaylistID		<code>String</code> object to store current user information.
	 *
	 * @see MyPlaylistsScreenScreen
	 * @see String
	 * @see ResultSet
	 */
	
	public void deleteProcess(LoggedIn currentLoggedIn, String deletePlaylistID) {
		
		ResultSet getCurrentPlaylistTitle = MySQLQueries.getCurrentPlaylistTitle(deletePlaylistID);				// Search for the name of playlist using playlistID parameter - this is because every song entry in a playlist has a unique playlistID,
																												// once the playlist name is established all database entries with a userID and playlistTitle can be removed
		String currentPlaylistTitle = null;
		
		
		try 
		{
			if(getCurrentPlaylistTitle.next()) 																	// If the ResultSet has rows remaining - i.e we want to delete all rows found
			{
				currentPlaylistTitle = getCurrentPlaylistTitle.getString("PlaylistTitle");						// Set variable to data in row of ResultSet under specified column name			

				MySQLQueries.DeletePlaylist(currentLoggedIn.getCurrentUserID(),currentPlaylistTitle );			// Delete from the database entries that have userID and playlistTitle we desire 
				
				clearScreen() ;
				loadContent(currentLoggedIn);																	// Refresh, reset and reload GUI
			}
		} 
		catch (SQLException errror) 
		{
	
		}
		
		
	}
	
	
	
}
