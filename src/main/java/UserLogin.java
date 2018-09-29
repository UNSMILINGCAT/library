//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class UserLogin extends JFrame implements ActionListener
//{
//    DataBaseManager db = new DataBaseManager();
//    MainWindow mainFrame;
//    JPanel panel1, panel2;
//    JLabel userLabel, passwordLabel;
//    JTextField userTextField;
//    JPasswordField passwordTextField;
//    JButton YesBtn, cancelBtn;
//    Container c;
//    ResultSet rs;
//
//    public UserLogin(MainWindow mainFrame)
//    {
//        super("用户登录");
//        this.mainFrame = mainFrame;
//        userLabel = new JLabel("用户名", JLabel.CENTER);
//        passwordLabel = new JLabel("密码", JLabel.CENTER);
//        userTextField = new JTextField(10);
//        passwordTextField = new JPasswordField(10);
//        YesBtn = new JButton("确定");
//        cancelBtn = new JButton("取消");
//        YesBtn.addActionListener(this);
//        cancelBtn.addActionListener(this);
//        panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(2, 2));
//        panel2 = new JPanel();
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        panel1.add(userLabel);
//        panel1.add(userTextField);
//        panel1.add(passwordLabel);
//        panel1.add(passwordTextField);
//        c.add(panel1, BorderLayout.CENTER);
//        panel2.add(YesBtn);
//        panel2.add(cancelBtn);
//        c.add(panel2, BorderLayout.SOUTH);
//        setSize(300, 300);
//    }
//
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == cancelBtn)
//        {
//            mainFrame.setEnable("else");
//            this.dispose();
//        } else
//        {
//            char[] password = passwordTextField.getPassword();
//            String passwordSTR = new String(password);
//            if (userTextField.getText().trim().equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "用户名不可为空!");
//                return;
//            }
//            if (passwordSTR.equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "密码不可为空!");
//                return;
//            }
//            String strSQL;
//            strSQL = "use library select * from UserTable where userName='" +
//                    userTextField.getText().trim() + "'and passWord='" +
//                    passwordSTR + "'";
//            strSQL = "use library select * from UserTable";
//            rs = db.getResult(strSQL);
//
//            boolean isExist = false;
//            try
//            {
//                System.out.println(userTextField.getText().trim() + " " + passwordSTR + " " + rs.first() + " " + rs
//                        .getString("Power"));
//                isExist = rs.first();
//            } catch (SQLException sqle)
//            {
//                System.out.println(sqle.toString());
//            }
//            if (!isExist)
//            {
//                JOptionPane.showMessageDialog(null, "用户名不存在或者密码不正确!");
//                mainFrame.setEnable("else");
//            } else
//            {
//                try
//                {
//                    rs.first();
//                    mainFrame.setEnable(rs.getString("Power").trim());
//                    db.closeConnection();
//                    this.dispose();
//                } catch (SQLException sqle2)
//                {
//                    System.out.println(sqle2.toString());
//                }
//            }
//
//        }
//    }
//}