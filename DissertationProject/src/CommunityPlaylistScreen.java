import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * User layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * CommunityPlaylistScreen
 * </p>
 * 
 * <p>
 * Allows user to view their Account details and update/change some of their details that maybe wrong/out of date  
 * <br>Has a direct link with <code>CommunityPlaylistApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see CommunityPlaylistApplication
 */
public class CommunityPlaylistScreen extends JFrame {

	// Variables
	
	private JPanel contentPane;
	private JTextField txtTitle1;
	private JTextField txtTitle2;
	private JTextField txtUsername1;
	private JTextField txtUsername2;
	private JTextField txtUserID1;
	private JTextField txtUserID2;
	private JButton btnMainmenu;
	private JLabel lblPlaylistTitle;
	private JLabel lblUsername;
	private JLabel lblSearchFor;
	private JLabel lblSearchBy;
	private JTextField txtUsername3;
	private JTextField txtUsername4;
	private JTextField txtUsername5;
	private JTextField txtUsername6;
	private JTextField txtUsername7;
	private JTextField txtUsername8;
	private JTextField txtUsername9;
	private JTextField txtUsername10;
	private JTextField txtTitle3;
	private JTextField txtTitle4;
	private JTextField txtTitle5;
	private JTextField txtTitle6;
	private JTextField txtTitle7;
	private JTextField txtTitle8;
	private JTextField txtTitle9;
	private JTextField txtTitle10;
	private JTextField txtUserID3;
	private JTextField txtUserID4;
	private JTextField txtUserID5;
	private JTextField txtUserID6;
	private JTextField txtUserID7;
	private JTextField txtUserID8;
	private JTextField txtUserID9;
	private JTextField txtUserID10;
	private JTextField txtPage;
	private JButton btnView1;
	private JButton btnView2;
	private JButton btnView3;
	private JButton btnView4;
	private JButton btnView5;
	private JButton btnView6;
	private JButton btnView7;
	private JButton btnView8;
	private JButton btnView9;
	private JButton btnView10;
	private JButton btnPrevious;
	private JButton btnNext;
	
	private JComboBox comboBoxSearch;
	private JComboBox comboBoxCriteria;
	private JButton btnSearch;
	
	private int pageCount = 1;
	private int sqlOffset = 0;  		// variable for offset during mysql LIMIT queries
	private int sqlRowCount = 10;		// variable for count during mysql LIMIT queries

	
	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>CommunityPlaylistScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * <br>Makes use of <code>CustomException</code> to relay feedback to user.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 * 
	 * @see CommunityPlaylistScreen
	 * @see LoggedIN
	 * @see CustomException
	 */
	public CommunityPlaylistScreen(LoggedIn currentLoggedIn) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				pageCount = 1;
				clearScreen();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Find Playlist");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 690);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle1.setBounds(240, 220, 200, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle2.setBounds(240, 250, 200, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		txtUsername1 = new JTextField();
		txtUsername1.setToolTipText("Username Of Search Result");
		txtUsername1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername1.setBounds(25, 220, 200, 20);
		contentPane.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		txtUsername2 = new JTextField();
		txtUsername2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername2.setBounds(25, 250, 200, 20);
		contentPane.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		btnView1 = new JButton("View");
		btnView1.setToolTipText("Click To View Search Result");
		btnView1.setEnabled(false);
		btnView1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle1.getText(), txtUserID1.getText(), currentLoggedIn);			// View playlist by passing parameters to next GUI so screen content can be accurately loaded
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnView1.setBounds(455, 220, 100, 20);
		contentPane.add(btnView1);
		
		btnView2 = new JButton("View");
		btnView2.setToolTipText("Click To View Search Result");
		btnView2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle2.getText(), txtUserID2.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView2.setEnabled(false);
		btnView2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView2.setBounds(455, 250, 100, 20);
		contentPane.add(btnView2);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setToolTipText("Select Criteria To Customise Your Search");
		comboBoxCriteria.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"UserName", "PlaylistTitle"}));
		comboBoxCriteria.setBounds(340, 140, 100, 25);
		contentPane.add(comboBoxCriteria);
		
		txtUserID1 = new JTextField();
		txtUserID1.setVisible(false);
		txtUserID1.setBounds(563, 220, 20, 20);
		contentPane.add(txtUserID1);
		txtUserID1.setColumns(10);
		
		txtUserID2 = new JTextField();
		txtUserID2.setVisible(false);
		txtUserID2.setBounds(563, 250, 20, 20);
		contentPane.add(txtUserID2);
		txtUserID2.setColumns(10);
		
		btnMainmenu = new JButton("Main Menu");
		btnMainmenu.setToolTipText("Return To Main Menu");
		btnMainmenu.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenuScreen gui = new MainMenuScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
			}
		});
		btnMainmenu.setBounds(250, 610, 100, 25);
		contentPane.add(btnMainmenu);
		
		comboBoxSearch = new JComboBox();
		comboBoxSearch.setToolTipText("This List Contains All The Current Material On Elenco Divided Into Caterogies By The 'Search By' Criteria Provided");
		
		// Populates the comboBox with elements from the database determined by user selected criteria
		comboBoxSearch.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				
				
				comboBoxSearch.removeAllItems();
				
				if(comboBoxCriteria.getSelectedItem().toString().equals("UserName"))
				{
			
					ResultSet results = MySQLQueries.popoulateWithUserName();											// Search database using username parameter - Query by username
					try
					{
						
						while (results.next())
						{
							comboBoxSearch.addItem(results.getString(comboBoxCriteria.getSelectedItem().toString()));	// while a search result is found add item to comboBox
						}
						
					} 
					catch (SQLException error) 
					{
			
					}
					
				}
				else
				{
					
					ResultSet results = MySQLQueries.popoulateWithPlaylistTitle();										// Search database using plyylistTitle parameter - Query by playlistTitle
					try
					{
						
						while (results.next())
						{
							comboBoxSearch.addItem(results.getString(comboBoxCriteria.getSelectedItem().toString()));	// while a search result is found add item to comboBox
						}
						
					} 
					catch (SQLException error)
					{
			
					}
			
		
				}
				
			}
		});
		comboBoxSearch.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxSearch.setBounds(100, 140, 150, 25);
		contentPane.add(comboBoxSearch);
		AutoCompleteDecorator.decorate(comboBoxSearch);
		
		JLabel lblHeader = new JLabel("Elenco - Community Playlists");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(new Color(90, 192, 217));
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setBounds(170, 43, 370, 25);
		contentPane.add(lblHeader);
		
		ImageIcon appIcon =  new ImageIcon(ElencoStartup.class.getResource("/BlueIcon-Circle.PNG"));					
		Image appImage = appIcon.getImage();															
		Image appImageResize = appImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		
		appIcon = new ImageIcon(appImageResize);													
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(75, 11, 100, 100);
		contentPane.add(lblLogo);
		
		lblPlaylistTitle = new JLabel("Playlist Title");
		lblPlaylistTitle.setForeground(new Color(90, 192, 217));
		lblPlaylistTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPlaylistTitle.setBounds(240, 200, 100, 20);
		contentPane.add(lblPlaylistTitle);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(90, 192, 217));
		lblUsername.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUsername.setBounds(25, 200, 100, 20);
		contentPane.add(lblUsername);
		
		lblSearchFor = new JLabel("Search For");
		lblSearchFor.setForeground(new Color(90, 192, 217));
		lblSearchFor.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSearchFor.setBounds(25, 140, 75, 25);
		contentPane.add(lblSearchFor);
		
		lblSearchBy = new JLabel("Search By");
		lblSearchBy.setForeground(new Color(90, 192, 217));
		lblSearchBy.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSearchBy.setBounds(270, 140, 75, 25);
		contentPane.add(lblSearchBy);
		
		txtUsername3 = new JTextField();
		txtUsername3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername3.setColumns(10);
		txtUsername3.setBounds(25, 280, 200, 20);
		contentPane.add(txtUsername3);
		
		txtUsername4 = new JTextField();
		txtUsername4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername4.setColumns(10);
		txtUsername4.setBounds(25, 310, 200, 20);
		contentPane.add(txtUsername4);
		
		txtUsername5 = new JTextField();
		txtUsername5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername5.setColumns(10);
		txtUsername5.setBounds(25, 340, 200, 20);
		contentPane.add(txtUsername5);
		
		txtUsername6 = new JTextField();
		txtUsername6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername6.setColumns(10);
		txtUsername6.setBounds(25, 370, 200, 20);
		contentPane.add(txtUsername6);
		
		txtUsername7 = new JTextField();
		txtUsername7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername7.setColumns(10);
		txtUsername7.setBounds(25, 400, 200, 20);
		contentPane.add(txtUsername7);
		
		txtUsername8 = new JTextField();
		txtUsername8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername8.setColumns(10);
		txtUsername8.setBounds(25, 430, 200, 20);
		contentPane.add(txtUsername8);
		
		txtUsername9 = new JTextField();
		txtUsername9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername9.setColumns(10);
		txtUsername9.setBounds(25, 460, 200, 20);
		contentPane.add(txtUsername9);
		
		txtUsername10 = new JTextField();
		txtUsername10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername10.setColumns(10);
		txtUsername10.setBounds(25, 490, 200, 20);
		contentPane.add(txtUsername10);
		
		txtTitle3 = new JTextField();
		txtTitle3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle3.setColumns(10);
		txtTitle3.setBounds(240, 280, 200, 20);
		contentPane.add(txtTitle3);
		
		txtTitle4 = new JTextField();
		txtTitle4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle4.setColumns(10);
		txtTitle4.setBounds(240, 310, 200, 20);
		contentPane.add(txtTitle4);
		
		txtTitle5 = new JTextField();
		txtTitle5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle5.setColumns(10);
		txtTitle5.setBounds(240, 340, 200, 20);
		contentPane.add(txtTitle5);
		
		txtTitle6 = new JTextField();
		txtTitle6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle6.setColumns(10);
		txtTitle6.setBounds(240, 370, 200, 20);
		contentPane.add(txtTitle6);
		
		txtTitle7 = new JTextField();
		txtTitle7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle7.setColumns(10);
		txtTitle7.setBounds(240, 400, 200, 20);
		contentPane.add(txtTitle7);
		
		txtTitle8 = new JTextField();
		txtTitle8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle8.setColumns(10);
		txtTitle8.setBounds(240, 430, 200, 20);
		contentPane.add(txtTitle8);
		
		txtTitle9 = new JTextField();
		txtTitle9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle9.setColumns(10);
		txtTitle9.setBounds(240, 460, 200, 20);
		contentPane.add(txtTitle9);
		
		txtTitle10 = new JTextField();
		txtTitle10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle10.setColumns(10);
		txtTitle10.setBounds(240, 490, 200, 20);
		contentPane.add(txtTitle10);
		
		btnView3 = new JButton("View");
		btnView3.setToolTipText("Click To View Search Result");
		btnView3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle3.getText(), txtUserID3.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView3.setEnabled(false);
		btnView3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView3.setBounds(455, 280, 100, 20);
		contentPane.add(btnView3);
		
		btnView4 = new JButton("View");
		btnView4.setToolTipText("Click To View Search Result");
		btnView4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle4.getText(), txtUserID4.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView4.setEnabled(false);
		btnView4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView4.setBounds(455, 310, 100, 20);
		contentPane.add(btnView4);
		
		btnView5 = new JButton("View");
		btnView5.setToolTipText("Click To View Search Result");
		btnView5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle5.getText(), txtUserID5.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnView5.setEnabled(false);
		btnView5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView5.setBounds(455, 340, 100, 20);
		contentPane.add(btnView5);
		
		btnView6 = new JButton("View");
		btnView6.setToolTipText("Click To View Search Result");
		btnView6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle6.getText(), txtUserID6.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView6.setEnabled(false);
		btnView6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView6.setBounds(455, 370, 100, 20);
		contentPane.add(btnView6);
		
		btnView7 = new JButton("View");
		btnView7.setToolTipText("Click To View Search Result");
		btnView7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle7.getText(), txtUserID7.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView7.setEnabled(false);
		btnView7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView7.setBounds(455, 400, 100, 20);
		contentPane.add(btnView7);
		
		btnView8 = new JButton("View");
		btnView8.setToolTipText("Click To View Search Result");
		btnView8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle8.getText(), txtUserID8.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView8.setEnabled(false);
		btnView8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView8.setBounds(455, 430, 100, 20);
		contentPane.add(btnView8);
		
		btnView9 = new JButton("View");
		btnView9.setToolTipText("Click To View Search Result");
		btnView9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle9.getText(), txtUserID9.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView9.setEnabled(false);
		btnView9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView9.setBounds(455, 460, 100, 20);
		contentPane.add(btnView9);
		
		btnView10 = new JButton("View");
		btnView10.setToolTipText("Click To View Search Result");
		btnView10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle10.getText(), txtUserID10.getText(), currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnView10.setEnabled(false);
		btnView10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView10.setBounds(455, 490, 100, 20);
		contentPane.add(btnView10);
		
		txtUserID3 = new JTextField();
		txtUserID3.setVisible(false);
		txtUserID3.setColumns(10);
		txtUserID3.setBounds(563, 281, 20, 20);
		contentPane.add(txtUserID3);
		
		txtUserID4 = new JTextField();
		txtUserID4.setVisible(false);
		txtUserID4.setColumns(10);
		txtUserID4.setBounds(563, 312, 20, 20);
		contentPane.add(txtUserID4);
		
		txtUserID5 = new JTextField();
		txtUserID5.setVisible(false);
		txtUserID5.setColumns(10);
		txtUserID5.setBounds(563, 343, 20, 20);
		contentPane.add(txtUserID5);
		
		txtUserID6 = new JTextField();
		txtUserID6.setVisible(false);
		txtUserID6.setColumns(10);
		txtUserID6.setBounds(563, 374, 20, 20);
		contentPane.add(txtUserID6);
		
		txtUserID7 = new JTextField();
		txtUserID7.setVisible(false);
		txtUserID7.setColumns(10);
		txtUserID7.setBounds(563, 405, 20, 20);
		contentPane.add(txtUserID7);
		
		txtUserID8 = new JTextField();
		txtUserID8.setVisible(false);
		txtUserID8.setColumns(10);
		txtUserID8.setBounds(563, 436, 20, 20);
		contentPane.add(txtUserID8);
		
		txtUserID9 = new JTextField();
		txtUserID9.setVisible(false);
		txtUserID9.setColumns(10);
		txtUserID9.setBounds(563, 467, 20, 20);
		contentPane.add(txtUserID9);
		
		txtUserID10 = new JTextField();
		txtUserID10.setVisible(false);
		txtUserID10.setColumns(10);
		txtUserID10.setBounds(563, 500, 20, 20);
		contentPane.add(txtUserID10);
		
		btnPrevious = new JButton("Previous Page");
		btnPrevious.setEnabled(false);
		btnPrevious.setToolTipText("Previous Page Of Search Results");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount - 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset - 10);
				
				clearScreen();
				loadContent();
			}
		});
		btnPrevious.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPrevious.setBounds(130, 530, 125, 25);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next Page");
		btnNext.setEnabled(false);
		btnNext.setToolTipText("Next Page Of Search Results");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount + 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset + 10);
				
				clearScreen();
				loadContent();
			}
		});
		btnNext.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNext.setBounds(345, 530, 125, 25);
		contentPane.add(btnNext);
		
		txtPage = new JTextField();
		txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBounds(275, 530, 50, 25);
		contentPane.add(txtPage);
		
		JLabel lblPage = new JLabel("Page");
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage.setForeground(new Color(90, 192, 217));
		lblPage.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPage.setBounds(275, 560, 50, 14);
		contentPane.add(lblPage);
		
		btnSearch = new JButton("Search");
		btnSearch.setToolTipText("Click To Search Elenco For Playlists Based On Your Custom Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(comboBoxSearch.getSelectedItem());
				System.out.println(comboBoxCriteria.getSelectedItem());
				
				clearScreen();
				loadContent();
			}
		});
		btnSearch.setBounds(451, 141, 89, 23);
		contentPane.add(btnSearch);
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>CommunityPlaylistScreen</code> and uses them to search the database to find entries matching the search criteria and populates the screen with the appropriate content.
	 * </p>
	 * 
	 *
	 * @see DiscoverSongScreen
	 * @see String
	 * @see Integer
	 * @see ResultSet
	 */
	
	public void loadContent() {
		
		String userID = null;
		String title = null;
		String username = null;
		int row = 1;
		
		txtPage.setText(String.valueOf(pageCount));
		
		if (sqlOffset > 9) {									// Makes the 'Previous' button only selectable when viable	 																								
			
			btnPrevious.setEnabled(true);
			
		}
		else 
		{																								
			
			btnPrevious.setEnabled(false);
		}
	
		ResultSet searchAttempt = MySQLQueries.searchForPlaylists(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem().toString(), sqlOffset , sqlRowCount);		// Search database for custom search criteria Limited to 10 results	

		try 
		{
			
			while (searchAttempt.next())								// while a search result is found, set following variables to data in stated 'column' names of the database 														
			{

				userID = searchAttempt.getString("UserID");
				title = searchAttempt.getString("PlaylistTitle");
				username = searchAttempt.getString("UserName");
				
				switch (row) {											// Switch to fill the appropriate line of the search result section of the GUI i.e populate each row inturn for ever iteration of while loop. Only 10 results are on screen at a time 
					case 1:
						txtUserID1.setText(userID);
						txtTitle1.setText(title);
						txtUsername1.setText(username);
						btnView1.setEnabled(true);
						break;
					case 2:
						txtUserID2.setText(userID);
						txtTitle2.setText(title);
						txtUsername2.setText(username);
						btnView2.setEnabled(true);
						break;
					case 3:
						txtUserID3.setText(userID);
						txtTitle3.setText(title);
						txtUsername3.setText(username);
						btnView3.setEnabled(true);
						break;
					case 4:
						txtUserID4.setText(userID);
						txtTitle4.setText(title);
						txtUsername4.setText(username);
						btnView4.setEnabled(true);
						break;
					case 5:
						txtUserID5.setText(userID);
						txtTitle5.setText(title);
						txtUsername5.setText(username);
						btnView5.setEnabled(true);
						break;
					case 6:
						txtUserID6.setText(userID);
						txtTitle6.setText(title);
						txtUsername6.setText(username);
						btnView6.setEnabled(true);
						break;
					case 7:
						txtUserID7.setText(userID);
						txtTitle7.setText(title);
						txtUsername7.setText(username);
						btnView7.setEnabled(true);
						break;
					case 8:
						txtUserID8.setText(userID);
						txtTitle8.setText(title);
						txtUsername8.setText(username);
						btnView8.setEnabled(true);
						break;
					case 9:
						txtUserID9.setText(userID);
						txtTitle9.setText(title);
						txtUsername9.setText(username);
						btnView9.setEnabled(true);
						break;
					case 10:
						txtUserID10.setText(userID);
						txtTitle10.setText(title);
						txtUsername10.setText(username);
						btnView10.setEnabled(true);
						btnNext.setEnabled(true);
						break;
					default:
					
						System.out.println("default of switch");
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
	 * @see CommunityPlaylistScreen
	 */
	
	public void clearScreen() {
		

		btnNext.setEnabled(false);
		btnPrevious.setEnabled(false);

		txtTitle1.setText("");
		txtUsername1.setText("");
		btnView1.setEnabled(false);
		
		txtTitle2.setText("");
		txtUsername2.setText("");
		btnView2.setEnabled(false);
		
		txtTitle3.setText("");
		txtUsername3.setText("");
		btnView3.setEnabled(false);
		
		txtTitle4.setText("");
		txtUsername4.setText("");
		btnView4.setEnabled(false);
		
		txtTitle5.setText("");
		txtUsername5.setText("");
		btnView5.setEnabled(false);
		
		txtTitle6.setText("");
		txtUsername6.setText("");
		btnView6.setEnabled(false);
		
		txtTitle7.setText("");
		txtUsername7.setText("");
		btnView7.setEnabled(false);
		
		txtTitle8.setText("");
		txtUsername8.setText("");
		btnView8.setEnabled(false);
		
		txtTitle9.setText("");
		txtUsername9.setText("");
		btnView9.setEnabled(false);
		
		txtTitle10.setText("");
		txtUsername10.setText("");
		btnView10.setEnabled(false);

	}
	
	
}
