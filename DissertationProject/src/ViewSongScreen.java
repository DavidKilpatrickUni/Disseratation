import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * View part of the Tired architecture structure.
 * </p>
 * 
 * <p>
 * ViewSongScreen
 * </p>
 * 
 * <p>
 * Allows users view and interact with a selected song on Elenco database part of the program. 
 * <br> Can read the extra details about the song
 * <br> View comments uploaded by other Elenco users about the song.
 * <br> Create and upload their own comment about the selected song.
 * <br> Set a personal rating for the selected song that impacts overall rating of the song.
 * <br>Has a direct link with <code>ViewSongApplication</code> that takes user input/tasks to process.
 * </p>
 * 
 *
 * @see DiscoverSongApplication
 */

public class ViewSongScreen extends JFrame {

	
	// variables
	
	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldArtist;
	private JTextField txtUsername1;
	private JTextField txtComment1;
	private JTextField txtUsername2;
	private JTextField txtComment2;
	private JTextField txtCommentCount;
	private JTextField textFieldAddComment;
	private JButton btnAddComment;
	private JLabel lblNumber1;
	private JTextField txtPosted1;
	private JTextField txtPosted2;
	private JLabel lblLength;
	private JLabel lblAlbum;
	private JLabel lblGenre;
	private JLabel lblReleased;
	private JTextField txtLength;
	private JTextField txtAlbum;
	private JTextField txtGenre;
	private JTextField txtReleased;
	private JTextArea textArea;
	private JButton btn;
	private JTextField txtUsername3;
	private JTextField txtUsername4;
	private JTextField txtUsername5;
	private JLabel lblNumber2;
	private JButton btnPrevious;
	private JButton btnNext;
	private JTextField txtComment3;
	private JTextField txtComment4;
	private JTextField txtComment5;
	private JTextField txtPosted3;
	private JTextField txtPosted4;
	private JTextField txtPosted5;
	private JLabel lblComment1;
	private JLabel lblComment2;
	private JTextField txtPage;
	private JLabel lblPage;
	private JComboBox comboBoxRating;
	
	private int pageCount = 1;
	private int sqlOffset = 0;					// variable for offset during mysql LIMIT queries
	private int sqlRowCount = 5;				// variable for count during mysql LIMIT queries
	private JLabel lblSongImage;
	
	/**
	 * <h1> Constructor </h1>
	 * 
	 * <p>
	 * Default constructor for the <code>ViewSongScreen</code> class. 
	 * </p>
	 * 
	 * <p>
	 * Sets up GUI elements and adds them to JPanel variable.
	 * <br>Has ActionListeners to act on user input.
	 * <br>Makes use of CustomException to rely feedback to user.
	 * </p>
	 * <p>
	 * Parameter one is the current information of the user currently logged into the application. A <code>LoggedIn</code> object is used to store the data.
	 * Parameter two is the current songID that has been selected by the user on previous GUI. A <code>String</code> object is used to store the data.
	 * </p>
	 * 
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information.
	 * @param currentSongID			<code>String</code> object to store current songID information.
	 * 
	 * @see ViewSongScreen
	 * @see LoggedIN
	 * @see String
	 * @see CustomException
	 */

	public ViewSongScreen(LoggedIn currentLoggedIn, String currentSongID) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - View Song");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				clearScreen();
				txtPage.setText(String.valueOf(pageCount));
				loadComments(currentSongID);
				loadSongInfo(currentSongID);
				loadRating(currentSongID, currentLoggedIn);
	
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setToolTipText("Title Of Song");
		textFieldTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textFieldTitle.setBounds(355, 120, 200, 25);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		textFieldArtist = new JTextField();
		textFieldArtist.setToolTipText("Artist Of Song");
		textFieldArtist.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textFieldArtist.setBounds(355, 160, 200, 25);
		contentPane.add(textFieldArtist);
		textFieldArtist.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblTitle.setBounds(270, 120, 50, 25);
		lblTitle.setForeground(new Color(90, 192, 217));
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Georgia", Font.BOLD, 12));
		lblArtist.setBounds(270, 160, 50, 25);
		lblArtist.setForeground(new Color(90, 192, 217));
		contentPane.add(lblArtist);
		
		txtCommentCount = new JTextField();
		txtCommentCount.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtCommentCount.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCommentCount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCommentCount.setText("0");
		txtCommentCount.setBounds(74, 360, 50, 25);
		contentPane.add(txtCommentCount);
		txtCommentCount.setColumns(10);
		
		textFieldAddComment = new JTextField();
		textFieldAddComment.setToolTipText("Type Your Comment Here");
		textFieldAddComment.setBounds(209, 360, 500, 25);
		contentPane.add(textFieldAddComment);
		textFieldAddComment.setColumns(10);
		
		btnAddComment = new JButton("Add Comment");
		btnAddComment.setToolTipText("Click To Add Your Comment To This Song");
		btnAddComment.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Upload Comment?", "Elenco - Upload Comment", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	

						if(Helper.checkBlank(textFieldAddComment.getText().strip()) || Helper.regexSQLInjection(textFieldAddComment.getText().strip())) {	// check comment user input is not blank and sql sanitised 
							
							JOptionPane.showMessageDialog(null, "Valid Comment Input Required - Can Not Contain Banned Special Characters", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
						else
						{
						
							MySQLQueries.addComment(currentSongID, currentLoggedIn.getCurrentUserID(), textFieldAddComment.getText().strip());							// Upload comment and create new database entry using user input
							JOptionPane.showMessageDialog(null, "Comment Successfully Uploaded", "Elenco - Upload Comment", JOptionPane.INFORMATION_MESSAGE,null);
							textFieldAddComment.setText("");
							
						}
				}
			}
		});
		btnAddComment.setBounds(714, 360, 105, 25);
		contentPane.add(btnAddComment);
		
		lblNumber1 = new JLabel("Number Of \r\n");
		lblNumber1.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNumber1.setBounds(10, 355, 75, 25);
		lblNumber1.setForeground(new Color(90, 192, 217));
		contentPane.add(lblNumber1);
		
		lblLength = new JLabel("Song Length");
		lblLength.setFont(new Font("Georgia", Font.BOLD, 12));
		lblLength.setBounds(580, 160, 100, 25);
		lblLength.setForeground(new Color(90, 192, 217));
		contentPane.add(lblLength);
		
		lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Georgia", Font.BOLD, 12));
		lblAlbum.setBounds(270, 200, 50, 25);
		lblAlbum.setForeground(new Color(90, 192, 217));
		contentPane.add(lblAlbum);
		
		lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGenre.setBounds(580, 120, 100, 25);
		lblGenre.setForeground(new Color(90, 192, 217));
		contentPane.add(lblGenre);
		
		lblReleased = new JLabel("Released");
		lblReleased.setFont(new Font("Georgia", Font.BOLD, 12));
		lblReleased.setBounds(580, 200, 100, 25);
		lblReleased.setForeground(new Color(90, 192, 217));
		contentPane.add(lblReleased);
		
		txtLength = new JTextField();
		txtLength.setToolTipText("Length Of Song");
		txtLength.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtLength.setBounds(680, 160, 100, 25);
		contentPane.add(txtLength);
		txtLength.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setToolTipText("Album Song Is From Or Name Of Single");
		txtAlbum.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtAlbum.setBounds(355, 200, 200, 25);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setToolTipText("Genre Of Song");
		txtGenre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre.setBounds(680, 120, 100, 25);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtReleased = new JTextField();
		txtReleased.setToolTipText("Release Date Of Song");
		txtReleased.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReleased.setBounds(680, 200, 100, 25);
		contentPane.add(txtReleased);
		txtReleased.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setToolTipText("Information/Detail About The Song");
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textArea.setBounds(25, 249, 533, 100);
		contentPane.add(textArea);
		
		JLabel lblMyRating = new JLabel("My Rating");
		lblMyRating.setFont(new Font("Georgia", Font.BOLD, 12));
		lblMyRating.setBounds(580, 270, 75, 25);
		lblMyRating.setForeground(new Color(90, 192, 217));
		contentPane.add(lblMyRating);
		
		btn = new JButton("Back");
		btn.setToolTipText("Reurn To Previous Screen");
		btn.setFont(new Font("Georgia", Font.PLAIN, 11));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiscoverSongScreen frame = new DiscoverSongScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();

			}
		});
		btn.setBounds(372, 670, 100, 25);
		contentPane.add(btn);
		
		JLabel lblHeader = new JLabel("Elenco - Song Info");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(420, 40, 300, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					
		Image appImage = appIcon.getImage();															
		Image appImageResize = appImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		
		appIcon = new ImageIcon(appImageResize);														
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(360, 2, 100, 100);
		contentPane.add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 393, 814, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername1 = new JTextField();
		txtUsername1.setToolTipText("User Name Of Uploaded Comment");
		txtUsername1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername1.setBounds(65, 10, 125, 25);
		panel.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		txtUsername2 = new JTextField();
		txtUsername2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername2.setBounds(65, 45, 125, 25);
		panel.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		txtUsername3 = new JTextField();
		txtUsername3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername3.setBounds(65, 80, 125, 25);
		panel.add(txtUsername3);
		txtUsername3.setColumns(10);
		
		txtUsername4 = new JTextField();
		txtUsername4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername4.setBounds(65, 115, 125, 25);
		panel.add(txtUsername4);
		txtUsername4.setColumns(10);
		
		txtUsername5 = new JTextField();
		txtUsername5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername5.setBounds(65, 150, 125, 25);
		panel.add(txtUsername5);
		txtUsername5.setColumns(10);
		
		txtComment1 = new JTextField();
		txtComment1.setToolTipText("Comment Uploaded By User");
		txtComment1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment1.setBounds(200, 10, 500, 25);
		panel.add(txtComment1);
		txtComment1.setColumns(10);
		
		txtComment2 = new JTextField();
		txtComment2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment2.setBounds(200, 45, 500, 25);
		panel.add(txtComment2);
		txtComment2.setColumns(10);
		
		txtPosted1 = new JTextField();
		txtPosted1.setToolTipText("Date The Comment Was Posted");
		txtPosted1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted1.setBounds(708, 10, 100, 25);
		panel.add(txtPosted1);
		txtPosted1.setColumns(10);
		
		txtPosted2 = new JTextField();
		txtPosted2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted2.setBounds(708, 45, 100, 25);
		panel.add(txtPosted2);
		txtPosted2.setColumns(10);
		
		txtComment3 = new JTextField();
		txtComment3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment3.setColumns(10);
		txtComment3.setBounds(200, 80, 500, 25);
		panel.add(txtComment3);
		
		txtComment4 = new JTextField();
		txtComment4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment4.setColumns(10);
		txtComment4.setBounds(200, 115, 500, 25);
		panel.add(txtComment4);
		
		txtComment5 = new JTextField();
		txtComment5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment5.setColumns(10);
		txtComment5.setBounds(200, 150, 500, 25);
		panel.add(txtComment5);
		
		txtPosted3 = new JTextField();
		txtPosted3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted3.setColumns(10);
		txtPosted3.setBounds(708, 80, 100, 25);
		panel.add(txtPosted3);
		
		txtPosted4 = new JTextField();
		txtPosted4.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted4.setColumns(10);
		txtPosted4.setBounds(708, 115, 100, 25);
		panel.add(txtPosted4);
		
		txtPosted5 = new JTextField();
		txtPosted5.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted5.setColumns(10);
		txtPosted5.setBounds(708, 150, 100, 25);
		panel.add(txtPosted5);
		
		comboBoxRating = new JComboBox();
		comboBoxRating.setToolTipText("Select Your Rating For This Song");
		comboBoxRating.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxRating.setModel(new DefaultComboBoxModel(new String[] {"Not Rated", "1", "2", "3", "4", "5"}));
		comboBoxRating.setBounds(680, 270, 100, 25);
		contentPane.add(comboBoxRating);
		
		JButton btnRate = new JButton("Update Rating");
		btnRate.setToolTipText("Click To Update Your Rating For This Song");
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					attemptRatingChange(currentLoggedIn, currentSongID , comboBoxRating.getSelectedItem().toString());																// Change current userID's rating for selected song
					JOptionPane.showMessageDialog(null, "Rating For This Song Has Been Updated", "Elenco - Successful Change Of Rating", JOptionPane.INFORMATION_MESSAGE,null);
				} 
				catch (CustomException error) 
				{
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
				}
			
			
			}
		});
		btnRate.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRate.setBounds(620, 310, 125, 25);
		contentPane.add(btnRate);
		
		lblNumber2 = new JLabel("Comments");
		lblNumber2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNumber2.setBounds(10, 365, 75, 25);
		lblNumber2.setForeground(new Color(90, 192, 217));
		contentPane.add(lblNumber2);
		
		btnPrevious = new JButton("Previous Page");
		btnPrevious.setToolTipText("View Previous Page Of Comments");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount + 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset - 5);
				clearScreen();
				loadComments(currentSongID);
			}
		});
		btnPrevious.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnPrevious.setBounds(240, 590, 150, 25);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next Page");
		btnNext.setToolTipText("View Next Page Of Comments");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount + 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset + 5);
				clearScreen();
				loadComments(currentSongID);
			}
		});
		btnNext.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNext.setBounds(460, 590, 150, 25);
		contentPane.add(btnNext);
		
		lblComment1 = new JLabel("New");
		lblComment1.setHorizontalAlignment(SwingConstants.CENTER);
		lblComment1.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblComment1.setForeground(new Color(90, 192, 217));
		lblComment1.setBounds(151, 355, 50, 25);
		contentPane.add(lblComment1);
		
		lblComment2 = new JLabel("Comment");
		lblComment2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblComment2.setForeground(new Color(90, 192, 217));
		lblComment2.setBounds(151, 365, 50, 25);
		contentPane.add(lblComment2);
		
		txtPage = new JTextField();
		txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPage.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setBounds(400, 590, 50, 25);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
		
		lblPage = new JLabel("Page");
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage.setForeground(new Color(90, 192, 217));
		lblPage.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPage.setBounds(400, 626, 50, 14);
		contentPane.add(lblPage);
		
		ImageIcon songIcon =  new ImageIcon(ApplicationStartup.class.getResource("/ProfileIcon.PNG"));					
		Image songImage = songIcon.getImage();															
		Image songImageResize = songImage.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH);		
		songIcon = new ImageIcon(songImageResize);
		
		lblSongImage = new JLabel(songIcon);
		lblSongImage.setBounds(25, 30, 200, 200);
		contentPane.add(lblSongImage);
	}

	/**
	 * <h1> Method </h1>
	 * <p>
	 * Receives parameter from <code>DiscoverSongScreen</code> and uses it to search the database to find all comments for the matching songID and populates the screen with the appropriate content.
	 * </p>
	 * @param currentSongID		<code>String</code> object to store current songID information. 
	 *
	 * @see DiscoverSongScreen
	 * @see String
	 * @see int
	 * @see ResultSet
	 */
	
	public void loadComments(String currentSongID) {	
		
		txtPage.setText(String.valueOf(pageCount));
		
		if (sqlOffset > 4) {														// Makes the 'Previous' button only selectable when viable																							
			
			btnPrevious.setEnabled(true);
			
		}
		else 
		{																								
			
			btnPrevious.setEnabled(false);
		}
	
		ResultSet songComments  = MySQLQueries.getComments(currentSongID, sqlOffset, sqlRowCount);	// Search database for comments about current songID  Limited to 5 results


		String userName = null;
		String comment = null;
		String posted = null;
		int row = 1;
	
		try {
		
			while (songComments.next())														// while a search result is found, set following variables to data in stated 'column' names of the database 																
			{
			
			userName = songComments.getString("UserName");
			comment = songComments.getString("Comment");
			posted = songComments.getString("Posted");
			
			txtCommentCount.setText(String.valueOf(songComments.getRow()));					// Switch to fill the appropriate line of the search result section of the GUI i.e populate each row inturn for ever iteration of while loop. Only 5 results are on screen at a time 
			
			switch (row) {
				case 1:
		
					txtUsername1.setText(userName);
					txtComment1.setText(comment);
					txtPosted1.setText(posted);
					break;
				case 2:
			
					txtUsername2.setText(userName);
					txtComment2.setText(comment);
					txtPosted2.setText(posted);
					break;
				case 3:
					txtUsername3.setText(userName);
					txtComment3.setText(comment);
					txtPosted3.setText(posted);
					break;
				case 4:
					txtUsername4.setText(userName);
					txtComment4.setText(comment);
					txtPosted4.setText(posted);
					break;
				case 5:
					txtUsername5.setText(userName);
					txtComment5.setText(comment);
					txtPosted5.setText(posted);
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
	 * @see ViewSongScreen
	 */
	
	public void clearScreen() {
	

		btnNext.setEnabled(false);
		btnPrevious.setEnabled(false);

		txtUsername1.setText("");
		txtComment1.setText("");
		txtPosted1.setText("");

		txtUsername2.setText("");
		txtComment2.setText("");
		txtPosted2.setText("");

		txtUsername3.setText("");
		txtComment3.setText("");
		txtPosted3.setText("");

		txtUsername4.setText("");
		txtComment4.setText("");
		txtPosted4.setText("");

		txtUsername5.setText("");
		txtComment5.setText("");
		txtPosted5.setText("");

		}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for updating a individuals rating for a song
	 * <br> Firstly checks if rating valid then if rating already exists for song by the individual
	 * <br> Dependent on outcome, it either UPDATES the database using mySQL or INSERTs a new database entry.
	 * <br> Throws CustomException if user inputs invalid inputs for feedback purposes
	 * </p>
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information. 
	 * @param currentSongID			<code>String</code> object to store current songID information. 
	 * @param comboBoxRating		<code>String</code> object to store new song rating.
	 *
	 * @see ViewSongScreen
	 * @see LoggedIn
	 * @see CustomException
	 * @see String
	 * @see int
	 * @see ResultSet
	 */

	public void attemptRatingChange(LoggedIn currentLoggedIn, String currentSongID , String comboBoxRating ) throws CustomException {

		if(comboBoxRating.equals("Not Rated"))																		// Checks current value of comboBox to see if valid input
		{
			System.out.println(" No rating provided ");
			throw new CustomException("Valid Rating Input Required - Rate Between 1 And 5", "rating");				// Throw if false

		}
		else
		{
			
			ResultSet ratingValue = MySQLQueries.myRating(currentSongID, currentLoggedIn.getCurrentUserID());		// Search database for rating of the current song by user
			
			try {
				
				if (ratingValue.next())																				// If a database row is returned UPDATE the database													
				{
					MySQLQueries.updateRating(currentSongID, currentLoggedIn.getCurrentUserID(), comboBoxRating);	// Update rating

					ResultSet  getAllRatings = MySQLQueries.getAllRatings(currentSongID);							// Since rating has change we must establish overall rating for song
																													// This is done by finding all ratings for song, totalling them and dividing by number of users who have a rating
					int totalReviews = 0;
					double totalRatings = 0 ;
					double overallRating;
				
					
					while(getAllRatings.next()) 																	// While rows in ResultSet exist
					{
					
						totalRatings = totalRatings + getAllRatings.getDouble("Rating");							// Ratings equals itself plus rating contained in ResultSet row
						totalReviews++;	
					}
					
					overallRating = (totalRatings/totalReviews);													// Quick math to find overall rating
					System.out.println("Total number of reviews: " + totalReviews + " Total ratings: "+ totalRatings+ " Overall Rating: "+overallRating);

					MySQLQueries.updateTotals(currentSongID, overallRating, totalReviews);							// Update the overallrating of the song to the established new amount and set totalReviews to number of rows
																													// in ResultSet (i.e number of users who rated song)
																													
				}
				else																								// User has not rated song before
				{
					MySQLQueries.createRating(currentSongID, currentLoggedIn.getCurrentUserID(), comboBoxRating);	// Create a rating for database
				
					ResultSet  getTotals = MySQLQueries.getAllRatings(currentSongID);								// Since a new rating exists that has not been included in totals we must update totals
			
					int totalReviews = 0;
					double totalRatings = 0 ;
					double overallRating;
				
					
					while(getTotals.next()) 																		// While rows in ResultSet exist
					{
					
						totalRatings = totalRatings + getTotals.getDouble("Rating");	
						totalReviews++;																				// Ratings equals itself plus rating contained in ResultSet row
					}
					
					overallRating = (totalRatings/totalReviews);
					System.out.println("Total number of reviews: " + totalReviews + " Total ratings: "+ totalRatings+ " Overall Rating: "+overallRating);
				

					MySQLQueries.updateTotals(currentSongID, overallRating, totalReviews);							// Update the overallrating of the song to the established new amount and set totalReviews to number of rows
																													// in ResultSet (i.e number of users who rated song)
					
				}
				
			}
			catch(SQLException sql)
			{
				
			}


		}
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for loading the current song details using parameter
	 * <p>
	 * @param currentSongID			<code>String</code> object to store current songID information. 
	 *
	 * @see ViewSongScreen
	 * @see String
	 * @see ResultSet
	 */
	public void loadSongInfo(String currentSongID) {
	
		ResultSet songDetails = MySQLQueries.songDetails(currentSongID);				// Search for current song using songID so the screen can be populated with appropriate details 
	
		String title = null;
		String artist = null;
		String length = null;
		String album = null;
		String genre = null;
		String released = null;
		String info =null;

		try 
		{
		
			while (songDetails.next())													// While a entry in the database equals the provided songID, set following variables to data in stated 'column' names of the database 													
			{
				title = songDetails.getString("Title");
				artist = songDetails.getString("Artist");
				length = songDetails.getString("Song Length");
				album = songDetails.getString("Album");
				genre = songDetails.getString("Genre");
				released = songDetails.getString("Released");
				info = songDetails.getString("Song Info");

				textFieldTitle.setText(title);
				textFieldArtist.setText(artist);
				txtLength.setText(length);
				txtAlbum.setText(album);
				txtGenre.setText(genre);
				txtReleased.setText(released);
				textArea.setText(info);
				
			}

		}
		catch (SQLException sqe)
		{
		
		}
	}
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * Method for loading the current rating that the current user has specified using parameter
	 * <p>
	 * @param currentSongID			<code>String</code> object to store current songID information. 
	 * @param currentLoggedIn		<code>LoggedIn</code> object to store current user information. 
	 * 
	 * @see ViewSongScreen
	 * @see LoggedIn
	 * @see String
	 * @see ResultSet
	 */
	public void loadRating(String currentSongID , LoggedIn currentLoggedIn) {
		
		ResultSet ratingValue = MySQLQueries.myRating(currentSongID, currentLoggedIn.getCurrentUserID());			// Retrieve the rating of the song provided by the current user
		
		try 
		{
			while (ratingValue.next())																				// If an entry is found, set comboBox to found value. The comboBox is set to 'Not Rated' by default 
			{
				String rating = null;
				rating = ratingValue.getString("Rating");
				comboBoxRating.setSelectedItem(rating.substring(0,1));
				System.out.println("My rating: " + rating);
			}
		
		}
		catch(SQLException sql)
		{
		
		}
	}
	
}
