package medium.design;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/21
 */
public class LeetCode_622 {

    static class MyCircularQueue {

        int[] arr;
        int idx;
        int k;

        public MyCircularQueue(int k) {
            arr = new int[k];
            idx = -1;
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (idx + 1 == k) {
                return false;
            }

            arr[++idx] = value;
            return true;
        }

        public boolean deQueue() {
            if (idx == -1) {
                return false;
            }

            for (int i = 0; i< idx; i++) {
                arr[i] = arr[i+1];
            }
            idx--;
            return true;
        }

        public int Front() {
            if (idx == -1) {
                return -1;
            }

            return arr[0];
        }

        public int Rear() {
            if (idx == -1) {
                return -1;
            }
            return arr[idx];
        }

        public boolean isEmpty() {
            return idx == -1;
        }

        public boolean isFull() {
            return idx == k - 1;
        }
    }
}
