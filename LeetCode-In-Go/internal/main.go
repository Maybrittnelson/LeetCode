package main

import (
	"fmt"
	"strconv"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (head *ListNode) toString() string {
	var res string
	for head != nil {
		res = res + string(head.Val)
		fmt.Println(head.Val)
		head = head.Next
	}
	return res
}

func main() {
	compareVersion("1.001", "1.1")
}

func compareVersion(v1, v2 string) int {
	ss1 := strings.Split(v1, ".")
	ss2 := strings.Split(v2, ".")
	l1, l2 := 0, 0

	for l1 < len(ss1) && l2 < len(ss2) {
		i, _ := strconv.ParseInt(ss1[l1], 10, 32)
		j, _ := strconv.ParseInt(ss2[l2], 10, 32)
		if i > j {
			return 1
		} else if i < j {
			return -1
		}
		l1++
		l2++
	}

	for l1 < len(ss1) {
		i, _ := strconv.ParseInt(ss1[l1], 10, 32)
		if i > 0 {
			return 1
		}
		l1++
	}

	for l2 < len(ss2) {
		i, _ := strconv.ParseInt(ss2[l2], 10, 32)
		if i > 0 {
			return -1
		}
		l2++
	}
	return 0
}


func reverse(head *ListNode) *ListNode {
	var pre *ListNode = nil
	for head != nil {
		next := head.Next
		head.Next = pre
		pre = head
		head = next
	}
	return pre
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	l := 0
	cmap := make(map[int]*ListNode)
	cur := head
	for cur != nil {
		cmap[l] = cur
		l++
		cur = cur.Next
	}
	if n < 1 || n > l+1 {
		return head
	}

	if n == l+1 {
		dummyHead := &ListNode{Next: head}
		dummyHead.Next = dummyHead.Next.Next
		return dummyHead.Next
	}

	if ln, ok := cmap[l-n]; ok {
		ln.Next = ln.Next.Next
	}
	return head
}
