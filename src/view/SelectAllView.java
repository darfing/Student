package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pojo.Student;
import util.Students;
import java.awt.Font;

public class SelectAllView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectAllView frame = new SelectAllView();
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
	public SelectAllView() {
		setTitle("全部学生信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 751, 544);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			getData(),
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6570\u5B66", "\u8BED\u6587"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	public Object[][] getData() {
		Object[][] table = new Object[500][4];
		List<Student> list = Students.getStudents();
		System.out.println(list);
		int i = 0;
		for(Student student: list) {
			table[i][0] = student.getNumber();
			table[i][1] = student.getName();
			table[i][2] = student.getMathScore();
			table[i][3] = student.getChineseScore();
			i++;
		}
		
		return table;
	}

}
