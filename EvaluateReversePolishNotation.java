import java.util.Stack;

class Solution {
    Stack<Integer> numbers = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            if (isNum(temp)) {
                numbers.push(Integer.parseInt(temp));
            } else {
                numbers.push(calculateNumber(temp));
            }
        }
        return numbers.pop();
    }

    private boolean isNum(String temp) {
        return temp.matches("-?\\d+(\\.\\d+)?");
    }

    private int calculateNumber(String operator) {
        int number2 = numbers.pop();
        int number1 = numbers.pop();
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
        }
        return -1;
    }
}