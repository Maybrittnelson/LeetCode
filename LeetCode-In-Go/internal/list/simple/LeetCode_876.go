package simple

func middleNode(head *ListNode) *ListNode {
	fast, low := head, head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		low = low.Next
	}
	return low
}
