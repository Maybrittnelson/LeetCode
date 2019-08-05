package medium.divideAndConquer;

import java.util.ArrayList;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/8/5
 */
public class LeetCode_932 {

    /**
     * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
     * <p>
     * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
     * <p>
     * 那么数组 A 是漂亮数组。
     * <p>
     *  
     * <p>
     * 给定 N，返回任意漂亮数组 A（保证存在一个）。
     *
     * @param N
     * @return
     */
    public int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : res) {
                if (i * 2 - 1 <= N) {
                    tmp.add(i * 2 - 1);
                }
            }
            for (int i : res) {
                if (i * 2 <= N) {
                    tmp.add(i * 2);
                }
            }
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        LeetCode_932 leetCode_932 = new LeetCode_932();
        int[] ints = leetCode_932.beautifulArray(4);
        System.out.println(ints);
    }
}
