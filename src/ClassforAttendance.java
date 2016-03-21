import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ClassforAttendance extends JPanel {
	private JTable table;
	public static int subjectno = 0;
	public static int semester = 0;
	public static int year = 0;
	public static String branch = null;
	private Connection connection;
	/**
	 * Create the panel.
	 */
	public ClassforAttendance() {
		connection = DBConnect.dbconnect();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>-1){
					setsubjectno();
					mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
					if(mainbody.tabbedPane.indexOfTab("Update Attendance")>-1)
						mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Update Attendance"));
					mainbody.tabbedPane.addTab("Update Attendance", new UpdateAttendance());
					mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Update Attendance"));
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Select a Row");
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Select a Class")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Select a Class"));
				mainbody.tabbedPane.addTab("Select a Class", new ClassforAttendance());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Select a Class"));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnProceed)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnClose)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnProceed)
						.addComponent(btnReset))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		loadtable();
	}
	void loadtable(){
		try {
			String query = "SELECT serialno,semester,year,branch FROM subjects where subject1 = ? or subject2 = ? or subject3 = ? or subject4 = ? or subject5 = ? or subject6 = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, TeacherDashboard.subject);
			pst.setString(2, TeacherDashboard.subject);
			pst.setString(3, TeacherDashboard.subject);
			pst.setString(4, TeacherDashboard.subject);
			pst.setString(5, TeacherDashboard.subject);
			pst.setString(6, TeacherDashboard.subject);
			ResultSet rst = pst.executeQuery();
			table.setModel(Rs2TableModel.resultSetToTableModel(rst, false));
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void setsubjectno(){
		semester = (int) table.getValueAt(table.getSelectedRow(), 1);
		year =(int) table.getValueAt(table.getSelectedRow(), 2);
		branch = (String) table.getValueAt(table.getSelectedRow(), 3);
		try {
			String query ="select * from subjects where semester = ? and year = ? and branch = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, semester);
			pst.setInt(2, year);
			pst.setString(3, branch);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				for(int i=1;i<=6;i++){
					if(TeacherDashboard.subject.equalsIgnoreCase(rst.getString("subject"+i))){
						subjectno = i;
					}
				}
			}
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
