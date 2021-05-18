package gui;


import bean.Course_video;
import controller.VideoCourseController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT7 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel NamePanel;
    private JLabel NameLabel;
    private TextField NameInput;

    JPanel SpecialtyPanel;
    private JLabel SpecialtyLabel;
    private JPanel SpecialtyBoxPanel;
    JCheckBox optionA;
    JCheckBox optionB;
    JCheckBox optionC;
    JCheckBox optionD;

    JPanel InfoPanel;
    private JLabel InfoLabel;
    private TextField InfoInput;

    JPanel VideoPanel;
    private JLabel VideoLabel;
    private TextField VideoInput;

//    Price price;
//    Inventory inventory;

    public PT7(String name, String TrainerName) {
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

        SpecialtyPanel = new JPanel();
        SpecialtyBoxPanel = new JPanel();
        SpecialtyLabel = new JLabel("Course Type:");
        SpecialtyPanel.add(SpecialtyLabel);
        optionA = new JCheckBox("Hit");
        optionB = new JCheckBox("Yoga");
        optionC = new JCheckBox("C.");
        optionD = new JCheckBox("D.");

        //SpecialtyBox = new TextField(15);
        SpecialtyBoxPanel.add(optionA);
        SpecialtyBoxPanel.add(optionB);
        SpecialtyBoxPanel.add(optionC);
        SpecialtyBoxPanel.add(optionD);
        SpecialtyPanel.add(SpecialtyBoxPanel);
        centerPanel.add(SpecialtyPanel);
        String CourseType = "yoga";


        InfoPanel = new JPanel();
        InfoLabel = new JLabel("Course information:");
        InfoPanel.add(InfoLabel);
        InfoInput = new TextField(15);
        InfoPanel.add(InfoInput);
        centerPanel.add(InfoPanel);

        VideoPanel = new JPanel();
        VideoLabel = new JLabel("Course video!!!!!!这里要修改成添加视频的按钮:");
        VideoPanel.add(VideoLabel);
        VideoInput = new TextField(15);
        VideoPanel.add(VideoInput);
        centerPanel.add(VideoPanel);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT5("My course videos","trainername");
            }
        });

        nextbutton.setText("Submit");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Course_video newCourseVideo = new Course_video(NameInput.getText(),
                        TrainerName,InfoInput.getText(),VideoInput.getText(),CourseType);
                VideoCourseController videoCourseController = new VideoCourseController();
                int add = videoCourseController.addCourseVideo(TrainerName,newCourseVideo);
                if(add == 0){
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT5("My course videos",TrainerName);
                }else{
                    System.out.println("出现问题！重试");
                }

            }
        });


    }
}