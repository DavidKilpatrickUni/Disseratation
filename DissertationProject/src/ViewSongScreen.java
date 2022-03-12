import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class ViewSongScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldArtist;
	private JTextField textFieldUserName1;
	private JTextField textFieldComment1;
	private JTextField textFieldUserName2;
	private JTextField textFieldComment2;
	private JTextField textFieldCount;
	private JTextField textFieldAddComment;
	private JButton btnAddComment;
	private JLabel lblNewLabelComments;
	private JTextField textFieldPosted1;
	private JTextField textFieldPosted2;
	private JLabel lblLength;
	private JLabel lblAlbum;
	private JLabel lblGenre;
	private JLabel lblReleased;
	private JLabel lblInfo;
	private JLabel lblRating;
	private JTextField txtLength;
	private JTextField txtAlbum;
	private JTextField txtGenre;
	private JTextField txtReleased;
	private JTextArea textArea;

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
	public ViewSongScreen(String currentUserID, String currentUserName, String currentSongID) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				
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
				
				
				
				
				
				
				
				ResultSet songComments  = ViewSongApplication.getComments(currentSongID);
			
			
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
				
				textFieldCount.setText(String.valueOf(songComments.getRow()));
						
						switch (row) {
						case 1:
					
							textFieldUserName1.setText(userName);
							textFieldComment1.setText(comment);
							textFieldPosted1.setText(posted);
							break;
						case 2:
						
							textFieldUserName2.setText(userName);
							textFieldComment2.setText(comment);
							textFieldPosted2.setText(posted);
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
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(235, 11, 96, 20);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		textFieldArtist = new JTextField();
		textFieldArtist.setBounds(235, 46, 96, 20);
		contentPane.add(textFieldArtist);
		textFieldArtist.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(177, 14, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(173, 49, 48, 14);
		contentPane.add(lblArtist);
		
		textFieldUserName1 = new JTextField();
		textFieldUserName1.setBounds(37, 368, 113, 20);
		contentPane.add(textFieldUserName1);
		textFieldUserName1.setColumns(10);
		
		textFieldComment1 = new JTextField();
		textFieldComment1.setBounds(177, 368, 357, 20);
		contentPane.add(textFieldComment1);
		textFieldComment1.setColumns(10);
		
		textFieldUserName2 = new JTextField();
		textFieldUserName2.setBounds(37, 399, 113, 20);
		contentPane.add(textFieldUserName2);
		textFieldUserName2.setColumns(10);
		
		textFieldComment2 = new JTextField();
		textFieldComment2.setBounds(177, 399, 357, 20);
		contentPane.add(textFieldComment2);
		textFieldComment2.setColumns(10);
		
		textFieldCount = new JTextField();
		textFieldCount.setText("0");
		textFieldCount.setBounds(178, 337, 96, 20);
		contentPane.add(textFieldCount);
		textFieldCount.setColumns(10);
		
		textFieldAddComment = new JTextField();
		textFieldAddComment.setBounds(44, 291, 378, 20);
		contentPane.add(textFieldAddComment);
		textFieldAddComment.setColumns(10);
		
		btnAddComment = new JButton("Add Comment");
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSongApplication.addComment(currentSongID, currentUserID, textFieldAddComment.getText());
				
			}
		});
		btnAddComment.setBounds(464, 290, 126, 23);
		contentPane.add(btnAddComment);
		
		lblNewLabelComments = new JLabel("Number Of Comments");
		lblNewLabelComments.setBounds(26, 343, 142, 14);
		contentPane.add(lblNewLabelComments);
		
		textFieldPosted1 = new JTextField();
		textFieldPosted1.setBounds(570, 368, 96, 20);
		contentPane.add(textFieldPosted1);
		textFieldPosted1.setColumns(10);
		
		textFieldPosted2 = new JTextField();
		textFieldPosted2.setBounds(570, 399, 96, 20);
		contentPane.add(textFieldPosted2);
		textFieldPosted2.setColumns(10);
		
		lblLength = new JLabel("Song Length");
		lblLength.setBounds(392, 49, 48, 14);
		contentPane.add(lblLength);
		
		lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(177, 90, 48, 14);
		contentPane.add(lblAlbum);
		
		lblGenre = new JLabel("Genre");
		lblGenre.setBounds(392, 14, 48, 14);
		contentPane.add(lblGenre);
		
		lblReleased = new JLabel("Released");
		lblReleased.setBounds(392, 90, 48, 14);
		contentPane.add(lblReleased);
		
		lblInfo = new JLabel("Song Info");
		lblInfo.setBounds(570, 14, 48, 14);
		contentPane.add(lblInfo);
		
		lblRating = new JLabel("Rating");
		lblRating.setBounds(37, 150, 48, 14);
		contentPane.add(lblRating);
		
		txtLength = new JTextField();
		txtLength.setBounds(450, 46, 96, 20);
		contentPane.add(txtLength);
		txtLength.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setBounds(235, 90, 96, 20);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(450, 11, 96, 20);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtReleased = new JTextField();
		txtReleased.setBounds(450, 87, 96, 20);
		contentPane.add(txtReleased);
		txtReleased.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(574, 37, 205, 218);
		contentPane.add(textArea);
		
		JLabel lblMyRating = new JLabel("My Rating");
		lblMyRating.setBounds(37, 200, 48, 14);
		contentPane.add(lblMyRating);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setBounds(116, 232, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setBounds(262, 232, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setBounds(400, 232, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
	}
}
