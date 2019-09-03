package medium.backtracing;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_89 {

    private int nums = 0;

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        backtrack(n, res);
        return res;
    }

    public void backtrack(int n, List<Integer> res) {
        if (n == 0) {
            res.add(nums);
            return;
        } else {
            backtrack(n - 1, res);
            nums ^= (1 << n - 1);// 当n初始值为3时，这一行n的值依次为：1, 2, 1, 3, 1, 2, 1
            backtrack(n-1, res);
        }
    }
}
