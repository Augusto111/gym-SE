package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT5 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton FirstButton;
    private JButton SecondButton;
    private JButton ThirdButton;
    private JButton FourthButton;


    public PT5(String name) {
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
                new PT6("Course aaa");//改成PT6
            }
        });
        SecondButton.setText("Fat Reduece");
        SecondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT6("Course aaa");//改成PT6
            }
        });
        ThirdButton.setText("。。。。。。");
        ThirdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT6("Course aaa");//改成PT6
            }
        });
        FourthButton.setText("。。。。。。");
        FourthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT6("Course aaa");//改成PT6
            }
        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT4("Welcome PT XXX");
            }
        });

        nextbutton.setText("Add");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT7("Publish a course video");
            }
        });


    }
}