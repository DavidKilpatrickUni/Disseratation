import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EmailScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailScreen frame = new EmailScreen();
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
	public EmailScreen() {
		setTitle("Elenco - Email Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("ELenco Email Server");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeader.setBounds(35, 62, 209, 57);
		contentPane.add(lblHeader);
		
		JButton btnOpenPort = new JButton("Open Port");
		btnOpenPort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmailApplication.recievedMessage();															
				
			}
		});
		btnOpenPort.setBounds(81, 195, 100, 23);
		contentPane.add(btnOpenPort);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(-1);
				
			}
		});
		btnExit.setBounds(81, 322, 100, 23);
		contentPane.add(btnExit);
	}

}

