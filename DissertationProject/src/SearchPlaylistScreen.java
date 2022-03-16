import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SearchPlaylistScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle1;
	private JTextField txtTitle2;
	private JTextField txtUsername1;
	private JTextField txtUsername2;
	private JTextField txtSearch;
	private JTextField txtUserID1;
	private JTextField txtUserID2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPlaylistScreen frame = new SearchPlaylistScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchPlaylistScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTitle1 = new JTextField();
		txtTitle1.setBounds(272, 194, 96, 20);
		contentPane.add(txtTitle1);
		txtTitle1.setColumns(10);
		
		txtTitle2 = new JTextField();
		txtTitle2.setBounds(272, 247, 96, 20);
		contentPane.add(txtTitle2);
		txtTitle2.setColumns(10);
		
		txtUsername1 = new JTextField();
		txtUsername1.setBounds(96, 194, 96, 20);
		contentPane.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		txtUsername2 = new JTextField();
		txtUsername2.setBounds(96, 247, 96, 20);
		contentPane.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		JButton btnView1 = new JButton("View");
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewPlaylistScreen frame = new ViewPlaylistScreen(txtTitle1.getText(), txtUserID1.getText());
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnView1.setBounds(497, 193, 89, 23);
		contentPane.add(btnView1);
		
		JButton btnView2 = new JButton("View");
		btnView2.setBounds(497, 246, 89, 23);
		contentPane.add(btnView2);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(73, 100, 169, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UserName", "Title"}));
		comboBox.setBounds(320, 100, 115, 20);
		contentPane.add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userID = null;
				String title = null;
				String username = null;
		
				
				int row = 1;
				
				
				System.out.println(comboBox.getSelectedItem());	
				
			
				ResultSet searchAttempt = SearchPlaylistApplication.search(txtSearch.getText(), comboBox.getSelectedItem().toString());	
				
				
				
				try {
					
				while (searchAttempt.next())																	
					{
			
					userID = searchAttempt.getString("UserID");
						title = searchAttempt.getString("PlaylistTitle");
						username = searchAttempt.getString("UserName");
		
						
						
						switch (row) {
						case 1:
							txtUserID1.setText(userID);
							txtTitle1.setText(title);
							txtUsername1.setText(username);
				
							break;
						case 2:
							txtUserID2.setText(userID);
							txtTitle2.setText(title);
							txtUsername2.setText(username);
				
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
		btnSearch.setBounds(249, 147, 89, 23);
		contentPane.add(btnSearch);
		
		txtUserID1 = new JTextField();
		txtUserID1.setBounds(414, 171, 96, 20);
		contentPane.add(txtUserID1);
		txtUserID1.setColumns(10);
		
		txtUserID2 = new JTextField();
		txtUserID2.setBounds(414, 227, 96, 20);
		contentPane.add(txtUserID2);
		txtUserID2.setColumns(10);
	}
}
