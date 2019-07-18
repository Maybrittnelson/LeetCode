package medium.stack;

import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/18
 */
public class LeetCode_456 {
/*
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] < nums[j] && nums[i] < nums[j] && nums[k] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    public boolean find132pattern(int[] nums) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        Integer left = null;
        int i = 0;
        while (i < nums.length) {
            if (s1.empty() || nums[i] <= s1.peek()) {
                if (left == null || left >= nums[i]) {
                    left = nums[i];
                } else {
                    s1.push(left);
                    s2.push(nums[i]);
                    left = null;
                }
                i++;
            } else if (nums[i] < s2.peek()) {
                return true;
            } else {
                int l = s1.pop();
                s2.pop();
                if (left == null)
                    left = l;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_456 leetCode_456 = new LeetCode_456();
        leetCode_456.find132pattern(new int[]{-1, 3, 2, 0});
    }
}
