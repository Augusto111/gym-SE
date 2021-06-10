package gui;


import bean.Course_video;
import bean.Trainer;
import controller.VideoCourseController;
import javafx.scene.text.Text;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT7 extends TRMain {

    JLabel EmptyLabel;

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
    JLabel ImgLabel;
    private TextField InfoInput;
    JButton add;
    JPanel VideoPanel;
    JLabel videoInforLabel;
    private JLabel VideoLabel;

    JButton addimg;
    JPanel ImgPanel;
    JLabel ImgInforLabel;
    private JLabel imgLabel;



    JFileChooser chooser;

    public PT7(String name, String TrainerName) {
        super(name);


        centerPanel.setLayout(new GridLayout(6, 1));
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
        videoInforLabel = new JLabel("Video:");
        VideoPanel.add(videoInforLabel);
        VideoLabel = new JLabel();
        add = new JButton("add");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooser= new JFileChooser();
                chooser.showOpenDialog(null);
                chooser.setMultiSelectionEnabled(false);
                chooser.getSelectedFile();
                System.out.println(chooser.getSelectedFile().getAbsolutePath());
                VideoLabel.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        VideoPanel.add(VideoLabel);
        VideoPanel.add(add);
        centerPanel.add(VideoPanel);

        ImgPanel = new JPanel();
        ImgInforLabel = new JLabel("Video image:");
        ImgPanel.add(ImgInforLabel);
        ImgLabel = new JLabel();
        addimg = new JButton("add");
        addimg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooser= new JFileChooser();
                chooser.showOpenDialog(null);
                chooser.setMultiSelectionEnabled(false);
                chooser.getSelectedFile();

                ImgLabel.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        ImgPanel.add(ImgLabel);
        ImgPanel.add(addimg);
        centerPanel.add(ImgPanel);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT5("My course videos", TrainerName);
            }
        });

        nextbutton.setText("Submit");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Course_video newCourseVideo = new Course_video(NameInput.getText(),
                        TrainerName,InfoInput.getText(),VideoLabel.getText(),CourseType);
                VideoCourseController videoCourseController = new VideoCourseController();
                int add = videoCourseController.addCourseVideo(TrainerName,newCourseVideo);
                if(add == 0){
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT5("My course videos",TrainerName);
                }else{
                    System.out.println("出现问题！重试");
                    JOptionPane.showMessageDialog(null, "Please retry", "wrong",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });


    }
}