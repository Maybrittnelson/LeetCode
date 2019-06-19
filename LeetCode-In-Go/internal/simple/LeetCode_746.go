package simple

func minCost(cost []int) int {
	dp := make([]int, len(cost)+1)
	dp[0] = 0
	dp[1] = 0
	var i int = 2
	for i = 2; i < len(dp); i++ {
		min1 := dp[i-1] + cost[i-1]
		min2 := dp[i-2] + cost[i-2]
		dp[i] = min(min1, min2)
	}
	return dp[i-1]
}

func min(i, j int) int {
	if i < j {
		return i
	}
	return j
}
