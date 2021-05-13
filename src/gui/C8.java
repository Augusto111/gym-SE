package gui;


import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C8 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel NamePanel;
    private JLabel NameLabel;
    private TextField NameInput;

    JPanel SpecialtyPanel;
    private JLabel SpecialtyLabel;
    private JPanel SpecialtyBoxPanel;
    JCheckBox optionA;
    JCheckBox optionB;
    JCheckBox optionC;
    JCheckBox optionD;

    JPanel InfoPanel;
    private JLabel InfoLabel;
    private TextField InfoInput;

    JPanel VideoPanel;
    private JLabel VideoLabel;
    private TextField VideoInput;

//    Price price;
//    Inventory inventory;

    public C8(String name,String userid) {
        super(name);

        String[] columnNames =
                { "user id", "course name", "time", "Aim","study", "cancel", "change" };

        /*
         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。
         */
        Object[][] obj = new Object[2][7];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                switch (j)
                {
                    case 0:
                        obj[i][j] = "C000002";
                        break;
                    case 1:
                        obj[i][j] = "xxx";
                        break;
                    case 2:
                        obj[i][j] = "xxx";
                        break;
                    case 3:
                        obj[i][j] = "xxx";
                        break;
                    case 4:
                        obj[i][j] = new Button("study");
                        break;
                    case 5:
                        obj[i][j] = new Button("cancel");
                        break;
                    case 6:
                        obj[i][j] = new Button("change");
                        break;
                }
            }
        }


        /*
         * JTable的其中一种构造方法
         */
        JTable table = new JTable(obj, columnNames);
        /*
         * 设置JTable的列默认的宽度和高度
         */
        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = table.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(75);

        }
        /*
         * 设置JTable自动调整列表的状态，此处设置为关闭
         */
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(4).setCellRenderer(new MyButtonRender("study"));
        table.getColumnModel().getColumn(5).setCellRenderer(new MyButtonRender("cancel"));
        table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender("change"));
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(700, 550);
        centerPanel.add(scroll);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome  xxx!",userid);
            }
        });

        nextbutton.setVisible(false);



    }
}