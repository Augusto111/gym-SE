package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C5 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton FirstButton;
    private JButton SecondButton;
    private JButton ThirdButton;
    private JButton FourthButton;


    public C5(String name, String userid) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(2, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstPanel = new JPanel();
        FirstButton = new JButton();
        SecondButton = new JButton();
        ThirdButton = new JButton();
        FourthButton = new JButton();
        FirstPanel.add(FirstButton);
        FirstPanel.add(SecondButton);
        FirstPanel.add(ThirdButton);
        FirstPanel.add(FourthButton);
        centerPanel.add(FirstPanel);


        FirstButton.setText("Yoga");
        FirstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C6("course aaa",userid);//看瑜伽课页面
            }
        });
        SecondButton.setText("Fat Reduece");
        SecondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C6("course aaa",userid);//看瑜伽课页面
            }
        });
        ThirdButton.setText("。。。。。。");
        ThirdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C6("course aaa",userid);//看瑜伽课页面
            }
        });
        FourthButton.setText("。。。。。。");
        FourthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C6("course aaa",userid);//看瑜伽课页面
            }
        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome XXX",userid);
            }
        });

        nextbutton.setVisible(false);


    }
}