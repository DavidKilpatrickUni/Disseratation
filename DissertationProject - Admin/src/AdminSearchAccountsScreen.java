import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class AdminSearchAccountsScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID1;
	private JTextField txtUsername1;
	private JTextField txtUserID2;
	private JTextField txtUserID3;
	private JTextField txtUserID4;
	private JTextField txtUserID5;
	private JTextField txtUserID6;
	private JTextField txtUserID7;
	private JTextField txtUserID8;
	private JTextField txtUserID9;
	private JTextField txtUserID10;
	private JTextField txtUsername2;
	private JTextField txtUsername3;
	private JTextField txtUsername4;
	private JTextField txtUsername5;
	private JTextField txtUsername6;
	private JTextField txtUsername7;
	private JTextField txtUsername8;
	private JTextField txtUsername9;
	private JTextField txtUsername10;
	private JTextField txtPage;
	private JComboBox comboBoxSearch;
	private JComboBox comboBoxCriteria;
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
	private JTextField txtEmail1;
	private JTextField txtEmail2;
	private JTextField txtEmail3;
	private JTextField txtEmail4;
	private JTextField txtEmail5;
	private JTextField txtEmail6;
	private JTextField txtEmail7;
	private JTextField txtEmail8;
	private JTextField txtEmail9;
	private JTextField txtEmail10;
	private JLabel lblEmail;
	private JLabel lblSearch;
	private JLabel lblCriteria;
	private JButton btnEmail1;
	private JButton btnEmail2;
	private JButton btnEmail3;
	private JButton btnEmail4;
	private JButton btnEmail5;
	private JButton btnEmail6;
	private JButton btnEmail7;
	private JButton btnEmail8;
	private JButton btnEmail9;
	private JButton btnEmail10;
	private JLabel lblNewLabel;

	public AdminSearchAccountsScreen(AdminLoggedIn currentAdmin) {
		setTitle("Admin - Search Accounts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 724);
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
				
				ResultSet populateComboBox = AdminSQL.popoulateForSearchAccounts(comboBoxCriteria.getSelectedItem());	
				
					try {
						
						while (populateComboBox.next())
						{
							comboBoxSearch.addItem(populateComboBox.getString(comboBoxCriteria.getSelectedItem().toString()));
						}
					} catch (SQLException sql) {
				
					}
			}
		});
		comboBoxSearch.setBounds(99, 146, 250, 22);
		contentPane.add(comboBoxSearch);
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.setModel(new DefaultComboBoxModel(new String[] {"UserID", "UserName", "Email"}));
		comboBoxCriteria.setBounds(456, 146, 191, 22);
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
		btnSearch.setBounds(763, 146, 89, 23);
		contentPane.add(btnSearch);
		
		txtUserID1 = new JTextField();
		txtUserID1.setBounds(50, 239, 100, 20);
		contentPane.add(txtUserID1);
		txtUserID1.setColumns(10);
		
		txtUsername1 = new JTextField();
		txtUsername1.setBounds(205, 239, 200, 20);
		contentPane.add(txtUsername1);
		txtUsername1.setColumns(10);
		
		btnView1 = new JButton("View");
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID1.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView1.setEnabled(false);
		btnView1.setBounds(666, 238, 89, 23);
		contentPane.add(btnView1);
		
		JLabel lblUserID = new JLabel("UserID");
		lblUserID.setBounds(50, 205, 48, 14);
		contentPane.add(lblUserID);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(205, 205, 100, 14);
		contentPane.add(lblUsername);
		
		txtUserID2 = new JTextField();
		txtUserID2.setColumns(10);
		txtUserID2.setBounds(50, 271, 100, 20);
		contentPane.add(txtUserID2);
		
		txtUserID3 = new JTextField();
		txtUserID3.setColumns(10);
		txtUserID3.setBounds(50, 302, 100, 20);
		contentPane.add(txtUserID3);
		
		txtUserID4 = new JTextField();
		txtUserID4.setColumns(10);
		txtUserID4.setBounds(50, 333, 100, 20);
		contentPane.add(txtUserID4);
		
		txtUserID5 = new JTextField();
		txtUserID5.setColumns(10);
		txtUserID5.setBounds(50, 364, 100, 20);
		contentPane.add(txtUserID5);
		
		txtUserID6 = new JTextField();
		txtUserID6.setColumns(10);
		txtUserID6.setBounds(50, 395, 100, 20);
		contentPane.add(txtUserID6);
		
		txtUserID7 = new JTextField();
		txtUserID7.setColumns(10);
		txtUserID7.setBounds(50, 426, 100, 20);
		contentPane.add(txtUserID7);
		
		txtUserID8 = new JTextField();
		txtUserID8.setColumns(10);
		txtUserID8.setBounds(50, 457, 100, 20);
		contentPane.add(txtUserID8);
		
		txtUserID9 = new JTextField();
		txtUserID9.setColumns(10);
		txtUserID9.setBounds(50, 488, 100, 20);
		contentPane.add(txtUserID9);
		
		txtUserID10 = new JTextField();
		txtUserID10.setColumns(10);
		txtUserID10.setBounds(50, 519, 100, 20);
		contentPane.add(txtUserID10);
		
		txtUsername2 = new JTextField();
		txtUsername2.setColumns(10);
		txtUsername2.setBounds(205, 270, 200, 20);
		contentPane.add(txtUsername2);
		
		txtUsername3 = new JTextField();
		txtUsername3.setColumns(10);
		txtUsername3.setBounds(205, 302, 200, 20);
		contentPane.add(txtUsername3);
		
		txtUsername4 = new JTextField();
		txtUsername4.setColumns(10);
		txtUsername4.setBounds(205, 333, 200, 20);
		contentPane.add(txtUsername4);
		
		txtUsername5 = new JTextField();
		txtUsername5.setColumns(10);
		txtUsername5.setBounds(205, 364, 200, 20);
		contentPane.add(txtUsername5);
		
		txtUsername6 = new JTextField();
		txtUsername6.setColumns(10);
		txtUsername6.setBounds(205, 395, 200, 20);
		contentPane.add(txtUsername6);
		
		txtUsername7 = new JTextField();
		txtUsername7.setColumns(10);
		txtUsername7.setBounds(205, 426, 200, 20);
		contentPane.add(txtUsername7);
		
		txtUsername8 = new JTextField();
		txtUsername8.setColumns(10);
		txtUsername8.setBounds(205, 457, 200, 20);
		contentPane.add(txtUsername8);
		
		txtUsername9 = new JTextField();
		txtUsername9.setColumns(10);
		txtUsername9.setBounds(205, 488, 200, 20);
		contentPane.add(txtUsername9);
		
		txtUsername10 = new JTextField();
		txtUsername10.setColumns(10);
		txtUsername10.setBounds(205, 519, 200, 20);
		contentPane.add(txtUsername10);
		
		btnView2 = new JButton("View");
		btnView2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID2.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView2.setEnabled(false);
		btnView2.setBounds(666, 270, 89, 23);
		contentPane.add(btnView2);
		
		btnView3 = new JButton("View");
		btnView3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID3.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView3.setEnabled(false);
		btnView3.setBounds(666, 301, 89, 23);
		contentPane.add(btnView3);
		
		btnView4 = new JButton("View");
		btnView4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID4.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView4.setEnabled(false);
		btnView4.setBounds(666, 332, 89, 23);
		contentPane.add(btnView4);
		
		btnView5 = new JButton("View");
		btnView5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID5.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView5.setEnabled(false);
		btnView5.setBounds(666, 363, 89, 23);
		contentPane.add(btnView5);
		
		btnView6 = new JButton("View");
		btnView6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID6.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView6.setEnabled(false);
		btnView6.setBounds(666, 394, 89, 23);
		contentPane.add(btnView6);
		
		btnView7 = new JButton("View");
		btnView7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID7.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView7.setEnabled(false);
		btnView7.setBounds(666, 425, 89, 23);
		contentPane.add(btnView7);
		
		btnView8 = new JButton("View");
		btnView8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID8.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView8.setEnabled(false);
		btnView8.setBounds(666, 456, 89, 23);
		contentPane.add(btnView8);
		
		btnView9 = new JButton("View");
		btnView9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID9.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView9.setEnabled(false);
		btnView9.setBounds(666, 487, 89, 23);
		contentPane.add(btnView9);
		
		btnView10 = new JButton("View");
		btnView10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAccountScreen adminViewAccountScreen = new AdminViewAccountScreen(currentAdmin, txtUserID10.getText());
				adminViewAccountScreen.setVisible(true);
				dispose();
			}
		});
		btnView10.setEnabled(false);
		btnView10.setBounds(666, 518, 89, 23);
		contentPane.add(btnView10);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminMainMenuScreen mainScreen = new AdminMainMenuScreen(currentAdmin);
				mainScreen.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setBounds(396, 634, 125, 23);
		contentPane.add(btnMainMenu);
		
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
		btnPrevious.setBounds(299, 576, 89, 23);
		contentPane.add(btnPrevious);
		
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
		btnNext.setBounds(524, 576, 89, 23);
		contentPane.add(btnNext);
		
		txtPage = new JTextField();
		txtPage.setBounds(407, 577, 96, 20);
		contentPane.add(txtPage);
		txtPage.setColumns(10);
		
		txtEmail1 = new JTextField();
		txtEmail1.setColumns(10);
		txtEmail1.setBounds(456, 239, 200, 20);
		contentPane.add(txtEmail1);
		
		txtEmail2 = new JTextField();
		txtEmail2.setColumns(10);
		txtEmail2.setBounds(456, 271, 200, 20);
		contentPane.add(txtEmail2);
		
		txtEmail3 = new JTextField();
		txtEmail3.setColumns(10);
		txtEmail3.setBounds(456, 302, 200, 20);
		contentPane.add(txtEmail3);
		
		txtEmail4 = new JTextField();
		txtEmail4.setColumns(10);
		txtEmail4.setBounds(456, 333, 200, 20);
		contentPane.add(txtEmail4);
		
		txtEmail5 = new JTextField();
		txtEmail5.setColumns(10);
		txtEmail5.setBounds(456, 364, 200, 20);
		contentPane.add(txtEmail5);
		
		txtEmail6 = new JTextField();
		txtEmail6.setColumns(10);
		txtEmail6.setBounds(456, 395, 200, 20);
		contentPane.add(txtEmail6);
		
		txtEmail7 = new JTextField();
		txtEmail7.setColumns(10);
		txtEmail7.setBounds(456, 426, 200, 20);
		contentPane.add(txtEmail7);
		
		txtEmail8 = new JTextField();
		txtEmail8.setColumns(10);
		txtEmail8.setBounds(456, 457, 200, 20);
		contentPane.add(txtEmail8);
		
		txtEmail9 = new JTextField();
		txtEmail9.setColumns(10);
		txtEmail9.setBounds(456, 488, 200, 20);
		contentPane.add(txtEmail9);
		
		txtEmail10 = new JTextField();
		txtEmail10.setColumns(10);
		txtEmail10.setBounds(456, 519, 200, 20);
		contentPane.add(txtEmail10);
		
		lblEmail = new JLabel("Email Address");
		lblEmail.setBounds(456, 205, 89, 14);
		contentPane.add(lblEmail);
		
		lblSearch = new JLabel("Search");
		lblSearch.setBounds(50, 150, 48, 14);
		contentPane.add(lblSearch);
		
		lblCriteria = new JLabel("Criteria");
		lblCriteria.setBounds(407, 150, 48, 14);
		contentPane.add(lblCriteria);
		
		btnEmail1 = new JButton("Email");
		btnEmail1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID1.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail1.setEnabled(false);
		btnEmail1.setBounds(782, 238, 89, 23);
		contentPane.add(btnEmail1);
		
		btnEmail2 = new JButton("Email");
		btnEmail2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID2.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail2.setEnabled(false);
		btnEmail2.setBounds(782, 270, 89, 23);
		contentPane.add(btnEmail2);
		
		btnEmail3 = new JButton("Email");
		btnEmail3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID3.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail3.setEnabled(false);
		btnEmail3.setBounds(782, 301, 89, 23);
		contentPane.add(btnEmail3);
		
		btnEmail4 = new JButton("Email");
		btnEmail4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID4.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail4.setEnabled(false);
		btnEmail4.setBounds(782, 332, 89, 23);
		contentPane.add(btnEmail4);
		
		btnEmail5 = new JButton("Email");
		btnEmail5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID5.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail5.setEnabled(false);
		btnEmail5.setBounds(782, 363, 89, 23);
		contentPane.add(btnEmail5);
		
		btnEmail6 = new JButton("Email");
		btnEmail6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID6.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail6.setEnabled(false);
		btnEmail6.setBounds(782, 395, 89, 23);
		contentPane.add(btnEmail6);
		
		btnEmail7 = new JButton("Email");
		btnEmail7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID7.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail7.setEnabled(false);
		btnEmail7.setBounds(782, 426, 89, 23);
		contentPane.add(btnEmail7);
		
		btnEmail8 = new JButton("Email");
		btnEmail8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID8.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail8.setEnabled(false);
		btnEmail8.setBounds(782, 456, 89, 23);
		contentPane.add(btnEmail8);
		
		btnEmail9 = new JButton("Email");
		btnEmail9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID9.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail9.setEnabled(false);
		btnEmail9.setBounds(782, 487, 89, 23);
		contentPane.add(btnEmail9);
		
		btnEmail10 = new JButton("Email");
		btnEmail10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSendEmailScreen adminSendEmail = new AdminSendEmailScreen(currentAdmin, txtUserID10.getText());
				adminSendEmail.setVisible(true);
				dispose();
			}
		});
		btnEmail10.setEnabled(false);
		btnEmail10.setBounds(782, 518, 89, 23);
		contentPane.add(btnEmail10);
		
		lblNewLabel = new JLabel("Search Accounts");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(325, 28, 309, 53);
		contentPane.add(lblNewLabel);
		
		
	}
	public void loadContent() {
		
		String userID = null;
		String username = null;
		
		String firstname = null;
		String surname = null;
		String email = null;
	
		
		txtPage.setText(String.valueOf(pageCount));

		int row = 1;
		
		if (sqlOffset > 9) {																											
		
			btnPrevious.setEnabled(true);
		
		}
		else 
		{																								
		
			btnPrevious.setEnabled(false);
		}
		
	
		ResultSet searchAttempt = AdminSQL.searchAccounts(comboBoxSearch.getSelectedItem(), comboBoxCriteria.getSelectedItem(),  sqlOffset, sqlRowCount);	
		
		
		try {		
			
		while (searchAttempt.next())																	
			{
	
			userID = searchAttempt.getString("UserID");
			username = searchAttempt.getString("UserName");
			email = searchAttempt.getString("Email");
			

				
			switch (row) {
				case 1:
					txtUserID1.setText(userID);
					txtUsername1.setText(username);
					txtEmail1.setText(email);
					btnView1.setEnabled(true);
					btnEmail1.setEnabled(true);
					
					break;
				case 2:
					txtUserID2.setText(userID);
					txtUsername2.setText(username);
					txtEmail2.setText(email);
					btnView2.setEnabled(true);
					btnEmail2.setEnabled(true);
					break;
				case 3:
					txtUserID3.setText(userID);
					txtUsername3.setText(username);
					txtEmail3.setText(email);
					btnView3.setEnabled(true);
					btnEmail3.setEnabled(true);
					break;
				case 4:
					txtUserID4.setText(userID);
					txtUsername4.setText(username);
					txtEmail4.setText(email);
					btnView4.setEnabled(true);
					btnEmail4.setEnabled(true);
					break;
				case 5:
					txtUserID5.setText(userID);
					txtUsername5.setText(username);
					txtEmail5.setText(email);
					btnView5.setEnabled(true);
					btnEmail5.setEnabled(true);
					break;
				case 6:
					txtUserID6.setText(userID);
					txtUsername6.setText(username);
					txtEmail6.setText(email);
					btnView6.setEnabled(true);
					btnEmail6.setEnabled(true);
					break;
				case 7:
					txtUserID7.setText(userID);
					txtUsername7.setText(username);
					txtEmail7.setText(email);
					btnView7.setEnabled(true);
					btnEmail7.setEnabled(true);
					break;
				case 8:
					txtUserID8.setText(userID);
					txtUsername8.setText(username);
					txtEmail8.setText(email);
					btnView8.setEnabled(true);
					btnEmail8.setEnabled(true);
					break;
				case 9:
					txtUserID9.setText(userID);
					txtUsername9.setText(username);
					txtEmail9.setText(email);
					btnView9.setEnabled(true);
					btnEmail9.setEnabled(true);
					break;
				case 10:
					txtUserID10.setText(userID);
					txtUsername10.setText(username);
					txtEmail10.setText(email);
					btnView10.setEnabled(true);
					btnEmail10.setEnabled(true);
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

		txtUserID1.setText("");
		txtUsername1.setText("");
		txtEmail1.setText("");
		btnView1.setEnabled(false);
		btnEmail1.setEnabled(false);

		txtUserID2.setText("");
		txtUsername2.setText("");
		txtEmail2.setText("");
		btnView2.setEnabled(false);
		btnEmail2.setEnabled(false);
		
		txtUserID3.setText("");
		txtUsername3.setText("");
		txtEmail3.setText("");
		btnView3.setEnabled(false);
		btnEmail3.setEnabled(false);
		
		txtUserID4.setText("");
		txtUsername4.setText("");
		txtEmail4.setText("");
		btnView4.setEnabled(false);
		btnEmail4.setEnabled(false);
		
		txtUserID5.setText("");
		txtUsername5.setText("");
		txtEmail5.setText("");
		btnView5.setEnabled(false);
		btnEmail5.setEnabled(false);
		
		txtUserID6.setText("");
		txtUsername6.setText("");
		txtEmail6.setText("");
		btnView6.setEnabled(false);
		btnEmail6.setEnabled(false);
		
		txtUserID7.setText("");
		txtUsername7.setText("");
		txtEmail7.setText("");
		btnView7.setEnabled(false);
		btnEmail7.setEnabled(false);
		
		txtUserID8.setText("");
		txtUsername8.setText("");
		txtEmail8.setText("");
		btnView8.setEnabled(false);
		btnEmail8.setEnabled(false);
		
		txtUserID9.setText("");
		txtUsername9.setText("");
		txtEmail9.setText("");
		btnView9.setEnabled(false);
		btnEmail9.setEnabled(false);
		
		txtUserID10.setText("");
		txtUsername10.setText("");
		txtEmail10.setText("");
		btnView10.setEnabled(false);
		btnEmail10.setEnabled(false);
	}
	
}
