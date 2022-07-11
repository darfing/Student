package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pojo.Student;
import service.Options;
import util.Students;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.awt.event.ActionEvent;

public class CRUDView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Object[][] data = new Object[1][4];
	int index;
	String[] title = new String[] {
			"\u5B66\u53F7", "\u59D3\u540D", "\u6570\u5B66", "\u8BED\u6587"
		};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDView frame = new CRUDView();
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
	public CRUDView() {
		setTitle("编辑界面");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(66, 26, 80, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(367, 26, 90, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(108, 32, 159, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(409, 32, 148, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(605, 31, 97, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 714, 64);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6570\u5B66", "\u8BED\u6587"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("删除该学生");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.setBounds(605, 142, 119, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("学号");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(136, 238, 68, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("姓名");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(136, 277, 68, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("数学");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(136, 311, 68, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("语文");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(136, 351, 68, 21);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 243, 193, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 277, 193, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(191, 317, 193, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(191, 351, 193, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("修改该学生信息");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(224, 190, 135, 30);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("提交");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(460, 291, 97, 39);
		contentPane.add(btnNewButton_2);
	}

	protected void update(ActionEvent e) {  //修改学生信息单击事件
		List<Student> list = Students.getStudents();
		String num = textField_2.getText();
		String name = textField_3.getText();
		int mathScore = Integer.parseInt(textField_4.getText());
		int chineseScore = Integer.parseInt(textField_5.getText());
		if(index + 1 > list.size() || !list.get(index).getNumber().equals(textField.getText())) {
			JOptionPane.showMessageDialog(null, "该学生不存在或已删除");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			return ;
		} else {
	        if(num.contains(" ") || name.contains(" ") || Options.checkScore(mathScore) || Options.checkScore(chineseScore)) {
	        	JOptionPane.showMessageDialog(null, "学号和姓名不能包含空格并且分数必须在0-100");
	        	return ;
	        } else {
	        	Student student = list.get(index);
	        	student.setNumber(num);
	        	student.setName(name);
	        	student.setMathScore(mathScore);
	        	student.setChineseScore(chineseScore);
	        	list.set(index, student);
	        	if(Options.update(list)) {
			        JOptionPane.showMessageDialog(null, "修改成功");
			        return ;
	        	}
	        }
		}
	}
		
	

	protected void delete(ActionEvent e) { //删除学生信息单击事件
		List<Student> list = Students.getStudents();
		list.remove(index);
		if(Options.update(list)) {
			JOptionPane.showMessageDialog(null, "删除成功");
		}
	}

	protected void query(ActionEvent e) { //查询学生信息单击事件
		List<Student> list = Students.getStudents();
		String num = textField.getText();
		String name = textField_1.getText();
		if("".equals(num)) {
			JOptionPane.showMessageDialog(null, "学号不能为空");
			return;
		}
		boolean flag = true;
		if("".equals(name)) {
			for(Student student: list) {
				if(student.getNumber().equals(num)) {
					flag = false;
					index = list.indexOf(student);
					break;
				}
			}
			if(flag) {
				JOptionPane.showMessageDialog(null, "该学生不存在");
				return;
			}
		} else {
			for(Student student: list) {
				if(student.getName().equals(name) && student.getNumber().equals(num)) {
					flag = false;
					index = list.indexOf(student);
					break;
				}
			}
			if(flag) {
				JOptionPane.showMessageDialog(null, "该学生不存在");
				return;
			}
		}
		data[0][0] = list.get(index).getNumber();
		data[0][1] = list.get(index).getName();
		data[0][2] = list.get(index).getMathScore();
		data[0][3] = list.get(index).getChineseScore();
		DefaultTableModel tabModel = new DefaultTableModel(data, title);
		table.setModel(tabModel);
		table.setEnabled(true);
	}
	
}
