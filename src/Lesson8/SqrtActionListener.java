package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class SqrtActionListener implements ActionListener {
    private final JTextField inputString;

    public SqrtActionListener(JTextField inputString) {
        this.inputString = inputString;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int sqrt = (int) Math.sqrt(Double.parseDouble(inputString.getText()));
        inputString.setText(String.valueOf(sqrt));
    }
}
