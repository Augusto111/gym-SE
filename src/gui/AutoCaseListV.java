package gui;

import javax.swing.*;
import java.awt.*;

public class AutoCaseListV extends JFrame {
    private static final long serialVersionUID = -6310560018875149946L;
    private Container container = getContentPane();

    public AutoCaseListV(String token) {
        setTitle("待送件列表");
        // 设计窗体大小
        setBounds(0, 0, 800, 900);
        // 添加一块桌布
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 初始化窗口
        init(token);
        // 设计窗口可见
        setVisible(true);
    }
    /**
     * @author FeianLing
     * @date 2019/9/9
     * @desc 待送检列表数据显示初始化
     * @param
     * @return void
     */
    private void init(String token) {

        String[] cNames = {"案号", "商标名称", "申请类别", "订单号", "委托人", "申请人", "操作"};
        Object[][] rowData = {
                {"2019T-US002413T", " SHAW UROY", "21", "201909097071", "Devi", "Deli", 1},
                {"2019T-US002414T", " SHAW UROY", "21", "201909097071", "Devi", "Deli", 2},
                {"2019T-US002415T", " SHAW UROY", "21", "201909097071", "Devi", "Deli", 3},
                {"2019T-US002416T", " SHAW UROY", "21", "201909097071", "Devi", "Deli", 4},
        };
        JTable table = new JTable(rowData, cNames);
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender(""));
    }

    public static void main(String[] args) {
        new AutoCaseListV("123");
    }
}

