package simple

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	ca, cb := headA, headB
	ba, bb := false, false
	for ca != nil && cb != nil {
		if ca == cb {
			return ca
		}

		ca, cb = ca.Next, cb.Next
		if ca == nil && !ba {
			ca = headB
			ba = true
		}
		if cb == nil && !bb {
			cb = headA
			bb = true
		}
	}
	return nil
}
