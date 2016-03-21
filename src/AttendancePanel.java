import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


public class AttendancePanel extends JPanel {
	private JTextField theoryattend;
	private JTextField practicalattend;
	private JTextField theorylectures;
	private JTextField practicallectures;
	private JLabel Theoryprecentage;
	private JLabel Practicalpercentage;
	private Connection connection;
	private JList<String> Subjects;

	/**
	 * Create the panel.
	 */
	public AttendancePanel(int roll) {
		connection = DBConnect.dbconnect();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblSubjectName = new JLabel("Subject Name");
		lblSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubjectName.setHorizontalAlignment(SwingConstants.CENTER);
		
		Subjects = new JList<String>();
		Subjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Subjects.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()>=2){
					if(Subjects.getSelectedIndex()>-1){
						try {
							String query = "select * from attendance where rollno = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, roll);
							ResultSet rst = pst.executeQuery();
							if(rst.next()){
								theoryattend.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"t"));
								if(Subjects.getSelectedIndex()<5){
									practicalattend.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"p"));
								}
								else{
									practicalattend.setText("");
								}
							}
							pst.close();
							rst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						int semester = 0;
						int year = 0;
						String branch = null;
						try {
							String query = "select semester,year,branch from student_details where rollno = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, roll);
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
							String query = "select * from total_lectures where semester = ? and year = ? and branch = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, semester);
							pst.setInt(2, year);
							pst.setString(3, branch);
							ResultSet rst = pst.executeQuery();
							if(rst.next()){
								Formatter fmt = new Formatter();
								Formatter fmt1 = new Formatter();
								theorylectures.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"t"));
								fmt.format("%.2f", (Double.parseDouble(theoryattend.getText())/Double.parseDouble(theorylectures.getText()))*100);
								Theoryprecentage.setText(fmt+"%");
								if(Subjects.getSelectedIndex()<5){
									practicallectures.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"p"));
									fmt1.format("%.2f", (Double.parseDouble(practicalattend.getText())/Double.parseDouble(practicallectures.getText()))*100);
									Practicalpercentage.setText(fmt1+"%");
								}
								else{
									practicallectures.setText("");
									Practicalpercentage.setText("");
								}
								fmt.close();
								fmt1.close();
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
		scrollPane_1.setViewportView(Subjects);
		
		JLabel label = new JLabel("Attended");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		theoryattend = new JTextField();
		theoryattend.setEditable(false);
		theoryattend.setColumns(10);
		
		practicalattend = new JTextField();
		practicalattend.setEditable(false);
		practicalattend.setColumns(10);
		
		JLabel label_1 = new JLabel("Theory");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_2 = new JLabel("Practical");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label_3 = new JLabel("/");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("/");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		theorylectures = new JTextField();
		theorylectures.setEditable(false);
		theorylectures.setColumns(10);
		
		practicallectures = new JTextField();
		practicallectures.setEditable(false);
		practicallectures.setColumns(10);
		
		JLabel label_5 = new JLabel("total Lectures");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		Theoryprecentage = new JLabel("%");
		Theoryprecentage.setHorizontalAlignment(SwingConstants.CENTER);
		
		Practicalpercentage = new JLabel("%");
		Practicalpercentage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel percentagelabel = new JLabel("Precentage");
		percentagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSubjectName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addGap(24)
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(theoryattend, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(theorylectures, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(practicalattend, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(practicallectures, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Theoryprecentage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Practicalpercentage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(9))
						.addComponent(percentagelabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSubjectName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_5)
									.addComponent(percentagelabel)))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(label_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(theoryattend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(theorylectures, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Theoryprecentage))))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(label_2))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(practicalattend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(practicallectures, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Practicalpercentage)))))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		setLayout(groupLayout);
		
		loadsubjects(roll);
	}
	
	void loadsubjects(int rollno){
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
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		try {
			String query = "select * from subjects where semester = ? and year = ? and branch = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, semester);
			pst.setInt(2, year);
			pst.setString(3, branch);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				for(int i=1;i<=6;i++){
					if(!rst.getString("subject"+i).isEmpty()){
						dlm.addElement(rst.getString("subject"+i));
					}
				}
			}
			pst.close();
			rst.close();
			Subjects.setModel(dlm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
