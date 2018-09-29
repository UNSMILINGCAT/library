//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//public class BorrowBook extends JFrame implements ActionListener
//{
//	DataBaseManager db=new DataBaseManager();
//	ResultSet rs;
//	JPanel panel1,panel2;
//	Container c;
//	JLabel BorrowedBookStudentLabel,BorrowedBookNameLabel,
//	       BorrowedDateLabel,ReturnDateLabel,BorrowedCommentLabel;
//	JTextField BorrowedBookStudentTextField,
//	           BorrowedDateTextField,ReturnDateTextField,BorrowedCommentTextField;
//	JButton ClearBtn,YesBtn,cancelBtn;
//	JComboBox BookNameComboBox=new JComboBox();
//	public BorrowBook()
//	{
//		super("书籍出借");
//		c=getContentPane();
//		c.setLayout(new BorderLayout());
//		BorrowedBookStudentLabel=new JLabel("借阅者姓名",JLabel.CENTER);
//		BorrowedBookNameLabel=new JLabel("书名",JLabel.CENTER);
//		BorrowedDateLabel=new JLabel("借阅日期",JLabel.CENTER);
//		ReturnDateLabel=new JLabel("归还日期",JLabel.CENTER);
//		BorrowedCommentLabel=new JLabel("备注",JLabel.CENTER);
//		BorrowedBookStudentTextField=new JTextField(15);
//		BorrowedDateTextField=new JTextField(15);
//		ReturnDateTextField=new JTextField(15);
//		BorrowedCommentTextField=new JTextField(15);
//		try
//		{
//			String strSQL="use library select bookName from books ";
//			rs=db.getResult(strSQL);
//			while(rs.next())
//			{
//				BookNameComboBox.addItem(rs.getString(1));
//			}
//		}
//		catch(SQLException sqle)
//		{
//			System.out.println(sqle.toString());
//		}
//		catch(Exception ex)
//		{
//			System.out.println(ex.toString());
//		}
//		panel1=new JPanel();
//		panel1.setLayout(new GridLayout(5,2));
//		panel1.add(BorrowedBookStudentLabel);
//		panel1.add(BorrowedBookStudentTextField);
//		panel1.add(BorrowedBookNameLabel);
//		panel1.add(BookNameComboBox);
//		panel1.add(BorrowedDateLabel);
//		panel1.add(BorrowedDateTextField);
//		panel1.add(ReturnDateLabel);
//		panel1.add(ReturnDateTextField);
//		panel1.add(BorrowedCommentLabel);
//		panel1.add(BorrowedCommentTextField);
//		c.add(panel1,BorderLayout.CENTER);
//		panel2=new JPanel();
//		panel2.setLayout(new GridLayout(1,3));
//		ClearBtn=new JButton("清空");
//		YesBtn=new JButton("确定");
//		cancelBtn=new JButton("取消");
//		ClearBtn.addActionListener(this);
//		YesBtn.addActionListener(this);
//		cancelBtn.addActionListener(this);
//		panel2.add(ClearBtn);
//		panel2.add(YesBtn);
//		panel2.add(cancelBtn);
//		c.add(panel2,BorderLayout.SOUTH);
//
//	}
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==cancelBtn)
//		{
//			this.dispose();
//		}
//		else if(e.getSource()==ClearBtn)
//		{
//			BorrowedBookStudentTextField.setText("");
//		        BorrowedDateTextField.setText("");
//		        BorrowedCommentTextField.setText("");
//
//		}
//		else if(e.getSource()==YesBtn)
//		{
//			if(BorrowedBookStudentTextField.getText().trim().equals(""))
//			{
//				JOptionPane.showMessageDialog(null,"请输入借阅者的姓名。。。");
//			}
//			else if(BookNameComboBox.getSelectedItem().equals(""))
//			{
//				JOptionPane.showMessageDialog(null,"对不起，现在书库里没有书，\n你现在不能借书!");
//			}
//			else
//			{
//				try
//				{
//				String strSQL="use library insert into bookBrowse(studentname,bookname,borrowdate,returndate,com) values('"+
//				BorrowedBookStudentTextField.getText().trim()+"','"+BookNameComboBox.getSelectedItem()+"','"+
//				BorrowedDateTextField.getText().trim()+"','"+
//				ReturnDateTextField.getText().trim()+"','"+
//				BorrowedCommentTextField.getText().trim()+"')";
//
//				if(db.updateSql(strSQL))
//				{
//					JOptionPane.showMessageDialog(null,"借阅完成！");
//					strSQL="update books set borrowed_count=borrowed_count+1 where bookname='"+
//					BookNameComboBox.getSelectedItem()+"'";
//
//					db.updateSql(strSQL);
//					db.closeConnection();
//					this.dispose();
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null,"借阅失败！");
//					db.closeConnection();
//					this.dispose();
//				}
//			}
//		catch(Exception ex)
//		{
//			System.out.println(ex.toString());
//		}
//			}
//		}
//
//	}
//}