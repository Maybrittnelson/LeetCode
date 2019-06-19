package simple

type MyLinkedList struct {
	Head, Tail *ListNode
	Size       int
}

func Constructor() MyLinkedList {
	tail := &ListNode{}
	head := &ListNode{Next: tail}
	return MyLinkedList{
		Tail: tail,
		Head: head,
	}
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 || this.Size <= index {
		return -1
	}

	l, cur := 0, this.Head.Next
	if l < index {
		l++
		cur = cur.Next
	}
	return cur.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	nd := &ListNode{Val: val}
	nd.Next = this.Head.Next
	this.Head.Next = nd
	this.Size++
}

func (this *MyLinkedList) AddAtTail(val int) {
	this.Tail.Val = val
	nd := &ListNode{}
	this.Tail.Next = nd
	this.Tail = nd
	this.Size++
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	switch {
	case index < 0 || this.Size < index:
		return
	case index == 0:
		this.AddAtHead(val)
		return
	case index == this.Size:
		this.AddAtTail(val)
		return
	}

	l, cur := -1, this.Head
	for l+1 < index {
		l++
		cur = cur.Next
	}

	nd := &ListNode{Val: val}
	nd.Next = cur.Next
	cur.Next = nd
	this.Size++
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 || this.Size <= index {
		return
	}

	l, cur := -1, this.Head
	for l+1 < index {
		l++
		cur = cur.Next
	}

	cur.Next = cur.Next.Next
	this.Size--
}
