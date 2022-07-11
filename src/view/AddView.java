package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Student;
import pojo.User;
import service.Options;
import util.Students;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddView frame = new AddView();
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
	public AddView() {
		setTitle("添加学生信息");
		setBounds(100, 100, 692, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(181, 108, 80, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(181, 164, 80, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("数学分数：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(153, 236, 80, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("语文分数：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(153, 301, 80, 34);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(233, 115, 281, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 174, 281, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 243, 281, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 308, 281, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(267, 371, 108, 34);
		contentPane.add(btnNewButton);
	}

	protected void add(ActionEvent e) {
		String num = textField.getText();
		String name = textField_1.getText();
		int mathScore = Integer.parseInt(textField_2.getText());
		int chineseScore = Integer.parseInt(textField_3.getText());
		List<Student> list = Students.getStudents();
		boolean flag = false;
		for(Student student : list) {
			if(num.equals(student.getNumber())){
				flag = true;
				break;
			}
		}
        if(num.contains(" ") || name.contains(" ") || Options.checkScore(mathScore) || Options.checkScore(chineseScore)) {
        	JOptionPane.showMessageDialog(null, "学号和姓名不能包含空格并且分数必须在0-100");
        	return ;
        } else if(flag){
			JOptionPane.showMessageDialog(null,"该学号的学生已存在");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			return ;
		} else {
	        try {
	            PrintStream ps = new PrintStream(new FileOutputStream("src/student.txt", true));
	            String s = num + " " + name + " " + mathScore + " " + chineseScore;
	            ps.println(s);
	        } catch (Exception exp) {
	            exp.printStackTrace();
	        }
	        JOptionPane.showMessageDialog(null, "添加成功");
	        this.dispose();
	        return ;
        }
	}

}
