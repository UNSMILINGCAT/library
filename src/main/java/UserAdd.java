import com.librarymanager.dao.UserTableDAO;
import com.librarymanager.data.UserTable;
import org.hibernate.query.Query;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserAdd extends JFrame implements ActionListener
{
    UserTable userTable = new UserTable();
    DataBaseManager db = new DataBaseManager();
    ResultSet rs;
    Container c;
    JPanel panel1, panel2;
    JLabel UserLabel, PasswordLabel, PasswordConfirmLabel, LoginPrivelegeLabel;
    JTextField UserTextField;
    JPasswordField PasswordTextField, PasswordConfirmTextField;
    JComboBox LoginPrivelegeComboBox;
    JButton AddBtn, CancelBtn;

    public UserAdd()
    {
        super("添加用户");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        UserLabel = new JLabel("用户名", JLabel.CENTER);
        PasswordLabel = new JLabel("密码", JLabel.CENTER);
        PasswordConfirmLabel = new JLabel("确认密码", JLabel.CENTER);
        LoginPrivelegeLabel = new JLabel("登录权限", JLabel.CENTER);
        UserTextField = new JTextField(10);
        PasswordTextField = new JPasswordField(10);
        PasswordConfirmTextField = new JPasswordField(10);
        LoginPrivelegeComboBox = new JComboBox();
        LoginPrivelegeComboBox.addItem("系统管理员");
        LoginPrivelegeComboBox.addItem("书籍管理员");
        LoginPrivelegeComboBox.addItem("借阅管理员");
        AddBtn = new JButton("添加");
        CancelBtn = new JButton("取消");
        AddBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 2));
        panel1.add(UserLabel);
        panel1.add(UserTextField);
        panel1.add(PasswordLabel);
        panel1.add(PasswordTextField);
        panel1.add(PasswordConfirmLabel);
        panel1.add(PasswordConfirmTextField);
        panel1.add(LoginPrivelegeLabel);
        panel1.add(LoginPrivelegeComboBox);
        c.add(panel1, BorderLayout.CENTER);
        panel2 = new JPanel();
        panel2.add(AddBtn);
        panel2.add(CancelBtn);
        c.add(panel2, BorderLayout.SOUTH);
        setSize(300, 300);

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == CancelBtn)
        {
            this.dispose();
        } else if (e.getSource() == AddBtn)
        {
            if (UserTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "用户名不能为空！");
            } else if (PasswordTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "密码不能为空！");
            } else if (!PasswordTextField.getText().trim().equals(
                    PasswordConfirmTextField.getText().trim()))
            {
                JOptionPane.showMessageDialog(null, "两次输入的密码不一致！");
            } else
            {
                String hql = "from UserTable where userName=?";
                Query<UserTable> query = UserTableDAO.getQuery(hql);
                userTable.setUsername(UserTextField.getText().trim());
                query.setString(0, userTable.getUsername());
                if (UserTableDAO.selectUser(query) != null)
                {
                    JOptionPane.showMessageDialog(null, "此用户已经存在，请重新输入用户名！");
                } else
                {
                    userTable.setPassword(PasswordTextField.getText().trim());
                    userTable.setPower(LoginPrivelegeComboBox.getSelectedItem().toString());

                    if (UserTableDAO.addUser(userTable))
                    {
                        JOptionPane.showMessageDialog(null, "添加用户成功！");

                    } else
                    {
                        JOptionPane.showMessageDialog(null, "添加用户失败！");
                    }
                }
            }
        }
    }
}