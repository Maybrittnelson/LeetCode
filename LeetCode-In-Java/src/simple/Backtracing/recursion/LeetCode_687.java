package simple.Backtracing.recursion;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/11
 */
public class LeetCode_687 {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int max = 0;

    /*
     *   5
     *  1 1
     * */
    public int longestUnivaluePath(TreeNode root) {
        recursion(root);
        return max;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = recursion(root.left);
        int r = recursion(root.right);
        int sideR = 0, sideL = 0;
        if (root.left != null && root.left.val == root.val) {
            sideL = l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            sideR = r + 1;
        }
        max = Math.max(max, sideL + sideR);
        return Math.max(sideL, sideR);
    }

}
