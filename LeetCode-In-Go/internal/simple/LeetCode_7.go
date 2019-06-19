package simple

func reverseNum(i int) int {
	sign := 1
	if i < 0 {
		sign = -1
		i = -i
	}

	res := 0
	for i > 0 {
		x := i % 10
		res = res*10 + x
		i = i / 10
	}

	res = res * sign
	if res > 1<<31-1 || res < -1<<31 {
		return 0
	}
	return res
}


