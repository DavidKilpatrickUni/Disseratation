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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPlaylistScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtRating1;
	private JTextField txtPlaylistTitle;
	private JTextField txtTitle2;
	private JTextField txtArtist2;
	private JTextField txtGenre2;
	private JTextField txtRating2;
	private JTextField txtUsername;
	private JTextField txtPlaylistCreated;

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
	
	
	public ViewPlaylistScreen(String playlistTitle, String userID) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				
				ResultSet viewList = ViewPlaylistApplication.loadPlaylist(playlistTitle, userID);
				
				String playlistTitle = null;
				String playlistId = null;
				String title = null;
				String artist = null;
				String genre = null;
				String rating = null;
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
									rating = viewList.getString("Rating");
									ranking = viewList.getString("Ranking");
									
								
									
						
									 
									
									switch (ranking) {
									case "1":
								
							
										txtTitle1.setText(title);
										txtArtist1.setText(artist);
										txtGenre1.setText(genre);
										txtRating1.setText(artist);
									
										break;
									case "2":
						
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
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(61, 184, 96, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBounds(226, 184, 96, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBounds(363, 184, 96, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBounds(483, 184, 96, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtPlaylistTitle = new JTextField();
		txtPlaylistTitle.setBounds(316, 70, 96, 20);
		contentPane.add(txtPlaylistTitle);
		txtPlaylistTitle.setColumns(10);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBounds(61, 230, 96, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		txtArtist2 = new JTextField();
		txtArtist2.setText("");
		txtArtist2.setBounds(226, 230, 96, 20);
		contentPane.add(txtArtist2);
		txtArtist2.setColumns(10);
		
		txtGenre2 = new JTextField();
		txtGenre2.setBounds(363, 230, 96, 20);
		contentPane.add(txtGenre2);
		txtGenre2.setColumns(10);
		
		txtRating2 = new JTextField();
		txtRating2.setBounds(483, 230, 96, 20);
		contentPane.add(txtRating2);
		txtRating2.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(121, 70, 96, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPlaylistCreated = new JTextField();
		txtPlaylistCreated.setBounds(497, 70, 96, 20);
		contentPane.add(txtPlaylistCreated);
		txtPlaylistCreated.setColumns(10);
	}

}
