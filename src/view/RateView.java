package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.math.BigDecimal;
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

public class RateView extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RateView frame = new RateView();
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
    public RateView() {
        setTitle("比率信息");
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
                new String[]{
                        "\u540D\u79F0", "\u7ED3\u679C"
                }
        ));
        scrollPane.setViewportView(table);
    }

    public Object[][] getData() {
        Object[][] table = new Object[10][2];
        List<Student> list = Students.getStudents();
        double[] YLZRate = Options.YLZRate(list);
        double[] passRate = Options.passRate(list);
        double[] avg = Options.average(list);
        int i = 0;
        table[0][0] = "数学及格率";
        table[0][1] = (100 * passRate[0]) + "%";
        table[1][0] = "语文及格率";
        table[1][1] = (100 * passRate[1]) + "%";
        table[2][0] = "数学优秀率";
        table[2][1] = (100 * YLZRate[0]) + "%";
        table[3][0] = "数学良好率";
        table[3][1] = (100 * YLZRate[1]) + "%";
        table[4][0] = "数学中等率";
        table[4][1] = (100 * YLZRate[2]) + "%";
        table[5][0] = "语文优秀率";
        table[5][1] = (100 * YLZRate[3]) + "%";
        table[6][0] = "语文良好率";
        table[6][1] = (100 * YLZRate[4]) + "%";
        table[7][0] = "语文中等率";
        table[7][1] = (YLZRate[5]) + "%";
        table[8][0] = "数学平均分";
        table[8][1] = avg[0];
        table[9][0] = "语文平均分";
        table[9][1] = avg[1];


        return table;
    }

}
