class ListNode:
    def __init__(self, x):
        self.x = x
        self.next = None

class Solution:
    def two_sum(self, l1, l2):
        q, p, carray, head = l1, l2, 0, ListNode(0)
        cur = head
        while q != None or p != None:
            x = 0 if q == None else q.val
            y = 0 if p == None else p.val
            sum = x + y + carray
            carray =  sum//10
            cur.next = ListNode(sum % 10)
            if q != None:
                q = q.next
            if p != None:
                p = p.next
        if carray > 0:
            cur.next = ListNode(carray)
        return head.next

        