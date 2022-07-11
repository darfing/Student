package view;

import pojo.User;
import util.Users;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				LoginView frame = new LoginView();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登录界面");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(151, 10, 118, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("账号:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(82, 94, 58, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(82, 141, 58, 23);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(129, 103, 171, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 143, 171, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});
		btnNewButton.setBounds(117, 189, 73, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register(e);
			}
		});
		btnNewButton_1.setBounds(212, 189, 73, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void register(ActionEvent e) {
		RegisterView rv = new RegisterView();
		rv.setLocationRelativeTo(null);
		rv.setVisible(true);
	}

	protected void login(ActionEvent e) {
		String username = textField.getText(); //获取账号
		String password = passwordField.getText(); //获取密码
		List<User> list = Users.getUsers();
		
		if(username.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空");
			return;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		boolean flag = false;
		for(User user : list) {
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
				JOptionPane.showMessageDialog(null, "登陆成功");
				MainView mv = new MainView(); //创建需要跳转的窗口对象
				mv.setLocationRelativeTo(null);
				mv.setVisible(true);
				this.dispose(); //关闭当前窗口
				return ;
			}
		}

		JOptionPane.showMessageDialog(null, "账号或密码错误");
		textField.setText("");
		passwordField.setText("");
		return;

	}
}
