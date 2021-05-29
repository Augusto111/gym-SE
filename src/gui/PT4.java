package gui;

//import com.sun.javafx.scene.control.behavior.ListCellBehavior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT4 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    JPanel SecondPanel;
    private JButton VideoButton;
    private JButton LiveButton;

    public PT4(String name) {
        super(name);
        //name就是trainer的名字

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
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT5("My Course Video",name);
            }
        });
        LiveButton.setText("Live");
        LiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT8("Check live course", name);
            }
        });

        prebutton.setText("Profile");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT10("Profile",name);
            }
        });
        centerbutton.setVisible(true);
        centerbutton.setText("New Message");
        centerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT11("New message");//改成PT11
            }
        });
        nextbutton.setText("Logout");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM System");
            }
        });


    }
}