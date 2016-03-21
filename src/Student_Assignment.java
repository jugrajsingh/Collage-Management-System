import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class Student_Assignment extends JPanel {
	private JTextField textField;
	private Connection connection;
	private JTable table;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public Student_Assignment() {
		connection = DBConnect.dbconnect();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblAssignmentTitle = new JLabel("Assignment Title");
		lblAssignmentTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignmentTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAssignment = new JLabel("Assignment");
		lblAssignment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadlist(Integer.parseInt(Login.usrname));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAssignmentTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addComponent(lblAssignment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRefresh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClose)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAssignmentTitle)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(lblAssignment))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnClose)
								.addComponent(btnRefresh)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
					.addGap(12))
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()>=2){
					if(table.getSelectedRow()>-1){
						try {
							String query = "select * from assignments where serialno = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1,table.getValueAt(table.getSelectedRow(), 0).toString());
							ResultSet rst = pst.executeQuery();
							if(rst.next()){
								textField.setText(rst.getString("Assignment_title"));
								textArea.setText(rst.getString("Assignment_body"));
							}
							pst.close();
							rst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		setLayout(groupLayout);
		
		loadlist(Integer.parseInt(Login.usrname));
	}
	void loadlist(int rollno){
		int semester = 0;
		int year = 0;
		String branch = null;
		try {
			String query = "select semester,year,branch from student_details where rollno = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, rollno);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				semester = rst.getInt("semester");
				year = rst.getInt("year");
				branch = rst.getString("branch");
			}
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String query = "select serialno,Assignment_title from assignments where semester = ? and year = ? and branch = ? order by DateofUpload desc";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, semester);
			pst.setInt(2, year);
			pst.setString(3, branch);
			ResultSet rst = pst.executeQuery();
			table.setModel(Rs2TableModel.resultSetToTableModel(rst, false));
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(0).setHeaderValue("ID");
			table.getColumnModel().getColumn(1).setHeaderValue("Assingnment Title");
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
