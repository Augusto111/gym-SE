package gui;


import bean.Trainer;
import controller.TrianerController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PT10 extends TRMain {

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

    JPanel SpecifyPanel;
    private JLabel SpecifyLabel;
    private JPanel SpecifyBoxPanel;
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

    public PT10(String name, String trainername) {
        super(name);

        addOnss = new int[4];

        centerPanel.setLayout(new GridLayout(9, 1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        FirstNamePanel = new JPanel();
        FirstNameLabel = new JLabel("First name:");
        FirstNamePanel.add(FirstNameLabel);
        FirstNameInput = new TextField(15);
        FirstNameInput.setBackground(Color.GRAY);
        FirstNameInput.setEditable(false);
        FirstNamePanel.add(FirstNameInput);
        centerPanel.add(FirstNamePanel);


        LastNamePanel = new JPanel();
        LastNameLabel = new JLabel("Last name:");
        LastNamePanel.add(LastNameLabel);
        LastNameInput = new TextField(15);
        LastNameInput.setBackground(Color.GRAY);
        LastNameInput.setEditable(false);
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

        SpecifyPanel = new JPanel();
        SpecifyBoxPanel = new JPanel();
        SpecifyLabel = new JLabel("Specialty:");
        SpecifyPanel.add(SpecifyLabel);
        optionA = new JCheckBox("Hit");
        optionB = new JCheckBox("Yoga");
        optionC = new JCheckBox("Shaping");
        optionD = new JCheckBox("D.");

        //SpecialtyBox = new TextField(15);
        SpecifyBoxPanel.add(optionA);
        SpecifyBoxPanel.add(optionB);
        SpecifyBoxPanel.add(optionC);
        SpecifyBoxPanel.add(optionD);
        SpecifyPanel.add(SpecifyBoxPanel);
        centerPanel.add(SpecifyPanel);

        String Speciaity = "Yoga";

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

        TrianerController PT10TrainerController = new TrianerController();
        Trainer trainer = PT10TrainerController.showTrainerInfo(trainername);
        FirstNameInput.setText(trainer.getFirstName());
        LastNameInput.setText(trainer.getLastName());
        SexInput.setText(trainer.getGender());
        AgeInput.setText(trainer.getAge());
//        optionA.setSelected();
        switch(trainer.getSpeciaity()){
            case "Hit":
                optionA.setSelected(true);
                break;
            case "Yoga":
                optionB.setSelected(true);
                break;
            case "Shaping":
                optionC.setSelected(true);
                break;
            case "D.":
                optionD.setSelected(true);
                break;
        }
        PWInput.setText(trainer.getPassword());

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT4(trainername);
            }
        });

        nextbutton.setText("Change Info");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PWInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input password", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    Trainer newTrainer = new Trainer(FirstNameInput.getText(),
                            LastNameInput.getText(),
                            SexInput.getText(),
                            AgeInput.getText(),
                            Speciaity,
                            PWInput.getText());
                    int err = PT10TrainerController.editTrainerInfo(trainername, newTrainer);
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT4(trainername);
                }
            }
        });


    }
}