import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminViewSongScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtArtist;
	private JTextField txtGenre;
	private JTextField txtAlbum;
	private JTextField txtSongLength;
	private JDateChooser dateChooser;
	private JTextField txtReleased;
	private JTextArea txtSongInfo;

	public AdminViewSongScreen(AdminLoggedIn currentAdmin, String currentSongID) {
		setTitle("Admin - Song Detail");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				loadSongInfo(currentSongID);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(42, 112, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(42, 164, 48, 14);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(42, 212, 48, 14);
		contentPane.add(lblGenre);
		
		JLabel lblSongLength = new JLabel("Song Length");
		lblSongLength.setBounds(42, 263, 71, 14);
		contentPane.add(lblSongLength);
		
		JLabel lblReleased = new JLabel("Released");
		lblReleased.setBounds(42, 309, 75, 14);
		contentPane.add(lblReleased);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(42, 362, 48, 14);
		contentPane.add(lblAlbum);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setBounds(424, 117, 75, 14);
		contentPane.add(lblSongInfo);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Update This Song?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.updateSong(txtTitle.getText(), txtArtist.getText(), txtGenre.getText(), txtSongLength.getText(), txtReleased.getText(), txtAlbum.getText(), txtSongInfo.getText(), currentSongID);;
					
						JOptionPane.showMessageDialog(null, "Successfully Updated Song", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
					}
				
				
			}
		});
		btnUpdate.setBounds(350, 418, 125, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Song?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deleteSong(currentSongID);
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Song", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
					
						AdminSearchSongsScreen adminSearchSongsScreen = new AdminSearchSongsScreen(currentAdmin);
						adminSearchSongsScreen.setVisible(true);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete.setBounds(350, 468, 125, 23);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSearchSongsScreen adminSearchSongsScreen = new AdminSearchSongsScreen(currentAdmin);
				adminSearchSongsScreen.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(364, 532, 100, 23);
		contentPane.add(btnBack);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(149, 109, 200, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtArtist = new JTextField();
		txtArtist.setBounds(149, 159, 200, 20);
		contentPane.add(txtArtist);
		txtArtist.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(151, 209, 200, 20);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setBounds(151, 359, 200, 20);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtSongInfo = new JTextArea();
		txtSongInfo.setBounds(508, 112, 257, 264);
		contentPane.add(txtSongInfo);
		
		txtSongLength = new JTextField();
		txtSongLength.setBounds(149, 260, 200, 20);
		contentPane.add(txtSongLength);
		txtSongLength.setColumns(10);
		
		txtReleased = new JTextField();
		txtReleased.setBounds(149, 306, 200, 20);
		contentPane.add(txtReleased);
		txtReleased.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Song Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(332, 11, 257, 59);
		contentPane.add(lblNewLabel);
	}
	
	public void loadSongInfo(String currentSongID) {
		
		ResultSet songDetails = AdminSQL.songDetails(currentSongID);
	
		String title = null;
		String artist = null;
		String length = null;
		String album = null;
		String genre = null;
		String released = null;
		String info =null;

		try 
		{
		
			while (songDetails.next())																	
			{
				title = songDetails.getString("Title");
				artist = songDetails.getString("Artist");
				length = songDetails.getString("Song Length");
				album = songDetails.getString("Album");
				genre = songDetails.getString("Genre");
				released = songDetails.getString("Released");
				info = songDetails.getString("Song Info");

				txtTitle.setText(title);
				txtArtist.setText(artist);
				txtSongLength.setText(length);
				txtAlbum.setText(album);
				txtGenre.setText(genre);
				txtReleased.setText(released);
				txtSongInfo.setText(info);
				
			}

		}
		catch (SQLException sqe)
		{
		
		}
	}
}
