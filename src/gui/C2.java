package gui;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C2 extends TRMain {

    //    private Order order;
    JLabel  EmptyLabel;
    int[] addOnss;

    JPanel WelcomePanel;
    private JLabel WelcomeLabel;

    JPanel YourIdPanel;
    private JLabel YourIdLabel;

//    Price price;
//    Inventory inventory;

    public C2(String name, String userid) {
        super(name);

        addOnss=new int[4];

        centerPanel.setLayout(new GridLayout(3,1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        WelcomePanel = new JPanel();
        WelcomeLabel = new JLabel("Welcome!"+"");//加入姓名
        WelcomePanel.add(WelcomeLabel);
        centerPanel.add(WelcomePanel);


        YourIdPanel = new JPanel();
        YourIdLabel = new JLabel("Your ID is:"+userid);//加入ID
        YourIdPanel.add(YourIdLabel);
        centerPanel.add(YourIdPanel);

        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM system");
            }
        });

        nextbutton.setText("Log in");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new C3("Sign in");
            }
        });


    }
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextbutton) {
            textLabel.setText("111");
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

            //thisFrame.setVisible(false);
            //thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
