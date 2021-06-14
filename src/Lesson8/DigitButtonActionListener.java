package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonActionListener implements ActionListener {

    private final JTextField inputString;

    public DigitButtonActionListener(JTextField inputString) {
        this.inputString = inputString;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        StringBuilder stringBuilder = new StringBuilder(inputString.getText());
        stringBuilder.append(button.getText());

        inputString.setText(stringBuilder.toString());
    }
}
