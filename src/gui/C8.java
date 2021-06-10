package gui;


import bean.BookCourse;
import bean.Course_live;
import bean.User;
import controller.BookCourseController;
import controller.LiveCourseController;
import controller.UserController;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C8 extends TRMain {

    final static BookCourseController bookCourseController = new BookCourseController();
    final static LiveCourseController liveCourseController = new LiveCourseController();

    public C8(String name,String userid) {
        super(name);

        String[] columnNames =
                { "user id", "course name", "time", "Info","operation"
//                        ,"study"  , "change"
                };

        UserController userController = new UserController();

        User user = userController.getUserInfo(userid);
        /*
         * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。
         */

        java.util.List<BookCourse> cources = bookCourseController.bookcourseList(userid);
        System.out.println("booked cources");
        System.out.println(cources);

        Object[][] obj = new Object[cources.size()][columnNames.length];

        if(cources != null) {
            for (int i = 0; i < cources.size(); i++)
            {
                Course_live courseLive = liveCourseController.showCourseLive(cources.get(i).getTrainerName(),cources.get(i).getCoursename());
                for (int j = 0; j < columnNames.length; j++)
                {
                    switch (j)
                    {
                        case 0:
                            obj[i][j] = userid;
                            break;
                        case 1:
                            obj[i][j] = courseLive.getCourseName();
                            break;
                        case 2:
                            obj[i][j] = courseLive.getTime();
                            break;
                        case 3:
                            obj[i][j] = courseLive.getCourseInfo();
                            break;
                        case 4:


                            obj[i][j] = "cancel";

                            break;
//                        case 5:
//                            obj[i][j] = new Button("study");
//                            break;
//                        case 6:
//                            obj[i][j] = new Button("change");
//                            break;
                        default:
                            break;
                    }
                }
            }
        }



        /*
         * JTable的其中一种构造方法
         */
        JTable table = new JTable(obj, columnNames);
        table.setRowSelectionAllowed(false);
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
//        table.setEditingColumn(4);




        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(4).setCellEditor(new MemberCancel());
//        table.getColumnModel().getColumn(5).setCellRenderer(new MyButtonRender("study"));
//        table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender("change"));
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(1000, 550);
        centerPanel.add(scroll);



        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome " + user.getFirstname(),userid);
            }
        });

        nextbutton.setVisible(false);



    }
}