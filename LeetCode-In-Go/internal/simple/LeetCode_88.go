package simple

func merge(nums1 []int, m int, nums2 []int, n int) {
	res := make([]int, m+n)
	l1, l2 := 0, 0
	for l1 < m && l2 < n {
		if nums1[l1] < nums2[l2] {
			res = append(res, nums1[l1])
			l1++
		} else {
			res = append(res, nums2[l2])
			l2++
		}
	}

	if l1 < m {
		res = append(res, nums1[l1:m]...)
	}
	if l2 < n {
		res = append(res, nums2[l2:n]...)
	}

	nums1 = append(nums1[:0], res...)
}
