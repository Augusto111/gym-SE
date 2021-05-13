package gui;


import javax.swing.*;
//import io.FileDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT1 extends TRMain {

    //    private Order order;
    JLabel  EmptyLabel;
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

    JPanel HeightPanel;
    private JLabel HeightLabel;
    private TextField HeightInput;

    JPanel WeightPanel;
    private JLabel WeightLabel;
    private TextField WeightInput;

    JPanel SpecialtyPanel;
    private JLabel SpecialtyLabel;
    private JPanel SpecialtyBoxPanel;
    JCheckBox optionA;
    JCheckBox optionB;
    JCheckBox optionC;
    JCheckBox optionD;


    JPanel PWPanel;
    private JLabel PWLabel;
    private TextField PWInput;

    JPanel PW2Panel;
    private JLabel PW2Label;
    private TextField PW2Input;


//    Price price;
//    Inventory inventory;

    public PT1(String name) {
        super(name);

        addOnss=new int[4];

        centerPanel.setLayout(new GridLayout(9,1));
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

        HeightPanel = new JPanel();
        HeightLabel = new JLabel("Height:");
        HeightPanel.add(HeightLabel);
        HeightInput = new TextField(15);
        HeightPanel.add(HeightInput);
        centerPanel.add(HeightPanel);

        WeightPanel = new JPanel();
        WeightLabel = new JLabel("Weight:");
        WeightPanel.add(WeightLabel);
        WeightInput = new TextField(15);
        WeightPanel.add(WeightInput);
        centerPanel.add(WeightPanel);

        SpecialtyPanel = new JPanel();
        SpecialtyBoxPanel = new JPanel();
        SpecialtyLabel = new JLabel("Specialty:");
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

        PWPanel = new JPanel();
        PWLabel = new JLabel("Password:");
        PWPanel.add( PWLabel);
        PWInput = new TextField(15);
        PWPanel.add( PWInput);
        centerPanel.add( PWPanel);

        PW2Panel = new JPanel();
        PW2Label = new JLabel("Confirm Password:");
        PW2Panel.add( PW2Label);
        PW2Input = new TextField(15);
        PW2Panel.add( PW2Input);
        centerPanel.add( PW2Panel);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM system");
            }
        });

        nextbutton.setText("Submit");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PWInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input password", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if(!PWInput.getText().equals(PW2Input.getText())){
                    JOptionPane.showMessageDialog(null, "Please confirm same password", "ERROR",
                            JOptionPane.WARNING_MESSAGE);
                }
                else {

                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT2("Welcome XXX");
                }
            }
        });


    }

/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextbutton) {
            C2 c2 = new C2("haha");
//            if(Integer.parseInt(EggVal.getText())!=0 ) {
//                //TODO dynamic set the price, not hardcode
//                ExtraDishOption egg = new Egg(price.getEggPrice(),Integer.parseInt(EggVal.getText()));
//                this.order.getOption().add(egg);
//                addOnss[1]=Integer.parseInt(EggVal.getText());
//            }
//            if(Integer.parseInt(BamVal.getText()) !=0) {
//                //TODO dynamic set the price, not hardcode
//                ExtraDishOption bambooShoots = new BambooShoots(price.getBambooShootsPrice(),Integer.parseInt(BamVal.getText()));
//                this.order.getOption().add(bambooShoots);
//                addOnss[2]=Integer.parseInt(BamVal.getText()) ;
//            }
//            if(Integer.parseInt(ChashuVal.getText()) !=0 ) {
//
//                ExtraDishOption chashu = new Chashu(price.getChashuPrice(),Integer.parseInt(ChashuVal.getText()));
//                this.order.getOption().add(chashu);
//                addOnss[3]=Integer.parseInt(ChashuVal.getText());
//            }

            thisFrame.setVisible(false);
            thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            Order3 order3 = new Order3("Dining Options",order);

        }

        if (e.getSource() == prebutton) {
            thisFrame.setVisible(false);
            thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//            double dishPrice = price.getDishPrice();
//            Order1 order1 = new Order1("Fixed price \uFFE1 "+String.valueOf(price));
        }
    }*/
}
