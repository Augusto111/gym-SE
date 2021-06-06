package gui;


import bean.Course_live;
import bean.Course_video;
import controller.BookCourseController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P2 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;
    JPanel allPanel;
    JPanel NamePanel;
    private JLabel NameLabel;
    private JLabel NameInput;

    JPanel InfoPanel;
    private JLabel InfoLabel;
    private JLabel InfoInput;

    JPanel TimePanel;
    private JLabel TimeLabel;
    private JLabel TimeInput;

    JPanel ImagePanel;
    private JLabel ImageLabel;
    private JLabel ImageInput;

    final static BookCourseController bookCourseController = new BookCourseController();

//    Price price;
//    Inventory inventory;

    public P2(String name, String userid, String trainerName, String courseName, Course_live courseLive) {
        super(name);

        JLabel jLabel = new JLabel("", JLabel.CENTER);
        Icon icon = new ImageIcon("./src/gui/2.png");
        jLabel.setIcon(icon);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jLabel, BorderLayout.WEST);


        addOnss = new int[4];
        allPanel = new JPanel();
        allPanel.setLayout(new GridLayout(5, 1));
        EmptyLabel = new JLabel("");
        allPanel.add(EmptyLabel);

        NamePanel = new JPanel();
        NameLabel = new JLabel("Course name: " + courseName);
        NamePanel.add(NameLabel);
        NameInput = new JLabel("");
        NamePanel.add(NameInput);
        allPanel.add(NamePanel);


        InfoPanel = new JPanel();
        InfoLabel = new JLabel("Course information: " + courseLive.getCourseInfo());
        InfoPanel.add(InfoLabel);
        InfoInput = new JLabel("");
        InfoPanel.add(InfoInput);
        allPanel.add(InfoPanel);

        TimePanel = new JPanel();
        TimeLabel = new JLabel("Course time: " + courseLive.getTime());
        TimePanel.add(TimeLabel);
        TimeInput = new JLabel("");
        TimePanel.add(TimeInput);
        allPanel.add(TimePanel);

        ImagePanel = new JPanel();
        ImageLabel = new JLabel("PT name: " + trainerName);
        ImagePanel.add(ImageLabel);
        ImageInput =  new JLabel("");
        ImagePanel.add(ImageInput);
        allPanel.add(ImagePanel);

        centerPanel.add(allPanel, BorderLayout.CENTER);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C5("My course videos",userid);
            }
        });

        nextbutton.setText("book");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                String res = bookCourseController.bookcourse(userid,courseName,trainerName);
                if(res == "SUCCESS") {
                    new P1("Personal Trainers",userid);
                }
                else {
                    JOptionPane.showMessageDialog(null, "BOOK ERROR", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });


    }
}