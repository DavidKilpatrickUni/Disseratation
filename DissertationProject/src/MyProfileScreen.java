import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyProfileScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldArtist1;
	private JTextField textFieldArtist2;
	private JTextField textFieldArtist3;
	private JTextField textFieldGenre1;
	private JTextField textFieldGenre2;
	private JTextField textFieldGenre3;
	private JButton btnArtist;
	private JButton btnGenre;
	private JButton btnUserName;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfileScreen frame = new MyProfileScreen();
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
	public MyProfileScreen(LoggedIn currentLoggedIn) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				
				
				ResultSet accountDetails  = AccountApplication.getAccountsDetail(currentLoggedIn.getCurrentUserID());
				
				
				
			
				String userName = null;
				String artist1 = null;
				String genre1 = null;
				String genre2 = null;
						
				try {
					
					if (accountDetails.next())																	
					{
						userName = accountDetails.getString("UserName");
						artist1 = accountDetails.getString("Artist One");
						genre1 = accountDetails.getString("Genre One");
						genre2 = accountDetails.getString("Genre Two");
						
						
						textFieldUserName.setText(userName);
						textFieldArtist1.setText(artist1);
						textFieldGenre1.setText(genre1);
						textFieldGenre2.setText(genre2);
						
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
					
					else
					{
						System.out.println("Invalid Account Details");
					}
					
				}
				catch (SQLException sqe)
				{
					
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setBounds(182, 49, 230, 14);
		contentPane.add(lblMyProfile);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(60, 124, 48, 14);
		contentPane.add(lblUserName);
		
		JLabel lblFavouriteArtists = new JLabel("Favourite Artist(s)");
		lblFavouriteArtists.setBounds(60, 212, 170, 14);
		contentPane.add(lblFavouriteArtists);
		
		JLabel lblFavouriteGenres = new JLabel("Favourite Genre(s)");
		lblFavouriteGenres.setBounds(353, 212, 103, 14);
		contentPane.add(lblFavouriteGenres);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(144, 121, 274, 20);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldArtist1 = new JTextField();
		textFieldArtist1.setBounds(48, 262, 170, 20);
		contentPane.add(textFieldArtist1);
		textFieldArtist1.setColumns(10);
		
		textFieldArtist2 = new JTextField();
		textFieldArtist2.setForeground(Color.BLACK);
		textFieldArtist2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArtist2.setBounds(48, 310, 170, 20);
		contentPane.add(textFieldArtist2);
		textFieldArtist2.setColumns(10);
		
		textFieldArtist3 = new JTextField();
		textFieldArtist3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArtist3.setForeground(Color.BLACK);
		textFieldArtist3.setBounds(48, 366, 182, 20);
		contentPane.add(textFieldArtist3);
		textFieldArtist3.setColumns(10);
		
		textFieldGenre1 = new JTextField();
		textFieldGenre1.setBounds(341, 262, 170, 20);
		contentPane.add(textFieldGenre1);
		textFieldGenre1.setColumns(10);
		
		textFieldGenre2 = new JTextField();
		textFieldGenre2.setBounds(353, 310, 158, 20);
		contentPane.add(textFieldGenre2);
		textFieldGenre2.setColumns(10);
		
		textFieldGenre3 = new JTextField();
		textFieldGenre3.setBounds(341, 366, 170, 20);
		contentPane.add(textFieldGenre3);
		textFieldGenre3.setColumns(10);
		
		btnArtist = new JButton("Change Artist(s)");
		btnArtist.setBounds(75, 408, 132, 23);
		contentPane.add(btnArtist);
		
		btnGenre = new JButton("Change Genre(s)");
		btnGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyProfileApplication.updateGenre(currentLoggedIn.getCurrentUserID(),textFieldGenre1.getText().strip(), textFieldGenre2.getText().strip() ,textFieldGenre3.getText().strip() );
				System.out.println(currentLoggedIn.getCurrentUserID() +textFieldGenre1.getText().strip()+ textFieldGenre2.getText().strip() +textFieldGenre3.getText().strip());
			
			}
		});
		btnGenre.setBounds(353, 408, 138, 23);
		contentPane.add(btnGenre);
		
		btnUserName = new JButton("Change User Name");
		btnUserName.setBounds(208, 163, 143, 23);
		contentPane.add(btnUserName);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileScreen frame = new ProfileScreen(currentLoggedIn);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(235, 491, 89, 23);
		contentPane.add(btnBack);
	}
}
