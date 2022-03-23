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
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToggleButton;

public class ManagePlaylistScreen extends JFrame {

	private JPanel contentPane;
	private static JTextField txtPlaylistTitle;
	private JTextField txtTitle1;
	private JTextField txtArtist1;
	private JTextField txtGenre1;
	private JTextField txtTitle2;
	private JTextField txtArtist2;
	private JTextField txtGenre2;

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


	private JTextField txtID2;
	private JTextField txtID3;
	private JTextField txtID4;
	private JTextField txtID5;
	private JTextField txtID6;
	private JTextField txtID7;
	private JTextField txtID8;
	private JTextField txtID9;
	private JTextField txtID10;
	
	private JButton btnRemove1;
	private JButton btnRemove2;
	private JButton btnRemove3;
	private JButton btnRemove4;
	private JButton btnRemove5;
	private JButton btnRemove6;
	private JButton btnRemove7;
	private JButton btnRemove8;
	private JButton btnRemove9;
	private JButton btnRemove10;
	
	private JButton btnAdd1;
	private JButton btnAdd2;
	private JButton btnAdd3;
	private JButton btnAdd4;
	private JButton btnAdd5;
	private JButton btnAdd6;
	private JButton btnAdd7;
	private JButton btnAdd8;
	private JButton btnAdd9;
	private JButton btnAdd10;
	
	private JButton btnUp2;
	private JButton btnUp3;
	private JButton btnUp4;
	private JButton btnUp5;
	private JButton btnUp6;
	private JButton btnUp7;
	private JButton btnUp8;
	private JButton btnUp9;
	private JButton btnUp10;
	
	private JButton btnDown1;
	private JButton btnDown2;
	private JButton btnDown3;
	private JButton btnDown4;
	private JButton btnDown5;
	private JButton btnDown6;
	private JButton btnDown7;
	private JButton btnDown8;
	private JButton btnDown9;

	private JButton btnRename;
	
	private JLabel lblTitle;
	private JLabel lblArtist;
	private JLabel lblGenre;
	private JLabel lblRating;
	private JLabel lblRanking;
	private JLabel lblElencoManage;


	public ManagePlaylistScreen(LoggedIn currentLoggedIn, PlaylistInfo currentPlaylistInfo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Manage Playlist");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
					clearScreen();
					loadContent(currentPlaylistInfo, currentLoggedIn);
					System.out.println(currentPlaylistInfo.getCurrentPlaylistTitle() + currentPlaylistInfo.getCurrentPlaylistID());

			}
	
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 666);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlaylistTitle = new JTextField();
		txtPlaylistTitle.setBounds(260, 130, 150, 25);
		contentPane.add(txtPlaylistTitle);
		txtPlaylistTitle.setColumns(10);
		
		JLabel lblPlaylistTitle = new JLabel("Playlist Title");
		lblPlaylistTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblPlaylistTitle.setBounds(160, 130, 100, 25);
		lblPlaylistTitle.setForeground(new Color(90, 192, 217));
		contentPane.add(lblPlaylistTitle);
		
		JLabel label1 = new JLabel("1");
		label1.setFont(new Font("Georgia", Font.BOLD, 12));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(new Color(90, 192, 217));
		label1.setBounds(21, 220, 48, 20);
		contentPane.add(label1);
		
		JLabel label10 = new JLabel("10");
		label10.setFont(new Font("Georgia", Font.BOLD, 12));
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setForeground(new Color(90, 192, 217));
		label10.setBounds(21, 490, 48, 20);
		contentPane.add(label10);
		
		JLabel label2 = new JLabel("2");
		label2.setFont(new Font("Georgia", Font.BOLD, 12));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(90, 192, 217));
		label2.setBounds(21, 250, 48, 20);
		contentPane.add(label2);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle1.setBounds(260, 220, 180, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist1.setBounds(470, 220, 150, 20);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre1.setBounds(650, 220, 100, 20);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		btnAdd1 = new JButton("Add");
		btnAdd1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 1);
				frame.setVisible(true);
				dispose();
			
			}
		});
		btnAdd1.setBounds(860, 220, 75, 20);
		contentPane.add(btnAdd1);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle2.setBounds(260, 250, 180, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		txtArtist2 = new JTextField();
		txtArtist2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist2.setBounds(470, 250, 150, 20);
		contentPane.add(txtArtist2);
		txtArtist2.setColumns(10);
		
		txtGenre2 = new JTextField();
		txtGenre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre2.setBounds(650, 250, 100, 20);
		contentPane.add(txtGenre2);
		txtGenre2.setColumns(10);
		
		btnRename = new JButton("Rename");
		btnRename.setEnabled(false);
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Helper.checkPlaylistTitle(txtPlaylistTitle.getText().strip()))
				{
					JOptionPane.showMessageDialog(null, "Valid Playlist Title Input Required - No Use Of Banned Special Characters", "Elenco - Invalid Playlist Title", JOptionPane.ERROR_MESSAGE,null);
				}
				else
				{
					ResultSet checkPlaylist = MySQLQueries.playlistTitleExists(currentLoggedIn.getCurrentUserID(), txtPlaylistTitle.getText().strip());
				
					try {
						if (checkPlaylist.next()) {
							System.out.println("Playlist title exists for userID");
							JOptionPane.showMessageDialog(null, "You Already Have A Playlist Using This Title", "Elenco - Duplicate Playlist Title", JOptionPane.ERROR_MESSAGE,null);
						}
						else
						{
							System.out.println("Playlist title does not exists for userID");
							MySQLQueries.updatePlaylistTitle(currentLoggedIn.getCurrentUserID(), currentPlaylistInfo.getCurrentPlaylistTitle(), txtPlaylistTitle.getText().strip());
							JOptionPane.showMessageDialog(null, "Playlist Title Renamed", "Elenco - Successful Name Change", JOptionPane.INFORMATION_MESSAGE,null);
						}
				
					} catch (SQLException error) 
					{
					
					}
				}
			}
		});
		btnRename.setBounds(435, 130, 100, 25);
		contentPane.add(btnRename);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyPlaylistsScreen frame = new MyPlaylistsScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(445, 568, 100, 25);
		contentPane.add(btnBack);
		
		btnRemove1 = new JButton("Remove");
		btnRemove1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																											
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID1.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
			}
		});
		btnRemove1.setBounds(945, 220, 75, 20);
		contentPane.add(btnRemove1);
		
		txtTitle3 = new JTextField();
		txtTitle3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle3.setBounds(260, 280, 180, 20);
		contentPane.add(txtTitle3);
		txtTitle3.setColumns(10);
		
		txtArtist3 = new JTextField();
		txtArtist3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist3.setBounds(470, 280, 150, 20);
		contentPane.add(txtArtist3);
		txtArtist3.setColumns(10);
		
		txtGenre3 = new JTextField();
		txtGenre3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre3.setBounds(650, 280, 100, 20);
		contentPane.add(txtGenre3);
		txtGenre3.setColumns(10);
		
		txtTitle4 = new JTextField();
		txtTitle4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle4.setBounds(260, 310, 180, 20);
		contentPane.add(txtTitle4);
		txtTitle4.setColumns(10);
		
		txtArtist4 = new JTextField();
		txtArtist4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist4.setBounds(470, 310, 150, 20);
		contentPane.add(txtArtist4);
		txtArtist4.setColumns(10);
		
		txtGenre4 = new JTextField();
		txtGenre4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre4.setBounds(650, 310, 100, 20);
		contentPane.add(txtGenre4);
		txtGenre4.setColumns(10);
		
		txtTitle5 = new JTextField();
		txtTitle5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle5.setBounds(260, 340, 180, 20);
		contentPane.add(txtTitle5);
		txtTitle5.setColumns(10);
		
		txtArtist5 = new JTextField();
		txtArtist5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist5.setBounds(470, 340, 150, 20);
		contentPane.add(txtArtist5);
		txtArtist5.setColumns(10);
		
		txtGenre5 = new JTextField();
		txtGenre5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre5.setBounds(650, 340, 100, 20);
		contentPane.add(txtGenre5);
		txtGenre5.setColumns(10);
		
		txtTitle6 = new JTextField();
		txtTitle6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle6.setBounds(260, 370, 180, 20);
		contentPane.add(txtTitle6);
		txtTitle6.setColumns(10);
		
		txtArtist6 = new JTextField();
		txtArtist6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist6.setBounds(470, 370, 150, 20);
		contentPane.add(txtArtist6);
		txtArtist6.setColumns(10);
		
		txtGenre6 = new JTextField();
		txtGenre6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre6.setBounds(650, 370, 100, 20);
		contentPane.add(txtGenre6);
		txtGenre6.setColumns(10);
		
		txtTitle7 = new JTextField();
		txtTitle7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle7.setBounds(260, 400, 180, 20);
		contentPane.add(txtTitle7);
		txtTitle7.setColumns(10);
		
		txtTitle8 = new JTextField();
		txtTitle8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle8.setBounds(260, 430, 180, 20);
		contentPane.add(txtTitle8);
		txtTitle8.setColumns(10);
		
		txtTitle9 = new JTextField();
		txtTitle9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle9.setBounds(260, 460, 180, 20);
		contentPane.add(txtTitle9);
		txtTitle9.setColumns(10);
		
		txtTitle10 = new JTextField();
		txtTitle10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtTitle10.setBounds(260, 490, 180, 20);
		contentPane.add(txtTitle10);
		txtTitle10.setColumns(10);
		
		txtArtist7 = new JTextField();
		txtArtist7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist7.setBounds(470, 400, 150, 20);
		contentPane.add(txtArtist7);
		txtArtist7.setColumns(10);
		
		txtArtist8 = new JTextField();
		txtArtist8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist8.setBounds(470, 430, 150, 20);
		contentPane.add(txtArtist8);
		txtArtist8.setColumns(10);
		
		txtArtist9 = new JTextField();
		txtArtist9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist9.setBounds(470, 460, 150, 20);
		contentPane.add(txtArtist9);
		txtArtist9.setColumns(10);
		
		txtArtist10 = new JTextField();
		txtArtist10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist10.setBounds(470, 490, 150, 20);
		contentPane.add(txtArtist10);
		txtArtist10.setColumns(10);
		
		txtGenre7 = new JTextField();
		txtGenre7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre7.setBounds(650, 400, 100, 20);
		contentPane.add(txtGenre7);
		txtGenre7.setColumns(10);
		
		txtGenre8 = new JTextField();
		txtGenre8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre8.setBounds(650, 430, 100, 20);
		contentPane.add(txtGenre8);
		txtGenre8.setColumns(10);
		
		txtGenre9 = new JTextField();
		txtGenre9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre9.setBounds(650, 460, 100, 20);
		contentPane.add(txtGenre9);
		txtGenre9.setColumns(10);
		
		txtGenre10 = new JTextField();
		txtGenre10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre10.setBounds(650, 490, 100, 20);
		contentPane.add(txtGenre10);
		txtGenre10.setColumns(10);
		
		txtRating1 = new JTextField();
		txtRating1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating1.setBounds(780, 220, 50, 20);
		contentPane.add(txtRating1);
		txtRating1.setColumns(10);
		
		txtRating2 = new JTextField();
		txtRating2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating2.setBounds(780, 250, 50, 20);
		contentPane.add(txtRating2);
		txtRating2.setColumns(10);
		
		txtRating3 = new JTextField();
		txtRating3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating3.setBounds(780, 280, 50, 20);
		contentPane.add(txtRating3);
		txtRating3.setColumns(10);
		
		txtRating4 = new JTextField();
		txtRating4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating4.setBounds(780, 310, 50, 20);
		contentPane.add(txtRating4);
		txtRating4.setColumns(10);
		
		txtRating5 = new JTextField();
		txtRating5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating5.setBounds(780, 340, 50, 20);
		contentPane.add(txtRating5);
		txtRating5.setColumns(10);
		
		txtRating6 = new JTextField();
		txtRating6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating6.setBounds(780, 370, 50, 20);
		contentPane.add(txtRating6);
		txtRating6.setColumns(10);
		
		txtRating7 = new JTextField();
		txtRating7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating7.setBounds(780, 400, 50, 20);
		contentPane.add(txtRating7);
		txtRating7.setColumns(10);
		
		txtRating8 = new JTextField();
		txtRating8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating8.setBounds(780, 430, 50, 20);
		contentPane.add(txtRating8);
		txtRating8.setColumns(10);
		
		txtRating9 = new JTextField();
		txtRating9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating9.setBounds(780, 460, 50, 20);
		contentPane.add(txtRating9);
		txtRating9.setColumns(10);
		
		txtRating10 = new JTextField();
		txtRating10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRating10.setBounds(780, 490, 50, 20);
		contentPane.add(txtRating10);
		txtRating10.setColumns(10);
		
		txtID1 = new JTextField();
		txtID1.setVisible(false);
		txtID1.setBounds(1030, 220, 25, 20);
	
		contentPane.add(txtID1);
		txtID1.setColumns(10);
		
		btnAdd2 = new JButton("Add");
		btnAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 2);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd2.setBounds(860, 250, 75, 20);
		contentPane.add(btnAdd2);
		
		btnRemove2 = new JButton("Remove");
		btnRemove2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);		
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID2.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
			}
		});
		btnRemove2.setBounds(945, 250, 75, 20);
		contentPane.add(btnRemove2);
		
		txtID2 = new JTextField();
		txtID2.setVisible(false);
		txtID2.setBounds(1030, 250, 25, 20);
		contentPane.add(txtID2);
		txtID2.setColumns(10);
		
		btnDown1 = new JButton("Down");
		btnDown1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MySQLQueries.swapRanking( txtID2.getText(), txtID1.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
			
			}
		});
		btnDown1.setBounds(160, 220, 75, 20);
		contentPane.add(btnDown1);
		
		btnUp2 = new JButton("Up");
		btnUp2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MySQLQueries.swapRanking( txtID2.getText(), txtID1.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
			}
		});
		btnUp2.setBounds(75, 250, 75, 20);
		contentPane.add(btnUp2);
		
		btnAdd3 = new JButton("Add");
		btnAdd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 3);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd3.setBounds(860, 280, 75, 20);
		contentPane.add(btnAdd3);
		
		 btnRemove3 = new JButton("Remove");
		 btnRemove3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID3.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove3.setBounds(945, 280, 75, 20);
		contentPane.add(btnRemove3);
		
		btnAdd4 = new JButton("Add");
		btnAdd4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 4);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd4.setBounds(860, 310, 75, 20);
		contentPane.add(btnAdd4);
		
		btnRemove4 = new JButton("Remove");
		btnRemove4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID4.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove4.setBounds(945, 310, 75, 20);
		contentPane.add(btnRemove4);
		
		btnAdd5 = new JButton("Add");
		btnAdd5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 5);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd5.setBounds(860, 340, 75, 20);
		contentPane.add(btnAdd5);
		
		btnRemove5 = new JButton("Remove");
		btnRemove5.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																											
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID5.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove5.setBounds(945, 340, 75, 20);
		contentPane.add(btnRemove5);
		
		btnAdd6 = new JButton("Add");
		btnAdd6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 6);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd6.setBounds(860, 370, 75, 20);
		contentPane.add(btnAdd6);
		
		btnRemove6 = new JButton("Remove");
		btnRemove6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID6.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove6.setBounds(945, 370, 75, 20);
		contentPane.add(btnRemove6);
		
		btnAdd7 = new JButton("Add");
		btnAdd7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 7);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnAdd7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd7.setBounds(860, 400, 75, 20);
		contentPane.add(btnAdd7);
		
		btnRemove7 = new JButton("Remove");
		btnRemove7.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID7.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove7.setBounds(945, 400, 75, 20);
		contentPane.add(btnRemove7);
		
		btnAdd8 = new JButton("Add");
		btnAdd8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 8);
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnAdd8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd8.setBounds(860, 430, 75, 20);
		contentPane.add(btnAdd8);
		
		btnAdd9 = new JButton("Add");
		btnAdd9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 9);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd9.setBounds(860, 460, 75, 20);
		contentPane.add(btnAdd9);
		
		btnAdd10 = new JButton("Add");
		btnAdd10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddToPlaylistScreen frame = new AddToPlaylistScreen(currentLoggedIn, currentPlaylistInfo, 10);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdd10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAdd10.setBounds(860, 490, 75, 20);
		contentPane.add(btnAdd10);
		
		btnRemove8 = new JButton("Remove");
		btnRemove8.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID8.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove8.setBounds(945, 430, 75, 20);
		contentPane.add(btnRemove8);
		
		btnRemove9 = new JButton("Remove");
		btnRemove9.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID9.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove9.setBounds(945, 460, 75, 20);
		contentPane.add(btnRemove9);
		
		btnRemove10 = new JButton("Remove");
		btnRemove10.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Remove Song From Playlist?", "Elenco - Remove Song?", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
				if (select == JOptionPane.YES_OPTION) {	
					MySQLQueries.removeFromList(currentLoggedIn.getCurrentUserID(), txtID10.getText());
					loadContent(currentPlaylistInfo, currentLoggedIn) ;
				}
		 	}
		 });
		btnRemove10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnRemove10.setBounds(945, 490, 75, 20);
		contentPane.add(btnRemove10);
		
		txtID3 = new JTextField();
		txtID3.setVisible(false);
		txtID3.setBounds(1030, 279, 25, 20);
		contentPane.add(txtID3);
		txtID3.setColumns(10);
		
		txtID4 = new JTextField();
		txtID4.setVisible(false);
		txtID4.setBounds(1030, 309, 25, 20);
		contentPane.add(txtID4);
		txtID4.setColumns(10);
		
		txtID5 = new JTextField();
		txtID5.setVisible(false);
		txtID5.setBounds(1030, 340, 25, 20);
		contentPane.add(txtID5);
		txtID5.setColumns(10);
		
		txtID6 = new JTextField();
		txtID6.setVisible(false);
		txtID6.setBounds(1030, 369, 25, 20);
		contentPane.add(txtID6);
		txtID6.setColumns(10);
		
		txtID7 = new JTextField();
		txtID7.setVisible(false);
		txtID7.setBounds(1030, 399, 25, 20);
		contentPane.add(txtID7);
		txtID7.setColumns(10);
		
		txtID8 = new JTextField();
		txtID8.setVisible(false);
		txtID8.setBounds(1030, 429, 25, 20);
		contentPane.add(txtID8);
		txtID8.setColumns(10);
		
		txtID9 = new JTextField();
		txtID9.setVisible(false);
		txtID9.setBounds(1030, 459, 25, 20);
		contentPane.add(txtID9);
		txtID9.setColumns(10);
		
		txtID10 = new JTextField();
		txtID10.setVisible(false);
		txtID10.setBounds(1030, 490, 25, 20);
		contentPane.add(txtID10);
		txtID10.setColumns(10);
		
		btnUp3 = new JButton("Up");
		btnUp3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	
		 		MySQLQueries.swapRanking( txtID3.getText(), txtID2.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp3.setBounds(75, 280, 75, 20);
		contentPane.add(btnUp3);
		
		btnUp4 = new JButton("Up");
		btnUp4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	
		 		MySQLQueries.swapRanking( txtID4.getText(), txtID3.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp4.setBounds(75, 310, 75, 20);
		contentPane.add(btnUp4);
		
		btnUp5 = new JButton("Up");
		btnUp5.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID5.getText(), txtID4.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp5.setBounds(75, 340, 75, 20);
		contentPane.add(btnUp5);
		
		btnUp6 = new JButton("Up");
		btnUp6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {		
		 		MySQLQueries.swapRanking( txtID6.getText(), txtID5.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp6.setBounds(75, 370, 75, 20);
		contentPane.add(btnUp6);
		
		btnUp7 = new JButton("Up");
		btnUp7.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID7.getText(), txtID6.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp7.setBounds(75, 400, 75, 20);
		contentPane.add(btnUp7);
		
		btnUp8 = new JButton("Up");
		btnUp8.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID8.getText(), txtID7.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp8.setBounds(75, 430, 75, 20);
		contentPane.add(btnUp8);
		
		btnUp9 = new JButton("Up");
		btnUp9.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID9.getText(), txtID8.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp9.setBounds(75, 460, 75, 20);
		contentPane.add(btnUp9);
		
		btnUp10 = new JButton("Up");
		btnUp10.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	
		 		MySQLQueries.swapRanking( txtID10.getText(), txtID9.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnUp10.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUp10.setBounds(75, 490, 75, 20);
		contentPane.add(btnUp10);
		
		btnDown2 = new JButton("Down");
		btnDown2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	
		 		MySQLQueries.swapRanking( txtID3.getText(), txtID2.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown2.setBounds(160, 250, 75, 20);
		contentPane.add(btnDown2);
		
		btnDown3 = new JButton("Down");
		btnDown3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) { 		
		 		MySQLQueries.swapRanking( txtID4.getText(), txtID3.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown3.setBounds(160, 280, 75, 20);
		contentPane.add(btnDown3);
		
		btnDown4 = new JButton("Down");
		btnDown4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	 		
		 		MySQLQueries.swapRanking( txtID5.getText(), txtID4.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown4.setBounds(160, 310, 75, 20);
		contentPane.add(btnDown4);
		
		btnDown5 = new JButton("Down");
		btnDown5.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID6.getText(), txtID5.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown5.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown5.setBounds(160, 340, 75, 20);
		contentPane.add(btnDown5);
		
		btnDown6 = new JButton("Down");
		btnDown6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID7.getText(), txtID6.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown6.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown6.setBounds(160, 370, 75, 20);
		contentPane.add(btnDown6);
		
		btnDown7 = new JButton("Down");
		btnDown7.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID8.getText(), txtID7.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown7.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown7.setBounds(160, 400, 75, 20);
		contentPane.add(btnDown7);
		
		btnDown8 = new JButton("Down");
		btnDown8.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		MySQLQueries.swapRanking( txtID9.getText(), txtID8.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
		 	}
		 });
		btnDown8.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown8.setBounds(160, 430, 75, 20);
		contentPane.add(btnDown8);
		
		btnDown9 = new JButton("Down");
		btnDown9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLQueries.swapRanking( txtID10.getText(), txtID9.getText());
				loadContent(currentPlaylistInfo, currentLoggedIn) ;
			}
		});
		btnDown9.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnDown9.setBounds(160, 460, 75, 20);
		contentPane.add(btnDown9);
		
		JLabel label3 = new JLabel("3");
		label3.setFont(new Font("Georgia", Font.BOLD, 12));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(new Color(90, 192, 217));
		label3.setBounds(21, 280, 48, 20);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("4");
		label4.setFont(new Font("Georgia", Font.BOLD, 12));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setForeground(new Color(90, 192, 217));
		label4.setBounds(21, 310, 48, 20);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("5");
		label5.setFont(new Font("Georgia", Font.BOLD, 12));
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setForeground(new Color(90, 192, 217));
		label5.setBounds(21, 340, 48, 20);
		contentPane.add(label5);
		
		JLabel label6 = new JLabel("6");
		label6.setFont(new Font("Georgia", Font.BOLD, 12));
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setForeground(new Color(90, 192, 217));
		label6.setBounds(21, 370, 48, 20);
		contentPane.add(label6);
		
		JLabel label7 = new JLabel("7");
		label7.setFont(new Font("Georgia", Font.BOLD, 12));
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setForeground(new Color(90, 192, 217));
		label7.setBounds(21, 400, 48, 20);
		contentPane.add(label7);
		
		JLabel label8 = new JLabel("8");
		label8.setFont(new Font("Georgia", Font.BOLD, 12));
		label8.setForeground(new Color(90, 192, 217));
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setBounds(21, 430, 48, 20);
		contentPane.add(label8);
		
		JLabel label9 = new JLabel("9");
		label9.setFont(new Font("Georgia", Font.BOLD, 12));
		label9.setForeground(new Color(90, 192, 217));
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setBounds(21, 460, 48, 20);
		contentPane.add(label9);
		
		lblTitle = new JLabel("Title");
		lblTitle.setForeground(new Color(90, 192, 217));
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblTitle.setBounds(260, 200, 50, 20);
		contentPane.add(lblTitle);
		
		lblArtist = new JLabel("Artist");
		lblArtist.setForeground(new Color(90, 192, 217));
		lblArtist.setFont(new Font("Georgia", Font.BOLD, 12));
		lblArtist.setBounds(466, 200, 50, 20);
		contentPane.add(lblArtist);
		
		lblGenre = new JLabel("Genre");
		lblGenre.setForeground(new Color(90, 192, 217));
		lblGenre.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGenre.setBounds(650, 200, 50, 20);
		contentPane.add(lblGenre);
		
		lblRating = new JLabel("Rating");
		lblRating.setForeground(new Color(90, 192, 217));
		lblRating.setFont(new Font("Georgia", Font.BOLD, 12));
		lblRating.setBounds(780, 200, 50, 20);
		contentPane.add(lblRating);
		
		lblRanking = new JLabel("Ranking");
		lblRanking.setForeground(new Color(90, 192, 217));
		lblRanking.setFont(new Font("Georgia", Font.BOLD, 12));
		lblRanking.setBounds(21, 200, 100, 20);
		contentPane.add(lblRanking);
		
		lblElencoManage = new JLabel("Elenco - Manage Playlist");
		lblElencoManage.setHorizontalAlignment(SwingConstants.CENTER);
		lblElencoManage.setForeground(new Color(90, 192, 217));
		lblElencoManage.setFont(new Font("Georgia", Font.BOLD, 24));
		lblElencoManage.setBounds(373, 51, 300, 25);
		contentPane.add(lblElencoManage);
	}
	
	
	
	public void loadContent( PlaylistInfo currentPlaylistInfo, LoggedIn currentLoggedIn){
		
		clearScreen();	
	
		String currentPlaylistTitle = null;
		ResultSet getCurrentPlaylistTitle = MySQLQueries.getCurrentPlaylistTitle(currentPlaylistInfo.getCurrentPlaylistID());
	
		try 
		{
		
			while (getCurrentPlaylistTitle.next()) {
				
				currentPlaylistTitle = getCurrentPlaylistTitle.getString("PlaylistTitle");
				
			}
		}
		catch (Exception error)
		{
			
		}
		
		ResultSet currentList = MySQLQueries.loadAPlaylist(currentPlaylistTitle, currentLoggedIn.getCurrentUserID());
		
		String playlistTitle = null;
		String playlistId = null;
		String title = null;
		String artist = null;
		String genre = null;
		String rating = null;
		int ranking;
		
		try {
			
						
			while (currentList.next()){
						
				playlistTitle = currentList.getString("PlaylistTitle");
				txtPlaylistTitle.setText(playlistTitle);
							
				System.out.println(playlistTitle);
							
				playlistId = currentList.getString("PlaylistID");
				ranking = currentList.getInt("Ranking");
				title = currentList.getString("Title");
				artist = currentList.getString("Artist");
				genre = currentList.getString("Genre");
				rating = currentList.getString("OverallRating");
							
				currentPlaylistInfo.setCurrentPlaylistTitle(playlistTitle);
							
				if (playlistTitle != null || playlistTitle != "")	
				{
					btnRename.setEnabled(true);
				}
					
							
				switch (ranking) {
					case 1:
						
						txtID1.setText(playlistId);
						txtTitle1.setText(title);
						txtArtist1.setText(artist);
						txtGenre1.setText(genre);
						txtRating1.setText(rating);
						btnAdd1.setEnabled(false);
						btnRemove1.setEnabled(true);
						btnDown1.setEnabled(true);
						break;
					case 2:
								
						txtID2.setText(playlistId);
						txtTitle2.setText(title);
						txtArtist2.setText(artist);
						txtGenre2.setText(genre);
						txtRating2.setText(rating);
						btnAdd2.setEnabled(false);
						btnRemove2.setEnabled(true);
								
						btnUp2.setEnabled(true);
						btnDown2.setEnabled(true);
						break;
					case 3:
						txtID3.setText(playlistId);
						txtTitle3.setText(title);
						txtArtist3.setText(artist);
						txtGenre3.setText(genre);
						txtRating3.setText(rating);
						btnAdd3.setEnabled(false);
						btnRemove3.setEnabled(true);
								
						btnUp3.setEnabled(true);
						btnDown3.setEnabled(true);
						break;
					case 4:
						txtID4.setText(playlistId);
						txtTitle4.setText(title);
						txtArtist4.setText(artist);
						txtGenre4.setText(genre);
						txtRating4.setText(rating);
						btnAdd4.setEnabled(false);
						btnRemove4.setEnabled(true);
								
						btnUp4.setEnabled(true);
						btnDown4.setEnabled(true);
						break;
					case 5:
						txtID5.setText(playlistId);
						txtTitle5.setText(title);
						txtArtist5.setText(artist);
						txtGenre5.setText(genre);
						txtRating5.setText(rating);
						btnAdd5.setEnabled(false);
						btnRemove5.setEnabled(true);
								
						btnUp5.setEnabled(true);
						btnDown5.setEnabled(true);
						break;
					case 6:
						txtID6.setText(playlistId);
						txtTitle6.setText(title);
						txtArtist6.setText(artist);
						txtGenre6.setText(genre);
						txtRating6.setText(rating);
						btnAdd6.setEnabled(false);
						btnRemove6.setEnabled(true);
								
						btnUp6.setEnabled(true);
						btnDown6.setEnabled(true);
						break;
					case 7:
						txtID7.setText(playlistId);
						txtTitle7.setText(title);
						txtArtist7.setText(artist);
						txtGenre7.setText(genre);
						txtRating7.setText(rating);
						btnAdd7.setEnabled(false);
						btnRemove7.setEnabled(true);
								
						btnUp7.setEnabled(true);
						btnDown7.setEnabled(true);
						break;
					case 8:
						txtID8.setText(playlistId);
						txtTitle8.setText(title);
						txtArtist8.setText(artist);
						txtGenre8.setText(genre);
						txtRating8.setText(rating);
						btnAdd8.setEnabled(false);
						btnRemove8.setEnabled(true);
								
						btnUp8.setEnabled(true);
						btnDown8.setEnabled(true);
						break;
					case 9:
						txtID9.setText(playlistId);
						txtTitle9.setText(title);
						txtArtist9.setText(artist);
						txtGenre9.setText(genre);
						txtRating9.setText(rating);
						btnAdd9.setEnabled(false);
						btnRemove9.setEnabled(true);
								
						btnUp9.setEnabled(true);
						btnDown9.setEnabled(true);
						break;
					case 10:
						txtID10.setText(playlistId);
						txtTitle10.setText(title);
						txtArtist10.setText(artist);
						txtGenre10.setText(genre);
						txtRating10.setText(rating);
						btnAdd10.setEnabled(false);
						btnRemove10.setEnabled(true);
								
						btnUp10.setEnabled(true);
						
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
							
		btnDown1.setEnabled(false);
								
		txtID2.setText("");
		txtTitle2.setText("");
		txtArtist2.setText("");
		txtGenre2.setText("");
		txtRating2.setText("");
		btnAdd2.setEnabled(true);
		btnRemove2.setEnabled(false);
		btnUp2.setEnabled(false);
		btnDown2.setEnabled(false);
								
		txtID3.setText("");
		txtTitle3.setText("");
		txtArtist3.setText("");
		txtGenre3.setText("");
		txtRating3.setText("");
		btnAdd3.setEnabled(true);
		btnRemove3.setEnabled(false);
		btnUp3.setEnabled(false);
		btnDown3.setEnabled(false);
								
		txtID4.setText("");
		txtTitle4.setText("");
		txtArtist4.setText("");
		txtGenre4.setText("");
		txtRating4.setText("");
		btnAdd4.setEnabled(true);
		btnRemove4.setEnabled(false);
		btnUp4.setEnabled(false);
		btnDown4.setEnabled(false);
								
		txtID5.setText("");
		txtTitle5.setText("");
		txtArtist5.setText("");
		txtGenre5.setText("");
		txtRating5.setText("");
		btnAdd5.setEnabled(true);
		btnRemove5.setEnabled(false);
		btnUp5.setEnabled(false);
		btnDown5.setEnabled(false);
								
		txtID6.setText("");
		txtTitle6.setText("");
		txtArtist6.setText("");
		txtGenre6.setText("");
		txtRating6.setText("");
		btnAdd6.setEnabled(true);
		btnRemove6.setEnabled(false);
		btnUp6.setEnabled(false);
		btnDown6.setEnabled(false);
								
		txtID7.setText("");
		txtTitle7.setText("");
		txtArtist7.setText("");
		txtGenre7.setText("");
		txtRating7.setText("");
		btnAdd7.setEnabled(true);
		btnRemove7.setEnabled(false);
		btnUp7.setEnabled(false);
		btnDown7.setEnabled(false);
								
		txtID8.setText("");
		txtTitle8.setText("");
		txtArtist8.setText("");
		txtGenre8.setText("");
		txtRating8.setText("");
		btnAdd8.setEnabled(true);
		btnRemove8.setEnabled(false);
		btnUp8.setEnabled(false);
		btnDown8.setEnabled(false);
								
		txtID9.setText("");
		txtTitle9.setText("");
		txtArtist9.setText("");
		txtGenre9.setText("");
		txtRating9.setText("");
		btnAdd9.setEnabled(true);
		btnRemove9.setEnabled(false);
		btnUp9.setEnabled(false);
		btnDown9.setEnabled(false);
								
		txtID10.setText("");
		txtTitle10.setText("");
		txtArtist10.setText("");
		txtGenre10.setText("");
		txtRating10.setText("");
		btnAdd10.setEnabled(true);
		btnRemove10.setEnabled(false);
		btnUp10.setEnabled(false);
									
	}
}
