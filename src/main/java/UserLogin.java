import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserLogin extends JFrame implements ActionListener
{
    DataBaseManager db = new DataBaseManager();
    MainWindow mainFrame;
    JPanel panel1, panel2;
    JLabel UserLabel, PasswordLabel;
    JTextField UserTextField;
    JPasswordField PasswordTextField;
    JButton YesBtn, CancelBtn;
    Container c;
    ResultSet rs;

    public UserLogin(MainWindow mainFrame)
    {
        super("用户登录");
        this.mainFrame = mainFrame;
        UserLabel = new JLabel("用户名", JLabel.CENTER);
        PasswordLabel = new JLabel("密码", JLabel.CENTER);
        UserTextField = new JTextField(10);
        PasswordTextField = new JPasswordField(10);
        YesBtn = new JButton("确定");
        CancelBtn = new JButton("取消");
        YesBtn.addActionListener(this);
        CancelBtn.addActionListener(this);
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel2 = new JPanel();
        c = getContentPane();
        c.setLayout(new BorderLayout());
        panel1.add(UserLabel);
        panel1.add(UserTextField);
        panel1.add(PasswordLabel);
        panel1.add(PasswordTextField);
        c.add(panel1, BorderLayout.CENTER);
        panel2.add(YesBtn);
        panel2.add(CancelBtn);
        c.add(panel2, BorderLayout.SOUTH);
        setSize(300, 300);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == CancelBtn)
        {
            mainFrame.setEnable("else");
            this.dispose();
        } else
        {
            char[] password = PasswordTextField.getPassword();
            String passwordSTR = new String(password);
            if (UserTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "用户名不可为空!");
                return;
            }
            if (passwordSTR.equals(""))
            {
                JOptionPane.showMessageDialog(null, "密码不可为空!");
                return;
            }
            String strSQL;
            strSQL = "use library select * from UserTable where userName='" +
                    UserTextField.getText().trim() + "'and passWord='" +
                    passwordSTR + "'";
            strSQL = "use library select * from UserTable";
            rs = db.getResult(strSQL);

            boolean isExist = false;
            try
            {
                System.out.println(UserTextField.getText().trim() + " " + passwordSTR + " " + rs.first() + " " + rs
                        .getString("Power"));
                isExist = rs.first();
            } catch (SQLException sqle)
            {
                System.out.println(sqle.toString());
            }
            if (!isExist)
            {
                JOptionPane.showMessageDialog(null, "用户名不存在或者密码不正确!");
                mainFrame.setEnable("else");
            } else
            {
                try
                {
                    rs.first();
                    mainFrame.setEnable(rs.getString("Power").trim());
                    db.closeConnection();
                    this.dispose();
                } catch (SQLException sqle2)
                {
                    System.out.println(sqle2.toString());
                }
            }

        }
    }
}