package gui;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C2 extends TRMain {

    //    private Order order;
    JLabel  EmptyLabel;
    int[] addOnss;

    JPanel WelcomePanel;
    private JLabel WelcomeLabel;

    JPanel YourIdPanel;
    private JLabel YourIdLabel;

//    Price price;
//    Inventory inventory;

    public C2(String name, String userid) {
        super(name);

        addOnss=new int[4];

        centerPanel.setLayout(new GridLayout(3,1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        WelcomePanel = new JPanel();
        WelcomeLabel = new JLabel("Welcome!"+"");//加入姓名
        WelcomePanel.add(WelcomeLabel);
        centerPanel.add(WelcomePanel);


        YourIdPanel = new JPanel();
        YourIdLabel = new JLabel("Your ID is:"+userid);//加入ID
        YourIdPanel.add(YourIdLabel);
        centerPanel.add(YourIdPanel);

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
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C3("Sign in");
            }
        });


    }
}
