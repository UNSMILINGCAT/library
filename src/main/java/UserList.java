//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//import javax.swing.table.*;
//import java.util.Vector;
//
//public class UserList extends JFrame
//{
//    DataBaseManager db = new DataBaseManager();
//    ResultSet rs;
//    Container c;
//    JTable table = null;
//    DefaultTableModel defaultModel = null;
//
//    public UserList()
//    {
//        super("用户列表一览！");
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        String[] name = {"用户名", "权限"};
//        String[][] data = new String[0][0];
//        defaultModel = new DefaultTableModel(data, name);
//        table = new JTable(defaultModel);
//        table.setPreferredScrollableViewportSize(new Dimension(400, 80));
//        JScrollPane s = new JScrollPane(table);
//        c.add(s);
//        try
//        {
//            String strSql = "use library select userName,power from userTable";
//            rs = db.getResult(strSql);
//            while (rs.next())
//            {
//                Vector insertRow = new Vector();
//                insertRow.addElement(rs.getString(1));
//                insertRow.addElement(rs.getString(2));
//                defaultModel.addRow(insertRow);
//            }
//            table.revalidate();
//        } catch (SQLException sqle)
//        {
//            System.out.println(sqle.toString());
//        } catch (Exception ex)
//        {
//            System.out.println(ex.toString());
//        }
//    }
//}