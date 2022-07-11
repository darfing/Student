package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("学生成绩管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 501);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("功能菜单");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("所有学生");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("学生排名");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("添加学生");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("详细信息");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("数学及格率");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("语文及格率");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("优良中比率");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("数学不及格率");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("语文不及格率");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("系统介绍");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("中文介绍");
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("英文介绍");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("查询全部学生");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(139, 93, 227, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询学生排名");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(436, 93, 227, 52);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("添加学生信息");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(139, 155, 227, 52);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("数学及格率");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rate(e);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setBounds(436, 217, 227, 59);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("查删改学生");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avg(e);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_4.setBounds(139, 283, 227, 59);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("各分数段人数");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hierachy(e);
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_5.setBounds(436, 286, 227, 52);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("语文及格率");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rate(e);
			}
		});
		btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_6.setBounds(139, 217, 227, 52);
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("优良中率");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rate(e);
			}
		});
		btnNewButton_7.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_7.setBounds(436, 155, 227, 52);
		getContentPane().add(btnNewButton_7);
		
		
	}

	protected void hierachy(ActionEvent e) {  //分数段查询单击事件
		HierachyView hv = new HierachyView();
		hv.setLocationRelativeTo(null);
		hv.setVisible(true);
	}

	protected void avg(ActionEvent e) { //平均数查询单击事件
		CRUDView cv = new CRUDView();
		cv.setLocationRelativeTo(null);
		cv.setVisible(true);
	}

	protected void add(ActionEvent e) { //添加学生单击事件
		AddView av = new AddView();
		av.setLocationRelativeTo(null);
		av.setVisible(true);
	}

	protected void rate(ActionEvent e) {
		RateView rv = new RateView();
		rv.setLocationRelativeTo(null);
		rv.setVisible(true);
		
	}


	protected void selectAll(ActionEvent e) { //查询所有学生单击事件
		SelectAllView sav = new SelectAllView();
		sav.setLocationRelativeTo(null);
		sav.setVisible(true);
		
	}

	protected void sort(ActionEvent e) { //学生排序单击事件
		SortView sv = new SortView();
		sv.setLocationRelativeTo(null);
		sv.setVisible(true);
		
	}


}
