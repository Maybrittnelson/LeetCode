package simple

/*func twoSum(nums []int, target int) []int {
	var arr []int
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			if target-arr[i] == arr[j] {
				arr = []int{i, j}
			}
		}
	}
	return arr
}
*/

func twoSum(nums []int, target int) []int {
	cMap := make(map[int]int, len(nums))
	for i, n := range nums {
		if j, ok := cMap[target-n]; ok {
			return []int{i, j}
		}
	}
	return nil
}
