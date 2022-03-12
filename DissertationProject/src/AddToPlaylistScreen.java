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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AddToPlaylistScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtRating1;
	private JTextField txtReviews1;
	private JTextField txtUploaded1;
	private JTextField txtSongID1;
	private JTextField txtTitle2;
	private JTextField txtArtist2;
	private JTextField txtGenre2;
	private JTextField txtRating2;
	private JTextField txtReviews2;
	private JTextField txtUploaded2;
	private JTextField txtSongID2;
	private JButton btnBack;
	
	private JRadioButton rdbtnAscending;
	private JRadioButton rdbtnDescending;

	/**
	 * Launch the application.
	 */
	 
	 /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddToPlaylistScreen frame = new AddToPlaylistScreen();
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
	public AddToPlaylistScreen(String currentUserID, String currentUserName, String currentPlaylistTitle, int ranking) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ButtonGroup radioButtons = new ButtonGroup();
		
		
	
		
		rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setBounds(766, 105, 109, 23);
		contentPane.add(rdbtnAscending);
		
		rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setSelected(true);
		rdbtnDescending.setBounds(766, 144, 109, 23);
		contentPane.add(rdbtnDescending);
		
		radioButtons.add(rdbtnAscending);																							
		radioButtons.add(rdbtnDescending);	
		
		txtSearch = new JTextField();
		txtSearch.setBounds(61, 128, 96, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(44, 285, 96, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBounds(153, 285, 96, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBounds(284, 285, 96, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBounds(394, 285, 96, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtReviews1 = new JTextField();
		txtReviews1.setBounds(511, 285, 96, 20);
		contentPane.add(txtReviews1);
		txtReviews1.setColumns(10);
		
		txtUploaded1 = new JTextField();
		txtUploaded1.setBounds(619, 285, 96, 20);
		contentPane.add(txtUploaded1);
		txtUploaded1.setColumns(10);
		
		JButton btnAdd1 = new JButton("Add To Playlist");
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet checksong = AddToPlaylistApplication.songOnPlaylist(txtSongID1.getText(),currentUserID);
				
				try
				{
				if (checksong.next()){
					System.out.print("song already on list");
					}
				else
				{
					System.out.print("song not already on list");
					AddToPlaylistApplication.addSong(currentUserID, txtSongID1.getText() ,currentPlaylistTitle, ranking);
				}
				
				}
				catch (SQLException sqe )
				{
					
				}
				
				
			
				
				/*
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentUserID, currentUserName, currentPlaylistTitle);
				gui.setVisible(true);
				dispose();
				*/
			}
		});
		btnAdd1.setBounds(766, 284, 130, 23);
		contentPane.add(btnAdd1);
		
		JComboBox comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"Title\t", "Artist", "Genre"}));
		comboBoxCriteria.setBounds(259, 127, 149, 23);
		contentPane.add(comboBoxCriteria);
		
		JComboBox comboBoxSort = new JComboBox();
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"Rating", "Reviews", "Uploaded"}));
		comboBoxSort.setBounds(531, 127, 198, 23);
		contentPane.add(comboBoxSort);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String songID = null;
				String title = null;
				String artist = null;
				String genre = null;
				String rating = null;
				String reviews = null;
				String uploaded = null;
				String sortType = null;
				
				int row = 1;
				
				
				if (rdbtnAscending.isSelected()) {																											
					
					sortType = "ASC";	
					System.out.println("Ascending\n");
					
				}else if (rdbtnDescending.isSelected()) {																								
					
					sortType = "DESC";	
					System.out.println("Descending\n");
					
				}
				
				ResultSet searchAttempt = AddToPlaylistApplication.search(txtSearch.getText(), comboBoxCriteria.getSelectedItem(), comboBoxSort.getSelectedItem(), sortType);	
				
				
				try {
					
				while (searchAttempt.next())																	
					{
			
					songID = searchAttempt.getString("SongID");
						title = searchAttempt.getString("Title");
						artist = searchAttempt.getString("Artist");
						genre = searchAttempt.getString("Genre");
						rating = searchAttempt.getString("Rating");
						reviews = searchAttempt.getString("Reviews");
						uploaded = searchAttempt.getString("uploaded");
						
						
						switch (row) {
						case 1:
							txtSongID1.setText(songID);
							txtTitle1.setText(title);
							txtArtist1.setText(artist);
							txtGenre1.setText(genre);
							txtRating1.setText(rating);
							txtReviews1.setText(reviews);
							txtUploaded1.setText(uploaded);
							System.out.println(title+artist+genre);
							break;
						case 2:
							txtSongID2.setText(songID);
							txtTitle2.setText(title);
							txtArtist2.setText(artist);
							txtGenre2.setText(genre);
							txtRating2.setText(rating);
							txtReviews2.setText(reviews);
							txtUploaded2.setText(uploaded);
							System.out.println(title+artist+genre);
							break;
						case 3:
					
							break;
						case 4:
				
							break;
						case 5:
						
							break;
						case 6:
						
							break;
						case 7:
							
							break;
						case 8:
						
							break;
						case 9:
						
							break;
						case 10:
							
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
		});
		btnSearch.setBounds(394, 199, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(61, 249, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(182, 249, 48, 14);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(304, 249, 48, 14);
		contentPane.add(lblGenre);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(413, 249, 48, 14);
		contentPane.add(lblRating);
		
		JLabel lblReviews = new JLabel("Reviews");
		lblReviews.setBounds(531, 249, 48, 14);
		contentPane.add(lblReviews);
		
		JLabel lblUploaded = new JLabel("Uploaded");
		lblUploaded.setBounds(641, 249, 48, 14);
		contentPane.add(lblUploaded);
		
		txtSongID1 = new JTextField();
		txtSongID1.setBounds(723, 249, 96, 20);
		contentPane.add(txtSongID1);
		txtSongID1.setColumns(10);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBounds(44, 328, 96, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		txtArtist2 = new JTextField();
		txtArtist2.setBounds(153, 328, 96, 20);
		contentPane.add(txtArtist2);
		txtArtist2.setColumns(10);
		
		txtGenre2 = new JTextField();
		txtGenre2.setBounds(284, 328, 96, 20);
		contentPane.add(txtGenre2);
		txtGenre2.setColumns(10);
		
		txtRating2 = new JTextField();
		txtRating2.setBounds(394, 328, 96, 20);
		contentPane.add(txtRating2);
		txtRating2.setColumns(10);
		
		txtReviews2 = new JTextField();
		txtReviews2.setBounds(511, 328, 96, 20);
		contentPane.add(txtReviews2);
		txtReviews2.setColumns(10);
		
		txtUploaded2 = new JTextField();
		txtUploaded2.setBounds(619, 328, 96, 20);
		contentPane.add(txtUploaded2);
		txtUploaded2.setColumns(10);
		
		txtSongID2 = new JTextField();
		txtSongID2.setBounds(723, 309, 96, 20);
		contentPane.add(txtSongID2);
		txtSongID2.setColumns(10);
		
		JButton btnAdd2 = new JButton("Add To Playlist");
		btnAdd2.setBounds(829, 327, 89, 23);
		contentPane.add(btnAdd2);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentUserID, currentUserName, currentPlaylistTitle);
				gui.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(225, 540, 89, 23);
		contentPane.add(btnBack);
		
	
		
		
	}
}
