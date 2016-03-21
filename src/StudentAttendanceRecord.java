import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class StudentAttendanceRecord extends JPanel {
	private JTextField NameField;
	private JTextField FathersNameField;
	private JTextField MothersNameField;
	private JTextField BranchField;
	private JTextField ContactField;
	private JTextField EmailField;
	private JTextField HorDField;
	private JTextField FeesField;
	private JTextField RollnoField;
	private Connection connection;

	/**
	 * Create the panel.
	 */
	public StudentAttendanceRecord() {
		connection = DBConnect.dbconnect();
		
		JLabel label = new JLabel("Attendance Record of Students");
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_2 = new JLabel("Father's Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_3 = new JLabel("Mother's Name");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_4 = new JLabel("Branch");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_5 = new JLabel("Roll No.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel("Contact No.");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_7 = new JLabel("Email id");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_8 = new JLabel("Hosteler/Day Scholar");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_9 = new JLabel("Fees ");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		NameField = new JTextField();
		NameField.setEditable(false);
		NameField.setColumns(10);
		
		FathersNameField = new JTextField();
		FathersNameField.setEditable(false);
		FathersNameField.setColumns(10);
		
		MothersNameField = new JTextField();
		MothersNameField.setEditable(false);
		MothersNameField.setColumns(10);
		
		BranchField = new JTextField();
		BranchField.setEditable(false);
		BranchField.setColumns(10);
		
		ContactField = new JTextField();
		ContactField.setEditable(false);
		ContactField.setColumns(10);
		
		EmailField = new JTextField();
		EmailField.setEditable(false);
		EmailField.setColumns(10);
		
		HorDField = new JTextField();
		HorDField.setEditable(false);
		HorDField.setColumns(10);
		
		FeesField = new JTextField();
		FeesField.setEditable(false);
		FeesField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		
		RollnoField = new JTextField();
		RollnoField.setEditable(false);
		RollnoField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(FathersNameField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(MothersNameField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(BranchField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_7)
						.addComponent(label_6)
						.addComponent(label_8)
						.addComponent(label_9))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ContactField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(EmailField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(HorDField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(FeesField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
					.addGap(67))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(RollnoField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(126))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClose)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnClose)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_1)
										.addComponent(label_6)
										.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(ContactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_5)
									.addComponent(RollnoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(label_7)
								.addComponent(FathersNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(label_8)
								.addComponent(MothersNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(HorDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(label_9)
								.addComponent(BranchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(FeesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
					.addGap(13))
		);
		
		
		scrollPane.setViewportView(new AttendancePanel(Integer.parseInt(Login.usrname)));
		setLayout(groupLayout);
		
		loaddata(Integer.parseInt(Login.usrname));
	}
	void loaddata(int rollno){
		try {
			String query ="SELECT * FROM student_details where rollno = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, rollno);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				RollnoField.setText(rst.getString("rollno"));
				NameField.setText(rst.getString("firstname")+" "+rst.getString("lastname"));
				FathersNameField.setText(rst.getString("Fname"));
				MothersNameField.setText(rst.getString("Mname"));
				BranchField.setText(rst.getString("branch").toUpperCase());
				ContactField.setText(rst.getString("phone"));
				EmailField.setText(rst.getString("email"));
				HorDField.setText(rst.getString("residancetype"));
				if(rst.getString("fee_status").equals("0")){
					FeesField.setText("Pending...");
				}
				else{
					FeesField.setText("Received.");
				}
			}
			pst.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
