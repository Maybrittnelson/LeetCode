package medium.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/31
 */
public class LeetCode_503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                next[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return next;
    }

    public static void main(String[] args) {
        LeetCode_503 leetCode_503 = new LeetCode_503();
        leetCode_503.nextGreaterElements(new int[]{1, 2, 1});
    }
}
