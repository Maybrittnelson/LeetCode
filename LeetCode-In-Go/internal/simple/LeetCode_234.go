package simple

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {

	cur := head
	var pre *ListNode
	for cur != nil {
		next := cur.Next
		cur1 := new(ListNode)
		cur1.Val = cur.Val
		cur1.Next = pre
		pre = cur1
		cur = next
	}

	for pre != nil {
		if pre.Val != head.Val {
			return false
		}
		pre = pre.Next
		head = head.Next
	}
	return true
}
