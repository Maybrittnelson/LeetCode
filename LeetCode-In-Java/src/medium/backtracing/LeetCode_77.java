package medium.backtracing;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_77 {
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            output.add(new LinkedList<>(cur));
        }

        for (int i = first; i < n + 1; i++) {
            cur.add(i);
            System.out.println(cur);
            backtrack(i + 1, cur);
            cur.removeLast();
            System.out.println(cur);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return output;
    }

    public static void main(String[] args) {
        LeetCode_77 leetCode_77 = new LeetCode_77();
        leetCode_77.combine(4, 2);
        System.out.println(leetCode_77.output);
    }
}
