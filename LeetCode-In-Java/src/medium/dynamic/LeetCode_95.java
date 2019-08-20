package medium.dynamic;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_95 {

    public List<TreeNode> generateTrees(int n) {

        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LeetCode_95 leetCode_95 = new LeetCode_95();
        List<TreeNode> treeNodes = leetCode_95.generateTrees(3);
        System.out.println(treeNodes);
    }

}
