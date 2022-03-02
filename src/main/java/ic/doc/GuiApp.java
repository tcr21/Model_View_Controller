package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiApp {
  public View view = new View(new Controller());
  public Model calculator = new Model(view);

  class Controller implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // When button is pressed, check if it is digit: if yes add to stack, if no it is operator so
      // perform calculation
      String button = e.getActionCommand();
      if (isDigit(button)) {
        calculator.addToCurrentDigits(Integer.parseInt(button));
      } else {
        calculator.calculate(button);
      }
    }
  }

  public static void main(String[] args) {
    new GuiApp();
  }

  public static boolean isDigit(String button) {
    try {
      Integer.parseInt(button);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
