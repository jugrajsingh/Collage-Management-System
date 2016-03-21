import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;


public class TeacherDashboard extends JPanel {
	public static String subject;
	private Connection connection;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public TeacherDashboard() {
		connection = DBConnect.dbconnect();
		
		JButton btnUpdateAttendance = new JButton("Update Attendance");
		btnUpdateAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Select a Class for Attendance")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Select a Class for Attendance"));
				mainbody.tabbedPane.addTab("Select a Class for Attendance", new ClassforAttendance());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Select a Class for Attendance"));
			}
		});
		
		JButton btnUpdateResult = new JButton("Update Result");
		btnUpdateResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Select a Class for Result")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Select a Class for Result"));
				mainbody.tabbedPane.addTab("Select a Class for Result", new ClassforResult());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Select a Class for Result"));
			}
		});
		
		JButton btnAssignmentUpdate = new JButton("Assignment Update");
		btnAssignmentUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Select a Class for Assignment")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Select a Class for Assignment"));
				mainbody.tabbedPane.addTab("Select a Class for Assignment", new ClassforAssignment());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Select a Class for Assignment"));
			}
		});
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==0){
					if(mainbody.tabbedPane.indexOfTab("General Settings")>-1)
						mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("General Settings"));
					mainbody.tabbedPane.addTab("General Settings", new TeacherGeneralSettings());
					mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("General Settings"));
				}
				else if(comboBox.getSelectedIndex()==1){
					if(mainbody.tabbedPane.indexOfTab("Change Password")>-1)
						mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Change Password"));
					mainbody.tabbedPane.addTab("Change Password", new ChangePassword(Login.usrname));
					mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Change Password"));
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"General Settings", "Change Password"}));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnUpdateAttendance, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUpdateResult, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAssignmentUpdate, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateAttendance)
						.addComponent(btnUpdateResult)
						.addComponent(btnAssignmentUpdate))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		try {
			String query = "SELECT subject FROM teacher_details where teacherid = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, Login.usrname);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				subject = rst.getString("subject");
			}
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
