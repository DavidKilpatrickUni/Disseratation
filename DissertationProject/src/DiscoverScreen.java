import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.PopupMenuListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.event.PopupMenuEvent;

public class DiscoverScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtRating1;
	private JTextField txtReviews1;
	private JTextField txtUploaded1;
	private JComboBox comboBoxCriteria;
	private JComboBox comboBoxSort;
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
	private JButton btnNextPage;
	private JButton btnPrevious;

	
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscoverScreen frame = new DiscoverScreen();
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
	public DiscoverScreen(String currentUserID, String currentUserName) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				clearScreen();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup radioButtons = new ButtonGroup();
		
		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setBounds(861, 31, 109, 23);
		contentPane.add(rdbtnAscending);
		
		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setSelected(true);
		rdbtnDescending.setBounds(861, 60, 109, 23);
		contentPane.add(rdbtnDescending);
		
		radioButtons.add(rdbtnAscending);																							
		radioButtons.add(rdbtnDescending);	
		
		txtSearch = new JTextField();
		txtSearch.setBounds(69, 60, 96, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(69, 180, 96, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBounds(213, 180, 96, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBounds(348, 180, 96, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBounds(476, 180, 96, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtReviews1 = new JTextField();
		txtReviews1.setBounds(614, 180, 96, 20);
		contentPane.add(txtReviews1);
		txtReviews1.setColumns(10);
		
		txtUploaded1 = new JTextField();
		txtUploaded1.setBounds(764, 180, 96, 20);
		contentPane.add(txtUploaded1);
		txtUploaded1.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(69, 142, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(225, 142, 48, 14);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(361, 142, 48, 14);
		contentPane.add(lblGenre);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(496, 142, 48, 14);
		contentPane.add(lblRating);
		
		JLabel lblViews = new JLabel("Reviews");
		lblViews.setBounds(630, 142, 48, 14);
		contentPane.add(lblViews);
		
		JLabel lblUploaded = new JLabel("Uploaded");
		lblUploaded.setBounds(778, 126, 48, 14);
		contentPane.add(lblUploaded);
		
		btnView1 = new JButton("View");
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID1.getText());
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnView1.setBounds(918, 179, 89, 23);
		contentPane.add(btnView1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clearScreen() ;
				
				String songID = null;
				String title = null;
				String artist = null;
				String genre = null;
	String rating = null;
				String uploaded = null;
				String reviews = null;
				String sortType = null;
				
				int row = 1;
				
			if (rdbtnAscending.isSelected()) {																											
					
					sortType = "ASC";	
					System.out.println("Ascending\n");
					
				}else if (rdbtnDescending.isSelected()) {																								
					
					sortType = "DESC";	
					System.out.println("Descending\n");
				}
				
				ResultSet searchAttempt = DiscoverApplication.search(comboBox.getSelectedItem().toString(), comboBoxCriteria.getSelectedItem(), comboBoxSort.getSelectedItem(), sortType);	
				
				
				try {
					
				while (searchAttempt.next())																	
					{
			
					songID = searchAttempt.getString("SongID");
						title = searchAttempt.getString("Title");
						artist = searchAttempt.getString("Artist");
						genre = searchAttempt.getString("Genre");
					rating = searchAttempt.getString("OverallRating");
					reviews = searchAttempt.getString("TotalReviews");
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
							btnNextPage.setEnabled(true);
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
		btnSearch.setBounds(389, 92, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblSearchFor = new JLabel("Search For");
		lblSearchFor.setBounds(69, 35, 110, 14);
		contentPane.add(lblSearchFor);
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setBounds(379, 35, 48, 14);
		contentPane.add(lblSearchBy);
		
		JLabel lblSortBy = new JLabel("Sort By");
		lblSortBy.setBounds(710, 35, 48, 14);
		contentPane.add(lblSortBy);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"Title", "Artist", "Genre"}));
		comboBoxCriteria.setBounds(379, 59, 120, 22);
		contentPane.add(comboBoxCriteria);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"OverallRating", "TotalReviews", "Uploaded"}));
		comboBoxSort.setBounds(696, 59, 110, 22);
		contentPane.add(comboBoxSort);
		
		txtTitle2 = new JTextField();
		txtTitle2.setColumns(10);
		txtTitle2.setBounds(69, 211, 96, 20);
		contentPane.add(txtTitle2);
		
		txtArtist2 = new JTextField();
		txtArtist2.setColumns(10);
		txtArtist2.setBounds(213, 211, 96, 20);
		contentPane.add(txtArtist2);
		
		txtGenre2 = new JTextField();
		txtGenre2.setColumns(10);
		txtGenre2.setBounds(348, 211, 96, 20);
		contentPane.add(txtGenre2);
		
		txtRating2 = new JTextField();
		txtRating2.setColumns(10);
		txtRating2.setBounds(476, 211, 96, 20);
		contentPane.add(txtRating2);
		
		txtReviews2 = new JTextField();
		txtReviews2.setColumns(10);
		txtReviews2.setBounds(614, 211, 96, 20);
		contentPane.add(txtReviews2);
		
		txtUploaded2 = new JTextField();
		txtUploaded2.setColumns(10);
		txtUploaded2.setBounds(764, 211, 96, 20);
		contentPane.add(txtUploaded2);
		
	
		
		txtSongID1 = new JTextField();
		txtSongID1.setBounds(885, 180, 23, 20);
		contentPane.add(txtSongID1);
		txtSongID1.setColumns(10);
		
		txtTitle3 = new JTextField();
		txtTitle3.setBounds(69, 242, 96, 20);
		contentPane.add(txtTitle3);
		txtTitle3.setColumns(10);
		
		txtTitle4 = new JTextField();
		txtTitle4.setBounds(69, 273, 96, 20);
		contentPane.add(txtTitle4);
		txtTitle4.setColumns(10);
		
		txtTitle5 = new JTextField();
		txtTitle5.setBounds(69, 312, 96, 20);
		contentPane.add(txtTitle5);
		txtTitle5.setColumns(10);
		
		txtTitle6 = new JTextField();
		txtTitle6.setBounds(69, 343, 96, 20);
		contentPane.add(txtTitle6);
		txtTitle6.setColumns(10);
		
		txtTitle7 = new JTextField();
		txtTitle7.setBounds(69, 374, 96, 20);
		contentPane.add(txtTitle7);
		txtTitle7.setColumns(10);
		
		txtTitle8 = new JTextField();
		txtTitle8.setBounds(69, 409, 96, 20);
		contentPane.add(txtTitle8);
		txtTitle8.setColumns(10);
		
		txtTitle9 = new JTextField();
		txtTitle9.setBounds(69, 440, 96, 20);
		contentPane.add(txtTitle9);
		txtTitle9.setColumns(10);
		
		txtTitle10 = new JTextField();
		txtTitle10.setBounds(69, 482, 96, 20);
		contentPane.add(txtTitle10);
		txtTitle10.setColumns(10);
		
		txtArtist3 = new JTextField();
		txtArtist3.setBounds(213, 242, 96, 20);
		contentPane.add(txtArtist3);
		txtArtist3.setColumns(10);
		
		txtArtist4 = new JTextField();
		txtArtist4.setBounds(213, 273, 96, 20);
		contentPane.add(txtArtist4);
		txtArtist4.setColumns(10);
		
		txtArtist5 = new JTextField();
		txtArtist5.setBounds(213, 312, 96, 20);
		contentPane.add(txtArtist5);
		txtArtist5.setColumns(10);
		
		txtArtist6 = new JTextField();
		txtArtist6.setBounds(213, 343, 96, 20);
		contentPane.add(txtArtist6);
		txtArtist6.setColumns(10);
		
		txtArtist7 = new JTextField();
		txtArtist7.setBounds(213, 374, 96, 20);
		contentPane.add(txtArtist7);
		txtArtist7.setColumns(10);
		
		txtArtist8 = new JTextField();
		txtArtist8.setBounds(213, 409, 96, 20);
		contentPane.add(txtArtist8);
		txtArtist8.setColumns(10);
		
		txtArtist9 = new JTextField();
		txtArtist9.setBounds(213, 440, 96, 20);
		contentPane.add(txtArtist9);
		txtArtist9.setColumns(10);
		
		txtArtist10 = new JTextField();
		txtArtist10.setBounds(213, 482, 96, 20);
		contentPane.add(txtArtist10);
		txtArtist10.setColumns(10);
		
		txtGenre3 = new JTextField();
		txtGenre3.setBounds(348, 242, 96, 20);
		contentPane.add(txtGenre3);
		txtGenre3.setColumns(10);
		
		txtGenre4 = new JTextField();
		txtGenre4.setColumns(10);
		txtGenre4.setBounds(348, 273, 96, 20);
		contentPane.add(txtGenre4);
		
		txtGenre5 = new JTextField();
		txtGenre5.setColumns(10);
		txtGenre5.setBounds(348, 312, 96, 20);
		contentPane.add(txtGenre5);
		
		txtGenre6 = new JTextField();
		txtGenre6.setColumns(10);
		txtGenre6.setBounds(348, 343, 96, 20);
		contentPane.add(txtGenre6);
		
		txtGenre7 = new JTextField();
		txtGenre7.setColumns(10);
		txtGenre7.setBounds(348, 374, 96, 20);
		contentPane.add(txtGenre7);
		
		txtGenre8 = new JTextField();
		txtGenre8.setColumns(10);
		txtGenre8.setBounds(348, 409, 96, 20);
		contentPane.add(txtGenre8);
		
		txtGenre9 = new JTextField();
		txtGenre9.setColumns(10);
		txtGenre9.setBounds(348, 440, 96, 20);
		contentPane.add(txtGenre9);
		
		txtGenre10 = new JTextField();
		txtGenre10.setColumns(10);
		txtGenre10.setBounds(348, 482, 96, 20);
		contentPane.add(txtGenre10);
		
		txtRating4 = new JTextField();
		txtRating4.setColumns(10);
		txtRating4.setBounds(476, 273, 96, 20);
		contentPane.add(txtRating4);
		
		txtRating5 = new JTextField();
		txtRating5.setColumns(10);
		txtRating5.setBounds(476, 312, 96, 20);
		contentPane.add(txtRating5);
		
		txtRating6 = new JTextField();
		txtRating6.setColumns(10);
		txtRating6.setBounds(476, 343, 96, 20);
		contentPane.add(txtRating6);
		
		txtRating7 = new JTextField();
		txtRating7.setColumns(10);
		txtRating7.setBounds(476, 374, 96, 20);
		contentPane.add(txtRating7);
		
		txtRating8 = new JTextField();
		txtRating8.setColumns(10);
		txtRating8.setBounds(476, 409, 96, 20);
		contentPane.add(txtRating8);
		
		txtRating9 = new JTextField();
		txtRating9.setColumns(10);
		txtRating9.setBounds(476, 440, 96, 20);
		contentPane.add(txtRating9);
		
		txtRating10 = new JTextField();
		txtRating10.setColumns(10);
		txtRating10.setBounds(476, 482, 96, 20);
		contentPane.add(txtRating10);
		
		txtReviews4 = new JTextField();
		txtReviews4.setColumns(10);
		txtReviews4.setBounds(614, 273, 96, 20);
		contentPane.add(txtReviews4);
		
		txtReviews5 = new JTextField();
		txtReviews5.setColumns(10);
		txtReviews5.setBounds(614, 312, 96, 20);
		contentPane.add(txtReviews5);
		
		txtReviews6 = new JTextField();
		txtReviews6.setColumns(10);
		txtReviews6.setBounds(614, 343, 96, 20);
		contentPane.add(txtReviews6);
		
		txtReviews7 = new JTextField();
		txtReviews7.setColumns(10);
		txtReviews7.setBounds(614, 374, 96, 20);
		contentPane.add(txtReviews7);
		
		txtReviews8 = new JTextField();
		txtReviews8.setColumns(10);
		txtReviews8.setBounds(614, 409, 96, 20);
		contentPane.add(txtReviews8);
		
		txtReviews9 = new JTextField();
		txtReviews9.setColumns(10);
		txtReviews9.setBounds(614, 440, 96, 20);
		contentPane.add(txtReviews9);
		
		txtReviews10 = new JTextField();
		txtReviews10.setColumns(10);
		txtReviews10.setBounds(614, 482, 96, 20);
		contentPane.add(txtReviews10);
		
		txtUploaded4 = new JTextField();
		txtUploaded4.setColumns(10);
		txtUploaded4.setBounds(764, 273, 96, 20);
		contentPane.add(txtUploaded4);
		
		txtUploaded5 = new JTextField();
		txtUploaded5.setColumns(10);
		txtUploaded5.setBounds(764, 312, 96, 20);
		contentPane.add(txtUploaded5);
		
		txtUploaded6 = new JTextField();
		txtUploaded6.setColumns(10);
		txtUploaded6.setBounds(764, 343, 96, 20);
		contentPane.add(txtUploaded6);
		
		txtUploaded7 = new JTextField();
		txtUploaded7.setColumns(10);
		txtUploaded7.setBounds(764, 374, 96, 20);
		contentPane.add(txtUploaded7);
		
		txtUploaded8 = new JTextField();
		txtUploaded8.setColumns(10);
		txtUploaded8.setBounds(764, 409, 96, 20);
		contentPane.add(txtUploaded8);
		
		txtUploaded9 = new JTextField();
		txtUploaded9.setColumns(10);
		txtUploaded9.setBounds(764, 440, 96, 20);
		contentPane.add(txtUploaded9);
		
		txtUploaded10 = new JTextField();
		txtUploaded10.setColumns(10);
		txtUploaded10.setBounds(764, 482, 96, 20);
		contentPane.add(txtUploaded10);
		
		txtSongID4 = new JTextField();
		txtSongID4.setColumns(10);
		txtSongID4.setBounds(874, 273, 31, 20);
		contentPane.add(txtSongID4);
		
		txtSongID5 = new JTextField();
		txtSongID5.setColumns(10);
		txtSongID5.setBounds(874, 312, 31, 20);
		contentPane.add(txtSongID5);
		
		txtSongID6 = new JTextField();
		txtSongID6.setColumns(10);
		txtSongID6.setBounds(874, 343, 31, 20);
		contentPane.add(txtSongID6);
		
		txtSongID7 = new JTextField();
		txtSongID7.setColumns(10);
		txtSongID7.setBounds(874, 374, 31, 20);
		contentPane.add(txtSongID7);
		
		txtSongID8 = new JTextField();
		txtSongID8.setColumns(10);
		txtSongID8.setBounds(874, 409, 31, 20);
		contentPane.add(txtSongID8);
		
		txtSongID9 = new JTextField();
		txtSongID9.setColumns(10);
		txtSongID9.setBounds(874, 440, 31, 20);
		contentPane.add(txtSongID9);
		
		txtSongID10 = new JTextField();
		txtSongID10.setColumns(10);
		txtSongID10.setBounds(874, 482, 31, 20);
		contentPane.add(txtSongID10);
		
		txtRating3 = new JTextField();
		txtRating3.setBounds(476, 242, 96, 20);
		contentPane.add(txtRating3);
		txtRating3.setColumns(10);
		
		txtReviews3 = new JTextField();
		txtReviews3.setBounds(614, 242, 96, 20);
		contentPane.add(txtReviews3);
		txtReviews3.setColumns(10);
		
		txtUploaded3 = new JTextField();
		txtUploaded3.setBounds(764, 242, 96, 20);
		contentPane.add(txtUploaded3);
		txtUploaded3.setColumns(10);
		
		txtSongID2 = new JTextField();
		txtSongID2.setColumns(10);
		txtSongID2.setBounds(870, 211, 23, 20);
		contentPane.add(txtSongID2);
		
		txtSongID3 = new JTextField();
		txtSongID3.setColumns(10);
		txtSongID3.setBounds(874, 242, 23, 20);
		contentPane.add(txtSongID3);
		
		btnView2 = new JButton("View");
		btnView2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID2.getText());
				frame.setVisible(true);
				//dispose();
			}
		});
		btnView2.setBounds(918, 210, 89, 23);
		contentPane.add(btnView2);
		
		btnView3 = new JButton("View");
		btnView3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID3.getText());
				frame.setVisible(true);
				//dispose();
			}
		});
		btnView3.setBounds(918, 241, 89, 23);
		contentPane.add(btnView3);
		
		btnView4 = new JButton("View");
		btnView4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID4.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView4.setBounds(918, 272, 89, 23);
		contentPane.add(btnView4);
		
		btnView5 = new JButton("View");
		btnView5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID5.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView5.setBounds(918, 311, 89, 23);
		contentPane.add(btnView5);
		
		btnView6 = new JButton("View");
		btnView6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID6.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView6.setBounds(918, 342, 89, 23);
		contentPane.add(btnView6);
		
		btnView7 = new JButton("View");
		btnView7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID7.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView7.setBounds(918, 373, 89, 23);
		contentPane.add(btnView7);
		
		btnView8 = new JButton("View");
		btnView8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID8.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView8.setBounds(918, 408, 89, 23);
		contentPane.add(btnView8);
		
		btnView9 = new JButton("View");
		btnView9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID9.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView9.setBounds(918, 439, 89, 23);
		contentPane.add(btnView9);
		
		btnView10 = new JButton("View");
		btnView10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, txtSongID10.getText());
				frame.setVisible(true);
				dispose();
			}
		});
		btnView10.setBounds(918, 481, 89, 23);
		contentPane.add(btnView10);
		
		btnNextPage = new JButton("Next Page");
		btnNextPage.setBounds(483, 516, 89, 23);
		contentPane.add(btnNextPage);
		
		btnPrevious = new JButton("Previous Page");
		btnPrevious.setBounds(305, 516, 145, 23);
		contentPane.add(btnPrevious);
		
	comboBox = new JComboBox();

comboBox.setMaximumRowCount(4);
	comboBox.setEditable(true);
	AutoCompleteDecorator.decorate(comboBox);
	
	
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
				
				
				
				
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
		
				
				
			
			}
			
			
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	

				comboBox.removeAllItems();
				try
				{
					
					String sortType = "ASC";
					
					Class.forName("com.mysql.cj.jdbc.Driver");																	
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Dissertation ?user=root&password=");	
					Statement statement = conn.createStatement();
					System.out.println("SELECT * FROM songs GROUP BY "+ comboBoxCriteria.getSelectedItem().toString() + " ORDER BY " + comboBoxSort.getSelectedItem().toString() + " " + sortType + ", " + comboBoxCriteria.getSelectedItem().toString() +  " " + sortType);	
					String query = "SELECT * FROM songs GROUP BY " + comboBoxCriteria.getSelectedItem().toString() + " ORDER BY " + comboBoxSort.getSelectedItem().toString() + " " + sortType + ", " + comboBoxCriteria.getSelectedItem().toString() + " " + sortType;		
					
					//System.out.println("SELECT songs.*, ratings.* FROM songs inner join ratings on songs.songID = ratings.songID GROUP BY songs.songID ORDER BY " + sort + " " + sortType );	
					//String query = "SELECT songs.*, ratings.* FROM songs inner join ratings on songs.songID = ratings.songID GROUP BY songs.songID ORDER BY " + sort + " " + sortType;
					System.out.println(query);
					ResultSet results = statement.executeQuery(query);															
					System.out.println("this here " + results);
				

				
					while (results.next())
					{
						comboBox.addItem(results.getString(comboBoxCriteria.getSelectedItem().toString()));
					}
				
		
				}

				catch (ClassNotFoundException cnf)
				{	
					System.err.println("Could not load driver");
					System.err.println(cnf.getMessage());
					System.exit(-1);	
				}
			
				catch (SQLException sqe)
				{
					System.out.println("Error performing SQL Query");
					System.out.println(sqe.getMessage());
					System.exit(-1);
				}
				
			}
		});
		comboBox.setBounds(69, 91, 127, 23);
		contentPane.add(comboBox);
	}
	
	
	public void clearScreen() {
		

		btnNextPage.setEnabled(false);
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
