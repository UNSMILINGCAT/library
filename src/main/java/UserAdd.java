import com.library.dao.BuildSqlSessionFactory;
import com.library.data.UserTable;
import com.library.mapper.UserTableMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserAdd extends JFrame implements ActionListener
{

    SqlSessionFactory sqlSessionFactory;

    SqlSession sqlSession;
    UserTable userTable;
    ResultSet rs;
    Container c;
    JPanel panel1, panel2;
    JLabel userLabel, passwordLabel, passwordConfirmLabel, loginPrivelegeLabel;
    JTextField userTextField;
    JPasswordField passwordTextField, passwordConfirmTextField;
    JComboBox loginPrivelegeComboBox;
    JButton addBtn, cancelBtn;

    public UserAdd()
    {
        super("添加用户");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        userLabel = new JLabel("用户名", JLabel.CENTER);
        passwordLabel = new JLabel("密码", JLabel.CENTER);
        passwordConfirmLabel = new JLabel("确认密码", JLabel.CENTER);
        loginPrivelegeLabel = new JLabel("登录权限", JLabel.CENTER);
        userTextField = new JTextField(10);
        passwordTextField = new JPasswordField(10);
        passwordConfirmTextField = new JPasswordField(10);
        loginPrivelegeComboBox = new JComboBox();
        loginPrivelegeComboBox.addItem("系统管理员");
        loginPrivelegeComboBox.addItem("书籍管理员");
        loginPrivelegeComboBox.addItem("借阅管理员");
        addBtn = new JButton("添加");
        cancelBtn = new JButton("取消");
        addBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 2));
        panel1.add(userLabel);
        panel1.add(userTextField);
        panel1.add(passwordLabel);
        panel1.add(passwordTextField);
        panel1.add(passwordConfirmLabel);
        panel1.add(passwordConfirmTextField);
        panel1.add(loginPrivelegeLabel);
        panel1.add(loginPrivelegeComboBox);
        c.add(panel1, BorderLayout.CENTER);
        panel2 = new JPanel();
        panel2.add(addBtn);
        panel2.add(cancelBtn);
        c.add(panel2, BorderLayout.SOUTH);
        setSize(300, 300);
        init();
    }

    /**
     * 进行数据库访问的一些初始化操作
     */
    public void init()
    {
        sqlSessionFactory = BuildSqlSessionFactory.buildSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cancelBtn)
        {
            this.dispose();
        } else if (e.getSource() == addBtn)
        {
            if (userTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "用户名不能为空！");
            } else if (passwordTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "密码不能为空！");
            } else if (!passwordTextField.getText().trim().equals(
                    passwordConfirmTextField.getText().trim()))
            {
                JOptionPane.showMessageDialog(null, "两次输入的密码不一致！");
            } else
            {
                UserTableMapper userTableMapper = sqlSession.getMapper(UserTableMapper.class);
                userTable = userTableMapper.select(userTextField.getText().trim());
                if (userTable != null)
                {
                    JOptionPane.showMessageDialog(null, "此用户已经存在，请重新输入用户名！");
                } else
                {
                    userTable = new UserTable();
                    userTable.setUsername(userTextField.getText().trim());
                    userTable.setPassword(passwordTextField.getText().trim());
                    userTable.setPower(loginPrivelegeComboBox.getSelectedItem().toString());
                    /*
                    如果没捕获异常则表示添加成功
                    如果捕获异常则添加失败
                     */
                    try
                    {
                        userTableMapper.addUser(userTable);
                        sqlSession.commit();
                        JOptionPane.showMessageDialog(null, "添加用户成功！");
                    } catch (Exception ex)
                    {
                        sqlSession.rollback();
                        JOptionPane.showMessageDialog(null, "添加用户失败！");
                    } finally
                    {
                        if (sqlSession != null)
                            sqlSession.close();
                    }
                }
            }
        }
    }
}