import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;


public class ChangePassword extends JPanel {
	private JPasswordField txtOldpassword;
	private JPasswordField newpassword;
	private JPasswordField renewpassword;
	private Connection connection;

	/**
	 * Create the panel.
	 */
	public ChangePassword(String username) {
		connection = DBConnect.dbconnect();
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtOldpassword = new JPasswordField();
		txtOldpassword.setName("Old Password Field");
		txtOldpassword.setColumns(10);
		
		newpassword = new JPasswordField();
		newpassword.setName("New Password Field");
		newpassword.setColumns(10);
		
		renewpassword = new JPasswordField();
		renewpassword.setName("Re-Enter Password Field");
		renewpassword.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Change Password")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Change Password"));
				mainbody.tabbedPane.addTab("Change Password", new ChangePassword(Login.usrname));
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Change Password"));
			}
		});
		
		JButton btnSubmitChanges = new JButton("Submit Changes");
		btnSubmitChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = false;
				String passfromtable = new String();
				String passquery = "SELECT * FROM login where username = ?";
				try {
					PreparedStatement passtest = connection.prepareStatement(passquery);
					passtest.setString(1, username);
					ResultSet rst = passtest.executeQuery();
					if(rst.next()){
						passfromtable = rst.getString("password");
					}
					passtest.close();
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					flag = txtOldpassword.getText().equalsIgnoreCase(passfromtable);
				} catch (Exception e) {
					
				}
				
				if(flag){
					if(Login.isfieldsempty(txtOldpassword,newpassword,renewpassword)){
					}
					else if(newpassword.getText().equals(renewpassword.getText())){
						try {
							String query = "UPDATE login SET password = ? WHERE username = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1, newpassword.getText());
							pst.setString(2, username);
							pst.execute();
							pst.close();
							JOptionPane.showMessageDialog(null, "Changes Saved Successfully");
							mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Passwords Didn`t Match");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Previous Password!!!");
				}	
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(lblOldPassword)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtOldpassword, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lblNewPassword)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(newpassword, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblReenterPassword)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(renewpassword, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
					.addGap(91))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnReset)
					.addPreferredGap(ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(181)
					.addComponent(btnSubmitChanges, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(134))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword)
						.addComponent(txtOldpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(newpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReenterPassword)
						.addComponent(renewpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSubmitChanges, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addComponent(btnClose))
						.addComponent(btnReset))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
