package gui;
import bean.*;
import io.FileDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePage extends TRMain {

//    Button now;

    public HomePage(String name) {
        super(name);
//        Price price = (Price) FileDB.read("file/manager/price");
        JLabel jLabel = new JLabel("", JLabel.CENTER);
        Icon icon = new ImageIcon("./src/gui/1.png");
        jLabel.setIcon(icon);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jLabel, BorderLayout.CENTER);
        prebutton.setText("Admin");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        centerbutton.setText("Customer");
        centerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        nextbutton.setText("Trainer");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

    }
    public static void main(String[] args) {
//        HomePage a = new HomePage("健身房预约系统");


        String CourseName = "frag";
        String CourseType = "swim";
        String CourseInfo = "stronger!better!";
        String url = "http://baudi.com";
        videoCourse zyfvideoCourse = new videoCourse(CourseName, CourseType, CourseInfo, url);
        CourseOperate testCourseOperate = new CourseOperate();

//        int test1result = testCourseOperate.addCourseVideo("zf",zyfvideoCourse);
//        System.out.println(test1result);

//        ArrayList<String> test2list = new ArrayList<>();
//        test2list = testCourseOperate.getTrainerCourse("zyf");
//        System.out.println(test2list);

//        videoCourse test3videoCourse = testCourseOperate.showCourseVideo("zyf","frag");
//        System.out.println(test3videoCourse);


        String newCourseName = "fragnew";
        String newCourseType = "swimnew";
        String newCourseInfo = "new!stronger!better!";
        String newurl = "http://baudi.com";
        videoCourse newzyfvideoCourse = new videoCourse(newCourseName, newCourseType, newCourseInfo, newurl);

//        int test1result = testCourseOperate.addCourseVideo("zyf",newzyfvideoCourse);
//        System.out.println(test1result);
        int test4 = testCourseOperate.editCourseVideo("zf","frag",newzyfvideoCourse);
        System.out.println(test4);


//        TrainerLoginReg testTrainerLoginReg = new TrainerLoginReg();

//        String PtID = "1113";
//        String firstName = "yf0";
//        String lastName = "zhao";
//        String Gender = "female";
//        int age = 18;
//        String speciaity = "swimming";
//        String password = "123";
//        Trainer testTrainer = new Trainer(PtID,firstName,lastName,Gender,age,speciaity,password);
//        int test5 = testTrainerLoginReg.trainerRegister(testTrainer);
//        System.out.println(test5);

//        int test6 = testTrainerLoginReg.trainerLogin("yfhao","121");
//        System.out.println(test6);

    }
}
