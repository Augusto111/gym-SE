package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//引入事件包


public class TRMain implements ActionListener{
    JFrame thisFrame ;
    JButton nextbutton;
    JButton centerbutton;
    JButton prebutton;
    JLabel textLabel;
    Panel centerPanel ;
    Panel controlpaPanel=new Panel();

    public TRMain(String name){
        thisFrame= new JFrame();
        Font myFont = new Font("Arial", 1, 30);

        ////////read from the scrooter file and set the number of Panel//////////
        centerPanel=new Panel();
        textLabel = new JLabel(name, JLabel.CENTER);
        textLabel.setFont(myFont);
        JPanel controlPanel = new JPanel();

        //实例化按钮对象
        nextbutton=new JButton("Next");
        centerbutton = new JButton("Center");
        prebutton=new JButton("Back");

        //为按钮对象注册监听器

        nextbutton.addActionListener(this);
        centerbutton.addActionListener(this);
        prebutton.addActionListener(this);


        controlpaPanel.add(prebutton);
        controlpaPanel.add(centerbutton);
        controlpaPanel.add(nextbutton);

       // buttonPanel.setLayout(new GridLayout(0,1,30,30));
        thisFrame.setLayout(new BorderLayout());
        thisFrame.add("North",textLabel);
        thisFrame.add("Center",centerPanel);
        thisFrame.add("South",controlpaPanel);

        thisFrame.setTitle("");
        thisFrame.setSize(800, 800);
        // thisFrame.getContentPane().setBackground(Color.blue);
        thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisFrame.setLocationRelativeTo(null);
        thisFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TRMain("Fixed SIze");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //如果用户单击nextbutton，执行的语句

        if (e.getSource() == nextbutton) {
            textLabel.setText("next");
            //切换cardPanel面板中当前组件之后的一个组件

            //若当前组件为最后添加的组件，则显示第一个组件，即卡片组件显示是循环的。

            // card.next(cardPanel);

        }

        if (e.getSource() == prebutton) {
            textLabel.setText("back");
            //切换cardPanel面板中当前组件之前的一个组件

            //若当前组件为第一个添加的组件，则显示最后一个组件，即卡片组件显示是循环的。

//                card.previous(cardPanel);

        }

        if (e.getSource() == centerbutton) {
            textLabel.setText("center");
            //切换cardPanel面板中当前组件之后的一个组件

            //若当前组件为最后添加的组件，则显示第一个组件，即卡片组件显示是循环的。

            // card.next(cardPanel);

        }
    }
}

