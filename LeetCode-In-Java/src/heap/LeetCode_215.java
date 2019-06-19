package heap;

import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/14
 */
public class LeetCode_215 {

    public int findKthLargest(int[] nums, int k) {
        //默认维护小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue(k);

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }

        return queue.peek();
    }

    //k
    public static void main(String[] args) {
        LeetCode_215 leetCode_215 = new LeetCode_215();
        int num = leetCode_215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(num);
    }
}
