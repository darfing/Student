package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.User;
import service.Register;
import util.Users;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("注册界面");
		setBounds(100, 100, 625, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(178, 78, 58, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(178, 150, 58, 41);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(256, 218, 107, 41);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(238, 96, 180, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 161, 180, 21);
		contentPane.add(passwordField);
		
	}


	protected void register(ActionEvent e) {
		List<User> list = Users.getUsers();
		/*
		 * 注册验证
		 * 成功，此页面关闭，登录页面打开
		 * 失败，显示失败信息
		 * */
		String username = textField.getText(); //获取账号
		String password = passwordField.getText(); //获取密码
		
		if(username.equals("")) {  //判断用户名，密码是否为空
			JOptionPane.showMessageDialog(null, "账号不能为空");
			return;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		boolean flag = false;
		for(User user : list) {
			if(username.equals(user.getUsername())){
				flag = true;
				break;
			}
		}
		if(flag) { //判断用户名是否已存在
			JOptionPane.showMessageDialog(null,"用户名已存在");
			return ;
		} else {
	        try {
	            OutputStream os = new FileOutputStream("src/user.txt", true);
	            PrintStream ps = new PrintStream(os);
	            String s = username + " " + password;
	            ps.println(s);
	            System.out.println("注册成功");
	        } catch (FileNotFoundException exception) {
	            System.out.println("注册失败");
	        }
			JOptionPane.showMessageDialog(null, "注册成功");
			this.dispose();
			return ;
		}

	}
}
