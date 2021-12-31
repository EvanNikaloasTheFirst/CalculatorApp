import javax.swing.JFrame;
import javax.swing.JTextArea;

class Calculator {
    private JFrame frame = new JFrame("Calculator");
    private JTextArea input = new JTextArea();
    private JTextArea output = new JTextArea();

    public Calculator() {
    }

    public static void main(String[] args) {
        new CalculatorTest();
    }
}

