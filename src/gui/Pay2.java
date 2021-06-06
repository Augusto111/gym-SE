package gui;

import bean.User;
import controller.UserController;
import controller.VideoCourseController;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay2 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JLabel FirstLabel;

    JPanel SecondPanel;
    private JLabel SecondLabel;

    final static UserController userController = new UserController();

//    Price price;
//    Inventory inventory;

    public Pay2(String name,String userid, String type, Integer price) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(3, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstPanel = new JPanel();
        FirstLabel = new JLabel("Payment: " + price.toString());
        FirstPanel.add(FirstLabel);
        centerPanel.add(FirstPanel);


        SecondPanel = new JPanel();
        SecondLabel = new JLabel("You are paying for a " + type);//加入会员类型
        SecondPanel.add(SecondLabel);
        centerPanel.add(SecondPanel);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay1("Pay for a CM",userid);
            }
        });

        nextbutton.setText("Pay");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                User user = userController.getUserInfo(userid);
                user.setType(1);
                Boolean res = userController.setUserInfo(user);
                if(res)
                    new C5("Course videos" ,userid);//改成C5
                else
                    JOptionPane.showMessageDialog(null, "PAY ERROR", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
            }
        });


    }
}