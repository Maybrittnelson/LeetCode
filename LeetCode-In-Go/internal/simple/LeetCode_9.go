package simple

func isPalindromeNum(x int) bool {
	if x < 0 {
		return false
	}

	return reverse(x) - x == 0
}

func reverse(x int) int {
	res := 0
	for x > 0 {
		y := x%10
		res = res*10 + y
		x = x/10
	}
	return res
}