package gui;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class W1 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel OnePanel;
    private JLabel OneLabel;

    JPanel TwoPanel;
    private JLabel TwoLabel;

//    Price price;
//    Inventory inventory;

    public W1(String name) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(3, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        OnePanel = new JPanel();
        OneLabel = new JLabel("Sorry:" + "");//加入姓名
        OnePanel.add(OneLabel);
        centerPanel.add(OnePanel);


        TwoPanel = new JPanel();
        TwoLabel = new JLabel("You need to get a common membership");
        TwoPanel.add(TwoLabel);
        centerPanel.add(TwoPanel);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome XXX");//改名字
            }
        });

        nextbutton.setText("Buy");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay1("Pay for a CM1");//改成Pay1
            }
        });


    }
}