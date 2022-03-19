import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class SuggestSongScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtArtist;
	private JTextField txtGenre;
	private JTextField txtAlbum;
	private JTextArea txtSongInfo;
	private JDateChooser dateChooser;
	private JSlider slider;
	private JComboBox comboBoxMins;
	private JComboBox comboBoxSecs; 
	
	
	
	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuggestSongScreen frame = new SuggestSongScreen();
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
	public SuggestSongScreen(LoggedIn currentLoggedIn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Random\\eclipse-workspace\\Dissertation\\Images\\BlueIcon-Circle.png"));
		setTitle("Elenco - Suggest Song");
		setBackground(Color.WHITE);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 699);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSuggestSong = new JButton("Suggest Song");
		btnSuggestSong.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnSuggestSong.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				txtTitle.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtArtist.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtGenre.setBorder(new LineBorder(Color.LIGHT_GRAY));
				comboBoxMins.setBorder(new LineBorder(Color.LIGHT_GRAY));
				comboBoxSecs.setBorder(new LineBorder(Color.LIGHT_GRAY));
				dateChooser.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtAlbum.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtSongInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
				slider.setBorder(new LineBorder(Color.LIGHT_GRAY));
	
				
			System.out.println("comboMin index: " + comboBoxMins.getSelectedIndex() + " ComboSec index: "+ comboBoxSecs.getSelectedIndex());
				
			System.out.println("slider value: " + slider.getValue());
			
			
			int select;																																	// Variable for storing user response to message box.
			
			select = JOptionPane.showOptionDialog(null, "Suggest Song To Elenco", "Elenc0 - Suggest Song", 
					 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
			
			if (select == JOptionPane.YES_OPTION) {
				
				try {
					
					if (SuggestSongApplication.checkSuggestionForm(txtTitle.getText().strip(),
															txtArtist.getText().strip(), 
															txtGenre.getText().strip(), 
															comboBoxMins.getSelectedIndex(),  
															comboBoxSecs.getSelectedIndex(), 
															dateChooser.getDate(), 
															txtAlbum.getText().strip(), 
															txtSongInfo.getText().strip(),
															slider.getValue()) == "continue"){
				
				
				
				
						try {
							if (!MySQLQueries.checkIfSongExists(txtTitle.getText().strip(),txtArtist.getText().strip()).next()){
						
								MySQLQueries.suggestSong((txtTitle.getText().strip()), 
										txtArtist.getText().strip(), 
										txtGenre.getText().strip(), 
										comboBoxMins.getSelectedItem() + ":" + comboBoxSecs.getSelectedItem() ,
										Helper.dateForDatabase(Helper.changeDateFormat(dateChooser.getDate())),
										txtAlbum.getText().strip(),
										"Song Info: " + txtSongInfo.getText().strip(),
										slider.getValue());
								
								ResultSet getSongID = MySQLQueries.getSongIDOfSuggestSong();
								
								String currentSongID = null;
								
								getSongID.last(); 
									
								currentSongID = getSongID.getString("SongID");
									
							
								ViewSongApplication.createRating(currentSongID,currentLoggedIn.getCurrentUserID(),String.valueOf(slider.getValue()));
							}
							else {
								JOptionPane.showMessageDialog(null,"Song Already Suggested - Try The Discover Feature To Find This Song", "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
							}
						
						}catch (SQLException error)
						{
							
								JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
						}
					
					
					}
				
				
				}
				catch (CustomException error)
				{
					JOptionPane.showMessageDialog(null, error.getMessage(), "Elenco - Something Went Wrong", JOptionPane.ERROR_MESSAGE,null);
					
					switch(error.getReason())
					{
					case "title":
						txtTitle.setBorder(new LineBorder(Color.RED));
						break;
					case "artist":
						txtArtist.setBorder(new LineBorder(Color.RED));
						break;
					case "genre":
						txtGenre.setBorder(new LineBorder(Color.RED));
						break;
					case "songLength":
						comboBoxMins.setBorder(new LineBorder(Color.RED));
						comboBoxSecs.setBorder(new LineBorder(Color.RED));
						break;
					case "released":
						dateChooser.setBorder(new LineBorder(Color.RED));
						break;
					case "album":
						txtAlbum.setBorder(new LineBorder(Color.RED));
						break;
					case "songInfo":
						txtSongInfo.setBorder(new LineBorder(Color.RED));
						break;
					case "rating":
						slider.setBorder(new LineBorder(Color.RED));
						break;
				
					}
						
				}
			
			}
			}
		});
		
		btnSuggestSong.setBounds(325, 550, 250, 25);
		contentPane.add(btnSuggestSong);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(150, 250, 250, 25);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtArtist = new JTextField();
		txtArtist.setBounds(150, 300, 250, 25);
		contentPane.add(txtArtist);
		txtArtist.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 12));
		lblTitle.setForeground(new Color(90, 192, 217));
		lblTitle.setBounds(50, 250, 100, 25);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Georgia", Font.BOLD, 12));
		lblArtist.setForeground(new Color(90, 192, 217));
		lblArtist.setBounds(50, 300, 100, 25);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGenre.setForeground(new Color(90, 192, 217));
		lblGenre.setBounds(50, 350, 100, 25);
		contentPane.add(lblGenre);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(150, 350, 250, 25);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		JLabel lblSongLength = new JLabel("Song Length");
		lblSongLength.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSongLength.setForeground(new Color(90, 192, 217));
		lblSongLength.setBounds(50, 400, 100, 25);
		contentPane.add(lblSongLength);
		
		JLabel lblReleased = new JLabel("Released");
		lblReleased.setFont(new Font("Georgia", Font.BOLD, 12));
		lblReleased.setForeground(new Color(90, 192, 217));
		lblReleased.setBounds(50, 450, 100, 25);
		contentPane.add(lblReleased);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Georgia", Font.BOLD, 12));
		lblAlbum.setForeground(new Color(90, 192, 217));
		lblAlbum.setBounds(50, 500, 100, 25);
		contentPane.add(lblAlbum);
		
		txtAlbum = new JTextField();
		txtAlbum.setBounds(150, 500, 250, 25);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		JLabel lblRating = new JLabel("My Rating");
		lblRating.setFont(new Font("Georgia", Font.BOLD, 12));
		lblRating.setForeground(new Color(90, 192, 217));
		lblRating.setBounds(450, 475, 100, 25);
		contentPane.add(lblRating);
		
		txtSongInfo = new JTextArea();
		txtSongInfo.setFont(new Font("Georgia", Font.PLAIN, 12));
		txtSongInfo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtSongInfo.setBounds(550, 250, 250, 175);
		contentPane.add(txtSongInfo);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setFont(new Font("Georgia", Font.BOLD, 12));
		lblSongInfo.setForeground(new Color(90, 192, 217));
		lblSongInfo.setBounds(450, 250, 100, 25);
		contentPane.add(lblSongInfo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 450, 250, 25);
		contentPane.add(dateChooser);
		
		slider = new JSlider();
		slider.setValue(0);
		slider.setFont(new Font("Georgia", Font.BOLD, 12));
		slider.setBackground(Color.WHITE);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMaximum(5);
		slider.setBounds(550, 475, 250, 50);
		slider.setForeground(new Color(90, 192, 217));
		contentPane.add(slider);
		
		 comboBoxMins = new JComboBox();
		comboBoxMins.setModel(new DefaultComboBoxModel(new String[] {"--", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBoxMins.setBounds(175, 400, 50, 25);
		contentPane.add(comboBoxMins);
	AutoCompleteDecorator.decorate(comboBoxMins);
		
		
		 comboBoxSecs = new JComboBox();
		comboBoxSecs.setModel(new DefaultComboBoxModel(new String[] {"--", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBoxSecs.setBounds(285, 400, 50, 25);
		contentPane.add(comboBoxSecs);
		AutoCompleteDecorator.decorate(comboBoxSecs);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblMinutes.setBounds(230, 400, 48, 25);
		lblMinutes.setForeground(new Color(90, 192, 217));
		contentPane.add(lblMinutes);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblSeconds.setBounds(340, 400, 48, 25);
		lblSeconds.setForeground(new Color(90, 192, 217));
		contentPane.add(lblSeconds);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select;																																	// Variable for storing user response to message box.
				
				select = JOptionPane.showOptionDialog(null, "Return To Main Menu - All Unconfirmed Input Will Be Lost", "Elence - Suggest Song", 
						 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_NO_OPTION);;									// Sets variable to the value returned from YES_NO_Option message pop up.
				
				if (select == JOptionPane.YES_OPTION) {
				
				MainScreen gui = new MainScreen(currentLoggedIn);
				gui.setVisible(true);
				dispose();
				
				}
			}
		});
		btnMainMenu.setBounds(375, 600, 150, 25);
		contentPane.add(btnMainMenu);
		
		JLabel lblElenco = new JLabel("Elenco");
		lblElenco.setToolTipText("Elenco - Express Your Musical Opinion");
		lblElenco.setHorizontalAlignment(SwingConstants.CENTER);
		lblElenco.setForeground(new Color(90, 192, 217));
		lblElenco.setFont(new Font("Georgia", Font.BOLD, 40));
		lblElenco.setBounds(325, 25, 250, 75);
		contentPane.add(lblElenco);
		
		ImageIcon appIcon =  new ImageIcon(ApplicationStartup.class.getResource("/BlueIcon-Circle.PNG"));					// Create new instance of Icon using the given PNG file.
		Image appImage = appIcon.getImage();															// Create image of icon variable.
		Image appImageResize = appImage.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		appIcon = new ImageIcon(appImageResize);
		
		
		ImageIcon profileButton =  new ImageIcon(ApplicationStartup.class.getResource("/ColourProfileIcon.PNG"));					// Create new instance of Icon using the given PNG file.
		Image buttonImage = profileButton.getImage();															// Create image of icon variable.
		Image buttonImageResize = buttonImage.getScaledInstance(75,75, java.awt.Image.SCALE_SMOOTH);		// Resize image to scale desired. 
		profileButton = new ImageIcon(buttonImageResize);
		
		JLabel lblHeader = new JLabel("Suggest Song");
		lblHeader.setFont(new Font("Georgia", Font.BOLD, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(325, 175, 250, 25);
		lblHeader.setForeground(new Color(90, 192, 217));
		contentPane.add(lblHeader);
	}
}
