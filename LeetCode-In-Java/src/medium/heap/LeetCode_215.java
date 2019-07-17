package medium.heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/14
 */
public class LeetCode_215 {

/*    O(nlogk) running time，O(K)memory
       public int findKthLargest(int[] nums, int k) {
        //默认维护小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue(k);

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }*/

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    public void shuffle(int nums[]) {

        final Random random = new Random();
        for (int ind = 1; ind < nums.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(nums, ind, r);
        }
    }

    private void exch(int[] nums, int i, int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //k
    public static void main(String[] args) {
        LeetCode_215 leetCode_215 = new LeetCode_215();
        int num = leetCode_215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(num);
    }
}
