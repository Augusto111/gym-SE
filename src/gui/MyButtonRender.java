package gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MyButtonRender implements TableCellRenderer {
    private JPanel jPanel;
    private JButton jButton;
    private String name;

    public MyButtonRender(String name) {
        initJPanel();
        initButton();
        jPanel.add(jButton);
        this.name = name;
    }
//    java.awt.Button[button0,0,0,0x0,invalid,label=cancel]

    private void initButton() {
        jButton = new JButton();
        jButton.setText(name);
        jButton.setBounds(2, 3, 75, 10);
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("kkkk");

            }

        } );
    }

    private void initJPanel() {
        jPanel = new JPanel();
        jPanel.setLayout(null);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        jButton.setText(name);
        System.out.println("ooooo");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("e.getActionCommand()");
                System.out.println(e.getActionCommand());
                System.out.println(jButton.getText());
            }
        });
        return jPanel;
    }

}

