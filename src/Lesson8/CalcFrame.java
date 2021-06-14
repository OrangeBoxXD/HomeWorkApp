package Lesson8;

import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame{

    private JTextField inputString;

    public CalcFrame() throws ScriptException {
        setTitle("Easy Calc v0.7");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(700, 300, 400, 500);

        setJMenuBar(CreateMenuBar());
        setLayout(new BorderLayout());


        add(createTopPanel(), BorderLayout.NORTH);
        add(createBottomPanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar CreateMenuBar() {
        JMenuBar AppMenuBar = new JMenuBar();

        JMenu AppMenu = new JMenu("Choose me");
        JMenuItem exitItem = new JMenu("Exit");
        JMenuItem openItem = new JMenu("Open");

        AppMenu.add(openItem);
        AppMenu.add(exitItem);
        AppMenuBar.add(AppMenu);

        return AppMenuBar;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputString = new JTextField();
        inputString.setEditable(false);
        top.add(inputString, BorderLayout.CENTER);

        return top;
    }
    private JPanel createBottomPanel() throws ScriptException {
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 6));

        DigitButtonActionListener digitButtonActionListener = new DigitButtonActionListener(inputString);
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(digitButtonActionListener);
            bottom.add(button);
        }
        JButton clear = new JButton("C");
        clear.addActionListener(e -> inputString.setText(""));
        bottom.add(clear);

        JButton plus = new JButton("+");
        plus.addActionListener(e -> inputString.setText(inputString.getText() + "+"));
        bottom.add(plus);

        JButton multiply = new JButton("*");
        multiply.addActionListener(e -> inputString.setText(inputString.getText() + "*"));
        bottom.add(multiply);

        JButton divide = new JButton("/");
        divide.addActionListener(e -> inputString.setText(inputString.getText() + "/"));
        bottom.add(divide);

        JButton subtract = new JButton("-");
        subtract.addActionListener(e -> inputString.setText(inputString.getText() + "-"));
        bottom.add(subtract);

        JButton sqrt = new JButton("sqrt");
        sqrt.addActionListener(new SqrtActionListener(inputString));
        bottom.add(sqrt);

        JButton execute = new JButton("=");
        execute.addActionListener(new CalcButtonActionListener(inputString));
        bottom.add(execute);

        return bottom;
    }

}
