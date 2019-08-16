package medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tmpList, int start) {
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtrack(nums, result, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_78 leetCode_78 = new LeetCode_78();
        System.out.println(leetCode_78.subsets(new int[]{1, 2, 3}));
    }

}
