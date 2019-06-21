package simple.BreathFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import lib.TreeNode;

/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/15
 */
public class LeetCode_993 {

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        int f = 0;
        HashMap<Integer, Integer> fMap = new HashMap<>();
        HashMap<Integer, Integer> pMap = new HashMap<>();
        boolean f1 = false, f2 = false;
        while (root != null && (size = queue.size()) > 0) {
            f++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) {
                    fMap.put(x, f);
                    f1 = true;
                }
                if (cur.val == y) {
                    fMap.put(y, f);
                    f2 = true;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                    pMap.put(cur.left.val, cur.val);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    pMap.put(cur.right.val, cur.val);
                }
            }
            if (f1 && f2) {
                break;
            }
        }
        if (fMap.get(x) == fMap.get(y) && pMap.get(x) != pMap.get(y)) {
            return true;
        }
        return false;
    }
}
