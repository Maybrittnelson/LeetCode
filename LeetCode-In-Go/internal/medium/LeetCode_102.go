package medium

func levelOrder(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}

	stack := []*TreeNode{}
	stack = append(stack, root)

	for len(stack) > 0 {
		res1 := []int{}
		for _, node := range stack {
			res1 = append(res1, node.Val)
			stack = stack[1:]
			if node.Left != nil {
				stack = append(stack, node.Left)
			}
			if node.Right != nil {
				stack = append(stack, node.Right)
			}
		}
		res = append(res, res1)
	}
	return res
}
