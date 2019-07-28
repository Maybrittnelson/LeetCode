package medium.stack;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/28
 */
public class LeetCode_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                while (root != null) {
                    if (root.left != null) {
                        res.add(root.left.val);
                    }
                    if (root.right != null) {
                        stack.add(root.right);
                    }
                    root = root.left;
                }
            }
        }
        return res;
    }

/*    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }

    public void recursion(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            recursion(root.left);
            recursion(root.right);
        }
    }*/
}
