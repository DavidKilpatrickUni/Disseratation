import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class MyPlaylistsScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCount;
	private JTextField txtTitle1;
	private JTextField txtTitle2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnPlaylist1;
	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPlaylistsScreen frame = new MyPlaylistsScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
*/

	/**
	 * Create the frame.
	 */
	public MyPlaylistsScreen(String currentUserID, String currentUserName) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				ResultSet myLists = MyPlaylistsApplication.loadPlaylists(currentUserID);
				
				String playlistTitle = null;
	
				int row = 1;
				
	try {
		
		
					
					while (myLists.next())																	
					{
						textFieldCount.setText(String.valueOf(myLists.getRow()));
						playlistTitle = myLists.getString("PlaylistTitle");
						System.out.println(playlistTitle);
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
						
						switch (row) {
						case 1:
							txtTitle1.setText(playlistTitle);
							btnPlaylist1.setText("View");
							break;
						case 2:
							txtTitle2.setText(playlistTitle);
					
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPlaylist1 = new JButton("Create List");
		btnPlaylist1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagePlaylistScreen gui = new ManagePlaylistScreen(currentUserID, currentUserName, txtTitle1.getText());
				gui.setVisible(true);
				dispose();
				
			}
		});
		btnPlaylist1.setBounds(57, 194, 89, 23);
		contentPane.add(btnPlaylist1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(57, 363, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnPlaylist2 = new JButton("New button");
		btnPlaylist2.setBounds(203, 194, 89, 23);
		contentPane.add(btnPlaylist2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(203, 363, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(341, 194, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(341, 345, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(488, 194, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(488, 345, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(632, 194, 89, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(632, 345, 89, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainScreen gui = new MainScreen(currentUserID, currentUserName);
				gui.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(461, 412, 89, 23);
		contentPane.add(btnBack);
		
		textFieldCount = new JTextField();
		textFieldCount.setBounds(85, 42, 96, 20);
		contentPane.add(textFieldCount);
		textFieldCount.setColumns(10);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(57, 161, 96, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBounds(203, 161, 96, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(341, 161, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(476, 161, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(632, 161, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}

}
