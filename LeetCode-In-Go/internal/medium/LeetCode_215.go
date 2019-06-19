package medium

import "container/heap"

func findKthLargest(nums []int, k int) int {
	heapHigh := highHeap(nums)
	h := &heapHigh
	heap.Init(h)

	if k == 1 {
		return (*h)[0]
	}

	for i := 0; i < k; i++ {
		heap.Remove(h, 0)
	}
	return (*h)[0]
}

type highHeap []int

/**
	Len/Less/Swap
 */
func (this highHeap) Len() int {
	return len(this)
}

func (this highHeap) Less(i, j int) bool {
	return this[i] > this[j]
}

func (this highHeap) Swap(i, j int) {
	this[i], this[j] = this[j], this[i]
}

func (this *highHeap) Pop() interface{} {
	tmp := (*this)[len(*this)-1]
	*this = (*this)[:len(*this)-1]
	return tmp
}

func (this *highHeap) Push(x interface{}) {
	*this = append(*this, x.(int))
}
