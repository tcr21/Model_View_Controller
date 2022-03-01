package ic.doc;

import java.util.Stack;

public class PressButton {
    private Stack<Integer> currentDigits = new Stack<>();
    public void addToCurrentDigits(int i) {
        currentDigits.add(i);
    }

    public int calculate(String name) {
        int second = currentDigits.pop();
        int first = currentDigits.pop();
        int result = 0;
        if (name == "+") {
            result = first + second;
        }
        else if (name == "-") {
            result = first - second;
        }
        currentDigits.add(result);
        return result;
    }
}
