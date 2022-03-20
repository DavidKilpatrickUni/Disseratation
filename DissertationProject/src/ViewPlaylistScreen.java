import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class ViewPlaylistScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaylistTitle;
	private JTextField txtUsername;
	private JButton btnBack;
	private JLabel lblTitle;
	private JLabel lblArtist;
	private JLabel lblGenre;
	private JLabel lblRating;
	private JLabel lblViews;
	private JLabel lblUploaded;
	private JLabel lblPlaylistTitle;
	private JLabel lblUsername;
	private JTextField txtTitle1;
	private JTextField txtTitle3;
	private JTextField txtTitle4;
	private JTextField txtTitle5;
	private JTextField txtTitle6;
	private JTextField txtTitle7;
	private JTextField txtTitle2;
	private JTextField txtTitle8;
	private JTextField txtTitle9;
	private JTextField txtTitle10;
	private JTextField txtArtist1;
	private JTextField txtArtist2;
	private JTextField txtArtist3;
	private JTextField txtArtist4;
	private JTextField txtArtist5;
	private JTextField txtArtist6;
	private JTextField txtArtist7;
	private JTextField txtArtist8;
	private JTextField txtArtist9;
	private JTextField txtArtist10;
	private JTextField txtGenre1;
	private JTextField txtGenre2;
	private JTextField txtGenre3;
	private JTextField txtGenre4;
	private JTextField txtGenre5;
	private JTextField txtGenre6;
	private JTextField txtGenre7;
	private JTextField txtGenre8;
	private JTextField txtGenre9;
	private JTextField txtGenre10;
	private JTextField txtRating1;
	private JTextField txtRating2;
	private JTextField txtRating3;
	private JTextField txtRating4;
	private JTextField txtRating5;
	private JTextField txtRating6;
	private JTextField txtRating7;
	private JTextField txtRating8;
	private JTextField txtRating9;
	private JTextField txtRating10;
	private JTextField txtReviews1;
	private JTextField txtReviews2;
	private JTextField txtReviews3;
	private JTextField txtReviews4;
	private JTextField txtReviews5;
	private JTextField txtReviews6;
	private JTextField txtReviews7;
	private JTextField txtReviews8;
	private JTextField txtReviews9;
	private JTextField txtReviews10;
	private JTextField txtUploaded1;
	private JTextField txtUploaded2;
	private JTextField txtUploaded3;
	private JTextField txtUploaded4;
	private JTextField txtUploaded5;
	private JTextField txtUploaded6;
	private JTextField txtUploaded7;
	private JTextField txtUploaded8;
	private JTextField txtUploaded9;
	private JTextField txtUploaded10;
	private JLabel lblUserIcon;
	private JLabel lblElencoView;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPlaylistScreen frame = new ViewPlaylistScreen();
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
	
	
	public ViewPlaylistScreen(String playlistTitle, String IDOfUser, LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - View Playlist");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				
				ResultSet viewList = ViewPlaylistApplication.loadPlaylist(playlistTitle, IDOfUser);
				
				String playlistTitle = null;
				String playlistId = null;
				String title = null;
				String artist = null;
				String genre = null;
				String rating = null;
				String reviews = null;
				String uploaded =null;
				
				String ranking = null;
				
				
				try {
					
					
								
								while (viewList.next())																	
								{
								
									playlistTitle = viewList.getString("PlaylistTitle");
									txtPlaylistTitle.setText(playlistTitle);
						
									System.out.println(playlistTitle);
									
									playlistId = viewList.getString("playlistID");
									title = viewList.getString("Title");
									artist = viewList.getString("Artist");
									genre = viewList.getString("Genre");
									rating = viewList.getString("OverallRating");
									reviews =viewList.getString("TotalReviews");
									uploaded = viewList.getString("uploaded");
									
									
									ranking = viewList.getString("Ranking");
									
								
									
						
									 
									
									switch (ranking) {
									case "1":
								
							
										txtTitle1.setText(title);
										txtArtist1.setText(artist);
										txtGenre1.setText(genre);
										txtRating1.setText(rating);
										txtReviews1.setText(reviews);
										txtUploaded1.setText(uploaded);
										
										break;
									case "2":
						
										txtTitle2.setText(title);
										txtArtist2.setText(artist);
										txtGenre2.setText(genre);
										txtRating2.setText(rating);
										txtReviews2.setText(reviews);
										txtUploaded2.setText(uploaded);
										break;
									case "3":
										txtTitle3.setText(title);
										txtArtist3.setText(artist);
										txtGenre3.setText(genre);
										txtRating3.setText(rating);
										txtReviews3.setText(reviews);
										txtUploaded3.setText(uploaded);
										break;
									case "4":
										txtTitle4.setText(title);
										txtArtist4.setText(artist);
										txtGenre4.setText(genre);
										txtRating4.setText(rating);
										txtReviews4.setText(reviews);
										txtUploaded4.setText(uploaded);
										break;
									case "5":
										txtTitle5.setText(title);
										txtArtist5.setText(artist);
										txtGenre5.setText(genre);
										txtRating5.setText(rating);
										txtReviews5.setText(reviews);
										txtUploaded5.setText(uploaded);
										break;
									case "6":
										txtTitle6.setText(title);
										txtArtist6.setText(artist);
										txtGenre6.setText(genre);
										txtRating6.setText(rating);
										txtReviews6.setText(reviews);
										txtUploaded6.setText(uploaded);
										break;
									case "7":
										txtTitle7.setText(title);
										txtArtist7.setText(artist);
										txtGenre7.setText(genre);
										txtRating7.setText(rating);
										txtReviews7.setText(reviews);
										txtUploaded7.setText(uploaded);
										break;
									case "8":
										txtTitle8.setText(title);
										txtArtist8.setText(artist);
										txtGenre8.setText(genre);
										txtRating8.setText(rating);
										txtReviews8.setText(reviews);
										txtUploaded8.setText(uploaded);
										break;
									case "9":
										txtTitle9.setText(title);
										txtArtist9.setText(artist);
										txtGenre9.setText(genre);
										txtRating9.setText(rating);
										txtReviews9.setText(reviews);
										txtUploaded9.setText(uploaded);
										break;
									case "10":
										txtTitle10.setText(title);
										txtArtist10.setText(artist);
										txtGenre10.setText(genre);
										txtRating10.setText(rating);
										txtReviews10.setText(reviews);
										txtUploaded10.setText(uploaded);
										break;
									
									
									
									
									default:
										System.out.println("nothing matching search criteria\n");
									}
									
								}
				
								
							}
							catch (SQLException sqe)
							{
								
							}
							
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 665);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaylistTitle = new JTextField();
		txtPlaylistTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPlaylistTitle.setBounds(545, 140, 140, 25);
		contentPane.add(txtPlaylistTitle);
		txtPlaylistTitle.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername.setBounds(200, 140, 180, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchPlaylistScreen gui = new SearchPlaylistScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(365, 580, 100, 25);
		contentPane.add(btnBack);
		
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
		
		lblPlaylistTitle = new JLabel("Playlist Title");
		lblPlaylistTitle.setForeground(new Color(90, 192, 217));
		lblPlaylistTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPlaylistTitle.setBounds(430, 140, 100, 25);
		contentPane.add(lblPlaylistTitle);
		
		lblUsername = new JLabel("User Name");
		lblUsername.setForeground(new Color(90, 192, 217));
		lblUsername.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUsername.setBounds(110, 140, 100, 25);
		contentPane.add(lblUsername);
		
		txtTitle1 = new JTextField();
		txtTitle1.setColumns(10);
		txtTitle1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle1.setBounds(40, 220, 180, 20);
		contentPane.add(txtTitle1);
		
		txtTitle3 = new JTextField();
		txtTitle3.setColumns(10);
		txtTitle3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle3.setBounds(40, 280, 180, 20);
		contentPane.add(txtTitle3);
		
		txtTitle4 = new JTextField();
		txtTitle4.setColumns(10);
		txtTitle4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle4.setBounds(40, 310, 180, 20);
		contentPane.add(txtTitle4);
		
		txtTitle5 = new JTextField();
		txtTitle5.setColumns(10);
		txtTitle5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle5.setBounds(40, 340, 180, 20);
		contentPane.add(txtTitle5);
		
		txtTitle6 = new JTextField();
		txtTitle6.setColumns(10);
		txtTitle6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle6.setBounds(40, 370, 180, 20);
		contentPane.add(txtTitle6);
		
		txtTitle7 = new JTextField();
		txtTitle7.setColumns(10);
		txtTitle7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle7.setBounds(40, 400, 180, 20);
		contentPane.add(txtTitle7);
		
		txtTitle2 = new JTextField();
		txtTitle2.setColumns(10);
		txtTitle2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle2.setBounds(40, 250, 180, 20);
		contentPane.add(txtTitle2);
		
		txtTitle8 = new JTextField();
		txtTitle8.setColumns(10);
		txtTitle8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle8.setBounds(40, 430, 180, 20);
		contentPane.add(txtTitle8);
		
		txtTitle9 = new JTextField();
		txtTitle9.setColumns(10);
		txtTitle9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle9.setBounds(40, 460, 180, 20);
		contentPane.add(txtTitle9);
		
		txtTitle10 = new JTextField();
		txtTitle10.setColumns(10);
		txtTitle10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle10.setBounds(40, 490, 180, 20);
		contentPane.add(txtTitle10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setColumns(10);
		txtArtist1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist1.setBounds(250, 220, 150, 20);
		contentPane.add(txtArtist1);
		
		txtArtist2 = new JTextField();
		txtArtist2.setColumns(10);
		txtArtist2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist2.setBounds(250, 250, 150, 20);
		contentPane.add(txtArtist2);
		
		txtArtist3 = new JTextField();
		txtArtist3.setColumns(10);
		txtArtist3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist3.setBounds(250, 280, 150, 20);
		contentPane.add(txtArtist3);
		
		txtArtist4 = new JTextField();
		txtArtist4.setColumns(10);
		txtArtist4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist4.setBounds(250, 310, 150, 20);
		contentPane.add(txtArtist4);
		
		txtArtist5 = new JTextField();
		txtArtist5.setColumns(10);
		txtArtist5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist5.setBounds(250, 340, 150, 20);
		contentPane.add(txtArtist5);
		
		txtArtist6 = new JTextField();
		txtArtist6.setColumns(10);
		txtArtist6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist6.setBounds(250, 370, 150, 20);
		contentPane.add(txtArtist6);
		
		txtArtist7 = new JTextField();
		txtArtist7.setColumns(10);
		txtArtist7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist7.setBounds(250, 400, 150, 20);
		contentPane.add(txtArtist7);
		
		txtArtist8 = new JTextField();
		txtArtist8.setColumns(10);
		txtArtist8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist8.setBounds(250, 430, 150, 20);
		contentPane.add(txtArtist8);
		
		txtArtist9 = new JTextField();
		txtArtist9.setColumns(10);
		txtArtist9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist9.setBounds(250, 460, 150, 20);
		contentPane.add(txtArtist9);
		
		txtArtist10 = new JTextField();
		txtArtist10.setColumns(10);
		txtArtist10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist10.setBounds(250, 490, 150, 20);
		contentPane.add(txtArtist10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setColumns(10);
		txtGenre1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre1.setBounds(430, 220, 100, 20);
		contentPane.add(txtGenre1);
		
		txtGenre2 = new JTextField();
		txtGenre2.setColumns(10);
		txtGenre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre2.setBounds(430, 250, 100, 20);
		contentPane.add(txtGenre2);
		
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
		
		txtGenre5 = new JTextField();
		txtGenre5.setColumns(10);
		txtGenre5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre5.setBounds(430, 340, 100, 20);
		contentPane.add(txtGenre5);
		
		txtGenre6 = new JTextField();
		txtGenre6.setColumns(10);
		txtGenre6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre6.setBounds(430, 370, 100, 20);
		contentPane.add(txtGenre6);
		
		txtGenre7 = new JTextField();
		txtGenre7.setColumns(10);
		txtGenre7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre7.setBounds(430, 400, 100, 20);
		contentPane.add(txtGenre7);
		
		txtGenre8 = new JTextField();
		txtGenre8.setColumns(10);
		txtGenre8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre8.setBounds(430, 430, 100, 20);
		contentPane.add(txtGenre8);
		
		txtGenre9 = new JTextField();
		txtGenre9.setColumns(10);
		txtGenre9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre9.setBounds(430, 460, 100, 20);
		contentPane.add(txtGenre9);
		
		txtGenre10 = new JTextField();
		txtGenre10.setColumns(10);
		txtGenre10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre10.setBounds(430, 490, 100, 20);
		contentPane.add(txtGenre10);
		
		txtRating1 = new JTextField();
		txtRating1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating1.setColumns(10);
		txtRating1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating1.setBounds(565, 220, 50, 20);
		contentPane.add(txtRating1);
		
		txtRating2 = new JTextField();
		txtRating2.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating2.setColumns(10);
		txtRating2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating2.setBounds(565, 250, 50, 20);
		contentPane.add(txtRating2);
		
		txtRating3 = new JTextField();
		txtRating3.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating3.setColumns(10);
		txtRating3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating3.setBounds(565, 280, 50, 20);
		contentPane.add(txtRating3);
		
		txtRating4 = new JTextField();
		txtRating4.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating4.setColumns(10);
		txtRating4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating4.setBounds(565, 310, 50, 20);
		contentPane.add(txtRating4);
		
		txtRating5 = new JTextField();
		txtRating5.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating5.setColumns(10);
		txtRating5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating5.setBounds(565, 340, 50, 20);
		contentPane.add(txtRating5);
		
		txtRating6 = new JTextField();
		txtRating6.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating6.setColumns(10);
		txtRating6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating6.setBounds(565, 370, 50, 20);
		contentPane.add(txtRating6);
		
		txtRating7 = new JTextField();
		txtRating7.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating7.setColumns(10);
		txtRating7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating7.setBounds(565, 400, 50, 20);
		contentPane.add(txtRating7);
		
		txtRating8 = new JTextField();
		txtRating8.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating8.setColumns(10);
		txtRating8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating8.setBounds(565, 430, 50, 20);
		contentPane.add(txtRating8);
		
		txtRating9 = new JTextField();
		txtRating9.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating9.setColumns(10);
		txtRating9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating9.setBounds(565, 460, 50, 20);
		contentPane.add(txtRating9);
		
		txtRating10 = new JTextField();
		txtRating10.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating10.setColumns(10);
		txtRating10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating10.setBounds(565, 490, 50, 20);
		contentPane.add(txtRating10);
		
		txtReviews1 = new JTextField();
		txtReviews1.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews1.setColumns(10);
		txtReviews1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews1.setBounds(645, 220, 75, 20);
		contentPane.add(txtReviews1);
		
		txtReviews2 = new JTextField();
		txtReviews2.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews2.setColumns(10);
		txtReviews2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews2.setBounds(645, 250, 75, 20);
		contentPane.add(txtReviews2);
		
		txtReviews3 = new JTextField();
		txtReviews3.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews3.setColumns(10);
		txtReviews3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews3.setBounds(645, 280, 75, 20);
		contentPane.add(txtReviews3);
		
		txtReviews4 = new JTextField();
		txtReviews4.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews4.setColumns(10);
		txtReviews4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews4.setBounds(645, 310, 75, 20);
		contentPane.add(txtReviews4);
		
		txtReviews5 = new JTextField();
		txtReviews5.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews5.setColumns(10);
		txtReviews5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews5.setBounds(645, 340, 75, 20);
		contentPane.add(txtReviews5);
		
		txtReviews6 = new JTextField();
		txtReviews6.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews6.setColumns(10);
		txtReviews6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews6.setBounds(645, 370, 75, 20);
		contentPane.add(txtReviews6);
		
		txtReviews7 = new JTextField();
		txtReviews7.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews7.setColumns(10);
		txtReviews7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews7.setBounds(645, 400, 75, 20);
		contentPane.add(txtReviews7);
		
		txtReviews8 = new JTextField();
		txtReviews8.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews8.setColumns(10);
		txtReviews8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews8.setBounds(645, 430, 75, 20);
		contentPane.add(txtReviews8);
		
		txtReviews9 = new JTextField();
		txtReviews9.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews9.setColumns(10);
		txtReviews9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews9.setBounds(645, 460, 75, 20);
		contentPane.add(txtReviews9);
		
		txtReviews10 = new JTextField();
		txtReviews10.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviews10.setColumns(10);
		txtReviews10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtReviews10.setBounds(645, 490, 75, 20);
		contentPane.add(txtReviews10);
		
		txtUploaded1 = new JTextField();
		txtUploaded1.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded1.setColumns(10);
		txtUploaded1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded1.setBounds(750, 220, 100, 20);
		contentPane.add(txtUploaded1);
		
		txtUploaded2 = new JTextField();
		txtUploaded2.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded2.setColumns(10);
		txtUploaded2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded2.setBounds(750, 250, 100, 20);
		contentPane.add(txtUploaded2);
		
		txtUploaded3 = new JTextField();
		txtUploaded3.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded3.setColumns(10);
		txtUploaded3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded3.setBounds(750, 280, 100, 20);
		contentPane.add(txtUploaded3);
		
		txtUploaded4 = new JTextField();
		txtUploaded4.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded4.setColumns(10);
		txtUploaded4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded4.setBounds(750, 310, 100, 20);
		contentPane.add(txtUploaded4);
		
		txtUploaded5 = new JTextField();
		txtUploaded5.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded5.setColumns(10);
		txtUploaded5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded5.setBounds(750, 340, 100, 20);
		contentPane.add(txtUploaded5);
		
		txtUploaded6 = new JTextField();
		txtUploaded6.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded6.setColumns(10);
		txtUploaded6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded6.setBounds(750, 370, 100, 20);
		contentPane.add(txtUploaded6);
		
		txtUploaded7 = new JTextField();
		txtUploaded7.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded7.setColumns(10);
		txtUploaded7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded7.setBounds(750, 400, 100, 20);
		contentPane.add(txtUploaded7);
		
		txtUploaded8 = new JTextField();
		txtUploaded8.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded8.setColumns(10);
		txtUploaded8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded8.setBounds(750, 430, 100, 20);
		contentPane.add(txtUploaded8);
		
		txtUploaded9 = new JTextField();
		txtUploaded9.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded9.setColumns(10);
		txtUploaded9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded9.setBounds(750, 460, 100, 20);
		contentPane.add(txtUploaded9);
		
		txtUploaded10 = new JTextField();
		txtUploaded10.setHorizontalAlignment(SwingConstants.CENTER);
		txtUploaded10.setColumns(10);
		txtUploaded10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUploaded10.setBounds(750, 490, 100, 20);
		contentPane.add(txtUploaded10);
		
		
		ImageIcon userIcon =  new ImageIcon(ApplicationStartup.class.getResource("/ProfileIcon.PNG"));					// Create new instance of Icon using the given PNG file.
		Image userImage = userIcon.getImage();															// Create image of icon variable.
		Image userImageResize = userImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		userIcon = new ImageIcon(userImageResize);														// Set instance of Icon to the resized Image.
		
		lblUserIcon = new JLabel(userIcon);
		lblUserIcon.setBounds(40, 125, 50, 50);
		contentPane.add(lblUserIcon);
		
		lblElencoView = new JLabel("Elenco - View Playlist");
		lblElencoView.setHorizontalAlignment(SwingConstants.CENTER);
		lblElencoView.setForeground(new Color(90, 192, 217));
		lblElencoView.setFont(new Font("Georgia", Font.BOLD, 24));
		lblElencoView.setBounds(299, 44, 300, 25);
		contentPane.add(lblElencoView);
		
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					// Create new instance of Icon using the given PNG file.
		Image appImage = appIcon.getImage();															// Create image of icon variable.
		Image appImageResize = appImage.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		appIcon = new ImageIcon(appImageResize);														// Set instance of Icon to the resized Image.
		
		JLabel lblLogo = new JLabel(appIcon);
		lblLogo.setToolTipText("Elenco - Express Your Musical Opinion");
		lblLogo.setBounds(200, 11, 100, 100);
		contentPane.add(lblLogo);
		
	}

}
