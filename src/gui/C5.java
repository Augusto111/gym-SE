package gui;

import bean.Course_video;
import bean.User;
import controller.TrianerController;
import controller.UserController;
import controller.VideoCourseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class C5 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton FirstButton;
    private JButton SecondButton;
    private JButton ThirdButton;
    private JButton FourthButton;

    final static TrianerController trainerController = new TrianerController();
    final static VideoCourseController videoCourseController = new VideoCourseController();


    public C5(String name, String userid) {
        super(name);


        UserController userController = new UserController();

        User user = userController.getUserInfo(userid);
        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(2, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstPanel = new JPanel();
//        FirstButton = new JButton();
//        SecondButton = new JButton();
//        ThirdButton = new JButton();
//        FourthButton = new JButton();
//        FirstPanel.add(FirstButton);
//        FirstPanel.add(SecondButton);
//        FirstPanel.add(ThirdButton);
//        FirstPanel.add(FourthButton);


        ArrayList<String> trainerList = trainerController.getAllTrainer();
        if(trainerList != null) {
            for(int i = 0; i < trainerList.size(); i++) {
                ArrayList<String> courseNameList = videoCourseController.getTrainerCourse(trainerList.get(i));
                if(courseNameList != null) {
                    for(int j = 0; j < courseNameList.size(); j++) {
                        JButton tmp = new JButton();
                        FirstPanel.add(tmp);
                        tmp.setText(courseNameList.get(j));
                        int finalI = i;
                        int finalJ = j;
                        tmp.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                thisFrame.setVisible(false);
                                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                Course_video courseVideo = videoCourseController.showCourseVideo(trainerList.get(finalI),courseNameList.get(finalJ));
                                new C6("course "+courseVideo.getCourseName(),userid,trainerList.get(finalI),courseNameList.get(finalJ),courseVideo);//看瑜伽课页面
                            }
                        });
                        System.out.println(courseNameList.get(j));
                    }
                }
            }
        }
        centerPanel.add(FirstPanel);

//        FirstButton.setText("Yoga");
//        FirstButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                new C6("course aaa",userid);//看瑜伽课页面
//            }
//        });
//        SecondButton.setText("Fat Reduece");
//        SecondButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                new C6("course aaa",userid);//看瑜伽课页面
//            }
//        });
//        ThirdButton.setText("。。。。。。");
//        ThirdButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                new C6("course aaa",userid);//看瑜伽课页面
//            }
//        });
//        FourthButton.setText("。。。。。。");
//        FourthButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                new C6("course aaa",userid);//看瑜伽课页面
//            }
//        });

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome " + user.getFirstname(),userid);
            }
        });

        nextbutton.setVisible(false);


    }
}