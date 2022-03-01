package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiApp {
  public static void main(String[] args) {
    new GuiApp().display();
  }

    private void display() {
        JFrame frame = new JFrame("RPN App");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        final JTextField textField = new JTextField(10);

        ArrayList<JButton> digitButtons = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            digitButtons.add(new JButton(Integer.toString(i)));
            digitButtons.get(i).addActionListener(actionEvent -> textField.setText("Pressed"));
            panel.add(digitButtons.get(i));
        }

        ArrayList<JButton> operatorButtons = new ArrayList<>();
        operatorButtons.add(new JButton("+"));
        operatorButtons.add(new JButton("-"));

        for (int i = 0; i < operatorButtons.size(); i++){
            operatorButtons.get(i).addActionListener(actionEvent -> textField.setText("Pressed"));
            panel.add(operatorButtons.get(i));
        }

        panel.add(textField);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
