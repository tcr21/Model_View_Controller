package ic.doc;

import java.util.Stack;

public class Model {
  private final Updatable view;
  public Stack<Integer> currentDigits = new Stack<>();

  public Model(Updatable view) {
    this.view = view;
  }

  public void addToCurrentDigits(int i) {
    currentDigits.add(i);
    view.update(this);
  }

  public void calculate(String name) {
    if (currentDigits.size() < 2) {
      throw new IllegalStateException("Not enough numbers on stack");
    }
    int second = currentDigits.pop();
    int first = currentDigits.pop();
    int result = 0;
    if (name.equals("+")) {
      result = first + second;
    } else if (name.equals("-")) {
      result = first - second;
    }
    currentDigits.add(result);
    view.update(this);
  }
}
