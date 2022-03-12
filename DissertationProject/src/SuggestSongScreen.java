import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SuggestSongScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldArtist;
	private JTextField textFieldGenre;
	private JTextField textFieldAlbum;
	private JTextArea textAreaSongInfo;
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
	public SuggestSongScreen(String currentUserID, String currentUserName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSuggestSong = new JButton("Suggest Song");
		btnSuggestSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SuggestSongApplication.suggestSong((textFieldTitle.getText()), 
						textFieldArtist.getText(), 
						textFieldGenre.getText(), 
						slider.getValue(),
						comboBoxMins.getSelectedItem() + ":" + comboBoxSecs.getSelectedItem() ,
						RegistrationApplication.changeDateFormat(dateChooser.getDate()),
						textFieldAlbum.getText(),
						textAreaSongInfo.getText());
				
				
				/*
				private JTextField textFieldTitle;
				private JTextField textFieldArtist;
				private JTextField textFieldGenre;
				private JTextField textFieldSongLength;
				private JTextField textFieldReleased;
				private JTextField textFieldAlbum;
				private JTextField textFieldRating;
				
				*/
			}
		});
		btnSuggestSong.setBounds(361, 426, 143, 23);
		contentPane.add(btnSuggestSong);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(129, 181, 96, 20);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		textFieldArtist = new JTextField();
		textFieldArtist.setBounds(129, 237, 96, 20);
		contentPane.add(textFieldArtist);
		textFieldArtist.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(79, 142, 48, 14);
		contentPane.add(lblTitle);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setBounds(79, 212, 48, 14);
		contentPane.add(lblArtist);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(68, 277, 48, 14);
		contentPane.add(lblGenre);
		
		textFieldGenre = new JTextField();
		textFieldGenre.setBounds(129, 292, 96, 20);
		contentPane.add(textFieldGenre);
		textFieldGenre.setColumns(10);
		
		JLabel lblSongLength = new JLabel("Song Length");
		lblSongLength.setBounds(308, 142, 103, 14);
		contentPane.add(lblSongLength);
		
		JLabel lblReleased = new JLabel("Released");
		lblReleased.setBounds(297, 226, 48, 14);
		contentPane.add(lblReleased);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(308, 277, 48, 14);
		contentPane.add(lblAlbum);
		
		textFieldAlbum = new JTextField();
		textFieldAlbum.setBounds(361, 294, 96, 20);
		contentPane.add(textFieldAlbum);
		textFieldAlbum.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(79, 350, 48, 14);
		contentPane.add(lblRating);
		
		textAreaSongInfo = new JTextArea();
		textAreaSongInfo.setBounds(574, 313, 202, 85);
		contentPane.add(textAreaSongInfo);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setBounds(439, 347, 48, 14);
		contentPane.add(lblSongInfo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(371, 237, 143, 20);
		contentPane.add(dateChooser);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setValue(0);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMaximum(10);
		slider.setBounds(42, 393, 316, 56);
		contentPane.add(slider);
		
		 comboBoxMins = new JComboBox();
		comboBoxMins.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBoxMins.setBounds(408, 138, 49, 22);
		contentPane.add(comboBoxMins);
		
		 comboBoxSecs = new JComboBox();
		comboBoxSecs.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBoxSecs.setBounds(491, 138, 43, 22);
		contentPane.add(comboBoxSecs);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(402, 100, 48, 14);
		contentPane.add(lblMinutes);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setBounds(491, 100, 48, 14);
		contentPane.add(lblSeconds);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(568, 426, 89, 23);
		contentPane.add(btnNewButton);
	}
}
