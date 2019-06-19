package simple

func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}

	fast := head.Next
	low := head
	for low != fast {
		if fast == nil || fast.Next == nil {
			return false
		}
		fast = fast.Next.Next
		low = low.Next
	}
	return true
}
