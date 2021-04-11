package gui;
import io.FileDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends TRMain {

//    Button now;

    public HomePage(String name) {
        super(name);
//        Price price = (Price) FileDB.read("file/manager/price");
        JLabel jLabel = new JLabel("", JLabel.CENTER);
        Icon icon = new ImageIcon("./src/gui/1.png");
        jLabel.setIcon(icon);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jLabel, BorderLayout.CENTER);
        prebutton.setText("Admin");
        prebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        centerbutton.setText("Customer");
        centerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                thisFrame.setVisible(false);
//                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        nextbutton.setText("Trainer");
        nextbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(false);
                thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

    }
    public static void main(String[] args) {
        HomePage a = new HomePage("健身房预约系统");
    }
}
