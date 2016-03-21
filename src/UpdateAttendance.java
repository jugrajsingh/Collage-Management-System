import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class UpdateAttendance extends JPanel {
	private JTable table;
	private Connection connection;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public UpdateAttendance() {
	
		connection = DBConnect.dbconnect();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int present_attendance;
				String sub;
				if(comboBox.getSelectedIndex()==0){
					sub = "subject"+ClassforAttendance.subjectno+"t";
				}
				else{
					sub = "subject"+ClassforAttendance.subjectno+"p";
				}
				for(int i=0;i<table.getRowCount();i++){
					present_attendance = 0;
					if((boolean) table.getValueAt(i, 2)){
						try {
							String query = "select "+sub+" from attendance where rollno = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, Integer.parseInt((String) table.getValueAt(i, 0)));
							ResultSet rst = pst.executeQuery();
							if(rst.next()){
								present_attendance = Integer.parseInt(rst.getString(sub));
							}
							pst.close();
							rst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						try {
							String query = "UPDATE attendance SET "+sub+" = ? WHERE rollno= ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, present_attendance+1);
							pst.setInt(2, Integer.parseInt((String) table.getValueAt(i, 0)));
							pst.execute();
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				int current_lectures = 0;
				try {
					String query = "select "+sub+" from total_lectures where semester = ? and year = ? and branch = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setInt(1, ClassforAttendance.semester);
					pst.setInt(2, ClassforAttendance.year);
					pst.setString(3, ClassforAttendance.branch);
					ResultSet rst = pst.executeQuery();
					if(rst.next()){
						current_lectures = rst.getInt(sub);
					}
					pst.close();
					rst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					String query = "UPDATE total_lectures SET "+sub+"= ? WHERE semester = ? and year = ? and branch = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setInt(1, current_lectures+1);
					pst.setInt(2, ClassforAttendance.semester);
					pst.setInt(3, ClassforAttendance.year);
					pst.setString(4, ClassforAttendance.branch);
					pst.execute();
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Theory", "Practical"}));
		comboBox.setSelectedIndex(0);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Update Attendance")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Update Attendance"));
				mainbody.tabbedPane.addTab("Update Attendance", new UpdateAttendance());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Update Attendance"));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnSave)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		loadattendancetable();
	}
	void loadattendancetable(){
		try {
			String query = "select rollno,firstname from student_details where semester = ? and year = ? and branch = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, ClassforAttendance.semester);
			pst.setInt(2, ClassforAttendance.year);
			pst.setString(3, ClassforAttendance.branch);
			ResultSet rst = pst.executeQuery();
			table.setModel(loadtabledate(rst, false));
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//for Present column Setting box value to false
		for(int i = 0;i<table.getRowCount();i++){
			table.setValueAt(false, i, 2);
		}
	}
	
	TableModel loadtabledate(ResultSet rs, boolean editibility){
		try{
			 ResultSetMetaData metaData = rs.getMetaData();
			    int numberOfColumns = metaData.getColumnCount()+1;
			    Vector<String> columnNames = new Vector<String>();
			    Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
			    
			    for (int column = 0; column < numberOfColumns-1; column++) {
					columnNames.addElement(metaData.getColumnLabel(column + 1));
				    }
			    columnNames.addElement("Present");
			    
			    
			    while (rs.next()) {
					Vector<Object> newRow = new Vector<Object>();
					for (int i = 1; i < numberOfColumns; i++) {
					    newRow.addElement(rs.getObject(i));
					}
					rows.addElement(newRow);
			    }
			    
			    boolean[] columnEditables = new boolean[numberOfColumns];
			    for(int i=0;i<numberOfColumns;i++){
			    	columnEditables[i] = editibility;
			    }
			    columnEditables[2] = true;
			    
			 return (new DefaultTableModel(rows, columnNames){
				 public Class<?> getColumnClass(int column) {
						Class cls = String.class;
						switch(column){
						case 2:
							cls = Boolean.class;
							break;
						}
						return cls;
					}
				 public void setValueAt(Object value,int row,int column){
					 if(value instanceof Boolean && column ==2){
						 Vector rowdata = (Vector)getDataVector().get(row);
						 rowdata.set(2, (Boolean)value);
						 fireTableCellUpdated(row, column);
					 }
				 }
				 public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}});
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
