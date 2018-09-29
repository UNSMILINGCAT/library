//import com.datepicker.component.CalendarPanel;
//import com.librarymanager.dao.BooksDAO;
//import com.librarymanager.data.Books;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.*;
//import java.text.SimpleDateFormat;
//
//public class BookAdd extends JFrame implements ActionListener
//{
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Books books = new Books();
//    DataBaseManager db = new DataBaseManager();
//    ResultSet rs;
//    JPanel panel1, panel2;
//    JLabel BookNameLabel, PressNameLabel, AuthorLabel, AddressLabel,
//            PressDateLabel, PriceLabel, BookCountLabel, CommentLabel;
//    JTextField BookNameTextField, PressNameTextField, AuthorTextField,
//            AddressTextField, PressDateTextField, PriceTextField,
//            BookCountTextField, CommentTextField;
//    Container c;
//    JButton ClearBtn, AddBtn, ExitBtn;
//
//    public BookAdd()
//    {
//        super("添加书籍信息");
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        BookNameLabel = new JLabel("名称", JLabel.CENTER);
//        PressNameLabel = new JLabel("出版社", JLabel.CENTER);
//        AuthorLabel = new JLabel("作者", JLabel.CENTER);
//        AddressLabel = new JLabel("地址", JLabel.CENTER);
//        PressDateLabel = new JLabel("出版日期", JLabel.CENTER);
//        PriceLabel = new JLabel("价格", JLabel.CENTER);
//        BookCountLabel = new JLabel("新书数目", JLabel.CENTER);
//        CommentLabel = new JLabel("备注", JLabel.CENTER);
//        BookNameTextField = new JTextField(15);
//        PressNameTextField = new JTextField(15);
//        AuthorTextField = new JTextField(15);
//        AddressTextField = new JTextField(15);
//        PressDateTextField = new JTextField(15);
//        CalendarPanel calendarPanel = new CalendarPanel();
//        calendarPanel.setComponent(PressDateTextField);
//        calendarPanel.initCalendarPanel();
//        PriceTextField = new JTextField(15);
//        BookCountTextField = new JTextField(15);
//        CommentTextField = new JTextField(15);
//        panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(8, 2));
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
//        panel1.add(BookCountLabel);
//        panel1.add(BookCountTextField);
//        panel1.add(CommentLabel);
//        panel1.add(CommentTextField);
//        c.add(calendarPanel);
//        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(1, 3));
//        ClearBtn = new JButton("清空");
//        ClearBtn.addActionListener(this);
//        AddBtn = new JButton("添加");
//        AddBtn.addActionListener(this);
//        ExitBtn = new JButton("退出");
//        ExitBtn.addActionListener(this);
//        panel2.add(ClearBtn);
//        panel2.add(AddBtn);
//        panel2.add(ExitBtn);
//        c.add(panel1, BorderLayout.CENTER);
//        c.add(panel2, BorderLayout.SOUTH);
//
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
//            BookCountTextField.setText("");
//            CommentTextField.setText("");
//        } else if (e.getSource() == AddBtn)
//        {
//            if (BookNameTextField.getText().trim().equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "书名不能为空！");
//            } else if (PressNameTextField.getText().trim().equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "出版社不能为空！");
//            } else if (AuthorTextField.getText().trim().equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "作者不能为空！");
//            } else if (BookCountTextField.getText().trim().equals(""))
//            {
//                JOptionPane.showMessageDialog(null, "新书数目不能为空！");
//            } else
//            {
//                try
//                {
//                    books.setBookName(BookNameTextField.getText().trim());
//                    books.setPress(PressNameTextField.getText().trim());
//                    books.setAuthor(AuthorTextField.getText().trim());
//                    books.setAddress(AddressTextField.getText().trim());
//                    books.setPressDate(new Date(simpleDateFormat.parse(PressDateTextField.getText().trim()).getTime()));
//                    books.setPrice(new BigDecimal(Integer.parseInt(PriceTextField.getText().trim())));
//                    books.setBooksCount(new BigInteger(BookCountTextField.getText().trim()));
//                    books.setCom(CommentTextField.getText().trim());
//                    if (BooksDAO.addUser(books))
//                    {
//                        JOptionPane.showMessageDialog(null, "添加书籍成功！");
//                        this.dispose();
//                    } else
//                    {
//                        JOptionPane.showMessageDialog(null, "添加书籍失败！");
//                        this.dispose();
//                    }
//                } catch (Exception ex)
//                {
//                    ex.printStackTrace();
//                }
//            }
//
//        }
//    }
//}