package ic.doc;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View implements Updatable{
    JTextField textField = new JTextField(10);
    public ArrayList<JButton> digitButtons = new ArrayList<>();
    public ArrayList<JButton> operatorButtons = new ArrayList<>();

    public View(ActionListener controller) {
        JFrame frame = new JFrame("RPN App");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        // Create button for each digit
        JButton button;
        for (int i = 0; i<10; i++) {
            button = new JButton(Integer.toString(i));
            button.addActionListener(controller);
            digitButtons.add(button);
            panel.add(button);
        }

        // Create button for each operator
        List<String> operatorNames = Arrays.asList("+", "-");
        for (String operatorName : operatorNames) {
            button = new JButton(operatorName);
            operatorButtons.add(button);
            panel.add(button);
        }

        panel.add(textField);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    @Override
    public void update(Calculator calculator) {
        textField.setText(Integer.toString(calculator.currentDigits.peek()));
    }
}
