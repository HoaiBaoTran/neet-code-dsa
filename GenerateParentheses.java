import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /* Only add open parenthesis if open < n
     * only add a closing parenthesis of closed < n
     * valid If open == closed == n
     */

    // Brute Force
    /*
    public List<String> GenerateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, "", res);
        return res;
    }

    
    private void dfs(int n, String s, List<String> res) {
       if (s.length() == n * 2) {
            if(isValid(s)) {
                res.add(s);
            }
            return;
       }

       dfs(n, s + '(', res);
       dfs(n, s + ')', res);
    }

    private boolean isValid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) return false;
        }
        return open == 0;
    }
    */

    // Back tracking
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtracking(0, 0, n, sb, res);
        return res;
    }

    private void backtracking(int openN, int closeN, int n, StringBuilder sb, List<String> res) {
        if (openN == closeN && openN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append('(');
            backtracking(openN + 1, closeN, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeN < openN) {
            sb.append(')');
            backtracking(openN, closeN + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
