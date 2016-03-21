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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class UpdateResult extends JPanel {
	private JTable table;
	private Connection connection;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public UpdateResult() {
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
				boolean flag = true;
				String sub,test;
				try {
					for(int i=0;i<table.getRowCount();i++){
						test = (String) table.getValueAt(i, 2);
						if(test.isEmpty()){
						}
					}
				} catch (NullPointerException e) {
					flag = false;
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Some Students Marks are Missing Please Check");
				}
				if(flag){
					if(comboBox.getSelectedIndex()==0){
						sub = "subject"+ClassforResult.subjectno+"t";
					}
					else{
						sub = "subject"+ClassforResult.subjectno+"p";
					}
					for(int i=0;i<table.getRowCount();i++){
						try {
							String query = "UPDATE student_result SET "+sub+" = ? WHERE rollno= ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, Integer.parseInt((String) table.getValueAt(i, 2)));
							pst.setInt(2, Integer.parseInt((String) table.getValueAt(i, 0)));
							pst.execute();
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mainbody.tabbedPane.indexOfTab("Update Result")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Update Result"));
				mainbody.tabbedPane.addTab("Update Result", new UpdateResult());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Update Result"));
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Theory", "Practical"}));
		comboBox.setSelectedIndex(0);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnClose)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		loadattendancetable();
	}
	void loadattendancetable(){
		try {
			String query = "select rollno,firstname from student_details where semester = ? and year = ? and branch = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, ClassforResult.semester);
			pst.setInt(2, ClassforResult.year);
			pst.setString(3, ClassforResult.branch);
			ResultSet rst = pst.executeQuery();
			table.setModel(loadtabledate(rst, false));
			rst.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
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
			    columnNames.addElement("Marks Obtained");
			    
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
						return cls;
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
