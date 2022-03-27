import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.PopupMenuListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.event.PopupMenuEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * DiscoverSongScreen
 * </p>
 * 
 * <p>
 * Allows users to custom search, view and interact with all the songs on Elenco database part of the program. 
 * <br>Viewing has greater detail than the normal search result contains.
 * <br>Also is the area to allow user commenting and rating of the selected song.
 * <br>Has a direct link with <code>DiscoverSongApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see DiscoverSongApplication
 */

public class DiscoverSongScreen extends JFrame {

	// Variables
	
	private JPanel contentPane;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtRating1;
	private JTextField txtReviews1;
	private JTextField txtUploaded1;

	private JTextField txtTitle2;
	private JTextField txtArtist2;
	private JTextField txtGenre2;
	private JTextField txtRating2;
	private JTextField txtReviews2;
	private JTextField txtUploaded2;
	private JTextField txtSongID1;
	private JTextField txtTitle3;
	private JTextField txtTitle4;
	private JTextField txtTitle5;
	private JTextField txtTitle6;
	private JTextField txtTitle7;
	private JTextField txtTitle8;
	private JTextField txtTitle9;
	private JTextField txtTitle10;
	private JTextField txtArtist3;
	private JTextField txtArtist4;
	private JTextField txtArtist5;
	private JTextField txtArtist6;
	private JTextField txtArtist7;
	private JTextField txtArtist8;
	private JTextField txtArtist9;
	private JTextField txtArtist10;
	private JTextField txtGenre3;
	private JTextField txtGenre4;
	private JTextField txtGenre5;
	private JTextField txtGenre6;
	private JTextField txtGenre7;
	private JTextField txtGenre8;
	private JTextField txtGenre9;
	private JTextField txtGenre10;
	private JTextField txtRating4;
	private JTextField txtRating5;
	private JTextField txtRating6;
	private JTextField txtRating7;
	private JTextField txtRating8;
	private JTextField txtRating9;
	private JTextField txtRating10;
	private JTextField txtReviews4;
	private JTextField txtReviews5;
	private JTextField txtReviews6;
	private JTextField txtReviews7;
	private JTextField txtReviews8;
	private JTextField txtReviews9;
	private JTextField txtReviews10;
	private JTextField txtUploaded4;
	private JTextField txtUploaded5;
	private JTextField txtUploaded6;
	private JTextField txtUploaded7;
	private JTextField txtUploaded8;
	private JTextField txtUploaded9;
	private JTextField txtUploaded10;
	private JTextField txtSongID4;
	private JTextField txtSongID5;
	private JTextField txtSongID6;
	private JTextField txtSongID7;
	private JTextField txtSongID8;
	private JTextField txtSongID9;
	private JTextField txtSongID10;
	private JTextField txtRating3;
	private JTextField txtReviews3;
	private JTextField txtUploaded3;
	private JTextField txtSongID2;
	private JTextField txtSongID3;
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
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnMainMenu;
	private JComboBox comboBoxCriteria;
	private JComboBox comboBoxSort;
	private JComboBox comboBoxSearch;
	private JRadioButton rdbtnAscending;
	private JRadioButton rdbtnDescending ;
	private JLabel lblPage;
	private JTextField txtPage;
	
	
	private int pageCount = 1;
	private int sqlOffset = 0;			// variable for offset during mysql LIMIT queries
	private int sqlRowCount = 10;		// variable for count during mysql LIMIT queries

	// Constructors
	
	// Overloaded
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>DiscoverSongScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * <br>Makes use of CustomException to rely feedback to user.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 * 
	 * @see DiscoverSongScreen
	 * @see LoggedIN
	 * @see CustomException
	 */
	
	public DiscoverSongScreen(LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Discover Songs");
		setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				clearScreen();
				txtPage.setText(String.valueOf(pageCount));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 690);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup radioButtons = new ButtonGroup();
		
		rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setToolTipText("Select An Ascending Order Of 'Sort By' Criteria");
		rdbtnAscending.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnAscending.setBackground(Color.WHITE);
		rdbtnAscending.setBounds(725, 125, 109, 25);
		rdbtnAscending.setForeground(new Color(90, 192, 217));
		contentPane.add(rdbtnAscending);
		
		rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setToolTipText("Select A Descending Order Of 'Sort By' Criteria");
		rdbtnDescending.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnDescending.setBackground(Color.WHITE);
		rdbtnDescending.setSelected(true);
		rdbtnDescending.setBounds(725, 155, 109, 25);
		rdbtnDescending.setForeground(new Color(90, 192, 217));
		contentPane.add(rdbtnDescending);
		
		radioButtons.add(rdbtnAscending);																							
		radioButtons.add(rdbtnDescending);
		
		JLabel lblHeader = new JLabel("Elenco - Discover Songs");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(400, 40, 300, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					
		Image appImage = appIcon.getImage();															
		Image appImageResize = appImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		
		appIcon = new ImageIcon(appImageResize);														
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(304, 2, 100, 100);
		contentPane.add(lblLogo);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle1.setBounds(40, 220, 180, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist1.setBounds(250, 220, 150, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre1.setBounds(430, 220, 100, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating1.setBounds(565, 220, 50, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtReviews1 = new JTextField();
		txtReviews1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews1.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews1.setBounds(645, 220, 75, 20);
		contentPane.add(txtReviews1);
		txtReviews1.setColumns(10);
		
		txtUploaded1 = new JTextField();
		txtUploaded1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded1.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded1.setBounds(750, 220, 100, 20);
		contentPane.add(txtUploaded1);
		txtUploaded1.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setToolTipText("Title Of Song");
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblTitle.setBounds(40, 200, 50, 20);
		lblTitle.setForeground(new Color(90, 192, 217));
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setToolTipText("Artist Of Song");
		lblArtist.setFont(new Font("Georgia", Font.BOLD, 12));
		lblArtist.setBounds(250, 200, 50, 20);
		lblArtist.setForeground(new Color(90, 192, 217));
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setToolTipText("Genre Of Song");
		lblGenre.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGenre.setBounds(430, 200, 50, 20);
		lblGenre.setForeground(new Color(90, 192, 217));
		contentPane.add(lblGenre);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setToolTipText("Rating Of Song");
		lblRating.setFont(new Font("Georgia", Font.BOLD, 12));
		lblRating.setBounds(565, 200, 50, 20);
		lblRating.setForeground(new Color(90, 192, 217));
		contentPane.add(lblRating);
		
		JLabel lblViews = new JLabel("Reviews");
		lblViews.setToolTipText("Reviews For Song");
		lblViews.setFont(new Font("Georgia", Font.BOLD, 12));
		lblViews.setBounds(645, 200, 100, 20);
		lblViews.setForeground(new Color(90, 192, 217));
		contentPane.add(lblViews);
		
		JLabel lblUploaded = new JLabel("Uploaded");
		lblUploaded.setToolTipText("Upload Date Of Song");
		lblUploaded.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUploaded.setBounds(750, 200, 100, 20);
		lblUploaded.setForeground(new Color(90, 192, 217));
		contentPane.add(lblUploaded);
		
		btnView1 = new JButton("View");
		btnView1.setToolTipText("View Song For Given Return Result");
		btnView1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID1.getText());
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnView1.setBounds(880, 220, 100, 20);
		contentPane.add(btnView1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setToolTipText("Click To Search Elenco For Songs Based On Your Custom Search");
		btnSearch.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(comboBoxSearch.getSelectedItem());
				System.out.println(comboBoxCriteria.getSelectedItem());
				pageCount = 1;
				sqlOffset = 0;
				clearScreen() ;
				loadContent();

			}
		});
		btnSearch.setBounds(880, 140, 100, 25);
		contentPane.add(btnSearch);
		
		JLabel lblSearchFor = new JLabel("Search For");
		lblSearchFor.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSearchFor.setBounds(30, 140, 75, 25);
		lblSearchFor.setForeground(new Color(90, 192, 217));
		contentPane.add(lblSearchFor);
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSearchBy.setBounds(310, 140, 75, 25);
		lblSearchBy.setForeground(new Color(90, 192, 217));
		contentPane.add(lblSearchBy);
		
		JLabel lblSortBy = new JLabel("Sort By");
		lblSortBy.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSortBy.setBounds(520, 140, 48, 25);
		lblSortBy.setForeground(new Color(90, 192, 217));
		contentPane.add(lblSortBy);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setToolTipText("Select Criteria To Customise Your Search");
		comboBoxCriteria.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"Title", "Artist", "Genre"}));
		comboBoxCriteria.setBounds(385, 140, 110, 25);
		contentPane.add(comboBoxCriteria);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.setToolTipText("Select Criteria To Customise Your Search");
		comboBoxSort.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"OverallRating", "TotalReviews", "Uploaded"}));
		comboBoxSort.setBounds(580, 140, 110, 25);
		contentPane.add(comboBoxSort);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle2.setColumns(10);
		txtTitle2.setBounds(40, 250, 180, 20);
		contentPane.add(txtTitle2);
		
		txtArtist2 = new JTextField();
		txtArtist2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist2.setColumns(10);
		txtArtist2.setBounds(250, 250, 150, 20);
		contentPane.add(txtArtist2);
		
		txtGenre2 = new JTextField();
		txtGenre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre2.setColumns(10);
		txtGenre2.setBounds(430, 250, 100, 20);
		contentPane.add(txtGenre2);
		
		txtRating2 = new JTextField();
		txtRating2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating2.setColumns(10);
		txtRating2.setBounds(565, 250, 50, 20);
		contentPane.add(txtRating2);
		
		txtReviews2 = new JTextField();
		txtReviews2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews2.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews2.setColumns(10);
		txtReviews2.setBounds(645, 250, 75, 20);
		contentPane.add(txtReviews2);
		
		txtUploaded2 = new JTextField();
		txtUploaded2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded2.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded2.setColumns(10);
		txtUploaded2.setBounds(750, 250, 100, 20);
		contentPane.add(txtUploaded2);
		
		txtSongID1 = new JTextField();
		txtSongID1.setVisible(false);
		txtSongID1.setBounds(1000, 220, 20, 20);
		contentPane.add(txtSongID1);
		txtSongID1.setColumns(10);
		
		txtTitle3 = new JTextField();
		txtTitle3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle3.setBounds(40, 280, 180, 20);
		contentPane.add(txtTitle3);
		txtTitle3.setColumns(10);
		
		txtTitle4 = new JTextField();
		txtTitle4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle4.setBounds(40, 310, 180, 20);
		contentPane.add(txtTitle4);
		txtTitle4.setColumns(10);
		
		txtTitle5 = new JTextField();
		txtTitle5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle5.setBounds(40, 340, 180, 20);
		contentPane.add(txtTitle5);
		txtTitle5.setColumns(10);
		
		txtTitle6 = new JTextField();
		txtTitle6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle6.setBounds(40, 370, 180, 20);
		contentPane.add(txtTitle6);
		txtTitle6.setColumns(10);
		
		txtTitle7 = new JTextField();
		txtTitle7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle7.setBounds(40, 400, 180, 20);
		contentPane.add(txtTitle7);
		txtTitle7.setColumns(10);
		
		txtTitle8 = new JTextField();
		txtTitle8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle8.setBounds(40, 430, 180, 20);
		contentPane.add(txtTitle8);
		txtTitle8.setColumns(10);
		
		txtTitle9 = new JTextField();
		txtTitle9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle9.setBounds(40, 460, 180, 20);
		contentPane.add(txtTitle9);
		txtTitle9.setColumns(10);
		
		txtTitle10 = new JTextField();
		txtTitle10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle10.setBounds(40, 490, 180, 20);
		contentPane.add(txtTitle10);
		txtTitle10.setColumns(10);
		
		txtArtist3 = new JTextField();
		txtArtist3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist3.setBounds(250, 280, 150, 20);
		contentPane.add(txtArtist3);
		txtArtist3.setColumns(10);
		
		txtArtist4 = new JTextField();
		txtArtist4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist4.setBounds(250, 310, 150, 20);
		contentPane.add(txtArtist4);
		txtArtist4.setColumns(10);
		
		txtArtist5 = new JTextField();
		txtArtist5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist5.setBounds(250, 340, 150, 20);
		contentPane.add(txtArtist5);
		txtArtist5.setColumns(10);
		
		txtArtist6 = new JTextField();
		txtArtist6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist6.setBounds(250, 370, 150, 20);
		contentPane.add(txtArtist6);
		txtArtist6.setColumns(10);
		
		txtArtist7 = new JTextField();
		txtArtist7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist7.setBounds(250, 400, 150, 20);
		contentPane.add(txtArtist7);
		txtArtist7.setColumns(10);
		
		txtArtist8 = new JTextField();
		txtArtist8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist8.setBounds(250, 430, 150, 20);
		contentPane.add(txtArtist8);
		txtArtist8.setColumns(10);
		
		txtArtist9 = new JTextField();
		txtArtist9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist9.setBounds(250, 460, 150, 20);
		contentPane.add(txtArtist9);
		txtArtist9.setColumns(10);
		
		txtArtist10 = new JTextField();
		txtArtist10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist10.setBounds(250, 490, 150, 20);
		contentPane.add(txtArtist10);
		txtArtist10.setColumns(10);
		
		txtGenre3 = new JTextField();
		txtGenre3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre3.setBounds(430, 280, 100, 20);
		contentPane.add(txtGenre3);
		txtGenre3.setColumns(10);
		
		txtGenre4 = new JTextField();
		txtGenre4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre4.setColumns(10);
		txtGenre4.setBounds(430, 310, 100, 20);
		contentPane.add(txtGenre4);
		
		txtGenre5 = new JTextField();
		txtGenre5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre5.setColumns(10);
		txtGenre5.setBounds(430, 340, 100, 20);
		contentPane.add(txtGenre5);
		
		txtGenre6 = new JTextField();
		txtGenre6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre6.setColumns(10);
		txtGenre6.setBounds(430, 370, 100, 20);
		contentPane.add(txtGenre6);
		
		txtGenre7 = new JTextField();
		txtGenre7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre7.setColumns(10);
		txtGenre7.setBounds(430, 400, 100, 20);
		contentPane.add(txtGenre7);
		
		txtGenre8 = new JTextField();
		txtGenre8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre8.setColumns(10);
		txtGenre8.setBounds(430, 430, 100, 20);
		contentPane.add(txtGenre8);
		
		txtGenre9 = new JTextField();
		txtGenre9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre9.setColumns(10);
		txtGenre9.setBounds(430, 460, 100, 20);
		contentPane.add(txtGenre9);
		
		txtGenre10 = new JTextField();
		txtGenre10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre10.setColumns(10);
		txtGenre10.setBounds(430, 490, 100, 20);
		contentPane.add(txtGenre10);
		
		txtRating4 = new JTextField();
		txtRating4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating4.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating4.setColumns(10);
		txtRating4.setBounds(565, 310, 50, 20);
		contentPane.add(txtRating4);
		
		txtRating5 = new JTextField();
		txtRating5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating5.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating5.setColumns(10);
		txtRating5.setBounds(565, 340, 50, 20);
		contentPane.add(txtRating5);
		
		txtRating6 = new JTextField();
		txtRating6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating6.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating6.setColumns(10);
		txtRating6.setBounds(565, 370, 50, 20);
		contentPane.add(txtRating6);
		
		txtRating7 = new JTextField();
		txtRating7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating7.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating7.setColumns(10);
		txtRating7.setBounds(565, 400, 50, 20);
		contentPane.add(txtRating7);
		
		txtRating8 = new JTextField();
		txtRating8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating8.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating8.setColumns(10);
		txtRating8.setBounds(565, 430, 50, 20);
		contentPane.add(txtRating8);
		
		txtRating9 = new JTextField();
		txtRating9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating9.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating9.setColumns(10);
		txtRating9.setBounds(565, 460, 50, 20);
		contentPane.add(txtRating9);
		
		txtRating10 = new JTextField();
		txtRating10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating10.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating10.setColumns(10);
		txtRating10.setBounds(565, 490, 50, 20);
		contentPane.add(txtRating10);
		
		txtReviews4 = new JTextField();
		txtReviews4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews4.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews4.setColumns(10);
		txtReviews4.setBounds(645, 310, 75, 20);
		contentPane.add(txtReviews4);
		
		txtReviews5 = new JTextField();
		txtReviews5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews5.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews5.setColumns(10);
		txtReviews5.setBounds(645, 340, 75, 20);
		contentPane.add(txtReviews5);
		
		txtReviews6 = new JTextField();
		txtReviews6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews6.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews6.setColumns(10);
		txtReviews6.setBounds(645, 370, 75, 20);
		contentPane.add(txtReviews6);
		
		txtReviews7 = new JTextField();
		txtReviews7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews7.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews7.setColumns(10);
		txtReviews7.setBounds(645, 400, 75, 20);
		contentPane.add(txtReviews7);
		
		txtReviews8 = new JTextField();
		txtReviews8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews8.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews8.setColumns(10);
		txtReviews8.setBounds(645, 430, 75, 20);
		contentPane.add(txtReviews8);
		
		txtReviews9 = new JTextField();
		txtReviews9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews9.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews9.setColumns(10);
		txtReviews9.setBounds(645, 460, 75, 20);
		contentPane.add(txtReviews9);
		
		txtReviews10 = new JTextField();
		txtReviews10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews10.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews10.setColumns(10);
		txtReviews10.setBounds(645, 490, 75, 20);
		contentPane.add(txtReviews10);
		
		txtUploaded4 = new JTextField();
		txtUploaded4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded4.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded4.setColumns(10);
		txtUploaded4.setBounds(750, 310, 100, 20);
		contentPane.add(txtUploaded4);
		
		txtUploaded5 = new JTextField();
		txtUploaded5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded5.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded5.setColumns(10);
		txtUploaded5.setBounds(750, 340, 100, 20);
		contentPane.add(txtUploaded5);
		
		txtUploaded6 = new JTextField();
		txtUploaded6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded6.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded6.setColumns(10);
		txtUploaded6.setBounds(750, 370, 100, 20);
		contentPane.add(txtUploaded6);
		
		txtUploaded7 = new JTextField();
		txtUploaded7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded7.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded7.setColumns(10);
		txtUploaded7.setBounds(750, 400, 100, 20);
		contentPane.add(txtUploaded7);
		
		txtUploaded8 = new JTextField();
		txtUploaded8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded8.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded8.setColumns(10);
		txtUploaded8.setBounds(750, 430, 100, 20);
		contentPane.add(txtUploaded8);
		
		txtUploaded9 = new JTextField();
		txtUploaded9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded9.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded9.setColumns(10);
		txtUploaded9.setBounds(750, 460, 100, 20);
		contentPane.add(txtUploaded9);
		
		txtUploaded10 = new JTextField();
		txtUploaded10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded10.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded10.setColumns(10);
		txtUploaded10.setBounds(750, 490, 100, 20);
		contentPane.add(txtUploaded10);
		
		txtSongID4 = new JTextField();
		txtSongID4.setVisible(false);
		txtSongID4.setColumns(10);
		txtSongID4.setBounds(1000, 310, 20, 20);
		contentPane.add(txtSongID4);
		
		txtSongID5 = new JTextField();
		txtSongID5.setVisible(false);
		txtSongID5.setColumns(10);
		txtSongID5.setBounds(1000, 340, 20, 20);
		contentPane.add(txtSongID5);
		
		txtSongID6 = new JTextField();
		txtSongID6.setVisible(false);
		txtSongID6.setColumns(10);
		txtSongID6.setBounds(1000, 370, 20, 20);
		contentPane.add(txtSongID6);
		
		txtSongID7 = new JTextField();
		txtSongID7.setVisible(false);
		txtSongID7.setColumns(10);
		txtSongID7.setBounds(1000, 400, 20, 20);
		contentPane.add(txtSongID7);
		
		txtSongID8 = new JTextField();
		txtSongID8.setVisible(false);
		txtSongID8.setColumns(10);
		txtSongID8.setBounds(1000, 430, 20, 20);
		contentPane.add(txtSongID8);
		
		txtSongID9 = new JTextField();
		txtSongID9.setVisible(false);
		txtSongID9.setColumns(10);
		txtSongID9.setBounds(1000, 460, 20, 20);
		contentPane.add(txtSongID9);
		
		txtSongID10 = new JTextField();
		txtSongID10.setVisible(false);
		txtSongID10.setColumns(10);
		txtSongID10.setBounds(1000, 490, 20, 20);
		contentPane.add(txtSongID10);
		
		txtRating3 = new JTextField();
		txtRating3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating3.setBounds(565, 280, 50, 20);
		contentPane.add(txtRating3);
		txtRating3.setColumns(10);
		
		txtReviews3 = new JTextField();
		txtReviews3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews3.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews3.setBounds(645, 280, 75, 20);
		contentPane.add(txtReviews3);
		txtReviews3.setColumns(10);
		
		txtUploaded3 = new JTextField();
		txtUploaded3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded3.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded3.setBounds(750, 280, 100, 20);
		contentPane.add(txtUploaded3);
		txtUploaded3.setColumns(10);
		
		txtSongID2 = new JTextField();
		txtSongID2.setVisible(false);
		txtSongID2.setColumns(10);
		txtSongID2.setBounds(1000, 250, 20, 20);
		contentPane.add(txtSongID2);
		
		txtSongID3 = new JTextField();
		txtSongID3.setVisible(false);
		txtSongID3.setColumns(10);
		txtSongID3.setBounds(1000, 280, 20, 20);
		contentPane.add(txtSongID3);
		
		btnView2 = new JButton("View");
		btnView2.setToolTipText("View Song For Given Return Result");
		btnView2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID2.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView2.setBounds(880, 250, 100, 20);
		contentPane.add(btnView2);
		
		btnView3 = new JButton("View");
		btnView3.setToolTipText("View Song For Given Return Result");
		btnView3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID3.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView3.setBounds(880, 280, 100, 20);
		contentPane.add(btnView3);
		
		btnView4 = new JButton("View");
		btnView4.setToolTipText("View Song For Given Return Result");
		btnView4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn,txtSongID4.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView4.setBounds(880, 310, 100, 20);
		contentPane.add(btnView4);
		
		btnView5 = new JButton("View");
		btnView5.setToolTipText("View Song For Given Return Result");
		btnView5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID5.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView5.setBounds(880, 340, 100, 20);
		contentPane.add(btnView5);
		
		btnView6 = new JButton("View");
		btnView6.setToolTipText("View Song For Given Return Result");
		btnView6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID6.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView6.setBounds(880, 370, 100, 20);
		contentPane.add(btnView6);
		
		btnView7 = new JButton("View");
		btnView7.setToolTipText("View Song For Given Return Result");
		btnView7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID7.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView7.setBounds(880, 400, 100, 20);
		contentPane.add(btnView7);
		
		btnView8 = new JButton("View");
		btnView8.setToolTipText("View Song For Given Return Result");
		btnView8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID8.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView8.setBounds(880, 430, 100, 20);
		contentPane.add(btnView8);
		
		btnView9 = new JButton("View");
		btnView9.setToolTipText("View Song For Given Return Result");
		btnView9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID9.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView9.setBounds(880, 460, 100, 20);
		contentPane.add(btnView9);
		
		btnView10 = new JButton("View");
		btnView10.setToolTipText("View Song For Given Return Result");
		btnView10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnView10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentLoggedIn, txtSongID10.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView10.setBounds(880, 490, 100, 20);
		contentPane.add(btnView10);
		
		btnNext = new JButton("Next Page");
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
		btnNext.setBounds(550, 530, 125, 25);
		contentPane.add(btnNext);
		
		btnPrevious = new JButton("Previous Page");
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
		btnPrevious.setBounds(300, 530, 125, 25);
		contentPane.add(btnPrevious);
		
		comboBoxSearch = new JComboBox();
		comboBoxSearch.setToolTipText("This List Contains All The Current Material On Elenco Divided Into Caterogies By The 'Search By' Criteria Provided");
		comboBoxSearch.setFont(new Font("Georgia", Font.PLAIN, 11));
		AutoCompleteDecorator.decorate(comboBoxSearch);
	
		// Populates the comboBox with elements from the database determined by user selected criteria
		comboBoxSearch.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	
				comboBoxSearch.removeAllItems();
			
				ResultSet populateComboBox = MySQLQueries.populateComboBox(comboBoxCriteria.getSelectedItem(), comboBoxSort.getSelectedItem());		// Search database
				
					try {
						
						while (populateComboBox.next())																								// while a search result is found add item to comboBox
						{
							comboBoxSearch.addItem(populateComboBox.getString(comboBoxCriteria.getSelectedItem().toString()));
						}
					} catch (SQLException sql) {
				
					}
	
			}
		});
		comboBoxSearch.setBounds(110, 140, 180, 25);
		contentPane.add(comboBoxSearch);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setToolTipText("Return To Main Menu");
		btnMainMenu.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenuScreen gui = new MainMenuScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setBounds(440, 610, 100, 25);
		contentPane.add(btnMainMenu);
		
		lblPage = new JLabel("Page");
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPage.setBounds(460, 560, 50, 14);
		lblPage.setForeground(new Color(90, 192, 217));
		contentPane.add(lblPage);
		
		txtPage = new JTextField();
		txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setBounds(461, 530, 50, 25);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>DiscoverSongScreen</code> and uses them to search the database to find entries matching the search criteria and populates the screen with the appropriate content.
	 * </p>
	 * 
	 *
	 * @see DiscoverSongScreen
	 * @see String
	 * @see Integer
	 * @see ResultSet
	 */
	
	public void loadContent() {
		
		String songID = null;
		String title = null;
		String artist = null;
		String genre = null;
		String rating = null;
		String uploaded = null;
		String reviews = null;
		String sortType = null;
		
		txtPage.setText(String.valueOf(pageCount));
		
		int row = 1;
		
		if (rdbtnAscending.isSelected()) {								// Finds out which radio button is selected 																			
			
			sortType = "ASC";	
			System.out.println("Ascending\n");
			
		}else if (rdbtnDescending.isSelected()) {																								
			
			sortType = "DESC";	
			System.out.println("Descending\n");
		}
	
	
		if (sqlOffset > 9) {											// Makes the 'Previous' button only selectable when viable																									
		
			btnPrevious.setEnabled(true);
		
		}
		else 
		{																								
		
			btnPrevious.setEnabled(false);
		}
		
	
		ResultSet searchAttempt = MySQLQueries.search(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem(), comboBoxSort.getSelectedItem(), sortType, sqlOffset, sqlRowCount);		// Search database for custom search criteria Limited to 10 results
		
		
		try {		
			
		while (searchAttempt.next())																// while a search result is found, set following variables to data in stated 'column' names of the database 															
			{
	
			songID = searchAttempt.getString("SongID");
			title = searchAttempt.getString("Title");
			artist = searchAttempt.getString("Artist");
			genre = searchAttempt.getString("Genre");
			rating = searchAttempt.getString("OverallRating");
			reviews = searchAttempt.getString("TotalReviews");
			uploaded = searchAttempt.getString("uploaded");	
				
			switch (row) {																			// Switch to fill the appropriate line of the search result section of the GUI i.e populate each row inturn for ever iteration of while loop. Only 10 results are on screen at a time 
				case 1:
					txtSongID1.setText(songID);
					txtTitle1.setText(title);
					txtArtist1.setText(artist);
					txtGenre1.setText(genre);
					txtRating1.setText(rating);
					txtReviews1.setText(reviews);
					txtUploaded1.setText(uploaded);
					btnView1.setEnabled(true);
					break;
				case 2:
					txtSongID2.setText(songID);
					txtTitle2.setText(title);
					txtArtist2.setText(artist);
					txtGenre2.setText(genre);
					txtRating2.setText(rating);
					txtReviews2.setText(reviews);
					txtUploaded2.setText(uploaded);
					btnView2.setEnabled(true);
					break;
				case 3:
					txtSongID3.setText(songID);
					txtTitle3.setText(title);
					txtArtist3.setText(artist);
					txtGenre3.setText(genre);
					txtRating3.setText(rating);
					txtReviews3.setText(reviews);
					txtUploaded3.setText(uploaded);
					btnView3.setEnabled(true);
					break;
				case 4:
					txtSongID4.setText(songID);
					txtTitle4.setText(title);
					txtArtist4.setText(artist);
					txtGenre4.setText(genre);
					txtRating4.setText(rating);
					txtReviews4.setText(reviews);
					txtUploaded4.setText(uploaded);
					btnView4.setEnabled(true);
					break;
				case 5:
					txtSongID5.setText(songID);
					txtTitle5.setText(title);
					txtArtist5.setText(artist);
					txtGenre5.setText(genre);
					txtRating5.setText(rating);
					txtReviews5.setText(reviews);
					txtUploaded5.setText(uploaded);
					btnView5.setEnabled(true);
					break;
				case 6:
					txtSongID6.setText(songID);
					txtTitle6.setText(title);
					txtArtist6.setText(artist);
					txtGenre6.setText(genre);
					txtRating6.setText(rating);
					txtReviews6.setText(reviews);
					txtUploaded6.setText(uploaded);
					btnView6.setEnabled(true);
					break;
				case 7:
					txtSongID7.setText(songID);
					txtTitle7.setText(title);
					txtArtist7.setText(artist);
					txtGenre7.setText(genre);
					txtRating7.setText(rating);
					txtReviews7.setText(reviews);
					txtUploaded7.setText(uploaded);
					btnView7.setEnabled(true);
					break;
				case 8:
					txtSongID8.setText(songID);
					txtTitle8.setText(title);
					txtArtist8.setText(artist);
					txtGenre8.setText(genre);
					txtRating8.setText(rating);
					txtReviews8.setText(reviews);
					txtUploaded8.setText(uploaded);
					btnView8.setEnabled(true);
					break;
				case 9:
					txtSongID9.setText(songID);
					txtTitle9.setText(title);
					txtArtist9.setText(artist);
					txtGenre9.setText(genre);
					txtRating9.setText(rating);
					txtReviews9.setText(reviews);
					txtUploaded9.setText(uploaded);
					btnView9.setEnabled(true);
					break;
				case 10:
					txtSongID10.setText(songID);
					txtTitle10.setText(title);
					txtArtist10.setText(artist);
					txtGenre10.setText(genre);
					txtRating10.setText(rating);
					txtReviews10.setText(reviews);
					txtUploaded10.setText(uploaded);
					btnView10.setEnabled(true);
					btnNext.setEnabled(true);
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
	 * @see DiscoverSongScreen
	 */
	
	public void clearScreen() {
		
		btnNext.setEnabled(false);
		btnPrevious.setEnabled(false);

		txtTitle1.setText("");
		txtArtist1.setText("");
		txtGenre1.setText("");
		txtRating1.setText("");
		txtReviews1.setText("");
		txtUploaded1.setText("");
		btnView1.setEnabled(false);

		txtTitle2.setText("");
		txtArtist2.setText("");
		txtGenre2.setText("");
		txtRating2.setText("");
		txtReviews2.setText("");
		txtUploaded2.setText("");
		btnView2.setEnabled(false);
		
		txtTitle3.setText("");
		txtArtist3.setText("");
		txtGenre3.setText("");
		txtRating3.setText("");
		txtReviews3.setText("");
		txtUploaded3.setText("");
		btnView3.setEnabled(false);
		
		txtTitle4.setText("");
		txtArtist4.setText("");
		txtGenre4.setText("");
		txtRating4.setText("");
		txtReviews4.setText("");
		txtUploaded4.setText("");
		btnView4.setEnabled(false);
		
		txtTitle5.setText("");
		txtArtist5.setText("");
		txtGenre5.setText("");
		txtRating5.setText("");
		txtReviews5.setText("");
		txtUploaded5.setText("");
		btnView5.setEnabled(false);
		
		txtTitle6.setText("");
		txtArtist6.setText("");
		txtGenre6.setText("");
		txtRating6.setText("");
		txtReviews6.setText("");
		txtUploaded6.setText("");
		btnView6.setEnabled(false);
		
		txtTitle7.setText("");
		txtArtist7.setText("");
		txtGenre7.setText("");
		txtRating7.setText("");
		txtReviews7.setText("");
		txtUploaded7.setText("");
		btnView7.setEnabled(false);
		
		txtTitle8.setText("");
		txtArtist8.setText("");
		txtGenre8.setText("");
		txtRating8.setText("");
		txtReviews8.setText("");
		txtUploaded8.setText("");
		btnView8.setEnabled(false);
		
		txtTitle9.setText("");
		txtArtist9.setText("");
		txtGenre9.setText("");
		txtRating9.setText("");
		txtReviews9.setText("");
		txtUploaded9.setText("");
		btnView9.setEnabled(false);
		
		txtTitle10.setText("");
		txtArtist10.setText("");
		txtGenre10.setText("");
		txtRating10.setText("");
		txtReviews10.setText("");
		txtUploaded10.setText("");
		btnView10.setEnabled(false);

	}
}
