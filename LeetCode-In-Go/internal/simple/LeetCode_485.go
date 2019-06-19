package simple

func findMaxConsecutiveOnes(nums []int) int {
	max, tmpMax := 0, 0
	for _, n := range nums {
		if n == 0 {
			tmpMax = 0
		} else {
			tmpMax++
			if tmpMax > max {
				max = tmpMax
			}
		}
	}
	return max
}
