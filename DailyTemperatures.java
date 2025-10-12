import java.util.Stack;

public class DailyTemperatures {

    // brute force
    /*
     * public int[] dailyTemperatures(int[] temperatures) {
     * int[] result = new int[temperatures.length];
     * for (int i = 0; i < temperatures.length - 1; i++) {
     * result[i] = 0;
     * for (int j = i + 1; j < temperatures.length; j++) {
     * if (temperatures[j] > temperatures[i]) {
     * result[i] = j - i;
     * break;
     * }
     * }
     * }
     * result[result.length - 1] = 0;
     * return result;
     * }
     */

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[] { t, i });
        }
        return result;
    }
}
