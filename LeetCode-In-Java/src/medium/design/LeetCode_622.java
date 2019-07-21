package medium.design;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/21
 */
public class LeetCode_622 {

    //arr
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

    //list
 /*  class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node front, rear;
    int k;
    int count;

    public MyCircularQueue(int k) {
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (count == k) {
            return false;
        }
        count++;
        Node cur = new Node(value);
        if(front == null) {
            front = cur;
        } else {
            rear.next = cur;
        }
        rear = cur;
        return true;
    }

    public boolean deQueue() {
        if (front == null) {
            return false;
        }

        count--;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        return true;
    }

    public int Front() {
        if (frot == null) {
            return -1;
        }

        return front.val;
    }

    public int Rear() {
        if (rear == null) {
            return -1;
        }
        return rear.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return count == k;
    }*/
}
