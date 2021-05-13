package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A2 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton MonthButton;
    private JButton QuarterButton;
    private JButton AnnualButton;



    public A2(String name) {
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


        MonthButton.setText("Custom List");
        MonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new A3("Manage Customer");//改成A3
            }
        });
        QuarterButton.setText("PT List");
        QuarterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new A4("Manage PT information");//改成A4
            }
        });
        AnnualButton.setText("Promotional Information");
        AnnualButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new A5("Manage Promotional Information");//改成A5
            }
        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM System");//改。。。
            }
        });

        nextbutton.setVisible(false);


    }
}