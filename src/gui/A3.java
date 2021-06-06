package gui;


import bean.User;
import controller.UserController;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class A3 extends TRMain {

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

    final static UserController userController = new UserController();

//    Price price;
//    Inventory inventory;

    public A3(String name) {
        super(name);

        ArrayList<String> userList = userController.getAllUser();
        System.out.println(userList);

        String[] columnNames =
                { "user id", "sex", "phone", "member level", "age", "aim","balance" };

        /*
         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。
         */
        if(userList != null)  {
            Object[][] obj = new Object[userList.size()][columnNames.length];
            for (int i = 0; i < userList.size(); i++)
            {
                User tmp = userController.getUserInfo(userList.get(i));
                for (int j = 0; j < columnNames.length-1; j++)
                {
                    switch (j)
                    {
                        case 0:
                            obj[i][j] = tmp.getFirstname();
                            break;
                        case 1:
                            obj[i][j] = tmp.getSex();
                            break;
                        case 2:
                            obj[i][j] = tmp.getTelephone();
                            break;
                        case 3:
                            obj[i][j] = tmp.getType() == 0? "visitor" :
                                    tmp.getType() == 1? "common member" :
                                    "premium member";
                            break;
                        case 4:
                            obj[i][j] = tmp.getAge();
                            break;

                        case 5:
                            obj[i][j] = tmp.getInterested();
                            break;
                        case 6:
                            obj[i][j] = tmp.getBalance();
                            break;
                        case 7:
                            obj[i][j] = new Button("change password");
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

            table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender("change pw"));

            /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
            JScrollPane scroll = new JScrollPane(table);
            scroll.setSize(700, 550);
            centerPanel.add(scroll);
        }






        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new A2("Administrator Page");
            }
        });

        nextbutton.setVisible(false);



    }
}