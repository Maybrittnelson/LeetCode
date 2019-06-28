package medium.list;

public class LeetCode_142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode p1, p2;

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        p1 = head;
        p2 = head;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            if (p2.next == null) {
                return false;
            }
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (hasCycle(head) == false) {
            return null;
        }

        p1 = head;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
