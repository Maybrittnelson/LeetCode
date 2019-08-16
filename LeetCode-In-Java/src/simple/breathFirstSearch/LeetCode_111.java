package simple.breathFirstSearch;

import lib.TreeNode;

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

}
