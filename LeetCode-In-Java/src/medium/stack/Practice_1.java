package medium.stack;

import java.util.Stack;

//two long string add
public class Practice_1 {

    public String add(String s1, String s2) {
        Stack<Integer> ss1 = str2stack(s1);
        Stack<Integer> ss2 = str2stack(s2);

        Stack<Integer> result = new Stack<>();
        int hex = 0;
        for (; !ss1.isEmpty() && !ss2.isEmpty(); ) {
            int i1 = ss1.pop();
            int i2 = ss2.pop();

            int sum = i1 + i2 + hex;
            if (sum > 10) {
                hex = 1;
                result.add(sum % 10);
            } else {
                hex = 0;
                result.add(sum);
            }
        }

        add(hex, ss1, result);
        add(hex, ss2, result);

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }

    public void add(int hex, Stack<Integer> ss1, Stack<Integer> result) {
        while (!ss1.isEmpty()) {
            int i1 = ss1.pop();

            int sum = hex + i1;
            if (sum > 10) {
                hex = 1;
            } else {
                hex = 0;
            }
            result.add(sum % 10);
        }
    }

    public Stack<Integer> str2stack(String s) {
        Stack<Integer> ss = new Stack<>();
        for (char c : s.toCharArray()) {
            ss.add(c - '0');
        }

        return ss;
    }

    public static void main(String[] args) {
        Practice_1 practice_1 = new Practice_1();
        practice_1.add("111111111111111111111111111111111111111111", "111111111111111111111111111111111111111111");
    }
}
