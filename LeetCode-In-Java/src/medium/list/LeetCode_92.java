package medium.list;

import java.util.List;

public class LeetCode_92 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode head1 = dummyHead, begin = null, mid = null, end = null;

        //find begin, mid, end
        int i = 0;
        while (head1 != null) {
            ListNode next = head1.next;
            if (i == m - 1) {
                begin = head1;
                mid = next;
            }

            if (i == n) {
                end = next;
                head1.next = null;
            }
            i++;
            head1 = head1.next;
        }

        //reverse mid
        mid = reverse(mid);

        //union
        begin.next = mid;
        for (; mid != null; ) {
            if (mid.next == null) {
                mid.next = end;
                break;
            }
            mid = mid.next;
        }

        return dummyHead.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        reverseBetween(head, 1, 2);
    }


}
