package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1, l2 *ListNode) *ListNode {
	dummyHead := new(ListNode)
	cur := dummyHead
	val, next := 0, 0
	for l1 != nil && l2 != nil {
		val = l1.Val + l2.Val + next
		if val >= 10 {
			next = val / 10
			val = val % 10
		} else {
			next = 0
		}
		l1, l2 = l1.Next, l2.Next
		cur.Next = &ListNode{Val: val}
		cur = cur.Next
	}

	for l1 != nil {
		val = l1.Val + next
		if val >= 10 {
			next = val / 10
			val = val % 10
		} else {
			next = 0
		}
		l1 = l1.Next
		cur.Next = &ListNode{Val: val}
		cur = cur.Next
	}

	for l2 != nil {
		val = l2.Val + next
		if val >= 10 {
			next = val % 10
			val = val / 10
		} else {
			next = 0
		}
		l2 = l2.Next
		cur.Next = &ListNode{Val: val}
		cur = cur.Next
	}
	if next != 0 {
		cur.Next = &ListNode{Val: next}
	}
	return dummyHead.Next
}
