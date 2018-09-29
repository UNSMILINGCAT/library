//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//import javax.swing.table.*;
//import java.util.Vector;
//public class BookList extends JFrame implements ActionListener
//{
//	DataBaseManager db=new DataBaseManager();
//	ResultSet rs;
//	Container c;
//	JPanel panel1,panel2,panel3;
//	JLabel BookNameLabel,AuthorLabel,PressLabel;
//	JTextField BookNameTextField,AuthorTextField,
//	           PressTextField;
//	JButton SearchBtn,ExitBtn;
//	JTable table=null;
//	DefaultTableModel defaultModel=null;
//	public BookList()
//	{
//		super("书籍信息一览！");
//		c=getContentPane();
//		c.setLayout(new BorderLayout());
//		BookNameLabel=new JLabel("名称",JLabel.CENTER);
//		AuthorLabel=new JLabel("作者",JLabel.CENTER);
//		PressLabel=new JLabel("出版社",JLabel.CENTER);
//		BookNameTextField=new JTextField(15);
//		AuthorTextField=new JTextField(15);
//		PressTextField=new JTextField(15);
//		SearchBtn=new JButton("查询");
//		SearchBtn.addActionListener(this);
//		ExitBtn=new JButton("退出");
//		ExitBtn.addActionListener(this);
//		panel1=new JPanel();
//		panel3=new JPanel();
//		panel1.add(BookNameLabel);
//		panel1.add(BookNameTextField);
//		panel1.add(AuthorLabel);
//		panel1.add(AuthorTextField);
//		panel3.add(PressLabel);
//		panel3.add(PressTextField);
//		panel3.add(SearchBtn);
//		panel3.add(ExitBtn);
//		String[] name={"书名","出版社","作者","地址","出版日期","定价","评论"};
//		String[][] data=new String[0][0];
//		defaultModel=new DefaultTableModel(data,name);
//		table=new JTable(defaultModel);
//		table.setPreferredScrollableViewportSize(new Dimension(400,80));
//		JScrollPane s=new JScrollPane(table);
//		panel2=new JPanel();
//		panel2.add(s);
//		c.add(panel1,BorderLayout.NORTH);
//		c.add(panel3,BorderLayout.CENTER);
//		c.add(panel2,BorderLayout.SOUTH);
//	}
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==SearchBtn)
//		{
//		String strSQL="use library select bookName,press,author,address,pressDate,price,com from books";
//		String strSql=null;
//		if(BookNameTextField.getText().trim().equals("")&&
//		   AuthorTextField.getText().trim().equals("")&&
//		   PressTextField.getText().trim().equals(""))
//		{
//			strSql=strSQL;
//		}
//		else if(BookNameTextField.getText().trim().equals("")&&
//		        AuthorTextField.getText().trim().equals(""))
//		        {
//		        	strSql=strSQL+" where press='"+PressTextField.getText().trim()+"'";
//		        }
//		else if(BookNameTextField.getText().trim().equals("")&&
//		        PressTextField.getText().trim().equals(""))
//		        {
//		        	strSql=strSQL+" where author='"+AuthorTextField.getText().trim()+"'";
//		        }
//	        else if(AuthorTextField.getText().trim().equals("")&&
//		        PressTextField.getText().trim().equals(""))
//		        {
//		        	strSql=strSQL+" where bookName='"+BookNameTextField.getText().trim()+"'";
//		        }
//		else if(BookNameTextField.getText().trim().equals(""))
//		       {
//		       	        strSql=strSQL+" where author='"+AuthorTextField.getText().trim()+
//		       	        "'and press='"+PressTextField.getText().trim()+"'";
//		       }
//		else if(AuthorTextField.getText().trim().equals(""))
//		       {
//		       	        strSql=strSQL+" where bookName='"+BookNameTextField.getText().trim()+
//		       	        "'and press='"+PressTextField.getText().trim()+"'";
//		       }
//		 else if(PressTextField.getText().trim().equals(""))
//		       {
//		       	        strSql=strSQL+" where bookname='"+BookNameTextField.getText().trim()+
//		       	        "'and author='"+AuthorTextField.getText().trim()+"'";
//		       }
//		 else
//		 {
//		 	strSql=strSQL+" where bookname='"+BookNameTextField.getText().trim()+
//		       	        "'and author='"+AuthorTextField.getText().trim()+"'and press='"+
//		       	        PressTextField.getText().trim()+"'";
//		}
//		try
//		{
//	        //首先要删除table中的数据先：
//	        int rowCount=defaultModel.getRowCount()-1;//取得table中的数据行；
//	        int j=rowCount;
//	        for(int i=0;i<=rowCount;i++)
//	        {
//	        	defaultModel.removeRow(j);//删除rowCount行的数据；
//	        	defaultModel.setRowCount(j);//重新设置行数；
//	        	j=j-1;
//	        }
//		rs=db.getResult(strSql);
//		while(rs.next())
//		{
//			Vector data=new Vector();
//			data.addElement(rs.getString(1));
//			data.addElement(rs.getString(2));
//			data.addElement(rs.getString(3));
//			data.addElement(rs.getString(4));
//			data.addElement(rs.getString(5));
//			data.addElement(rs.getString(6));
//			data.addElement(rs.getString(7));
//			defaultModel.addRow(data);
//		}
//		table.revalidate();
//	}
//	catch(SQLException sqle)
//		{
//			System.out.println(sqle.toString());
//		}
//	catch(Exception ex)
//		{
//			System.out.println(ex.toString());
//		}
//	}
//	else if(e.getSource()==ExitBtn)
//	{
//		db.closeConnection();
//		this.dispose();
//	}
//}
//}