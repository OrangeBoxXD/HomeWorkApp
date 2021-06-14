package Lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButtonActionListener implements ActionListener {

    private final JTextField inputString;

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("nashorn");

    public CalcButtonActionListener(JTextField inputString) throws ScriptException {
        this.inputString = inputString;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Object result = engine.eval(inputString.getText());
            inputString.setText(String.valueOf(result));
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
        }


    }
}

