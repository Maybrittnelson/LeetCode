package medium.stack;

import lib.TreeNode;

import java.util.Stack;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/8/2
 */
public class LeetCode_173 {

    class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode tmp = stack.pop();
            pushAll(tmp.right);
            return tmp.val;
        }

        private void pushAll(TreeNode node) {
            for (; node != null; stack.push(node), node = node.left) ;
        }
    }

}
