package gui;


import bean.Course_live;
import bean.Course_video;
import controller.LiveCourseController;
import controller.VideoCourseController;

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

    JLabel imgLabel;
    JFileChooser chooser;
    JButton addimg;
    JPanel ImgPanel;

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

    public PT9(String name, String trainerName) {
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
        imgLabel = new JLabel();
        ImagePanel.add(imgLabel);
        addimg = new JButton("add");
        addimg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooser= new JFileChooser();
                chooser.showOpenDialog(null);
                chooser.setMultiSelectionEnabled(false);
                chooser.getSelectedFile();

                imgLabel.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });
        ImagePanel.add(addimg);
        centerPanel.add(ImagePanel);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT8("Check live course", trainerName);//??????PT8
            }
        });

        nextbutton.setText("Submit");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Course_live newCourseLive = new Course_live(NameInput.getText(),
                        trainerName,InfoInput.getText(), "none", TimeInput.getText(), "none", "none");
                LiveCourseController liveCourseController = new LiveCourseController();
                int add = liveCourseController.addCourseLive(trainerName,newCourseLive);
                if(add == 0){
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT8("My live videos", trainerName);
                }else{
                    System.out.println("?????????????????????");
                    JOptionPane.showMessageDialog(null, "Please retry", "wrong",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}