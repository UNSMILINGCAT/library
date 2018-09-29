//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//public class BookDelete extends JFrame implements ActionListener
//{
//	DataBaseManager db=new DataBaseManager();
//	ResultSet rs;
//	Container c;
//	JLabel TipLabel=new JLabel("请输入要删除的书名：",JLabel.CENTER);
//	JTextField BookDeleteTextField=new JTextField(15);
//	JButton YesBtn,ExitBtn;
//	JPanel panel1=new JPanel();
//	public BookDelete()
//	{
//		super("删除书籍信息");
//		c=getContentPane();
//		c.setLayout(new BorderLayout());
//		c.add(TipLabel,BorderLayout.NORTH);
//		c.add(BookDeleteTextField,BorderLayout.CENTER);
//		YesBtn=new JButton("确定");
//		ExitBtn=new JButton("退出");
//		YesBtn.addActionListener(this);
//		ExitBtn.addActionListener(this);
//		panel1.add(YesBtn);
//		panel1.add(ExitBtn);
//		c.add(panel1,BorderLayout.SOUTH);
//	}
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==ExitBtn)
//		{
//			this.dispose();
//		}
//		else if(e.getSource()==YesBtn)
//		{
//			try
//			{
//			String strSQL="select borrowed_count from books where bookName='"+
//			BookDeleteTextField.getText().trim()+"'";
//			rs=db.getResult(strSQL);
//			if(!rs.first())
//			{
//				JOptionPane.showMessageDialog(null,"书库里没有你要删除的书！");
//			}
//			else
//			{
//				String strSql="delete from books where bookName='"+
//				BookDeleteTextField.getText().trim()+"'";
//				rs.first();
//				int count=rs.getInt(1);
//				if(!(count==0))
//				{
//					JOptionPane.showMessageDialog(null,"此书还有学生没有还！\n现在还不能从书库中删除。。。");
//					this.dispose();
//				}
//				else if(db.updateSql(strSql))
//				{
//					JOptionPane.showMessageDialog(null,"删除成功！");
//					db.closeConnection();
//					this.dispose();
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null,"删除失败！");
//					db.closeConnection();
//					this.dispose();
//				}
//			}
//		}
//		catch(SQLException sqle)
//	        {
//		    System.out.println(sqle.toString());
//	        }
//	        catch(Exception ex)
//	        {
//		    System.out.println(ex.toString());
//	        }
//		}
//	}
//}