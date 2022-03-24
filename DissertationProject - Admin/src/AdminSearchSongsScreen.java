import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSearchSongsScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtSongID1;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtUploaded1;
	private JTextField txtTitle2;
	private JTextField txtTitle3;
	private JTextField txtTitle4;
	private JTextField txtTitle5;
	private JTextField txtTitle6;
	private JTextField txtTitle7;
	private JTextField txtTitle8;
	private JTextField txtTitle9;
	private JTextField txtTitle10;
	private JTextField txtSongID2;
	private JTextField txtSongID3;
	private JTextField txtSongID4;
	private JTextField txtSongID5;
	private JTextField txtSongID6;
	private JTextField txtSongID7;
	private JTextField txtSongID8;
	private JTextField txtSongID9;
	private JTextField txtSongID10;
	private JTextField txtArtist2;
	private JTextField txtArtist3;
	private JTextField txtArtist4;
	private JTextField txtArtist5;
	private JTextField txtArtist6;
	private JTextField txtArtist7;
	private JTextField txtArtist8;
	private JTextField txtArtist9;
	private JTextField txtArtist10;
	private JTextField txtGenre2;
	private JTextField txtGenre3;
	private JTextField txtGenre4;
	private JTextField txtGenre5;
	private JTextField txtGenre6;
	private JTextField txtGenre7;
	private JTextField txtGenre8;
	private JTextField txtGenre9;
	private JTextField txtGenre10;
	private JTextField txtUploaded2;
	private JTextField txtUploaded3;
	private JTextField txtUploaded4;
	private JTextField txtUploaded5;
	private JTextField txtUploaded6;
	private JTextField txtUploaded7;
	private JTextField txtUploaded8;
	private JTextField txtUploaded9;
	private JTextField txtUploaded10;
	
	private JComboBox comboBoxCriteria;
	private JComboBox comboBoxSearch;
	
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
	private JButton btnNext;
	private JButton btnPrevious;
	
	private int pageCount = 1;
	private int sqlOffset = 0;
	private int sqlRowCount = 10;
	private JTextField txtPage;
	private JButton btnMenu;

	public AdminSearchSongsScreen(AdminLoggedIn currentAdmin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSongID1 = new JTextField();
		txtSongID1.setBounds(20, 180, 50, 20);
		contentPane.add(txtSongID1);
		txtSongID1.setColumns(10);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(100, 180, 200, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBounds(330, 180, 200, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBounds(560, 180, 150, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		btnView1 = new JButton("View");
		btnView1.setEnabled(false);
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID1.getText());
				mainScreen.setVisible(true);
				dispose();
				
			}
		});
		btnView1.setBounds(870, 180, 100, 20);
		contentPane.add(btnView1);
		
		txtUploaded1 = new JTextField();
		txtUploaded1.setBounds(740, 180, 100, 20);
		contentPane.add(txtUploaded1);
		txtUploaded1.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(100, 140, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(330, 140, 48, 14);
		contentPane.add(lblArtist);
		
		JLabel lblSongID = new JLabel("SongID");
		lblSongID.setBounds(20, 140, 48, 14);
		contentPane.add(lblSongID);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(560, 140, 48, 14);
		contentPane.add(lblGenre);
		
		JLabel lblUploaded = new JLabel("Uploaded");
		lblUploaded.setBounds(740, 140, 48, 14);
		contentPane.add(lblUploaded);
		
		comboBoxSearch = new JComboBox();
		comboBoxSearch.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				
				comboBoxSearch.removeAllItems();
				
				ResultSet populateComboBox = AdminSQL.populateComboBox(comboBoxCriteria.getSelectedItem());	
				
					try {
						
						while (populateComboBox.next())
						{
							comboBoxSearch.addItem(populateComboBox.getString(comboBoxCriteria.getSelectedItem().toString()));
						}
					} catch (SQLException sql) {
				
					}
				
				
			}
		});
		comboBoxSearch.setBounds(140, 80, 200, 22);
		contentPane.add(comboBoxSearch);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"SongID", "Title", "Artist"}));
		comboBoxCriteria.setBounds(501, 80, 200, 22);
		contentPane.add(comboBoxCriteria);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageCount = 1;
				sqlOffset = 0;
				clearScreen();
				loadContent();
			}
		});
		btnSearch.setBounds(786, 80, 89, 23);
		contentPane.add(btnSearch);
		
		txtTitle2 = new JTextField();
		txtTitle2.setColumns(10);
		txtTitle2.setBounds(100, 210, 200, 20);
		contentPane.add(txtTitle2);
		
		txtTitle3 = new JTextField();
		txtTitle3.setColumns(10);
		txtTitle3.setBounds(100, 240, 200, 20);
		contentPane.add(txtTitle3);
		
		txtTitle4 = new JTextField();
		txtTitle4.setColumns(10);
		txtTitle4.setBounds(100, 270, 200, 20);
		contentPane.add(txtTitle4);
		
		txtTitle5 = new JTextField();
		txtTitle5.setColumns(10);
		txtTitle5.setBounds(100, 300, 200, 20);
		contentPane.add(txtTitle5);
		
		txtTitle6 = new JTextField();
		txtTitle6.setColumns(10);
		txtTitle6.setBounds(100, 330, 200, 20);
		contentPane.add(txtTitle6);
		
		txtTitle7 = new JTextField();
		txtTitle7.setColumns(10);
		txtTitle7.setBounds(100, 360, 200, 20);
		contentPane.add(txtTitle7);
		
		txtTitle8 = new JTextField();
		txtTitle8.setColumns(10);
		txtTitle8.setBounds(100, 390, 200, 20);
		contentPane.add(txtTitle8);
		
		txtTitle9 = new JTextField();
		txtTitle9.setColumns(10);
		txtTitle9.setBounds(100, 420, 200, 20);
		contentPane.add(txtTitle9);
		
		txtTitle10 = new JTextField();
		txtTitle10.setColumns(10);
		txtTitle10.setBounds(100, 450, 200, 20);
		contentPane.add(txtTitle10);
		
		txtSongID2 = new JTextField();
		txtSongID2.setColumns(10);
		txtSongID2.setBounds(20, 210, 50, 20);
		contentPane.add(txtSongID2);
		
		txtSongID3 = new JTextField();
		txtSongID3.setColumns(10);
		txtSongID3.setBounds(20, 240, 50, 20);
		contentPane.add(txtSongID3);
		
		txtSongID4 = new JTextField();
		txtSongID4.setColumns(10);
		txtSongID4.setBounds(20, 270, 50, 20);
		contentPane.add(txtSongID4);
		
		txtSongID5 = new JTextField();
		txtSongID5.setColumns(10);
		txtSongID5.setBounds(20, 300, 50, 20);
		contentPane.add(txtSongID5);
		
		txtSongID6 = new JTextField();
		txtSongID6.setColumns(10);
		txtSongID6.setBounds(20, 330, 50, 20);
		contentPane.add(txtSongID6);
		
		txtSongID7 = new JTextField();
		txtSongID7.setColumns(10);
		txtSongID7.setBounds(20, 360, 50, 20);
		contentPane.add(txtSongID7);
		
		txtSongID8 = new JTextField();
		txtSongID8.setColumns(10);
		txtSongID8.setBounds(20, 390, 50, 20);
		contentPane.add(txtSongID8);
		
		txtSongID9 = new JTextField();
		txtSongID9.setColumns(10);
		txtSongID9.setBounds(20, 420, 50, 20);
		contentPane.add(txtSongID9);
		
		txtSongID10 = new JTextField();
		txtSongID10.setColumns(10);
		txtSongID10.setBounds(20, 450, 50, 20);
		contentPane.add(txtSongID10);
		
		JLabel lblHeader = new JLabel("Search Songs");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeader.setBounds(430, 11, 205, 30);
		contentPane.add(lblHeader);
		
		JLabel lblSearchFor = new JLabel("Search");
		lblSearchFor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchFor.setBounds(55, 80, 48, 14);
		contentPane.add(lblSearchFor);
		
		JLabel lblSearchCriteria = new JLabel("Criteria");
		lblSearchCriteria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchCriteria.setBounds(433, 80, 48, 14);
		contentPane.add(lblSearchCriteria);
		
		txtArtist2 = new JTextField();
		txtArtist2.setColumns(10);
		txtArtist2.setBounds(330, 210, 200, 20);
		contentPane.add(txtArtist2);
		
		txtArtist3 = new JTextField();
		txtArtist3.setColumns(10);
		txtArtist3.setBounds(330, 240, 200, 20);
		contentPane.add(txtArtist3);
		
		txtArtist4 = new JTextField();
		txtArtist4.setColumns(10);
		txtArtist4.setBounds(330, 270, 200, 20);
		contentPane.add(txtArtist4);
		
		txtArtist5 = new JTextField();
		txtArtist5.setColumns(10);
		txtArtist5.setBounds(330, 300, 200, 20);
		contentPane.add(txtArtist5);
		
		txtArtist6 = new JTextField();
		txtArtist6.setColumns(10);
		txtArtist6.setBounds(330, 330, 200, 20);
		contentPane.add(txtArtist6);
		
		txtArtist7 = new JTextField();
		txtArtist7.setColumns(10);
		txtArtist7.setBounds(330, 360, 200, 20);
		contentPane.add(txtArtist7);
		
		txtArtist8 = new JTextField();
		txtArtist8.setColumns(10);
		txtArtist8.setBounds(330, 390, 200, 20);
		contentPane.add(txtArtist8);
		
		txtArtist9 = new JTextField();
		txtArtist9.setColumns(10);
		txtArtist9.setBounds(330, 420, 200, 20);
		contentPane.add(txtArtist9);
		
		txtArtist10 = new JTextField();
		txtArtist10.setColumns(10);
		txtArtist10.setBounds(330, 450, 200, 20);
		contentPane.add(txtArtist10);
		
		txtGenre2 = new JTextField();
		txtGenre2.setColumns(10);
		txtGenre2.setBounds(560, 210, 150, 20);
		contentPane.add(txtGenre2);
		
		txtGenre3 = new JTextField();
		txtGenre3.setColumns(10);
		txtGenre3.setBounds(560, 240, 150, 20);
		contentPane.add(txtGenre3);
		
		txtGenre4 = new JTextField();
		txtGenre4.setColumns(10);
		txtGenre4.setBounds(560, 270, 150, 20);
		contentPane.add(txtGenre4);
		
		txtGenre5 = new JTextField();
		txtGenre5.setColumns(10);
		txtGenre5.setBounds(560, 300, 150, 20);
		contentPane.add(txtGenre5);
		
		txtGenre6 = new JTextField();
		txtGenre6.setColumns(10);
		txtGenre6.setBounds(560, 330, 150, 20);
		contentPane.add(txtGenre6);
		
		txtGenre7 = new JTextField();
		txtGenre7.setColumns(10);
		txtGenre7.setBounds(560, 360, 150, 20);
		contentPane.add(txtGenre7);
		
		txtGenre8 = new JTextField();
		txtGenre8.setColumns(10);
		txtGenre8.setBounds(560, 390, 150, 20);
		contentPane.add(txtGenre8);
		
		txtGenre9 = new JTextField();
		txtGenre9.setColumns(10);
		txtGenre9.setBounds(560, 420, 150, 20);
		contentPane.add(txtGenre9);
		
		txtGenre10 = new JTextField();
		txtGenre10.setColumns(10);
		txtGenre10.setBounds(560, 450, 150, 20);
		contentPane.add(txtGenre10);
		
		txtUploaded2 = new JTextField();
		txtUploaded2.setColumns(10);
		txtUploaded2.setBounds(740, 210, 100, 20);
		contentPane.add(txtUploaded2);
		
		txtUploaded3 = new JTextField();
		txtUploaded3.setColumns(10);
		txtUploaded3.setBounds(740, 240, 100, 20);
		contentPane.add(txtUploaded3);
		
		txtUploaded4 = new JTextField();
		txtUploaded4.setColumns(10);
		txtUploaded4.setBounds(740, 270, 100, 20);
		contentPane.add(txtUploaded4);
		
		txtUploaded5 = new JTextField();
		txtUploaded5.setColumns(10);
		txtUploaded5.setBounds(740, 300, 100, 20);
		contentPane.add(txtUploaded5);
		
		txtUploaded6 = new JTextField();
		txtUploaded6.setColumns(10);
		txtUploaded6.setBounds(740, 330, 100, 20);
		contentPane.add(txtUploaded6);
		
		txtUploaded7 = new JTextField();
		txtUploaded7.setColumns(10);
		txtUploaded7.setBounds(740, 360, 100, 20);
		contentPane.add(txtUploaded7);
		
		txtUploaded8 = new JTextField();
		txtUploaded8.setColumns(10);
		txtUploaded8.setBounds(740, 390, 100, 20);
		contentPane.add(txtUploaded8);
		
		txtUploaded9 = new JTextField();
		txtUploaded9.setColumns(10);
		txtUploaded9.setBounds(740, 420, 100, 20);
		contentPane.add(txtUploaded9);
		
		txtUploaded10 = new JTextField();
		txtUploaded10.setColumns(10);
		txtUploaded10.setBounds(740, 450, 100, 20);
		contentPane.add(txtUploaded10);
		
		btnView2 = new JButton("View");
		btnView2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID2.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView2.setEnabled(false);
		btnView2.setBounds(870, 210, 100, 20);
		contentPane.add(btnView2);
		
		btnView3 = new JButton("View");
		btnView3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID3.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView3.setEnabled(false);
		btnView3.setBounds(870, 239, 100, 20);
		contentPane.add(btnView3);
		
		btnView4 = new JButton("View");
		btnView4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID4.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView4.setEnabled(false);
		btnView4.setBounds(870, 269, 100, 20);
		contentPane.add(btnView4);
		
		btnView5 = new JButton("View");
		btnView5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID5.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView5.setEnabled(false);
		btnView5.setBounds(870, 299, 100, 20);
		contentPane.add(btnView5);
		
		btnView6 = new JButton("View");
		btnView6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID6.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView6.setEnabled(false);
		btnView6.setBounds(870, 330, 100, 20);
		contentPane.add(btnView6);
		
		btnView7 = new JButton("View");
		btnView7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID7.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView7.setEnabled(false);
		btnView7.setBounds(870, 359, 100, 20);
		contentPane.add(btnView7);
		
		btnView8 = new JButton("View");
		btnView8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID8.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView8.setEnabled(false);
		btnView8.setBounds(870, 389, 100, 20);
		contentPane.add(btnView8);
		
		btnView9 = new JButton("View");
		btnView9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID9.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView9.setEnabled(false);
		btnView9.setBounds(870, 419, 100, 20);
		contentPane.add(btnView9);
		
		btnView10 = new JButton("View");
		btnView10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewSongScreen mainScreen = new AdminViewSongScreen(currentAdmin, txtSongID10.getText());
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnView10.setEnabled(false);
		btnView10.setBounds(870, 449, 100, 20);
		contentPane.add(btnView10);
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount + 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset + 10);
				clearScreen();
				loadContent();
			}
		});
		btnNext.setBounds(532, 486, 89, 23);
		contentPane.add(btnNext);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount - 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset - 10);
				clearScreen();
				loadContent();
			}
		});
		btnPrevious.setBounds(340, 486, 89, 23);
		contentPane.add(btnPrevious);
		
		txtPage = new JTextField();
		txtPage.setBounds(453, 487, 50, 20);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
		
		btnMenu = new JButton("main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminMainMenuScreen mainScreen = new AdminMainMenuScreen(currentAdmin);
				mainScreen.setVisible(true);
				dispose();
				
			}
		});
		btnMenu.setBounds(425, 520, 89, 23);
		contentPane.add(btnMenu);
	}
	
	public void loadContent() {
		
		String songID = null;
		String title = null;
		String artist = null;
		String genre = null;
		String uploaded = null;
	
		
		txtPage.setText(String.valueOf(pageCount));

		int row = 1;
		
		if (sqlOffset > 9) {																											
		
			btnPrevious.setEnabled(true);
		
		}
		else 
		{																								
		
			btnPrevious.setEnabled(false);
		}
		
	
		ResultSet searchAttempt = AdminSQL.search(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem(),  sqlOffset, sqlRowCount);	
		
		
		try {		
			
		while (searchAttempt.next())																	
			{
	
			songID = searchAttempt.getString("SongID");
			title = searchAttempt.getString("Title");
			artist = searchAttempt.getString("Artist");
			genre = searchAttempt.getString("Genre");
			uploaded = searchAttempt.getString("uploaded");	
				
			switch (row) {
				case 1:
					txtSongID1.setText(songID);
					txtTitle1.setText(title);
					txtArtist1.setText(artist);
					txtGenre1.setText(genre);
					txtUploaded1.setText(uploaded);
					btnView1.setEnabled(true);
					break;
				case 2:
					txtSongID2.setText(songID);
					txtTitle2.setText(title);
					txtArtist2.setText(artist);
					txtGenre2.setText(genre);
					txtUploaded2.setText(uploaded);
					btnView2.setEnabled(true);
					break;
				case 3:
					txtSongID3.setText(songID);
					txtTitle3.setText(title);
					txtArtist3.setText(artist);
					txtGenre3.setText(genre);
					txtUploaded3.setText(uploaded);
					btnView3.setEnabled(true);
					break;
				case 4:
					txtSongID4.setText(songID);
					txtTitle4.setText(title);
					txtArtist4.setText(artist);
					txtGenre4.setText(genre);
					txtUploaded4.setText(uploaded);
					btnView4.setEnabled(true);
					break;
				case 5:
					txtSongID5.setText(songID);
					txtTitle5.setText(title);
					txtArtist5.setText(artist);
					txtGenre5.setText(genre);
					txtUploaded5.setText(uploaded);
					btnView5.setEnabled(true);
					break;
				case 6:
					txtSongID6.setText(songID);
					txtTitle6.setText(title);
					txtArtist6.setText(artist);
					txtGenre6.setText(genre);
					txtUploaded6.setText(uploaded);
					btnView6.setEnabled(true);
					break;
				case 7:
					txtSongID7.setText(songID);
					txtTitle7.setText(title);
					txtArtist7.setText(artist);
					txtGenre7.setText(genre);
					txtUploaded7.setText(uploaded);
					btnView7.setEnabled(true);
					break;
				case 8:
					txtSongID8.setText(songID);
					txtTitle8.setText(title);
					txtArtist8.setText(artist);
					txtGenre8.setText(genre);
					txtUploaded8.setText(uploaded);
					btnView8.setEnabled(true);
					break;
				case 9:
					txtSongID9.setText(songID);
					txtTitle9.setText(title);
					txtArtist9.setText(artist);
					txtGenre9.setText(genre);
					txtUploaded9.setText(uploaded);
					btnView9.setEnabled(true);
					break;
				case 10:
					txtSongID10.setText(songID);
					txtTitle10.setText(title);
					txtArtist10.setText(artist);
					txtGenre10.setText(genre);
					txtUploaded10.setText(uploaded);
					btnView10.setEnabled(true);
					btnNext.setEnabled(true);
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
	
	public void clearScreen() {
		
		btnNext.setEnabled(false);
		btnPrevious.setEnabled(false);

		txtTitle1.setText("");
		txtArtist1.setText("");
		txtGenre1.setText("");
		txtUploaded1.setText("");
		txtSongID1.setText("");
		btnView1.setEnabled(false);

		txtTitle2.setText("");
		txtArtist2.setText("");
		txtGenre2.setText("");
		txtUploaded2.setText("");
		txtSongID2.setText("");
		btnView2.setEnabled(false);
		
		txtTitle3.setText("");
		txtArtist3.setText("");
		txtGenre3.setText("");
		txtUploaded3.setText("");
		txtSongID3.setText("");
		btnView3.setEnabled(false);
		
		txtTitle4.setText("");
		txtArtist4.setText("");
		txtGenre4.setText("");
		txtUploaded4.setText("");
		txtSongID4.setText("");
		btnView4.setEnabled(false);
		
		txtTitle5.setText("");
		txtArtist5.setText("");
		txtGenre5.setText("");
		txtUploaded5.setText("");
		txtSongID5.setText("");
		btnView5.setEnabled(false);
		
		txtTitle6.setText("");
		txtArtist6.setText("");
		txtGenre6.setText("");
		txtUploaded6.setText("");
		txtSongID6.setText("");
		btnView6.setEnabled(false);
		
		txtTitle7.setText("");
		txtArtist7.setText("");
		txtGenre7.setText("");
		txtUploaded7.setText("");
		txtSongID7.setText("");
		btnView7.setEnabled(false);
		
		txtTitle8.setText("");
		txtArtist8.setText("");
		txtGenre8.setText("");
		txtUploaded8.setText("");
		txtSongID8.setText("");
		btnView8.setEnabled(false);
		
		txtTitle9.setText("");
		txtArtist9.setText("");
		txtGenre9.setText("");
		txtUploaded9.setText("");
		txtSongID9.setText("");
		btnView9.setEnabled(false);
		
		txtTitle10.setText("");
		txtArtist10.setText("");
		txtGenre10.setText("");
		txtUploaded10.setText("");
		txtSongID10.setText("");
		btnView10.setEnabled(false);

	}
}
