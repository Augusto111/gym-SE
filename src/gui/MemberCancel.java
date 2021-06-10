package gui;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberCancel extends AbstractCellEditor implements
        TableCellEditor {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6546334664166791132L;

    private JPanel panel;

    private JButton button;
    String acc = "cancel";

    public MemberCancel() {

        initButton();

        initPanel();

        panel.add(this.button, BorderLayout.CENTER);
    }

    private void initButton() {
        button = new JButton();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel it?", "choose",
                        JOptionPane.YES_NO_OPTION);

                if(res ==  JOptionPane.YES_OPTION){
                    System.out.println("ff");
                }
                //stopped!!!!
                fireEditingStopped();

            }
        });

    }

    private void initPanel() {
        panel = new JPanel();

        panel.setLayout(new BorderLayout());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {

        //button.setText(value == null ? "refuse" : String.valueOf(value));
        button.setText("cancel");
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return acc;
    }

}
