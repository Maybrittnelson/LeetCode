package medium.stack;

import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/25
 */
public class LeetCode_739 {

/*    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        for (int i = 0; i < T.length - 1; i++) {
            int cnt = 1;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = cnt;
                }
                cnt++;
            }
        }

        return res;
    }*/

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            //直到出现比自己大的，才会出栈比较
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int ind = stack.pop();
                res[ind] = i - ind;
            }
            stack.push(i);
        }

        return res;
    }

   /* public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        int top = -1;
        int[] stack = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int ind = stack[top--];
                res[ind] = i - ind;
            }
            stack[++top] = i;
        }
        return res;
    }*/
}
