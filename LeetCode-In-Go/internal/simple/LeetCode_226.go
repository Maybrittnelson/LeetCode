package simple

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTreeNode(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	l := invertTreeNode(root.Left)
	r := invertTreeNode(root.Right)
	if l != nil || r != nil {
		root.Left, root.Right = root.Right, root.Left
	}
	return root
}
