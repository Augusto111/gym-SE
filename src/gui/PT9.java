package gui;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT9 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel NamePanel;
    private JLabel NameLabel;
    private TextField NameInput;

    JPanel InfoPanel;
    private JLabel InfoLabel;
    private TextField InfoInput;

    JPanel TimePanel;
    private JLabel TimeLabel;
    private TextField TimeInput;

    JPanel ImagePanel;
    private JLabel ImageLabel;
    private TextField ImageInput;

//    Price price;
//    Inventory inventory;

    public PT9(String name) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(5, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        NamePanel = new JPanel();
        NameLabel = new JLabel("Course name:");
        NamePanel.add(NameLabel);
        NameInput = new TextField(15);
        NamePanel.add(NameInput);
        centerPanel.add(NamePanel);


        InfoPanel = new JPanel();
        InfoLabel = new JLabel("Course information:");
        InfoPanel.add(InfoLabel);
        InfoInput = new TextField(15);
        InfoPanel.add(InfoInput);
        centerPanel.add(InfoPanel);

        TimePanel = new JPanel();
        TimeLabel = new JLabel("Course time:");
        TimePanel.add(TimeLabel);
        TimeInput = new TextField(15);
        TimePanel.add(TimeInput);
        centerPanel.add(TimePanel);

        ImagePanel = new JPanel();
        ImageLabel = new JLabel("Course Image:");
        ImagePanel.add(ImageLabel);
        ImageInput = new TextField(15);
        ImagePanel.add(ImageInput);
        centerPanel.add(ImagePanel);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT8("Check live course");//改成PT8
            }
        });

        nextbutton.setText("Submit");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT8("Check live course");//改成PT8
                }
        });


    }
}