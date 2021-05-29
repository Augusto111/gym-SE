package gui;

import bean.Trainer;
import controller.TrianerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PT3 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel UserIdPanel;
    private JLabel userIdLabel;
    private TextField UserIdInput;

    JPanel PWPanel;
    private JLabel PWLabel;
    private TextField PWInput;

//    Price price;
//    Inventory inventory;

    public PT3(String name) {
        super(name);

        addOnss=new int[4];

        centerPanel.setLayout(new GridLayout(3,1));
        EmptyLabel = new JLabel("");
        centerPanel.add(EmptyLabel);

        UserIdPanel = new JPanel();
        userIdLabel = new JLabel("User Name:");
        UserIdPanel.add(userIdLabel);
        UserIdInput = new TextField(15);
        UserIdPanel.add(UserIdInput);
        centerPanel.add(UserIdPanel);

        PWPanel = new JPanel();
        PWLabel = new JLabel("Password:");
        PWPanel.add( PWLabel);
        PWInput = new TextField(15);
        PWPanel.add( PWInput);
        centerPanel.add( PWPanel);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new HomePage("GYM system");
            }
        });
        centerbutton.setVisible(true);
        centerbutton.setText("Sign up");
        centerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new PT1("Sign up");
            }
        });
        nextbutton.setText("Log in");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TrianerController PT3TrainerController = new TrianerController();
                int LoginResult = PT3TrainerController.trainerLogin(UserIdInput.getText(),
                        PWInput.getText());
                if(LoginResult == 0){
                    thisFrame.setVisible(false);
                    thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    new PT4(UserIdInput.getText());
                }else if(LoginResult == 1){
                    System.out.println("用户名不存在");
                }else{
                    System.out.println("密码错误");
                }


            }
        });

        newbutton.setVisible(false);

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
    }

 */
}
