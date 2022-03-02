package ic.doc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class View implements Updatable {
  private final JTextField textField = new JTextField(10);
  private ArrayList<JButton> digitButtons = new ArrayList<>();
  private ArrayList<JButton> operatorButtons = new ArrayList<>();

  public View(ActionListener controller) {
    JFrame frame = new JFrame("RPN App");
    frame.setSize(400, 300);

    JPanel panel = new JPanel();

    JButton button;
    // Create button for each digit and add to array of buttons
    for (int i = 0; i < 10; i++) {
      button = new JButton(Integer.toString(i));
      button.addActionListener(controller);
      digitButtons.add(button);
      panel.add(button);
    }

    // Create button for each operator and add to array of buttons
    List<String> operatorNames = Arrays.asList("+", "-");
    for (String operatorName : operatorNames) {
      button = new JButton(operatorName);
      operatorButtons.add(button);
      button.addActionListener(controller);
      panel.add(button);
    }

    panel.add(textField);
    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }

  @Override
  // Always show top of stack
  public void update(Model calculator) {
    textField.setText(Integer.toString(calculator.currentDigits.peek()));
  }
}
