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
import service.Options;
import util.Students;
import java.awt.Font;

public class HierachyView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HierachyView frame = new HierachyView();
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
	public HierachyView() {
		setTitle("各分数段人数");
		setBounds(100, 100, 846, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 812, 516);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			getData(),
			new String[] {
				"\u8BED\u6587", "\u4EBA\u6570", "\u6570\u5B66", "\u4EBA\u6570"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	public Object[][] getData() {
		Object[][] table = new Object[5][4];
		List<Student> list = Students.getStudents();
		int[] math = new int[] {0, 0, 0, 0, 0};
		int[] chinese = new int[] {0, 0, 0, 0, 0};
		for(Student student : list) {
			if(student.getChineseScore() >= 90) {
				chinese[0] += 1;
			}
			if(student.getChineseScore() >= 80) {
				chinese[1] += 1;
			}
			if(student.getChineseScore() >= 70) {
				chinese[2] += 1;
			}
			if(student.getChineseScore() >= 60) {
				chinese[3] += 1;
			}else {
				chinese[4] += 1;
			}
			if(student.getMathScore() >= 90) {
				math[0] += 1;
			}
			if(student.getMathScore() >= 80) {
				math[1] += 1;
			}
			if(student.getMathScore() >= 70) {
				math[2] += 1;
			}
			if(student.getMathScore() >= 60) {
				math[3] += 1;
			}else {
				math[4] += 1;
			}
		}
		for(int i = 0; i < 5 ;++i) {
			table[i][0] = (100-(i+1)*10) + "-" + (100-i*10);
			table[i][2] = (100-(i+1)*10) + "-" + (100-i*10);
			if(i == 4) {
				table[i][0] = "0-60";
				table[i][2] = "0-60";
			}
			table[i][1] = math[i];
			table[i][3] = chinese[i];
		}

		return table;
	}

}
