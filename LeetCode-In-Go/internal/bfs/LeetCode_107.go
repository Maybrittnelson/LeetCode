package bfs

func levelOrderBottom(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}

	arr := append([]TreeNode{}, *root)
	for len(arr) > 0 {
		res1 := []int{}
		for _, n := range arr {
			arr = arr[1:]
			if n.Left != nil {
				arr = append(arr, *n.Left)
			}
			if n.Right != nil {
				arr = append(arr, *n.Right)
			}
			res1 = append(res1, n.Val)
		}
		res = append(res, res1)
	}

	reverse(res, 0, len(res)-1)
	return res
}

func reverse(res [][]int, i, j int) {
	for i < j {
		res[i], res[j] = res[j], res[i]
		i++
		j--
	}
}
