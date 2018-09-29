//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class BookModify extends JFrame implements ActionListener
//{
//    DataBaseManager db = new DataBaseManager();
//    ResultSet rs;
//    JPanel panel1, panel2, panel3;
//    JLabel TipLabel = new JLabel("输入书名点确定，将调出此书相关信息");
//    JLabel BookNameLabel, PressNameLabel, AuthorLabel, AddressLabel,
//            PressDateLabel, PriceLabel, CommentLabel;
//    JTextField BookNameTextField, PressNameTextField, AuthorTextField,
//            AddressTextField, PressDateTextField, PriceTextField,
//            CommentTextField;
//    Container c;
//    JButton ClearBtn, YesBtn, UpdateBtn, ExitBtn;
//
//    public BookModify()
//    {
//        super("修改书籍信息");
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        panel3 = new JPanel();
//        panel3.add(TipLabel);
//        c.add(panel3, BorderLayout.NORTH);
//        BookNameLabel = new JLabel("名称", JLabel.CENTER);
//        PressNameLabel = new JLabel("出版社", JLabel.CENTER);
//        AuthorLabel = new JLabel("作者", JLabel.CENTER);
//        AddressLabel = new JLabel("地址", JLabel.CENTER);
//        PressDateLabel = new JLabel("出版日期", JLabel.CENTER);
//        PriceLabel = new JLabel("价格", JLabel.CENTER);
//        CommentLabel = new JLabel("备注", JLabel.CENTER);
//        BookNameTextField = new JTextField(15);
//        PressNameTextField = new JTextField(15);
//        AuthorTextField = new JTextField(15);
//        AddressTextField = new JTextField(15);
//        PressDateTextField = new JTextField(15);
//        PriceTextField = new JTextField(15);
//        CommentTextField = new JTextField(15);
//        panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(7, 2));
//        panel1.add(BookNameLabel);
//        panel1.add(BookNameTextField);
//        panel1.add(PressNameLabel);
//        panel1.add(PressNameTextField);
//        panel1.add(AuthorLabel);
//        panel1.add(AuthorTextField);
//        panel1.add(AddressLabel);
//        panel1.add(AddressTextField);
//        panel1.add(PressDateLabel);
//        panel1.add(PressDateTextField);
//        panel1.add(PriceLabel);
//        panel1.add(PriceTextField);
//        panel1.add(CommentLabel);
//        panel1.add(CommentTextField);
//        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(1, 4));
//        ClearBtn = new JButton("清空");
//        YesBtn = new JButton("确定");
//        UpdateBtn = new JButton("更新");
//        ExitBtn = new JButton("退出");
//        panel2.add(ClearBtn);
//        panel2.add(YesBtn);
//        panel2.add(UpdateBtn);
//        panel2.add(ExitBtn);
//        ClearBtn.addActionListener(this);
//        YesBtn.addActionListener(this);
//        UpdateBtn.addActionListener(this);
//        ExitBtn.addActionListener(this);
//        UpdateBtn.setEnabled(false);
//        c.add(panel1, BorderLayout.CENTER);
//        c.add(panel2, BorderLayout.SOUTH);
//    }
//
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == ExitBtn)
//        {
//            this.dispose();
//        } else if (e.getSource() == ClearBtn)
//        {
//            BookNameTextField.setText("");
//            PressNameTextField.setText("");
//            AuthorTextField.setText("");
//            AddressTextField.setText("");
//            PressDateTextField.setText("");
//            PriceTextField.setText("");
//            CommentTextField.setText("");
//        } else if (e.getSource() == YesBtn)
//        {
//            try
//            {
//                String strSQL = "use library select * from books where bookName='"
//                        + BookNameTextField.getText().trim() + "'";
//                if (BookNameTextField.getText().trim().equals(""))
//                {
//                    JOptionPane.showMessageDialog(null, "清输入书名：<*v*>");
//                } else if (!db.getResult(strSQL).first())
//                {
//                    JOptionPane.showMessageDialog(null, "此书没有在书库中...");
//                } else
//                {
//                    rs = db.getResult(strSQL);
//                    rs.first();
//                    BookNameTextField.setText(rs.getString("BookName"));
//                    PressNameTextField.setText(rs.getString("Press"));
//                    AuthorTextField.setText(rs.getString("Author"));
//                    AddressTextField.setText(rs.getString("address"));
//                    PressDateTextField.setText(rs.getString("PressDate"));
//                    PriceTextField.setText(rs.getString("Price"));
//                    CommentTextField.setText(rs.getString("Com"));
//                    UpdateBtn.setEnabled(true);
//                }
//            } catch (NullPointerException upe)
//            {
//                System.out.println(upe.toString());
//            } catch (SQLException sqle)
//            {
//                System.out.println(sqle.toString());
//            } catch (Exception ex)
//            {
//                System.out.println(ex.toString());
//            }
//        } else if (e.getSource() == UpdateBtn)
//        {
//            try
//            {
//                String strSQL = "update books set bookName='"
//                        + BookNameTextField.getText().trim() + "',press='"
//                        + PressNameTextField.getText().trim() + "',author='"
//                        + AuthorTextField.getText().trim() + "',address='"
//                        + AddressTextField.getText().trim() + "',pressDate='"
//                        + PressDateTextField.getText().trim() + "',price='"
//                        + PriceTextField.getText().trim() + "',com='"
//                        + CommentTextField.getText().trim() + "'";
//                if (db.updateSql(strSQL))
//                {
//                    JOptionPane.showMessageDialog(null, "更新书籍信息成功！");
//                    db.closeConnection();
//                    this.dispose();
//                } else
//                {
//                    JOptionPane.showMessageDialog(null, "更新书籍信息失败！");
//                    db.closeConnection();
//                    this.dispose();
//                }
//            } catch (Exception ex)
//            {
//                System.out.println(ex.toString());
//            }
//        }
//    }
//}