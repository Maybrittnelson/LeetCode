package medium

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	cmap := make(map[int]*ListNode)
	l := 0
	cur := head
	for cur != nil {
		cmap[l] = cur
		l++
		cur = cur.Next
	}

	//n不在链表范围内，不做删除
	if n < 1 || n > l {
		return head
	}

	//删除头节点
	if n == l {
		dummyHead := &ListNode{Next: head}
		dummyHead.Next = dummyHead.Next.Next
		return dummyHead.Next
	}

	//删除头节点以外的其他节点
	if ln, ok := cmap[l-n-1]; ok {
		ln.Next = ln.Next.Next
	}
	return head
}
