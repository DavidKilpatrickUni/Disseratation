import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminSearchPlaylistScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle1;
	private JTextField txtUsername1;
	private JTextField txtPlaylistID1;
	private JTextField txtUsername2;
	private JTextField txtUsername3;
	private JTextField txtUsername4;
	private JTextField txtUsername5;
	private JTextField txtUsername6;
	private JTextField txtUsername7;
	private JTextField txtUsername8;
	private JTextField txtUsername9;
	private JTextField txtUsername10;
	private JTextField txtTitle2;
	private JTextField txtTitle3;
	private JTextField txtTitle4;
	private JTextField txtTitle5;
	private JTextField txtTitle6;
	private JTextField txtTitle7;
	private JTextField txtTitle8;
	private JTextField txtTitle9;
	private JTextField txtTitle10;
	private JTextField txtPlaylistID2;
	private JTextField txtPlaylistID3;
	private JTextField txtPlaylistID4;
	private JTextField txtPlaylistID5;
	private JTextField txtPlaylistID6;
	private JTextField txtPlaylistID7;
	private JTextField txtPlaylistID8;
	private JTextField txtPlaylistID9;
	private JTextField txtPlaylistID10;
	private JButton btnDelete1;
	private JButton btnDelete2;
	private JButton btnDelete3;
	private JButton btnDelete4;
	private JButton btnDelete5;
	private JButton btnDelete6;
	private JButton btnDelete7;
	private JButton btnDelete8;
	private JButton btnDelete9;
	private JButton btnDelete10;
	
	
	private JComboBox comboBoxSearch;
	private JComboBox comboBoxCriteria;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnMain;
	private JTextField txtPage;
	
	private int pageCount = 1;
	private int sqlOffset = 0;
	private int sqlRowCount = 10;
	private JLabel lblHeader;
	private JTextField txtUserID1;
	private JTextField txtUserID2;
	private JTextField txtUserID3;
	private JTextField txtUserID4;
	private JTextField txtUserID5;
	private JTextField txtUserID6;
	private JTextField txtUserID7;
	private JTextField txtUserID8;
	private JTextField txtUserID9;
	private JTextField txtUserID10;


	public AdminSearchPlaylistScreen(AdminLoggedIn currentAdmin) {
		setTitle("Admin - Search Playlists");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxSearch = new JComboBox();
		comboBoxSearch.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				
				
				comboBoxSearch.removeAllItems();
				
				if(comboBoxCriteria.getSelectedItem().toString().equals("UserName"))
				{
			
					ResultSet results = AdminSQL.popoulateWithUserName();
					try
					{
						
						while (results.next())
						{
							comboBoxSearch.addItem(results.getString(comboBoxCriteria.getSelectedItem().toString()));
						}
						
					} 
					catch (SQLException error) 
					{
			
					}
					
				}
				else
				{
					
					ResultSet results = AdminSQL.popoulateWithPlaylistTitle();
					try
					{
						
						while (results.next())
						{
							comboBoxSearch.addItem(results.getString(comboBoxCriteria.getSelectedItem().toString()));
						}
						
					} 
					catch (SQLException error)
					{
			
					}
				}
			}
		});
		comboBoxSearch.setBounds(84, 124, 150, 22);
		contentPane.add(comboBoxSearch);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"UserName", "PlaylistTitle"}));
		comboBoxCriteria.setBounds(361, 124, 100, 22);
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
		btnSearch.setBounds(496, 124, 89, 23);
		contentPane.add(btnSearch);
		
		btnDelete1 = new JButton("Delete");
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID1.getText(), txtTitle1.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
				
			}
		});
		btnDelete1.setBounds(485, 228, 100, 20);
		contentPane.add(btnDelete1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(26, 204, 100, 14);
		contentPane.add(lblUsername);
		
		JLabel lblTitle = new JLabel("Playlist Title");
		lblTitle.setBounds(261, 204, 100, 14);
		contentPane.add(lblTitle);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(261, 229, 200, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtUsername1 = new JTextField();
		txtUsername1.setBounds(26, 229, 200, 20);
		contentPane.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		txtPlaylistID1 = new JTextField();
		txtPlaylistID1.setVisible(false);
		txtPlaylistID1.setEditable(false);
		txtPlaylistID1.setBounds(599, 228, 25, 20);
		contentPane.add(txtPlaylistID1);
		txtPlaylistID1.setColumns(10);
		
		JLabel lblSearchFor = new JLabel("Search");
		lblSearchFor.setBounds(26, 128, 48, 14);
		contentPane.add(lblSearchFor);
		
		JLabel lblCriteria = new JLabel("Criteria");
		lblCriteria.setBounds(293, 128, 48, 14);
		contentPane.add(lblCriteria);
		
		txtUsername2 = new JTextField();
		txtUsername2.setColumns(10);
		txtUsername2.setBounds(26, 260, 200, 20);
		contentPane.add(txtUsername2);
		
		txtUsername3 = new JTextField();
		txtUsername3.setColumns(10);
		txtUsername3.setBounds(26, 291, 200, 20);
		contentPane.add(txtUsername3);
		
		txtUsername4 = new JTextField();
		txtUsername4.setColumns(10);
		txtUsername4.setBounds(26, 326, 200, 20);
		contentPane.add(txtUsername4);
		
		txtUsername5 = new JTextField();
		txtUsername5.setColumns(10);
		txtUsername5.setBounds(26, 359, 200, 20);
		contentPane.add(txtUsername5);
		
		txtUsername6 = new JTextField();
		txtUsername6.setColumns(10);
		txtUsername6.setBounds(26, 389, 200, 20);
		contentPane.add(txtUsername6);
		
		txtUsername7 = new JTextField();
		txtUsername7.setColumns(10);
		txtUsername7.setBounds(26, 420, 200, 20);
		contentPane.add(txtUsername7);
		
		txtUsername8 = new JTextField();
		txtUsername8.setColumns(10);
		txtUsername8.setBounds(26, 451, 200, 20);
		contentPane.add(txtUsername8);
		
		txtUsername9 = new JTextField();
		txtUsername9.setColumns(10);
		txtUsername9.setBounds(26, 483, 200, 20);
		contentPane.add(txtUsername9);
		
		txtUsername10 = new JTextField();
		txtUsername10.setColumns(10);
		txtUsername10.setBounds(26, 514, 200, 20);
		contentPane.add(txtUsername10);
		
		txtTitle2 = new JTextField();
		txtTitle2.setColumns(10);
		txtTitle2.setBounds(261, 260, 200, 20);
		contentPane.add(txtTitle2);
		
		txtTitle3 = new JTextField();
		txtTitle3.setColumns(10);
		txtTitle3.setBounds(261, 291, 200, 20);
		contentPane.add(txtTitle3);
		
		txtTitle4 = new JTextField();
		txtTitle4.setColumns(10);
		txtTitle4.setBounds(261, 326, 200, 20);
		contentPane.add(txtTitle4);
		
		txtTitle5 = new JTextField();
		txtTitle5.setColumns(10);
		txtTitle5.setBounds(261, 359, 200, 20);
		contentPane.add(txtTitle5);
		
		txtTitle6 = new JTextField();
		txtTitle6.setColumns(10);
		txtTitle6.setBounds(261, 389, 200, 20);
		contentPane.add(txtTitle6);
		
		txtTitle7 = new JTextField();
		txtTitle7.setColumns(10);
		txtTitle7.setBounds(261, 420, 200, 20);
		contentPane.add(txtTitle7);
		
		txtTitle8 = new JTextField();
		txtTitle8.setColumns(10);
		txtTitle8.setBounds(261, 451, 200, 20);
		contentPane.add(txtTitle8);
		
		txtTitle9 = new JTextField();
		txtTitle9.setColumns(10);
		txtTitle9.setBounds(261, 483, 200, 20);
		contentPane.add(txtTitle9);
		
		txtTitle10 = new JTextField();
		txtTitle10.setColumns(10);
		txtTitle10.setBounds(261, 514, 200, 20);
		contentPane.add(txtTitle10);
		
		btnDelete2 = new JButton("Delete");
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID2.getText(), txtTitle2.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete2.setBounds(485, 259, 100, 20);
		contentPane.add(btnDelete2);
		
		btnDelete3 = new JButton("Delete");
		btnDelete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID3.getText(), txtTitle3.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete3.setBounds(485, 290, 100, 20);
		contentPane.add(btnDelete3);
		
		btnDelete4 = new JButton("Delete");
		btnDelete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID4.getText(), txtTitle4.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete4.setBounds(485, 325, 100, 20);
		contentPane.add(btnDelete4);
		
		btnDelete5 = new JButton("Delete");
		btnDelete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID5.getText(), txtTitle5.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete5.setBounds(485, 358, 100, 20);
		contentPane.add(btnDelete5);
		
		btnDelete6 = new JButton("Delete");
		btnDelete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID6.getText(), txtTitle6.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete6.setBounds(485, 388, 100, 20);
		contentPane.add(btnDelete6);
		
		btnDelete7 = new JButton("Delete");
		btnDelete7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID7.getText(), txtTitle7.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete7.setBounds(485, 419, 100, 20);
		contentPane.add(btnDelete7);
		
		btnDelete8 = new JButton("Delete");
		btnDelete8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID8.getText(), txtTitle8.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete8.setBounds(485, 450, 100, 20);
		contentPane.add(btnDelete8);
		
		btnDelete9 = new JButton("Delete");
		btnDelete9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID9.getText(), txtTitle9.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete9.setBounds(485, 482, 100, 20);
		contentPane.add(btnDelete9);
		
		btnDelete10 = new JButton("Delete");
		btnDelete10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentAdmin.getAdminLevel() >1)
				{
		
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Playlist?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
					
						AdminSQL.deletePlaylist(txtUserID10.getText(), txtTitle10.getText());
					
						JOptionPane.showMessageDialog(null, "Successfully Deleted Playlist", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Admin Level Too Low To Do This Task", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
				}
			}
		});
		btnDelete10.setBounds(485, 513, 100, 20);
		contentPane.add(btnDelete10);
		
		txtPlaylistID2 = new JTextField();
		txtPlaylistID2.setVisible(false);
		txtPlaylistID2.setEditable(false);
		txtPlaylistID2.setColumns(10);
		txtPlaylistID2.setBounds(599, 259, 25, 20);
		contentPane.add(txtPlaylistID2);
		
		txtPlaylistID3 = new JTextField();
		txtPlaylistID3.setVisible(false);
		txtPlaylistID3.setEditable(false);
		txtPlaylistID3.setColumns(10);
		txtPlaylistID3.setBounds(599, 291, 25, 20);
		contentPane.add(txtPlaylistID3);
		
		txtPlaylistID4 = new JTextField();
		txtPlaylistID4.setVisible(false);
		txtPlaylistID4.setEditable(false);
		txtPlaylistID4.setColumns(10);
		txtPlaylistID4.setBounds(599, 326, 25, 20);
		contentPane.add(txtPlaylistID4);
		
		txtPlaylistID5 = new JTextField();
		txtPlaylistID5.setVisible(false);
		txtPlaylistID5.setEditable(false);
		txtPlaylistID5.setColumns(10);
		txtPlaylistID5.setBounds(599, 359, 25, 20);
		contentPane.add(txtPlaylistID5);
		
		txtPlaylistID6 = new JTextField();
		txtPlaylistID6.setVisible(false);
		txtPlaylistID6.setEditable(false);
		txtPlaylistID6.setColumns(10);
		txtPlaylistID6.setBounds(599, 389, 25, 20);
		contentPane.add(txtPlaylistID6);
		
		txtPlaylistID7 = new JTextField();
		txtPlaylistID7.setVisible(false);
		txtPlaylistID7.setEditable(false);
		txtPlaylistID7.setColumns(10);
		txtPlaylistID7.setBounds(599, 420, 25, 20);
		contentPane.add(txtPlaylistID7);
		
		txtPlaylistID8 = new JTextField();
		txtPlaylistID8.setVisible(false);
		txtPlaylistID8.setEditable(false);
		txtPlaylistID8.setColumns(10);
		txtPlaylistID8.setBounds(599, 451, 25, 20);
		contentPane.add(txtPlaylistID8);
		
		txtPlaylistID9 = new JTextField();
		txtPlaylistID9.setVisible(false);
		txtPlaylistID9.setEditable(false);
		txtPlaylistID9.setColumns(10);
		txtPlaylistID9.setBounds(599, 483, 25, 20);
		contentPane.add(txtPlaylistID9);
		
		txtPlaylistID10 = new JTextField();
		txtPlaylistID10.setVisible(false);
		txtPlaylistID10.setEditable(false);
		txtPlaylistID10.setColumns(10);
		txtPlaylistID10.setBounds(599, 514, 25, 20);
		contentPane.add(txtPlaylistID10);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount + 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset + 10);
				
				clearScreen();
				loadContent();
			}
		});
		btnNext.setEnabled(false);
		btnNext.setBounds(399, 562, 89, 23);
		contentPane.add(btnNext);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pageCount = (pageCount - 1);
				txtPage.setText(String.valueOf(pageCount));
				sqlOffset = (sqlOffset - 10);
				
				clearScreen();
				loadContent();
			}
		});
		btnPrevious.setEnabled(false);
		btnPrevious.setBounds(208, 562, 89, 23);
		contentPane.add(btnPrevious);
		
		btnMain = new JButton("Main Menu");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminMainMenuScreen mainScreen = new AdminMainMenuScreen(currentAdmin);
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnMain.setBounds(303, 606, 100, 23);
		contentPane.add(btnMain);
		
		txtPage = new JTextField();
		txtPage.setText("");
		txtPage.setBounds(324, 563, 50, 20);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
		
		lblHeader = new JLabel("Search Playlists");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHeader.setBounds(174, 30, 300, 50);
		contentPane.add(lblHeader);
		
		txtUserID1 = new JTextField();
		txtUserID1.setVisible(false);
		txtUserID1.setBounds(634, 228, 25, 20);
		contentPane.add(txtUserID1);
		txtUserID1.setColumns(10);
		
		txtUserID2 = new JTextField();
		txtUserID2.setVisible(false);
		txtUserID2.setColumns(10);
		txtUserID2.setBounds(634, 260, 25, 20);
		contentPane.add(txtUserID2);
		
		txtUserID3 = new JTextField();
		txtUserID3.setVisible(false);
		txtUserID3.setColumns(10);
		txtUserID3.setBounds(634, 291, 25, 20);
		contentPane.add(txtUserID3);
		
		txtUserID4 = new JTextField();
		txtUserID4.setVisible(false);
		txtUserID4.setColumns(10);
		txtUserID4.setBounds(634, 326, 25, 20);
		contentPane.add(txtUserID4);
		
		txtUserID5 = new JTextField();
		txtUserID5.setVisible(false);
		txtUserID5.setColumns(10);
		txtUserID5.setBounds(634, 359, 25, 20);
		contentPane.add(txtUserID5);
		
		txtUserID6 = new JTextField();
		txtUserID6.setVisible(false);
		txtUserID6.setColumns(10);
		txtUserID6.setBounds(634, 389, 25, 20);
		contentPane.add(txtUserID6);
		
		txtUserID7 = new JTextField();
		txtUserID7.setVisible(false);
		txtUserID7.setColumns(10);
		txtUserID7.setBounds(634, 420, 25, 20);
		contentPane.add(txtUserID7);
		
		txtUserID8 = new JTextField();
		txtUserID8.setVisible(false);
		txtUserID8.setColumns(10);
		txtUserID8.setBounds(634, 451, 25, 20);
		contentPane.add(txtUserID8);
		
		txtUserID9 = new JTextField();
		txtUserID9.setVisible(false);
		txtUserID9.setColumns(10);
		txtUserID9.setBounds(634, 483, 25, 20);
		contentPane.add(txtUserID9);
		
		txtUserID10 = new JTextField();
		txtUserID10.setVisible(false);
		txtUserID10.setColumns(10);
		txtUserID10.setBounds(634, 514, 25, 20);
		contentPane.add(txtUserID10);
	}

	public void loadContent() {
		
		String playlistID = null;
		String userID = null;
		String title = null;
		String username = null;
		int row = 1;
		
		txtPage.setText(String.valueOf(pageCount));
		
		if (sqlOffset > 9) {																											
			
			btnPrevious.setEnabled(true);
			
		}
		else 
		{																								
			
			btnPrevious.setEnabled(false);
		}
	
		ResultSet searchAttempt = AdminSQL.searchForPlaylists(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem().toString(), sqlOffset , sqlRowCount);	

		try 
		{
			
			while (searchAttempt.next())																	
			{

				playlistID = searchAttempt.getString("PlaylistID");
				userID = searchAttempt.getString("UserID");
				title = searchAttempt.getString("PlaylistTitle");
				username = searchAttempt.getString("UserName");
				
				switch (row) {
					case 1:
						txtPlaylistID1.setText(playlistID);
						txtUserID1.setText(userID);
						txtTitle1.setText(title);
						txtUsername1.setText(username);
						btnDelete1.setEnabled(true);
						break;
					case 2:
						txtPlaylistID2.setText(playlistID);
						txtUserID2.setText(userID);
						txtTitle2.setText(title);
						txtUsername2.setText(username);
						btnDelete2.setEnabled(true);
						break;
					case 3:
						txtPlaylistID3.setText(playlistID);
						txtUserID3.setText(userID);
						txtTitle3.setText(title);
						txtUsername3.setText(username);
						btnDelete3.setEnabled(true);
						break;
					case 4:
						txtPlaylistID4.setText(playlistID);
						txtUserID4.setText(userID);
						txtTitle4.setText(title);
						txtUsername4.setText(username);
						btnDelete4.setEnabled(true);
						break;
					case 5:
						txtPlaylistID5.setText(playlistID);
						txtUserID5.setText(userID);
						txtTitle5.setText(title);
						txtUsername5.setText(username);
						btnDelete5.setEnabled(true);
						break;
					case 6:
						txtPlaylistID6.setText(playlistID);
						txtUserID6.setText(userID);
						txtTitle6.setText(title);
						txtUsername6.setText(username);
						btnDelete6.setEnabled(true);
						break;
					case 7:
						txtPlaylistID7.setText(playlistID);
						txtUserID7.setText(userID);
						txtTitle7.setText(title);
						txtUsername7.setText(username);
						btnDelete7.setEnabled(true);
						break;
					case 8:
						txtPlaylistID8.setText(playlistID);
						txtUserID8.setText(userID);
						txtTitle8.setText(title);
						txtUsername8.setText(username);
						btnDelete8.setEnabled(true);
						break;
					case 9:
						txtPlaylistID9.setText(playlistID);
						txtUserID9.setText(userID);
						txtTitle9.setText(title);
						txtUsername9.setText(username);
						btnDelete9.setEnabled(true);
						break;
					case 10:
						txtPlaylistID10.setText(playlistID);
						txtUserID10.setText(userID);
						txtTitle10.setText(title);
						txtUsername10.setText(username);
						btnDelete10.setEnabled(true);
						btnNext.setEnabled(true);
						break;
					default:
					
						System.out.println("default of switch");
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
		txtUsername1.setText("");
		btnDelete1.setEnabled(false);
		
		txtTitle2.setText("");
		txtUsername2.setText("");
		btnDelete2.setEnabled(false);
		
		txtTitle3.setText("");
		txtUsername3.setText("");
		btnDelete3.setEnabled(false);
		
		txtTitle4.setText("");
		txtUsername4.setText("");
		btnDelete4.setEnabled(false);
		
		txtTitle5.setText("");
		txtUsername5.setText("");
		btnDelete5.setEnabled(false);
		
		txtTitle6.setText("");
		txtUsername6.setText("");
		btnDelete6.setEnabled(false);
		
		txtTitle7.setText("");
		txtUsername7.setText("");
		btnDelete7.setEnabled(false);
		
		txtTitle8.setText("");
		txtUsername8.setText("");
		btnDelete8.setEnabled(false);
		
		txtTitle9.setText("");
		txtUsername9.setText("");
		btnDelete9.setEnabled(false);
		
		txtTitle10.setText("");
		txtUsername10.setText("");
		btnDelete10.setEnabled(false);

	}
	
}
