package gui;


import bean.User;
import controller.UserController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C7 extends TRMain {

    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstNamePanel;
    private JLabel FirstNameLabel;
    private TextField FirstNameInput;

    JPanel LastNamePanel;
    private JLabel LastNameLabel;
    private TextField LastNameInput;

    JPanel SexPanel;
    private JLabel SexLabel;
    private TextField SexInput;

    JPanel AgePanel;
    private JLabel AgeLabel;
    private TextField AgeInput;

    JPanel InterestedPanel;
    private JLabel InterestedLabel;
    private JPanel InterestedBoxPanel;
    JCheckBox optionA;
    JCheckBox optionB;
    JCheckBox optionC;
    JCheckBox optionD;


    JPanel PWPanel;
    private JLabel PWLabel;
    private TextField PWInput;

    JPanel PhonePanel;
    private JLabel PhoneLabel;
    private TextField PhoneInput;


//    Price price;
//    Inventory inventory;

    public C7(String name, String userid) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(9, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstNamePanel = new JPanel();
        FirstNameLabel = new JLabel("First name:");
        FirstNamePanel.add(FirstNameLabel);
        FirstNameInput = new TextField(15);
        FirstNamePanel.add(FirstNameInput);
        centerPanel.add(FirstNamePanel);


        LastNamePanel = new JPanel();
        LastNameLabel = new JLabel("Last name:");
        LastNamePanel.add(LastNameLabel);
        LastNameInput = new TextField(15);
        LastNamePanel.add(LastNameInput);
        centerPanel.add(LastNamePanel);

        SexPanel = new JPanel();
        SexLabel = new JLabel("Sex:");
        SexPanel.add(SexLabel);
        SexInput = new TextField(15);
        SexPanel.add(SexInput);
        centerPanel.add(SexPanel);

        AgePanel = new JPanel();
        AgeLabel = new JLabel("Age:");
        AgePanel.add(AgeLabel);
        AgeInput = new TextField(15);
        AgePanel.add(AgeInput);
        centerPanel.add(AgePanel);

        InterestedPanel = new JPanel();
        InterestedBoxPanel = new JPanel();
        InterestedLabel = new JLabel("Specialty:");
        InterestedPanel.add(InterestedLabel);
        optionA = new JCheckBox("Hit");
        optionB = new JCheckBox("Yoga");
        optionC = new JCheckBox("Shaping");
        optionD = new JCheckBox("D.");

        //SpecialtyBox = new TextField(15);
        InterestedBoxPanel.add(optionA);
        InterestedBoxPanel.add(optionB);
        InterestedBoxPanel.add(optionC);
        InterestedBoxPanel.add(optionD);
        InterestedPanel.add(InterestedBoxPanel);
        centerPanel.add(InterestedPanel);

        PWPanel = new JPanel();
        PWLabel = new JLabel("Password:");
        PWPanel.add(PWLabel);
        PWInput = new TextField(15);
        PWPanel.add(PWInput);
        centerPanel.add(PWPanel);

        PhonePanel = new JPanel();
        PhoneLabel = new JLabel("Phone:");
        PhonePanel.add(PhoneLabel);
        PhoneInput = new TextField(15);
        PhonePanel.add(PhoneInput);
        centerPanel.add(PhonePanel);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C4("Welcome XXX",userid);
            }
        });

        nextbutton.setText("Change Info");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PWInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input password", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    UserController userController = new UserController();

                    boolean selectedA = optionA.isSelected();
                    boolean selectedB = optionB.isSelected();
                    boolean selectedC = optionC.isSelected();
                    boolean selectedD = optionD.isSelected();
                    String res = "";
                    if(selectedA)
                        res = "Hit";
                    else if(selectedB)
                        res = "Yoga";
                    else if(selectedC)
                        res = "C";
                    else if(selectedD)
                        res = "D";
                    else
                        res = "";

                    User user = new User();
                    user.setUserid(userid);
                    user.setFirstname(FirstNameInput.getText());
                    user.setLastname(LastNameInput.getText());
                    user.setSex(SexInput.getText());
                    user.setAge(Integer.valueOf(AgeInput.getText()));
                    user.setInterested(res);
                    user.setPassword(PWInput.getText());

                    Boolean result = userController.setUserInfo(user);

                    if(result) {
                        thisFrame.setVisible(false);
                        thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        new C7("SUCCESS!",userid);
                    }
                    else {
                        thisFrame.setVisible(false);
                        thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        new C7("FAILED!",userid);
                    }


                }
            }
        });


    }
}