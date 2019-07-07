package medium.string;

import java.util.Stack;

public class LeetCode_227 {

    public int calculate(String s) {
        long res = 0, num = 0, n = s.length();
        char op = '+';
        Stack<Long> num_stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= '0') {
                num = num * 10 + s.charAt(i) - '0';
            }

            //s.charAt(i) < '0' like !Character.isDigit
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i == n - 1) {
                if (op == '+') {
                    num_stack.push(num);
                }
                if (op == '-') {
                    num_stack.push(-num);
                }
                if (op == '*' || op == '/') {
                    long tmp = (op == '*') ? num_stack.peek() * num : num_stack.peek() / num;
                    num_stack.pop();
                    num_stack.push(tmp);
                }
                op = s.charAt(i);
                num = 0;
            }
        }

        while (!num_stack.empty()) {
            res += num_stack.peek();
            num_stack.pop();
        }
        return Math.toIntExact(res);
    }

    public static void main(String[] args) {
        LeetCode_227 leetCode_227 = new LeetCode_227();
        System.out.println(leetCode_227.calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
    }
}
