package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButton extends JButton {
    JButton a;
    public CancelButton(String name){

        JButton a = new JButton(name) ;
        a.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //弹出对话框
                JOptionPane.showMessageDialog(null, "弹出对话框");
            }
        });

    }
}
