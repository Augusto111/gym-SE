package gui;

import bean.User;
import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P1 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton FirstButton;
    private JButton SecondButton;
    private JButton ThirdButton;
    private JButton FourthButton;

    final static UserController userController = new UserController();

    public P1(String name,String userid) {
        super(name);

        User user = userController.getUserInfo(userid);
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


        FirstButton.setText("PT1");
        FirstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new P2(user.getFirstname(),userid);//改成P2
            }
        });
        SecondButton.setText("PT2");
        SecondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new P2(user.getFirstname(),userid);//课程页面
            }
        });
        ThirdButton.setText("PT3");
        ThirdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new P2(user.getFirstname(),userid);
            }
        });
        FourthButton.setText("PT4");
        FourthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new P2("",userid);
            }
        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome " + user.getFirstname(), userid);
            }
        });

        nextbutton.setVisible(false);


    }
}