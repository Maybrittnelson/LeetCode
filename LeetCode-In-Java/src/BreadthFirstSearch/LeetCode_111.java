package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/14
 */
public class LeetCode_111 {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int n = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = null, nlast = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                break;
            }
            if (cur.left != null) {
                last = cur.left;
                queue.add(last);
            }
            if (cur.right != null) {
                last = cur.right;
                queue.add(last);
            }
            if (cur == nlast) {
                nlast = last;
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        minDepth(root);
    }

}
