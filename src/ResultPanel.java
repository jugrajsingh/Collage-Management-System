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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


public class ResultPanel extends JPanel {
	private JTextField TheoryMarks;
	private JTextField TheoryTotal;
	private JTextField PracticalMarks;
	private JTextField PracticalTotal;
	private JLabel Theoryprecentage;
	private JLabel Practicalpercentage;
	private JList<String> Subjects;
	private Connection connection;

	/**
	 * Create the panel.
	 */
	public ResultPanel(int roll) {
		connection = DBConnect.dbconnect();
		
		JLabel label = new JLabel("Subject Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblMarksObtained = new JLabel("Marks Obtained");
		lblMarksObtained.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarksObtained.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTotalMarks = new JLabel("Total Marks");
		lblTotalMarks.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalMarks.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_3 = new JLabel("Theory");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		TheoryMarks = new JTextField();
		TheoryMarks.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TheoryMarks.setEditable(false);
		TheoryMarks.setColumns(10);
		
		JLabel label_4 = new JLabel("/");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		TheoryTotal = new JTextField();
		TheoryTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TheoryTotal.setEditable(false);
		TheoryTotal.setColumns(10);
		
		JLabel label_5 = new JLabel("Practical");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		PracticalMarks = new JTextField();
		PracticalMarks.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PracticalMarks.setEditable(false);
		PracticalMarks.setColumns(10);
		
		JLabel label_6 = new JLabel("/");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		PracticalTotal = new JTextField();
		PracticalTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		PracticalTotal.setEditable(false);
		PracticalTotal.setColumns(10);
		
		Theoryprecentage = new JLabel("%");
		Theoryprecentage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Theoryprecentage.setHorizontalAlignment(SwingConstants.CENTER);
		
		Practicalpercentage = new JLabel("%");
		Practicalpercentage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Practicalpercentage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_9 = new JLabel("Precentage");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(PracticalMarks, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(TheoryMarks, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addComponent(lblMarksObtained, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(4)))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTotalMarks, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(TheoryTotal, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(PracticalTotal, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_9, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addComponent(Theoryprecentage, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addComponent(Practicalpercentage, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))
					.addGap(17))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(label_3)
							.addGap(29)
							.addComponent(label_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMarksObtained)
							.addGap(17)
							.addComponent(TheoryMarks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(PracticalMarks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTotalMarks)
							.addGap(17)
							.addComponent(TheoryTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(PracticalTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_9)
							.addGap(20)
							.addComponent(Theoryprecentage, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(Practicalpercentage, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(24))
		);
		
		Subjects = new JList<String>();
		Subjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Subjects.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()>=2){
					if(Subjects.getSelectedIndex()>-1){
						try {
							String query = "select * from student_result where rollno = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, roll);
							ResultSet rst = pst.executeQuery();
							if(rst.next()){
								TheoryMarks.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"t"));
								if(Subjects.getSelectedIndex()<5){
									PracticalMarks.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"p"));
								}
								else{
									PracticalMarks.setText("");
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
							String query = "select * from total_marks where semester = ? and year = ? and branch = ?";
							PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, semester);
							pst.setInt(2, year);
							pst.setString(3, branch);
							ResultSet rst = pst.executeQuery();
							if(rst.next()){
								Formatter fmt = new Formatter();
								Formatter fmt1 = new Formatter();
								TheoryTotal.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"t"));
								fmt.format("%.2f", (Double.parseDouble(TheoryMarks.getText())/Double.parseDouble(TheoryTotal.getText()))*100);
								Theoryprecentage.setText(fmt+"%");
								if(Subjects.getSelectedIndex()<5){
									PracticalTotal.setText(rst.getString("subject"+(Subjects.getSelectedIndex()+1)+"p"));
									fmt1.format("%.2f", (Double.parseDouble(PracticalMarks.getText())/Double.parseDouble(PracticalTotal.getText()))*100);
									Practicalpercentage.setText(fmt1+"%");
								}
								else{
									PracticalTotal.setText("");
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
		scrollPane.setViewportView(Subjects);
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
