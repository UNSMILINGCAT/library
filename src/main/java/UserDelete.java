//import com.librarymanager.dao.UserTableDAO;
//import com.librarymanager.data.UserTable;
//import org.hibernate.query.Query;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class UserDelete extends JFrame implements ActionListener
//{
//    UserTable userTable = new UserTable();
//    DataBaseManager db = new DataBaseManager();
//    ResultSet rs;
//    JPanel panel1, panel2;
//    Container c;
//    JLabel UserLabel, PasswordLabel;
//    JTextField UserTextField;
//    JPasswordField PasswordTextField;
//    JButton YesBtn, CancelBtn;
//
//    public UserDelete()
//    {
//        super("删除用户");
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        UserLabel = new JLabel("用户名", JLabel.CENTER);
//        PasswordLabel = new JLabel("密码", JLabel.CENTER);
//        UserTextField = new JTextField(10);
//        PasswordTextField = new JPasswordField(10);
//        YesBtn = new JButton("确定");
//        CancelBtn = new JButton("取消");
//        YesBtn.addActionListener(this);
//        CancelBtn.addActionListener(this);
//        panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(2, 2));
//        panel1.add(UserLabel);
//        panel1.add(UserTextField);
//        panel1.add(PasswordLabel);
//        panel1.add(PasswordTextField);
//        panel2 = new JPanel();
//        panel2.add(YesBtn);
//        panel2.add(CancelBtn);
//        c.add(panel1, BorderLayout.CENTER);
//        c.add(panel2, BorderLayout.SOUTH);
//        setSize(300, 300);
//    }
//
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == CancelBtn)
//        {
//            this.dispose();
//        } else if (e.getSource() == YesBtn)
//        {
//            String hql = "from UserTable where userName=? and passWord=?";
//            String sql = "delete from UserTable where userName=? and passWord=?";
//            Query<UserTable> query = UserTableDAO.getQuery(hql);
//            char[] password = PasswordTextField.getPassword();
//            String passwordSTR = new String(password);
//            userTable.setUsername(UserTextField.getText().trim());
//            userTable.setPassword(passwordSTR);
//            query.setString(0, userTable.getUsername());
//            query.setString(1, userTable.getPassword());
//            if (UserTextField.getText().trim().equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "用户名不能为空！");
//            } else if (PasswordTextField.equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "密码不能为空！");
//            } else if (UserTableDAO.selectUser(query) != null)
//            {
//                query = UserTableDAO.getSQLQuery(sql);
//                query.setString(0, userTable.getUsername());
//                query.setString(1, userTable.getPassword());
//                if (UserTableDAO.delete(query))
//                {
//                    JOptionPane.showMessageDialog(null, "删除成功!");
//                    this.dispose();
//
//                } else
//                {
//                    JOptionPane.showMessageDialog(null, "删除失败！");
//                    this.dispose();
//                }
//
//                db.closeConnection();
//            } else
//            {
//                JOptionPane.showMessageDialog(null, "不存在此用户或者密码错误！");
//            }
//        }
//    }
//}