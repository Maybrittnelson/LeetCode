package medium

type TreeNode struct {
	Val   int
	Right *TreeNode
	Left  *TreeNode
}

func lowestCommonAncestor(root, q, p *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if root == q || root == p {
		return root
	}
	l := lowestCommonAncestor(root.Left, q, p)
	r := lowestCommonAncestor(root.Right, q, p)
	if l != nil && r != nil {
		return root
	}
	if l != nil {
		return l
	}
	return r
}
