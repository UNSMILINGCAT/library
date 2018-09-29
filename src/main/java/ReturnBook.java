//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//public class ReturnBook extends JFrame implements ActionListener
//{
//	DataBaseManager db=new DataBaseManager();
//	ResultSet rs;
//	JPanel panel1,panel2;
//	Container c;
//	JLabel ReturnedBookStudentLabel,ReturnedBookNameLabel,
//			ReturnedDateLabel,ReturnedCommentLabel;
//	JTextField ReturnedBookStudentTextField,
//			ReturnedDateTextField,ReturnedCommentTextField;
//	JButton ClearBtn,YesBtn,CancelBtn;
//	JComboBox BookNameComboBox=new JComboBox();
//	public ReturnBook()
//	{
//		super("书籍还入");
//		c=getContentPane();
//		c.setLayout(new BorderLayout());
//		ReturnedBookStudentLabel=new JLabel("还书者姓名",JLabel.CENTER);
//		ReturnedBookNameLabel=new JLabel("书名",JLabel.CENTER);
//		ReturnedDateLabel=new JLabel("日期",JLabel.CENTER);
//		ReturnedCommentLabel=new JLabel("备注",JLabel.CENTER);
//		ReturnedBookStudentTextField=new JTextField(15);
//		ReturnedDateTextField=new JTextField(15);
//		ReturnedCommentTextField=new JTextField(15);
//		try
//		{
//			String s="";
//			String strSQL="use library select bookName from bookBrowse";
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
//		panel1.setLayout(new GridLayout(4,2));
//		panel1.add(ReturnedBookStudentLabel);
//		panel1.add(ReturnedBookStudentTextField);
//		panel1.add(ReturnedBookNameLabel);
//		panel1.add(BookNameComboBox);
//		panel1.add(ReturnedDateLabel);
//		panel1.add(ReturnedDateTextField);
//		panel1.add(ReturnedCommentLabel);
//		panel1.add(ReturnedCommentTextField);
//		c.add(panel1,BorderLayout.CENTER);
//		panel2=new JPanel();
//		panel2.setLayout(new GridLayout(1,3));
//		ClearBtn=new JButton("清空");
//		YesBtn=new JButton("确定");
//		CancelBtn=new JButton("取消");
//		ClearBtn.addActionListener(this);
//		YesBtn.addActionListener(this);
//		CancelBtn.addActionListener(this);
//		panel2.add(ClearBtn);
//		panel2.add(YesBtn);
//		panel2.add(CancelBtn);
//		c.add(panel2,BorderLayout.SOUTH);
//	}
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==CancelBtn)
//		{
//			this.dispose();
//		}
//		else if(e.getSource()==ClearBtn)
//		{
//			ReturnedBookStudentTextField.setText("");
//			ReturnedDateTextField.setText("");
//			ReturnedCommentTextField.setText("");
//
//		}
//		else if(e.getSource()==YesBtn)
//		{
//			if(ReturnedBookStudentTextField.getText().trim().equals(""))
//			{
//				JOptionPane.showMessageDialog(null,"请输入还书者的姓名。。。");
//			}
//			else if(BookNameComboBox.getSelectedItem().equals(""))
//			{
//				JOptionPane.showMessageDialog(null,"图书馆没有出借过书！");
//			}
//			else
//			{
//				try
//				{
//					String strSQL="use library update bookBrowse set returnDate='"+
//							ReturnedDateTextField.getText().trim()+"',com='"+
//							ReturnedCommentTextField.getText().trim()+"',is_returned='是' where studentName='"+
//							ReturnedBookStudentTextField.getText().trim()+"'and bookName='"+
//							BookNameComboBox.getSelectedItem()+"'";
//					if(db.updateSql(strSQL))
//					{
//						JOptionPane.showMessageDialog(null,"还书完成！");
//						strSQL="use library update books set borrowed_count=borrowed_count-1 where bookname='"+
//								BookNameComboBox.getSelectedItem()+"'";
//						db.updateSql(strSQL);
//						db.closeConnection();
//						this.dispose();
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null,"还书失败！");
//						db.closeConnection();
//						this.dispose();
//					}
//				}
//				catch(Exception ex)
//				{
//					System.out.println(ex.toString());
//				}
//			}
//		}
//	}
//}