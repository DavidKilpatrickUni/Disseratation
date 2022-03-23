import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;

public class MyProfileScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtArtist1;
	private JTextField txtArtist2;
	private JTextField txtArtist3;
	private JTextField txtGenre1;
	private JTextField txtGenre2;
	private JTextField txtGenre3;
	private JButton btnArtist;
	private JButton btnGenre;
	private JButton btnBack;
	private JLabel lblUserIcon;
	private JTextField txtUserIcon;
	private JButton btnChangeIcon;

	public MyProfileScreen(LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - My Profile Details");
		setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				ResultSet accountDetails  = MySQLQueries.getAccountsDetail(currentLoggedIn.getCurrentUserID());
				
				String userName = null;
				String artist1 = null;
				String artist2 = null;
				String artist3 = null;
				String genre1 = null;
				String genre2 = null;
				String genre3 = null;
						
				try {
					
					if (accountDetails.next())																
					{
						userName = accountDetails.getString("UserName");
						artist1 = accountDetails.getString("Artist One");
						artist2 = accountDetails.getString("Artist Two");
						artist3 = accountDetails.getString("Artist Three");
						genre1 = accountDetails.getString("Genre One");
						genre2 = accountDetails.getString("Genre Two");
						genre3 = accountDetails.getString("Genre Three");
						
						txtUsername.setText(userName);
						txtArtist1.setText(artist1);
						txtArtist2.setText(artist2);
						txtArtist3.setText(artist3);
						txtGenre1.setText(genre1);
						txtGenre2.setText(genre2);
						txtGenre3.setText(genre3);
							
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
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUserName.setBounds(50, 175, 100, 25);
		lblUserName.setForeground(new Color(90, 192, 217));
		contentPane.add(lblUserName);
		
		JLabel lblFavouriteArtists = new JLabel("Favourite Artist(s)");
		lblFavouriteArtists.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavouriteArtists.setFont(new Font("Georgia", Font.BOLD, 12));
		lblFavouriteArtists.setBounds(25, 375, 200, 25);

		lblFavouriteArtists.setForeground(new Color(90, 192, 217));
		contentPane.add(lblFavouriteArtists);
		
		JLabel lblFavouriteGenres = new JLabel("Favourite Genre(s)");
		lblFavouriteGenres.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavouriteGenres.setFont(new Font("Georgia", Font.BOLD, 12));
		lblFavouriteGenres.setBounds(262, 375, 200, 25);
		lblFavouriteGenres.setForeground(new Color(90, 192, 217));
		contentPane.add(lblFavouriteGenres);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUsername.setBounds(150, 175, 275, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtArtist1 = new JTextField();
		txtArtist1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist1.setHorizontalAlignment(SwingConstants.CENTER);
		txtArtist1.setBounds(25, 410, 200, 25);
		contentPane.add(txtArtist1);
		txtArtist1.setColumns(10);
		
		txtArtist2 = new JTextField();
		txtArtist2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist2.setForeground(Color.BLACK);
		txtArtist2.setHorizontalAlignment(SwingConstants.CENTER);
		txtArtist2.setBounds(25, 450, 200, 25);
		contentPane.add(txtArtist2);
		txtArtist2.setColumns(10);
		
		txtArtist3 = new JTextField();
		txtArtist3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtArtist3.setHorizontalAlignment(SwingConstants.CENTER);
		txtArtist3.setForeground(Color.BLACK);
		txtArtist3.setBounds(25, 490, 200, 25);
		contentPane.add(txtArtist3);
		txtArtist3.setColumns(10);
		
		txtGenre1 = new JTextField();
		txtGenre1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenre1.setBounds(262, 410, 200, 25);
		contentPane.add(txtGenre1);
		txtGenre1.setColumns(10);
		
		txtGenre2 = new JTextField();
		txtGenre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenre2.setBounds(262, 450, 200, 25);
		contentPane.add(txtGenre2);
		txtGenre2.setColumns(10);
		
		txtGenre3 = new JTextField();
		txtGenre3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtGenre3.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenre3.setBounds(262, 490, 200, 25);
		contentPane.add(txtGenre3);
		txtGenre3.setColumns(10);
		
		btnArtist = new JButton("Change Artist(s)");
		btnArtist.setToolTipText("Click To Change Your Favourite Artists To Input Above");
		btnArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Update Your Favourite Artists", "Elenco - Update Profile", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) 
				{

					MySQLQueries.updateArtist(currentLoggedIn.getCurrentUserID(),txtArtist1.getText().strip(), txtArtist2.getText().strip() ,txtArtist3.getText().strip() );

				}
				
			}
		});
		btnArtist.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnArtist.setBounds(50, 525, 150, 25);
		contentPane.add(btnArtist);
		
		btnGenre = new JButton("Change Genre(s)");
		btnGenre.setToolTipText("Click To Change Your Favourite Genres To Input Above");
		btnGenre.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Update Your Favourite Genres", "Elenco - Update Profile", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;								
				
				if (select == JOptionPane.YES_OPTION) 
				{
				
					MySQLQueries.updateGenre(currentLoggedIn.getCurrentUserID(),txtGenre1.getText().strip(), txtGenre2.getText().strip() ,txtGenre3.getText().strip() );
				
				}
			}
		});
		btnGenre.setBounds(287, 525, 150, 25);
		contentPane.add(btnGenre);
		
		btnBack = new JButton("Profile Menu");
		btnBack.setToolTipText("Return To Profile Screen");
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Return To Main Menu - All Unconfirmed Input Will Be Lost", "Elenco - Profile", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) 
				{
					ProfileMenuScreen frame = new ProfileMenuScreen(currentLoggedIn);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnBack.setBounds(200, 600, 100, 25);
		contentPane.add(btnBack);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setBounds(150, 25, 200, 75);
		contentPane.add(lblElenco);
		
		JLabel lblHeader = new JLabel("Profile Details");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(150, 125, 200, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
		
		JButton btnUsername = new JButton("Change User Name");
		btnUsername.setToolTipText("Click To Change Username To Input Above");
		btnUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	
				
				select = JOptionPane.showOptionDialog(null, "Confirm Change Of Username", "Elenco - Profile", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									
				
				if (select == JOptionPane.YES_OPTION) {
					try 
					{
					
						MyProfileApplication.checkValidUsername(txtUsername.getText().strip());
					
						try 
						{
							MySQLQueries.updateUsername(currentLoggedIn.getCurrentUserID(), txtUsername.getText().strip());
					
						} 
						catch (CustomException error) {
					
							JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
						
					}
					catch (CustomException error){
					
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					}
				
				}
			}
		});
		btnUsername.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnUsername.setBounds(150, 220, 200, 25);
		contentPane.add(btnUsername);
		
		lblUserIcon = new JLabel("User Icon");
		lblUserIcon.setForeground(new Color(90, 192, 217));
		lblUserIcon.setFont(new Font("Georgia", Font.BOLD, 12));
		lblUserIcon.setBounds(50, 275, 100, 25);
		contentPane.add(lblUserIcon);
		
		txtUserIcon = new JTextField();
		txtUserIcon.setColumns(10);
		txtUserIcon.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUserIcon.setBounds(150, 275, 275, 25);
		contentPane.add(txtUserIcon);
		
		btnChangeIcon = new JButton("Change User Icon");
		btnChangeIcon.setToolTipText("Demo Place Holder For Changing User Icon");
		btnChangeIcon.setEnabled(false);
		btnChangeIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Not In Build", "Elenco - Change User Icon", JOptionPane.INFORMATION_MESSAGE,null);
			}
		});
		btnChangeIcon.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnChangeIcon.setBounds(150, 330, 200, 25);
		contentPane.add(btnChangeIcon);
	}
}
