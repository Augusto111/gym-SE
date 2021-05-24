package gui;

import bean.Trainer;
import controller.VideoCourseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PT5 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;

    private ClassClass a;

    public PT5(String name, String TrainerName) {
        super(name);
        centerPanel.setLayout(new GridLayout(3, 3));
        VideoCourseController videoCourseController = new VideoCourseController();
        ArrayList allVideoCourse = videoCourseController.getTrainerCourse(TrainerName);
        //教练课程为空，UI目前灭有提示用户添加课程的处理，所以先设庄
        if(allVideoCourse == null){

        }else{
            for(int i = 0;i < allVideoCourse.size(); i ++){
                String coursename = (String)allVideoCourse.get(i);
                a = new ClassClass(TrainerName,coursename);
                centerPanel.add(a);
            }
        }

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT4( TrainerName);
            }
        });

        nextbutton.setText("Add");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT7("Publish a course video",TrainerName);
            }
        });


    }

    class ClassClass extends JButton {
        public ClassClass(String TrainerName,String coursename){
            super(coursename);
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT6(TrainerName,coursename);//看课页面
                }
            });
        }

    }
}