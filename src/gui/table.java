package gui;

import bean.Course_live;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class table  {

    JTable table = null;
    JButton viewButton2 ;

    DefaultTableModel model = null;




    public JComponent makeUI() {
        String[] columnNames =
                { "user id", "course name", "time", "Info","operation"
//                        ,"study"  , "change"
                };

        // number of columns it
        // hides another button

        Object[][] obj = new Object[5][5];
        for (int i = 0; i <5; i++)
        {
           for (int j = 0; j < columnNames.length; j++)
            {
                switch (j) {
                    case 0:
                        obj[i][j] = "11";
                        break;
                    case 1:
                        obj[i][j] = "11";
                        break;
                    case 2:
                        obj[i][j] = "11";
                        break;
                    case 3:
                        obj[i][j] = "11";
                        break;
                    case 4:

                        break;
                }
            }
        }


        model = new DefaultTableModel(obj, columnNames) {

        };
        table = new JTable(model);
        table.setRowHeight(36);
        ActionPanelEditorRenderer er = new ActionPanelEditorRenderer("hhj");
        TableColumn column = table.getColumnModel().getColumn(4);
        column.setCellRenderer(er);
        column.setCellEditor(er);

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(table));
        p.setPreferredSize(new Dimension(320, 200));
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(new table().makeUI());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }



    class ActionPanelEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        public ActionPanelEditorRenderer(String name) {
            super();

            viewButton2 = new JButton(name);

            panel2.add(viewButton2);

            viewButton2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    JOptionPane.showMessageDialog(null, "jjj");
                }
            });
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            panel2.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            panel2.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());



            //	panel2.setBackground(table.getBackground());
            return panel2;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel2.setBackground(table.getSelectionBackground());
            return panel2;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }
}