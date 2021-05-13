package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay1 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton MonthButton;
    private JButton QuarterButton;
    private JButton AnnualButton;



    public Pay1(String name) {
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


        MonthButton.setText("Month  10");
        MonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay2("");
            }
        });
        QuarterButton.setText("Quarter  25");
        QuarterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay2("");
            }
        });
        AnnualButton.setText("Annual  80");
        AnnualButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new Pay2("");
            }
        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new W1("");
            }
        });

        nextbutton.setVisible(false);


    }
}