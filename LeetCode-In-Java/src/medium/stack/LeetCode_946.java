package medium.stack;

import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/19
 */
public class LeetCode_946 {
    /**
     * Give two sequences pushed and popped with distinct values, return
     * true if and only if this could have been the result of a sequence of
     * push and pop operations on an initially empty stack
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int n : pushed) {
            stack.push(n);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.size() == 0 ? true : false;
    }
}
