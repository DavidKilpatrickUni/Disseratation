import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
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
 * AddToPlaylistScreen
 * </p>
 * 
 * <p>
 * Allows users to custom search through all the songs on Elenco database part of the program. 
 * <br> Once desired song has been found it can be added to the newly created playlist or to the existing playlist selected
 * <br>Has a direct link with <code>AddToPlaylistApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see AddToPlaylistApplication
 */

public class AddToPlaylistScreen extends JFrame {

	// Variables 
	
	private JPanel contentPane;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtRating1;
	private JTextField txtReviews1;
	private JTextField txtUploaded1;
	private JTextField txtSongID1;
	private JButton btnBack;
	
	private JRadioButton rdbtnAscending;
	private JRadioButton rdbtnDescending;
	private JTextField txtTitle2;
	private JTextField txtTitle3;
	private JTextField txtTitle9;
	private JTextField txtTitle8;
	private JTextField txtTitle7;
	private JTextField txtTitle6;
	private JTextField txtTitle5;
	private JTextField txtTitle4;
	private JTextField txtTitle10;
	private JTextField txtArtist2;
	private JTextField txtArtist10;
	private JTextField txtArtist9;
	private JTextField txtArtist8;
	private JTextField txtArtist7;
	private JTextField txtArtist6;
	private JTextField txtArtist5;
	private JTextField txtArtist4;
	private JTextField txtArtist3;
	private JTextField txtGenre2;
	private JTextField txtGenre10;
	private JTextField txtGenre9;
	private JTextField txtGenre8;
	private JTextField txtGenre7;
	private JTextField txtGenre6;
	private JTextField txtGenre5;
	private JTextField txtGenre3;
	private JTextField txtGenre4;
	private JTextField txtRating10;
	private JTextField txtRating9;
	private JTextField txtRating8;
	private JTextField txtRating7;
	private JTextField txtRating6;
	private JTextField txtRating5;
	private JTextField txtRating4;
	private JTextField txtRating3;
	private JTextField txtRating2;
	private JTextField txtReviews2;
	private JTextField txtReviews10;
	private JTextField txtReviews9;
	private JTextField txtReviews8;
	private JTextField txtReviews7;
	private JTextField txtReviews6;
	private JTextField txtReviews5;
	private JTextField txtReviews4;
	private JTextField txtReviews3;
	private JTextField txtUploaded2;
	private JTextField txtUploaded10;
	private JTextField txtUploaded9;
	private JTextField txtUploaded8;
	private JTextField txtUploaded7;
	private JTextField txtUploaded6;
	private JTextField txtUploaded5;
	private JTextField txtUploaded4;
	private JTextField txtUploaded3;
	private JLabel lblTitle;
	private JLabel lblArtist;
	private JLabel lblGenre;
	private JLabel lblRating;
	private JLabel lblViews;
	private JLabel lblUploaded;
	private JTextField txtSongID2;
	private JTextField txtSongID3;
	private JTextField txtSongID4;
	private JTextField txtSongID5;
	private JTextField txtSongID6;
	private JTextField txtSongID7;
	private JTextField txtSongID8;
	private JTextField txtSongID9;
	private JTextField txtSongID10;
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblPage;
	private JTextField txtPage;
	
	
	private JComboBox comboBoxSearch;
	private JComboBox comboBoxCriteria;

	
	private JButton btnAdd1;
	private JButton btnAdd2;
	private JButton btnAdd3;
	private JButton btnAdd4;
	private JButton btnAdd5;
	private JButton btnAdd6;
	private JButton btnAdd7;
	private JButton btnAdd8;
	private JButton btnAdd9;
	private JButton btnAdd10;

	private int pageCount = 1;		
	private int sqlOffset = 0;		// variable for offset during mysql LIMIT queries
	private int sqlRowCount = 10;	// variable for count during mysql LIMIT queries
	private JButton btnSearch;
	private JComboBox comboBoxSort;
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Constructor for the <code>AddToPlaylistScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * <br>Makes use of <code>CustomException</code> to rely feedback to user.
	 * </p>
	 * 
	 * <p>
	 * Parameter is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * <br>Parameter is the current playlist information - Title, Id etc. A <code>PlaylistInfo</code> object is used to store the data.
	 * <br>Parameter is the rank that the song will be added to the playlist, determined by which 'row' add button the user selected . A <code>Integer</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentLoggedIn			<code>LoggedIn</code> object to store current user information.
	 * @param currentPlaylistInfo		<code>PlaylistInfo</code> object to store current playlist information.
	 * @param ranking					<code>Integer</code> object to store current rank information.
	 * 
	 * @see AddToPlaylistScreen
	 * @see LoggedIN
	 * @see PlaylistInfo
	 * @see Integer
	 */

	public AddToPlaylistScreen(LoggedIn currentLoggedIn, PlaylistInfo currentPlaylistInfo, int ranking) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println(currentPlaylistInfo.getCurrentPlaylistTitle() + currentPlaylistInfo.getCurrentPlaylistID());
				clearScreen();
				txtPage.setText(String.valueOf(pageCount));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Add Song To Playlist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 691);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSearch = new JButton("Search");
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
		btnSearch.setBounds(860, 140, 125, 25);
		contentPane.add(btnSearch);
		
		ButtonGroup radioButtons = new ButtonGroup();
		
	
		rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnAscending.setForeground(new Color(90, 192, 217));
		rdbtnAscending.setBackground(Color.WHITE);
		rdbtnAscending.setBounds(725, 125, 109, 23);
		contentPane.add(rdbtnAscending);
		
		rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnDescending.setForeground(new Color(90, 192, 217));
		rdbtnDescending.setBackground(Color.WHITE);
		rdbtnDescending.setSelected(true);
		rdbtnDescending.setBounds(725, 155, 109, 23);
		contentPane.add(rdbtnDescending);
		
		radioButtons.add(rdbtnAscending);																							
		radioButtons.add(rdbtnDescending);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle1.setBounds(40, 220, 180, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		txtReviews1.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews1.setBounds(645, 220, 75, 20);
		contentPane.add(txtReviews1);
		txtReviews1.setColumns(10);
		
		txtUploaded1 = new JTextField();
		txtUploaded1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded1.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded1.setBounds(750, 220, 100, 20);
		contentPane.add(txtUploaded1);
		txtUploaded1.setColumns(10);
		
		btnAdd1 = new JButton("Add To Playlist");
		btnAdd1.setEnabled(false);
		btnAdd1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {		
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID1.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
				
			}
		});
		btnAdd1.setBounds(860, 220, 125, 20);
		contentPane.add(btnAdd1);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"Title", "Artist", "Genre"}));
		comboBoxCriteria.setBounds(385, 140, 110, 25);
		contentPane.add(comboBoxCriteria);
		
		txtSongID1 = new JTextField();
		txtSongID1.setVisible(false);
		txtSongID1.setBounds(995, 219, 25, 20);
		contentPane.add(txtSongID1);
		txtSongID1.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
				gui.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(440, 610, 100, 25);
		contentPane.add(btnBack);
		
		JLabel lblElencoAdd = new JLabel("Elenco - Add To Playlist");
		lblElencoAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblElencoAdd.setForeground(new Color(90, 192, 217));
		lblElencoAdd.setFont(new Font("Georgia", Font.BOLD, 24));
		lblElencoAdd.setBounds(366, 41, 300, 25);
		contentPane.add(lblElencoAdd);
		
		txtTitle2 = new JTextField();
		txtTitle2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle2.setColumns(10);
		txtTitle2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle2.setBounds(40, 250, 180, 20);
		contentPane.add(txtTitle2);
		
		txtTitle3 = new JTextField();
		txtTitle3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle3.setColumns(10);
		txtTitle3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle3.setBounds(40, 280, 180, 20);
		contentPane.add(txtTitle3);
		
		txtTitle9 = new JTextField();
		txtTitle9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle9.setColumns(10);
		txtTitle9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle9.setBounds(40, 460, 180, 20);
		contentPane.add(txtTitle9);
		
		txtTitle8 = new JTextField();
		txtTitle8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle8.setColumns(10);
		txtTitle8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle8.setBounds(40, 430, 180, 20);
		contentPane.add(txtTitle8);
		
		txtTitle7 = new JTextField();
		txtTitle7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle7.setColumns(10);
		txtTitle7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle7.setBounds(40, 400, 180, 20);
		contentPane.add(txtTitle7);
		
		txtTitle6 = new JTextField();
		txtTitle6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle6.setColumns(10);
		txtTitle6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle6.setBounds(40, 370, 180, 20);
		contentPane.add(txtTitle6);
		
		txtTitle5 = new JTextField();
		txtTitle5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle5.setColumns(10);
		txtTitle5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle5.setBounds(40, 340, 180, 20);
		contentPane.add(txtTitle5);
		
		txtTitle4 = new JTextField();
		txtTitle4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle4.setColumns(10);
		txtTitle4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle4.setBounds(40, 310, 180, 20);
		contentPane.add(txtTitle4);
		
		txtTitle10 = new JTextField();
		txtTitle10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTitle10.setColumns(10);
		txtTitle10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle10.setBounds(40, 490, 180, 20);
		contentPane.add(txtTitle10);
		
		txtArtist2 = new JTextField();
		txtArtist2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist2.setColumns(10);
		txtArtist2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist2.setBounds(250, 250, 150, 20);
		contentPane.add(txtArtist2);
		
		txtArtist10 = new JTextField();
		txtArtist10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist10.setColumns(10);
		txtArtist10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist10.setBounds(250, 490, 150, 20);
		contentPane.add(txtArtist10);
		
		txtArtist9 = new JTextField();
		txtArtist9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist9.setColumns(10);
		txtArtist9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist9.setBounds(250, 460, 150, 20);
		contentPane.add(txtArtist9);
		
		txtArtist8 = new JTextField();
		txtArtist8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist8.setColumns(10);
		txtArtist8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist8.setBounds(250, 430, 150, 20);
		contentPane.add(txtArtist8);
		
		txtArtist7 = new JTextField();
		txtArtist7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist7.setColumns(10);
		txtArtist7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist7.setBounds(250, 400, 150, 20);
		contentPane.add(txtArtist7);
		
		txtArtist6 = new JTextField();
		txtArtist6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist6.setColumns(10);
		txtArtist6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist6.setBounds(250, 370, 150, 20);
		contentPane.add(txtArtist6);
		
		txtArtist5 = new JTextField();
		txtArtist5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist5.setColumns(10);
		txtArtist5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist5.setBounds(250, 340, 150, 20);
		contentPane.add(txtArtist5);
		
		txtArtist4 = new JTextField();
		txtArtist4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist4.setColumns(10);
		txtArtist4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist4.setBounds(250, 310, 150, 20);
		contentPane.add(txtArtist4);
		
		txtArtist3 = new JTextField();
		txtArtist3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArtist3.setColumns(10);
		txtArtist3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist3.setBounds(250, 280, 150, 20);
		contentPane.add(txtArtist3);
		
		txtGenre2 = new JTextField();
		txtGenre2.setColumns(10);
		txtGenre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre2.setBounds(430, 250, 100, 20);
		contentPane.add(txtGenre2);
		
		txtGenre10 = new JTextField();
		txtGenre10.setColumns(10);
		txtGenre10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre10.setBounds(430, 490, 100, 20);
		contentPane.add(txtGenre10);
		
		txtGenre9 = new JTextField();
		txtGenre9.setColumns(10);
		txtGenre9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre9.setBounds(430, 460, 100, 20);
		contentPane.add(txtGenre9);
		
		txtGenre8 = new JTextField();
		txtGenre8.setColumns(10);
		txtGenre8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre8.setBounds(430, 430, 100, 20);
		contentPane.add(txtGenre8);
		
		txtGenre7 = new JTextField();
		txtGenre7.setColumns(10);
		txtGenre7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre7.setBounds(430, 400, 100, 20);
		contentPane.add(txtGenre7);
		
		txtGenre6 = new JTextField();
		txtGenre6.setColumns(10);
		txtGenre6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre6.setBounds(430, 370, 100, 20);
		contentPane.add(txtGenre6);
		
		txtGenre5 = new JTextField();
		txtGenre5.setColumns(10);
		txtGenre5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre5.setBounds(430, 340, 100, 20);
		contentPane.add(txtGenre5);
		
		txtGenre3 = new JTextField();
		txtGenre3.setColumns(10);
		txtGenre3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre3.setBounds(430, 280, 100, 20);
		contentPane.add(txtGenre3);
		
		txtGenre4 = new JTextField();
		txtGenre4.setColumns(10);
		txtGenre4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre4.setBounds(430, 310, 100, 20);
		contentPane.add(txtGenre4);
		
		txtRating10 = new JTextField();
		txtRating10.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating10.setColumns(10);
		txtRating10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating10.setBounds(565, 490, 50, 20);
		contentPane.add(txtRating10);
		
		txtRating9 = new JTextField();
		txtRating9.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating9.setColumns(10);
		txtRating9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating9.setBounds(565, 460, 50, 20);
		contentPane.add(txtRating9);
		
		txtRating8 = new JTextField();
		txtRating8.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating8.setColumns(10);
		txtRating8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating8.setBounds(565, 430, 50, 20);
		contentPane.add(txtRating8);
		
		txtRating7 = new JTextField();
		txtRating7.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating7.setColumns(10);
		txtRating7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating7.setBounds(565, 400, 50, 20);
		contentPane.add(txtRating7);
		
		txtRating6 = new JTextField();
		txtRating6.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating6.setColumns(10);
		txtRating6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating6.setBounds(565, 370, 50, 20);
		contentPane.add(txtRating6);
		
		txtRating5 = new JTextField();
		txtRating5.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating5.setColumns(10);
		txtRating5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating5.setBounds(565, 340, 50, 20);
		contentPane.add(txtRating5);
		
		txtRating4 = new JTextField();
		txtRating4.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating4.setColumns(10);
		txtRating4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating4.setBounds(565, 310, 50, 20);
		contentPane.add(txtRating4);
		
		txtRating3 = new JTextField();
		txtRating3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating3.setColumns(10);
		txtRating3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating3.setBounds(565, 280, 50, 20);
		contentPane.add(txtRating3);
		
		txtRating2 = new JTextField();
		txtRating2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating2.setColumns(10);
		txtRating2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating2.setBounds(565, 250, 50, 20);
		contentPane.add(txtRating2);
		
		txtReviews2 = new JTextField();
		txtReviews2.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews2.setColumns(10);
		txtReviews2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews2.setBounds(645, 250, 75, 20);
		contentPane.add(txtReviews2);
		
		txtReviews10 = new JTextField();
		txtReviews10.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews10.setColumns(10);
		txtReviews10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews10.setBounds(645, 490, 75, 20);
		contentPane.add(txtReviews10);
		
		txtReviews9 = new JTextField();
		txtReviews9.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews9.setColumns(10);
		txtReviews9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews9.setBounds(645, 460, 75, 20);
		contentPane.add(txtReviews9);
		
		txtReviews8 = new JTextField();
		txtReviews8.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews8.setColumns(10);
		txtReviews8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews8.setBounds(645, 430, 75, 20);
		contentPane.add(txtReviews8);
		
		txtReviews7 = new JTextField();
		txtReviews7.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews7.setColumns(10);
		txtReviews7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews7.setBounds(645, 400, 75, 20);
		contentPane.add(txtReviews7);
		
		txtReviews6 = new JTextField();
		txtReviews6.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews6.setColumns(10);
		txtReviews6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews6.setBounds(645, 370, 75, 20);
		contentPane.add(txtReviews6);
		
		txtReviews5 = new JTextField();
		txtReviews5.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews5.setColumns(10);
		txtReviews5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews5.setBounds(645, 340, 75, 20);
		contentPane.add(txtReviews5);
		
		txtReviews4 = new JTextField();
		txtReviews4.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews4.setColumns(10);
		txtReviews4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews4.setBounds(645, 310, 75, 20);
		contentPane.add(txtReviews4);
		
		txtReviews3 = new JTextField();
		txtReviews3.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews3.setColumns(10);
		txtReviews3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews3.setBounds(645, 280, 75, 20);
		contentPane.add(txtReviews3);
		
		txtUploaded2 = new JTextField();
		txtUploaded2.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded2.setColumns(10);
		txtUploaded2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded2.setBounds(750, 250, 100, 20);
		contentPane.add(txtUploaded2);
		
		txtUploaded10 = new JTextField();
		txtUploaded10.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded10.setColumns(10);
		txtUploaded10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded10.setBounds(750, 490, 100, 20);
		contentPane.add(txtUploaded10);
		
		txtUploaded9 = new JTextField();
		txtUploaded9.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded9.setColumns(10);
		txtUploaded9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded9.setBounds(750, 460, 100, 20);
		contentPane.add(txtUploaded9);
		
		txtUploaded8 = new JTextField();
		txtUploaded8.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded8.setColumns(10);
		txtUploaded8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded8.setBounds(750, 430, 100, 20);
		contentPane.add(txtUploaded8);
		
		txtUploaded7 = new JTextField();
		txtUploaded7.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded7.setColumns(10);
		txtUploaded7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded7.setBounds(750, 400, 100, 20);
		contentPane.add(txtUploaded7);
		
		txtUploaded6 = new JTextField();
		txtUploaded6.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded6.setColumns(10);
		txtUploaded6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded6.setBounds(750, 370, 100, 20);
		contentPane.add(txtUploaded6);
		
		txtUploaded5 = new JTextField();
		txtUploaded5.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded5.setColumns(10);
		txtUploaded5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded5.setBounds(750, 340, 100, 20);
		contentPane.add(txtUploaded5);
		
		txtUploaded4 = new JTextField();
		txtUploaded4.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded4.setColumns(10);
		txtUploaded4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded4.setBounds(750, 310, 100, 20);
		contentPane.add(txtUploaded4);
		
		txtUploaded3 = new JTextField();
		txtUploaded3.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUploaded3.setColumns(10);
		txtUploaded3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded3.setBounds(750, 280, 100, 20);
		contentPane.add(txtUploaded3);
		
		lblTitle = new JLabel("Title");
		lblTitle.setForeground(new Color(90, 192, 217));
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblTitle.setBounds(40, 200, 50, 20);
		contentPane.add(lblTitle);
		
		lblArtist = new JLabel("Artist");
		lblArtist.setForeground(new Color(90, 192, 217));
		lblArtist.setFont(new Font("Georgia", Font.BOLD, 12));
		lblArtist.setBounds(250, 200, 50, 20);
		contentPane.add(lblArtist);
		
		lblGenre = new JLabel("Genre");
		lblGenre.setForeground(new Color(90, 192, 217));
		lblGenre.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGenre.setBounds(430, 200, 50, 20);
		contentPane.add(lblGenre);
		
		lblRating = new JLabel("Rating");
		lblRating.setForeground(new Color(90, 192, 217));
		lblRating.setFont(new Font("Georgia", Font.BOLD, 12));
		lblRating.setBounds(565, 200, 50, 20);
		contentPane.add(lblRating);
		
		lblViews = new JLabel("Reviews");
		lblViews.setForeground(new Color(90, 192, 217));
		lblViews.setFont(new Font("Georgia", Font.BOLD, 12));
		lblViews.setBounds(645, 200, 100, 20);
		contentPane.add(lblViews);
		
		lblUploaded = new JLabel("Uploaded");
		lblUploaded.setForeground(new Color(90, 192, 217));
		lblUploaded.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUploaded.setBounds(750, 200, 100, 20);
		contentPane.add(lblUploaded);
		
		btnAdd2 = new JButton("Add To Playlist");
		btnAdd2.setEnabled(false);
		btnAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID2.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd2.setBounds(860, 250, 125, 20);
		contentPane.add(btnAdd2);
		
		btnAdd3 = new JButton("Add To Playlist");
		btnAdd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID3.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
				
			}
		});
		btnAdd3.setEnabled(false);
		btnAdd3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd3.setBounds(860, 280, 125, 20);
		contentPane.add(btnAdd3);
		
		btnAdd4 = new JButton("Add To Playlist");
		btnAdd4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID4.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd4.setEnabled(false);
		btnAdd4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd4.setBounds(860, 310, 125, 20);
		contentPane.add(btnAdd4);
		
		btnAdd5 = new JButton("Add To Playlist");
		btnAdd5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID5.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd5.setEnabled(false);
		btnAdd5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd5.setBounds(860, 340, 125, 20);
		contentPane.add(btnAdd5);
		
		btnAdd6 = new JButton("Add To Playlist");
		btnAdd6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID6.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd6.setEnabled(false);
		btnAdd6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd6.setBounds(860, 370, 125, 20);
		contentPane.add(btnAdd6);
		
		btnAdd7 = new JButton("Add To Playlist");
		btnAdd7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {		
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID7.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd7.setEnabled(false);
		btnAdd7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd7.setBounds(860, 400, 125, 20);
		contentPane.add(btnAdd7);
		
		btnAdd8 = new JButton("Add To Playlist");
		btnAdd8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID8.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd8.setEnabled(false);
		btnAdd8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd8.setBounds(860, 430, 125, 20);
		contentPane.add(btnAdd8);
		
		btnAdd9 = new JButton("Add To Playlist");
		btnAdd9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID9.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
		});
		btnAdd9.setEnabled(false);
		btnAdd9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd9.setBounds(860, 460, 125, 20);
		contentPane.add(btnAdd9);
		
		btnAdd10 = new JButton("Add To Playlist");
		btnAdd10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Add Song To Playlist?", "Elenco - Add Song To Playlist", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					try 
					{
						tryAddSong(currentLoggedIn, currentPlaylistInfo,ranking, txtSongID10.getText());
						JOptionPane.showMessageDialog(null, "Song Has Been Added To Playlist", "Elenco - Successful Added Song To Playlist", JOptionPane.INFORMATION_MESSAGE,null);
					}
					catch (CustomException error)
					{
						JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				}
				
			}
		});
		btnAdd10.setEnabled(false);
		btnAdd10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd10.setBounds(860, 490, 125, 20);
		contentPane.add(btnAdd10);
		
		txtSongID2 = new JTextField();
		txtSongID2.setVisible(false);
		txtSongID2.setColumns(10);
		txtSongID2.setBounds(995, 249, 25, 20);
		contentPane.add(txtSongID2);
		
		txtSongID3 = new JTextField();
		txtSongID3.setVisible(false);
		txtSongID3.setColumns(10);
		txtSongID3.setBounds(995, 279, 25, 20);
		contentPane.add(txtSongID3);
		
		txtSongID4 = new JTextField();
		txtSongID4.setVisible(false);
		txtSongID4.setColumns(10);
		txtSongID4.setBounds(995, 309, 25, 20);
		contentPane.add(txtSongID4);
		
		txtSongID5 = new JTextField();
		txtSongID5.setVisible(false);
		txtSongID5.setColumns(10);
		txtSongID5.setBounds(995, 339, 25, 20);
		contentPane.add(txtSongID5);
		
		txtSongID6 = new JTextField();
		txtSongID6.setVisible(false);
		txtSongID6.setColumns(10);
		txtSongID6.setBounds(995, 369, 25, 20);
		contentPane.add(txtSongID6);
		
		txtSongID7 = new JTextField();
		txtSongID7.setVisible(false);
		txtSongID7.setColumns(10);
		txtSongID7.setBounds(995, 399, 25, 20);
		contentPane.add(txtSongID7);
		
		txtSongID8 = new JTextField();
		txtSongID8.setVisible(false);
		txtSongID8.setColumns(10);
		txtSongID8.setBounds(995, 429, 25, 20);
		contentPane.add(txtSongID8);
		
		txtSongID9 = new JTextField();
		txtSongID9.setVisible(false);
		txtSongID9.setColumns(10);
		txtSongID9.setBounds(995, 460, 25, 20);
		contentPane.add(txtSongID9);
		
		txtSongID10 = new JTextField();
		txtSongID10.setVisible(false);
		txtSongID10.setColumns(10);
		txtSongID10.setBounds(995, 489, 25, 20);
		contentPane.add(txtSongID10);
		
		comboBoxSearch = new JComboBox();
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
						
						while (populateComboBox.next())
						{
							comboBoxSearch.addItem(populateComboBox.getString(comboBoxCriteria.getSelectedItem().toString()));						// while a search result is found add item to comboBox
						}
					} catch (SQLException sql) {
				
					}
					
			}
		});
		comboBoxSearch.setBounds(110, 140, 180, 25);
		contentPane.add(comboBoxSearch);
		
		JLabel lblSearchFor = new JLabel("Search For");
		lblSearchFor.setForeground(new Color(90, 192, 217));
		lblSearchFor.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSearchFor.setBounds(30, 140, 75, 25);
		contentPane.add(lblSearchFor);
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setForeground(new Color(90, 192, 217));
		lblSearchBy.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSearchBy.setBounds(310, 140, 75, 25);
		contentPane.add(lblSearchBy);
		
		JLabel lblSortBy = new JLabel("Sort By");
		lblSortBy.setForeground(new Color(90, 192, 217));
		lblSortBy.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSortBy.setBounds(520, 140, 48, 25);
		contentPane.add(lblSortBy);
		
		btnPrevious = new JButton("Previous Page");
		btnPrevious.setEnabled(false);
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
		
		btnNext = new JButton("Next Page");
		btnNext.setEnabled(false);
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
		
		lblPage = new JLabel("Page");
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage.setForeground(new Color(90, 192, 217));
		lblPage.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPage.setBounds(460, 560, 50, 14);
		contentPane.add(lblPage);
		
		txtPage = new JTextField();
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPage.setBounds(461, 530, 50, 25);
		contentPane.add(txtPage);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"OverallRating", "TotalReviews", "Uploaded"}));
		comboBoxSort.setBounds(585, 140, 110, 25);
		contentPane.add(comboBoxSort);
	
		
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>AddToPlaylistgScreen</code> and uses them to search the database to find entries matching the search criteria and populates the screen with the appropriate content.
	 * </p>
	 * 
	 *
	 * @see AddToPlaylistgScreen
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
		
	ResultSet searchAttempt = MySQLQueries.search(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem(), comboBoxSort.getSelectedItem(), sortType, sqlOffset, sqlRowCount);	// Search database for custom search criteria Limited to 10 results

		
		
		try {		
			
			while (searchAttempt.next())										// while a search result is found, set following variables to data in stated 'column' names of the database 																	
			{
	
				songID = searchAttempt.getString("SongID");
				title = searchAttempt.getString("Title");
				artist = searchAttempt.getString("Artist");
				genre = searchAttempt.getString("Genre");
				rating = searchAttempt.getString("OverallRating");
				reviews = searchAttempt.getString("TotalReviews");
				uploaded = searchAttempt.getString("uploaded");
				
				
				
				switch (row) {													// Switch to fill the appropriate line of the search result section of the GUI i.e populate each row inturn for ever iteration of while loop. Only 10 results are on screen at a time 
					case 1:
						txtSongID1.setText(songID);
						txtTitle1.setText(title);
						txtArtist1.setText(artist);
						txtGenre1.setText(genre);
						txtRating1.setText(rating);
						txtReviews1.setText(reviews);
						txtUploaded1.setText(uploaded);
						btnAdd1.setEnabled(true);
						break;
					case 2:
						txtSongID2.setText(songID);
						txtTitle2.setText(title);
						txtArtist2.setText(artist);
						txtGenre2.setText(genre);
						txtRating2.setText(rating);
						txtReviews2.setText(reviews);
						txtUploaded2.setText(uploaded);
						btnAdd2.setEnabled(true);
						break;
					case 3:
						txtSongID3.setText(songID);
						txtTitle3.setText(title);
						txtArtist3.setText(artist);
						txtGenre3.setText(genre);
						txtRating3.setText(rating);
						txtReviews3.setText(reviews);
						txtUploaded3.setText(uploaded);
						btnAdd3.setEnabled(true);
						break;
					case 4:
						txtSongID4.setText(songID);
						txtTitle4.setText(title);
						txtArtist4.setText(artist);
						txtGenre4.setText(genre);
						txtRating4.setText(rating);
						txtReviews4.setText(reviews);
						txtUploaded4.setText(uploaded);
						btnAdd4.setEnabled(true);
						break;
					case 5:
						txtSongID5.setText(songID);
						txtTitle5.setText(title);
						txtArtist5.setText(artist);
						txtGenre5.setText(genre);
						txtRating5.setText(rating);
						txtReviews5.setText(reviews);
						txtUploaded5.setText(uploaded);
						btnAdd5.setEnabled(true);
						break;
					case 6:
						txtSongID6.setText(songID);
						txtTitle6.setText(title);
						txtArtist6.setText(artist);
						txtGenre6.setText(genre);
						txtRating6.setText(rating);
						txtReviews6.setText(reviews);
						txtUploaded6.setText(uploaded);
						btnAdd6.setEnabled(true);
						break;
					case 7:
						txtSongID7.setText(songID);
						txtTitle7.setText(title);
						txtArtist7.setText(artist);
						txtGenre7.setText(genre);
						txtRating7.setText(rating);
						txtReviews7.setText(reviews);
						txtUploaded7.setText(uploaded);
						btnAdd7.setEnabled(true);
						break;
					case 8:
						txtSongID8.setText(songID);
						txtTitle8.setText(title);
						txtArtist8.setText(artist);
						txtGenre8.setText(genre);
						txtRating8.setText(rating);
						txtReviews8.setText(reviews);
						txtUploaded8.setText(uploaded);
						btnAdd8.setEnabled(true);
						break;
					case 9:
						txtSongID9.setText(songID);
						txtTitle9.setText(title);
						txtArtist9.setText(artist);
						txtGenre9.setText(genre);
						txtRating9.setText(rating);
						txtReviews9.setText(reviews);
						txtUploaded9.setText(uploaded);
						btnAdd9.setEnabled(true);
						break;
					case 10:
						txtSongID10.setText(songID);
						txtTitle10.setText(title);
						txtArtist10.setText(artist);
						txtGenre10.setText(genre);
						txtRating10.setText(rating);
						txtReviews10.setText(reviews);
						txtUploaded10.setText(uploaded);
						btnAdd10.setEnabled(true);
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
	 * @see AddToPlaylistScreen
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
		btnAdd1.setEnabled(false);

		txtTitle2.setText("");
		txtArtist2.setText("");
		txtGenre2.setText("");
		txtRating2.setText("");
		txtReviews2.setText("");
		txtUploaded2.setText("");
		btnAdd2.setEnabled(false);
	
		txtTitle3.setText("");
		txtArtist3.setText("");
		txtGenre3.setText("");
		txtRating3.setText("");
		txtReviews3.setText("");
		txtUploaded3.setText("");
		btnAdd3.setEnabled(false);
	
		txtTitle4.setText("");
		txtArtist4.setText("");
		txtGenre4.setText("");
		txtRating4.setText("");
		txtReviews4.setText("");
		txtUploaded4.setText("");
		btnAdd4.setEnabled(false);
	
		txtTitle5.setText("");
		txtArtist5.setText("");
		txtGenre5.setText("");
		txtRating5.setText("");
		txtReviews5.setText("");
		txtUploaded5.setText("");
		btnAdd5.setEnabled(false);
	
		txtTitle6.setText("");
		txtArtist6.setText("");
		txtGenre6.setText("");
		txtRating6.setText("");
		txtReviews6.setText("");
		txtUploaded6.setText("");
		btnAdd6.setEnabled(false);
	
		txtTitle7.setText("");
		txtArtist7.setText("");
		txtGenre7.setText("");
		txtRating7.setText("");
		txtReviews7.setText("");
		txtUploaded7.setText("");
		btnAdd7.setEnabled(false);
	
		txtTitle8.setText("");
		txtArtist8.setText("");
		txtGenre8.setText("");
		txtRating8.setText("");
		txtReviews8.setText("");
		txtUploaded8.setText("");
		btnAdd8.setEnabled(false);
	
		txtTitle9.setText("");
		txtArtist9.setText("");
		txtGenre9.setText("");
		txtRating9.setText("");
		txtReviews9.setText("");
		txtUploaded9.setText("");
		btnAdd9.setEnabled(false);
	
		txtTitle10.setText("");
		txtArtist10.setText("");
		txtGenre10.setText("");
		txtRating10.setText("");
		txtReviews10.setText("");
		txtUploaded10.setText("");
		btnAdd10.setEnabled(false);
	
	
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives user input from <code>AddToPlaylistgScreen</code> and uses them to do different sql queries.
	 * <br> Firstly establishes if the selected song is already exists on selected playlist.
	 * <br> If false adds the song to a playlist b following 1 of 2 paths
	 * <br> 1. The playlist exists and the song is only being added to the current list. Or
	 * <br> 2. A playlist title does not exist so the user is asked for a title so a new playlist can be created.
	 * <br> This new playlist title can not be the same as any other playlist title for the current user.
	 * <br> Failed points in the method throw a <code>CustomException</code>, so feedback can be shown to the user.
	 * </p>
	 *	
	 * <p>
	 * Parameter is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * <br>Parameter is the current playlist information - Title, Id etc. A <code>PlaylistInfo</code> object is used to store the data.
	 * <br>Parameter is the rank that the song will be added to the playlist, determined by which 'row' add button the user selected . A <code>Integer</code> object is used to store the data.
	 * <br>Parameter is the currently selected songID that the user wants to add to playlist.
	 * </p>
	 * 
	 * @param currentLoggedIn			<code>LoggedIn</code> object to store current user information.
	 * @param currentPlaylistInfo		<code>PlaylistInfo</code> object to store current playlist information.
	 * @param ranking					<code>Integer</code> object to store current ranking information.
	 * @param songID					<code>String</code> object to store current songID information.
	 *
	 * @see AddToPlaylistgScreen
	 * @see CustomException
	 * @see LoggedIn
	 * @see PlaylistInfo
	 * @see String
	 * @see Integer
	 * @see ResultSet
	 */

	public void tryAddSong(LoggedIn currentLoggedIn, PlaylistInfo currentPlaylistInfo,int ranking, String songID) throws CustomException {
		
		ResultSet checksong = MySQLQueries.songOnPlaylist(songID,currentLoggedIn.getCurrentUserID(),currentPlaylistInfo.getCurrentPlaylistTitle() );		// Check if song is already on the current palylist of user

		try
		{
			if (checksong.next()){																															// Response if true
				System.out.print("song already on list");
				throw new CustomException("You Already Have This Song In This Playlist", "playlistTitle");

			}
			else
			{
	
				System.out.print("song not already on list");
				
				if (currentPlaylistInfo.getCurrentPlaylistTitle() != null) {																				// Check if the current playlist exists Has title) or needs to be created(no title)
					MySQLQueries.addSong(currentLoggedIn.getCurrentUserID(), songID ,currentPlaylistInfo.getCurrentPlaylistTitle(), ranking);				// True - Add selected song to current playlist of user
	
					ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
					gui.setVisible(true);
					dispose();
				}
				else
				{
					System.out.println("no playlistTitle");
		
					String getPlaylistTitle = (JOptionPane.showInputDialog("Enter A Name For Playlist"));													// False -  Get a new title for playlist
					
					System.out.println("Title given: " + getPlaylistTitle);
					
					if (getPlaylistTitle == null)																											// Validation check
					{
						throw new CustomException("Valid Playlist Title Input Required - No Use Of Banned Special Characters", "playlistTitle");
					}
		
					if (Helper.checkPlaylistTitle(getPlaylistTitle.strip()))																				// validation check
					{
						throw new CustomException("Valid Playlist Title Input Required - No Use Of Banned Special Characters", "playlistTitle");
		
					}
					else
					{
			
						ResultSet checkPlaylist = MySQLQueries.playlistTitleExists(currentLoggedIn.getCurrentUserID(), getPlaylistTitle.strip());			// Check that new title of playlist does not match a playlist that already exists for user
		
		
						try {
							if (checkPlaylist.next()) {
								System.out.println("Playlist title exists for userID");
							
								throw new CustomException("You Already Have A Playlist Using This Title", "playlistTitle");
							}
							else
							{
								currentPlaylistInfo.setCurrentPlaylistTitle(getPlaylistTitle.strip());
				
								MySQLQueries.addSong(currentLoggedIn.getCurrentUserID(), songID ,currentPlaylistInfo.getCurrentPlaylistTitle(), ranking);				// Add song to the newly created playlist 
								System.out.println(currentPlaylistInfo.getCurrentPlaylistTitle() + currentPlaylistInfo.getCurrentPlaylistID());
				
								ResultSet getPlaylistID = MySQLQueries.getPlaylistID(currentLoggedIn.getCurrentUserID(),currentPlaylistInfo.getCurrentPlaylistTitle());	// Because of design - The new playlist ID must be found and passed as parameter to populate next GUI correctly
				
								String playlistID = null;
				
								while(getPlaylistID.next()) {
					
									playlistID = getPlaylistID.getString("PlaylistID");
								}
				
								currentPlaylistInfo.setCurrentPlaylistID(playlistID);											// Add the playlist details to the playlistInfo object
								ManagePlaylistScreen gui = new ManagePlaylistScreen(currentLoggedIn, currentPlaylistInfo);
								gui.setVisible(true);
								dispose();
							}
		
						} catch (SQLException error) {
			
						}
		
					}
				}
			}

		}
		catch (SQLException sqe )
		{
	
		}

	}


}
