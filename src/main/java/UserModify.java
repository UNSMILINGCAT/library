//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class UserModify extends JFrame implements ActionListener {
//	DataBaseManager db = new DataBaseManager();
//	ResultSet rs;
//	JPanel panel1, panel2;
//	Container c;
//	JLabel userLabel, passwordLabel, NewPasswordLabel, passwordConfirmLabel;
//	JTextField userTextField;
//	JPasswordField passwordTextField, NewPasswordTextField,
//			passwordConfirmTextField;
//	JButton UpdateBtn, cancelBtn;
//
//	public UserModify() {
//		super("更改密码");
//		c = getContentPane();
//		c.setLayout(new BorderLayout());
//		userLabel = new JLabel("用户名", JLabel.CENTER);
//		passwordLabel = new JLabel("原密码", JLabel.CENTER);
//		NewPasswordLabel = new JLabel("新密码", JLabel.CENTER);
//		passwordConfirmLabel = new JLabel("确认新密码", JLabel.CENTER);
//		userTextField = new JTextField(10);
//		passwordTextField = new JPasswordField(10);
//		NewPasswordTextField = new JPasswordField(10);
//		passwordConfirmTextField = new JPasswordField(10);
//		UpdateBtn = new JButton("更新");
//		cancelBtn = new JButton("取消");
//		UpdateBtn.addActionListener(this);
//		cancelBtn.addActionListener(this);
//		panel1 = new JPanel();
//		panel1.setLayout(new GridLayout(4, 2));
//		panel1.add(userLabel);
//		panel1.add(userTextField);
//		panel1.add(passwordLabel);
//		panel1.add(passwordTextField);
//		panel1.add(NewPasswordLabel);
//		panel1.add(NewPasswordTextField);
//		panel1.add(passwordConfirmLabel);
//		panel1.add(passwordConfirmTextField);
//		panel2 = new JPanel();
//		panel2.add(UpdateBtn);
//		panel2.add(cancelBtn);
//		c.add(panel1, BorderLayout.CENTER);
//		c.add(panel2, BorderLayout.SOUTH);
//		setSize(300, 300);
//
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == cancelBtn) {
//			db.closeConnection();
//			this.dispose();
//		} else if (e.getSource() == UpdateBtn) {
//			try {
//				char[] password = passwordTextField.getPassword();
//				String passwordSTR = new String(password);
//				char[] newPassword = NewPasswordTextField.getPassword();
//				String newPasswordSTR = new String(newPassword);
//				char[] confirmPassword = passwordConfirmTextField.getPassword();
//				String confirmPasswordSTR = new String(confirmPassword);
//				String strSQL = "use library select * from userTable where userName='"
//						+ userTextField.getText().trim() + "'and password='"
//						+ passwordSTR + "'";
//				if (userTextField.getText().trim().equals("")) {
//					JOptionPane.showMessageDialog(null, "用户名不能为空！");
//				} else if (passwordSTR.equals("")) {
//					JOptionPane.showMessageDialog(null, "原密码不能为空！");
//				} else if (!newPasswordSTR.equals(confirmPasswordSTR)) {
//					JOptionPane.showMessageDialog(null, "两次输入的新密码不一致！");
//				} else {
//					if (!db.getResult(strSQL).first()) {
//						JOptionPane.showMessageDialog(null, "此用户不存在或者原密码不正确！");
//
//					} else {
//						strSQL = "use library update userTable set password='"
//								+ newPasswordSTR + "'where userName='"
//								+ userTextField.getText().trim() + "'";
//						if (db.updateSql(strSQL)) {
//							JOptionPane.showMessageDialog(null, "更新密码成功！");
//							this.dispose();
//						} else {
//							JOptionPane.showMessageDialog(null, "更新密码失败！");
//							this.dispose();
//						}
//						db.closeConnection();
//					}
//				}
//			} catch (SQLException sqle) {
//				System.out.println(sqle.toString());
//			} catch (Exception ex) {
//				System.out.println(ex.toString());
//			}
//		}
//	}
//}