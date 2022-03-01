package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class GuiApp {
  private Calculator calculator = new Calculator();

    public static void main(String[] args) {
    new GuiApp().display();
  }

    private void display() {
        JFrame frame = new JFrame("RPN App");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        final JTextField textField = new JTextField(10);

        // Create button for each digit
        for (int i = 0; i < 10; i++){
            JButton digitButton = new JButton(Integer.toString(i));
            int finalI = i;
            digitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // When button is pressed, add to stack of digits
                    calculator.addToCurrentDigits(finalI);
                    textField.setText(Integer.toString(finalI));
                }
            });
            panel.add(digitButton);
        }

        // Create button for each operation
        List<String> operatorNames = Arrays.asList("+", "-");
        for (int i=0; i < operatorNames.size(); i++) {
            JButton operatorButton = new JButton(operatorNames.get(i));
            int finalI = i;
            operatorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // When operator button is pressed, perform operation of top two digits in stack
                    int result = calculator.calculate(operatorNames.get(finalI));
                    textField.setText(Integer.toString(result));
                }
            });
            panel.add(operatorButton);
        }

        panel.add(textField);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
