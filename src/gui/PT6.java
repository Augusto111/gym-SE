package gui;


import bean.Course_video;
import controller.VideoCourseController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT6 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;
    JPanel allPanel;
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

    public PT6(String Trainername, String Coursename) {
        super(Coursename);

        JLabel jLabel = new JLabel("", JLabel.CENTER);
        Icon icon = new ImageIcon("./src/gui/2.png");
        jLabel.setIcon(icon);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jLabel, BorderLayout.WEST);

        VideoCourseController videoCourseController = new VideoCourseController();
        Course_video videoCourse = videoCourseController.showCourseVideo(Trainername,Coursename);


        addOnss = new int[4];
        allPanel = new JPanel();
        allPanel.setLayout(new GridLayout(5, 1));
        EmptyLabel = new JLabel("");
        allPanel.add(EmptyLabel);

        NamePanel = new JPanel();
        NameLabel = new JLabel("Course name:");
        NamePanel.add(NameLabel);
        NameInput = new TextField(videoCourse.getCourseName());
        NamePanel.add(NameInput);
        allPanel.add(NamePanel);


        InfoPanel = new JPanel();
        InfoLabel = new JLabel("Course information:");
        InfoPanel.add(InfoLabel);
        InfoInput = new TextField(videoCourse.getCourseInfo());
        InfoPanel.add(InfoInput);
        allPanel.add(InfoPanel);

        TimePanel = new JPanel();
        TimeLabel = new JLabel("Course type:");
        TimePanel.add(TimeLabel);
        TimeInput = new TextField(videoCourse.getCourseType());
        TimePanel.add(TimeInput);
        allPanel.add(TimePanel);

        ImagePanel = new JPanel();
        ImageLabel = new JLabel("Pt name:");
        ImagePanel.add(ImageLabel);
        ImageInput = new TextField(videoCourse.getTrainerName());
        ImagePanel.add(ImageInput);
        allPanel.add(ImagePanel);

        centerPanel.add(allPanel, BorderLayout.CENTER);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT5("My course videos",Trainername);
            }
        });

        nextbutton.setText("Change");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT6(Trainername,Coursename);//理论上 应该还有个类PT7的界面
            }
        });


    }

    public PT6(String Trainername, String course_aaa, String userid) {
        super(userid);
    }
}