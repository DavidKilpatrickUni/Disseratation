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

public class ViewSongScreen extends JFrame {

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
	
	private int pageCount = 0;
	private int sqlOffset = 0;
	private int sqlRowCount = 5;
	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSongScreen frame = new ViewSongScreen();
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
	public ViewSongScreen(LoggedIn currentLoggedIn, String currentSongID) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - View Song");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				clearScreen();
				txtPage.setText(String.valueOf(pageCount));
				loadComments(currentSongID);
				
				
				ResultSet ratingValue = ViewSongApplication.myRating(currentSongID, currentLoggedIn.getCurrentUserID());
					try {
						while (ratingValue.next())
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
				
				
				
				ResultSet songDetails = ViewSongApplication.songDetails(currentSongID);
				
				
				String title = null;
				String artist = null;
				String length = null;
				String album = null;
				String genre = null;
				String released = null;
				String info =null;
	
			
	try {
					
					while (songDetails.next())																	
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
						
					//textFieldCount.setText(String.valueOf(count));
				
						
				/*
				 * 
				 * 	private JTextField txtLength;
	private JTextField txtAlbum;
	private JTextField txtGenre;
	private JTextField txtReleased;
	
	
						private JPanel contentPane;
						private JTextField textFieldUserName;
						private JTextField textFieldArtist1;
						private JTextField textFieldArtist2;
						private JTextField textFieldArtist3;
						private JTextField textFieldGenre1;
						private JTextField textFieldGenre2;
						private JTextField textFieldGenre3;
						*/
						
					
						
					
					
					
				}
				catch (SQLException sqe)
				{
					
				}
				
				
				

				
				
				
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
		textFieldTitle.setEditable(false);
		textFieldTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textFieldTitle.setBounds(355, 120, 200, 25);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		textFieldArtist = new JTextField();
		textFieldArtist.setEditable(false);
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
		txtCommentCount.setEditable(false);
		txtCommentCount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCommentCount.setText("0");
		txtCommentCount.setBounds(74, 360, 50, 25);
		contentPane.add(txtCommentCount);
		txtCommentCount.setColumns(10);
		
		textFieldAddComment = new JTextField();
		textFieldAddComment.setBounds(209, 360, 500, 25);
		contentPane.add(textFieldAddComment);
		textFieldAddComment.setColumns(10);
		
		btnAddComment = new JButton("Add Comment");
		btnAddComment.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		int select;																												// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Upload Comment?", "Elenco - Upload Comment", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {	
				
			
						
						if(!Helper.checkBlank(textFieldAddComment.getText().strip())) {
							
							ViewSongApplication.addComment(currentSongID, currentLoggedIn.getCurrentUserID(), textFieldAddComment.getText().strip());
							JOptionPane.showMessageDialog(null, "Comment Successfully Uploaded", "Elenco - Upload Comment", JOptionPane.INFORMATION_MESSAGE,null);
							textFieldAddComment.setText("");;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No Comment Written To Upload", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
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
		txtLength.setEditable(false);
		txtLength.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtLength.setBounds(680, 160, 100, 25);
		contentPane.add(txtLength);
		txtLength.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setEditable(false);
		txtAlbum.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtAlbum.setBounds(355, 200, 200, 25);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setEditable(false);
		txtGenre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre.setBounds(680, 120, 100, 25);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtReleased = new JTextField();
		txtReleased.setEditable(false);
		txtReleased.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReleased.setBounds(680, 200, 100, 25);
		contentPane.add(txtReleased);
		txtReleased.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textArea.setBounds(270, 249, 510, 100);
		contentPane.add(textArea);
		
		JLabel lblMyRating = new JLabel("My Rating");
		lblMyRating.setFont(new Font("Georgia", Font.BOLD, 12));
		lblMyRating.setBounds(48, 270, 75, 25);
		lblMyRating.setForeground(new Color(90, 192, 217));
		contentPane.add(lblMyRating);
		
		btn = new JButton("Back");
		btn.setFont(new Font("Georgia", Font.PLAIN, 11));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiscoverScreen frame = new DiscoverScreen(currentLoggedIn);
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
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					// Create new instance of Icon using the given PNG file.
		Image appImage = appIcon.getImage();															// Create image of icon variable.
		Image appImageResize = appImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		appIcon = new ImageIcon(appImageResize);														// Set instance of Icon to the resized Image.
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(360, 2, 100, 100);
		contentPane.add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 393, 814, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername1 = new JTextField();
		txtUsername1.setEditable(false);
		txtUsername1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername1.setBounds(65, 10, 125, 25);
		panel.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		txtUsername2 = new JTextField();
		txtUsername2.setEditable(false);
		txtUsername2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername2.setBounds(65, 45, 125, 25);
		panel.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		txtUsername3 = new JTextField();
		txtUsername3.setEditable(false);
		txtUsername3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername3.setBounds(65, 80, 125, 25);
		panel.add(txtUsername3);
		txtUsername3.setColumns(10);
		
		txtUsername4 = new JTextField();
		txtUsername4.setEditable(false);
		txtUsername4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername4.setBounds(65, 115, 125, 25);
		panel.add(txtUsername4);
		txtUsername4.setColumns(10);
		
		txtUsername5 = new JTextField();
		txtUsername5.setEditable(false);
		txtUsername5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername5.setBounds(65, 150, 125, 25);
		panel.add(txtUsername5);
		txtUsername5.setColumns(10);
		
		txtComment1 = new JTextField();
		txtComment1.setEditable(false);
		txtComment1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment1.setBounds(200, 10, 500, 25);
		panel.add(txtComment1);
		txtComment1.setColumns(10);
		
		txtComment2 = new JTextField();
		txtComment2.setEditable(false);
		txtComment2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment2.setBounds(200, 45, 500, 25);
		panel.add(txtComment2);
		txtComment2.setColumns(10);
		
		txtPosted1 = new JTextField();
		txtPosted1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted1.setEditable(false);
		txtPosted1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted1.setBounds(708, 10, 100, 25);
		panel.add(txtPosted1);
		txtPosted1.setColumns(10);
		
		txtPosted2 = new JTextField();
		txtPosted2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted2.setEditable(false);
		txtPosted2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted2.setBounds(708, 45, 100, 25);
		panel.add(txtPosted2);
		txtPosted2.setColumns(10);
		
		txtComment3 = new JTextField();
		txtComment3.setEditable(false);
		txtComment3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment3.setColumns(10);
		txtComment3.setBounds(200, 80, 500, 25);
		panel.add(txtComment3);
		
		txtComment4 = new JTextField();
		txtComment4.setEditable(false);
		txtComment4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment4.setColumns(10);
		txtComment4.setBounds(200, 115, 500, 25);
		panel.add(txtComment4);
		
		txtComment5 = new JTextField();
		txtComment5.setEditable(false);
		txtComment5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtComment5.setColumns(10);
		txtComment5.setBounds(200, 150, 500, 25);
		panel.add(txtComment5);
		
		txtPosted3 = new JTextField();
		txtPosted3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted3.setEditable(false);
		txtPosted3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted3.setColumns(10);
		txtPosted3.setBounds(708, 80, 100, 25);
		panel.add(txtPosted3);
		
		txtPosted4 = new JTextField();
		txtPosted4.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted4.setEditable(false);
		txtPosted4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted4.setColumns(10);
		txtPosted4.setBounds(708, 115, 100, 25);
		panel.add(txtPosted4);
		
		txtPosted5 = new JTextField();
		txtPosted5.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosted5.setEditable(false);
		txtPosted5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPosted5.setColumns(10);
		txtPosted5.setBounds(708, 150, 100, 25);
		panel.add(txtPosted5);
		
		comboBoxRating = new JComboBox();
		comboBoxRating.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBoxRating.setModel(new DefaultComboBoxModel(new String[] {"Not Rated", "1", "2", "3", "4", "5"}));
		comboBoxRating.setBounds(148, 270, 100, 25);
		contentPane.add(comboBoxRating);
		
		JButton btnRate = new JButton("Update Rating");
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxRating.getSelectedItem().toString().equals("Not Rated"))
				{
					
			System.out.println(" No rating provided ");
			
				}
				else
				{
					
					ResultSet ratingValue = ViewSongApplication.myRating(currentSongID, currentLoggedIn.getCurrentUserID());
					try {
						
						if (ratingValue.next())
						{
							ViewSongApplication.updateRating(currentSongID, currentLoggedIn.getCurrentUserID(), comboBoxRating.getSelectedItem().toString());
							System.out.println("Up to here 1");
							
							
							
							
							
							
							ResultSet  getAllRatings = ViewSongApplication.getAllRatings(currentSongID);
							System.out.println("Up to here 2");
					
							int totalReviews = 0;
							double totalRatings = 0 ;
							double overallRating;
						
							
							while(getAllRatings.next()) {
							
								totalRatings = totalRatings + getAllRatings.getDouble("Rating");
								
								totalReviews++;
								}
							
							overallRating = (totalRatings/totalReviews);
							System.out.println("Total number of reviews: " + totalReviews + " Total ratings: "+ totalRatings+ " Overall Rating: "+overallRating);
						
		
							ViewSongApplication.updateTotals(currentSongID, overallRating, totalReviews);
							
							
						}
						else
						{
							ViewSongApplication.createRating(currentSongID, currentLoggedIn.getCurrentUserID(), comboBoxRating.getSelectedItem().toString());
						
							ResultSet  getTotals = ViewSongApplication.getAllRatings(currentSongID);
							System.out.println("Up to here 2");
					
							int totalReviews = 0;
							double totalRatings = 0 ;
							double overallRating;
						
							
							while(getTotals.next()) {
							
								totalRatings = totalRatings + getTotals.getDouble("Rating");
								
								totalReviews++;
								}
							
							overallRating = (totalRatings/totalReviews);
							System.out.println("Total number of reviews: " + totalReviews + " Total ratings: "+ totalRatings+ " Overall Rating: "+overallRating);
						
		
							ViewSongApplication.updateTotals(currentSongID, overallRating, totalReviews);
							
			
						}
						
					}
					catch(SQLException sql)
					{
						
					}
					
			
				}
			}
		});
		btnRate.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRate.setBounds(93, 310, 125, 25);
		contentPane.add(btnRate);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(48, 38, 200, 200);
		contentPane.add(lblNewLabel);
		
		lblNumber2 = new JLabel("Comments");
		lblNumber2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNumber2.setBounds(10, 365, 75, 25);
		lblNumber2.setForeground(new Color(90, 192, 217));
		contentPane.add(lblNumber2);
		
		btnPrevious = new JButton("Previous Page");
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
		txtPage.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setEditable(false);
		txtPage.setBounds(400, 590, 50, 25);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
		
		lblPage = new JLabel("Page");
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage.setForeground(new Color(90, 192, 217));
		lblPage.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPage.setBounds(400, 626, 50, 14);
		contentPane.add(lblPage);
	}
	
	
	
	public void loadComments(String currentSongID) {	
		
		txtPage.setText(String.valueOf(pageCount));
		
		if (sqlOffset > 4) {																											
			
			btnPrevious.setEnabled(true);
			
		}
		else 
		{																								
			
			btnPrevious.setEnabled(false);
		}
	
	ResultSet songComments  = ViewSongApplication.getComments(currentSongID, sqlOffset, sqlRowCount);


	String userName = null;
	String comment = null;
	String posted = null;
	int row = 1;

	
			
	try {
		
		while (songComments.next())																	
		{
			
			userName = songComments.getString("UserName");
			comment = songComments.getString("Comment");
			posted = songComments.getString("Posted");
			
	
	txtCommentCount.setText(String.valueOf(songComments.getRow()));
			
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
			
		//textFieldCount.setText(String.valueOf(count));
	
			
	/*
			private JPanel contentPane;
			private JTextField textFieldUserName;
			private JTextField textFieldArtist1;
			private JTextField textFieldArtist2;
			private JTextField textFieldArtist3;
			private JTextField textFieldGenre1;
			private JTextField textFieldGenre2;
			private JTextField textFieldGenre3;
			*/
			
		
			
		
		
		
	}
	catch (SQLException sqe)
	{
		
	}
	
	
}


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
}
