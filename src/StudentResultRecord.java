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


public class StudentResultRecord extends JPanel {
	private JTextField NameField;
	private JTextField FathersNameField;
	private JTextField MothersNameField;
	private JTextField BranchField;
	private JTextField RollnoField;
	private JTextField ContactField;
	private JTextField EmailField;
	private JTextField HnDField;
	private JTextField FeesField;
	private JButton btnClose;
	private Connection connection;

	/**
	 * Create the panel.
	 */
	public StudentResultRecord() {
		connection = DBConnect.dbconnect();
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		NameField = new JTextField();
		NameField.setEditable(false);
		NameField.setColumns(10);
		
		JLabel label_1 = new JLabel("Father's Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		FathersNameField = new JTextField();
		FathersNameField.setEditable(false);
		FathersNameField.setColumns(10);
		
		JLabel label_2 = new JLabel("Mother's Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		MothersNameField = new JTextField();
		MothersNameField.setEditable(false);
		MothersNameField.setColumns(10);
		
		JLabel label_3 = new JLabel("Branch");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		BranchField = new JTextField();
		BranchField.setEditable(false);
		BranchField.setColumns(10);
		
		JLabel label_4 = new JLabel("Roll No.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		RollnoField = new JTextField();
		RollnoField.setEditable(false);
		RollnoField.setColumns(10);
		
		JLabel label_5 = new JLabel("Contact No.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel("Email id");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_7 = new JLabel("Hosteler/Day Scholar");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_8 = new JLabel("Fees ");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		ContactField = new JTextField();
		ContactField.setEditable(false);
		ContactField.setColumns(10);
		
		EmailField = new JTextField();
		EmailField.setEditable(false);
		EmailField.setColumns(10);
		
		HnDField = new JTextField();
		HnDField.setEditable(false);
		HnDField.setColumns(10);
		
		FeesField = new JTextField();
		FeesField.setEditable(false);
		FeesField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainbody.tabbedPane.remove(mainbody.tabbedPane.getSelectedComponent());
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(80)
									.addComponent(label)
									.addGap(18)
									.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(72)
									.addComponent(label_3)
									.addGap(18)
									.addComponent(BranchField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(69)
									.addComponent(label_4)
									.addGap(18)
									.addComponent(RollnoField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addComponent(label_1)
									.addGap(18)
									.addComponent(FathersNameField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(24)
									.addComponent(label_2)
									.addGap(18)
									.addComponent(MothersNameField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(54)
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(ContactField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(83)
											.addComponent(label_6)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(EmailField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_7)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(HnDField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(97)
											.addComponent(label_8)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(FeesField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
									.addGap(30))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGap(251)
									.addComponent(btnClose)))))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnClose))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(FathersNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(MothersNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(BranchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(RollnoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(ContactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(HnDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(FeesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8))))
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		scrollPane.setViewportView(new ResultPanel(Integer.parseInt(Login.usrname)));
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
				HnDField.setText(rst.getString("residancetype"));
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
