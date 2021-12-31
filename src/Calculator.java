import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalculatorTest implements ActionListener {
    private final JFrame frame = new JFrame("Calculator");
    private final JTextField input = new JTextField();
    private final JPanel panelTwo = new JPanel(new FlowLayout());
    private final JButton dec = new JButton(".");
    private final JButton add = new JButton("+");
    private final JButton minus = new JButton("-");
    private final JButton divide = new JButton("/");
    private final JButton multiply = new JButton("*");
    private final JButton clear = new JButton("AC");
    private final JButton equals = new JButton("=");
    private final JButton delete = new JButton("DEL");
    double num1;
    double num2;
    double result;
    int results;
    char operator;
    JButton[] buttons = new JButton[11];
    JButton[] operators = new JButton[8];

    public CalculatorTest() {
        this.operators[0] = this.add;
        this.operators[1] = this.minus;
        this.operators[2] = this.divide;
        this.operators[3] = this.multiply;
        this.operators[4] = this.equals;
        this.operators[5] = this.dec;
        this.operators[6] = this.clear;
        this.operators[7] = this.delete;

        int i;
        for(i = 0; i < 8; ++i) {
            this.operators[i].addActionListener(this);
        }

        for(i = 0; i < 10; ++i) {
            this.buttons[i] = new JButton(String.valueOf(i));
            this.buttons[i].addActionListener(this);
        }

        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(300, 500);
        this.frame.setLocationRelativeTo((Component)null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(3);
        this.panelTwo.setLayout(new GridLayout(3, 6, 10, 10));
        this.input.setLayout(new BorderLayout());
        this.input.setPreferredSize(new Dimension(400, 50));
        this.input.setEditable(true);
        Color CustomGrey = new Color(152, 146, 146);
        new Color(255, 255, 136);
        Color CustomWhite = new Color(255, 255, 255);
        Color CustomBlack = new Color(0, 0, 0);
        this.input.setBackground(CustomGrey);
        this.panelTwo.add(this.buttons[0]);
        this.panelTwo.add(this.buttons[1]);
        this.panelTwo.add(this.buttons[2]);
        this.panelTwo.add(this.buttons[3]);
        this.panelTwo.add(this.buttons[4]);
        this.panelTwo.add(this.buttons[5]);
        this.panelTwo.add(this.buttons[6]);
        this.panelTwo.add(this.buttons[7]);
        this.panelTwo.add(this.buttons[8]);
        this.panelTwo.add(this.buttons[9]);
        this.panelTwo.add(this.operators[0]);
        this.panelTwo.add(this.operators[1]);
        this.panelTwo.add(this.operators[2]);
        this.panelTwo.add(this.operators[3]);
        this.panelTwo.add(this.operators[4]);
        this.panelTwo.add(this.operators[5]);
        this.panelTwo.add(this.operators[6]);
        this.panelTwo.add(this.operators[7]);
        this.frame.add(this.panelTwo);
        this.frame.add(this.input);
        this.input.setBackground(CustomWhite);
        this.panelTwo.setBackground(CustomBlack);
        this.frame.getContentPane().setBackground(CustomBlack);
        this.frame.getContentPane().add(this.input, "North");
        this.frame.getContentPane().add(this.panelTwo, "Center");
        this.frame.setVisible(true);
        this.input.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; ++i) {
            if (e.getSource() == this.buttons[i]) {
                this.input.setText(this.input.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == this.dec) {
            this.input.setText(this.input.getText().concat("."));
        }

        if (e.getSource() == this.add) {
            this.num1 = Double.parseDouble(this.input.getText());
            this.operator = '+';
            this.input.setText("");
        }

        if (e.getSource() == this.minus) {
            this.num1 = Double.parseDouble(this.input.getText());
            this.operator = '-';
            this.input.setText("");
        }

        if (e.getSource() == this.divide) {
            this.num1 = Double.parseDouble(this.input.getText());
            this.operator = '/';
            this.input.setText("");
        }

        if (e.getSource() == this.multiply) {
            this.num1 = Double.parseDouble(this.input.getText());
            this.operator = '*';
            this.input.setText("");
        }

        if (e.getSource() == this.clear) {
            this.input.setText("");
        }

        if (e.getSource() == this.equals) {
            this.num2 = Double.parseDouble(this.input.getText());
            switch(this.operator) {
                case '*':
                    this.result = this.num1 * this.num2;
                    break;
                case '+':
                    this.result = this.num1 + this.num2;
                case ',':
                case '.':
                default:
                    break;
                case '-':
                    this.result = this.num1 - this.num2;
                    break;
                case '/':
                    this.result = this.num1 / this.num2;
            }

            this.input.setText(String.valueOf(this.result));
            this.num1 = this.result;
        }

        if (e.getSource() == this.delete) {
            String number = this.input.getText();
            this.input.setText("");

            for(int i = 0; i < number.length() - 1; ++i) {
                JTextField var10000 = this.input;
                String var10001 = this.input.getText();
                var10000.setText(var10001 + number.charAt(i));
            }
        }

    }
}