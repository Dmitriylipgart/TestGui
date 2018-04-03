package com.lipgart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel upperPanel = new JPanel();
    private JButton button = new JButton();
    private JTextField textField = new JTextField(15);
    private JTextArea textArea = new JTextArea(10, 20);
    private JCheckBox checkBox = new JCheckBox("Uppercase");
    private boolean check;

    public void setGui(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setText("Add");
        button.addActionListener(new AddMouse());
        checkBox.addItemListener(new CheckBox());
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        upperPanel.add(textField);
        upperPanel.add(checkBox);
        panel.add(BorderLayout.NORTH, upperPanel);
        panel.add(BorderLayout.CENTER, textArea);
        panel.add(BorderLayout.SOUTH, button);
        checkBox.setBackground(Color.gray);
        panel.setBackground(Color.gray);
        frame.setContentPane(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);



    }

    class AddMouse implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
                if(check) {
                    textArea.append(textField.getText().toUpperCase() + "\n");
                }else {

                    textArea.append(textField.getText() + "\n");
                }
                textField.setText("");
                textField.requestFocus();
        }
    }

    class CheckBox implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            check = false;
            if (checkBox.isSelected()){
                check = true;
            }
        }
    }


}
