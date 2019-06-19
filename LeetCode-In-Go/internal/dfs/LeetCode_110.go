package dfs

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}

	var (
		l int
		r int
	)
	if root.Left != nil {
		l = dfs(root.Left)
	}
	if root.Right != nil {
		r = dfs(root.Right)
	}
	if l-r > 1 || r-l > 1 {
		return false
	} else {
		return isBalanced(root.Left) && isBalanced(root.Right)
	}
}

func dfs(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l := dfs(root.Left)
	r := dfs(root.Right)
	if l == 0 && r == 0 {
		return 1
	}
	return max(l, r) + 1
}

func max(r, l int) int {
	if r > l {
		return r
	}
	return l
}
