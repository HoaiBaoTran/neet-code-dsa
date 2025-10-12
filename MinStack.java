import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int val) {
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}