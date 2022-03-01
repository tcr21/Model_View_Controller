package ic.doc;

import java.util.Stack;

public class Calculator {
    public Stack<Integer> currentDigits = new Stack<>();
    public void addToCurrentDigits(int i) {
        currentDigits.add(i);
    }

    public int calculate(String name) {
        if (currentDigits.size() < 2) throw new IllegalStateException("Not enough numbers on stack");
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
