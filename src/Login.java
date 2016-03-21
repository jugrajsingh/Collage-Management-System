import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Login {

	public JFrame frame;
	private JTextField UsernameField;
	private JPasswordField PasswordField;
	private Connection connection;
	public static String uniqueid;
	public static String usrname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		usrname = null;
		uniqueid = null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connection = DBConnect.dbconnect();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isfieldsempty(UsernameField, PasswordField)) {
				} else {
					uniqueid = null;
					usrname = null;
					PreparedStatement logintest;
					ResultSet resultoflogin;
					int count = 0;
					try {
						String loginquery = "SELECT * FROM login where username = ? and password = ?";
						logintest = connection.prepareStatement(loginquery);
						logintest.setString(1, UsernameField.getText());
						logintest.setString(2, PasswordField.getText());
						resultoflogin = logintest.executeQuery();
						while (resultoflogin.next()) {
							uniqueid = resultoflogin.getString("type");
							usrname = resultoflogin.getString("username");
							count = count + 1;
						}
						if (count == 1) {
							JOptionPane.showMessageDialog(null,"Username and Password Accepted");
							frame.dispose();
							new mainbody().setVisible(true);
						} else if (count == 0) {
							JOptionPane.showMessageDialog(null,"Authentcation Failed...");
						} else {
							JOptionPane.showMessageDialog(null,"Something Went Wrong");
						}
						resultoflogin.close();
						logintest.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		
		JLabel lblCollageName = new JLabel("GNDEC,Ludhiana");
		lblCollageName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollageName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblUsername = new JLabel("UserName");
		
		JLabel lblPassword = new JLabel("Password");
		
		UsernameField = new JTextField();
		UsernameField.setName("Username Field");
		UsernameField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setEchoChar('*');
		PasswordField.setName("Password Field");
		PasswordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("if you forgot the password contact the authority www.gndec.ac.in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		JLabel img = new JLabel("", new ImageIcon(this.getClass().getResource("/Guru_Nanak_Dev_University.png")), JLabel.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addComponent(lblCollageName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(104))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblUsername)
							.addGap(32)
							.addComponent(UsernameField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblPassword)
							.addGap(32)
							.addComponent(PasswordField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCollageName)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblUsername))
								.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblPassword))
								.addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(img, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(img, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public static boolean isfieldsempty(Object... field) {
		for (Object x : field) {
			if (((JTextComponent) x).getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						((JTextComponent) x).getName() + " is Empty");
				return true;
			}
		}
		return false;
	}
}