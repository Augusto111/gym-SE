package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay3 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton MonthButton;
    private JButton QuarterButton;
    private JButton AnnualButton;



    public Pay3(String name) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(2, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstPanel = new JPanel();
        MonthButton = new JButton();
        QuarterButton = new JButton();
        AnnualButton = new JButton();
        FirstPanel.add(MonthButton);
        FirstPanel.add(QuarterButton);
        FirstPanel.add(AnnualButton);
        centerPanel.add(FirstPanel);


        MonthButton.setText("10 items  2000");
        MonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay4("");
            }
        });
        QuarterButton.setText("30 items  5500");
        QuarterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay4("");
            }
        });
        AnnualButton.setText("100 items 15000");
        AnnualButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay4("");
            }
        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay3("pay");
            }
        });

        nextbutton.setVisible(false);


    }
}