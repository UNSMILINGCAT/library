//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class MainWindow extends JFrame implements ActionListener
//{
//    JPanel panel1;
//    Container c;
//    JMenuBar MenuB;
//    JMenu SystemMenu, BookMGRMenu, BorrowBookMenu, ReturnBookMenu,
//            InfoBrowseMenu, UserMGRMenu;
//    JMenuItem UserLoginMenuItem, UserAddMenuItem, UserModifyMenuItem,
//            UserDeleteMenuItem, ExitMenuItem, BookAddMenuItem, BookModifyMenuItem, BookDeleteMenuItem,
//            BorrowBookMenuItem, BorrowInfoMenuItem, ReturnBookMenuItem, ReturnInfoMenuItem,
//            BookListMenuItem, BorrowBookListMenuItem, UserListMenuItem;
//    JLabel titleLabel, AuthorLabel, DateLabel;
//
//    public MainWindow()
//    {
//        super("图书馆管理系统");
//        //--系统管理菜单--
//        MenuB = new JMenuBar();
//        SystemMenu = new JMenu("系统管理");
//        UserMGRMenu = new JMenu("用户管理");
//        UserLoginMenuItem = new JMenuItem("用户登录");
//        UserAddMenuItem = new JMenuItem("添加用户");
//        UserModifyMenuItem = new JMenuItem("修改用户");
//        UserDeleteMenuItem = new JMenuItem("删除用户");
//        ExitMenuItem = new JMenuItem("退出");
//        SystemMenu.add(UserLoginMenuItem);
//        UserMGRMenu.add(UserAddMenuItem);
//        UserMGRMenu.add(UserModifyMenuItem);
//        UserMGRMenu.add(UserDeleteMenuItem);
//        SystemMenu.add(UserMGRMenu);
//        SystemMenu.add(ExitMenuItem);
//        UserLoginMenuItem.addActionListener(this);
//        UserAddMenuItem.addActionListener(this);
//        UserModifyMenuItem.addActionListener(this);
//        UserDeleteMenuItem.addActionListener(this);
//        ExitMenuItem.addActionListener(this);
//        MenuB.add(SystemMenu);
//        //---书籍管理菜单--
//        BookMGRMenu = new JMenu("书籍管理");
//        BookAddMenuItem = new JMenuItem("添加书籍");
//        BookModifyMenuItem = new JMenuItem("修改书籍");
//        BookDeleteMenuItem = new JMenuItem("删除书籍");
//        BookMGRMenu.add(BookAddMenuItem);
//        BookMGRMenu.add(BookModifyMenuItem);
//        BookMGRMenu.add(BookDeleteMenuItem);
//        BookAddMenuItem.addActionListener(this);
//        BookModifyMenuItem.addActionListener(this);
//        BookDeleteMenuItem.addActionListener(this);
//        MenuB.add(BookMGRMenu);
//        //--借书管理菜单--
//        BorrowBookMenu = new JMenu("借书管理");
//        BorrowBookMenuItem = new JMenuItem("书籍出借");
//        BorrowInfoMenuItem = new JMenuItem("出借信息修改");
//        BorrowBookMenu.add(BorrowBookMenuItem);
//        BorrowBookMenu.add(BorrowInfoMenuItem);
//        BorrowBookMenuItem.addActionListener(this);
//        BorrowInfoMenuItem.addActionListener(this);
//        MenuB.add(BorrowBookMenu);
//        //--还书管理菜单--
//        ReturnBookMenu = new JMenu("还书管理");
//        ReturnBookMenuItem = new JMenuItem("书籍还入");
//        ReturnInfoMenuItem = new JMenuItem("书籍还入信息修改");
//        ReturnBookMenu.add(ReturnBookMenuItem);
//        ReturnBookMenu.add(ReturnInfoMenuItem);
//        ReturnBookMenuItem.addActionListener(this);
//        ReturnInfoMenuItem.addActionListener(this);
//        MenuB.add(ReturnBookMenu);
//        //--信息一览菜单--
//        InfoBrowseMenu = new JMenu("信息一览");
//        BookListMenuItem = new JMenuItem("书籍列表");
//        BorrowBookListMenuItem = new JMenuItem("借阅情况表");
//        UserListMenuItem = new JMenuItem("用户列表");
//        InfoBrowseMenu.add(BookListMenuItem);
//        InfoBrowseMenu.add(BorrowBookListMenuItem);
//        InfoBrowseMenu.add(UserListMenuItem);
//        BookListMenuItem.addActionListener(this);
//        BorrowBookListMenuItem.addActionListener(this);
//        UserListMenuItem.addActionListener(this);
//        MenuB.add(InfoBrowseMenu);
//        //----------------------------------
//        setJMenuBar(MenuB);
//
//        titleLabel = new JLabel(new ImageIcon("./pic.jpg"));
//        c = getContentPane();
//        c.setLayout(new BorderLayout());
//        panel1 = new JPanel();
//        panel1.setLayout(new BorderLayout());
//        panel1.add(titleLabel, BorderLayout.CENTER);
//        c.add(panel1, BorderLayout.CENTER);
//        setBounds(100, 50, 400, 300);
//        show();
//        //--设置初始功能:--
//        UserMGRMenu.setEnabled(false);
//        BookMGRMenu.setEnabled(false);
//        BorrowBookMenu.setEnabled(false);
//        ReturnBookMenu.setEnabled(false);
//        InfoBrowseMenu.setEnabled(false);
//    }
//
//    //--设置每个菜单点击后出现的窗口和窗口显示的位置--
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getActionCommand() == "用户登录")
//        {
//            UserLogin UserLoginFrame = new UserLogin(this);
//            Dimension FrameSize = UserLoginFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            UserLoginFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            UserLoginFrame.pack();
//            UserLoginFrame.show();
//        } else if (e.getActionCommand() == "添加用户")
//        {
//            UserAdd UserAddFrame = new UserAdd();
//            Dimension FrameSize = UserAddFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            UserAddFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            UserAddFrame.pack();
//            UserAddFrame.show();
//        } else if (e.getActionCommand() == "修改用户")
//        {
//            UserModify UserModifyFrame = new UserModify();
//            Dimension FrameSize = UserModifyFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            UserModifyFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            UserModifyFrame.pack();
//            UserModifyFrame.show();
//        } else if (e.getActionCommand() == "删除用户")
//        {
//            UserDelete UserDeleteFrame = new UserDelete();
//            Dimension FrameSize = UserDeleteFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            UserDeleteFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            UserDeleteFrame.pack();
//            UserDeleteFrame.show();
//        } else if (e.getActionCommand() == "添加书籍")
//        {
//            BookAdd BookAddFrame = new BookAdd();
//            Dimension FrameSize = BookAddFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BookAddFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BookAddFrame.pack();
//            BookAddFrame.show();
//        } else if (e.getActionCommand() == "修改书籍")
//        {
//            BookModify BookModifyFrame = new BookModify();
//            Dimension FrameSize = BookModifyFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BookModifyFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BookModifyFrame.pack();
//            BookModifyFrame.show();
//        } else if (e.getActionCommand() == "删除书籍")
//        {
//            BookDelete BookDeleteFrame = new BookDelete();
//            Dimension FrameSize = BookDeleteFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BookDeleteFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BookDeleteFrame.pack();
//            BookDeleteFrame.show();
//        } else if (e.getActionCommand() == "书籍出借")
//        {
//            BorrowBook BorrowBookFrame = new BorrowBook();
//            Dimension FrameSize = BorrowBookFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BorrowBookFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BorrowBookFrame.pack();
//            BorrowBookFrame.show();
//        } else if (e.getActionCommand() == "出借信息修改")
//        {
//            BorrowInfo BorrowInfoFrame = new BorrowInfo();
//            Dimension FrameSize = BorrowInfoFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BorrowInfoFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BorrowInfoFrame.pack();
//            BorrowInfoFrame.show();
//        } else if (e.getActionCommand() == "书籍还入")
//        {
//            ReturnBook ReturnBookFrame = new ReturnBook();
//            Dimension FrameSize = ReturnBookFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            ReturnBookFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            ReturnBookFrame.pack();
//            ReturnBookFrame.show();
//        } else if (e.getActionCommand() == "书籍还入信息修改")
//        {
//            ReturnInfo ReturnInfoFrame = new ReturnInfo();
//            Dimension FrameSize = ReturnInfoFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            ReturnInfoFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            ReturnInfoFrame.pack();
//            ReturnInfoFrame.show();
//        } else if (e.getActionCommand() == "书籍列表")
//        {
//            BookList BookListFrame = new BookList();
//            Dimension FrameSize = BookListFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BookListFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BookListFrame.pack();
//            BookListFrame.show();
//        } else if (e.getActionCommand() == "借阅情况表")
//        {
//            BorrowBookList BorrowBookListFrame = new BorrowBookList();
//            Dimension FrameSize = BorrowBookListFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            BorrowBookListFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            BorrowBookListFrame.pack();
//            BorrowBookListFrame.show();
//        } else if (e.getActionCommand() == "用户列表")
//        {
//            UserList UserListFrame = new UserList();
//            Dimension FrameSize = UserListFrame.getPreferredSize();
//            Dimension MainFrameSize = getSize();
//            Point loc = getLocation();
//            UserListFrame.setLocation((MainFrameSize.width - FrameSize.width) / 2 + loc.x,
//                    (MainFrameSize.height - FrameSize.height) / 2 + loc.y);
//            UserListFrame.pack();
//            UserListFrame.show();
//        } else if (e.getActionCommand() == "退出")
//        {
//            this.dispose();
//            System.exit(0);
//        }
//    }
//
//    //--设置登录用户的权限--
//    public void setEnable(String powerType)
//    {
//        if (powerType.trim().equals("系统管理员"))
//        {
//            UserMGRMenu.setEnabled(true);
//            BookMGRMenu.setEnabled(true);
//            BorrowBookMenu.setEnabled(true);
//            ReturnBookMenu.setEnabled(true);
//            InfoBrowseMenu.setEnabled(true);
//            UserListMenuItem.setEnabled(true);
//        } else if (powerType.trim().equals("书籍管理员"))
//        {
//            UserMGRMenu.setEnabled(false);
//            BookMGRMenu.setEnabled(true);
//            BorrowBookMenu.setEnabled(false);
//            ReturnBookMenu.setEnabled(false);
//            InfoBrowseMenu.setEnabled(true);
//            UserListMenuItem.setEnabled(false);
//
//        } else if (powerType.trim().equals("借阅管理员"))
//        {
//            UserMGRMenu.setEnabled(false);
//            BookMGRMenu.setEnabled(false);
//            BorrowBookMenu.setEnabled(true);
//            ReturnBookMenu.setEnabled(true);
//            InfoBrowseMenu.setEnabled(true);
//            UserListMenuItem.setEnabled(false);
//        } else if (powerType.trim().equals("else"))
//        {
//            UserMGRMenu.setEnabled(false);
//            BookMGRMenu.setEnabled(false);
//            BorrowBookMenu.setEnabled(false);
//            ReturnBookMenu.setEnabled(false);
//            InfoBrowseMenu.setEnabled(false);
//        }
//    }
//
//    public static void main(String args[])
//    {
//        MainWindow mainFrame = new MainWindow();
//
//
//    }
//}