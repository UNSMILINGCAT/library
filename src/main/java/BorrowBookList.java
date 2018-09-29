//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//import javax.swing.table.*;
//import java.util.Vector;
//public class BorrowBookList extends JFrame implements ActionListener
//{
//	DataBaseManager db=new DataBaseManager();
//	ResultSet rs;
//	Container c;
//	JPanel panel1,panel2;
//	JLabel BookNameLabel,StudentNameLabel;
//	JTextField BookNameTextField,StudentNameTextField;
//	JButton SearchBtn,ExitBtn;
//	JTable table=null;
//	DefaultTableModel defaultModel=null;
//	public BorrowBookList()
//	{
//		super("书籍借阅一览！");
//		c=getContentPane();
//		c.setLayout(new BorderLayout());
//		BookNameLabel=new JLabel("书名   ",JLabel.CENTER);
//		StudentNameLabel=new JLabel("借阅者",JLabel.CENTER);
//		BookNameTextField=new JTextField(15);
//		StudentNameTextField=new JTextField(15);
//		SearchBtn=new JButton("查询");
//		ExitBtn=new JButton("退出");
//		SearchBtn.addActionListener(this);
//		ExitBtn.addActionListener(this);
//		Box box1=Box.createHorizontalBox();
//		box1.add(StudentNameLabel);
//		box1.add(StudentNameTextField);
//		box1.add(SearchBtn);
//		Box box2=Box.createHorizontalBox();
//		box2.add(BookNameLabel);
//		box2.add(BookNameTextField);
//		box2.add(ExitBtn);
//		Box boxH=Box.createVerticalBox();
//		boxH.add(box1);
//		boxH.add(box2);
//		boxH.add(Box.createVerticalGlue());
//		panel1=new JPanel();
//		panel1.add(boxH);
//		panel2=new JPanel();
//		String[] name={"借阅者","书名","借阅日期","还入日期","备注"};
//		String[][] data=new String[0][0];
//		defaultModel=new DefaultTableModel(data,name);
//		table=new JTable(defaultModel);
//		table.setPreferredScrollableViewportSize(new Dimension(400,80));
//		JScrollPane s=new JScrollPane(table);
//		panel2.add(s);
//		c.add(panel1,BorderLayout.NORTH);
//		c.add(panel2,BorderLayout.SOUTH);
//	}
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==ExitBtn)
//	        {
//		    db.closeConnection();
//		    this.dispose();
//	        }
//	        else if(e.getSource()==SearchBtn)
//	        {
//	        	String strSQL="use library select studentname,bookname,borrowdate,returndate,com from bookBrowse";
//	        	String strSql=null;
//	        	if(StudentNameTextField.getText().trim().equals("")&&
//	        	   BookNameTextField.getText().trim().equals(""))
//	        	 {
//	        	 	strSql=strSQL;
//	        	 }
//	        	 else if(StudentNameTextField.getText().trim().equals(""))
//	        	 {
//	        	 	strSql=strSQL+" where bookName='"+
//	        	 	BookNameTextField.getText().trim()+"'";
//	        	}
//	        	else if(BookNameTextField.getText().trim().equals(""))
//	        	{
//	        		strSql=strSQL+" where studentName='"+
//	        		StudentNameTextField.getText().trim()+"'";
//	        	}
//	        	else
//	        	{
//	        		strSql=strSQL+" where studentName='"+
//	        		StudentNameTextField.getText().trim()+"'and bookName='"+
//	        		BookNameTextField.getText().trim()+"'";
//	        	}
//	        	try
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
//	        }
//	}
//}