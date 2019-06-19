package medium

import (
	"strconv"
	"strings"
)

func compareVersion(v1, v2 string) int {
	ss1 := strings.Split(v1, ".")
	ss2 := strings.Split(v2, ".")
	l1, l2 := 0, 0

	for l1 < len(ss1) && l2 < len(ss2) {
		i, _ := strconv.ParseInt(ss1[l1], 10, 32)
		j, _ := strconv.ParseInt(ss2[l2], 10, 32)
		if i > j {
			return 1
		} else if i < j {
			return -1
		}
		l1++
		l2++
	}

	for l1 < len(ss1) {
		i, _ := strconv.ParseInt(ss1[l1], 10, 32)
		if i > 0 {
			return 1
		}
		l1++
	}

	for l2 < len(ss2) {
		i, _ := strconv.ParseInt(ss2[l2], 10, 32)
		if i > 0 {
			return -1
		}
		l2++
	}
	return 0
}
