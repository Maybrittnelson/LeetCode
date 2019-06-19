package simple

type MyQueue struct {
	arr []int
}

func Construct() MyQueue {
	return MyQueue{[]int{}}
}

func (this *MyQueue) Push(x int) {
	this.arr = append(this.arr, x)
}

func (this *MyQueue) Pop() int {
	if this.Empty() {
		return -1
	}
	top := this.arr[0]
	this.arr = this.arr[1:]
	return top
}

func (this *MyQueue) Peek() int {
	if this.Empty() {
		return -1;
	}
	return this.arr[0]
}

func (this *MyQueue) Empty() bool {
	return len(this.arr) < 1
}
