package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/15
 */
public class LeetCode_103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        int size;
        int n = 0;
        boolean flag = false;
        while (root != null && (size = queue.size()) > 0) {
            LinkedList<Integer> list = new LinkedList<>();
            n++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = ((LinkedList<TreeNode>) queue).poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (!flag) {
                    list.add(cur.val);
                } else {
                    list.addFirst(cur.val);
                }
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);

        zigzagLevelOrder(root);
    }
}
