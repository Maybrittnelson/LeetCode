package medium.stack;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/27
 */
public class LeetCode_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                //traversal left node
                while (stack.peek() != null) {
                    stack.push(stack.peek().left);
                }

                stack.pop(); //remove null

                if (!stack.isEmpty()) {
                    root = stack.pop();
                    //add root
                    res.add(root.val);
                    stack.push(root.right);
                }
            }
        }
        return res;
    }

/*    List<Integer> res = new LinkedList<>();
    //recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }

    public void recursion(TreeNode root) {
        if (root != null) {
            recursion(root.left);
            res.add(root.val);
            recursion(root.right);
        }
    }*/
}
