package gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A5 extends TRMain {
    //    private Order order;
    JLabel EmptyLabel;
    int[] addOnss;

    JPanel FirstPanel;
    JLabel FirstLabel;
    JLabel SecondLabel;
    private JLabel MonthJLabel;
    private JLabel QuarterJLabel;
    private JLabel AnnualJLabel;

    private JLabel JLabel10;
    private JLabel JLabel30;
    private JLabel JLabel100;
    TextField MonthText;
    TextField QuarterText;
    TextField AnnualText;
    TextField Text10;
    TextField Text30;
    TextField Text100;


    public A5(String name) {
        super(name);



        centerPanel.setLayout(new GridLayout(2, 4));


        FirstLabel = new JLabel("CM");
        centerPanel.add(FirstLabel);

        JPanel a = new JPanel();
        a.setLayout(new BorderLayout());

        MonthJLabel = new JLabel("Month");
        MonthText = new TextField(1);
        a.add(MonthJLabel,BorderLayout.NORTH);
        a.add(MonthText,BorderLayout.CENTER);
        centerPanel.add(a);


        JPanel b = new JPanel();
        b.setLayout(new BorderLayout());
        QuarterJLabel = new JLabel("Quarter");
        QuarterText = new TextField(1);
        b.add(QuarterJLabel,BorderLayout.NORTH);
        b.add(QuarterText,BorderLayout.CENTER);
        centerPanel.add(b);

        JPanel c = new JPanel();
        c.setLayout(new BorderLayout());
        AnnualJLabel = new JLabel("Annual");
        AnnualText = new TextField(1);
        c.add(AnnualJLabel,BorderLayout.NORTH);
        c.add(AnnualText,BorderLayout.CENTER);
        centerPanel.add(c);



        SecondLabel = new JLabel("PM");
        centerPanel.add(SecondLabel);

        JPanel d = new JPanel();
        d.setLayout(new BorderLayout());
        JLabel10 = new JLabel("10 items");
        Text10 = new TextField(1);
        d.add(JLabel10,BorderLayout.NORTH);
        d.add(Text10,BorderLayout.CENTER);
        centerPanel.add(d);


        JPanel e = new JPanel();
        e.setLayout(new BorderLayout());
        JLabel30 = new JLabel("30 items");
        Text30 = new TextField(1);
        e.add(JLabel30,BorderLayout.NORTH);
        e.add(Text30,BorderLayout.CENTER);
        centerPanel.add(e);


        JPanel f = new JPanel();
        f.setLayout(new BorderLayout());
        JLabel100 = new JLabel("100 items");
        Text100 = new TextField(1);
        f.add(JLabel100,BorderLayout.NORTH);
        f.add(Text100,BorderLayout.CENTER);
        centerPanel.add(f);


        prebutton.setText("Back");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                new A2("Administrator Page");
            }
        });

        nextbutton.setVisible(false);


    }
}