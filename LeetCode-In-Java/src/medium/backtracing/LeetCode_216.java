package medium.backtracing;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_216 {

    private List<List<Integer>> res = new LinkedList<>();
    private int k;
    private int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backtrack(k, n, 1, new LinkedList<>());
        return res;
    }

    public void backtrack(int k, int n, int j, LinkedList<Integer> list) {
        if (list.size() == k) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            if (sum == n) {
                res.add(new LinkedList<>(list));
            }
            return;
        }

        for (int i = j; i < 9; i++) {
            list.add(i);
            backtrack(k, n, i+1, list);
            list.removeLast();
        }
    }
}
