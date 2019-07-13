package medium.string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>((int) Math.pow(nums.length, 2));
        allSubsets.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = allSubsets.size();
            for (int j = 0; j < size; j++) {
                List<Integer> current = allSubsets.get(j);
                List<Integer> oneMore = new ArrayList<>(current);
                oneMore.add(nums[i]);
                allSubsets.add(oneMore);
            }
        }

        return allSubsets;
    }
/*    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }


    public static void backtrack(int[] nums, int i, List<Integer> sub, List<List<Integer>> res) {
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            sub.add(nums[j]);
            res.add(new ArrayList<Integer>(sub));
            backtrack(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }

    }*/

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

}
