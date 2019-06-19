package main

import "fmt"

//
func rotate(nums []int, k int) {
	len := len(nums)
	if k >= len {
		k %= len
	}
	if k == 0 {
		return
	}
	reverse(nums, 0, len-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, len-1)
}

func reverse(nums []int, j int, i int) {
	for i > j {
		nums[i], nums[j] = nums[j], nums[i]
		i--
		j++
	}
}

func main() {
	nums := []int{1,2,3,4,5,6,7}
	rotate(nums, 3)
	fmt.Printf("%v", nums)
}
