package simple

func containsNearByDuplicate(nums []int, k int) bool {
	cMap := make(map[int]int, len(nums))
	for i, n := range nums {
		if j, ok := cMap[n]; ok {
			if i-j <= k {
				return true
			}
		}
		cMap[n] = i
	}
	return false
}
