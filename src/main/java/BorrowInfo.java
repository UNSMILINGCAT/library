//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class BorrowInfo extends JFrame implements ActionListener {
//	DataBaseManager db = new DataBaseManager();
//	ResultSet rs;
//	JPanel panel1, panel2, panel3;
//	Container c;
//	JLabel TipLabel = new JLabel("输入借阅者姓名和书名点击确定，将调出此书的相关信息");
//	JLabel BorrowedBookStudentLabel, BorrowedBookNameLabel, BorrowedDateLabel,
//			BorrowedCommentLabel;
//	JTextField BorrowedBookStudentTextField, BorrowedBookNameTextField,
//			BorrowedDateTextField, BorrowedCommentTextField;
//	JButton ClearBtn, YesBtn, UpdateBtn, CancelBtn;
//
//	public BorrowInfo() {
//		super("修改书籍出借信息");
//		c = getContentPane();
//		c.setLayout(new BorderLayout());
//		panel3 = new JPanel();
//		panel3.add(TipLabel);
//		c.add(panel3, BorderLayout.NORTH);
//		BorrowedBookStudentLabel = new JLabel("借阅者姓名", JLabel.CENTER);
//		BorrowedBookNameLabel = new JLabel("书名", JLabel.CENTER);
//		BorrowedDateLabel = new JLabel("借书日期", JLabel.CENTER);
//		BorrowedCommentLabel = new JLabel("备注", JLabel.CENTER);
//		BorrowedBookStudentTextField = new JTextField(15);
//		BorrowedBookNameTextField = new JTextField(15);
//		BorrowedDateTextField = new JTextField(15);
//		BorrowedCommentTextField = new JTextField(15);
//		panel1 = new JPanel();
//		panel1.setLayout(new GridLayout(4, 2));
//		panel1.add(BorrowedBookStudentLabel);
//		panel1.add(BorrowedBookStudentTextField);
//		panel1.add(BorrowedBookNameLabel);
//		panel1.add(BorrowedBookNameTextField);
//		panel1.add(BorrowedDateLabel);
//		panel1.add(BorrowedDateTextField);
//		panel1.add(BorrowedCommentLabel);
//		panel1.add(BorrowedCommentTextField);
//		c.add(panel1, BorderLayout.CENTER);
//		panel2 = new JPanel();
//		panel2.setLayout(new GridLayout(1, 4));
//		ClearBtn = new JButton("清空");
//		YesBtn = new JButton("确定");
//		UpdateBtn = new JButton("更新");
//		CancelBtn = new JButton("取消");
//		ClearBtn.addActionListener(this);
//		YesBtn.addActionListener(this);
//		UpdateBtn.addActionListener(this);
//		UpdateBtn.setEnabled(false);
//		CancelBtn.addActionListener(this);
//		panel2.add(ClearBtn);
//		panel2.add(YesBtn);
//		panel2.add(UpdateBtn);
//		panel2.add(CancelBtn);
//		c.add(panel2, BorderLayout.SOUTH);
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == ClearBtn) {
//			BorrowedBookStudentTextField.setText("");
//			BorrowedBookNameTextField.setText("");
//			BorrowedDateTextField.setText("");
//			BorrowedCommentTextField.setText("");
//		} else if (e.getSource() == CancelBtn) {
//			this.dispose();
//		} else if (e.getSource() == YesBtn) {
//			try {
//				String strSQL = "use library select studentName,bookName,borrowDate,com from BookBrowse where studentName='"
//						+ BorrowedBookStudentTextField.getText().trim()
//						+ "'and bookName='"
//						+ BorrowedBookNameTextField.getText().trim() + "'";
//				rs = db.getResult(strSQL);
//				if (!rs.first()) {
//					JOptionPane.showMessageDialog(null, "此学生没有借过书！或者没有此书！");
//
//				} else {
//					BorrowedBookStudentTextField.setText(rs.getString(1));
//					BorrowedBookNameTextField.setText(rs.getString(2));
//					BorrowedDateTextField.setText(rs.getString(3));
//					BorrowedCommentTextField.setText(rs.getString(4));
//					UpdateBtn.setEnabled(true);
//
//				}
//			} catch (Exception ex) {
//				System.out.println(ex.toString());
//			}
//
//		} else if (e.getSource() == UpdateBtn) {
//			String strSQL = "use library update bookBrowse set borrowDate='"
//					+ BorrowedDateTextField.getText().trim() + "',com='"
//					+ BorrowedCommentTextField.getText().trim()
//					+ "' where studentName='"
//					+ BorrowedBookStudentTextField.getText().trim()
//					+ "'and bookName='"
//					+ BorrowedBookNameTextField.getText().trim() + "'";
//			if (db.updateSql(strSQL)) {
//				JOptionPane.showMessageDialog(null, "更新成功！");
//				db.closeConnection();
//				this.dispose();
//			} else {
//				JOptionPane.showMessageDialog(null, "更新失败！");
//				db.closeConnection();
//				this.dispose();
//			}
//		}
//
//	}
//}