import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class TeacherGeneralSettings extends JPanel {
	private JTextField NameField;
	private JTextField FathersNameField;
	private JTextField MothersNameField;
	private JTextField ContactField;
	private JTextField EmailField;
	private JTextArea AddressArea;
	private Connection connection;
	private JTextField dob;
	private JButton loaddate;
	private CalendarProgram cal;
	private JPanel generalpanel;
	/**
	 * Create the panel.
	 */
	public TeacherGeneralSettings() {
connection = DBConnect.dbconnect();
		
		cal = new CalendarProgram();
		
		JLabel label = new JLabel("Name ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		NameField = new JTextField();
		NameField.setEditable(false);
		NameField.setColumns(10);
		
		JLabel label_1 = new JLabel("Father's Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("Mother's Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("Contact No.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("Email id");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel("Address");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		FathersNameField = new JTextField();
		FathersNameField.setEditable(false);
		FathersNameField.setColumns(10);
		
		MothersNameField = new JTextField();
		MothersNameField.setEditable(false);
		MothersNameField.setColumns(10);
		
		ContactField = new JTextField();
		ContactField.setEditable(false);
		ContactField.setColumns(10);
		
		EmailField = new JTextField();
		EmailField.setEditable(false);
		EmailField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		AddressArea = new JTextArea();
		AddressArea.setOpaque(false);
		AddressArea.setWrapStyleWord(true);
		AddressArea.setLineWrap(true);
		AddressArea.setEditable(false);
		scrollPane.setViewportView(AddressArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JToggleButton btnEditSettings = new JToggleButton("Edit Settings");
		btnEditSettings.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = new String();
				boolean flag = false;
				String passfromtable = new String();
				if (btnEditSettings.isSelected()) {
					JPasswordField pwd = new JPasswordField();
					int choice = JOptionPane.showConfirmDialog(null, pwd,"Confirm Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
					switch(choice){
					case JOptionPane.OK_OPTION:
						pass = pwd.getText();
						String passquery = "SELECT * FROM login where username = ?";
						try {
							PreparedStatement passtest = connection.prepareStatement(passquery);
							passtest.setString(1,Login.usrname);
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
							flag = pass.equalsIgnoreCase(passfromtable);
						} catch (Exception e) {
						}
						break;
					}
					if(flag){
						ContactField.setEditable(true);
						EmailField.setEditable(true);
						AddressArea.setEditable(true);
						AddressArea.setOpaque(true);
						dob.setEditable(true);
						loaddate.setEnabled(true);
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						Date d;
						try {
							d = df.parse(dob.getText());
							cal.setDate(d);
							cal.setChosenOtherButtonColor(new Color(160, 160, 160));
							cal.setChosenMonthButtonColor(new Color(240, 240, 240));
							generalpanel.add(cal,BorderLayout.CENTER);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						btnEditSettings.setText("Save Change");
						repaint();
					}else {
						JOptionPane.showMessageDialog(null,"Wrong Password Please Check");
						btnEditSettings.setSelected(false);
					}
				}
				else{
					if(Login.isfieldsempty(NameField,FathersNameField,MothersNameField,ContactField,EmailField,AddressArea)){
						int choice = JOptionPane.showOptionDialog(null, "Want to Exit Without Saving", "User Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						switch(choice){
						case JOptionPane.YES_OPTION:
							ContactField.setEditable(false);
							dob.setEditable(false);
							EmailField.setEditable(false);
							AddressArea.setEditable(false);
							AddressArea.setOpaque(false);
							generalpanel.remove(cal);
							btnEditSettings.setText("Edit Settings");
							repaint();
							break;
						case JOptionPane.NO_OPTION: 
							btnEditSettings.setSelected(true);
							break;
						default:
							btnEditSettings.setSelected(true);
						}
					}
					else{
						int choice = JOptionPane.showOptionDialog(null, "Want to Save Current Data", "User Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						switch(choice){
						case JOptionPane.YES_OPTION:
							try {
								String query = "UPDATE teacher_details SET DoB = ?, phone = ?, email = ?, address = ? WHERE teacherid = ?";
								PreparedStatement pst = connection.prepareStatement(query);
								pst.setString(1, dob.getText());
								pst.setString(2, ContactField.getText());
								pst.setString(3, EmailField.getText());
								pst.setString(4, AddressArea.getText());
								pst.setString(5, Login.usrname);
								pst.execute();
								pst.close();
								ContactField.setEditable(false);
								dob.setEditable(false);
								EmailField.setEditable(false);
								AddressArea.setEditable(false);
								AddressArea.setOpaque(false);
								loaddate.setEnabled(false);
								generalpanel.remove(cal);
								btnEditSettings.setText("Edit Settings");
								repaint();
								btnEditSettings.setSelected(false);
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case JOptionPane.NO_OPTION:
							ContactField.setEditable(false);
							dob.setEditable(false);
							EmailField.setEditable(false);
							AddressArea.setEditable(false);
							AddressArea.setOpaque(false);
							loaddate.setEnabled(false);
							generalpanel.remove(cal);
							btnEditSettings.setText("Edit Settings");
							repaint();
							btnEditSettings.setSelected(false);
							break;
						default:
							btnEditSettings.setSelected(true);
						}
					}
				}
			}
		});
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setColumns(10);
		
		generalpanel = new JPanel();
		
		loaddate = new JButton("<<");
		loaddate.setEnabled(false);
		loaddate.setFont(new Font("Tahoma", Font.PLAIN, 9));
		loaddate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dob.setText(cal.getDate());
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(label)
							.addGap(18)
							.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(label_1))
								.addComponent(label_2)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addComponent(label_3))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(46)
									.addComponent(label_4))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(lblDateOfBirth))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addComponent(label_5)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(FathersNameField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(MothersNameField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(ContactField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(EmailField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(dob, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
					.addGap(10)
					.addComponent(loaddate, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(generalpanel, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnEditSettings)
							.addGap(6)
							.addComponent(btnClose)
							.addGap(49)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addGap(13)
							.addComponent(label_2)
							.addGap(14)
							.addComponent(label_3)
							.addGap(14)
							.addComponent(label_4)
							.addGap(16)
							.addComponent(lblDateOfBirth)
							.addGap(11)
							.addComponent(label_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(FathersNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(MothersNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(ContactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(dob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(loaddate, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(generalpanel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addGap(82)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEditSettings)
								.addComponent(btnClose))))
					.addGap(19))
		);
		generalpanel.setLayout(new BorderLayout(0, 0));
		setLayout(groupLayout);
		
		loaddata(Login.usrname);
	}
	void loaddata(String usrname){
		try {
			String query ="SELECT * FROM teacher_details where teacherid = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, usrname);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				NameField.setText(rst.getString("firstname")+" "+rst.getString("lastname"));
				FathersNameField.setText(rst.getString("Fname"));
				MothersNameField.setText(rst.getString("Mname"));
				ContactField.setText(rst.getString("phone"));
				EmailField.setText(rst.getString("email"));
				AddressArea.setText(rst.getString("address"));
				dob.setText(rst.getString("DoB"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
