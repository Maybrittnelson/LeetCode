package BreadthFirstSearch;

import java.util.*;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/15
 */
public class LeetCode_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        int size;
        while (root != null && (size = queue.size()) > 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                list.add(cur.val);
            }
            lists.add(list);
        }

        Collections.reverse(lists);
        return lists;
    }
}
