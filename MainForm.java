package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel panel1;
    private JPanel displayPanel;
    private JTextField textFieldRst;
    private JPanel buttonPanel;
    private JButton button1;
    private JButton button2;
    private JButton xButton;
    private JButton a1XButton;
    private JButton CEButton;
    private JButton cButton;
    private JButton delButton;
    private JButton button8;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton button12;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button15;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button18;
    private JButton a2Button;
    private JButton button20;
    private JButton a0Button;
    private JButton a3Button;
    private JButton button23;
    private JButton button24;

    private CalculatorCore cc;

    public MainForm() {

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton)(e.getSource());
                CalculatorEvent ce = new CalculatorEvent(CalculatorEvent.EventType.NUMBER, jb.getText());
                cc.HandleButtonClick(ce);
                textFieldRst.setText(cc.GetSBuffer());
            }
        };
        a7Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        button20.addActionListener(listener);
        a0Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);

        cc = new CalculatorCore();
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton)(e.getSource());
                CalculatorEvent ce = new CalculatorEvent(CalculatorEvent.EventType.SINGLEOPERATOR, jb.getText());
                cc.HandleButtonClick(ce);
                textFieldRst.setText(cc.GetSBuffer());
            }
        };
        button1.addActionListener(listener1);
        button2.addActionListener(listener1);
        xButton.addActionListener(listener1);
        a1XButton.addActionListener(listener1);
        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton)(e.getSource());
                CalculatorEvent ce = new CalculatorEvent(CalculatorEvent.EventType.DOUBLEOPERATOR, jb.getText());
                cc.HandleButtonClick(ce);
                textFieldRst.setText(cc.GetSBuffer());
            }
        };
        button8.addActionListener(listener2);
        button15.addActionListener(listener2);
        button18.addActionListener(listener2);
        button23.addActionListener(listener2);
        ActionListener listener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton)(e.getSource());
                CalculatorEvent ce = new CalculatorEvent(CalculatorEvent.EventType.COMMAND, jb.getText());
                cc.HandleButtonClick(ce);
                textFieldRst.setText(cc.GetSBuffer());
            }
        };
        CEButton.addActionListener(listener3);
        cButton.addActionListener(listener3);
        delButton.addActionListener(listener3);
        button12.addActionListener(listener3);
        button24.addActionListener(listener3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2645 Calculator");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
