package simple.depthFirstSearch;

import lib.TreeNode;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/5/20
 */
public class LeetCode_110 {

    public Boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = 0;
        int r = 0;
        if (root.left != null) {
            l = recusion(root.left);
        }
        if (root.right != null) {
            r = recusion(root.right);
        }
        if (l - r > 1 || r - l > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int recusion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recusion(root.left);
        int right = recusion(root.right);
        if (left == 0 && right == 0) {
            return 1;
        }
        return Math.max(left, right) + 1;
    }
}
