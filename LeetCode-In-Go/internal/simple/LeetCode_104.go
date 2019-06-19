package simple

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l := maxDepth(root.Left)
	r := maxDepth(root.Right)
	return max(l, r) + 1
}

func max(i, j int) int {
	if i < j {
		return j
	}
	return i
}
