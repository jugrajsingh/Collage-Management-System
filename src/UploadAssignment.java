import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;


public class UploadAssignment extends JPanel {
	private JTextField textField;
	private JTextArea textArea;
	private Connection connection;

	/**
	 * Create the panel.
	 */
	public UploadAssignment() {
		connection = DBConnect.dbconnect();
		
		JLabel lblAssignmentTitle = new JLabel("Assignment Title");
		lblAssignmentTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setName("Assignment Title");
		textField.setColumns(10);
		
		JLabel lblAssignment = new JLabel("Assignment");
		lblAssignment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button = new JButton("Close");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		JButton button_1 = new JButton("Reset");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
				if(mainbody.tabbedPane.indexOfTab("Assignment Update")>-1)
					mainbody.tabbedPane.remove(mainbody.tabbedPane.indexOfTab("Assignment Update"));
				mainbody.tabbedPane.addTab("Assignment Update", new UploadAssignment());
				mainbody.tabbedPane.setSelectedIndex(mainbody.tabbedPane.indexOfTab("Assignment Update"));
			}
		});
		
		JButton button_2 = new JButton("Save");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.isfieldsempty(textField,textArea)){
				}
				else{
					try {
						String query = "INSERT INTO assignments (semester, year, branch, Assignment_title, Assignment_body) VALUES (?, ?, ?, ?, ?)";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setInt(1, ClassforAssignment.semester);
						pst.setInt(2, ClassforAssignment.year);
						pst.setString(3, ClassforAssignment.branch);
						pst.setString(4, textField.getText());
						pst.setString(5, textArea.getText());
						pst.execute();
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAssignment)
								.addComponent(lblAssignmentTitle))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAssignmentTitle))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAssignment)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		textArea.setName("Assignment Body");
		scrollPane.setViewportView(textArea);
		setLayout(groupLayout);
	}
}
