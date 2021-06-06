package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A1 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel UserIdPanel;
    private JLabel userIdLabel;
    private TextField UserIdInput;

    JPanel PWPanel;
    private JLabel PWLabel;
    private TextField PWInput;

//    Price price;
//    Inventory inventory;

    public A1(String name) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(3, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        UserIdPanel = new JPanel();
        userIdLabel = new JLabel("User Id:");
        UserIdPanel.add(userIdLabel);
        UserIdInput = new TextField(15);
        UserIdPanel.add(UserIdInput);
        centerPanel.add(UserIdPanel);

        PWPanel = new JPanel();
        PWLabel = new JLabel("Password:");
        PWPanel.add(PWLabel);
        PWInput = new TextField(15);
        PWPanel.add(PWInput);
        centerPanel.add(PWPanel);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM system");
            }
        });


        nextbutton.setText("Log in");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(UserIdInput.getText().equals("admin") && PWInput.getText().equals("111"))
                {
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new A2("Administrator Page");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "用户名不存在或密码错误", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        newbutton.setVisible(false);

    }
}