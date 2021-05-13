package gui;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class JTableTest extends JFrame
{

    public JTableTest()
    {
        String[] columnNames =
                { "姓名", "学号", "性别", "工期", "学院", "学校" };

        /*
         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。
         */
        Object[][] obj = new Object[2][6];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                switch (j)
                {
                    case 0:
                        obj[i][j] = "赵匡义";
                        break;
                    case 1:
                        obj[i][j] = "123215";
                        break;
                    case 2:
                        obj[i][j] = "男";
                        break;
                    case 3:
                        obj[i][j] = "两年";
                        break;
                    case 4:
                        obj[i][j] = "计算机技术学院";
                        break;
                    case 5:
                        obj[i][j] = "北京理工大学";
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
            column.setPreferredWidth(100);
        }
        /*
         * 设置JTable自动调整列表的状态，此处设置为关闭
         */
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(300, 200);


        add(scroll);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }


    public static void main(String[] args)
    {
        new JTableTest();
    }
}