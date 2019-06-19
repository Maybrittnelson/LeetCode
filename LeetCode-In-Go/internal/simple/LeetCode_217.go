package simple

func containsDuplicate(nums []int) bool {
	cMap := make(map[int]int, len(nums))
	for i, n := range nums {
		if _, ok := cMap[n]; ok {
			return true
		}
		cMap[n] = i
	}
	return false
}
