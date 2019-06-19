package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	cur := head
	len := 0
	arr := []int{}
	for cur != nil {
		next := cur.Next
		len++
		arr = append(arr, cur.Val)
		cur = next
	}

	if k > len {
		k = k % len
	}

	if k == 0 {
		return head
	}

	reverse(arr, 0, len-1)
	reverse(arr, 0, k-1)
	reverse(arr, k, len-1)
	dummyHead := new(ListNode)
	curHead := dummyHead
	for _, n := range arr {
		next := new(ListNode)
		next.Val = n
		curHead.Next = next
		curHead = curHead.Next
	}
	return dummyHead.Next
}

func reverse(arr []int, i, j int) {
	for i > j {
		arr[i], arr[j] = arr[j], arr[i]
		i--
		j++
	}
}
