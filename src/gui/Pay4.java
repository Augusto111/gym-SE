package gui;

import bean.User;
import controller.UserController;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay4 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JLabel FirstLabel;

    JPanel SecondPanel;
    private JLabel SecondLabel;

//    Price price;
//    Inventory inventory;

    final static UserController userController = new UserController();

    public Pay4(String name,String userid, String courseNum) {
        super(name);

        User user = userController.getUserInfo(userid);
        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(3, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstPanel = new JPanel();
        FirstLabel = new JLabel("Payment");
        FirstPanel.add(FirstLabel);
        centerPanel.add(FirstPanel);


        SecondPanel = new JPanel();
        SecondLabel = new JLabel("You are paying for premium membership and " + courseNum + " courses");//加入会员类型
        SecondPanel.add(SecondLabel);
        centerPanel.add(SecondPanel);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay3("Pay for a PM",userid);
            }
        });

        nextbutton.setText("Pay");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                int res = userController.purchaseCourse(Integer.parseInt(courseNum), userid);
                user.setType(2);
                Boolean res1 = userController.setUserInfo(user);
                if(res == -1){
                    new C3("Customer Sign In");
                }
                else if(!res1) {
                    JOptionPane.showMessageDialog(null, "PAY ERROR", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                }
                else {
                    new P1("Personal trainer",userid);
                }
            }
        });


    }
}