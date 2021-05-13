package gui;

//import com.sun.javafx.scene.control.behavior.ListCellBehavior;

import bean.User;
import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C4 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    private JButton VideoButton;
    private JButton LiveButton;

    JPanel SecondPanel;
    private JButton PIButton;


    public C4(String name,String userid) {
        super(name);

        UserController userController = new UserController();

        User user = userController.getUserInfo(userid);


        //addOnss = new int[4];


        centerPanel.setLayout(new BorderLayout());


        JPanel abutton = new JPanel();
        abutton.setLayout(new GridLayout(1, 2));

        FirstPanel = new JPanel();
        VideoButton = new JButton("Video");
        LiveButton = new JButton("Live");

        abutton.add(VideoButton);
        abutton.add(LiveButton);

        centerPanel.add(abutton,BorderLayout.CENTER);


        SecondPanel = new JPanel();

        JLabel jLabel = new JLabel("", JLabel.CENTER);
        Icon icon = new ImageIcon("./src/gui/7.png");
        jLabel.setIcon(icon);


        SecondPanel.add(jLabel);
        centerPanel.add(SecondPanel,BorderLayout.SOUTH);

        VideoButton.setText("Video");
        VideoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                boolean pay = false;

                if (user.getType() != 0) {
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new C5("Course Video",userid);
                }else{
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new W1("sorry", userid);
                }

            }
        });
        LiveButton.setText("Live");
        LiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean pay = false;
                if (pay == false) {
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new W2("sorry",userid);
                }else{
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new P1("Personal Trainers",userid);
                }


            }
        });
//        `PIButton.setText("Promotional Information");
//        PIButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                new HomePage("HomePage");//改成...?
//            }
//        });`

        prebutton.setText("Profile");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C7("Profile",userid);//改成C7
            }
        });
        centerbutton.setVisible(true);
        centerbutton.setText("Schedule");
        centerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C8("Schedule", userid);//改成C8
            }
        });
        nextbutton.setText("New message");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C9("Message Box",userid);//改成C9
            }
        });

        newbutton.setVisible(true);
        newbutton.setText("Logout");
        newbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM system");
            }
        });

    }
}