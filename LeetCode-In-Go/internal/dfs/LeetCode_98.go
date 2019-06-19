package dfs

import "math"

func isValidBST(root *TreeNode) bool {
	return dfs1(root, math.MaxInt64, math.MinInt64)
}

func dfs1(root *TreeNode, max, min int) bool {
	if root == nil {
		return true
	}
	if root.Val >= max || root.Val <= min {
		return false
	}
	return dfs1(root.Left, root.Val, min) && dfs1(root.Right, max,  root.Val)
}
