import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class DiscoverScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JTextField textFieldTitle1;
	private JTextField textFieldArtist1;
	private JTextField textFieldGenre1;
	private JTextField textFieldRating1;
	private JTextField textFieldViews1;
	private JTextField textFieldUploaded1;
	private JComboBox comboBoxCriteria;
	private JComboBox comboBoxSort;
	private JTextField textFieldTitle2;
	private JTextField textFieldArtist2;
	private JTextField textFieldGenre2;
	private JTextField textFieldRating2;
	private JTextField textFieldViews2;
	private JTextField textFieldUploaded2;
	private JTextField textFieldSongID1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(135, 137, 96, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		textFieldTitle1 = new JTextField();
		textFieldTitle1.setBounds(103, 275, 96, 20);
		contentPane.add(textFieldTitle1);
		textFieldTitle1.setColumns(10);
		
		textFieldArtist1 = new JTextField();
		textFieldArtist1.setBounds(235, 275, 96, 20);
		contentPane.add(textFieldArtist1);
		textFieldArtist1.setColumns(10);
		
		textFieldGenre1 = new JTextField();
		textFieldGenre1.setBounds(361, 275, 96, 20);
		contentPane.add(textFieldGenre1);
		textFieldGenre1.setColumns(10);
		
		textFieldRating1 = new JTextField();
		textFieldRating1.setBounds(496, 275, 96, 20);
		contentPane.add(textFieldRating1);
		textFieldRating1.setColumns(10);
		
		textFieldViews1 = new JTextField();
		textFieldViews1.setBounds(655, 275, 96, 20);
		contentPane.add(textFieldViews1);
		textFieldViews1.setColumns(10);
		
		textFieldUploaded1 = new JTextField();
		textFieldUploaded1.setBounds(789, 275, 96, 20);
		contentPane.add(textFieldUploaded1);
		textFieldUploaded1.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(135, 225, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(257, 225, 48, 14);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(379, 225, 48, 14);
		contentPane.add(lblGenre);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(527, 225, 48, 14);
		contentPane.add(lblRating);
		
		JLabel lblViews = new JLabel("Reviews");
		lblViews.setBounds(676, 225, 48, 14);
		contentPane.add(lblViews);
		
		JLabel lblUploaded = new JLabel("Uploaded");
		lblUploaded.setBounds(810, 225, 48, 14);
		contentPane.add(lblUploaded);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ViewSongScreen frame = new ViewSongScreen(currentUserID, currentUserName, textFieldSongID1.getText());
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnView.setBounds(925, 274, 89, 23);
		contentPane.add(btnView);
		
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
				
				int row = 1;
				
				ResultSet searchAttempt = DiscoverApplication.search(textFieldSearch.getText(), comboBoxCriteria.getSelectedItem(), comboBoxSort.getSelectedItem());	
				
				
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
							textFieldSongID1.setText(songID);
							textFieldTitle1.setText(title);
							textFieldArtist1.setText(artist);
							textFieldGenre1.setText(genre);
							textFieldRating1.setText(rating);
							textFieldViews1.setText(reviews);
							textFieldUploaded1.setText(uploaded);
							System.out.println(title+artist+genre);
							break;
						case 2:
							textFieldTitle2.setText(title);
							textFieldArtist2.setText(artist);
							textFieldGenre2.setText(genre);
							textFieldRating2.setText(rating);
							textFieldViews2.setText(reviews);
							textFieldUploaded2.setText(uploaded);
							break;
						case 3:
							textFieldTitle1.setText(title);
							textFieldArtist1.setText(artist);
							textFieldGenre1.setText(genre);
							break;
						case 4:
							textFieldTitle2.setText(title);
							textFieldArtist2.setText(artist);
							textFieldGenre2.setText(genre);
							break;
						case 5:
							textFieldTitle1.setText(title);
							textFieldArtist1.setText(artist);
							textFieldGenre1.setText(genre);
							break;
						case 6:
							textFieldTitle2.setText(title);
							textFieldArtist2.setText(artist);
							textFieldGenre2.setText(genre);
							break;
						case 7:
							textFieldTitle1.setText(title);
							textFieldArtist1.setText(artist);
							textFieldGenre1.setText(genre);
							break;
						case 8:
							textFieldTitle2.setText(title);
							textFieldArtist2.setText(artist);
							textFieldGenre2.setText(genre);
							break;
						case 9:
							textFieldTitle1.setText(title);
							textFieldArtist1.setText(artist);
							textFieldGenre1.setText(genre);
							break;
						case 10:
							textFieldTitle2.setText(title);
							textFieldArtist2.setText(artist);
							textFieldGenre2.setText(genre);
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
		btnSearch.setBounds(428, 180, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblSearchFor = new JLabel("Search For");
		lblSearchFor.setBounds(121, 109, 110, 14);
		contentPane.add(lblSearchFor);
		
		JLabel lblSearchBy = new JLabel("Search By");
		lblSearchBy.setBounds(412, 109, 48, 14);
		contentPane.add(lblSearchBy);
		
		JLabel lblSortBy = new JLabel("Sort By");
		lblSortBy.setBounds(737, 109, 48, 14);
		contentPane.add(lblSortBy);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"Title", "Artist", "Genre"}));
		comboBoxCriteria.setBounds(412, 136, 120, 22);
		contentPane.add(comboBoxCriteria);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"Rating", "Reviews", "Uploaded"}));
		comboBoxSort.setBounds(710, 136, 110, 22);
		contentPane.add(comboBoxSort);
		
		textFieldTitle2 = new JTextField();
		textFieldTitle2.setColumns(10);
		textFieldTitle2.setBounds(103, 333, 96, 20);
		contentPane.add(textFieldTitle2);
		
		textFieldArtist2 = new JTextField();
		textFieldArtist2.setColumns(10);
		textFieldArtist2.setBounds(235, 333, 96, 20);
		contentPane.add(textFieldArtist2);
		
		textFieldGenre2 = new JTextField();
		textFieldGenre2.setColumns(10);
		textFieldGenre2.setBounds(361, 333, 96, 20);
		contentPane.add(textFieldGenre2);
		
		textFieldRating2 = new JTextField();
		textFieldRating2.setColumns(10);
		textFieldRating2.setBounds(496, 333, 96, 20);
		contentPane.add(textFieldRating2);
		
		textFieldViews2 = new JTextField();
		textFieldViews2.setColumns(10);
		textFieldViews2.setBounds(655, 333, 96, 20);
		contentPane.add(textFieldViews2);
		
		textFieldUploaded2 = new JTextField();
		textFieldUploaded2.setColumns(10);
		textFieldUploaded2.setBounds(789, 333, 96, 20);
		contentPane.add(textFieldUploaded2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Acending");
		rdbtnNewRadioButton.setBounds(861, 136, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Decending");
		rdbtnNewRadioButton_1.setBounds(861, 162, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		textFieldSongID1 = new JTextField();
		textFieldSongID1.setBounds(918, 243, 96, 20);
		contentPane.add(textFieldSongID1);
		textFieldSongID1.setColumns(10);
	}
}
