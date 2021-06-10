

import gui.MemberRefuse;
import gui.MemberAccept;
import gui.MyButtonRenderer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    private JFrame frame;
    private JTable table;

    private Object[][] data = {
            {1, 2, 3},
            {4, 5, 6},
            {4, 5, 6},
            {7, 8, 9}};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestTable window = new TestTable();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public TestTable() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 414, 242);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 394, 222);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        table.setModel(new DefaultTableModel() {
            @Override
            public Object getValueAt(int row, int column) {
                return data[row][column];
            }

            @Override
            public int getRowCount() {
                return 4;
            }

            @Override
            public int getColumnCount() {
                return 3;
            }
            @Override
            public void setValueAt(Object aValue, int row, int column){
                data[row][column] = aValue;
                fireTableCellUpdated(row, column);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 2) {
                    return true;
                }
                if (column == 1) {
                    return true;
                }else {
                    return false;
                }
            }
        });

        table.getColumnModel().getColumn(2).setCellEditor(
                new MemberRefuse());

        table.getColumnModel().getColumn(1).setCellEditor(
                new MemberAccept());

        table.getColumnModel().getColumn(2).setCellRenderer(
                new MyButtonRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(
                new MyButtonRenderer());

        table.setRowSelectionAllowed(false);
    }
}