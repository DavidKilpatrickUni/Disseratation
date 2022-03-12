import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ManagePlaylistScreen extends JFrame {

	private JPanel contentPane;
	private static JTextField txtPlaylistTitle;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtTitle2;
	private JTextField txtArtist2;
	private JTextField txtGenre2;
	private JButton btnRemove1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField txtRating1;
	private JTextField txtRating2;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField txtID1;
	private JButton btnAdd1;
	private JButton btnAdd2;
	private JButton btnRemove2;
	private JTextField txtID2;
	private JTextField txtSwap1;
	private JTextField txtSwap2;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagePlaylistScreen frame = new ManagePlaylistScreen();
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
	public ManagePlaylistScreen(String currentUserID, String currentUserName, String currentPlaylistTitle) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				refreshScreen(currentPlaylistTitle);
				/*
				ResultSet currentList = ManagePlaylistApplication.loadPlaylist(currentPlaylistTitle);
				
				String playlistTitle = null;
				String playlistId = null;
				String title = null;
				String artist = null;
				String genre = null;
				String rating = null;
				String ranking = null;
				
				
				try {
					
					
								
								while (currentList.next())																	
								{
								
									playlistTitle = currentList.getString("PlaylistTitle");
									txtPlaylistTitle.setText(playlistTitle);
									
									System.out.println(playlistTitle);
									
									playlistId = currentList.getString("playlistID");
									title = currentList.getString("Title");
									artist = currentList.getString("Artist");
									genre = currentList.getString("Genre");
									rating = currentList.getString("Rating");
									ranking = currentList.getString("Ranking");
									
									//
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
									 //
									
									switch (ranking) {
									case "1":
										System.out.println("id: " + playlistId);
										txtID1.setText(playlistId);
										txtTitle1.setText(title);
										txtArtist1.setText(artist);
										txtGenre1.setText(genre);
										txtRating1.setText(artist);
										btnAdd1.setEnabled(false);
										btnRemove1.setEnabled(true);
										break;
									case "2":
										System.out.println("id: " + playlistId);
										txtID2.setText(playlistId);
										txtTitle2.setText(title);
										txtArtist2.setText(artist);
										txtGenre2.setText(genre);
										txtRating2.setText(artist);
										break;
									case "3":
								
										break;
									case "4":
								
										break;
									case "5":
									
										break;
									case "6":
								
										break;
									case "7":
								
										break;
									case "8":
									
										break;
									case "9":
							
										break;
									case "10":
									
										break;
									
									
									
									
									default:
										System.out.println("nothing matching search criteria\n");
									}
									
								}
				
								
							}
							catch (SQLException sqe)
							{
								
							}
							*/
				
			}
	
	
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaylistTitle = new JTextField();
		txtPlaylistTitle.setBounds(326, 65, 96, 20);
		contentPane.add(txtPlaylistTitle);
		txtPlaylistTitle.setColumns(10);
		
		JLabel lblPlaylistTitle = new JLabel("Playlist Title");
		lblPlaylistTitle.setBounds(215, 68, 82, 14);
		contentPane.add(lblPlaylistTitle);
		
		JLabel label1 = new JLabel("1");
		label1.setBounds(21, 141, 48, 14);
		contentPane.add(label1);
		
		JLabel label_1 = new JLabel("10");
		label_1.setBounds(21, 539, 48, 14);
		contentPane.add(label_1);
		
		JLabel label2 = new JLabel("2");
		label2.setBounds(21, 183, 48, 14);
		contentPane.add(label2);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(253, 143, 96, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBounds(373, 143, 96, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBounds(499, 143, 96, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		btnAdd1 = new JButton("Add");
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentUserID, currentUserName, txtPlaylistTitle.getText(), 1);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd1.setBounds(777, 142, 62, 23);
		contentPane.add(btnAdd1);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBounds(253, 185, 96, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		txtArtist2 = new JTextField();
		txtArtist2.setBounds(373, 185, 96, 20);
		contentPane.add(txtArtist2);
		txtArtist2.setColumns(10);
		
		txtGenre2 = new JTextField();
		txtGenre2.setBounds(499, 185, 96, 20);
		contentPane.add(txtGenre2);
		txtGenre2.setColumns(10);
		
		JButton btnRename = new JButton("Rename");
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagePlaylistApplication.updatePlaylistTitle(currentUserID, currentPlaylistTitle, txtPlaylistTitle.getText());
				
			}
		});
		btnRename.setBounds(484, 64, 89, 23);
		contentPane.add(btnRename);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyPlaylistsScreen frame = new MyPlaylistsScreen(currentUserID, currentUserName);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(473, 593, 89, 23);
		contentPane.add(btnBack);
		
		btnRemove1 = new JButton("Remove");
		btnRemove1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagePlaylistApplication.removeFromList(currentUserID, txtID1.getText());
				refreshScreen(currentPlaylistTitle) ;
			}
		});
		btnRemove1.setBounds(868, 142, 89, 23);
		contentPane.add(btnRemove1);
		
		textField = new JTextField();
		textField.setBounds(253, 224, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(373, 224, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(499, 224, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(79, 272, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(199, 272, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(325, 272, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(79, 320, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(199, 320, 96, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(325, 320, 96, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(79, 370, 96, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(199, 370, 96, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(325, 370, 96, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(79, 421, 96, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(79, 463, 96, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(79, 500, 96, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(79, 536, 96, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(199, 421, 96, 20);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(199, 463, 96, 20);
		contentPane.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(199, 500, 96, 20);
		contentPane.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(199, 536, 96, 20);
		contentPane.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(325, 421, 96, 20);
		contentPane.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(325, 463, 96, 20);
		contentPane.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(325, 500, 96, 20);
		contentPane.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(325, 536, 96, 20);
		contentPane.add(textField_23);
		textField_23.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBounds(616, 143, 96, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtRating2 = new JTextField();
		txtRating2.setBounds(616, 185, 96, 20);
		contentPane.add(txtRating2);
		txtRating2.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setBounds(616, 224, 96, 20);
		contentPane.add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setBounds(442, 272, 96, 20);
		contentPane.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setBounds(442, 320, 96, 20);
		contentPane.add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(442, 370, 96, 20);
		contentPane.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(442, 421, 96, 20);
		contentPane.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setBounds(453, 463, 96, 20);
		contentPane.add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setBounds(442, 500, 96, 20);
		contentPane.add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setBounds(442, 536, 96, 20);
		contentPane.add(textField_33);
		textField_33.setColumns(10);
		
		txtID1 = new JTextField();
		txtID1.setBounds(709, 107, 96, 20);
	
		contentPane.add(txtID1);
		txtID1.setColumns(10);
		txtID1.setVisible(false);
		
		btnAdd2 = new JButton("Add");
		btnAdd2.setBounds(759, 184, 89, 23);
		contentPane.add(btnAdd2);
		
		btnRemove2 = new JButton("Remove");
		btnRemove2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagePlaylistApplication.removeFromList(currentUserID, txtID2.getText());
			}
		});
		btnRemove2.setBounds(868, 184, 89, 23);
		contentPane.add(btnRemove2);
		
		txtID2 = new JTextField();
		txtID2.setBounds(696, 163, 96, 20);
		contentPane.add(txtID2);
		txtID2.setColumns(10);
		
		JButton btnNewButton = new JButton("down");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		btnNewButton.setBounds(154, 137, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUp = new JButton("up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtSwap1.setText(txtID2.getText());
				txtSwap2.setText(txtID1.getText());
		
				ManagePlaylistApplication.improveRanking( txtSwap1.getText(), txtSwap2.getText());
				refreshScreen(currentPlaylistTitle) ;
			}
		});
		btnUp.setBounds(64, 179, 89, 23);
		contentPane.add(btnUp);
		
		txtSwap1 = new JTextField();
		txtSwap1.setBounds(677, 45, 96, 20);
		contentPane.add(txtSwap1);
		txtSwap1.setColumns(10);
		
		txtSwap2 = new JTextField();
		txtSwap2.setBounds(839, 45, 96, 20);
		contentPane.add(txtSwap2);
		txtSwap2.setColumns(10);
		txtID2.setVisible(false);
	}
	
	
	
	public void refreshScreen(String currentPlaylistTitle) {
		
		clearScreen();
		ResultSet currentList = ManagePlaylistApplication.loadPlaylist(currentPlaylistTitle);
		
		String playlistTitle = null;
		String playlistId = null;
		String title = null;
		String artist = null;
		String genre = null;
		String rating = null;
		String ranking = null;
		
		
		try {
			
			
						
						while (currentList.next())																	
						{
						
							playlistTitle = currentList.getString("PlaylistTitle");
							txtPlaylistTitle.setText(playlistTitle);
							
							System.out.println(playlistTitle);
							
							playlistId = currentList.getString("playlistID");
							title = currentList.getString("Title");
							artist = currentList.getString("Artist");
							genre = currentList.getString("Genre");
							rating = currentList.getString("Rating");
							ranking = currentList.getString("Ranking");
							
							/*
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
							 */
							
							switch (ranking) {
							case "1":
								System.out.println("id: " + playlistId);
								txtID1.setText(playlistId);
								txtTitle1.setText(title);
								txtArtist1.setText(artist);
								txtGenre1.setText(genre);
								txtRating1.setText(artist);
								btnAdd1.setEnabled(false);
								btnRemove1.setEnabled(true);
								break;
							case "2":
								System.out.println("id: " + playlistId);
								txtID2.setText(playlistId);
								txtTitle2.setText(title);
								txtArtist2.setText(artist);
								txtGenre2.setText(genre);
								txtRating2.setText(artist);
								break;
							case "3":
						
								break;
							case "4":
						
								break;
							case "5":
							
								break;
							case "6":
						
								break;
							case "7":
						
								break;
							case "8":
							
								break;
							case "9":
					
								break;
							case "10":
							
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
	
	public void clearScreen() {
		

						
								txtID1.setText("");
								txtTitle1.setText("");
								txtArtist1.setText("");
								txtGenre1.setText("");
								txtRating1.setText("");
								btnAdd1.setEnabled(true);
								btnRemove1.setEnabled(false);
							
								
								txtID2.setText("");
								txtTitle2.setText("");
								txtArtist2.setText("");
								txtGenre2.setText("");
								txtRating2.setText("");
			
		
	}
	
	
	
	
	
	
	
}
