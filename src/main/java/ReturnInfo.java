//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class ReturnInfo extends JFrame implements ActionListener
//{
//    DataBaseManager db = new DataBaseManager();
//    ResultSet rs;
//    JPanel panel1, panel2;
//    Container c;
//    JLabel TipLabel = new JLabel("输入还书者姓名和书名点击确定，将调出此书的相关信息");
//    JLabel ReturnedBookStudentLabel, ReturnedBookNameLabel,
//            ReturnedDateLabel, ReturnedCommentLabel;
//    JTextField ReturnedBookStudentTextField, ReturnedBookNameTextField,
//            ReturnedDateTextField, ReturnedCommentTextField;
//    JButton ClearBtn, YesBtn, UpdateBtn, cancelBtn;
//
//    public ReturnInfo()
//    {
//        super("修改书籍还入信息");
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        c.add(TipLabel, BorderLayout.NORTH);
//        ReturnedBookStudentLabel = new JLabel("还书者姓名", JLabel.CENTER);
//        ReturnedBookNameLabel = new JLabel("书名", JLabel.CENTER);
//        ReturnedDateLabel = new JLabel("还书日期", JLabel.CENTER);
//        ReturnedCommentLabel = new JLabel("备注", JLabel.CENTER);
//        ReturnedBookStudentTextField = new JTextField(15);
//        ReturnedBookNameTextField = new JTextField(15);
//        ReturnedDateTextField = new JTextField(15);
//        ReturnedCommentTextField = new JTextField(15);
//        panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(4, 2));
//        panel1.add(ReturnedBookStudentLabel);
//        panel1.add(ReturnedBookStudentTextField);
//        panel1.add(ReturnedBookNameLabel);
//        panel1.add(ReturnedBookNameTextField);
//        panel1.add(ReturnedDateLabel);
//        panel1.add(ReturnedDateTextField);
//        panel1.add(ReturnedCommentLabel);
//        panel1.add(ReturnedCommentTextField);
//        c.add(panel1, BorderLayout.CENTER);
//        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(1, 4));
//        ClearBtn = new JButton("清空");
//        YesBtn = new JButton("确定");
//        UpdateBtn = new JButton("更新");
//        cancelBtn = new JButton("取消");
//        ClearBtn.addActionListener(this);
//        YesBtn.addActionListener(this);
//        UpdateBtn.addActionListener(this);
//        UpdateBtn.setEnabled(false);
//        cancelBtn.addActionListener(this);
//        panel2.add(ClearBtn);
//        panel2.add(YesBtn);
//        panel2.add(UpdateBtn);
//        panel2.add(cancelBtn);
//        c.add(panel2, BorderLayout.SOUTH);
//    }
//
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == ClearBtn)
//        {
//            ReturnedBookStudentTextField.setText("");
//            ReturnedBookNameTextField.setText("");
//            ReturnedDateTextField.setText("");
//            ReturnedCommentTextField.setText("");
//        } else if (e.getSource() == cancelBtn)
//        {
//            this.dispose();
//        } else if (e.getSource() == YesBtn)
//        {
//            try
//            {
//                String strSQL = "use library select studentName,bookName,borrowDate,com from BookBrowse where " +
//                        "studentName='" +
//                        ReturnedBookStudentTextField.getText().trim() + "'and bookName='" +
//                        ReturnedBookNameTextField.getText().trim() + "'";
//                rs = db.getResult(strSQL);
//                if (!rs.first())
//                {
//                    JOptionPane.showMessageDialog(null, "此学生没有借过书！或者没有此书！");
//
//                } else
//                {
//                    ReturnedBookStudentTextField.setText(rs.getString(1));
//                    ReturnedBookNameTextField.setText(rs.getString(2));
//                    ReturnedDateTextField.setText(rs.getString(3));
//                    ReturnedCommentTextField.setText(rs.getString(4));
//                    UpdateBtn.setEnabled(true);
//
//                }
//            } catch (Exception ex)
//            {
//                System.out.println(ex.toString());
//            }
//
//
//        } else if (e.getSource() == UpdateBtn)
//        {
//            String strSQL = "use library update bookBrowse set returnDate='" +
//                    ReturnedDateTextField.getText().trim() + "',com='" +
//                    ReturnedCommentTextField.getText().trim() + "' where studentName='" +
//                    ReturnedBookStudentTextField.getText().trim() + "'and bookName='" +
//                    ReturnedBookNameTextField.getText().trim() + "'";
//            if (db.updateSql(strSQL))
//            {
//                JOptionPane.showMessageDialog(null, "更新成功！");
//                db.closeConnection();
//                this.dispose();
//            } else
//            {
//                JOptionPane.showMessageDialog(null, "更新失败！");
//                db.closeConnection();
//                this.dispose();
//            }
//        }
//    }
//}