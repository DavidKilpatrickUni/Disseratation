import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSearchCommentsScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtSongID1;
	private JTextField txtUsername1;
	private JTextField txtComment1;
	private JTextField txtComment2;
	private JTextField txtComment3;
	private JTextField txtComment4;
	private JTextField txtComment5;
	private JTextField txtComment6;
	private JTextField txtComment7;
	private JTextField txtComment8;
	private JTextField txtComment9;
	private JTextField txtComment10;
	private JTextField txtUsername2;
	private JTextField txtUsername3;
	private JTextField txtUsername4;
	private JTextField txtUsername5;
	private JTextField txtUsername6;
	private JTextField txtUsername7;
	private JTextField txtUsername8;
	private JTextField txtUsername9;
	private JTextField txtUsername10;
	private JTextField txtSongID2;
	private JTextField txtSongID3;
	private JTextField txtSongID4;
	private JTextField txtSongID5;
	private JTextField txtSongID6;
	private JTextField txtSongID7;
	private JTextField txtSongID8;
	private JTextField txtSongID9;
	private JTextField txtSongID10;
	private JTextField txtPage;
	private JTextField txtCommentID1;
	private JTextField txtCommentID2;
	private JTextField txtCommentID3;
	private JTextField txtCommentID4;
	private JTextField txtCommentID5;
	private JTextField txtCommentID6;
	private JTextField txtCommentID7;
	private JTextField txtCommentID8;
	private JTextField txtCommentID9;
	private JTextField txtCommentID10;
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
	private JButton btnPrevious;
	private JButton btnNext;
	private JComboBox comboBoxSearch;
	private JComboBox comboBoxCriteria;
	private int pageCount = 1;
	private int sqlOffset = 0;
	private int sqlRowCount = 10;


	public AdminSearchCommentsScreen(AdminLoggedIn currentAdmin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 651);
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
			
					ResultSet results = AdminSQL.populateForCommentsUsername();
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
					
					ResultSet results = AdminSQL.popoulateForCommentsSongID();
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
		comboBoxSearch.setBounds(95, 87, 133, 25);
		contentPane.add(comboBoxSearch);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"SongID", "UserName"}));
		comboBoxCriteria.setBounds(356, 87, 173, 25);
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
		btnSearch.setBounds(657, 91, 89, 25);
		contentPane.add(btnSearch);
		
		btnDelete1 = new JButton("Delete");
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																												
				
				select = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete This Comment?", "Elenco - Admin", 					
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);				
				
					if (select == JOptionPane.YES_OPTION) {	
						AdminSQL.deleteComment(txtCommentID1.getText());
						JOptionPane.showMessageDialog(null, "Successfully Deleted Comment", "Elenco - Admin", JOptionPane.INFORMATION_MESSAGE,null);
						clearScreen();
						loadContent();
					}
				
			}
		});
		btnDelete1.setBounds(835, 171, 89, 23);
		contentPane.add(btnDelete1);
		
		btnDelete2 = new JButton("Delete");
		btnDelete2.setBounds(835, 205, 89, 23);
		contentPane.add(btnDelete2);
		
		btnDelete3 = new JButton("Delete");
		btnDelete3.setBounds(835, 239, 89, 23);
		contentPane.add(btnDelete3);
		
		btnDelete4 = new JButton("Delete");
		btnDelete4.setBounds(835, 273, 89, 23);
		contentPane.add(btnDelete4);
		
		btnDelete5 = new JButton("Delete");
		btnDelete5.setBounds(835, 307, 89, 23);
		contentPane.add(btnDelete5);
		
		btnDelete6 = new JButton("Delete");
		btnDelete6.setBounds(835, 341, 89, 23);
		contentPane.add(btnDelete6);
		
		btnDelete7 = new JButton("Delete");
		btnDelete7.setBounds(835, 375, 89, 23);
		contentPane.add(btnDelete7);
		
		btnDelete8 = new JButton("Delete");
		btnDelete8.setBounds(835, 409, 89, 23);
		contentPane.add(btnDelete8);
		
		btnDelete9 = new JButton("Delete");
		btnDelete9.setBounds(835, 443, 89, 23);
		contentPane.add(btnDelete9);
		
		btnDelete10 = new JButton("Delete");
		btnDelete10.setBounds(835, 477, 89, 23);
		contentPane.add(btnDelete10);
		
		txtSongID1 = new JTextField();
		txtSongID1.setBounds(25, 172, 50, 20);
		contentPane.add(txtSongID1);
		txtSongID1.setColumns(10);
		
		txtUsername1 = new JTextField();
		txtUsername1.setBounds(97, 172, 150, 20);
		contentPane.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		
		txtComment1 = new JTextField();
		txtComment1.setBounds(262, 172, 550, 20);
		contentPane.add(txtComment1);
		txtComment1.setColumns(10);
		
		txtComment2 = new JTextField();
		txtComment2.setColumns(10);
		txtComment2.setBounds(262, 206, 550, 20);
		contentPane.add(txtComment2);
		
		txtComment3 = new JTextField();
		txtComment3.setColumns(10);
		txtComment3.setBounds(262, 240, 550, 20);
		contentPane.add(txtComment3);
		
		txtComment4 = new JTextField();
		txtComment4.setColumns(10);
		txtComment4.setBounds(262, 274, 550, 20);
		contentPane.add(txtComment4);
		
		txtComment5 = new JTextField();
		txtComment5.setColumns(10);
		txtComment5.setBounds(262, 308, 550, 20);
		contentPane.add(txtComment5);
		
		txtComment6 = new JTextField();
		txtComment6.setColumns(10);
		txtComment6.setBounds(262, 342, 550, 20);
		contentPane.add(txtComment6);
		
		txtComment7 = new JTextField();
		txtComment7.setColumns(10);
		txtComment7.setBounds(262, 376, 550, 20);
		contentPane.add(txtComment7);
		
		txtComment8 = new JTextField();
		txtComment8.setColumns(10);
		txtComment8.setBounds(262, 410, 550, 20);
		contentPane.add(txtComment8);
		
		txtComment9 = new JTextField();
		txtComment9.setColumns(10);
		txtComment9.setBounds(262, 444, 550, 20);
		contentPane.add(txtComment9);
		
		txtComment10 = new JTextField();
		txtComment10.setColumns(10);
		txtComment10.setBounds(262, 478, 550, 20);
		contentPane.add(txtComment10);
		
		txtUsername2 = new JTextField();
		txtUsername2.setColumns(10);
		txtUsername2.setBounds(97, 206, 150, 20);
		contentPane.add(txtUsername2);
		
		txtUsername3 = new JTextField();
		txtUsername3.setColumns(10);
		txtUsername3.setBounds(97, 240, 150, 20);
		contentPane.add(txtUsername3);
		
		txtUsername4 = new JTextField();
		txtUsername4.setColumns(10);
		txtUsername4.setBounds(97, 274, 150, 20);
		contentPane.add(txtUsername4);
		
		txtUsername5 = new JTextField();
		txtUsername5.setColumns(10);
		txtUsername5.setBounds(97, 308, 150, 20);
		contentPane.add(txtUsername5);
		
		txtUsername6 = new JTextField();
		txtUsername6.setColumns(10);
		txtUsername6.setBounds(97, 342, 150, 20);
		contentPane.add(txtUsername6);
		
		txtUsername7 = new JTextField();
		txtUsername7.setColumns(10);
		txtUsername7.setBounds(97, 376, 150, 20);
		contentPane.add(txtUsername7);
		
		txtUsername8 = new JTextField();
		txtUsername8.setColumns(10);
		txtUsername8.setBounds(97, 410, 150, 20);
		contentPane.add(txtUsername8);
		
		txtUsername9 = new JTextField();
		txtUsername9.setColumns(10);
		txtUsername9.setBounds(97, 444, 150, 20);
		contentPane.add(txtUsername9);
		
		txtUsername10 = new JTextField();
		txtUsername10.setColumns(10);
		txtUsername10.setBounds(97, 478, 150, 20);
		contentPane.add(txtUsername10);
		
		txtSongID2 = new JTextField();
		txtSongID2.setColumns(10);
		txtSongID2.setBounds(25, 206, 50, 20);
		contentPane.add(txtSongID2);
		
		txtSongID3 = new JTextField();
		txtSongID3.setColumns(10);
		txtSongID3.setBounds(25, 240, 50, 20);
		contentPane.add(txtSongID3);
		
		txtSongID4 = new JTextField();
		txtSongID4.setColumns(10);
		txtSongID4.setBounds(25, 274, 50, 20);
		contentPane.add(txtSongID4);
		
		txtSongID5 = new JTextField();
		txtSongID5.setColumns(10);
		txtSongID5.setBounds(25, 308, 50, 20);
		contentPane.add(txtSongID5);
		
		txtSongID6 = new JTextField();
		txtSongID6.setColumns(10);
		txtSongID6.setBounds(25, 342, 50, 20);
		contentPane.add(txtSongID6);
		
		txtSongID7 = new JTextField();
		txtSongID7.setColumns(10);
		txtSongID7.setBounds(25, 376, 50, 20);
		contentPane.add(txtSongID7);
		
		txtSongID8 = new JTextField();
		txtSongID8.setColumns(10);
		txtSongID8.setBounds(25, 410, 50, 20);
		contentPane.add(txtSongID8);
		
		txtSongID9 = new JTextField();
		txtSongID9.setColumns(10);
		txtSongID9.setBounds(25, 444, 50, 20);
		contentPane.add(txtSongID9);
		
		txtSongID10 = new JTextField();
		txtSongID10.setColumns(10);
		txtSongID10.setBounds(25, 478, 50, 20);
		contentPane.add(txtSongID10);
		
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
		btnNext.setBounds(506, 522, 89, 23);
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
		btnPrevious.setBounds(275, 522, 89, 23);
		contentPane.add(btnPrevious);
		
		txtPage = new JTextField();
		txtPage.setBounds(386, 523, 96, 20);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
		
		JButton btnMain = new JButton("Main Menu");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminMainMenuScreen mainScreen = new AdminMainMenuScreen(currentAdmin);
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnMain.setBounds(393, 578, 125, 23);
		contentPane.add(btnMain);
		
		txtCommentID1 = new JTextField();
		txtCommentID1.setVisible(false);
		txtCommentID1.setBounds(934, 172, 25, 20);
		contentPane.add(txtCommentID1);
		txtCommentID1.setColumns(10);
		
		txtCommentID2 = new JTextField();
		txtCommentID2.setVisible(false);
		txtCommentID2.setColumns(10);
		txtCommentID2.setBounds(934, 206, 25, 20);
		contentPane.add(txtCommentID2);
		
		txtCommentID3 = new JTextField();
		txtCommentID3.setVisible(false);
		txtCommentID3.setColumns(10);
		txtCommentID3.setBounds(934, 240, 25, 20);
		contentPane.add(txtCommentID3);
		
		txtCommentID4 = new JTextField();
		txtCommentID4.setVisible(false);
		txtCommentID4.setColumns(10);
		txtCommentID4.setBounds(934, 274, 25, 20);
		contentPane.add(txtCommentID4);
		
		txtCommentID5 = new JTextField();
		txtCommentID5.setVisible(false);
		txtCommentID5.setColumns(10);
		txtCommentID5.setBounds(934, 308, 25, 20);
		contentPane.add(txtCommentID5);
		
		txtCommentID6 = new JTextField();
		txtCommentID6.setVisible(false);
		txtCommentID6.setColumns(10);
		txtCommentID6.setBounds(934, 342, 25, 20);
		contentPane.add(txtCommentID6);
		
		txtCommentID7 = new JTextField();
		txtCommentID7.setVisible(false);
		txtCommentID7.setColumns(10);
		txtCommentID7.setBounds(934, 376, 25, 20);
		contentPane.add(txtCommentID7);
		
		txtCommentID8 = new JTextField();
		txtCommentID8.setVisible(false);
		txtCommentID8.setColumns(10);
		txtCommentID8.setBounds(934, 410, 25, 20);
		contentPane.add(txtCommentID8);
		
		txtCommentID9 = new JTextField();
		txtCommentID9.setVisible(false);
		txtCommentID9.setColumns(10);
		txtCommentID9.setBounds(934, 444, 25, 20);
		contentPane.add(txtCommentID9);
		
		txtCommentID10 = new JTextField();
		txtCommentID10.setVisible(false);
		txtCommentID10.setColumns(10);
		txtCommentID10.setBounds(934, 478, 25, 20);
		contentPane.add(txtCommentID10);
		
		JLabel lblSongID = new JLabel("SongID");
		lblSongID.setBounds(25, 144, 48, 14);
		contentPane.add(lblSongID);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(97, 144, 75, 14);
		contentPane.add(lblUsername);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(262, 144, 48, 14);
		contentPane.add(lblComment);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(27, 96, 48, 14);
		contentPane.add(lblSearch);
		
		JLabel lblCriteria = new JLabel("Criteria");
		lblCriteria.setBounds(298, 92, 48, 14);
		contentPane.add(lblCriteria);
		
		JLabel lblHeader = new JLabel("Search Comments");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHeader.setBounds(326, 25, 400, 51);
		contentPane.add(lblHeader);
	}
	
	public void loadContent() {
		
		String songID = null;
		String username = null;
		String comment = null;
		String commentID = null;
		int row = 1;
		
		txtPage.setText(String.valueOf(pageCount));
		
		if (sqlOffset > 9) {																											
			
			btnPrevious.setEnabled(true);
			
		}
		else 
		{																								
			
			btnPrevious.setEnabled(false);
		}
	
		ResultSet searchAttempt = AdminSQL.searchComments(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem(),  sqlOffset , sqlRowCount);	

		try 
		{
			
			while (searchAttempt.next())																	
			{

				songID = searchAttempt.getString("SongID");
				username = searchAttempt.getString("UserName");
				comment = searchAttempt.getString("Comment");
				commentID = searchAttempt.getString("CommentID");
				
				switch (row) {
					case 1:
						txtSongID1.setText(songID);
						txtUsername1.setText(username);
						txtComment1.setText(comment);
						txtCommentID1.setText(commentID);
						btnDelete1.setEnabled(true);
						break;
					case 2:
						txtSongID2.setText(songID);
						txtUsername2.setText(username);
						txtComment2.setText(comment);
						txtCommentID2.setText(commentID);
						btnDelete2.setEnabled(true);
						break;
					case 3:
						txtSongID3.setText(songID);
						txtUsername3.setText(username);
						txtComment3.setText(comment);
						txtCommentID3.setText(commentID);
						btnDelete3.setEnabled(true);
						break;
					case 4:
						txtSongID4.setText(songID);
						txtUsername4.setText(username);
						txtComment4.setText(comment);
						txtCommentID4.setText(commentID);
						btnDelete4.setEnabled(true);
						break;
					case 5:
						txtSongID5.setText(songID);
						txtUsername5.setText(username);
						txtComment5.setText(comment);
						txtCommentID5.setText(commentID);
						btnDelete5.setEnabled(true);
						break;
					case 6:
						txtSongID6.setText(songID);
						txtUsername6.setText(username);
						txtComment6.setText(comment);	
						txtCommentID6.setText(commentID);
						btnDelete6.setEnabled(true);
						break;
					case 7:
						txtSongID7.setText(songID);
						txtUsername7.setText(username);
						txtComment7.setText(comment);
						txtCommentID7.setText(commentID);
						btnDelete7.setEnabled(true);
						break;
					case 8:
						txtSongID8.setText(songID);
						txtUsername8.setText(username);
						txtComment8.setText(comment);
						txtCommentID8.setText(commentID);
						btnDelete8.setEnabled(true);
						break;
					case 9:
						txtSongID9.setText(songID);
						txtUsername9.setText(username);
						txtComment9.setText(comment);
						txtCommentID9.setText(commentID);
						btnDelete9.setEnabled(true);
						break;
					case 10:
						txtSongID10.setText(songID);
						txtUsername10.setText(username);
						txtComment10.setText(comment);
						txtCommentID10.setText(commentID);
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
		
		txtUsername1.setText("");
		txtSongID1.setText("");
		txtComment1.setText("");
		txtCommentID1.setText("");
		btnDelete1.setEnabled(false);
		
		txtUsername2.setText("");
		txtSongID2.setText("");
		txtComment2.setText("");
		txtCommentID2.setText("");
		btnDelete2.setEnabled(false);
		
		txtUsername3.setText("");
		txtSongID3.setText("");
		txtComment3.setText("");
		txtCommentID3.setText("");
		btnDelete3.setEnabled(false);
		
		txtUsername4.setText("");
		txtSongID4.setText("");
		txtComment4.setText("");
		txtCommentID4.setText("");
		btnDelete4.setEnabled(false);
		
		txtUsername5.setText("");
		txtSongID5.setText("");
		txtComment5.setText("");
		txtCommentID5.setText("");
		btnDelete5.setEnabled(false);
		
		txtUsername6.setText("");
		txtSongID6.setText("");
		txtComment6.setText("");
		txtCommentID6.setText("");
		btnDelete6.setEnabled(false);
		
		txtUsername7.setText("");
		txtSongID7.setText("");
		txtComment7.setText("");
		txtCommentID7.setText("");
		btnDelete7.setEnabled(false);
		
		txtUsername8.setText("");
		txtSongID8.setText("");
		txtComment8.setText("");
		txtCommentID8.setText("");
		btnDelete8.setEnabled(false);
		
		txtUsername9.setText("");
		txtSongID9.setText("");
		txtComment9.setText("");
		txtCommentID9.setText("");
		btnDelete9.setEnabled(false);
		
		txtUsername10.setText("");
		txtSongID10.setText("");
		txtComment10.setText("");
		txtCommentID10.setText("");
		btnDelete10.setEnabled(false);

	}

}
