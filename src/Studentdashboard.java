import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Studentdashboard extends JPanel {
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public Studentdashboard() {
		
		JButton btnAttendanceRecord = new JButton("Attendance Record");
		btnAttendanceRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Attendance Record")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Attendance Record"));
				mainbody.tabbedPane.addTab("Attendance Record", new StudentAttendanceRecord());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Attendance Record"));
			}
		});
		
		JButton BtnResult = new JButton("Results");
		BtnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Result Record")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Result Record"));
				mainbody.tabbedPane.addTab("Result Record", new StudentResultRecord());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Result Record"));
			}
		});
		
		JButton BtnAssignments = new JButton("Assignments");
		BtnAssignments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Assignments")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Assignments"));
				mainbody.tabbedPane.addTab("Assignments", new Student_Assignment());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Assignments"));
			}
		});
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==0){
					if(mainbody.tabbedPane.indexOfTab("General Settings")>-1)
						mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("General Settings"));
					mainbody.tabbedPane.addTab("General Settings", new StudentGeneralSettings());
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(536, Short.MAX_VALUE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(btnAttendanceRecord, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(BtnResult, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(BtnAssignments, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addGap(219)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAttendanceRecord)
						.addComponent(BtnAssignments)
						.addComponent(BtnResult)))
		);
		setLayout(groupLayout);
	}
}
