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
	private JTextField txtTitle3;
	private JTextField txtArtist3;
	private JTextField txtGenre3;
	private JTextField txtTitle4;
	private JTextField txtArtist4;
	private JTextField txtGenre4;
	private JTextField txtTitle5;
	private JTextField txtArtist5;
	private JTextField txtGenre5;
	private JTextField txtTitle6;
	private JTextField txtArtist6;
	private JTextField txtGenre6;
	private JTextField txtTitle7;
	private JTextField txtTitle8;
	private JTextField txtTitle9;
	private JTextField txtTitle10;
	private JTextField txtArtist7;
	private JTextField txtArtist8;
	private JTextField txtArtist9;
	private JTextField txtArtist10;
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
	private JTextField txtID1;
	private JButton btnAdd1;
	private JButton btnAdd2;
	private JButton btnRemove2;
	private JTextField txtID2;
	private JTextField txtSwap1;
	private JTextField txtSwap2;
	private JTextField txtID3;
	private JTextField txtID4;
	private JTextField txtID5;
	private JTextField txtID6;
	private JTextField txtID7;
	private JTextField txtID8;
	private JTextField txtID9;
	private JTextField txtID10;

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
		
		JLabel label10 = new JLabel("10");
		label10.setBounds(21, 539, 48, 14);
		contentPane.add(label10);
		
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
		
		txtTitle3 = new JTextField();
		txtTitle3.setBounds(253, 224, 96, 20);
		contentPane.add(txtTitle3);
		txtTitle3.setColumns(10);
		
		txtArtist3 = new JTextField();
		txtArtist3.setBounds(373, 224, 96, 20);
		contentPane.add(txtArtist3);
		txtArtist3.setColumns(10);
		
		txtGenre3 = new JTextField();
		txtGenre3.setBounds(499, 224, 96, 20);
		contentPane.add(txtGenre3);
		txtGenre3.setColumns(10);
		
		txtTitle4 = new JTextField();
		txtTitle4.setBounds(256, 279, 96, 20);
		contentPane.add(txtTitle4);
		txtTitle4.setColumns(10);
		
		txtArtist4 = new JTextField();
		txtArtist4.setBounds(376, 279, 96, 20);
		contentPane.add(txtArtist4);
		txtArtist4.setColumns(10);
		
		txtGenre4 = new JTextField();
		txtGenre4.setBounds(502, 279, 96, 20);
		contentPane.add(txtGenre4);
		txtGenre4.setColumns(10);
		
		txtTitle5 = new JTextField();
		txtTitle5.setBounds(256, 327, 96, 20);
		contentPane.add(txtTitle5);
		txtTitle5.setColumns(10);
		
		txtArtist5 = new JTextField();
		txtArtist5.setBounds(376, 327, 96, 20);
		contentPane.add(txtArtist5);
		txtArtist5.setColumns(10);
		
		txtGenre5 = new JTextField();
		txtGenre5.setBounds(502, 327, 96, 20);
		contentPane.add(txtGenre5);
		txtGenre5.setColumns(10);
		
		txtTitle6 = new JTextField();
		txtTitle6.setBounds(256, 377, 96, 20);
		contentPane.add(txtTitle6);
		txtTitle6.setColumns(10);
		
		txtArtist6 = new JTextField();
		txtArtist6.setBounds(376, 377, 96, 20);
		contentPane.add(txtArtist6);
		txtArtist6.setColumns(10);
		
		txtGenre6 = new JTextField();
		txtGenre6.setBounds(502, 377, 96, 20);
		contentPane.add(txtGenre6);
		txtGenre6.setColumns(10);
		
		txtTitle7 = new JTextField();
		txtTitle7.setBounds(256, 428, 96, 20);
		contentPane.add(txtTitle7);
		txtTitle7.setColumns(10);
		
		txtTitle8 = new JTextField();
		txtTitle8.setBounds(256, 470, 96, 20);
		contentPane.add(txtTitle8);
		txtTitle8.setColumns(10);
		
		txtTitle9 = new JTextField();
		txtTitle9.setBounds(256, 507, 96, 20);
		contentPane.add(txtTitle9);
		txtTitle9.setColumns(10);
		
		txtTitle10 = new JTextField();
		txtTitle10.setBounds(256, 543, 96, 20);
		contentPane.add(txtTitle10);
		txtTitle10.setColumns(10);
		
		txtArtist7 = new JTextField();
		txtArtist7.setBounds(376, 428, 96, 20);
		contentPane.add(txtArtist7);
		txtArtist7.setColumns(10);
		
		txtArtist8 = new JTextField();
		txtArtist8.setBounds(376, 470, 96, 20);
		contentPane.add(txtArtist8);
		txtArtist8.setColumns(10);
		
		txtArtist9 = new JTextField();
		txtArtist9.setBounds(376, 507, 96, 20);
		contentPane.add(txtArtist9);
		txtArtist9.setColumns(10);
		
		txtArtist10 = new JTextField();
		txtArtist10.setBounds(376, 543, 96, 20);
		contentPane.add(txtArtist10);
		txtArtist10.setColumns(10);
		
		txtGenre7 = new JTextField();
		txtGenre7.setBounds(502, 428, 96, 20);
		contentPane.add(txtGenre7);
		txtGenre7.setColumns(10);
		
		txtGenre8 = new JTextField();
		txtGenre8.setBounds(502, 470, 96, 20);
		contentPane.add(txtGenre8);
		txtGenre8.setColumns(10);
		
		txtGenre9 = new JTextField();
		txtGenre9.setBounds(502, 507, 96, 20);
		contentPane.add(txtGenre9);
		txtGenre9.setColumns(10);
		
		txtGenre10 = new JTextField();
		txtGenre10.setBounds(502, 543, 96, 20);
		contentPane.add(txtGenre10);
		txtGenre10.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBounds(616, 143, 96, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtRating2 = new JTextField();
		txtRating2.setBounds(616, 185, 96, 20);
		contentPane.add(txtRating2);
		txtRating2.setColumns(10);
		
		txtRating3 = new JTextField();
		txtRating3.setBounds(616, 224, 96, 20);
		contentPane.add(txtRating3);
		txtRating3.setColumns(10);
		
		txtRating4 = new JTextField();
		txtRating4.setBounds(619, 279, 96, 20);
		contentPane.add(txtRating4);
		txtRating4.setColumns(10);
		
		txtRating5 = new JTextField();
		txtRating5.setBounds(619, 327, 96, 20);
		contentPane.add(txtRating5);
		txtRating5.setColumns(10);
		
		txtRating6 = new JTextField();
		txtRating6.setBounds(619, 377, 96, 20);
		contentPane.add(txtRating6);
		txtRating6.setColumns(10);
		
		txtRating7 = new JTextField();
		txtRating7.setBounds(619, 428, 96, 20);
		contentPane.add(txtRating7);
		txtRating7.setColumns(10);
		
		txtRating8 = new JTextField();
		txtRating8.setBounds(630, 470, 96, 20);
		contentPane.add(txtRating8);
		txtRating8.setColumns(10);
		
		txtRating9 = new JTextField();
		txtRating9.setBounds(619, 507, 96, 20);
		contentPane.add(txtRating9);
		txtRating9.setColumns(10);
		
		txtRating10 = new JTextField();
		txtRating10.setBounds(619, 543, 96, 20);
		contentPane.add(txtRating10);
		txtRating10.setColumns(10);
		
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
		
		JButton btnDown1 = new JButton("Down");
		btnDown1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		btnDown1.setBounds(154, 137, 89, 23);
		contentPane.add(btnDown1);
		
		JButton btnUp2 = new JButton("Up");
		btnUp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtSwap1.setText(txtID2.getText());
				txtSwap2.setText(txtID1.getText());
		
				ManagePlaylistApplication.improveRanking( txtSwap1.getText(), txtSwap2.getText());
				refreshScreen(currentPlaylistTitle) ;
			}
		});
		btnUp2.setBounds(64, 179, 89, 23);
		contentPane.add(btnUp2);
		
		txtSwap1 = new JTextField();
		txtSwap1.setBounds(677, 45, 96, 20);
		contentPane.add(txtSwap1);
		txtSwap1.setColumns(10);
		
		txtSwap2 = new JTextField();
		txtSwap2.setBounds(839, 45, 96, 20);
		contentPane.add(txtSwap2);
		txtSwap2.setColumns(10);
		
		JButton btnAdd3 = new JButton("Add");
		btnAdd3.setBounds(750, 223, 89, 23);
		contentPane.add(btnAdd3);
		
		JButton btnRemove3 = new JButton("Remove");
		btnRemove3.setBounds(878, 223, 89, 23);
		contentPane.add(btnRemove3);
		
		JButton btnAdd4 = new JButton("Add");
		btnAdd4.setBounds(750, 278, 89, 23);
		contentPane.add(btnAdd4);
		
		JButton btnRemove4 = new JButton("Remove");
		btnRemove4.setBounds(878, 278, 89, 23);
		contentPane.add(btnRemove4);
		
		JButton btnAdd5 = new JButton("Add");
		btnAdd5.setBounds(750, 326, 89, 23);
		contentPane.add(btnAdd5);
		
		JButton btnRemove5 = new JButton("Remove");
		btnRemove5.setBounds(868, 326, 89, 23);
		contentPane.add(btnRemove5);
		
		JButton btnAdd6 = new JButton("Add");
		btnAdd6.setBounds(759, 376, 89, 23);
		contentPane.add(btnAdd6);
		
		JButton btnRemove6 = new JButton("Remove");
		btnRemove6.setBounds(868, 376, 89, 23);
		contentPane.add(btnRemove6);
		
		JButton btnAdd7 = new JButton("Add");
		btnAdd7.setBounds(759, 427, 89, 23);
		contentPane.add(btnAdd7);
		
		JButton btnRemove7 = new JButton("Remove");
		btnRemove7.setBounds(868, 427, 89, 23);
		contentPane.add(btnRemove7);
		
		JButton btnAdd8 = new JButton("Add");
		btnAdd8.setBounds(750, 469, 89, 23);
		contentPane.add(btnAdd8);
		
		JButton btnAdd9 = new JButton("Add");
		btnAdd9.setBounds(759, 506, 89, 23);
		contentPane.add(btnAdd9);
		
		JButton btnAdd10 = new JButton("Add");
		btnAdd10.setBounds(759, 542, 89, 23);
		contentPane.add(btnAdd10);
		
		JButton btnRemove8 = new JButton("Remove");
		btnRemove8.setBounds(868, 469, 89, 23);
		contentPane.add(btnRemove8);
		
		JButton btnRemove9 = new JButton("Remove");
		btnRemove9.setBounds(868, 506, 89, 23);
		contentPane.add(btnRemove9);
		
		JButton btnRemove10 = new JButton("Remove");
		btnRemove10.setBounds(868, 542, 89, 23);
		contentPane.add(btnRemove10);
		
		txtID3 = new JTextField();
		txtID3.setBounds(709, 206, 96, 20);
		contentPane.add(txtID3);
		txtID3.setColumns(10);
		
		txtID4 = new JTextField();
		txtID4.setBounds(696, 255, 96, 20);
		contentPane.add(txtID4);
		txtID4.setColumns(10);
		
		txtID5 = new JTextField();
		txtID5.setBounds(696, 296, 96, 20);
		contentPane.add(txtID5);
		txtID5.setColumns(10);
		
		txtID6 = new JTextField();
		txtID6.setBounds(696, 346, 96, 20);
		contentPane.add(txtID6);
		txtID6.setColumns(10);
		
		txtID7 = new JTextField();
		txtID7.setBounds(709, 397, 96, 20);
		contentPane.add(txtID7);
		txtID7.setColumns(10);
		
		txtID8 = new JTextField();
		txtID8.setBounds(709, 444, 96, 20);
		contentPane.add(txtID8);
		txtID8.setColumns(10);
		
		txtID9 = new JTextField();
		txtID9.setBounds(709, 486, 96, 20);
		contentPane.add(txtID9);
		txtID9.setColumns(10);
		
		txtID10 = new JTextField();
		txtID10.setBounds(709, 522, 96, 20);
		contentPane.add(txtID10);
		txtID10.setColumns(10);
		
		JButton btnUp3 = new JButton("Up");
		btnUp3.setBounds(64, 223, 89, 23);
		contentPane.add(btnUp3);
		
		JButton btnUp4 = new JButton("Up");
		btnUp4.setBounds(64, 278, 89, 23);
		contentPane.add(btnUp4);
		
		JButton btnUp5 = new JButton("Up");
		btnUp5.setBounds(64, 326, 89, 23);
		contentPane.add(btnUp5);
		
		JButton btnUp6 = new JButton("Up");
		btnUp6.setBounds(64, 376, 89, 23);
		contentPane.add(btnUp6);
		
		JButton btnUp7 = new JButton("Up");
		btnUp7.setBounds(64, 427, 89, 23);
		contentPane.add(btnUp7);
		
		JButton btnUp8 = new JButton("Up");
		btnUp8.setBounds(64, 469, 89, 23);
		contentPane.add(btnUp8);
		
		JButton btnUp9 = new JButton("Up");
		btnUp9.setBounds(64, 505, 89, 23);
		contentPane.add(btnUp9);
		
		JButton btnUp10 = new JButton("Up");
		btnUp10.setBounds(64, 542, 89, 23);
		contentPane.add(btnUp10);
		
		JButton btnDown2 = new JButton("Down");
		btnDown2.setBounds(154, 179, 89, 23);
		contentPane.add(btnDown2);
		
		JButton btnDown3 = new JButton("Down");
		btnDown3.setBounds(154, 223, 89, 23);
		contentPane.add(btnDown3);
		
		JButton btnDown4 = new JButton("Down");
		btnDown4.setBounds(157, 278, 89, 23);
		contentPane.add(btnDown4);
		
		JButton btnDown5 = new JButton("Down");
		btnDown5.setBounds(157, 326, 89, 23);
		contentPane.add(btnDown5);
		
		JButton btnDown6 = new JButton("Down");
		btnDown6.setBounds(157, 376, 89, 23);
		contentPane.add(btnDown6);
		
		JButton btnDown7 = new JButton("Down");
		btnDown7.setBounds(157, 427, 89, 23);
		contentPane.add(btnDown7);
		
		JButton btnDown8 = new JButton("Down");
		btnDown8.setBounds(157, 469, 89, 23);
		contentPane.add(btnDown8);
		
		JButton btnDown9 = new JButton("Down");
		btnDown9.setBounds(157, 506, 89, 23);
		contentPane.add(btnDown9);
		
		JLabel label3 = new JLabel("3");
		label3.setBounds(10, 227, 48, 14);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("4");
		label4.setBounds(10, 282, 48, 14);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("5");
		label5.setBounds(6, 330, 48, 14);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("6");
		label6.setBounds(6, 380, 48, 14);
		contentPane.add(label6);
		
		JLabel label7 = new JLabel("7");
		label7.setBounds(6, 431, 48, 14);
		contentPane.add(label7);
		
		JLabel label8 = new JLabel("8");
		label8.setBounds(6, 473, 48, 14);
		contentPane.add(label8);
		
		JLabel label9 = new JLabel("9");
		label9.setBounds(10, 514, 48, 14);
		contentPane.add(label9);
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
							
							playlistId = currentList.getString("PlaylistID");
							ranking = currentList.getString("Ranking");
							
							
							title = currentList.getString("Title");
							artist = currentList.getString("Artist");
							genre = currentList.getString("Genre");
							rating = currentList.getString("OverallRating");
							
							
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
