package medium.stack.practice;

import lib.stack.LinkStack;

import java.util.Stack;

//two long string add
public class Practice_1 {

    public String add(String s1, String s2) {
        LinkStack<Integer> ss1 = str2stack(s1);
        LinkStack<Integer> ss2 = str2stack(s2);

        Stack<Integer> result = new Stack<>();
        int hex = 0;
        for (; !ss1.isEmpty() && !ss2.isEmpty(); ) {
            int i1 = ss1.pop();
            int i2 = ss2.pop();

            int sum = i1 + i2 + hex;
            if (sum >= 10) {
                hex = 1;
                result.add(sum % 10);
            } else {
                hex = 0;
                result.add(sum);
            }
        }

        LinkStack<Integer> last  = ss1.isEmpty() ? ss2 : ss1 ;

        while (!last.isEmpty()) {
            int i1 = last.pop();

            if (hex > 0) {
                int sum = i1 + hex;
                if (sum >= 10) {
                    result.add(sum - 10);
                } else {
                    hex = 0;
                    result.add(sum);
                }
            } else {
                result.add(i1);
            }
        }

        //last hex
        if (hex > 0) {
            result.add(hex);
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }

    public LinkStack<Integer> str2stack(String s) {
        LinkStack<Integer> ss = new LinkStack<>();
        for (char c : s.toCharArray()) {
            ss.push(c - '0');
        }

        return ss;
    }

    public static void main(String[] args) {
        Practice_1 practice_1 = new Practice_1();
        String add = practice_1.add("18452543389943209752345473", "8123542678432986899334");
        System.out.println(add);
    }
}
