package simple.Backtracing.recursion;


/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/15
 */
public class LeetCode_111 {

    public int minDepth(TreeNode root) {
        //递归结束
        if (root == null) {
            return 0;
        }
        //0
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        //1.两个子节点都没有值，加1（加上父节点） 2.两个子节点其中一个有值,选有值的并且，加1（加上父节点）
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        //3.两个子节点都有值
        return Math.min(l, r) + 1;
    }

}
